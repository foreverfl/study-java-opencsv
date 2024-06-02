# opencsv 5.9 API

- opencsv를 쓰는 간단한 방법을 정리한 자료입니다.
- 목차는 [공식 문서의 packages](https://javadoc.io/doc/com.opencsv/opencsv/latest/index.html)입니다.
- 각 package를 사용하는 기본적인 방법에 대해서만 정리해보았습니다. 구체적인 메서드 사용 방법은 혼자서 공식문서를 보고 하도록 합시다.
- 예제 코드 및 번역은 Claude3 Opus 및 GPT 4o를 활용했습니다.
- 예제 데이터는 다음과 같고, 사용할 때는 예제 코드와 동일한 경로에 csv 파일을 생성해주세요.

```plaintext
"Category","Subcategory","Topic","Question","Answer"
"Java","Basics","Variables","자바에서 변수를 선언하는 방법은 무엇인가요?","자바에서는 변수 선언 시 자료형을 명시해야 합니다. 예를 들어 int num = 10; 과 같이 선언합니다."
"Java","Control Flow","Loops","자바에서 for 루프를 사용하는 방법은 무엇인가요?","자바에서 for 루프는 for (초기화; 조건식; 증감식) { 실행할 코드 } 형식으로 사용됩니다."
"Ruby","Basics","Variables","루비에서 변수를 선언하는 방법은 무엇인가요?","루비에서는 변수 앞에 $를 붙이지 않고 그냥 변수명을 사용합니다. 예를 들어 num = 10."
"Ruby","Control Flow","Conditionals","루비에서 if 문을 사용하는 방법은 무엇인가요?","루비에서 if 문은 if 조건 then 실행할 코드 end 형식으로 사용됩니다."
"Python","Basics","Variables","파이썬에서 변수를 선언하는 방법은 무엇인가요?","파이썬에서는 변수 선언 시 자료형을 명시하지 않습니다. 예를 들어 num = 10."
"Python","Data Structures","Lists","파이썬에서 리스트를 생성하는 방법은 무엇인가요?","파이썬에서 리스트는 대괄호 []를 사용하여 생성합니다. 예를 들어 nums = [1, 2, 3]."
"JavaScript","Basics","Functions","자바스크립트에서 함수를 선언하는 방법은 무엇인가요?","자바스크립트에서는 function 키워드를 사용하여 함수를 선언합니다. 예를 들어 function myFunction() { 실행할 코드 }."
"JavaScript","DOM Manipulation","Events","자바스크립트에서 이벤트 리스너를 추가하는 방법은 무엇인가요?","자바스크립트에서는 addEventListener 메서드를 사용하여 이벤트 리스너를 추가합니다. 예를 들어 element.addEventListener('click', 함수)."
"C++","Basics","Variables","C++에서 변수를 선언하는 방법은 무엇인가요?","C++에서는 변수 선언 시 자료형을 명시해야 합니다. 예를 들어 int num = 10; 과 같이 선언합니다."
"C++","OOP","Classes","C++에서 클래스를 정의하는 방법은 무엇인가요?","C++에서는 class 키워드를 사용하여 클래스를 정의합니다. 예를 들어 class MyClass { public: int myNum; }."
"HTML","Basics","Elements","HTML에서 기본 요소를 정의하는 방법은 무엇인가요?","HTML에서는 <tagname>내용</tagname> 형식으로 요소를 정의합니다. 예를 들어 <p>안녕하세요</p>."
"HTML","Forms","Inputs","HTML에서 입력 필드를 생성하는 방법은 무엇인가요?","HTML에서는 <input type="text"> 형식으로 입력 필드를 생성합니다."
"CSS","Basics","Selectors","CSS에서 클래스를 선택하는 방법은 무엇인가요?","CSS에서는 .classname 형식으로 클래스를 선택합니다. 예를 들어 .myClass { color: red; }."
"CSS","Layout","Flexbox","Flexbox를 사용하는 방법은 무엇인가요?","CSS에서 Flexbox는 display: flex; 속성을 사용하여 레이아웃을 설정합니다."
"SQL","Basics","Queries","SQL에서 데이터를 조회하는 방법은 무엇인가요?","SQL에서는 SELECT 문을 사용하여 데이터를 조회합니다. 예를 들어 SELECT * FROM 테이블명."
"SQL","Joins","Inner Join","SQL에서 INNER JOIN을 사용하는 방법은 무엇인가요?","SQL에서 INNER JOIN은 두 테이블의 일치하는 데이터를 조회할 때 사용합니다. 예를 들어 SELECT * FROM 테이블1 INNER JOIN 테이블2 ON 테이블1.id = 테이블2.id."
"PHP","Basics","Variables","PHP에서 변수를 선언하는 방법은 무엇인가요?","PHP에서는 변수 앞에 $를 붙여서 선언합니다. 예를 들어 $num = 10;."
"PHP","Control Flow","Loops","PHP에서 for 루프를 사용하는 방법은 무엇인가요?","PHP에서 for 루프는 for (초기화; 조건식; 증감식) { 실행할 코드 } 형식으로 사용됩니다."
"Swift","Basics","Variables","Swift에서 변수를 선언하는 방법은 무엇인가요?","Swift에서는 var 키워드를 사용하여 변수를 선언합니다. 예를 들어 var num = 10."
"Swift","Control Flow","Conditionals","Swift에서 if 문을 사용하는 방법은 무엇인가요?","Swift에서 if 문은 if 조건 { 실행할 코드 } 형식으로 사용됩니다."
"Kotlin","Basics","Variables","Kotlin에서 변수를 선언하는 방법은 무엇인가요?","Kotlin에서는 var 또는 val 키워드를 사용하여 변수를 선언합니다. 예를 들어 var num = 10."
"Kotlin","Control Flow","Loops","Kotlin에서 for 루프를 사용하는 방법은 무엇인가요?","Kotlin에서 for 루프는 for (item in collection) { 실행할 코드 } 형식으로 사용됩니다."
"Go","Basics","Variables","Go에서 변수를 선언하는 방법은 무엇인가요?","Go에서는 var 키워드를 사용하여 변수를 선언합니다. 예를 들어 var num int = 10."
"Go","Control Flow","Conditionals","Go에서 if 문을 사용하는 방법은 무엇인가요?","Go에서 if 문은 if 조건 { 실행할 코드 } 형식으로 사용됩니다."
"Rust","Basics","Variables","Rust에서 변수를 선언하는 방법은 무엇인가요?","Rust에서는 let 키워드를 사용하여 변수를 선언합니다. 예를 들어 let num = 10."
"Rust","Control Flow","Loops","Rust에서 for 루프를 사용하는 방법은 무엇인가요?","Rust에서 for 루프는 for item in collection { 실행할 코드 } 형식으로 사용됩니다."
"Perl","Basics","Variables","Perl에서 변수를 선언하는 방법은 무엇인가요?","Perl에서는 변수 앞에 $를 붙여서 선언합니다. 예를 들어 $num = 10."
"Perl","Control Flow","Conditionals","Perl에서 if 문을 사용하는 방법은 무엇인가요?","Perl에서 if 문은 if (조건) { 실행할 코드 } 형식으로 사용됩니다."
"Scala","Basics","Variables","Scala에서 변수를 선언하는 방법은 무엇인가요?","Scala에서는 var 또는 val 키워드를 사용하여 변수를 선언합니다. 예를 들어 var num = 10."
"Scala","Control Flow","Loops","Scala에서 for 루프를 사용하는 방법은 무엇인가요?","Scala에서 for 루프는 for (item <- collection) { 실행할 코드 } 형식으로 사용됩니다."
"R","Basics","Variables","R에서 변수를 선언하는 방법은 무엇인가요?","R에서는 <- 연산자를 사용하여 변수를 선언합니다. 예를 들어 num <- 10."
"R","Data Structures","Vectors","R에서 벡터를 생성하는 방법은 무엇인가요?","R에서는 c() 함수를 사용하여 벡터를 생성합니다. 예를 들어 nums <- c(1, 2, 3)."
"MATLAB","Basics","Variables","MATLAB에서 변수를 선언하는 방법은 무엇인가요?","MATLAB에서는 변수를 선언할 때 자료형을 명시하지 않습니다. 예를 들어 num = 10."
"MATLAB","Control Flow","Loops","MATLAB에서 for 루프를 사용하는 방법은 무엇인가요?","MATLAB에서 for 루프는 for index = values, statements, end 형식으로 사용됩니다."
"Shell","Basics","Variables","Shell 스크립트에서 변수를 선언하는 방법은 무엇인가요?","Shell 스크립트에서는 변수명=값 형식으로 변수를 선언합니다. 예를 들어 num=10."
"Shell","Control Flow","Conditionals","Shell 스크립트에서 if 문을 사용하는 방법은 무엇인가요?","Shell 스크립트에서 if 문은 if [ 조건 ]; then 실행할 코드; fi 형식으로 사용됩니다."
"Julia","Basics","Variables","Julia에서 변수를 선언하는 방법은 무엇인가요?","Julia에서는 let 키워드를 사용하여 변수를 선언합니다. 예를 들어 let num = 10."
"Julia","Control Flow","Loops","Julia에서 for 루프를 사용하는 방법은 무엇인가요?","Julia에서 for 루프는 for item in collection 실행할 코드 end 형식으로 사용됩니다."
"Dart","Basics","Variables","Dart에서 변수를 선언하는 방법은 무엇인가요?","Dart에서는 var 또는 final 키워드를 사용하여 변수를 선언합니다. 예를 들어 var num = 10."
"Dart","Control Flow","Conditionals","Dart에서 if 문을 사용하는 방법은 무엇인가요?","Dart에서 if 문은 if (조건) { 실행할 코드 } 형식으로 사용됩니다."
"TypeScript","Basics","Variables","TypeScript에서 변수를 선언하는 방법은 무엇인가요?","TypeScript에서는 let 또는 const 키워드를 사용하여 변수를 선언합니다. 예를 들어 let num = 10."
"TypeScript","Control Flow","Loops","TypeScript에서 for 루프를 사용하는 방법은 무엇인가요?","TypeScript에서 for 루프는 for (초기화; 조건식; 증감식) { 실행할 코드 } 형식으로 사용됩니다."
```

## 목차

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

### 개요

- 상업적으로 친화적인 라이선스로 출시된 Java용 매우 간단한 CSV 파서.

### 인터페이스 요약

- `ICSVParser`: CSVReader가 입력 라인을 토큰화하여 추가 처리하는 데 필요한 파서의 모든 동작을 정의함.
- `ICSVWriter`: csv 작성기 클래스의 모든 동작을 정의함.
- `ResultSetHelper`: `ResultSetHelperService`의 인터페이스.

### 클래스 요약:

- `AbstractCSVParser`: 파서 간의 중복 코드를 통합함.
- `AbstractCSVWriter`: `CSVWriter`와 `CSVParserWriter` 클래스 간의 코드 중복을 방지함.
- `CSVIterator`: opencsv에서 찾은 데이터에 대한 반복자를 제공함.
- `CSVParser`: 상업적으로 친화적인 라이선스로 출시된 매우 간단한 CSV 파서.
- `CSVParserBuilder`: `CSVParser`를 생성하기 위한 빌더.
- `CSVParserWriter`: 문자열 배열을 CSV 데이터 라인으로 변환하는 작업을 처리하기 위해 `ICSVParser`를 전달할 수 있는 `CSVWriter`의 대체품.
- `CSVReader`: 상업적으로 친화적인 라이선스로 출시된 매우 간단한 CSV 리더.
- `CSVReaderBaseBuilder`<T>: 다양한 `CSVReader`의 변형을 위한 빌더의 기본 클래스.
- `CSVReaderBuilder`: `CSVReader`를 생성하기 위한 빌더.
- `CSVReaderHeaderAware`: 빈 바인딩을 사용할 동기가 부족하지만 헤더 매핑은 여전히 원할 때 유용한 리더.
- `CSVReaderHeaderAwareBuilder`: `CSVReaderHeaderAware`를 위한 빌더.
- `CSVWriter`: 상업적으로 친화적인 라이선스로 출시된 매우 간단한 CSV 작성기.
- `CSVWriterBuilder`: `CSVWriter`를 생성하기 위한 빌더.
- `ResultSetColumnNameHelperService`: 사용자가 열의 하위 집합을 처리하고 사용자 지정 헤더 이름을 설정할 수 있도록 JDBC ResultSet 객체를 처리하는 도우미 클래스.
- `ResultSetHelperService`: JDBC ResultSet 객체를 처리하기 위한 도우미 클래스.
- `RFC4180Parser`: RFC4180 사양에 따라 파싱하기 위한 파서.
- `RFC4180ParserBuilder`: RFC4180Parser를 생성하기 위한 빌더.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/OpencsvExample.java)

