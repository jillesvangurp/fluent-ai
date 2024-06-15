-about = このアプリについて
-brand = Fluent AI
-manage-files = Fluentファイルの管理
-settings = 設定
-translation-editor = 翻訳エディタ

busy-failure = エラー
busy-initial-title = 翻訳中
busy-initial-message = OpenAIを使用して{$language}に翻訳しています
busy-success = {$language}への翻訳が完了しました

common-app-name = { -brand }
common-add = 追加
common-cancel = キャンセル
common-clear = クリア
common-confirm = OK
common-filter-placeholder = リストを絞り込む
common-save = 保存
common-delete = 削除
common-download = ダウンロード
common-hide = {$content}を隠す
common-show = {$content}を表示

confirmation-dialog-yes = はい
confirmation-dialog-no = いいえ
confirmation-dialog-default-question = よろしいですか？
confirmation-dialog-default-description = 「はい」をクリックすると、この操作が実行されます。

cookies-disclaimer = このウェブサイトは、ブラウザのローカルストレージを使用してアプリ内で作成したjsonコンテンツを保存します。この情報は他の場所で共有されることはありません。このアプリを使用するには、ローカルストレージの使用に同意する必要があります。
cookies-header = クッキー & 許可
cookies-welcome = {-brand}へようこそ

file-loader-clear-confirmation = これにより、現在のファイルと編集内容がすべて削除されます。必要なものがすべてダウンロードされているか確認してください。
file-loader-delete-file-confirmation = これにより、{$file} が削除されます。
file-loader-files-header = あなたのFluentファイル
file-loader-drag-and-drop = ここにftlファイルをドラッグして読み込んでください
file-loader-load-own-ftls = { -brand }用のftlファイルを読み込む
file-loader-load-own-ftls-confirmation = これは現在のファイルと編集内容を削除し、{ -brand }のftlファイルと置き換えます。気になるものをダウンロードしているか確認してください。
file-loader-add-new = ftlファイルを作成または追加
file-loader-create-new-file = 新しいftlファイルを作成
file-loader-no-files-yet-cta = まだftlファイルはありません。新しいものを作成するか、既存のものをアプリにドラッグしてください。
file-loader-translate-missing = 欠けている部分をOpenAIで追加
file-loader-translate-missing-confirmation = 欠けている{$number_translations}の翻訳をOpenAIで追加します。注：大量の翻訳には時間がかかる場合があり、もちろんトークンが必要です。

language-select-select-language = UIの言語を選択

pages-editor = { -translation-editor }
pages-files = { -manage-files }
pages-settings = { -settings }
pages-about = { -about }

settings-edit-open-ai-key = OpenAI APIキーを設定
settings-open-ai-key = OpenAI APIキーを設定 (翻訳には必要です)
settings-translation-language = AI 翻訳のソース言語を設定します。言語は ftl ファイル名に対して標準化される場合があります。デフォルトは en-US です。

supported-models-gpt-4-o = 最も高性能なモデル、大きなコンテキストウィンドウ。古いモデルよりもコストが高いです。
supported-models-gpt-35-turbo = 古いモデルですが、翻訳には十分です。トークンのコストが低いです。

