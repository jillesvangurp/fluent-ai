package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Common : Translatable {
        AppName,
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

    enum class ConfirmDialog: Translatable {
        DefaultQuestion,
        DefaultDescription,
        Yes,
        No,
        ;

        override val prefix = "confirmation-dialog"
    }

    enum class Cookies: Translatable {
        Disclaimer,
        Header,
        Welcome,

        ;

        override val prefix = "cookies"
    }

    enum class LanguageSelector : Translatable {
        SelectLanguage,
        ;

        override val prefix = "language-select"
    }

    enum class FileLoader : Translatable {
        FilesHeader,
        ClearConfirmation,
        DeleteFileConfirmation,
        DragAndDrop,
        LoadOwnFtls,
        LoadOwnFtlsConfirmation,
        AddNew,
        CreateNewFile,
        NoFilesYetCta,
        ;

        override val prefix = "file-loader"
    }

    enum class FluentEditor : Translatable {
        AiTranslate,
        DeleteThisId,
        DeleteThisIdConfirmation,
        ConfigureKey,
        TranslateUsingOpenAi,
        NoTranslationIdSelected,
        NewTranslationIdHeader,
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