## com.opencsv.bean

### 개요

- opencsv와 함께 사용하기 위한 빈 바인딩 인터페이스.

### 인터페이스 요약

- `BeanField<T,I>`: opencsv에 필요한 기능을 포함하도록 Field 클래스를 확장하는 데 사용됨.
- `BeanVerifier<T>`: 이 인터페이스를 구현하는 클래스는 빈 생성 후 호출 응용 프로그램으로 전달되기 전에 빈을 검증하고 필터링하는 데 사용될 수 있음.
- `ComplexFieldMapEntry<I,K extends Comparable<K>,T>`: CSV 파일의 열과 빈 필드 간의 다대일 매핑에 필요한 기본 기능을 정의합니다.
- `CsvConverter`: 이 인터페이스를 구현하는 클래스는 읽을 때 `String`에서 어떤 유형으로의 변환과 쓸 때 어떤 유형에서 `String`으로의 변환을 수행함.
- `CsvToBeanFilter`: 필터를 사용하면 빈이 생성되기 전에 입력 라인을 무시할 수 있음.
- `FieldMap<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: 필드 식별자와 연결된 `BeanField` 간의 매핑에 대한 기본 특성을 정의함.
- `MappingStrategy<T>`: CSV 파일의 열을 실제 객체로 변환하는 작업을 처리하는 클래스의 인터페이스.

### 클래스 요약

- `AbstractBeanField<T,I>`: 이 기본 빈은 제공된 문자열을 대상 필드에 적합한 유형으로 변환하고 대상 필드를 설정하는 책임을 맡음.
- `AbstractCsvConverter`: `CsvConverter`의 이 구현은 `CsvConverter.convertToWrite(java.lang.Object)`에 대한 합리적인 기본값과 몇 가지 공통 필드를 제공함.
- `AbstractFieldMap<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: `FieldMap`의 모든 일반화된 구성 요소를 수집하기 위한 기본 클래스.
- `AbstractFieldMapEntry<I,K extends Comparable<K>,T>`: `ComplexFieldMapEntry`의 공통 측면을 수집함.
- `AbstractMappingStrategy<I,K extends Comparable<K>,C extends ComplexFieldMapEntry<I,K,T>,T>`: 이 클래스는 매핑 전략 구현에서 일반적으로 유용한 부분을 가능한 한 많이 수집함.
- `AbstractMappingStrategy.RecursiveType`: 빈 유형과 재귀적으로 들어가야 하는 모든 멤버 변수를 캡슐화함.
- `BeanFieldJoin<T,I>`: 이 클래스는 입력의 여러 열을 동일한 이름의 여러 열과 결합하여 하나의 필드로 만드는 데 사용됨.
- `BeanFieldJoinIntegerIndex<T>`: 인덱스에 `Integer`를 사용하여 `BeanFieldJoin`을 구현함.
- `BeanFieldJoinStringIndex<T>`: 인덱스에 `String`을 사용하여 `BeanFieldJoin`을 구현함.
- `BeanFieldSingleValue<T,I>`: 이 클래스는 단일 값 빈 필드 처리와 관련이 있음.
- `BeanFieldSplit<T,I>`: 이 클래스는 컬렉션 값 빈 필드 처리와 관련이 있음.
- `ColumnPositionMappingStrategy<T>`: 열과 해당 위치 간의 매핑을 허용함.
- `ColumnPositionMappingStrategyBuilder<T>`: `ColumnPositionMappingStrategy`의 빌더.
- `ConverterCurrency`: 이 클래스는 입력 ISO 4217 통화 코드를 Currency 인스턴스로 변환함.
- `ConverterDate`: 이 클래스는 입력을 날짜 유형으로 변환함.
- `ConverterEnum`: 이 클래스는 입력을 열거형 유형으로 변환하고 그 반대로도 변환함.
- `ConverterNumber`: 이 변환기 클래스는 `CsvNumber`와 함께 사용되며, 숫자 입력과 출력을 서식화해야 할 때 사용됨.
- `ConverterPrimitiveTypes`: 이 클래스는 기본 유형의 변환을 처리하고 "필수" 플래그를 추가하기 위해 리플렉션 API의 필드를 래핑함.
- `ConverterUUID`: 이 클래스는 String을 UUID 인스턴스로 변환함.
- `CsvToBean<T>`: CSV 데이터를 객체로 변환함.
- `CsvToBeanBuilder<T>`: 이 클래스를 사용하면 CSV 소스에서 빈 목록으로 읽기 위한 모든 중간 단계와 클래스를 우회할 수 있음.
- `FieldAccess<T>`: 클래스의 멤버 변수에 액세스하기 위한 로직을 캡슐화함.
- `FieldMapByName<T>`: 이 클래스는 CSV 파일의 헤더 이름에서 빈 필드로의 매핑을 유지 관리함.
- `FieldMapByNameEntry<T>`: `FieldMapByName`의 한 항목을 나타냄.
- `FieldMapByPosition<T>`: 이 클래스는 CSV 파일의 열 위치에서 빈 필드로의 매핑을 유지 관리함.
- `FieldMapByPositionEntry<T>`: `FieldMapByPosition`의 한 항목을 나타냄.
- `FuzzyMappingStrategy<T>`: 헤더 이름과 주석이 없는 멤버 변수 사이에서 최상의 일치를 시도하는 매핑 전략.
- `FuzzyMappingStrategyBuilder<T>`: `FuzzyMappingStrategy`의 빌더입.
- `HeaderColumnNameMappingStrategy<T>`: CSV 파일의 첫 번째 행에 있는 열 이름을 참조로 사용하여 데이터를 객체에 매핑함.
- `HeaderColumnNameMappingStrategyBuilder<T>`: `HeaderColumnNameMappingStrategy`의 빌더.
- `HeaderColumnNameTranslateMappingStrategy<T>`: 사용자가 열 이름에서 빈 이름으로의 맵을 전달할 수 있도록 허용하여 `HeaderColumnNameMappingStrategy`를 확장함.
- `HeaderColumnNameTranslateMappingStrategyBuilder<T>`: `HeaderColumnNameMappingStrategy`의 빌더.
- `HeaderIndex`: 열 위치와 헤더 이름 사이의 양방향 매핑.
- `HeaderNameBaseMappingStrategy<T>`: 이 클래스는 헤더 이름을 멤버 변수에 매핑하는 매핑 전략에 공통적인 코드를 수집하는 위치 역할을 함.
- `PositionToBeanField<T>`: 범위 정의와 일치하는 모든 열 위치를 `BeanField`에 매핑함.
- `RegexToBeanField<T>`: 정규식과 일치하는 모든 헤더 이름을 `BeanField`에 매핑함.
- `StatefulBeanToCsv<T>`: 이 클래스는 상태 정보를 유지하고 적용할 매핑 전략을 지능적으로 추측하면서 빈을 CSV 형식으로 `Writer`에 씀.
- `StatefulBeanToCsvBuilder<T>`: 이것은 `StatefulBeanToCsv`의 빌더로, CSV 파일을 쓰는 데 필요한 모든 매개변수를 설정할 수 있음.

