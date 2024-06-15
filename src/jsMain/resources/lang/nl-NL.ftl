-about = Over
-manage-files = Beheer Fluent-bestanden
-settings = Instellingen
-translation-editor = Vertalingen editor

busy-failure = Fout
busy-initial-title = Bezig met vertalen
busy-initial-message = Aan het vertalen naar {$language} met OpenAI
busy-success = Klaar met vertalen naar {$language}

common-delete = Verwijderen
common-download = Downloaden
common-hide = Verberg {$content}
common-show = Toon {$content}
common-save = Opslaan
common-filter-placeholder = Filter de lijst
common-clear = Verwijderen
common-cancel = Annuleren
common-add = Voeg toe

confirmation-dialog-yes = Ja
confirmation-dialog-no = Nee
confirmation-dialog-default-description = Als je op ja klikt, wordt de actie uitgevoerd.
confirmation-dialog-default-question = Weet je het zeker?

cookies-welcome = Welkom bij {-brand}
cookies-disclaimer = Deze website maakt gebruik van de lokale opslag van de browser om json-inhoud op te slaan
        die je in de app creëert. Deze informatie wordt nooit elders gedeeld.
        Om deze app te gebruiken, moet je akkoord gaan met het gebruik van lokale opslag.
cookies-header = Cookies & machtigingen

file-loader-drag-and-drop = Sleep ftl-bestanden hier om ze te laden
file-loader-load-own-ftls = Laad ftl-bestanden voor { -brand }
file-loader-add-new = Maak of voeg ftl-bestanden toe
file-loader-clear-confirmation = Hierdoor worden alle huidige bestanden en bewerkingen verwijderd. Zorg ervoor dat je alles hebt gedownload wat je belangrijk vindt.
file-loader-create-new-file = Maak nieuw ftl-bestand aan
file-loader-delete-file-confirmation = Dit verwijdert { $file }.
file-loader-files-header = Jouw Fluent-bestanden
file-loader-load-own-ftls-confirmation = Dit verwijdert alle huidige bestanden en bewerkingen en vervangt deze door de ftl-bestanden voor { -brand }. Zorg ervoor dat je alles hebt gedownload wat belangrijk voor je is.
file-loader-no-files-yet-cta = Je hebt nog geen ftl-bestanden. Maak een nieuw bestand aan of sleep bestaande bestanden naar de app.
file-loader-translate-missing = Voeg ontbrekende vertalingen toe met OpenAI
file-loader-translate-missing-confirmation = Voeg {$number_translations} ontbrekende vertalingen toe met OpenAI. Let op, een groot aantal vertalingen kan enige tijd duren en zal je natuurlijk enkele tokens kosten.

language-select-select-language = Selecteer een taal

settings-open-ai-key = Stel uw OpenAI API-sleutel in (nodig voor vertalingen)
settings-translation-language = Configureer de brontaal voor AI-vertalingen. Let op, de taal wordt vergeleken met de naam van je ftl-bestand met enige normalisatie. Standaard ingesteld op en-US.
settings-edit-open-ai-key = OpenAI API-sleutel configureren

supported-models-gpt-35-turbo = Ouder model, maar nog steeds geschikt voor vertalingen. Lagere token kosten.
supported-models-gpt-4-o = Meest capabele model, groot contextvenster. Duurder dan oudere modellen.

