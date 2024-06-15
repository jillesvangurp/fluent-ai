-about = 'bout
-brand = Fluent AI
-manage-files = Manage Fluent Files
-settings = Settings
-translation-editor = Translation Editor

busy-failure = Arrr! Blimey!
busy-success = Done translatin' t' {$language}
busy-initial-message = Usin' OpenAI to translate t' {$language}

common-save = Save thar
common-delete = Scuttle
common-download = Plunder
common-hide = Stow {$content}
common-cancel = Belay
common-clear = Swab
common-confirm = Aye
common-filter-placeholder = Filter th' list
common-add = Add ye scallywag
common-show = Show {$content}, matey

confirmation-dialog-yes = Aye
confirmation-dialog-no = Nay
confirmation-dialog-default-description = If ye click aye, the action will be carried out.
confirmation-dialog-default-question = Be ye certain?

cookies-welcome = Ahoy to {-brand}
cookies-disclaimer = This here website be usin' yer browser's local storage to stash the json booty ye be creatin' in the app. This here info be stayin' with us; we ain't sharin' it with no one else. To be usin' this app, ye gotta agree to be usin' local storage. Arrr!
cookies-header = Cookies & permissions = Cookies & articles o' accordance

file-loader-drag-and-drop = Drag ftl files here to be loaded
file-loader-load-own-ftls = Load ftl files fer { -brand }
file-loader-add-new = Create or be addin' ftl files
file-loader-clear-confirmation = This be removin' any current files an' edits. Make sure ye've downloaded anythin' ye care about.
file-loader-create-new-file = Create new jolly roger file
file-loader-delete-file-confirmation = This be removin' { $file }.
file-loader-files-header = Ye Fluent Files
file-loader-load-own-ftls-confirmation = This will be removin' any current files and edits and replacin' 'em with the ftl files fer { -brand }. Be sure ye've downloaded anythin' ye care about, matey.
file-loader-no-files-yet-cta = Ye don't have any ftl files yet. Create a new one or drag existin' ones to the app.
file-loader-translate-missing-confirmation = Add missin' {$number_translations} missin' translations wit' OpenAI. Note. a large amount o' translations may take some time 'n' will o' course cost ye some tokens.
file-loader-translate-missing = Be addin' missin' with OpenAI

language-select-select-language = Pick a tongue