### 어노테이션 유형 요약

- `CsvBindAndJoinByName`: 입력의 여러 열 값을 열 이름 패턴에 따라 하나의 빈 필드로 결합함.
- `CsvBindAndJoinByNames`: 이 어노테이션은 `CsvBindAndJoinByName`의 컨테이너 어노테이션.
- `CsvBindAndJoinByPosition`: 입력의 여러 열 값을 열 위치 선택에 따라 하나의 빈 필드로 결합함.
- `CsvBindAndJoinByPositions`: 이 어노테이션은 `CsvBindAndJoinByPosition`의 컨테이너 어노테이션.
- `CsvBindAndSplitByName`: 이 어노테이션은 입력의 한 필드를 컬렉션으로 해석하여 구성 요소로 분할하고 컬렉션 기반 빈 필드에 할당함.
- `CsvBindAndSplitByNames`: 이 어노테이션은 `CsvBindAndSplitByName`의 컨테이너 어노테이션.
- `CsvBindAndSplitByPosition`: 이 어노테이션은 입력의 한 필드를 컬렉션으로 해석하여 구성 요소로 분할하고 컬렉션 기반 빈 필드에 할당함.
- `CsvBindAndSplitByPositions`: 이 어노테이션은 `CsvBindAndSplitByPosition`의 컨테이너 어노테이션.
- `CsvBindByName`: CSV 입력의 열 이름과 빈의 필드 사이의 바인딩을 지정함.
- `CsvBindByNames`: 이 어노테이션은 `CsvBindByName`의 컨테이너 어노테이션.
- `CsvBindByPosition`: CSV 입력의 열 번호와 빈의 필드 사이의 바인딩을 지정함.
- `CsvBindByPositions`: 이 어노테이션은 `CsvBindByPosition`의 컨테이너 어노테이션.
- `CsvCustomBindByName`: 소스에서 대상으로의 변환을 수행할 클래스를 지정할 수 있음.
- `CsvCustomBindByNames`: 이 어노테이션은 `CsvCustomBindByName`의 컨테이너 어노테이션.
- `CsvCustomBindByPosition`: 소스에서 대상으로의 변환을 수행할 클래스를 지정할 수 있음.
- `CsvCustomBindByPositions`: 이 어노테이션은 `CsvCustomBindByPosition`의 컨테이너 어노테이션.
- `CsvDate`: 이 어노테이션은 대상 필드가 시간 표현임을 나타냄.
- `CsvDates`: 이 어노테이션은 `CsvDate`의 컨테이너 어노테이션.
- `CsvIgnore`: opencsv에 필드와 존재하는 어노테이션을 무시하도록 지시함.
- `CsvNumber`: 이 어노테이션은 대상 필드가 특별히 형식화된 숫자임을 나타냄.
- `CsvNumbers`: 이 어노테이션은 `CsvNumber`의 컨테이너 어노테이션.
- `CsvRecurse`: 매핑 전략에 추가 매핑 어노테이션을 위해 멤버 변수 내부를 확인하도록 지시함.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/BeanExample.java)

