-about = 'Bout
-brand = Fluent AI
-manage-files = Manage Fluent Files
-settings = Settings
-translation-editor = Translation Editor

busy-failure = Arrr! Blimey!
busy-success = Done translatin' t' {$language}

busy-initial-title = Translating
busy-initial-message = Usin' OpenAI to translate t' {$language}

common-app-name = { -brand }
common-show = Show {$content}
common-save = Save thar
common-delete = Scuttle
common-download = Plunder
common-hide = Stow {$content}
common-cancel = Belay
common-clear = Swab
common-confirm = Aye
common-filter-placeholder = Filter th' list
common-add = Add ye scallywag

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

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-open-ai-key = Set yer OpenAI API Key (needed fer translatin')
settings-translation-language = Set ye source lingo for yer AI translations, matey. Be warned, the lingo be matched against yer ftl file name with some normalizin'. Defaults to en-US.

translation-editor-add-translation-id = Create new translation id
translation-editor-no-files-cta = Ye need at least one translation file t' edit. Go to [{ -manage-files }](/#page=Files) and create or add some translation files.
translation-editor-number-of-keys = Total {$amount}
translation-editor-translate-using-open-ai = Translate usin' OpenAI
translation-editor-ai-translate = Translate usin' GPT-4
translation-editor-configure-key = Set sail an OpenAI API key in the settin's
translation-editor-delete-this-id = Delete this 'ere translatin' id
translation-editor-delete-this-id-confirmation = This will be deletin' the translation id from all the loaded files. Set the definition to nothin' if ye just be wantin' to delete a specific translation.
translation-editor-new-translation = Arrr translation
translation-editor-new-translation-id = Ahoy matey! Ye be lookin' for some English Pirate translations, eh? Here we be:
translation-editor-new-translation-id-header = Arr, be creatin' a new translation definition
translation-editor-no-translation-id-selected = Select a language id on the port side to be editing the translation.

zzdocs-about = # 'Bout Fluent AI

    {-brand} helps ye **localize yer applications usin' AI**. It uses OpenAI t' do in seconds
    wha' would otherwise take a trained translator weeks. This **saves ye time 'n booty**.

    {-brand} can load 'n edit yer [Project Fluent](https://projectfluent.org/) localization files
    'n it offers a convenient editor for reviewin' 'n editin' translations for yer translations side by side.

    ## How d' I use {-brand}?

    - Configure yer OpenAI API key in the [{-settings}](/#page=Settings). Without a key the AI translations won't work.
    - Load yer `.ftl` files in the [{-manage-files}](/#page=Files) section by draggin' 'n droppin' them t' the UI.
    - Or load the ftl files for Fluent AI if ye jus' want t' play around. Fluent AI o' course is localized 'n playin' around with its ftl files is a great way t' get started.
    - For each file it will show ye the number o' missin' translations 'n offer an AI assisted translation for these.
    - Ye can also manually edit them with the [{-translation-editor}](/#page=Editor) t' edit yer translation strings or translate individual strings with OpenAI.

    ## Wha' be project Fluent 'n why should ye use it?

    Invented by Mozilla t' support localizin' products like Firefox, Thunderbird, etc. t' hundreds o' languages,
    Project Fluent be designed wit' flexibility 'n usability in mind. Their translations depend on
    a large user community contributin' translations. Therefore they wanted t' make this as easy
    as possible t' do. Additionally, they needed the flexibility t' deal wit' various grammatical variations
    in languages fer e.g. gender, tense, amount, etc.

    The result, project fluent, be a simple 'n easy t' use file format 'n syntax fer defini' translation files. It provides a few benefits
    o'er other solutions in this space based on e.g. properties files or libraries like gettext:

    - **Flexibility.** It supports conditional logic 'n variables that ye can use in yer translations.
    - **Ease o' use.** It's simple 'n easy t' use 'n edit. Any file wit' lines containin' `key = translation` be a valid `ftl` file
    - **Portability.** There be libraries that make supportin' Fluent based localizations easy in both native, mobile, 'n web applications.

    ## Limitations o' {-brand}

    - {-brand} currently does not validate the fluent syntax.
    - It runs in a browser so there be no direct file system access. However ye can drag 'n drop files t' the UI 'n download modified files from the UI. Given enough interest, I may at some point create an Electron wrapper fer {-brand}.
    - It be a bit opinionated about re-orderin' 'n cleanin' up translations. It will remove translations identical t' the base translation, fer example. Carefully examine diffs before comin' changes t' yer localization files.
    - OpenAI be good but o' course not flawless 'n sometimes it jus' gets it wrong. Also, it may not always have enough context t' correctly translate everythin'. Ye should o' course use professional translators t' review translations. However, it does nail it rather often.
    - While ye can edit translations fer Fluent AI itself, it does not currently reload them in the UI. I may add this later.
    - The model 'n AI provider be currently hardwired. I'm well aware o' other solutions in this space 'n may support additional models; includin' potentially even locally runnin' ones later. However, OpenAI currently seems best in class 'n is cheap enough.
    - Translatin' large files can take quite a bit o' time.

    ## Bugs 'n issues

    This project be free 'n open source 'n distributed under the MIT license.
    The main project be available on [Github](https://github.com/jillesvangurp/fluent-ai).
    If ye need help ping me
    or use the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Related projects

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplatform library that me 'n me mates developed fer jvm/js that allows ye t' use ftl files in yer Kotlin applications. This browser application uses it.

    ## Spread the word

    Writin' software like this be a lot o' work 'n it can often be thankless work. If Fluent AI is useful t' ye, let others know so they too can benefit.

    - Tweet / toot / blog about it.
    - Hit the star button on [Github](https://github.com/jillesvangurp/fluent-ai).
    - Give me some feedback.

    ## Credits

    Fluent AI be created by [Jilles van Gurp](https://jillesvangurp.com). Currently it be free 'n open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Me website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X