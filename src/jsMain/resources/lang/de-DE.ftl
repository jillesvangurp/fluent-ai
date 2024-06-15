-about = Über
-brand = Fluent AI
-manage-files = Fluent-Dateien verwalten
-settings = Einstellungen
-translation-editor = Übersetzungseditor

busy-failure = Fehler
busy-initial-title = Übersetzen
busy-initial-message = Verwenden von OpenAI zum Übersetzen nach {$language}
busy-success = Übersetzung nach {$language} abgeschlossen

common-add = Hinzufügen
common-cancel = Abbrechen
common-clear = Löschen
common-filter-placeholder = Liste filtern
common-save = Speichern
common-delete = Löschen
common-download = Herunterladen
common-hide = {$content} verbergen
common-show = {$content} anzeigen
common-confirm = OK

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

settings-open-ai-key = Ihren OpenAI-API-Schlüssel einstellen (notwendig für Übersetzungen)
settings-translation-language = Quellsprache für AI-Übersetzungen konfigurieren. Hinweis: Die Sprache wird anhand des Namens Ihrer FTL-Datei mit etwas Normalisierung abgeglichen. Standard ist en-US.
settings-edit-open-ai-key = Konfiguriere OpenAI API-Schlüssel

supported-models-gpt-35-turbo = Älteres Modell, aber immer noch ausreichend für Übersetzungen. Geringere Tokenkosten.
supported-models-gpt-4-o = Das leistungsfähigste Modell, großes Kontextfenster. Teurer als ältere Modelle.

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

translation-service-progress = "Fertig mit der Übersetzung von {$total} IDs unter Verwendung von {$model} in {$duration} mit {$apicalls} API-Aufrufen"