## com.opencsv.bean.comparator

### 개요

- 이 패키지는 opencsv를 사용하는 누구에게나 유용할 수 있는 비교자(`Comparator`) 모음.

### 클래스 요약

- `LiteralComparator<T extends Comparable<T>>`: (Deprecated) 이와 동일한 동작은 opencsv가 종속성으로 포함하는 Apache Commons Collections의 비교자를 사용하여 얻을 수 있음.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/comparator/ComparatorExample.java)

## com.opencsv.bean.concurrent

### 개요

- 이 패키지는 빈의 병렬 처리에 필요한 모든 클래스를 수집함.

### 클래스 요약

- `BeanExecutor<T>`: 쓰기를 위해 문자열로 변환될 빈을 제출하기 위한 `IntolerantThreadPoolExecutor`의 특정 파생 클래스.
- `CompleteFileReader<T>`: 입력을 읽고 `LineExecutor`로 보내기 위한 별도의 스레드를 구현함.
- `LineExecutor<T>`: 빈으로 변환될 입력 라인을 제출하기 위한 `IntolerantThreadPoolExecutor`의 특정 파생 클래스.
- `ProcessCsvBean<T>`: 출력에 쓰기 위해 하나의 빈을 문자열 표현으로 변환하는 클래스.
- `ProcessCsvLine<T>`: CSV 입력의 한 줄에서 빈을 생성하는 작업을 캡슐화하고 해당 작업을 병렬로 실행할 수 있게 만드는 클래스.
- `SingleLineReader`: 이 클래스는 `CsvToBean.iterator()`와 `CompleteFileReader`에 공통적인 단일 입력 라인을 읽는 로직을 분리하기 위해 존재함.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/concurrent/ConcurrentExample.java)

