package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        Add
        ;

        override val prefix = "common"
    }

    enum class LanguageSelector: Translatable {
        SelectLanguage,
        ;
        override val prefix = "language-select"
    }

}
