-brand = Fluent AI

busy-failure = Fehler
busy-initial-title = Übersetzen
busy-initial-message = Verwenden von OpenAI zum Übersetzen nach {$language}
busy-success = Übersetzung nach {$language} abgeschlossen

common-app-name = { -brand }
common-add = Hinzufügen
common-cancel = Abbrechen
common-clear = Löschen
common-confirm = OK
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

pages-editor = Übersetzungen bearbeiten
pages-files = Fluent-Dateien verwalten
pages-settings = Einstellungen
pages-about = Über

settings-open-ai-key = Ihren OpenAI-API-Schlüssel einstellen (notwendig für Übersetzungen)
settings-translation-language = Quellsprache für AI-Übersetzungen konfigurieren. Hinweis: Die Sprache wird anhand des Namens Ihrer FTL-Datei mit etwas Normalisierung abgeglichen. Standard ist en-US.

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

    Fluent AI hilft Ihnen bei der Lokalisierung Ihrer Anwendungen. Es kann Ihre [Project Fluent](https://projectfluent.org/) Lokalisierungsdateien laden und ermöglicht es Ihnen, Übersetzungen nebeneinander zu bearbeiten.

    Wichtiger ist, dass es eine eingebaute Unterstützung für die Nutzung von OpenAI zur Übersetzung Ihrer Lokalisierungen hat.

    ## Wie funktioniert es

    - Konfigurieren Sie Ihren OpenAI API-Schlüssel in den Einstellungen. Ohne diesen funktionieren die AI-Übersetzungen nicht.
    - Laden Sie Ihre `.ftl` Dateien im Dateibereich
    - Gehen Sie dann zum Editor, um Ihre Übersetzungstexte zu bearbeiten.

    ## Einschränkungen

    - Dies validiert derzeit nicht die Fluent-Syntax
    - Es läuft in einem Browser, daher gibt es keinen direkten Zugriff auf das Dateisystem. Sie können jedoch Dateien per Drag-and-Drop in die Benutzeroberfläche ziehen und geänderte Dateien aus der Benutzeroberfläche herunterladen.
    - Es ist etwas eigenwillig bei der Neuordnung aller Übersetzungen. Überprüfen Sie die Änderungen sorgfältig, bevor Sie Änderungen an Ihren Lokalisierungsdateien übernehmen.

    ## Fehler und Probleme

    Dieses Projekt ist frei und Open Source und wird unter der MIT-Lizenz verteilt. Wenn Sie Hilfe benötigen, kontaktieren Sie mich
    oder verwenden Sie den [Issue-Tracker](https://github.com/jillesvangurp/fluent-ai/issues).