package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        FilterPlaceholder,
        Save,
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
        DragAndDrop
        ;
        override val prefix = "file-loader"
    }

    enum class FluentEditor {

    }

}