translation-editor-add-translation-id = Maak nieuw vertalings-ID
translation-editor-no-files-cta = Je hebt minstens één vertalingsbestand nodig om te bewerken. Ga naar [{ -manage-files }](/#page=Files) en maak of voeg vertalingsbestanden toe.
translation-editor-number-of-keys = Totaal {$amount}
translation-editor-ai-translate = Vertalen met behulp van gpt-4
translation-editor-configure-key = Configureer een OpenAI API-sleutel in de instellingen
translation-editor-delete-this-id = Deze vertalings-id verwijderen
translation-editor-delete-this-id-confirmation = Dit zal de vertaal-id uit alle geladen bestanden verwijderen. Stel de definitie in op leeg als je alleen een specifieke vertaling wilt verwijderen.
translation-editor-new-translation = Standaardvertaling
translation-editor-new-translation-id = Vertaling ID
translation-editor-new-translation-id-header = Maak een nieuwe vertalingsdefinitie
translation-editor-no-translation-id-selected = Selecteer aan de linkerkant een taal-id om de vertaling te bewerken.
translation-editor-translate-using-open-ai = Vertalen met OpenAI

translation-service-progress = Vertaling voltooid van {$total} id's met behulp van {$model} in {$duration} met behulp van {$apicalls} API-oproepen

zzdocs-about = # Over Fluent AI

    {-brand} helpt je **je applicaties te lokaliseren met behulp van AI**. Het gebruikt OpenAI om in seconden te doen
    wat anders een getrainde vertaler weken zou kosten. Dit **bespaart je tijd en geld**.

    {-brand} kan je [Project Fluent](https://projectfluent.org/) lokalisatiebestanden laden en bewerken
    en het biedt een handige editor voor het bekijken en bewerken van vertalingen voor je vertalingen naast elkaar.

    ## Hoe gebruik ik {-brand}?

    - Configureer je OpenAI API-sleutel in de [{-settings}](/#page=Settings). Zonder een sleutel zullen de AI-vertalingen niet werken.
    - Laad je `.ftl` bestanden in de [{-manage-files}](/#page=Files) sectie door ze naar de UI te slepen en neer te zetten.
    - Of laad de .ftl bestanden voor Fluent AI als je alleen maar wilt experimenteren. Fluent AI is natuurlijk gelokaliseerd en spelen met zijn .ftl bestanden is een geweldige manier om te beginnen.
    - Voor elk bestand wordt het aantal ontbrekende vertalingen weergegeven en biedt het een AI-geassisteerde vertaling voor deze.
    - Je kunt ze ook handmatig bewerken met de [{-translation-editor}](/#page=Editor) om je vertalingsstrings te bewerken of individuele strings te vertalen met OpenAI.

    ## Wat is Project Fluent en waarom zou je het gebruiken?

    Ontworpen door Mozilla om producten als Firefox, Thunderbird, enz. te ondersteunen bij het lokaliseren naar honderden talen,
    is Project Fluent ontworpen met flexibiliteit en bruikbaarheid in gedachten. Hun vertalingen hangen af van
    een grote gebruikersgemeenschap die vertalingen bijdraagt. Daarom wilden ze dit zo eenvoudig mogelijk maken.
    Bovendien hadden ze de flexibiliteit nodig om om te gaan met verschillende grammaticale variaties
    in talen voor bv. geslacht, tijd, hoeveelheid, enz.

    Het resultaat, Project Fluent, is een eenvoudig en gemakkelijk te gebruiken bestandsformaat en syntaxis voor het definiëren van vertalingsbestanden. Het biedt een paar voordelen
    ten opzichte van andere oplossingen in deze ruimte gebaseerd op bv. properties-bestanden of bibliotheken zoals gettext:

    - **Flexibiliteit.** Het ondersteunt conditionele logica en variabelen die je in je vertalingen kunt gebruiken.
    - **Gebruiksgemak.** Het is eenvoudig en gemakkelijk te gebruiken en te bewerken. Elk bestand met regels die `key = vertaling` bevatten, is een geldig `ftl` bestand.
    - **Draagbaarheid.** Er zijn bibliotheken die het ondersteunen van op Fluent gebaseerde lokalisaties gemakkelijk maken in zowel native, mobiele als webapplicaties.

    ## Beperkingen van {-brand}

    - {-brand} valideert momenteel niet de Fluent-syntaxis.
    - Het werkt in een browser, dus er is geen directe toegang tot het bestandssysteem. Je kunt echter bestanden naar de UI slepen en neerzetten en gewijzigde bestanden downloaden vanuit de UI. Bij voldoende interesse maak ik misschien ooit een Electron wrapper voor {-brand}.
    - Het is een beetje eigenzinnig als het gaat om het herordenen en opschonen van vertalingen. Het zal bijvoorbeeld vertalingen verwijderen die identiek zijn aan de basisvertaling. Controleer de verschillen zorgvuldig voordat je wijzigingen in je lokalisatiebestanden doorvoert.
    - OpenAI is goed, maar natuurlijk niet foutloos en soms heeft het het gewoon mis. Ook heeft het mogelijk niet altijd genoeg context om alles correct te vertalen. Je moet natuurlijk professionele vertalers gebruiken om vertalingen te beoordelen. Het slaagt er echter vaak in.
    - Hoewel je vertalingen voor Fluent AI zelf kunt bewerken, herlaadt het ze momenteel niet in de UI. Mogelijk voeg ik dit later toe.
    - Het model en de AI-provider zijn momenteel vast ingesteld. Ik ben me goed bewust van andere oplossingen in deze ruimte en wellicht ondersteun ik later extra modellen; mogelijk zelfs lokaal werkende modellen. OpenAI lijkt echter momenteel het beste in zijn klasse en is goedkoop genoeg.
    - Het vertalen van grote bestanden kan vrij lang duren.

    ## Bugs en problemen

    Dit project is gratis en open source en wordt verspreid onder de MIT-licentie.
    Het hoofdproject is beschikbaar op [Github](https://github.com/jillesvangurp/fluent-ai).
    Als je hulp nodig hebt, stuur me dan een bericht
    of gebruik de [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Gerelateerde projecten

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplatform bibliotheek die ik en mijn collega's hebben ontwikkeld voor jvm/js waarmee je .ftl bestanden kunt gebruiken in je Kotlin-applicaties. Deze browserapplicatie maakt er gebruik van.

    ## Verspreid het woord

    Het schrijven van software zoals deze is veel werk en het kan vaak ondankbaar werk zijn. Als Fluent AI nuttig voor je is, laat anderen dit dan weten zodat zij er ook van kunnen profiteren.

    - Tweet / toot / blog erover.
    - Klik op de sterknop op [Github](https://github.com/jillesvangurp/fluent-ai).
    - Geef me wat feedback.

    ## Credits

    Fluent AI is gemaakt door [Jilles van Gurp](https://jillesvangurp.com). Momenteel is het gratis en open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Mijn website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X