settings-open-ai-key = Set yer OpenAI API Key (needed fer translatin')
settings-translation-language = Set ye source lingo for yer AI translations, matey. Be warned, the lingo be matched against yer ftl file name with some normalizin'. Defaults to en-US.
settings-edit-open-ai-key = Set yer OpenAI API Key

supported-models-gpt-35-turbo = Older model but still fine fer translations. Lower treasure cost.
supported-models-gpt-4-o = Most capable model, large context window. More costly than older models, arrr.

translation-editor-translate-using-open-ai = Translate usin' OpenAI
translation-editor-ai-translate = Translate
translation-editor-configure-key = Set sail an OpenAI API key in the settin's
translation-editor-delete-this-id = Delete this 'ere translatin' id
translation-editor-delete-this-id-confirmation = This will be deletin' the translation id from all the loaded files. Set the definition to nothin' if ye just be wantin' to delete a specific translation.
translation-editor-new-translation = Arrr translation
translation-editor-new-translation-id = Ahoy matey! Ye be lookin' for some English Pirate translations, eh? Here we be:
translation-editor-new-translation-id-header = Arr, be creatin' a new translation definition
translation-editor-no-files-cta = Ye need at least one translation file t' edit. Go to [{ -manage-files }](/#page=Files) and create or add some translation files.
translation-editor-no-translation-id-selected = Select a language id on the port side to be editing the translation.
translation-editor-number-of-keys = Total {$amount} Doubloons
translation-editor-add-translation-id = Ahoy matey! Be craftin' a new translation id

translation-service-progress = Translated {$completed} ids out o' {$total} usin' {$model} usin' {$apicalls} API calls. Elapsed time {$duration}.
translation-service-completed = Finished translatin' {$total} ids usin' {$model} in {$duration} usin' {$apicalls} API calls

zzdocs-about = # Bout Fluent AI

    {-brand} helps yeh **localize yar applications using AI**. It uses OpenAI t' do in seconds
    what would otherwise take a trained translator weeks. This **saves yeh time and money**.

    {-brand} can load an' edit yar [Project Fluent](https://projectfluent.org/) localization files
    an' it offers a convenient editor for reviewin' an' editin' translations fer yar translations side by side.

    ## How do I use {-brand}?

    - Configure yar OpenAI API key in the [{-settings}](/#page=Settings). Without a key th' AI translations won't work.
    - Load yar `.ftl` files in th' [{-manage-files}](/#page=Files) section by draggin' an' droppin' 'em t' th' UI.
    - Or load th' ftl files fer Fluent AI if yeh just want t' play around. Fluent AI o' course be localized and playin' around wit' its ftl files be a great way t' get started.
    - Fer each file it will show yeh th' number o' missin' translations an' offer an AI assisted translation fer these.
    - Yeh can also manually edit 'em wit' th' [{-translation-editor}](/#page=Editor) t' edit yar translation strings or translate individual strings wit' OpenAI.

    ## What be project Fluent an' why should yeh use it?

    Invented by Mozilla t' support localizin' products like Firefox, Thunderbird, etc. t' hundreds o' languages,
    Project Fluent be designed wit' flexibility an' usability in mind. Their translations dependd on
    a large user community contributin' translations. Therefore they wanted t' make this as easy
    as possible t' do. Additionally, they needed th' flexibility t' deal wit' various grammatical variations
    in languages fer e.g. gender, tense, amount, etc.

    Th' result, project fluent, be a simple an' easy t' use file format an' syntax fer definin' translation files. It provides a few benefits
    o'er other solutions in this space based on e.g. properties files or libraries like gettext:

    - **Flexibility.** It supports conditinal logic an' variables that yeh can use in yar translations.
    - **Ease o' use.** It be simple an' easy t' use an' edit. Any file wit' lines containin' `key = translation` be a valid `ftl` file
    - **Portability.** There be libraries that make supportin' Fluent based localizations easy in both native, mobile, an' web applications.

    ## Limitations o' {-brand}

    - {-brand} currently does not validate th' fluent syntax.
    - It runs in a browser so there be no direct file system access. However yeh can drag an' drop files t' th' UI an' download modified files from th' UI. Given enough interest, I may at some point create an Electron wrapper fer {-brand}.
    - It be a bit opinionated about re-orderin' an' cleanin' up translations. Carefully examine diffs before committin' changes t' yar localization files.
    - OpenAI be good but o' course not flawless an' sometimes it just gets it wrong. Also, it may not always have enough context t' correctly translate everything. Yeh should o' course use professional translators t' review translations. However, it does nail it rather often.
    - While yeh can edit translations fer Fluent AI itself, it does not currently reload 'em in th' UI. I may add this later.
    - Currently only OpenAI be supported. If there be interest, I may add more models later.
    - Translatin' large files can take quite a bit o' time.

    ## Bugs an' issues

    This project be free an' open source an' distributed under th' MIT license.
    Th' main project be available on [Github](https://github.com/jillesvangurp/fluent-ai).
    If yeh need help ping me
    or use th' [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Related projects

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplatform library that me an' me colleagues developed fer jvm/js that allows yeh t' use ftl files in yar Kotlin applications. This browser application uses it.

    ## Spread th' word

    Writin' software like this be a lot o' work an' it can often be thankless work. If Fluent AI be useful t' yeh, let others know so they t' can benefit.

    - Tweet / toot / blog about it.
    - Hit th' star button on [Github](https://github.com/jillesvangurp/fluent-ai).
    - Give me some feedback.

    ## Credits

    Fluent AI be created by [Jilles van Gurp](https://jillesvangurp.com). Currently it be free an' open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - My website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X