package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        FilterPlaceholder,
        Save,
        Clear,
        Cancel,
        Confirm,
        Delete,
        Download,
        Downloaded,
        Add,
        ;

        override val prefix = "common"
    }

    enum class LanguageSelector : Translatable {
        SelectLanguage,
        ;

        override val prefix = "language-select"
    }

    enum class FileLoader : Translatable {
        FilesHeader,
        DragAndDrop,
        LoadOwnFtls,
        AddNew,
        CreateNewFile,
        NoFilesYetCta,
        ;

        override val prefix = "file-loader"
    }

    enum class FluentEditor : Translatable {
        AiTranslate,
        NoTranslationIdSelected,
        NewTranslationId,
        NewTranslation,
        ;

        override val prefix = "translation-editor"

    }

    enum class Settings : Translatable {
        OpenAiKey,
        TranslationLanguage,
        ;

        override val prefix = "settings"
    }
}
