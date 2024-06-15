package localization

import com.tryformation.localization.Translatable

object TL {
    enum class Busy : Translatable {
        InitialTitle,
        InitialMessage,
        Success,
        Failure,
        ;

        override val prefix = "busy"
    }

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
        Show,
        Hide
        ;

        override val prefix = "common"
    }

    enum class ConfirmDialog : Translatable {
        DefaultQuestion,
        DefaultDescription,
        Yes,
        No,
        ;

        override val prefix = "confirmation-dialog"
    }

    enum class Cookies : Translatable {
        Disclaimer,
        Header,
        Welcome,

        ;

        override val prefix = "cookies"
    }

    enum class Docs : Translatable {
        About
        ;

        // sort to bottom
        override val prefix = "zzdocs"
    }


    enum class FileLoader : Translatable {
        FilesHeader,
        ClearConfirmation,
        DeleteFileConfirmation,
        DragAndDrop,
        LoadOwnFtls,
        LoadOwnFtlsConfirmation,
        AddNew,
        DownloadAll,
        CreateNewFile,
        NoFilesYetCta,
        TranslateMissing,
        TranslateMissingConfirmation,
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
        NoFilesCta,
        AddTranslationId,
        NumberOfKeys,
        ;

        override val prefix = "translation-editor"

    }

    enum class LanguageSelector : Translatable {
        SelectLanguage,
        ;

        override val prefix = "language-select"
    }

    enum class Settings : Translatable {
        EditOpenAiKey,
        OpenAiKey,
        TranslationLanguage,
        ;

        override val prefix = "settings"
    }

    enum class TranslationLogic : Translatable {
        Completed,
        Progress,
        ;

        override val prefix = "translation-service"
    }
}
