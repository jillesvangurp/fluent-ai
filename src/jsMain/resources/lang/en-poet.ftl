-about = 'Tis of What
-brand = Eloquent tongues of AI
-manage-files = Steward Fluent Tomes
-settings = Attunements
-translation-editor = Scribe's Chamber

busy-failure = A Mishap
busy-initial-title = Crafting Tongues
busy-initial-message = Calling upon the spirits of OpenAI to weave words into {$language}
busy-success = The Tongues are Transformed to {$language}

common-app-name = { -brand }
common-add = Enrich
common-cancel = Desist
common-clear = Cleanse
common-confirm = Verily
common-filter-placeholder = Sift the scrolls
common-save = Preserve
common-delete = Erase
common-download = Procure
common-hide = Veil {$content}
common-show = Unveil {$content}

confirmation-dialog-yes = Indeed
confirmation-dialog-no = Nay
confirmation-dialog-default-question = Art thou certain?
confirmation-dialog-default-description = If thou clicketh yes, the deed shall be done.

cookies-disclaimer = This realm employs browser local storage to retain the json substance
        thou dost create within the app. This lore is never divulged elsewhere.
        To wield this app, thou must consent to the employment of local storage.
cookies-header = Cookies & mandates
cookies-welcome = Welcome to {-brand}

file-loader-clear-confirmation = This shall expunge any present files and alterations. Ensure thou hast procured all thou deem worthy.
file-loader-delete-file-confirmation = This shall eradicate { $file }.
file-loader-files-header = Thy Fluent Manuscripts
file-loader-drag-and-drop = Cast thine ftl scrolls hither to ensorcel them
file-loader-load-own-ftls = Invoke thine own ftl scrolls for { -brand }
file-loader-load-own-ftls-confirmation = Verily, this shall erase all current scrolls and inscriptions, replacing them with ftl scrolls for { -brand }. Ensure thou hast safeguarded all thou deem'st precious.
file-loader-add-new = Forge or entwine ftl scrolls
file-loader-create-new-file = Forge a new ftl scroll
file-loader-no-files-yet-cta = Thou possess no ftl scrolls yet. Forge a new one or cast existing ones into the app.
file-loader-translate-missing = Invoke the missing with OpenAI's aid
file-loader-translate-missing-confirmation = Summon {$number_translations} missing translations with OpenAI's magick. Beware, an abundance of translations may require time and of course shalt deplete thy tokens.

language-select-select-language = Choose thy tongue for the UI

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-edit-open-ai-key = Attune OpenAI's arcane key
settings-open-ai-key = Declare thine OpenAI arcane key (needed for translations)
settings-translation-language = Configure the tongue from whence AI’s silver words will flow. Note, the tongue doth match against thy file name with some norm. Defaults to en-US.

supported-models-gpt-4-o = The genius model, vast is its mind like the stars. Gold it demands, more than its forebears.
supported-models-gpt-35-turbo = An elder mind, yet wise and sufficient. Tokens it desires, fewer than its kin.

