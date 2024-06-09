-brand = Fluent AI

busy-failure = Fout
busy-initial-title = Bezig met vertalen
busy-initial-message = Aan het vertalen naar {$language} met OpenAI
busy-success = Klaar met vertalen naar {$language}

common-app-name = { -brand }
common-confirm = OK
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

pages-editor = Wijzig Fluent Definities
pages-settings = Instellingen
pages-files = Beheer Fluent-bestanden
pages-about = Over

settings-open-ai-key = Stel uw OpenAI API-sleutel in (nodig voor vertalingen)
settings-translation-language = Configureer de brontaal voor AI-vertalingen. Let op, de taal wordt vergeleken met de naam van je ftl-bestand met enige normalisatie. Standaard ingesteld op en-US.

translation-editor-ai-translate = Vertalen met behulp van gpt-4
translation-editor-configure-key = Configureer een OpenAI API-sleutel in de instellingen
translation-editor-delete-this-id = Deze vertalings-id verwijderen
translation-editor-delete-this-id-confirmation = Dit zal de vertaal-id uit alle geladen bestanden verwijderen. Stel de definitie in op leeg als je alleen een specifieke vertaling wilt verwijderen.
translation-editor-new-translation = Standaardvertaling
translation-editor-new-translation-id = Vertaling ID
translation-editor-new-translation-id-header = Maak een nieuwe vertalingsdefinitie
translation-editor-no-translation-id-selected = Selecteer aan de linkerkant een taal-id om de vertaling te bewerken.
translation-editor-translate-using-open-ai = Vertalen met OpenAI

zzdocs-about = # Over Fluent AI

    Fluent AI helpt je bij het lokaliseren van je applicaties. Het kan je [Project Fluent](https://projectfluent.org/) localisatiebestanden laden en bewerken en deze vertalen naar verschillende talen met behulp van AI.

    ## Hoe werkt het

    - Configureer je OpenAI API-sleutel in de instellingen. Zonder dit zullen de AI-vertalingen niet werken.
    - Laad je `.ftl`-bestanden in het bestanden-gedeelte door ze naar de UI te slepen en te plaatsen.
    - Of laad de ftl-bestanden voor Fluent AI als je alleen maar wilt experimenteren.
    - Voor elk bestand toont het je het aantal ontbrekende vertalingen en biedt het aan om de ontbrekende vertalingen te vertalen.
    - Je kunt ze ook handmatig bewerken met de editor om je vertalingsstrings te bewerken of individuele strings te vertalen met OpenAI.

    ## Beperkingen

    - Fluent AI valideert momenteel niet de Fluent-syntaxis
    - Het werkt in een browser dus er is geen directe toegang tot het bestandssysteem. Je kunt echter bestanden naar de UI slepen en geplaatste bestanden bewerken en downloaden vanuit de UI.
    - Het is een beetje eigenzinnig wat betreft het herschikken van alle vertalingen, bekijk zorgvuldig de verschillen voordat je wijzigingen in je lokalisatiebestanden doorvoert.
    - OpenAI is goed maar niet foutloos en soms gaat het gewoon mis. Ook kan het soms niet genoeg context hebben om alles correct te vertalen.
    - Je kunt vertalingen voor Fluent AI zelf bewerken, maar ze worden momenteel niet opnieuw geladen in de UI. Ik voeg dit later mogelijk toe.

    ## Bugs en problemen

    Dit project is gratis en open source en wordt verspreid onder de MIT-licentie.
    Het hoofdproject is beschikbaar op [Github](https://github.com/jillesvangurp/fluent-ai).
    Als je hulp nodig hebt, ping me
    of gebruik de [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Credits

    Fluent AI is gemaakt door [Jilles van Gurp](https://jillesvangurp.com).