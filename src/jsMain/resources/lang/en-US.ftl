-about = About
-brand = Fluent AI
-manage-files = Manage Fluent Files
-settings = Settings
-translation-editor = Translation Editor

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
file-loader-remove-identical-translations = Remove identical translations
file-loader-remove-identical-translations-disclaimer =
    This will remove all translations that are identical to your default translations. Check your settings to make sure this is what you exepct it to be. Anything not in the default translations will be removed as well.

    Use this to clean up your translations.
file-loader-translate-missing = Add missing with OpenAI
file-loader-translate-missing-confirmation = Add missing {$number_translations} missing translations with OpenAI. Note. a large amount of translations may take some time and will of course cost you some tokens.

language-select-select-language = Select UI language

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-edit-open-ai-key = Configure OpenAI API Key
settings-open-ai-key = Set your OpenAI API Key (needed for translations)
settings-translation-language = Configure source language for AI translations. Note, the language is matched against your ftl file name with some normalization. Defaults to en-US.

supported-models-gpt-4-o = Most capable model, large context window. More costly than older models.
supported-models-gpt-35-turbo = Older model but still adequate for translations. Lower token cost.

translation-editor-add-translation-id = Create new translation id
translation-editor-ai-translate = Translate
translation-editor-configure-key = Configure an OpenAI API key in the settings
translation-editor-delete-this-id = Delete this translation id
translation-editor-delete-this-id-confirmation = This will delete the translation id from all loaded files. Set the definition to empty if you just want to delete a specific translation.
translation-editor-no-translation-id-selected = Select a language id on the left to edit the translation.
translation-editor-new-translation-id-header = Create a new translation definition
translation-editor-new-translation-id = Translation ID
translation-editor-new-translation = Default translation
translation-editor-no-files-cta = You need at least one translation file to edit. Go to [{ -manage-files }](/#page=Files) and create or add some translation files.
translation-editor-number-of-keys = Total {$amount}
translation-editor-translate-using-open-ai = Translate using OpenAI

translation-service-progress = Translated {$completed} ids out of {$total} using {$model} using {$apicalls} API calls. Elapsed time {$duration}.
translation-service-completed = Finished translating {$total} ids using {$model} in {$duration} using {$apicalls} API calls

zzdocs-about = # About Fluent AI

    {-brand} helps you **localize your applications using AI**. It uses OpenAI to do in seconds
    what would otherwise take a trained translator weeks. This **saves you time and money**.

    - effortlessly support new languages, simply add a new language and let OpenAI do the work.
    - easy side by side editing of translations for different languages
    - identify missing translations easily and then fix them using AI.
    - sorts and organizes your translations by common prefix

    {-brand} supports [Project Fluent](https://projectfluent.org/) localization files.

    ## How do I use {-brand}?

    - Configure your OpenAI API key in the [{-settings}](/#page=Settings). Without a key the AI translations won't work.
    - Load your `.ftl` files in the [{-manage-files}](/#page=Files) section by dragging and dropping them to the UI.
    - Or load the ftl files for Fluent AI if you just want to play around. Fluent AI of course is localized and playing around with its ftl files is a great way to get started.
    - For each file it will show you the number of missing translations and offer an AI assisted translation for these.
    - You can also manually edit them with the [{-translation-editor}](/#page=Editor) to edit your translation strings or translate individual strings with OpenAI.

    ## What is project Fluent and why should you use it?

    Invented by Mozilla to support localizing products like Firefox, Thunderbird, etc. to hundreds of languages,
    Project Fluent is designed with flexibility and usability in mind. Their translations depend on
    a large user community contributing translations. Therefore they wanted to make this as easy
    as possible to do. Additionally, they needed the flexibility to deal with various grammatical variations
    in languages for e.g. gender, tense, amount, etc.

    The result, project fluent, is a simple and easy to use file format and syntax for defining translation files. It provides a few benefits
    over other solutions in this space based on e.g. properties files or libraries like gettext:

    - **Flexibility.** It supports conditinal logic and variables that you can use in your translations.
    - **Ease of use.** It's simple and easy to use and edit. Any file with lines containing `key = translation` is a valid `ftl` file. And you can use multi line strings, markdown, etc.
    - **Portability.** There are libraries that make supporting Fluent based localizations easy in both native, mobile, and web applications.

    ## Limitations of {-brand}

    - {-brand} currently does not validate the fluent syntax.
    - It runs in a browser so there is no direct file system access. However you can drag and drop files to the UI and download modified files from the UI. Given enough interest, I may at some point create an Electron wrapper for {-brand}.
    - It is a bit opinionated about re-ordering and cleaning up translations. Carefully examine diffs before committing changes to your localization files.
    - OpenAI is good but of course not flawless and sometimes it just gets it wrong. Also, it may not always have enough context to correctly translate everything. You should of course use professional translators to review translations. However, it does nail it rather often.
    - Sometimes OpenAI ignores its instructions and produces the wrong thing or dreams up some new variables. For best results use gp4-4o. I find it's more consistently good.
    - While you can edit translations for Fluent AI itself, it does not currently reload them in the UI. I may add this later.
    - Currently only OpenAI is supported. If there's interest, I may add more models later.
    - Translating large files can take quite a bit of time.

    ## Bugs and issues

    This project is free and open source and distributed under the MIT license.
    The main project is available on [Github](https://github.com/jillesvangurp/fluent-ai).
    If you need help ping me
    or use the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Related projects

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplatform library that me and my colleagues developed for jvm/js that allows you to use ftl files in your Kotlin applications. This browser application uses it.

    ## Spread the word

    Writing software like this is a lot of work and it can often be thankless work. If Fluent AI is useful to you, let others know so they to can benefit.

    - Tweet / toot / blog about it.
    - Hit the star button on [Github](https://github.com/jillesvangurp/fluent-ai).
    - Give me some feedback.

    ## Credits

    Fluent AI is created by [Jilles van Gurp](https://jillesvangurp.com). Currently it is free and open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - My website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X