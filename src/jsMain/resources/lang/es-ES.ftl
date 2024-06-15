-about = Acerca de
-manage-files = Gestionar archivos Fluent
-settings = Ajustes
-translation-editor = Editor de traducción

busy-initial-title = Traduciendo
busy-initial-message = Usando OpenAI para traducir a {$language}

busy-success = Traducción a {$language} completada

common-add = Añadir
common-cancel = Cancelar
common-clear = Limpiar
common-filter-placeholder = Filtrar la lista
common-save = Guardar
common-delete = Eliminar
common-download = Descargar
common-hide = Ocultar {$content}
common-show = Mostrar {$content}

confirmation-dialog-yes = Sí
confirmation-dialog-default-question = ¿Estás seguro?
confirmation-dialog-default-description = Si haces clic en sí, la acción se ejecutará.
confirmation-dialog-no = No

cookies-disclaimer = Este sitio web utiliza el almacenamiento local del navegador para almacenar contenido json
        que creas en la aplicación. Esta información nunca se comparte en otro lugar.
        Para utilizar esta aplicación, debes aceptar el uso del almacenamiento local.
cookies-header = Cookies y permisos
cookies-welcome = Bienvenido a {-brand}

file-loader-clear-confirmation = Esto eliminará cualquier archivo actual y ediciones. Asegúrate de haber descargado todo lo que te importe.
file-loader-delete-file-confirmation = Esto eliminará { $file }.
file-loader-files-header = Tus archivos Fluent
file-loader-drag-and-drop = Arrastra aquí los archivos ftl para cargarlos
file-loader-load-own-ftls = Cargar archivos ftl para { -brand }
file-loader-load-own-ftls-confirmation = Esto eliminará cualquier archivo o edición actual y los reemplazará con los archivos ftl para { -brand }. Asegúrate de haber descargado todo lo que te importe.
file-loader-add-new = Crear o añadir archivos ftl
file-loader-create-new-file = Crear nuevo archivo ftl
file-loader-no-files-yet-cta = Aún no tienes archivos ftl. Crea uno nuevo o arrastra los existentes a la aplicación.
file-loader-translate-missing = Añadir faltantes con OpenAI
file-loader-translate-missing-confirmation = Añadir {$number_translations} traducciones faltantes con OpenAI. Nota: una gran cantidad de traducciones puede llevar un tiempo y, por supuesto, te costará algunos tokens.

language-select-select-language = Selecciona el idioma de la interfaz

settings-edit-open-ai-key = Configurar la clave de API de OpenAI
settings-open-ai-key = Establecer tu clave de API de OpenAI (necesaria para traducciones)
settings-translation-language = Configurar idioma de origen para traducciones de IA. Tenga en cuenta que el idioma se compara con el nombre de su archivo ftl con alguna normalización. Por defecto es en-US.

supported-models-gpt-4-o = Modelo más capaz, ventana de contexto grande. Más costoso que los modelos anteriores.
supported-models-gpt-35-turbo = Modelo anterior pero aún adecuado para traducciones. Menor costo por token.

