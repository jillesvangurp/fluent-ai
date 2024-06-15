-about = Acerca de
-brand = Fluent AI
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
translation-editor-ai-translate = Traducir
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

translation-service-progress = Traducido {$completed} identificadores de {$total} utilizando {$model} usando {$apicalls} llamadas API. Tiempo transcurrido {$duration}.
translation-service-completed = Se ha completado la traducción de {$total} identificadores utilizando {$model} en {$duration} mediante {$apicalls} llamadas a la API

zzdocs-about = # Acerca de Fluent AI

    {-brand} te ayuda a **localizar tus aplicaciones usando IA**. Utiliza OpenAI para hacer en segundos
    lo que de otro modo llevaría semanas a un traductor cualificado. Esto **te ahorra tiempo y dinero**.

    {-brand} puede cargar y editar tus archivos de localización [Project Fluent](https://projectfluent.org/)
    y ofrece un editor conveniente para revisar y editar traducciones en paralelo.

    ## ¿Cómo utilizo {-brand}?

    - Configura tu clave API de OpenAI en la sección de [{-settings}](/#page=Settings). Sin una clave, las traducciones de IA no funcionarán.
    - Carga tus archivos `.ftl` en la sección [{-manage-files}](/#page=Files) arrastrándolos y soltándolos en la interfaz de usuario.
    - O carga los archivos ftl para Fluent AI si solo quieres experimentar. Fluent AI, por supuesto, está localizado y jugar con sus archivos ftl es una excelente manera de comenzar.
    - Para cada archivo, te mostrará el número de traducciones faltantes y ofrecerá una traducción asistida por IA para estas.
    - También puedes editarlas manualmente con el [{-translation-editor}](/#page=Editor) para editar tus cadenas de traducción o traducir cadenas individuales con OpenAI.

    ## ¿Qué es Project Fluent y por qué deberías utilizarlo?

    Inventado por Mozilla para apoyar la localización de productos como Firefox, Thunderbird, etc. a cientos de idiomas,
    Project Fluent está diseñado con flexibilidad y usabilidad en mente. Sus traducciones dependen
    de una gran comunidad de usuarios contribuyendo con traducciones. Por lo tanto, querían hacer esto lo más fácil
    posible. Adicionalmente, necesitaban la flexibilidad para manejar varias variaciones gramaticales
    en los idiomas, por ejemplo, género, tiempo, cantidad, etc.

    El resultado, project fluent, es un formato de archivo y una sintaxis simples y fáciles de usar para definir archivos de traducción. Proporciona algunos beneficios
    sobre otras soluciones en este espacio basadas en archivos de propiedades o bibliotecas como gettext:

    - **Flexibilidad.** Soporta lógica condicional y variables que puedes usar en tus traducciones.
    - **Facilidad de uso.** Es simple y fácil de usar y editar. Cualquier archivo con líneas que contengan `key = translation` es un archivo `ftl` válido.
    - **Portabilidad.** Hay bibliotecas que hacen que el soporte para localizaciones basadas en Fluent sea fácil en aplicaciones nativas, móviles y web.

    ## Limitaciones de {-brand}

    - {-brand} actualmente no valida la sintaxis de fluent.
    - Funciona en un navegador, por lo que no hay acceso directo al sistema de archivos. Sin embargo, puedes arrastrar y soltar archivos en la interfaz de usuario y descargar archivos modificados desde la interfaz de usuario. Si hay suficiente interés, podría crear una envoltura de Electron para {-brand} en algún momento.
    - Es un poco estricto sobre el reordenamiento y la limpieza de traducciones. Examina cuidadosamente las diferencias antes de confirmar los cambios en tus archivos de localización.
    - OpenAI es bueno, pero por supuesto no es perfecto y a veces se equivoca. Además, puede que no siempre tenga suficiente contexto para traducir todo correctamente. Deberías, por supuesto, usar traductores profesionales para revisar las traducciones. Sin embargo, acierta bastantes veces.
    - Aunque puedes editar las traducciones para Fluent AI mismo, actualmente no las recarga en la interfaz de usuario. Podría agregar esto más adelante.
    - Actualmente solo se soporta OpenAI. Si hay interés, podría agregar más modelos más adelante.
    - Traducir archivos grandes puede llevar bastante tiempo.

    ## Errores e incidencias

    Este proyecto es gratuito y de código abierto y se distribuye bajo la licencia MIT.
    El proyecto principal está disponible en [Github](https://github.com/jillesvangurp/fluent-ai).
    Si necesitas ayuda, contáctame
    o usa el [tracker de incidencias](https://github.com/jillesvangurp/fluent-ai/issues).

    ## Proyectos relacionados

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - Biblioteca multiplataforma que mis colegas y yo desarrollamos para jvm/js que permite usar archivos ftl en tus aplicaciones Kotlin. Esta aplicación del navegador la usa.

    ## Difundir la palabra

    Escribir software como este requiere mucho trabajo y a menudo puede ser un trabajo ingrato. Si Fluent AI te resulta útil, házselo saber a otros para que también puedan beneficiarse.

    - Twitea, publica o escribe en un blog sobre ello.
    - Haz clic en el botón de estrella en [Github](https://github.com/jillesvangurp/fluent-ai).
    - Dame tu opinión.

    ## Créditos

    Fluent AI es creado por [Jilles van Gurp](https://jillesvangurp.com). Actualmente es gratuito y de código abierto.

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - Mi sitio web
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X