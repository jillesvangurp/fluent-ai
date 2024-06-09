-brand = Fluent AI

busy-failure = Erreur
busy-initial-title = Traduction
busy-initial-message = Utilisation de OpenAI pour traduire en {$language}
busy-success = Terminé la traduction en {$language}

common-app-name = { -brand }
common-hide = Cacher {$content}
common-show = Montrer {$content}
common-add = Ajouter
common-cancel = Annuler
common-clear = Effacer
common-confirm = D'accord
common-delete = Supprimer
common-download = Télécharger
common-filter-placeholder = Filtrer la liste
common-save = Enregistrer

confirmation-dialog-no = Non
confirmation-dialog-yes = Oui
confirmation-dialog-default-description = Si vous cliquez sur oui, l'action sera exécutée.
confirmation-dialog-default-question = Êtes-vous sûr ?

cookies-welcome = Bienvenue à {-brand}
cookies-disclaimer = Ce site web utilise le stockage local du navigateur pour stocker le contenu JSON
        que vous créez dans l'application. Ces informations ne sont jamais partagées ailleurs.
        Pour utiliser cette application, vous devez accepter l'utilisation du stockage local.
cookies-header = Cookies & autorisations

file-loader-add-new = Créer ou ajouter des fichiers ftl
file-loader-clear-confirmation = Ceci supprimera tous les fichiers et modifications en cours. Assurez-vous d'avoir téléchargé tout ce qui vous importe.
file-loader-create-new-file = Créer un nouveau fichier ftl
file-loader-delete-file-confirmation = Cela supprimera { $file }.
file-loader-drag-and-drop = Faites glisser les fichiers ftl ici pour les charger
file-loader-files-header = Vos Fichiers Fluent
file-loader-load-own-ftls = Charger des fichiers ftl pour { -brand }
file-loader-load-own-ftls-confirmation = Cela supprimera tous les fichiers et modifications actuels et les remplacera par les fichiers ftl pour { -brand }. Assurez-vous d'avoir téléchargé tout ce qui vous importe.
file-loader-no-files-yet-cta = Vous n'avez pas encore de fichiers ftl. Créez-en un nouveau ou glissez-en un existant dans l'application.

file-loader-translate-missing = Ajouter les traductions manquantes avec OpenAI
file-loader-translate-missing-confirmation = Ajouter {$number_translations} traductions manquantes avec OpenAI. Notez qu'un grand nombre de traductions peut prendre du temps et, bien sûr, vous coûter des jetons.

language-select-select-language = Sélectionnez la langue de l'interface utilisateur

pages-about = À propos
pages-editor = Modifier les traductions
pages-files = Gérer les fichiers Fluent
pages-settings = Paramètres

settings-open-ai-key = Définissez votre clé API OpenAI (nécessaire pour les traductions)
settings-translation-language = Configurez la langue source pour les traductions par IA. Notez que la langue est comparée au nom de votre fichier ftl avec une certaine normalisation. Par défaut, en-US.

translation-editor-ai-translate = Translater avec gpt-4o
translation-editor-configure-key = Configurez une clé API OpenAI dans les paramètres
translation-editor-delete-this-id = Supprimer cette identité de traduction
translation-editor-delete-this-id-confirmation = Cela supprimera l'identifiant de traduction de tous les fichiers chargés. Laissez la définition vide si vous souhaitez simplement supprimer une traduction spécifique.
translation-editor-new-translation = Traduction par défaut
translation-editor-new-translation-id = ID de traduction
translation-editor-new-translation-id-header = Créer une nouvelle définition de traduction
translation-editor-no-translation-id-selected = Sélectionnez un identifiant de langue à gauche pour modifier la traduction.
translation-editor-translate-using-open-ai = Traduire avec OpenAI

zzdocs-about = # À propos de Fluent AI

    Fluent AI vous aide à localiser vos applications. Il peut charger et éditer vos fichiers de localisation [Project Fluent](https://projectfluent.org/) et les traduire dans différentes langues en utilisant l'IA.

    ## Comment ça marche

    - Configurez votre clé API OpenAI dans les paramètres. Sans cela, les traductions par IA ne fonctionneront pas.
    - Chargez vos fichiers `.ftl` dans la section des fichiers en les glissant-déposant dans l'interface utilisateur.
    - Ou chargez les fichiers ftl pour Fluent AI si vous voulez juste vous amuser.
    - Pour chaque fichier, il vous montrera le nombre de traductions manquantes et proposera de traduire celles qui manquent.
    - Vous pouvez également les éditer manuellement avec l'éditeur pour modifier vos chaînes de traduction ou traduire des chaînes individuelles avec OpenAI.

    ## Limitations

    - Fluent AI ne valide actuellement pas la syntaxe fluide
    - Il fonctionne dans un navigateur donc il n'y a pas d'accès direct au système de fichiers. Cependant, vous pouvez glisser-déposer des fichiers dans l'interface utilisateur et télécharger les fichiers modifiés depuis l'interface utilisateur.
    - Il est un peu pointilleux sur le réordonnancement de toutes les traductions, examinez attentivement les différences avant de valider les modifications dans vos fichiers de localisation.
    - OpenAI est bon mais pas infaillible et parfois il se trompe. De plus, il peut ne pas avoir suffisamment de contexte pour traduire correctement tout.
    - Bien que vous puissiez éditer les traductions pour Fluent AI lui-même, il ne les recharge pas actuellement dans l'interface utilisateur. Je pourrais ajouter cela plus tard.

    ## Bugs et problèmes

    Ce projet est gratuit et open source et distribué sous licence MIT.
    Le projet principal est disponible sur [Github](https://github.com/jillesvangurp/fluent-ai).
    Si vous avez besoin d'aide, contactez-moi
    ou utilisez le [suivi des problèmes](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Crédits

    Fluent AI a été créé par [Jilles van Gurp](https://jillesvangurp.com).