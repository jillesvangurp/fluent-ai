-about = 'Bout
-brand = Fluent AI
-manage-files = Wrangle Fluent Files
-settings = Fixins
-translation-editor = Translation Shed

busy-failure = Dang It
busy-initial-title = Translatin'
busy-initial-message = Usin' OpenAI to translate to {$language}
busy-success = Done translatin' to {$language}

common-app-name = { -brand }
common-add = Fetch
common-cancel = Ain't Happenin'
common-clear = Sweep
common-confirm = Yep
common-filter-placeholder = Filter the list
common-save = Save
common-delete = Delete
common-download = Download
common-hide = Hide {$content}
common-show = Show {$content}

confirmation-dialog-yes = Yep
confirmation-dialog-no = Naw
confirmation-dialog-default-question = Y'all sure 'bout that?
confirmation-dialog-default-description = If y'all click yep, we gonna go on and do it.

cookies-disclaimer = This here website uses browser local storage ta store json stuff y'all make in the app. Ain't none of this shared nowhere else. Use this app, y'all gotta agree ta the local storage.
cookies-header = Cookies & permissions
cookies-welcome = Welcome ta {-brand}

file-loader-clear-confirmation = This here will wipe out any files and changes y'all got now. Make sure ya downloaded what ya need.
file-loader-delete-file-confirmation = This here will wipe out { $file }.
file-loader-files-header = Yer Fluent Files
file-loader-drag-and-drop = Drag dem ftl files rightchere ta git em loaded
file-loader-load-own-ftls = Load ftl files fer { -brand }
file-loader-load-own-ftls-confirmation = This here gonna git rid of any current files and edits an' swap em with the ftl files fer { -brand }. Make sure ya done saved anythin' ya care 'bout.
file-loader-add-new = Make or add ftl files
file-loader-create-new-file = Make a new ftl file
file-loader-no-files-yet-cta = Y'all ain't got any ftl files yet. Make a new one or drag sum existin' ones t'the app.
file-loader-translate-missing = Add missin' with OpenAI
file-loader-translate-missing-confirmation = Add {$number_translations} missin' translations with OpenAI. Be warned, a heap o' translations might take a while an' will cost ya sum tokens.

language-select-select-language = Pick yer UI language

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-edit-open-ai-key = Fix up yer OpenAI API Key
settings-open-ai-key = Set yer OpenAI API Key (needed fer translations)
settings-translation-language = Fix up source language fer AI translations. Note, the language gits matched agin yer ftl file name with sum normalizin'. Defaults to en-US.

supported-models-gpt-4-o = Most capable model, big ol' context window. More costly than them older models.
supported-models-gpt-35-turbo = Older model but still does the job fer translations. Cheaper fer tokens.

translation-editor-add-translation-id = Make new translation id
translation-editor-ai-translate = Translate
translation-editor-configure-key = Fix up a OpenAI API key in the settin's
translation-editor-delete-this-id = Git rid of this translation id
translation-editor-delete-this-id-confirmation = This here will delete the translation id from all them loaded files. Set the definition empty if ya jest wanna git rid of a specific translation.
translation-editor-no-translation-id-selected = Pick a language id on the left to fiddle with the translation.
translation-editor-new-translation-id-header = Make a new translation definition
translation-editor-new-translation-id = Translation ID
translation-editor-new-translation = Default translation
translation-editor-no-files-cta = Ya need at least one translation file to mess with. Head on over to [{ -manage-files }](/#page=Files) and make or add sum translation files.
translation-editor-number-of-keys = Total {$amount}
translation-editor-translate-using-open-ai = Translate usin' OpenAI

translation-service-progress = Done got {$total} ids translated usin' {$model} in {$duration} usin' {$apicalls} API calls

zzdocs-about = # 'Bout Fluent AI

    {-brand} helps ya **make yer apps talk like the locals usin' AI**. It uses OpenAI to do in seconds
    what would otherwise take a trained translator a heap of time. This here **saves ya time and money**.

    {-brand} can load up and edit yer [Project Fluent](https://projectfluent.org/) localization files
    and it offers a handy dandy editor fer reviewin' and fixin' up translations side by side.

    ## How do I use {-brand}?

    - Get yer OpenAI API key set up in the [{-settings}](/#page=Settings). Without a key, the AI ain't gonna do squat.
    - Load up yer `.ftl` files in the [{-manage-files}](/#page=Files) section by draggin' and droppin' 'em in the UI.
    - Or just play 'round with the Fluent AI's own files if yer just fiddlin' 'round. Fluent AI is already set up fer multiple languages, so it's a good place to start practicin'.
    - It'll show ya how many translations are missin' and lend a hand with AI-assisted translations fer those.
    - Ya can also pitch in manually with the [{-translation-editor}](/#page=Editor) to tweak yer translations or handle individual strings with OpenAI.

    ## What is project Fluent and why should ya give it a shot?

    Made by them geniuses at Mozilla to help with localizin' things like Firefox, Thunderbird, and more to a mess of languages,
    Project Fluent is built fer flexibility and ease of use. Their translations come from
    a big ol' user community pitchin' in. So, they made it as simple as pie.
    Plus, they needed it to be flexible 'nough to handle all sorts of grammatical craziness like
    gender, tense, amount, and so on.

    The upshot, project fluent, is a straightforward file format and syntax fer writin' translation files. It has a few perks
    compared to other ways of doin' thangs using e.g. properties files or libraries like gettext:

    - **Flexibility.** It supports all sorts of fancy stuff like conditional logic and variables in translations.
    - **Ease of use.** It's simple as can be. Any file with lines like `key = translation` is a valid `ftl` file.
    - **Portability.** There are libraries makin' it easy-peasy to support Fluent-based localizations in native, mobile, and web apps.

    ## Drawbacks of {-brand}

    - {-brand} ain't checkin' yer fluent syntax fer errors.
    - It runs in a browser, so ya can't mess with the file system directly. But ya can drag and drop files into the UI and download 'em from there once yer done. If enough folks want it, I might make an Electron wrapper fer {-brand}.
    - It's a bit picky 'bout cleanin' up and re-orderin' translations. Double-check yer changes before ya commit 'em.
    - OpenAI's pretty good but it ain't perfect and sometimes it just don't get things right. It may not always have 'nough context to make perfect translations. Always good to have a pro translator take a gander at it. Though, it gets things right more often than not.
    - While ya can edit translations fer Fluent AI itself, right now it won't reload 'em in the UI. Might add that later.
    - Currently, OpenAI is the only model I'm usin'. Might add more if folks are keen.
    - Translating big ol' files can take some time.

    ## Bugs and issues

    This project's free and open source under the MIT license.
    The main project is on [Github](https://github.com/jillesvangurp/fluent-ai).
    If ya need a hand, holler at me
    or use the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Related projects

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplatform library me and my buddies cooked up for jvm/js that lets ya use ftl files in yer Kotlin apps. This here browser app uses it.

    ## Spread the word

    Puttin' together software like this is a heap of work and sometimes it ain't appreciated much. If Fluent AI helps ya out, let others know so they can get a kick outta it too.

    - Tweet / toot / blog 'bout it.
    - Click the star button on [Github](https://github.com/jillesvangurp/fluent-ai).
    - Give me some feedback.

    ## Credits

    Fluent AI is whipped up by [Jilles van Gurp](https://jillesvangurp.com). Right now it's free and open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - My website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X