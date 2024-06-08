-brand = Fluent AI

common-cancel = Belay
common-clear = Swab
common-confirm = Aye
common-filter-placeholder = Filter th' list
common-save = Save
common-add = Add ye scallywag

confirmation-dialog-yes = Aye
confirmation-dialog-no = Nay
confirmation-dialog-default-description = If ye click aye, the action will be carried out.
confirmation-dialog-default-question = Be ye certain?

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

language-select-select-language = Pick a tongue

pages-editor = Edit the Fluent Definitions
pages-files = Manage Fluent Files = Arrr'ange Fluent Files
pages-settings = Settin's
pages-about = 'Bout

settings-open-ai-key = Set yer OpenAI API Key (needed fer translatin')
settings-translation-language = Set ye source lingo for yer AI translations, matey. Be warned, the lingo be matched against yer ftl file name with some normalizin'. Defaults to en-US.

translation-editor-ai-translate = Translate usin' GPT-4
translation-editor-configure-key = Set sail an OpenAI API key in the settin's
translation-editor-delete-this-id = Delete this 'ere translatin' id
translation-editor-delete-this-id-confirmation = This will be deletin' the translation id from all the loaded files. Set the definition to nothin' if ye just be wantin' to delete a specific translation.
translation-editor-new-translation = Arrr translation
translation-editor-new-translation-id = Ahoy matey! Ye be lookin' for some English Pirate translations, eh? Here we be:
translation-editor-new-translation-id-header = Arr, be creatin' a new translation definition
translation-editor-no-translation-id-selected = Select a language id on the port side to be editing the translation.
translation-editor-translate-using-open-ai = Translate using OpenAI

zzdocs-about = # 'Bout Fluent AI

    Fluent AI be helpin' ye localize yer applications. It can hoist yer [Project Fluent](https://projectfluent.org/) localization files 'n allows ye t' edit translations side by side.

    More importantly, it be havin' built-in support fer usin' OpenAI t' translate yer localizations.

    ## How be it workin'

    - Configure yer OpenAI API key in th' settings. Without this th' AI translations won't work.
    - Load yer `.ftl` files in th' files section
    - An' then go t' th' editor t' edit yer translation strings.

    ## Limitations

    - This currently does not validate th' fluent syntax
    - It runs in a browser so there be no direct file system access. However ye can drag 'n drop files t' th' UI an' download modified files from th' UI.
    - It be a bit opinionated 'bout re-orderin' all th' translations, carefully examine diffs afore committin' changes t' yer localization files.

    ## Bugs 'n issues

    This project be free 'n open source 'n distributed under th' MIT license. If ye need help ping me or use th' [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).