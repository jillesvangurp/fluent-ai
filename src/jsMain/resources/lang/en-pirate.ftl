-brand = Fluent AI

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

pages-editor = Edit the Fluent Definitions
pages-files = Manage Fluent Files = Arrr'ange Fluent Files
pages-settings = Settin's
pages-about = 'Bout

settings-open-ai-key = Set yer OpenAI API Key (needed fer translatin')
settings-translation-language = Set ye source lingo for yer AI translations, matey. Be warned, the lingo be matched against yer ftl file name with some normalizin'. Defaults to en-US.

translation-editor-translate-using-open-ai = Translate usin' OpenAI
translation-editor-ai-translate = Translate usin' GPT-4
translation-editor-configure-key = Set sail an OpenAI API key in the settin's
translation-editor-delete-this-id = Delete this 'ere translatin' id
translation-editor-delete-this-id-confirmation = This will be deletin' the translation id from all the loaded files. Set the definition to nothin' if ye just be wantin' to delete a specific translation.
translation-editor-new-translation = Arrr translation
translation-editor-new-translation-id = Ahoy matey! Ye be lookin' for some English Pirate translations, eh? Here we be:
translation-editor-new-translation-id-header = Arr, be creatin' a new translation definition
translation-editor-no-translation-id-selected = Select a language id on the port side to be editing the translation.

zzdocs-about = # About Fluent AI

    Fluent AI be helpin' ye localize yer applications. It be able t' load and edit yer [Project Fluent](https://projectfluent.org/) localization files with it 'n translate 'em to different languages usin' AI.

    ## How does it work

    - Configure ye OpenAI API key in th' settin's. Without this the AI translations won’t work.
    - Load yer `.ftl` files in th' files section by draggin' 'n droppin' 'em to th' UI.
    - Or load the ftl files fer Fluent AI if ye jus' want t' play around.
    - Fer each file it be showin' ye th' number o' missin' translations 'n offer t' translate th' missin' ones.
    - Ye can also manually edit 'em with th' editor t' edit yer translation strings or translate individual strings with OpenAI.

    ## Limitations

    - Fluent AI currently does not validate th' fluent syntax
    - It runs in a browser so thar be no direct file system access. Howev'r ye can drag 'n drop files to th' UI 'n download modified files from th' UI.
    - It be a bit opinionated about re-orderin' all th' translations, carefully examine diffs before committin' changes t' yer localization files.
    - OpenAI be good but not flawless 'n sometimes it jus' gets it wrong. Also, it may not have enough context t' correctly translate everythin'.
    - While ye can edit translations fer Fluent AI itself, it does not currently reload 'em in th' UI. I may be addin' this later.

    ## Bugs 'n issues

    This project be free 'n open source 'n distributed under th' MIT license.
    Th' main project be available on [Github](https://github.com/jillesvangurp/fluent-ai).
    If ye need help ping me
    or use th' [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Credits

    Fluent AI was created by [Jilles van Gurp](https://jillesvangurp.com).