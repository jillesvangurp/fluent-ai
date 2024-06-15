-about = Über
-brand = Fluent AI
-manage-files = Fluent-Dateien verwalten
-settings = Einstellungen
-translation-editor = Übersetzungseditor

busy-failure = Fehler
busy-initial-title = Übersetzen
busy-initial-message = Verwenden von OpenAI zum Übersetzen nach {$language}
busy-success = Übersetzung nach {$language} abgeschlossen

common-app-name = { -brand }
common-confirm = OK
common-add = Hinzufügen
common-cancel = Abbrechen
common-clear = Löschen
common-filter-placeholder = Liste filtern
common-save = Speichern
common-delete = Löschen
common-download = Herunterladen
common-hide = {$content} verbergen
common-show = {$content} anzeigen

confirmation-dialog-yes = Ja
confirmation-dialog-no = Nein
confirmation-dialog-default-question = Sind Sie sicher?
confirmation-dialog-default-description = Wenn Sie auf Ja klicken, wird die Aktion ausgeführt.

cookies-disclaimer = Diese Website verwendet den lokalen Speicher des Browsers, um JSON-Inhalte, die Sie in der App erstellen, zu speichern. Diese Informationen werden niemals anderweitig weitergegeben. Um diese App zu nutzen, müssen Sie der Nutzung des lokalen Speichers zustimmen.
cookies-header = Cookies & Berechtigungen
cookies-welcome = Willkommen bei {-brand}

file-loader-clear-confirmation = Dies wird alle aktuellen Dateien und Änderungen entfernen. Stellen Sie sicher, dass Sie alles heruntergeladen haben, was Ihnen wichtig ist.
file-loader-delete-file-confirmation = Dies wird {$file} entfernen.
file-loader-files-header = Ihre Fluent-Dateien
file-loader-drag-and-drop = Ziehen Sie die FTL-Dateien hierher, um sie zu laden
file-loader-load-own-ftls = Laden Sie die FTL-Dateien für { -brand }
file-loader-load-own-ftls-confirmation = Dies wird alle aktuellen Dateien und Änderungen entfernen und sie durch die FTL-Dateien für { -brand } ersetzen. Stellen Sie sicher, dass Sie alles heruntergeladen haben, was Ihnen wichtig ist.
file-loader-add-new = Erstellen oder hinzufügen von FTL-Dateien
file-loader-create-new-file = Neue FTL-Datei erstellen
file-loader-no-files-yet-cta = Sie haben noch keine FTL-Dateien. Erstellen Sie eine neue oder ziehen Sie vorhandene Dateien in die App.
file-loader-translate-missing = Fehlende mit OpenAI hinzufügen
file-loader-translate-missing-confirmation = {$number_translations} fehlende Übersetzungen mit OpenAI hinzufügen. Hinweis: Eine große Anzahl von Übersetzungen kann einige Zeit in Anspruch nehmen und wird natürlich einige Tokens kosten.

language-select-select-language = UI-Sprache auswählen

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-open-ai-key = Ihren OpenAI-API-Schlüssel einstellen (notwendig für Übersetzungen)
settings-translation-language = Quellsprache für AI-Übersetzungen konfigurieren. Hinweis: Die Sprache wird anhand des Namens Ihrer FTL-Datei mit etwas Normalisierung abgeglichen. Standard ist en-US.