translation-editor-add-translation-id = Crear nuevo ID de traducción
translation-editor-ai-translate = Traducir usando gpt-4o
translation-editor-configure-key = Configurar una clave de API de OpenAI en la configuración
translation-editor-delete-this-id = Eliminar este ID de traducción
translation-editor-delete-this-id-confirmation = Esto eliminará el ID de traducción de todos los archivos cargados. Establezca la definición como vacía si solo desea eliminar una traducción específica.
translation-editor-no-translation-id-selected = Seleccione un ID de idioma a la izquierda para editar la traducción.
translation-editor-new-translation-id-header = Crear una nueva definición de traducción
translation-editor-new-translation-id = ID de traducción
translation-editor-new-translation = Traducción por defecto
translation-editor-no-files-cta = Necesita al menos un archivo de traducción para editar. Vaya a [{ -manage-files }](/#page=Files) y cree o añada algunos archivos de traducción.
translation-editor-translate-using-open-ai = Traducir usando OpenAI
translation-editor-number-of-keys = Total {$amount}

translation-service-progress = "Traducidos {$total} identificadores utilizando {$model} en {$duration} usando {$apicalls} llamadas a la API"

zzdocs-about = # Acerca de Fluent AI

    {-brand} te ayuda a **localizar tus aplicaciones utilizando IA**. Utiliza OpenAI para hacer en segundos
    lo que de otro modo tomaría semanas a un traductor entrenado. Esto te **ahorra tiempo y dinero**.

    {-brand} puede cargar y editar tus archivos de localización de [Project Fluent](https://projectfluent.org/)
    y ofrece un editor conveniente para revisar y editar traducciones para tus traducciones lado a lado.

    ## ¿Cómo utilizo {-brand}?

    - Configura tu clave de API de OpenAI en [{-settings}](/#page=Settings). Sin una clave, las traducciones de IA no funcionarán.
    - Carga tus archivos `.ftl` en la sección de [{-manage-files}](/#page=Files) arrastrándolos y soltándolos en la interfaz de usuario.
    - O carga los archivos ftl para Fluent AI si solo quieres experimentar. Por supuesto, Fluent AI está localizado y jugar con sus archivos ftl es una excelente manera de empezar.
    - Para cada archivo, te mostrará el número de traducciones faltantes y ofrecerá una traducción asistida por IA para estas.
    - También puedes editarlas manualmente con el [{-translation-editor}](/#page=Editor) para editar tus cadenas de traducción o traducir cadenas individuales con OpenAI.

    ## ¿Qué es project Fluent y por qué deberías usarlo?

    Inventado por Mozilla para soportar la localización de productos como Firefox, Thunderbird, etc. a cientos de idiomas,
    Project Fluent está diseñado con flexibilidad y usabilidad en mente. Sus traducciones dependen de
    una gran comunidad de usuarios que contribuyen con traducciones. Por lo tanto, querían facilitar esto
    tanto como sea posible. Además, necesitaban la flexibilidad para tratar con varias variaciones gramaticales
    en los idiomas, por ejemplo, género, tiempo, cantidad, etc.

    El resultado, project Fluent, es un formato de archivo y sintaxis simple y fácil de usar para definir archivos de traducción. Proporciona varios beneficios
    sobre otras soluciones en este espacio basadas en, por ejemplo, archivos de propiedades o bibliotecas como gettext:

    - **Flexibilidad.** Acepta lógica condicional y variables que puedes utilizar en tus traducciones.
    - **Facilidad de uso.** Es simple y fácil de usar y editar. Cualquier archivo con líneas que contengan `clave = traducción` es un archivo `ftl` válido.
    - **Portabilidad.** Hay bibliotecas que facilitan el soporte de localizaciones basadas en Fluent en aplicaciones nativas, móviles y web.

    ## Limitaciones de {-brand}

    - {-brand} actualmente no valida la sintaxis de Fluent.
    - Funciona en un navegador, por lo que no hay acceso directo al sistema de archivos. Sin embargo, puedes arrastrar y soltar archivos en la interfaz de usuario y descargar archivos modificados desde la interfaz de usuario. Si hay suficiente interés, es posible que en algún momento cree un contenedor Electrón para {-brand}.
    - Es un poco dogmático acerca de reordenar y limpiar traducciones. Eliminará traducciones idénticas a la traducción base, por ejemplo. Examina cuidadosamente las diferencias antes de confirmar los cambios en tus archivos de localización.
    - OpenAI es bueno pero, por supuesto, no es infalible y a veces se equivoca. Además, a veces puede no tener suficiente contexto para traducir correctamente todo. Deberías, por supuesto, usar traductores profesionales para revisar las traducciones. Sin embargo, a menudo lo hace bastante bien.
    - Si bien puedes editar traducciones para el propio Fluent AI, actualmente no las recarga en la interfaz de usuario. Puede que añada esto más adelante.
    - El modelo y el proveedor de IA están actualmente cableados. Soy consciente de otras soluciones en este espacio y podría admitir modelos adicionales; incluso potencialmente locales en ejecución más adelante. Sin embargo, en la actualidad, OpenAI parece ser el mejor en su clase y es lo suficientemente económico.
    - Traducir archivos grandes puede llevar bastante tiempo.

    ## Bugs y problemas

    Este proyecto es gratuito y de código abierto, distribuido bajo la licencia MIT.
    El proyecto principal está disponible en [Github](https://github.com/jillesvangurp/fluent-ai).
    Si necesitas ayuda, avísame
    o utiliza el [rastreador de problemas](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Proyectos relacionados

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Biblioteca multipropósito que mis colegas y yo desarrollamos para jvm/js que te permite usar archivos ftl en tus aplicaciones Kotlin. Esta aplicación de navegador lo utiliza.

    ## Corre la voz

    Escribir software como este es mucho trabajo y a menudo puede ser un trabajo ingrato. Si Fluent AI te resulta útil, házselo saber a otros para que también puedan beneficiarse.

    - Tuitea / tootea / bloguea sobre ello.
    - Haz clic en el botón de estrella en [Github](https://github.com/jillesvangurp/fluent-ai).
    - Dame algún feedback.

    ## Créditos

    Fluent AI ha sido creado por [Jilles van Gurp](https://jillesvangurp.com). Actualmente es gratuito y de código abierto.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Mi sitio web
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X