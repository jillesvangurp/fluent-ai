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
    NL_NL("nl", "NL", arrayOf("nl", "nl-BE")),
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