## com.opencsv.bean.customconverter

### 개요

- 일반적으로 유용한 사용자 정의 변환기가 여기에 수집되어 있음.

### 클래스 요약

- `ConverterLanguageToBoolean<T,I>`: 문자열 값이 특정 언어로 지역화되었거나 지역화되어야 할 때 부울 값으로 또는 부울 값에서 변환하기 위한 모든 변환기의 기본 클래스.
- `ConvertFrenchToBoolean<T,I>`: 이 클래스는 부울 값의 일반적인 프랑스어 표현을 `Boolean`으로 변환함.
- `ConvertGermanToBoolean<T,I>`: 이 클래스는 부울 값의 일반적인 독일어 표현을 `Boolean`으로 변환함.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/bean/customconverter)

## com.opencsv.bean.exceptionhandler

### 개요

- 이 패키지에는 빈 생성 및 빈 쓰기 중에 예외 처리 로직을 위한 인터페이스와 표준 구현이 포함되어 있음.

### 인터페이스 요약

- `CsvExceptionHandler`: 이 인터페이스는 빈 생성 또는 CSV 출력으로의 변환 중에 발생한 예외를 처리하는 일반적인 방법을 정의함.

### 클래스 요약

- `ExceptionHandlerIgnore`: 항상 발생한 예외를 무시하는 예외 처리기.
- `ExceptionHandlerIgnoreThenThrowAfter`: 처음 x개의 예외를 무시한 다음, 이후의 모든 예외를 던지는 예외 처리기.
- `ExceptionHandlerQueue`: 항상 발생한 예외를 큐에 넣는 예외 처리기.
- `ExceptionHandlerQueueThenThrowAfter`: 처음 x개의 예외를 큐에 넣은 다음, 이후의 모든 예외를 던지는 예외 처리기.
- `ExceptionHandlerThrow`: 항상 발생한 예외를 던지는 예외 처리기.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/exceptionhandler/ExceptionhandlerExample.java)