translation-editor-add-translation-id = 新しい翻訳 ID を作成
translation-editor-ai-translate = 翻訳する
translation-editor-configure-key = 設定で OpenAI API キーを設定
translation-editor-delete-this-id = この翻訳 ID を削除
translation-editor-delete-this-id-confirmation = これはすべての読み込まれたファイルから翻訳 ID を削除します。特定の翻訳だけを削除する場合は、定義を空に設定してください。
translation-editor-no-translation-id-selected = 左側で言語 ID を選択して翻訳を編集してください。
translation-editor-new-translation-id-header = 新しい翻訳の定義を作成
translation-editor-new-translation-id = 翻訳 ID
translation-editor-new-translation = デフォルトの翻訳
translation-editor-no-files-cta = 編集するには少なくとも1つの翻訳ファイルが必要です。[{ -manage-files }](/#page=Files)に移動して、翻訳ファイルを作成または追加してください。
translation-editor-number-of-keys = 合計 {$amount}
translation-editor-translate-using-open-ai = OpenAI を使用して翻訳

translation-service-progress = {$model} を使用して {$total} 中 {$completed} 個のIDを翻訳しました。API コール数: {$apicalls}。経過時間: {$duration}。
translation-service-completed = {$model} を使用して {$total} 個のIDを翻訳しました。所要時間: {$duration}。API コール数: {$apicalls}。

zzdocs-about = # Fluent AI について

    {-brand} は**AI を使用してアプリケーションをローカライズする**ものです。OpenAI を使用して、通常なら翻訳者に数週間かかる作業を数秒で行います。これにより、**時間とお金を節約**できます。

    - 新しい言語をサポートするのは簡単で、単に新しい言語を追加し、OpenAI に任せればよい。
    - 異なる言語の翻訳を並行して簡単に編集できる。
    - 欠落している翻訳を簡単に特定し、AI を使用して修正できる。
    - 一般的なプレフィックスで翻訳を整理し、構成する。

    {-brand} は [Project Fluent](https://projectfluent.org/) のローカライゼーションファイルをサポートしています。

    ## {-brand} の使い方

    - [{-settings}](/#page=Settings) で OpenAI API キーを設定してください。キーがなければ AI 翻訳は機能しません。
    - [{-manage-files}](/#page=Files) セクションで `.ftl` ファイルを UI にドラッグアンドドロップすることで読み込みます。
    - あるいは、Fluent AI の ftl ファイルを読み込んで遊びたい場合も読み込めます。Fluent AI 自体がローカライズされており、その ftl ファイルで遊ぶのは良い出発点です。
    - 各ファイルには欠落している翻訳の数が表示され、これに対する AI アシストの翻訳が提供されます。
    - また、 [{-translation-editor}](/#page=Editor) を使用して翻訳文字列を手動で編集したり、OpenAI を使って個々の文字列を翻訳することもできます。

    ## Project Fluent とは何か、なぜ使うべきか？

    Mozilla が Firefox や Thunderbird などの製品を数百の言語にローカライズするために開発し、
    柔軟性と使いやすさを考慮して設計されました。翻訳は多くのユーザーコミュニティによって貢献されているため、
    これをできるだけ簡単に行えるようにすることが求められました。また、性別、時制、数量などの
    言語の文法的な変化に対応する柔軟性が必要でした。

    結果としての project Fluent は、翻訳ファイルを定義するためのシンプルで使いやすいファイル形式と構文を提供します。
    その他の解決策に比べていくつかの利点があります。例えば:
    
    - **柔軟性。** 条件付きロジックや変数を使用した翻訳をサポートします。
    - **使いやすさ。** シンプルで、使いやすく、編集が簡単です。`key = translation` という行を含むファイルは全て有効な `ftl` ファイルです。さらに、複数行の文字列やマークダウンなども使用できます。
    - **移植性。** ネイティブ、モバイル、ウェブアプリケーションで Fluent ベースのローカライゼーションをサポートするライブラリが存在します。

    ## {-brand} の制限

    - {-brand} は現時点で fluent 構文を検証しません。
    - ブラウザで実行されるため、直接的なファイルシステムアクセスはありません。しかし、UI にファイルをドラッグアンドドロップしてファイルを読み込め、UI から修正されたファイルをダウンロードすることができます。十分な需要があれば、{-brand} 用の Electron ラッパーを作成するかもしれません。
    - 翻訳の再整理やクリーンアップには独自の意見があります。ローカライゼーションファイルに変更をコミットする前に、差分を慎重に確認してください。
    - OpenAI は優れていますが、もちろん完璧ではないため、時々間違えることがあります。また、常に十分な文脈を持って正しく翻訳できるわけではありません。翻訳をレビューするためにプロの翻訳者を使用するべきです。ただし、かなりの頻度でうまくいきます。
    - OpenAI が指示を無視して誤った内容を生成したり、新しい変数を作り出してしまうことがあります。最良の結果を得るには gp4-4o を使用してください。これが一貫して良い結果を生むことが多いです。
    - Fluent AI 自体の翻訳を編集できますが、それを UI に再読み込みすることは現時点ではできません。後で追加するかもしれません。
    - 現在サポートされているのは OpenAI のみです。需要があれば他のモデルを追加するかもしれません。
    - 大きなファイルの翻訳にはかなりの時間がかかることがあります。

    ## バグと問題

    このプロジェクトは MIT ライセンスで無料およびオープンソースで提供されています。
    メインプロジェクトは [Github](https://github.com/jillesvangurp/fluent-ai) で利用可能です。
    助けが必要な場合は私に連絡するか、[issue tracker](https://github.com/jillesvangurp/fluent-ai/issues) を使用してください。

    ## 関連プロジェクト

    - [Fluent-Kotlin](https://github.com/formation-res/fluent-kotlin) - JVM/JS 用に開発されたマルチプラットフォームライブラリで、Kotlin アプリケーションで ftl ファイルを使用できるようにします。このブラウザーアプリケーションもそれを使用しています。

    ## 広めてください

    このようなソフトウェアを書くことは多くの労力を要し、しばしば報われない作業です。Fluent AI が役立つ場合は、他の人に知らせてください。彼らも恩恵を受けることができます。

    - 小鳥のさえずり / toot / ブログで共有する。
    - [Github](https://github.com/jillesvangurp/fluent-ai) でスターを押す。
    - フィードバックをください。

    ## クレジット

    Fluent AI は [Jilles van Gurp](https://jillesvangurp.com) によって作成されました。現在、無料およびオープンソースです。

    - [www.jillesvangurp.com](https://www.jillesvangurp.com) - 私のサイト
    - [@jillesvangurp@mastodon.world ](https://mastodon.world/deck/@jillesvangurp) - Mastodon
    - [@jillesvangurp](https://twitter.com/jillesvangurp) - Twitter/X