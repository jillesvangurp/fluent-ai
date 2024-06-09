-brand = Fluent AI

busy-failure = Error
busy-initial-title = Translating
busy-initial-message = Using OpenAI to translate to {$language}
busy-success = Done translating to {$language}

common-app-name = { -brand }
common-add = Add
common-cancel = Cancel
common-clear = Clear
common-confirm = OK
common-filter-placeholder = Filter the list
common-save = Save
common-delete = Delete
common-download = Download
common-hide = Hide {$content}
common-show = Show {$content}

confirmation-dialog-yes = Yes
confirmation-dialog-no = No
confirmation-dialog-default-question = Are you sure?
confirmation-dialog-default-description = If you click yes, the action will be executed.

cookies-disclaimer = This website uses browser local storage to store json content
        that you create in the app. This information is never shared elsewhere.
        In order to use this app, you have to agree to the usage of local storage.
cookies-header = Cookies & permissions
cookies-welcome = Welcome to {-brand}

file-loader-clear-confirmation = This will remove any current files and edits. Make sure you have downloaded anything you care about.
file-loader-delete-file-confirmation = This will remove { $file }.
file-loader-files-header = Your Fluent Files
file-loader-drag-and-drop = Drag ftl files here to load them
file-loader-load-own-ftls = Load ftl files for { -brand }
file-loader-load-own-ftls-confirmation = his will remove any current files and edits and replace them with the ftl files for { -brand }. Make sure you have downloaded anything you care about.
file-loader-add-new = Create or add ftl files
file-loader-create-new-file = Create new ftl file
file-loader-no-files-yet-cta = You don't have any ftl files yet. Create a new one or drag existing ones to the app.
file-loader-translate-missing = Add missing with OpenAI
file-loader-translate-missing-confirmation = Add missing {$number_translations} missing translations with OpenAI. Note. a large amount of translations may take some time and will of course cost you some tokens.

language-select-select-language = Select UI language

pages-editor = Edit Translations
pages-files = Manage Fluent Files
pages-settings = Settings
pages-about = About

settings-open-ai-key = Set your OpenAI API Key (needed for translations)
settings-translation-language = Configure source language for AI translations. Note, the language is matched against your ftl file name with some normalization. Defaults to en-US.

translation-editor-ai-translate = Translate using gpt-4o
translation-editor-configure-key = Configure an OpenAI API key in the settings
translation-editor-delete-this-id = Delete this translation id
translation-editor-delete-this-id-confirmation = This will delete the translation id from all loaded files. Set the definition to empty if you just want to delete a specific translation.
translation-editor-no-translation-id-selected = Select a language id on the left to edit the translation.
translation-editor-new-translation-id-header = Create a new translation definition
translation-editor-new-translation-id = Translation ID
translation-editor-new-translation = Default translation
translation-editor-translate-using-open-ai = Translate using OpenAI

zzdocs-about = # About Fluent AI

    Fluent AI helps you localize your applications. It can load and edit your [Project Fluent](https://projectfluent.org/) localization files with it and translate them to different languages using AI.

    ## How does it work

    - Configure your OpenAI API key in the settings. Without this the AI translations won't work.
    - Load your `.ftl` files in the files section by dragging and dropping them to the UI.
    - Or load the ftl files for Fluent AI if you just want to play around.
    - For each file it will show you the number of missing translations and offer to translate the missing ones.
    - You can also manually edit them with the editor to edit your translation strings or translate individual strings with OpenAI.

    ## Limitations

    - Fluent AI currently does not validate the fluent syntax
    - It runs in a browser so there is no direct file system access. However you can drag and drop files to the UI and download modified files from the UI.
    - It is a bit opinionated about re-ordering all the translations, carefully examine diffs before committing changes to your localization files.
    - OpenAI is good but not flawless and sometimes it just gets it wrong. Also, it may not have enough context to correctly translate everything.
    - Whole you can edit translations for Fluent AI itself, it does not currently reload them in the UI. I may add this later.

    ## Bugs and issues

    This project is free and open source and distributed under the MIT license.
    The main project is available on [Github](https://github.com/jillesvangurp/fluent-ai).
    If you need help ping me
    or use the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Credits

    Fluent AI was created by [Jilles van Gurp](https://jillesvangurp.com).