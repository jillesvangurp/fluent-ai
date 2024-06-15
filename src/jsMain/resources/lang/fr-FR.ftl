-about = À propos
-brand = Fluent AI
-manage-files = Gérer les fichiers Fluent
-settings = Paramètres
-translation-editor = Éditeur de traduction

busy-failure = Erreur
busy-initial-title = Traduction
busy-initial-message = Utilisation de OpenAI pour traduire en {$language}
busy-success = Terminé la traduction en {$language}

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

settings-open-ai-key = Définissez votre clé API OpenAI (nécessaire pour les traductions)
settings-translation-language = Configurez la langue source pour les traductions par IA. Notez que la langue est comparée au nom de votre fichier ftl avec une certaine normalisation. Par défaut, en-US.
settings-edit-open-ai-key = Configurez la clé API OpenAI

supported-models-gpt-35-turbo = Un modèle plus ancien mais toujours adéquat pour les traductions. Coût en jetons inférieur.
supported-models-gpt-4-o = Modèle le plus performant, fenêtre de contexte plus grande. Plus coûteux que les modèles plus anciens.

translation-editor-add-translation-id = Créer un nouvel identifiant de traduction
translation-editor-no-files-cta = Vous avez besoin d'au moins un fichier de traduction pour éditer. Allez à [{ -manage-files }](/#page=Files) et créez ou ajoutez des fichiers de traduction.
translation-editor-ai-translate = Translater avec gpt-4o
translation-editor-configure-key = Configurez une clé API OpenAI dans les paramètres
translation-editor-delete-this-id = Supprimer cette identité de traduction
translation-editor-delete-this-id-confirmation = Cela supprimera l'identifiant de traduction de tous les fichiers chargés. Laissez la définition vide si vous souhaitez simplement supprimer une traduction spécifique.
translation-editor-new-translation = Traduction par défaut
translation-editor-new-translation-id = ID de traduction
translation-editor-new-translation-id-header = Créer une nouvelle définition de traduction
translation-editor-no-translation-id-selected = Sélectionnez un identifiant de langue à gauche pour modifier la traduction.
translation-editor-translate-using-open-ai = Traduire avec OpenAI
translation-editor-number-of-keys = Total {$amount}

translation-service-progress = J'ai fini de traduire {$total} IDs en utilisant {$model} en {$duration} en effectuant {$apicalls} appels API

zzdocs-about = # À propos de Fluent AI

    {-brand} vous aide à **localiser vos applications en utilisant l'IA**. Il utilise OpenAI pour accomplir en quelques secondes ce qu'un traducteur expérimenté prendrait des semaines à faire. Cela **vous fait économiser du temps et de l'argent**.

    {-brand} peut charger et éditer vos fichiers de localisation [Project Fluent](https://projectfluent.org/) et propose un éditeur pratique pour examiner et éditer les traductions côte à côte.

    ## Comment utiliser {-brand} ?

    - Configurez votre clé API OpenAI dans les [{-settings}](/#page=Settings). Sans une clé, les traductions IA ne fonctionneront pas.
    - Chargez vos fichiers `.ftl` dans la section [{-manage-files}](/#page=Files) en les glissant-déposant dans l'interface utilisateur.
    - Ou chargez les fichiers `.ftl` pour Fluent AI si vous voulez simplement vous amuser. Fluent AI est bien sûr localisé et jouer avec ses fichiers `.ftl` est un excellent moyen de commencer.
    - Pour chaque fichier, il vous montrera le nombre de traductions manquantes et proposera une traduction assistée par IA pour celles-ci.
    - Vous pouvez également les éditer manuellement avec le [{-translation-editor}](/#page=Editor) pour éditer vos chaînes de traduction ou traduire des chaînes individuelles avec OpenAI.

    ## Qu'est-ce que Project Fluent et pourquoi l'utiliser ?

    Inventé par Mozilla pour soutenir la localisation de produits comme Firefox, Thunderbird, etc. vers des centaines de langues, Project Fluent est conçu avec flexibilité et facilité d'utilisation à l'esprit. Leurs traductions dépendent d'une grande communauté d'utilisateurs contribuant aux traductions. Ils voulaient donc rendre cela aussi simple que possible. De plus, ils avaient besoin de la flexibilité pour gérer diverses variations grammaticales dans les langues, par exemple le genre, le temps, la quantité, etc.

    Le résultat, project fluent, est un format de fichier et une syntaxe simples et faciles à utiliser pour définir des fichiers de traduction. Il offre quelques avantages par rapport à d'autres solutions dans ce domaine basées sur, par exemple, des fichiers de propriétés ou des bibliothèques comme gettext :

    - **Flexibilité.** Il prend en charge la logique conditionnelle et les variables que vous pouvez utiliser dans vos traductions.
    - **Facilité d'utilisation.** C'est simple et facile à utiliser et à éditer. Tout fichier avec des lignes contenant `key = translation` est un fichier `ftl` valide
    - **Portabilité.** Il existe des bibliothèques qui facilitent le support des localisations basées sur Fluent dans les applications natives, mobiles et web.

    ## Limitations de {-brand}

    - {-brand} ne valide actuellement pas la syntaxe Fluent.
    - Il fonctionne dans un navigateur, il n'y a donc pas d'accès direct au système de fichiers. Cependant, vous pouvez glisser et déposer des fichiers dans l'interface utilisateur et télécharger les fichiers modifiés depuis l'interface utilisateur. Si l'intérêt est suffisant, je pourrais à un moment donné créer un wrapper Electron pour {-brand}.
    - Il est un peu opiniâtre en ce qui concerne le réarrangement et le nettoyage des traductions. Examinez attentivement les différences avant de valider les modifications dans vos fichiers de localisation.
    - OpenAI est bon mais bien sûr pas infaillible et parfois il se trompe. De plus, il peut ne pas toujours avoir suffisamment de contexte pour tout traduire correctement. Vous devriez bien sûr utiliser des traducteurs professionnels pour vérifier les traductions. Cependant, il réussit assez souvent.
    - Bien que vous puissiez éditer les traductions pour Fluent AI lui-même, il ne les recharge actuellement pas dans l'interface utilisateur. Je pourrais ajouter cela plus tard.
    - Actuellement, seul OpenAI est pris en charge. S'il y a de l'intérêt, je pourrais ajouter d'autres modèles plus tard.
    - La traduction de fichiers volumineux peut prendre beaucoup de temps.

    ## Bugs et problèmes

    Ce projet est gratuit et open source et distribué sous la licence MIT.
    Le projet principal est disponible sur [Github](https://github.com/jillesvangurp/fluent-ai).
    Si vous avez besoin d'aide, contactez-moi
    ou utilisez le [suivi des problèmes](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Projets liés

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Bibliothèque multiplateforme que mes collègues et moi avons développée pour jvm/js et qui vous permet d'utiliser des fichiers `.ftl` dans vos applications Kotlin. Cette application de navigateur l'utilise.

    ## Faites passer le mot

    Écrire des logiciels comme celui-ci demande beaucoup de travail et c'est souvent un travail ingrat. Si Fluent AI vous est utile, faites-le savoir aux autres pour qu'ils puissent aussi en bénéficier.

    - Tweetez / postez / bloguez à ce sujet.
    - Appuyez sur le bouton étoile sur [Github](https://github.com/jillesvangurp/fluent-ai).
    - Donnez-moi des retours.

    ## Crédits

    Fluent AI est créé par [Jilles van Gurp](https://jillesvangurp.com). Actuellement, il est gratuit et open source.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Mon site web
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X