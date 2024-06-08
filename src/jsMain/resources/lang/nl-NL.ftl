-brand = Fluent AI

common-save = Opslaan
common-filter-placeholder = Filter de lijst
common-clear = Verwijderen
common-cancel = Annuleren
common-add = Voeg toe

confirmation-dialog-yes = Ja
confirmation-dialog-no = Nee
confirmation-dialog-default-description = Als je op ja klikt, wordt de actie uitgevoerd.
confirmation-dialog-default-question = Weet je het zeker?

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

    Fluent AI helpt u uw toepassingen te lokaliseren. Het kan uw [Project Fluent](https://projectfluent.org/) lokalisatiebestanden laden en stelt u in staat om vertalingen naast elkaar te bewerken.

    Belangrijker nog, het heeft ingebouwde ondersteuning voor het gebruik van OpenAI om uw lokalisaties te vertalen.

    ## Hoe werkt het

    - Configureer uw OpenAI API-sleutel in de instellingen. Zonder deze zal de AI vertaling niet werken.
    - Laad uw `.ftl` bestanden in de bestandssectie
    - En ga dan naar de editor om uw vertalingsstrings te bewerken.

    ## Beperkingen

    - Dit valideert momenteel niet de fluent syntax
    - Het draait in een browser, dus er is geen directe toegang tot het bestandssysteem. U kunt echter bestanden naar de UI slepen en aangepaste bestanden downloaden vanuit de UI.
    - Het heeft een bepaalde voorkeur voor het herschikken van alle vertalingen, bekijk de verschillen zorgvuldig voordat u wijzigingen in uw lokalisatiebestanden doorvoert.

    ## Bugs en problemen

    Dit project is gratis en open source en wordt gedistribueerd onder de MIT-licentie. Als u hulp nodig heeft, ping me dan of gebruik de [issue tracker](https://github.com/jillesvangurp/fluent-ai/issues).