package localization

import com.tryformation.localization.Locale
import kotlinx.serialization.Serializable

@Serializable
enum class Locales(
    override val languageCode: String,
    override val countryCode: String?,
    override val aliases: Array<String>,
) : Locale {
    EN_US("en", "US", arrayOf("en-GB", "en")),
    EN_PIRATE("en", "pirate", arrayOf("en-PR","en-GB", "en")),
    EN_POET("en", "poet", arrayOf()),
    EN_REDNECK("en", "redneck", arrayOf()),
    FR_FR("fr", "FR", arrayOf("fr", "fr-BE")),
    NL_NL("nl", "NL", arrayOf("nl", "nl-BE")),
    DE_DE("de", "DE", arrayOf("de")),
    ES_ES("es", "ES", arrayOf("es")),
    JA_JP("ja","JP", arrayOf("ja")),
    ;

    val title = "${languageCode}-${countryCode}"
    override val prefix = "locales"

    companion object {
        fun getByIdOrNull(id: String): Locales? {
            val values = Locales.entries
            return values.firstOrNull { it.id == id }
                ?: values.firstOrNull { id in it.aliases }
        }
    }
}
