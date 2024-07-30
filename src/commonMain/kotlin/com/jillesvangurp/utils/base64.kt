package com.jillesvangurp.utils

import kotlin.math.min

object Base64 {
    /**
     * Returns a [Encoder] that encodes using the
     * [Basic](#basic) type base64 encoding scheme.
     *
     * @return  A Base64 encoder.
     */
    val encoder by lazy {  Encoder(null, -1, true) }

    /**
     * Returns a [Decoder] that decodes using the
     * [Basic](#basic) type base64 encoding scheme.
     *
     * @return  A Base64 decoder.
     */
    val decoder by lazy { Decoder() }

    internal val toBase64 = charArrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    )

    internal val toBase64URL = charArrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'
    )

    class Encoder internal constructor(private val newline: ByteArray?, private val lineMax: Int, private val doPadding: Boolean) {
        private fun outLength(srcLen: Int): Int {
            var len = if (doPadding) {
                4 * ((srcLen + 2) / 3)
            } else {
                val n = srcLen % 3
                4 * (srcLen / 3) + if (n == 0) 0 else n + 1
            }
            if (lineMax > 0) // line separators
                len += (len - 1) / lineMax * newline!!.size
            return len
        }

        fun encode(src: ByteArray): ByteArray {
            val len = outLength(src.size) // dst array size
            val dst = ByteArray(len)
            val ret = encode0(src, 0, src.size, dst)
            return if (ret != dst.size) dst.copyOf(ret) else dst
        }

        private fun encodeBlock(src: ByteArray, sp: Int, sl: Int, dst: ByteArray, dp: Int) {
            var sp0 = sp
            var dp0 = dp
            while (sp0 < sl) {
                val bits: Int = src[sp0++].toInt() and 0xff shl 16 or (
                    src[sp0++].toInt() and 0xff shl 8) or
                    (src[sp0++].toInt() and 0xff)
                dst[dp0++] = toBase64[bits ushr 18 and 0x3f].code.toByte()
                dst[dp0++] = toBase64[bits ushr 12 and 0x3f].code.toByte()
                dst[dp0++] = toBase64[bits ushr 6 and 0x3f].code.toByte()
                dst[dp0++] = toBase64[bits and 0x3f].code.toByte()
            }
        }

        @Suppress("UNUSED_CHANGED_VALUE")
        private fun encode0(src: ByteArray, off: Int, end: Int, dst: ByteArray): Int {
            val base64 = toBase64
            var sp = off
            var slen = (end - off) / 3 * 3
            val sl = off + slen
            if (lineMax > 0 && slen > lineMax / 4 * 3) slen = lineMax / 4 * 3
            var dp = 0
            while (sp < sl) {
                val sl0: Int = min(sp + slen, sl)
                encodeBlock(src, sp, sl0, dst, dp)
                val dlen = (sl0 - sp) / 3 * 4
                dp += dlen
                sp = sl0
                if (dlen == lineMax && sp < end) {
                    for (b in newline!!) {
                        dst[dp++] = b
                    }
                }
            }
            if (sp < end) {               // 1 or 2 leftover bytes
                val b0: Int = src[sp++].toInt() and 0xff
                dst[dp++] = base64[b0 shr 2].code.toByte()
                if (sp == end) {
                    dst[dp++] = base64[b0 shl 4 and 0x3f].code.toByte()
                    if (doPadding) {
                        dst[dp++] = '='.code.toByte()
                        dst[dp++] = '='.code.toByte()
                    }
                } else {
                    val b1: Int = src[sp++].toInt() and 0xff
                    dst[dp++] = base64[b0 shl 4 and 0x3f or (b1 shr 4)].code.toByte()
                    dst[dp++] = base64[b1 shl 2 and 0x3f].code.toByte()
                    if (doPadding) {
                        dst[dp++] = '='.code.toByte()
                    }
                }
            }
            return dp
        }
    }

    class Decoder {
        companion object {
            internal val fromBase64 = IntArray(256)

            private val fromBase64URL = IntArray(256)

            init {
                fromBase64.fill(-1)
                for (i in toBase64.indices) fromBase64[toBase64[i].code] = i
                fromBase64['='.code] = -2
            }

            init {
                fromBase64URL.fill(-1)
                for (i in toBase64URL.indices) fromBase64URL[toBase64URL[i].code] = i
                fromBase64URL['='.code] = -2
            }
        }

        fun decode(src: ByteArray): ByteArray {
            var dst = ByteArray(outLength(src, 0, src.size))
            val ret = decode0(src, 0, src.size, dst)
            if (ret != dst.size) {
                dst = dst.copyOf(ret)
            }
            return dst
        }

        private fun outLength(src: ByteArray, sp: Int, sl: Int): Int {
            var paddings = 0
            val len = sl - sp
            if (len == 0) return 0
            if (len < 2) {
                throw IllegalArgumentException(
                    "Input byte[] should at least have 2 bytes for base64 bytes"
                )
            }
            if (src[sl - 1].toInt().toChar() == '=') {
                paddings++
                if (src[sl - 2].toInt().toChar() == '=') paddings++
            }
            if (paddings == 0 && len and 0x3 != 0) paddings = 4 - (len and 0x3)
            return 3 * ((len + 3) / 4) - paddings
        }

        private fun decode0(src: ByteArray, sp: Int, sl: Int, dst: ByteArray): Int {
            var spPos = sp
            val base64 = if (false) fromBase64URL else fromBase64
            var dp = 0
            var bits = 0
            var shiftto = 18 // pos of first byte of 4-byte atom
            while (spPos < sl) {
                if (shiftto == 18 && spPos + 4 < sl) {       // fast path
                    val sl0 = spPos + (sl - spPos and 3.inv())
                    while (spPos < sl0) {
                        val b1 = base64[src[spPos++].toInt() and 0xff]
                        val b2 = base64[src[spPos++].toInt() and 0xff]
                        val b3 = base64[src[spPos++].toInt() and 0xff]
                        val b4 = base64[src[spPos++].toInt() and 0xff]
                        if (b1 or b2 or b3 or b4 < 0) {    // non base64 byte
                            spPos -= 4
                            break
                        }
                        val bits0 = b1 shl 18 or (b2 shl 12) or (b3 shl 6) or b4
                        dst[dp++] = (bits0 shr 16).toByte()
                        dst[dp++] = (bits0 shr 8).toByte()
                        dst[dp++] = bits0.toByte()
                    }
                    if (spPos >= sl) break
                }
                var b: Int = src[spPos++].toInt() and 0xff
                if (base64[b].also { b = it } < 0) {
                    if (b == -2) {         // padding byte '='
                        // =     shiftto==18 unnecessary padding
                        // x=    shiftto==12 a dangling single x
                        // x     to be handled together with non-padding case
                        // xx=   shiftto==6&&sp==sl missing last =
                        // xx=y  shiftto==6 last is not =
                        require(
                            !(shiftto == 6 && (spPos == sl || src[spPos++].toInt().toChar() != '=') ||
                                shiftto == 18)
                        ) { "Input byte array has wrong 4-byte ending unit" }
                        break
                    }
                    throw IllegalArgumentException("Illegal base64 character " + src[spPos - 1].toInt().toString(16))
                }
                bits = bits or (b shl shiftto)
                shiftto -= 6
                if (shiftto < 0) {
                    dst[dp++] = (bits shr 16).toByte()
                    dst[dp++] = (bits shr 8).toByte()
                    dst[dp++] = bits.toByte()
                    shiftto = 18
                    bits = 0
                }
            }
            // reached end of byte array or hit padding '=' characters.
            when (shiftto) {
                6 -> {
                    dst[dp++] = (bits shr 16).toByte()
                }
                0 -> {
                    dst[dp++] = (bits shr 16).toByte()
                    dst[dp++] = (bits shr 8).toByte()
                }
                else -> require(shiftto != 12) {
                    // dangling single "x", incorrectly encoded.
                    "Last unit does not have enough valid bits"
                }
            }
            // anything left is invalid, if is not MIME.
            // if MIME, ignore all non-base64 character
            while (spPos < sl) {
                throw IllegalArgumentException(
                    "Input byte array has incorrect ending byte at $spPos"
                )
            }
            return dp
        }
    }

}

fun String.encodeBase64(): String {
    val bytes = Base64.encoder.encode(this.encodeToByteArray())
    return bytes.decodeToString()
}

fun String.decodeBase64(): String {
    return Base64.decoder.decode(this.encodeToByteArray()).decodeToString()
}
