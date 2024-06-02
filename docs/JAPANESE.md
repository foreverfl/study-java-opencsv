# opencsv 5.9 API

- opencsv を使う簡単な方法をまとめた資料です。
- 目次は[公式ドキュメントの packages](https://javadoc.io/doc/com.opencsv/opencsv/latest/index.html)です。
- 各 package を使う基本的な方法についてのみまとめてみました。具体的なメソッドの使い方は一人で公式ドキュメントを見て行うようにしましょう。
- サンプルコードおよび翻訳は「Claude3 Opus」および「GPT 4o」を活用しました。
- サンプルデータは次の通りで、使うときはサンプルコードと同じパスに csv ファイルを作成してください。

```plaintext
"Category","Subcategory","Topic","Question","Answer"
"Java","Basics","Variables","Javaで変数を宣言する方法は何ですか?","Javaでは変数宣言時にデータ型を明示する必要があります。例えば、int num = 10; のように宣言します。"
"Java","Control Flow","Loops","Javaでforループを使う方法は何ですか?","Javaでforループはfor (初期化; 条件式; 増減式) { 実行するコード } 形式で使われます。"
"Ruby","Basics","Variables","Rubyで変数を宣言する方法は何ですか?","Rubyでは変数の前に$をつけずにそのまま変数名を使います。例えば、num = 10。"
"Ruby","Control Flow","Conditionals","Rubyでif文を使う方法は何ですか?","Rubyでif文はif 条件 then 実行するコード end 形式で使われます。"
"Python","Basics","Variables","Pythonで変数を宣言する方法は何ですか?","Pythonでは変数宣言時にデータ型を明示しません。例えば、num = 10。"
"Python","Data Structures","Lists","Pythonでリストを作成する方法は何ですか?","Pythonではリストは大かっこ[]を使って作成します。例えば、nums = [1, 2, 3]。"
"JavaScript","Basics","Functions","JavaScriptで関数を宣言する方法は何ですか?","JavaScriptではfunctionキーワードを使って関数を宣言します。例えば、function myFunction() { 実行するコード }。"
"JavaScript","DOM Manipulation","Events","JavaScriptでイベントリスナーを追加する方法は何ですか?","JavaScriptではaddEventListenerメソッドを使ってイベントリスナーを追加します。例えば、element.addEventListener('click', 関数)。"
"C++","Basics","Variables","C++で変数を宣言する方法は何ですか?","C++では変数宣言時にデータ型を明示する必要があります。例えば、int num = 10; のように宣言します。"
"C++","OOP","Classes","C++でクラスを定義する方法は何ですか?","C++ではclassキーワードを使ってクラスを定義します。例えば、class MyClass { public: int myNum; }。"
"HTML","Basics","Elements","HTMLで基本要素を定義する方法は何ですか?","HTMLでは<tagname>内容</tagname> 形式で要素を定義します。例えば、<p>こんにちは</p>。"
"HTML","Forms","Inputs","HTMLで入力フィールドを作成する方法は何ですか?","HTMLでは<input type="text"> 形式で入力フィールドを作成します。"
"CSS","Basics","Selectors","CSSでクラスを選択する方法は何ですか?","CSSでは.classname 形式でクラスを選択します。例えば、.myClass { color: red; }。"
"CSS","Layout","Flexbox","Flexboxを使う方法は何ですか?","CSSではFlexboxはdisplay: flex; プロパティを使ってレイアウトを設定します。"
"SQL","Basics","Queries","SQLでデータを照会する方法は何ですか?","SQLではSELECT文を使ってデータを照会します。例えば、SELECT * FROM テーブル名。"
"SQL","Joins","Inner Join","SQLでINNER JOINを使う方法は何ですか?","SQLでINNER JOINは2つのテーブルの一致するデータを照会する時に使います。例えば、SELECT * FROM テーブル1 INNER JOIN テーブル2 ON テーブル1.id = テーブル2.id。"
"PHP","Basics","Variables","PHPで変数を宣言する方法は何ですか?","PHPでは変数の前に$をつけて宣言します。例えば、$num = 10;。"
"PHP","Control Flow","Loops","PHPでforループを使う方法は何ですか?","PHPでforループはfor (初期化; 条件式; 増減式) { 実行するコード } 形式で使われます。"
"Swift","Basics","Variables","Swiftで変数を宣言する方法は何ですか?","Swiftではvarキーワードを使って変数を宣言します。例えば、var num = 10。"
"Swift","Control Flow","Conditionals","Swiftでif文を使う方法は何ですか?","Swiftでif文はif 条件 { 実行するコード } 形式で使われます。"
"Kotlin","Basics","Variables","Kotlinで変数を宣言する方法は何ですか?","Kotlinではvarまたはvalキーワードを使って変数を宣言します。例えば、var num = 10。"
"Kotlin","Control Flow","Loops","Kotlinでforループを使う方法は何ですか?","Kotlinでforループはfor (item in collection) { 実行するコード } 形式で使われます。"
"Go","Basics","Variables","Goで変数を宣言する方法は何ですか?","Goではvarキーワードを使って変数を宣言します。例えば、var num int = 10。"
"Go","Control Flow","Conditionals","Goでif文を使う方法は何ですか?","Goでif文はif 条件 { 実行するコード } 形式で使われます。"
"Rust","Basics","Variables","Rustで変数を宣言する方法は何ですか?","Rustではletキーワードを使って変数を宣言します。例えば、let num = 10。"
"Rust","Control Flow","Loops","Rustでforループを使う方法は何ですか?","Rustでforループはfor item in collection { 実行するコード } 形式で使われます。"
"Perl","Basics","Variables","Perlで変数を宣言する方法は何ですか?","Perlでは変数の前に$をつけて宣言します。例えば、$num = 10。"
"Perl","Control Flow","Conditionals","Perlでif文を使う方法は何ですか?","Perlでif文はif (条件) { 実行するコード } 形式で使われます。"
"Scala","Basics","Variables","Scalaで変数を宣言する方法は何ですか?","Scalaではvarまたはvalキーワードを使って変数を宣言します。例えば、var num = 10。"
"Scala","Control Flow","Loops","Scalaでforループを使う方法は何ですか?","Scalaでforループはfor (item <- collection) { 実行するコード } 形式で使われます。"
"R","Basics","Variables","Rで変数を宣言する方法は何ですか?","Rでは<- 演算子を使って変数を宣言します。例えば、num <- 10。"
"R","Data Structures","Vectors","Rでベクトルを作成する方法は何ですか?","Rではc()関数を使ってベクトルを作成します。例えば、nums <- c(1, 2, 3)。"
"MATLAB","Basics","Variables","MATLABで変数を宣言する方法は何ですか?","MATLABでは変数を宣言する時にデータ型を明示しません。例えば、num = 10。"
"MATLAB","Control Flow","Loops","MATLABでforループを使う方法は何ですか?","MATLABでforループはfor index = values, statements, end 形式で使われます。"
"Shell","Basics","Variables","シェルスクリプトで変数を宣言する方法は何ですか?","シェルスクリプトでは変数名=値 形式で変数を宣言します。例えば、num=10。"
"Shell","Control Flow","Conditionals","シェルスクリプトでif文を使う方法は何ですか?","シェルスクリプトでif文はif [ 条件 ]; then 実行するコード; fi 形式で使われます。"
"Julia","Basics","Variables","Juliaで変数を宣言する方法は何ですか?","Juliaではletキーワードを使って変数を宣言します。例えば、let num = 10。"
"Julia","Control Flow","Loops","Juliaでforループを使う方法は何ですか?","Juliaでforループはfor item in collection 実行するコード end 形式で使われます。"
"Dart","Basics","Variables","Dartで変数を宣言する方法は何ですか?","Dartではvarまたはfinalキーワードを使って変数を宣言します。例えば、var num = 10。"
"Dart","Control Flow","Conditionals","Dartでif文を使う方法は何ですか?","Dartでif文はif (条件) { 実行するコード } 形式で使われます。"
"TypeScript","Basics","Variables","TypeScriptで変数を宣言する方法は何ですか?","TypeScriptではletまたはconstキーワードを使って変数を宣言します。例えば、let num = 10。"
"TypeScript","Control Flow","Loops","TypeScriptでforループを使う方法は何ですか?","TypeScriptでforループはfor (初期化; 条件式; 増減式) { 実行するコード } 形式で使われます。"
```

## 目次

- [com.opencsv](#comopencsv)
- [com.opencsv.bean](#comopencsvbean)
- [com.opencsv.bean.comparator](#comopencsvbeancomparator)
- [com.opencsv.bean.concurrent](#comopencsvbeanconcurrent)
- [com.opencsv.bean.customconverter](#comopencsvbeancustomconverter)
- [com.opencsv.bean.exceptionhandler](#comopencsvbeanexceptionhandler)
- [com.opencsv.bean.function](#comopencsvbeanfunction)
- [com.opencsv.bean.processor](#comopencsvbeanprocessor)
- [com.opencsv.bean.util](#comopencsvbeanutil)
- [com.opencsv.bean.validators](#comopencsvbeanvalidators)
- [com.opencsv.enums](#comopencsvenums)
- [com.opencsv.exceptions](#comopencsvexceptions)
- [com.opencsv.processor](#comopencsvprocessor)
- [com.opencsv.stream.reader](#comopencsvstreamreader)
- [com.opencsv.validators](#comopencsvvalidators)

## com.opencsv

### 概要

- 商用利用に適したライセンスで公開されている、Java のための非常にシンプルな CSV パーサー。

### インターフェースの概要

- `ICSVParser`: `CSVReader` が入力行をトークン化して追加処理に必要なパーサーのすべての動作を定義。
- `ICSVWriter`: csv ライター・クラスのすべての動作を定義。
- `ResultSetHelper`: `ResultSetHelperService` のインターフェース。

### クラスの概要

- `AbstractCSVParser`: パーサー間の重複コードを統合。
- `AbstractCSVWriter`: `CSVWriter` と `CSVParserWriter`クラス間のコード重複を防止。
- `CSVIterator`: opencsv から見つかったデータに対するイテレータを提供。
- `CSVParser`: 商用利用に適したライセンスで公開された非常に単純な CSV パーサー。
- `CSVParserBuilder`: `CSVParser` を生成するためのビルダー。
- `CSVParserWriter`: 文字列配列を CSV データ行に変換する作業を処理するために `ICSVParser` を渡すことができる `CSVWriter` の代替品。
- `CSVReader`: 商用利用に適したライセンスで公開された非常に単純な CSV リーダー。
- `CSVReaderBaseBuilder`<T>: 様々な `CSVReader` の変形のためのビルダーの基本クラス。
- `CSVReaderBuilder`: `CSVReader` を生成するためのビルダー。
- `CSVReaderHeaderAware`: Bean Binding を使用する動機付けがないが、ヘッダーマッピングは引き続き必要な場合に便利なリーダー。
- `CSVReaderHeaderAwareBuilder`: CSVReaderHeaderAware 用のビルダー。
- `CSVWriter`: 商用利用に適したライセンスで公開された非常にシンプルな CSV ライター。
- `CSVWriterBuilder`: `CSVWriter` を生成するためのビルダー。
- `ResultSetColumnNameHelperService`: ユーザーが列のサブセットを処理し、カスタムヘッダー名を設定できるようにする JDBC ResultSet オブジェクトを処理するヘルパークラス。
- `ResultSetHelperService`: JDBC ResultSet オブジェクトを処理するためのヘルパークラス。
- `RFC4180Parser`: RFC4180 仕様に従ってパースするためのパーサー。
- `RFC4180ParserBuilder`: RFC4180Parser を生成するためのビルダー。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/OpencsvExample.java)

## com.opencsv.bean

### 概要

- opencsv とともに使用するための Bean Binding インターフェース。

### インターフェースの概要

- `BeanField<T,I>`: opencsv に必要な機能を含むように Field クラスを拡張するために使用。
- `BeanVerifier<T>`: このインターフェースを実装するクラスは、Bean 生成後に呼び出しアプリケーションに渡される前に、Bean を検証およびフィルタリングするために使用できる。
- `ComplexFieldMapEntry<I,K extends Comparable<K>,T>`: CSV ファイルの列と Bean フィールド間の多対一マッピングに必要な基本機能を定義。
- `CsvConverter`: このインターフェースを実装するクラスは、読み込み時の `String` から任意の型への変換と、書き込み時の任意の型から `String` への変換を実行。
- `CsvToBeanFilter`: フィルターを使用すると、Bean が生成される前に入力行を無視できる。
- `FieldMap<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: フィールド識別子と関連する BeanField の間のマッピングの基本的な特性を定義。
- `MappingStrategy<T>`: CSV ファイルの列を実際のオブジェクトに変換する作業を処理するクラスのインターフェース。

### クラスの概要

- `AbstractBeanField<T,I>`: この基本 Bean は、提供された文字列をターゲットフィールドに適した型に変換し、ターゲットフィールドを設定する責任を担う。
- `AbstractCsvConverter`: `CsvConverter` のこの実装は、`CsvConverter.convertToWrite(java.lang.Object)`の合理的なデフォルトといくつかの共通フィールドを提供する。
- `AbstractFieldMap<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: `FieldMap` のすべての一般化されたコンポーネントを収集するための基本クラス。
- `AbstractFieldMapEntry<I,K extends Comparable<K>,T>`: `ComplexFieldMapEntry` の共通側面を収集。
- `AbstractMappingStrategy<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: このクラスは、マッピング戦略の実装で一般的に役立つ部分をできるだけ多く収集。
- `AbstractMappingStrategy.RecursiveType`: Bean 型と再帰的に入る必要があるすべてのメンバー変数をカプセル化。
- `BeanFieldJoin<T,I>`: このクラスは、入力の複数の列を同じ名前の複数の列と結合して 1 つのフィールドにするために使用。
- `BeanFieldJoinIntegerIndex<T>`: インデックスに `Integer` を使用して `BeanFieldJoin` を実装。
- `BeanFieldJoinStringIndex<T>`: インデックスに `String` を使用して `BeanFieldJoin` を実装。
- `BeanFieldSingleValue<T,I>`: このクラスは、単一値 Bean フィールド処理に関連。
- `BeanFieldSplit<T,I>`: このクラスは、コレクション値 Bean フィールド処理に関連。
- `ColumnPositionMappingStrategy<T>`: 列とその位置の間のマッピングを許可。
- `ColumnPositionMappingStrategyBuilder<T>`: `ColumnPositionMappingStrategy` のビルダー。
- `ConverterCurrency`: このクラスは、入力 ISO 4217 通貨コードを Currency インスタンスに変換。
- `ConverterDate`: このクラスは、入力を日付型に変換。
- `ConverterEnum`: このクラスは、入力を列挙型に変換し、その逆も変換。
- `ConverterNumber`: このコンバータークラスは、`CsvNumber` と共に使用され、数値の入力と出力をフォーマットする必要がある場合に使用。
- `ConverterPrimitiveTypes`: このクラスは、プリミティブ型の変換を処理し、必須のフラグを追加するためにリフレクション API の Field をラップ。
- `ConverterUUID`: このクラスは、`String` を UUID インスタンスに変換。
- `CsvToBean<T>`: CSV データをオブジェクトに変換。
- `CsvToBeanBuilder<T>`: このクラスを使用すると、CSV ソースから Bean リストへの読み取りに必要なすべての中間ステップとクラスを回避できる。
- `FieldAccess<T>`: クラスのメンバー変数にアクセスするためのロジックをカプセル化。
- `FieldMapByName<T>`: このクラスは、CSV ファイルのヘッダー名から Bean フィールドへのマッピングを維持管理。
- `FieldMapByNameEntry<T>`: `FieldMapByName` の 1 つのエントリを表す。
- `FieldMapByPosition<T>`: このクラスは、CSV ファイルの列位置から Bean フィールドへのマッピングを維持管理。
- `FieldMapByPositionEntry<T>`: `FieldMapByPosition` の 1 つのエントリを表す。
- `FuzzyMappingStrategy<T>`: ヘッダー名と注釈付けされていないメンバー変数の間で最適な一致を試みるマッピング戦略。
- `FuzzyMappingStrategyBuilder<T>`: `FuzzyMappingStrategy` のビルダー。
- `HeaderColumnNameMappingStrategy<T>`: CSV ファイルの最初の行にある列名を参照として使用してデータをオブジェクトにマッピング。
- `HeaderColumnNameMappingStrategyBuilder<T>`: `HeaderColumnNameMappingStrategy` のビルダー。
- `HeaderColumnNameTranslateMappingStrategy<T>`: ユーザーが列名から Bean 名へのマップを渡すことを許可して、`HeaderColumnNameMappingStrategy` を拡張。
- `HeaderColumnNameTranslateMappingStrategyBuilder<T>`: `HeaderColumnNameMappingStrategy` のビルダー。
- `HeaderIndex`: 列の位置とヘッダー名の間の双方向マッピング。
- `HeaderNameBaseMappingStrategy<T>`: このクラスは、ヘッダー名をメンバー変数にマッピングするマッピング戦略に共通のコードを収集する場所の役割を果たす。
- `PositionToBeanField<T>`: 範囲定義に一致するすべての列の位置を BeanField にマッピング。
- `RegexToBeanField<T>`: 正規表現に一致するすべてのヘッダー名を BeanField にマッピング。
- `StatefulBeanToCsv<T>`: このクラスは、状態情報を維持し、適用するマッピング戦略を賢く推測しながら、Bean を CSV 形式で Writer に書き込む。
- `StatefulBeanToCsvBuilder<T>`: これは `StatefulBeanToCsv` のビルダーで、CSV ファイルの書き込みに必要なすべてのパラメータを設定できる。

### アノテーション型の概要

- `CsvBindAndJoinByName`: 入力の複数の列の値を、列名パターンに従って 1 つの Bean フィールドに結合。
- `CsvBindAndJoinByNames`: このアノテーションは、`CsvBindAndJoinByName` のコンテナアノテーション。
- `CsvBindAndJoinByPosition`: 入力の複数の列の値を、列の位置の選択に従って 1 つの Bean フィールドに結合。
- `CsvBindAndJoinByPositions`: このアノテーションは、`CsvBindAndJoinByPosition` のコンテナアノテーション。
- `CsvBindAndSplitByName`: このアノテーションは、入力の 1 つのフィールドをコレクションとして解釈し、コンポーネントに分割して、コレクションベースの Bean フィールドに割り当てる。
- `CsvBindAndSplitByNames`: このアノテーションは、`CsvBindAndSplitByName` のコンテナアノテーション。
- `CsvBindAndSplitByPosition`: このアノテーションは、入力の 1 つのフィールドをコレクションとして解釈し、コンポーネントに分割して、コレクションベースの Bean フィールドに割り当てる。
- `CsvBindAndSplitByPositions`: このアノテーションは、`CsvBindAndSplitByPosition` のコンテナアノテーション。
- `CsvBindByName`: CSV 入力の列名と Bean のフィールドの間のバインディングを指定。
- `CsvBindByNames`: このアノテーションは、`CsvBindByName` のコンテナアノテーション。
- `CsvBindByPosition`: CSV 入力の列番号と Bean のフィールドの間のバインディングを指定。
- `CsvBindByPositions`: このアノテーションは、`CsvBindByPosition` のコンテナアノテーション。
- `CsvCustomBindByName`: ソースからターゲットへの変換を実行するクラスを指定できる。
- `CsvCustomBindByNames`: このアノテーションは、`CsvCustomBindByName` のコンテナアノテーション。
- `CsvCustomBindByPosition`: ソースからターゲットへの変換を実行するクラスを指定できる。
- `CsvCustomBindByPositions`: このアノテーションは、`CsvCustomBindByPosition` のコンテナアノテーション。
- `CsvDate`: このアノテーションは、ターゲットフィールドが時間表現であることを示す。
- `CsvDates`: このアノテーションは、`CsvDate` のコンテナアノテーション。
- `CsvIgnore`: opencsv にフィールドと存在するアノテーションを無視するよう指示。
- `CsvNumber`: このアノテーションは、ターゲットフィールドが特別にフォーマットされた数値であることを示す。
- `CsvNumbers`: このアノテーションは、`CsvNumber` のコンテナアノテーション。
- `CsvRecurse`: マッピング戦略に追加のマッピングアノテーションのためにメンバー変数の内部をチェックするよう指示。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/BeanExample.java)

## com.opencsv.bean.comparator

### 概要

- このパッケージは、opencsv を使用する誰にでも役立つ可能性のあるコンパレータ(`Comparator`)のコレクション。

### クラスの概要

- `LiteralComparator<T extends Comparable<T>>`: (Deprecated) これと同じ動作は、opencsv が依存関係として含む Apache Commons Collections のコンパレータを使用して得ることができる。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/comparator/ComparatorExample.java)

## com.opencsv.bean.concurrent

### 概要

- このパッケージは、Bean の並列処理に必要なすべてのクラスを収集。

### クラスの概要

- `BeanExecutor<T>`: 書き込むために文字列に変換される Bean を提出するための `IntolerantThreadPoolExecutor` の特定の派生クラス。
- `CompleteFileReader<T>`: 入力を読み取り、`LineExecutor` に送信するための別のスレッドを実装。
- `LineExecutor<T>`: Bean に変換される入力行を提出するための` IntolerantThreadPoolExecutor` の特定の派生クラス。
- `ProcessCsvBean<T>`: 出力に書き込むために 1 つの Bean を文字列表現に変換するクラス。
- `ProcessCsvLine<T>`: CSV 入力の 1 行から Bean を生成する作業をカプセル化し、その作業を並列に実行できるようにするクラス。
- `SingleLineReader`: このクラスは、`CsvToBean.iterator()`と `CompleteFileReader` に共通する単一の入力行を読み取るロジックを分離するために存在。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/concurrent/ConcurrentExample.java)

## com.opencsv.bean.customconverter

### 概要

- 一般的に役立つカスタムコンバーターがここに収集されている。

### クラスの概要

- `ConverterLanguageToBoolean<T,I>`: 文字列値が特定の言語にローカライズされているか、ローカライズする必要がある場合に、ブール値との間で変換するためのすべてのコンバーターの基本クラス。
- `ConvertFrenchToBoolean<T,I>`: このクラスは、ブール値の一般的なフランス語表現を `Boolean` に変換。
- `ConvertGermanToBoolean<T,I>`: このクラスは、ブール値の一般的なドイツ語表現を `Boolean` に変換。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/bean/customconverter)

## com.opencsv.bean.exceptionhandler

### 概要

- このパッケージには、Bean 生成と Bean 書き込み中の例外処理ロジックのインターフェースと標準実装が含まれている。

### インターフェースの概要

- `CsvExceptionHandler`: このインターフェースは、Bean 生成または CSV 出力への変換中に発生した例外を処理する一般的な方法を定義。

### クラスの概要

- `ExceptionHandlerIgnore`: 常に発生した例外を無視する例外ハンドラー。
- `ExceptionHandlerIgnoreThenThrowAfter`: 最初の x 個の例外を無視し、その後のすべての例外をスローする例外ハンドラー。
- `ExceptionHandlerQueue`: 常に発生した例外をキューに入れる例外ハンドラー。
- `ExceptionHandlerQueueThenThrowAfter`: 最初の x 個の例外をキューに入れ、その後のすべての例外をスローする例外ハンドラー。
- `ExceptionHandlerThrow`: 常に発生した例外をスローする例外ハンドラー。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/exceptionhandler/ExceptionhandlerExample.java)

## com.opencsv.bean.function

### 概要

- このパッケージは、opencsv で使用される関数の定義を収集。

### インターフェースの概要

- `AccessorInvoker<T,R>`: フィールドから値にアクセスするための関数型インターフェース。
- `AssignmentInvoker<T,U>`: フィールドに値を割り当てるための関数型インターフェース。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/function/FunctionExample.java)

## com.opencsv.bean.processor

### インターフェースの概要

- `StringProcessor`: 単一の文字列値に対するバリデーターのためのインターフェース。

### クラスの概要

- `ConvertEmptyOrBlankStringsToDefault`: 空文字列または空白文字列を目的の値の文字列に変換する `StringProcessor`。
- `ConvertEmptyOrBlankStringsToNull`: 空文字列または空白文字列をリテラルの `null` 文字列に変換する `StringProcessor`。
- `ConvertWordNullToNull`: 文字列値の"null"をリテラルの `null` 文字列に変換する `StringProcessor`。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/processor/ProcessorExample.java)

## com.opencsv.bean.util

### 概要

- このパッケージは、内部使用のためのユーティリティクラスのコレクション。

### クラスの概要

- `OpencsvUtils`: このクラスは、opencsv の内部処理に役立つ汎用の静的メソッドのコレクションになることを意図している。
- `OrderedObject<E>`: オブジェクトをソートするための単純なクラス。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/util/UtilExample.java)

## com.opencsv.bean.validators

### インターフェースの概要

- `StringValidator`: 単一の文字列値に対するバリデーターのためのインターフェース。

### クラスの概要

- `MustMatchRegexExpression`: このバリデーターは、パラメータの追加により、複数の異なるタイプの入力検証を許可。

### アノテーション型の概要

- `PreAssignmentValidator`: Bean のフィールドに対するバリデーターのバインディングを指定。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/validators/ValidatorsExample.java)

## com.opencsv.enums

### 概要

- opencsv の内部動作に関連する列挙型。

### 列挙型の概要

- `CSVReaderNullFieldIndicator`: CSVParser に何を `null` と見なすかを知らせるために使用される列挙型。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/enums/EnumsExample.java)

## com.opencsv.exceptions

### 개요

- このパッケージには、opencsv に関連するすべての例外が含まれている。

### 예외 요약

- `CsvBadConverterException`: この例外は、コンバーターが何らかの形で期待通りに動作しなかったことを示す。
- `CsvBeanIntrospectionException`: この例外は、opencsv に提供された Bean の内部検査中に問題が発生したときに発生。
- `CsvChainedException`: 複数の例外を収集するための例外クラス。
- `CsvConstraintViolationException` この例外は、インポートされたデータによってデータフィールド間の論理的な接続が違反されたときに発生。
- `CsvDataTypeMismatchException`: この例外は、変換のために提供された文字列値をターゲットフィールドの必須の型に変換できない場合に発生すべき。
- `CsvException`: これは、opencsv のすべての例外の基本クラス。
- `CsvFieldAssignmentException`: 単一のフィールドのデコードと割り当て中に発生する可能性のある確認された例外のスーパークラス。
- `CsvMalformedLineException`: `CSVReader` が行を処理できないときに発生する例外。
- `CsvMultilineLimitBrokenException`: 複数行フィールドの行制限を超えたときに発生する例外。
- `CsvRecursionException`: この例外は、`CsvRecurse` が誤って使用された場合、フィールドマッピングの開始時に発生。
- `CsvRequiredFieldEmptyException`: この例外は、CSV ファイルで必須とマークされたフィールドが空の場合に発生すべき。
- `CsvRuntimeException`: opencsv のすべての未確認の例外の基本クラス。
- `CsvValidationException`: 単一の行が無効な場合に、`LineValidator` または `LineValidatorAggregator` によって発生する例外。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/exceptions/ExceptionsExample.java)

## com.opencsv.processor

### インターフェースの概要

- `RowProcessor`: `CSVReader` によって読み取られた文字列の配列が検証される前に処理するためのプロセッサのインターフェース。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/processor)

## com.opencsv.stream.reader

### 概要

- 行の読み取りをカスタマイズするためのクラスのコレクション。

### クラスの概要

- `LineReader`: このクラスは、キャリッジリターンが削除される問題[#106](https://sourceforge.net/p/opencsv/bugs/106/)のために作成された。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/processor)

## com.opencsv.validators

### インターフェースの概要

- `LineValidator`: これは、CSVReader の Reader によって読み取られた String に対するバリデーターのインターフェースで、処理前に使用。
- `RowValidator`: これは、CSVReader によって読み取られた String の配列に対するバリデーターのインターフェースで、処理後に使用。

### クラスの概要

- `LineValidatorAggregator`: アグリゲーターの目的は、複数の LineValidator を収集し、単一の行に対して実行すること。
- `RowFunctionValidator`: このバリデーターは、行の特定のプロパティ（特定の要素に関する情報または配列自体に関する情報）を検証するのに最適。
- `RowMustHaveSameNumberOfColumnsAsFirstRowValidator`: このバリデーターは、列の数が必ずしも知られている必要はないが、一貫している必要がある場合に使用。
- `RowValidatorAggregator`: アグリゲーターの目的は、複数の RowValidator を収集し、単一の文字列の配列に対して実行すること。

### [サンプルコード](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/validators/ValidatorsExample.java)