translation-editor-add-translation-id = Neue Übersetzungs-ID erstellen
translation-editor-no-files-cta = Du benötigst mindestens eine Übersetzungsdatei zum Bearbeiten. Gehe zu [{ -manage-files }](/#page=Files) und erstelle oder füge einige Übersetzungsdateien hinzu.
translation-editor-number-of-keys = Gesamt {$amount}
translation-editor-ai-translate = Mit gpt-4.0 übersetzen
translation-editor-configure-key = Konfigurieren Sie einen OpenAI-API-Schlüssel in den Einstellungen
translation-editor-delete-this-id = Diese Übersetzungs-ID löschen
translation-editor-delete-this-id-confirmation = Dies wird die Übersetzungs-ID aus allen geladenen Dateien löschen. Setzen Sie die Definition auf leer, wenn Sie nur eine bestimmte Übersetzung löschen möchten.
translation-editor-no-translation-id-selected = Wählen Sie links eine Sprach-ID aus, um die Übersetzung zu bearbeiten.
translation-editor-new-translation-id-header = Neue Übersetzungsdefinition erstellen
translation-editor-new-translation-id = Übersetzungs-ID
translation-editor-new-translation = Standardübersetzung
translation-editor-translate-using-open-ai = Mit OpenAI übersetzen

zzdocs-about = # Über Fluent AI

    {-brand} hilft dir dabei, **deine Anwendungen mit KI zu lokalisieren**. Es nutzt OpenAI, um in Sekunden das zu erledigen, was sonst Wochen von einem geschulten Übersetzer dauern würde. Dies **spart dir Zeit und Geld**.

    {-brand} kann deine [Project Fluent](https://projectfluent.org/) Lokalisierungsdateien laden und bearbeiten und bietet einen praktischen Editor zum Überprüfen und Bearbeiten von Übersetzungen nebeneinander.

    ## Wie benutze ich {-brand}?

    - Konfiguriere deinen OpenAI API-Schlüssel in den [{-settings}](/#page=Settings). Ohne einen Schlüssel funktionieren die KI-Übersetzungen nicht.
    - Lade deine `.ftl`-Dateien im Abschnitt [{ -manage-files }](/#page=Files) hoch, indem du sie in die Benutzeroberfläche ziehst.
    - Oder lade die ftl-Dateien für Fluent AI, wenn du nur herumspielen möchtest. Fluent AI ist natürlich lokalisiert und das Spielen mit seinen ftl-Dateien ist eine großartige Möglichkeit, loszulegen.
    - Für jede Datei wird dir die Anzahl der fehlenden Übersetzungen angezeigt und eine KI-gestützte Übersetzung für diese angeboten.
    - Du kannst sie auch manuell mit dem [{-translation-editor}](/#page=Editor) bearbeiten, um deine Übersetzungsstrings zu bearbeiten oder einzelne Strings mit OpenAI zu übersetzen.

    ## Was ist Project Fluent und warum solltest du es verwenden?

    Erfunden von Mozilla, um Produkte wie Firefox, Thunderbird usw. in Hunderte von Sprachen zu lokalisieren, wurde Project Fluent mit Flexibilität und Benutzerfreundlichkeit im Kopf entwickelt. Ihre Übersetzungen hängen von einer großen Benutzercommunity ab, die Übersetzungen beisteuert. Sie wollten dies daher so einfach wie möglich machen. Zusätzlich brauchten sie die Flexibilität, um mit verschiedenen grammatikalischen Variationen in Sprachen umzugehen, z.B. Geschlecht, Zeit, Menge, usw.

    Das Ergebnis, Project Fluent, ist ein einfaches und benutzerfreundliches Dateiformat und Syntax zur Definition von Übersetzungsdateien. Es bietet einige Vorteile gegenüber anderen Lösungen in diesem Bereich, die z.B. auf Eigenschaftendateien oder Bibliotheken wie gettext basieren:

    - **Flexibilität.** Es unterstützt bedingte Logik und Variablen, die du in deinen Übersetzungen verwenden kannst.
    - **Benutzerfreundlichkeit.** Es ist einfach und benutzerfreundlich zu verwenden und zu bearbeiten. Jede Datei mit Zeilen, die `Schlüssel = Übersetzung` enthalten, ist eine gültige `ftl`-Datei.
    - **Portabilität.** Es gibt Bibliotheken, die die Unterstützung von Fluent-basierten Lokalisierungen in nativen, mobilen und Webanwendungen erleichtern.

    ## Einschränkungen von {-brand}

    - {-brand} validiert derzeit nicht die Fluent-Syntax.
    - Es läuft in einem Browser, daher gibt es keinen direkten Dateisystemzugriff. Du kannst jedoch Dateien in die Benutzeroberfläche ziehen und die modifizierten Dateien von der Benutzeroberfläche herunterladen. Bei genügend Interesse könnte ich irgendwann einen Electron-Wrapper für {-brand} erstellen.
    - Es ist ein wenig meinungsstark, was die Neuordnung und Bereinigung von Übersetzungen betrifft. Es wird z.B. Übersetzungen entfernen, die mit der Basisübersetzung identisch sind. Überprüfe Änderungen sorgfältig, bevor du sie in deine Lokalisierungsdateien übernimmst.
    - OpenAI ist gut, aber natürlich nicht fehlerlos und manchmal liegt es einfach falsch. Es hat möglicherweise nicht immer genug Kontext, um alles richtig zu übersetzen. Du solltest professionelle Übersetzer zur Überprüfung der Übersetzungen hinzuziehen. Dennoch trifft es oft ins Schwarze.
    - Während du Übersetzungen für Fluent AI selbst bearbeiten kannst, lädt es sie derzeit nicht in der Benutzeroberfläche neu. Dies könnte ich später hinzufügen.
    - Das Modell und der KI-Anbieter sind derzeit fest verdrahtet. Ich bin mir der anderen Lösungen in diesem Bereich bewusst und könnte künftig zusätzliche Modelle unterstützen, einschließlich möglicherweise auch lokal laufender Modelle. Derzeit scheint OpenAI jedoch am besten in seiner Klasse zu sein und ist kostengünstig.
    - Das Übersetzen großer Dateien kann ziemlich viel Zeit in Anspruch nehmen.

    ## Bugs und Probleme

    Dieses Projekt ist kostenlos und Open Source und wird unter der MIT-Lizenz vertrieben.
    Das Hauptprojekt ist auf [Github](https://github.com/jillesvangurp/fluent-ai) verfügbar.
    Wenn du Hilfe benötigst, kontaktiere mich oder nutze den [Issue Tracker](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Verwandte Projekte

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Eine Multiplattform-Bibliothek, die ich und meine Kollegen für jvm/js entwickelt haben und die es ermöglicht, ftl-Dateien in deinen Kotlin-Anwendungen zu verwenden. Diese Browseranwendung nutzt sie.

    ## Erzähl es weiter

    Software wie diese zu schreiben, ist viel Arbeit und oft eine undankbare Arbeit. Wenn dir Fluent AI nützlich ist, lass es andere wissen, damit sie auch davon profitieren können.

    - Tweet / toot / blogge darüber.
    - Klicke auf den Stern-Button auf [Github](https://github.com/jillesvangurp/fluent-ai).
    - Gib mir ein Feedback.

    ## Credits

    Fluent AI wurde von [Jilles van Gurp](https://jillesvangurp.com) erstellt. Derzeit ist es kostenlos und Open Source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Meine Website
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X