## com.opencsv.bean.function

### 개요

- 이 패키지는 opencsv에서 사용되는 함수 정의를 수집함.

### 인터페이스 요약

- `AccessorInvoker<T,R>`: 필드에서 값에 액세스하기 위한 함수형 인터페이스.
- `AssignmentInvoker<T,U>`: 필드에 값을 할당하기 위한 함수형 인터페이스.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/function/FunctionExample.java)

## com.opencsv.bean.processor

### 인터페이스 요약

- `StringProcessor`: 단일 문자열 값에 대한 검증기를 위한 인터페이스.

### 클래스 요약

- `ConvertEmptyOrBlankStringsToDefault`: 빈 문자열이나 공백 문자열을 원하는 값 문자열로 변환하는 `StringProcessor`.
- `ConvertEmptyOrBlankStringsToNull`: 빈 문자열이나 공백 문자열을 리터럴 `null` 문자열로 변환하는 `StringProcessor`.
- `ConvertWordNullToNull`: 문자열 값 "null"을 리터럴 `null` 문자열로 변환하는 `StringProcessor`.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/processor/ProcessorExample.java)

## com.opencsv.bean.util

### 개요

- 이 패키지는 내부 사용을 위한 유틸리티 클래스 모음.

### 클래스 요약

- `OpencsvUtils`: 이 클래스는 opencsv의 내부 처리에 유용한 범용 정적 메서드 모음이 되도록 의도되었dma.
- `OrderedObject<E>`: 객체를 정렬하기 위한 간단한 클래스.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/util/UtilExample.java)

