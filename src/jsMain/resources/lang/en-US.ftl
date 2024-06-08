-brand = Fluent AI

common-app-name = { -brand }
common-add = Add
common-cancel = Cancel
common-clear = Clear
common-confirm = OK
common-filter-placeholder = Filter the list
common-save = Save
common-delete = Delete
common-download = Download

cookies-disclaimer = This website uses browser local storage to store json content
        that you create in the app. This information is never shared elsewhere.
        In order to use this app, you have to agree to the usage of local storage.
cookies-header = Cookies & permissions
cookies-welcome = Welcome to {-brand}

confirmation-dialog-yes = Yes
confirmation-dialog-no = No

confirmation-dialog-default-question = Are you sure?
confirmation-dialog-default-description = If you click yes, the action will be executed.

file-loader-clear-confirmation = This will remove any current files and edits. Make sure you have downloaded anything you care about.
file-loader-delete-file-confirmation = This will remove { $file }.
file-loader-files-header = Your Fluent Files
file-loader-drag-and-drop = Drag ftl files here to load them
file-loader-load-own-ftls = Load ftl files for { -brand }
file-loader-load-own-ftls-confirmation = his will remove any current files and edits and replace them with the ftl files for { -brand }. Make sure you have downloaded anything you care about.
file-loader-add-new = Create or add ftl files
file-loader-create-new-file = Create new ftl file
file-loader-no-files-yet-cta = You don't have any ftl files yet. Create a new one or drag existing ones to the app.

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

    Fluent AI helps you localize your applications. It can load your [Project Fluent](https://projectfluent.org/) localization files and allows you to edit translations side by side.

    More importantly, it has built-in support for using OpenAI to translate your localizations.

    ## How does it work

    - Configure your OpenAI API key in the settings. Without this the AI translations won't work.
    - Load your `.ftl` files in the files section
    - And then goto the editor to edit your translation strings.

    ## Limitations

    - This currently does not validate the fluent syntax
    - It runs in a browser so there is no direct file system access. However you can drag and drop files to the UI and download modified files from the UI.
    - It is a bit opinionated about re-ordering all the translations, carefully examine diffs before committing changes to your localization files.

    ## Bugs and issues

    This project is free and open source and distributed under the MIT license. If you need help ping me
    or use the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).