zzdocs-about = # Über Fluent AI

    {-brand} hilft Ihnen dabei, **Ihre Anwendungen mithilfe von KI zu lokalisieren**. Es verwendet OpenAI, um in wenigen Sekunden das zu erledigen, wofür ein ausgebildeter Übersetzer Wochen brauchen würde. Das **spart Ihnen Zeit und Geld**.

    {-brand} kann Ihre [Project Fluent](https://projectfluent.org/) Lokalisierungsdateien laden und bearbeiten und bietet einen praktischen Editor, mit dem Sie Ihre Übersetzungen Seite an Seite überprüfen und bearbeiten können.

    ## Wie benutze ich {-brand}?

    - Konfigurieren Sie Ihren OpenAI API-Schlüssel unter [{-settings}](/#page=Settings). Ohne einen Schlüssel funktionieren die KI-Übersetzungen nicht.
    - Laden Sie Ihre `.ftl`-Dateien im Abschnitt [{-manage-files}](/#page=Files), indem Sie sie in die Benutzeroberfläche ziehen und dort ablegen.
    - Oder laden Sie die. ftl-Dateien für Fluent AI, wenn Sie nur herumspielen möchten. Fluent AI ist natürlich lokalisiert, und das Herumspielen mit seinen ftl-Dateien ist ein großartiger Startpunkt.
    - Für jede Datei zeigt Ihnen die Anwendung die Anzahl fehlender Übersetzungen und bietet eine KI-unterstützte Übersetzung für diese an.
    - Sie können diese auch manuell mit dem [{-translation-editor}](/#page=Editor) bearbeiten, um Ihre Übersetzungsstrings zu bearbeiten oder einzelne Strings mit OpenAI zu übersetzen.

    ## Was ist Project Fluent und warum sollten Sie es verwenden?

    Mozilla hat es entwickelt, um die Lokalisierung von Produkten wie Firefox, Thunderbird usw. in Hunderte von Sprachen zu unterstützen. Project Fluent wurde mit Blick auf Flexibilität und Benutzerfreundlichkeit entworfen. Ihre Übersetzungen hängen von einer großen Benutzer-Community ab, die Beiträge liefert. Daher wollten sie dies so einfach wie möglich gestalten. Zusätzlich benötigten sie die Flexibilität, um mit verschiedenen grammatischen Variationen in Sprachen wie z.B. Geschlecht, Zeitform, Menge usw. umgehen zu können.

    Das Ergebnis, Project Fluent, ist ein einfaches und benutzerfreundliches Dateiformat und Syntax zur Definition von Übersetzungsdateien. Es bietet einige Vorteile gegenüber anderen Lösungen in diesem Bereich, wie z.B. properties-Dateien oder Bibliotheken wie gettext:

    - **Flexibilität.** Es unterstützt bedingte Logik und Variablen, die Sie in Ihren Übersetzungen verwenden können.
    - **Benutzerfreundlichkeit.** Es ist einfach und leicht zu verwenden und zu bearbeiten. Jede Datei mit Zeilen, die `key = translation` enthalten, ist eine gültige `ftl`-Datei.
    - **Portabilität.** Es gibt Bibliotheken, die das Unterstützen von Fluent-basierten Lokalisierungen in nativen, mobilen und Webanwendungen erleichtern.

    ## Einschränkungen von {-brand}

    - {-brand} überprüft derzeit nicht die Fluent-Syntax.
    - Es läuft in einem Browser, daher gibt es keinen direkten Zugriff auf das Dateisystem. Sie können jedoch Dateien in die Benutzeroberfläche ziehen und dort ablegen sowie geänderte Dateien aus der Benutzeroberfläche herunterladen. Bei genügend Interesse könnte ich möglicherweise einen Electron-Wrapper für {-brand} erstellen.
    - Es ist etwas anspruchsvoll in Bezug auf das Neuordnen und Bereinigen von Übersetzungen. Untersuchen Sie die Unterschiede sorgfältig, bevor Sie Änderungen an Ihren Lokalisierungsdateien übernehmen.
    - OpenAI ist gut, aber natürlich nicht fehlerfrei und manchmal liegt es einfach falsch. Zudem hat es möglicherweise nicht immer genug Kontext, um alles korrekt zu übersetzen. Sie sollten natürlich professionelle Übersetzer zur Überprüfung der Übersetzungen einsetzen. Allerdings trifft es oft den Nagel auf den Kopf.
    - Obwohl Sie Übersetzungen für Fluent AI selbst bearbeiten können, werden diese derzeit nicht in der Benutzeroberfläche neu geladen. Dies könnte ich später hinzufügen.
    - Derzeit wird nur OpenAI unterstützt. Bei Interesse könnte ich später weitere Modelle hinzufügen.
    - Das Übersetzen großer Dateien kann ziemlich viel Zeit in Anspruch nehmen.

    ## Fehler und Probleme

    Dieses Projekt ist kostenlos und Open Source und wird unter der MIT-Lizenz vertrieben.
    Das Hauptprojekt ist auf [Github](https://github.com/jillesvangurp/fluent-ai) verfügbar.
    Wenn Sie Hilfe benötigen, können Sie mich kontaktieren oder den [Issue Tracker](https://github.com/jillesvangurp/fluent-ai/issues) verwenden.

    ## Verwandte Projekte

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Multiplattform-Bibliothek, die ich und meine Kollegen für JVM/JS entwickelt haben und die es Ihnen erlaubt, ftl-Dateien in Ihren Kotlin-Anwendungen zu verwenden. Diese Browser-Anwendung nutzt diese Bibliothek.

    ## Weitersagen

    Software wie diese zu schreiben, ist viel Arbeit und kann oft undankbare Arbeit sein. Wenn Fluent AI für Sie nützlich ist, lassen Sie es andere wissen, damit auch sie davon profitieren können.

    - Twittern/bloggen Sie darüber.
    - Klicken Sie auf den Stern-Button auf [Github](https://github.com/jillesvangurp/fluent-ai).
    - Geben Sie mir Feedback.

    ## Credits

    Fluent AI wurde von [Jilles van Gurp](https://jillesvangurp.com) erstellt. Derzeit ist es kostenlos und Open Source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Meine Website
    - [@jillesvangurp@mastodon.world](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X