## com.opencsv.bean.validators

### 인터페이스 요약

- `StringValidator`: 단일 문자열 값에 대한 검증기를 위한 인터페이스.

### 클래스 요약

- `MustMatchRegexExpression`: 이 검증기는 매개변수의 추가로 인해 여러 다른 유형의 입력 검증을 허용함.

### 어노테이션 유형 요약

- `PreAssignmentValidator`: 빈의 필드에 대한 검증기의 바인딩을 지정함.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/bean/validators/ValidatorsExample.java)

## com.opencsv.enums

### 개요

- opencsv의 내부 작업과 관련된 열거형.

### Enum 요약

- `CSVReaderNullFieldIndicator`: CSVParser에게 무엇을 null로 간주할지 알려주는 데 사용되는 열거형.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/enums/EnumsExample.java)

## com.opencsv.exceptions

### 개요

- 이 패키지에는 opencsv와 관련된 모든 예외가 포함되어 있음.

### 예외 요약

- `CsvBadConverterException`: 이 예외는 변환기가 어떤 식으로든 예상대로 동작하지 않았음을 나타냄.
- `CsvBeanIntrospectionException`: 이 예외는 opencsv에 제공된 빈의 내부 검사 중에 문제가 발생했을 때 발생함.
- `CsvChainedException`: 여러 예외를 수집하기 위한 예외 클래스입니다.CsvConstraintViolationException이 예외는 가져온 데이터에 의해 데이터 필드 간의 논리적 연결이 위반될 때 발생함.
- `CsvDataTypeMismatchException`: 이 예외는 변환을 위해 제공된 문자열 값을 대상 필드의 필수 유형으로 변환할 수 없을 때 발생해야 함.
- `CsvException`: 이것은 opencsv의 모든 예외에 대한 기본 클래스.
- `CsvFieldAssignmentException`: 단일 필드를 디코딩하고 할당하는 동안 발생할 수 있는 확인된 예외의 상위 클래스.
- `CsvMalformedLineException`: `CSVReader`가 라인을 처리할 수 없을 때 발생하는 예외.
- `CsvMultilineLimitBrokenException`: 다중 라인 필드의 라인 제한을 초과할 때 발생하는 예외.
- `CsvRecursionException`: 이 예외는 `CsvRecurse`가 잘못 사용된 경우 필드 매핑 시작 시 발생함.
- `CsvRequiredFieldEmptyException`: 이 예외는 CSV 파일에서 필수로 표시된 필드가 비어 있을 때 발생해야 함.
- `CsvRuntimeException`: opencsv의 모든 확인되지 않은 예외에 대한 기본 클래스.
- `CsvValidationException`: 단일 행이 유효하지 않을 때 `LineValidator` 또는 `LineValidatorAggregator`에 의해 발생하는 예외.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/exceptions/ExceptionsExample.java)