translation-editor-add-translation-id = Birth a new id of translation
translation-editor-ai-translate = Let gpt-4o weave its words
translation-editor-configure-key = Set an OpenAI key in the sacred settings
translation-editor-delete-this-id = Banish this translation id
translation-editor-delete-this-id-confirmation = This banishment shall erase the id from every tome. Leave empty the page if thou dost wish to erase but one translation.
translation-editor-no-translation-id-selected = Choose a language id upon the left to shape the translation.
translation-editor-new-translation-id-header = Craft a new translation's essence
translation-editor-new-translation-id = ID of Translation
translation-editor-new-translation = Translation, by default
translation-editor-no-files-cta = One translation file at least, thou needst to edit. Travel to [{ -manage-files }](/#page=Files) and conjure or summon some files of translation.
translation-editor-number-of-keys = Total {$amount}
translation-editor-translate-using-open-ai = Let OpenAI be thy translator

translation-service-progress = Concluded the translation of {$total} ids with {$model} within {$duration}, utilizing {$apicalls} API calls

zzdocs-about = # About Fluent AI

    {-brand} dost aid thee in **localizing thy applications with AI's grace**. It doth employ OpenAI to accomplish in mere moments
    what a learned translator might toil for weeks. This **saveth thee both time and gold**.

    {-brand} can thus load and amend thy [Project Fluent](https://projectfluent.org/) localization scrolls,
    offering a convenient scribe for scrutinizing and refining thy translations in parallel.

    ## How might one use {-brand}?

    - Configure thine OpenAI API key in the [{-settings}](/#page=Settings). Without a key, the AI translations shall remain dormant.
    - Fetch thy `.ftl` scrolls into the [{-manage-files}](/#page=Files) segment by dragging and dropping them into the interface.
    - Alternatively, acquire the ftl scrolls for Fluent AI if thou dost seek mere experimentation. Fluent AI, being itself localized, serves as a noble inception point.
    - For each scroll, thou shalt witness the tally of absent translations, with AI-supported translations offered for them.
    - One may also amend them manually through the [{-translation-editor}](/#page=Editor), polishing thy translation strings or translating each string individually with OpenAI's aid.

    ## What is project Fluent and why ought thou use it?

    Conceived by Mozilla to buttress products like Firefox and Thunderbird in myriad tongues,
    Project Fluent is forged for both flexibility and ease of use. Their translations rely upon
    a vast community of users contributing their linguistic treasures. Thus, simplicity hath been their aim.
    Moreover, flexibility to manage various grammatical variations—be it gender, tense, or number—was crucial.

    The consequence, project fluent, is a format of plain and effortless usability for defining translation scrolls. It proffers several boons
    over other solutions like properties files or libraries akin to gettext:

    - **Flexibility.** It doth support conditional logic and variables within thy translations.
    - **Ease of use.** Simple and accessible, any scroll with lines holding `key = translation` is a valid `ftl` scroll.
    - **Portability.** There exist libraries simplifying the endorsement of Fluent-based localizations in native, mobile, and web applications.

    ## Limitations of {-brand}

    - {-brand} currently doth not validate the fluent syntax.
    - It dwells in a browser, hence has no direct access to the file system. Drag and drop thou must for files, and modified files shalt thou download from the interface. Given ample interest, an Electron wrapper for {-brand} might be forged.
    - It holds certain preferences about the re-ordering and refining of translations. Closely inspect diffs before thy final commits to localization scrolls.
    - OpenAI, though proficient, is not devoid of flaws and may err. Lacking ample context, some translations may falter. Thus, employ professional translators for verification. Still, it oft overcomes such trials with finesse.
    - While translations for Fluent AI may be amended, reloading them in the interface is not yet enabled. This may change.
    - As of now, only OpenAI is supported. Should there be interest, more models may be integrated in time.
    - Translating scrolls of grand length might consume considerable time.

    ## Bugs and issues

    This endeavor is free and open as the skies, under the MIT license.
    The principal project lies on [Github](https://github.com/jillesvangurp/fluent-ai).
    For aid, summon me
    or employ the [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Related projects

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - A library for multiple platforms, crafted by myself and my comrades for jvm/js, empowering the use of ftl scrolls in thy Kotlin applications. This browser application is its offspring.

    ## Spread the word

    Crafting software such as this entails vast toil and can often seem thankless. If Fluent AI endows thee with worth, spread the word so others may also partake in its bounty.

    - Tweet, toot, or blog about it.
    - Mark it with a star on [Github](https://github.com/jillesvangurp/fluent-ai).
    - Render me thine feedback.

    ## Credits

    Fluent AI is authored by [Jilles van Gurp](https://jillesvangurp.com), and remains freely accessible and open.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - My sanctuary
    - [@jillesvangurp@mastodon.world](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X