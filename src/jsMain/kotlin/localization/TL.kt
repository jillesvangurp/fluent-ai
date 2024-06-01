package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        FilterPlaceholder,
        Save,
        Clear,
        Cancel,
        Confirm,
        ;

        override val prefix = "common"
    }

    enum class LanguageSelector : Translatable {
        SelectLanguage,
        ;

        override val prefix = "language-select"
    }

    enum class FileLoader : Translatable {
        DragAndDrop,
        LoadOwnFtls
        ;

        override val prefix = "file-loader"
    }

    enum class FluentEditor : Translatable {
        AiTranslate,
        ;

        override val prefix = "translation-editor"

    }

    enum class Settings : Translatable {
        OpenAiKey
        ;

        override val prefix = "settings"
    }

}