## com.opencsv.processor

### 인터페이스 요약

- `RowProcessor`: `CSVReader`에 의해 읽혀진 String 배열이 검증되기 전에 처리하는 프로세서를 위한 인터페이스.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/processor)

## com.opencsv.stream.reader

### 개요

- 라인 읽기를 사용자 정의하기 위한 클래스 모음.

### 클래스 요약

- `LineReader`: 이 클래스는 캐리지 리턴이 제거되는 문제 #106을 위해 생성되었음.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/tree/main/app/src/main/java/study/java/opencsv/processor)

## com.opencsv.validators

### 인터페이스 요약

- `LineValidator`: 이것은 `CSVReader`의 `Reader`에 의해 읽혀진 `String`에 대한 검증기 인터페이스로, 처리되기 전에 사용됨.
- `RowValidator`: 이것은 `CSVReader`에 의해 읽혀진 `String` 배열에 대한 검증기 인터페이스로, 처리된 후에 사용됨.

### 클래스 요약

- `LineValidatorAggregator`: 집계자의 목적은 여러 개의 `LineValidator`를 수집하고 단일 행에 대해 실행하는 것.
- `RowFunctionValidator`: 이 검증기는 행의 특정 속성(특정 요소에 대한 정보 또는 배열 자체에 대한 정보)을 검증하는 데 가장 적합함.
- `RowMustHaveSameNumberOfColumnsAsFirstRowValidator`: 이 검증기는 열의 수가 반드시 알려질 필요는 없지만 일관되어야 할 때 사용됨.
- `RowValidatorAggregator`: 집계자의 목적은 여러 개의 `RowValidator`를 수집하고 단일 문자열 배열에 대해 실행하는 것.

### [예제 코드](https://github.com/foreverfl/study-java-opencsv/blob/main/app/src/main/java/study/java/opencsv/validators/ValidatorsExample.java)
