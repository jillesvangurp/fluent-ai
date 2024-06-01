package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        FilterPlaceholder,
        Save,
        Clear,
        Cancel,
        ;

        override val prefix = "common"
    }

    enum class LanguageSelector: Translatable {
        SelectLanguage,
        ;
        override val prefix = "language-select"
    }

    enum class FileLoader: Translatable {
        DragAndDrop,
        LoadOwnFtls,
        ;
        override val prefix = "file-loader"
    }

    enum class FluentEditor {

    }

}
