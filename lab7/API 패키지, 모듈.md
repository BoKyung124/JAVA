### 1. 패키지

- 관련 있는 클래스들을 하나로 묶은 것
- 내장 패키지 & 사용자 정의 패키지
- `이름 공간` - 동일한 이름의 클래스가 각 다른 패키지에 속할 수 있어 이름 충돌을 방지할 수 있음
- 세밀한 접근 제어 구현 가능 
- 파일의 맨 처음에 `package 이름;`

### 2. 패키지 사용

- 완전한 이름으로 참조하기 (패키지 이름이 클래스 앞에 붙음)   
```java
graphics.Rectangle myRect = new graphics.Rectangle();
```
 - 패키지 안에서 원하는 클래스만 포함하기   
```java
import graphics.Rectangle;

Rectangle myRect = new Rectangle();
```

- 패키지 안의 모든 클래스 포함하기   
```java
import graphics.*;

Rectangle myRect = new Rectangle();
```

<br>

### 3. 계층 구조의 패키지 

> ex) `java - awt - font` 구조의 패키지들이 있을 때,   
`java.awt.*`를 포함시키면 `java.awt.font` 패키지는 자동으로 포함되지 __않음!__   
별도로 포함시키기   
```java
import java.awt.*;
import java.awt.font.*;
```

<br>

### 4. 클래스 파일 로드

- 자바 소스 파일이 컴파일되면 `.class` 확장자를 가지는 클래스 파일로 변환되고 파일 시스템에 저장됨   
- 클래스 파일은 JVM에 의해 로드됨   

<br>

### 5. JVM이 클래스를 찾는 순서와 방법

- 부트스트랩 클래스
    - 자바 플랫폼을 구성하는 핵심적인 클래스   
    - 디렉터리 __jre/lib__ 에 있는 여러 jar 파일들   

- 확장 클래스
    - 자바 확장 메커니즘 사용하는 클래스   
    - __확장 디렉터리__ 에 있는 jar 파일들   

- 사용자   
    - 확장 메커니즘을 활용하지 않는 __개발자 및 타사에서 정의한__ 클래스   

- 방법   
    - 현재 디렉터리 찾음   
    - 일반적으로는 환경 변수인 `CLASSPATH`에 설정된 디렉터리에서 찾음   

<br>

### 6. 자바 API 패키지

<br>

| 패키지 | 설명 | 
| --- | --- |
| java.applet | 애플릿을 생성하는 데 필요한 클래스 |
| java.awt | 그래픽과 이미지를 위한 클래스 | 
| java.io | 입력과 출력 스트림을 위한 클래스 | 
| java.lang | 자바 프로그래밍 언어에 필수적인 클래스 | 
| java.math | 수학에 관련된 클래스 | 
| java.net | 네트워킹 클래스 | 
| java.nio | 새로운 네트워킹 클래스 |
| java.security | 보안 프레임워크를 위한 클래스와 인터페이스 | 
| java.sql | 데이터베이스에 저장된 데이터에 접근하기 위한 클래스 | 
| java.util | 날짜, 난수 생성기 등의 유틸리티 클래스 |
| java.imageio | 자바 이미지 입출력 API | 
| javax.net | 네트워킹 애플리케이션을 위한 클래스 | 
| javax.swing | 스윙 컴포넌트를 위한 클래스 | 
| javax.xml | XML을 지원하는 패키지 |

<br>

### 8. Object 클래스
 
- `java.lang` 패키지에 들어있음   
- 자바 클래스 계층 구조에서 맨 위에 위치하는 클래스    
<br>

- 메소드
  
| 메소드 이름 | 설명 |
| --- | --- |
| pubilc boolean equals(Object obj) | obj가 이 객체와 같은지 검사 |
| public String toString() | 객체의 문자열 표현 반환 | 
| protected Object clone() | 객체 자신의 복사본 생성하여 반환 |
| public int hashCode() | 객체에 대한 해쉬 코드 반환 | 
| protected void finalize() | 가비지 콜렉터에 의해 호출됨 | 
| public final Class getClass() | 객체의 클래스 정보 반환 |


<br>

- `getClass()` : 객체가 어떤 클래스로 생성되었는지에 대한 정보 반환   

```java
class Circle {  }
public class CircleTest {
    public static void main(String[] args) {
        Circle obj = new Circle();
        System.out.println("obj is of type " + obj.getClass().getName());
        System.out.println("obj의 해쉬코드=" + obj.hashCode());
    }
}

// obj is of type test.Circle
// obj의 해쉬코드=1554547125
```
<br>

- `toString()` : 객체의 문자열 표현 반환   
- `equals()` : == 연산자 사용해서 객체의 주소가 동일한지 검사   

<br>

### 8. `Wrapper` 클래스

- 정수와 같은 __기초 자료형을 객체로__ 포장하고 싶은 경우 사용   

<br>

![wp](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnOz0t%2FbtrU1pEL5F9%2FYfPyNBmOlJCLUiQJtDsjOK%2Fimg.png)

<br>

```java
int i = 100;
Integer obj = new Integer(i);
```
<br>

- 메소드   

| 반환값 | 메소드 이름 | 설명 |
| ---- | ---- | ---- | 
| static int | intValue() | int형으로 반환 |
| static double | doubleValue() | double형으로 반환 |
| static float | floatValue() | float형으로 반환 |
| static int | parseInt(String s) | 문자열을 int형으로 변환 |
| static String | toBinaryString(int i) | int형 정수를 2진수 형태의 문자열로 변환 |
| static String | toString(int i) | int형 정수를 10진수 형태의 문자열로 변환 |
| static Integer | valueOf(String s) | 문자열 s를 Integer 객체로 변환 |
| static Integer | valueOf(String s, in radix)| 문자열 s를 radix 진법의 Integer 객체로 변환 |   

<br>

- 문자열 "100" -> 정수 100 : `Integer.parseInt()`
- 정수 100 -> 문자열 "100" : `Integer.toString()`

<br>

### 9. 오토박싱

- `intValue()` 대신
- 랩퍼 객체와 기초 자료형 사이의 변환을 자동으로 해주는 기능   
![auto](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F6ABGi%2FbtrU02iLjyx%2Fv419PWTLF2kRYHVMWwzzvK%2Fimg.png)   

<br>

```java
Integer obj;

obj = 10;                      // 정수 -> Integer 객체
System.out.println(obj + 1);   // Integer 객체 -> 정수
```

### 10. `String` 클래스

<br>

- 메소드

| 반환값 | 메소드 이름 | 설명 | 
| --- | --- | --- |
| char | charAt(int index) | 지정된 인덱스에 있는 문자 반환 |
| int | compareTo(String anotherString) | 사전적 순서로 문자열 비교 - 앞에 있으면 `-1`, 같으면 `0`, 뒤에 있으면 `1` 반환 |
| String | concat(String str) | 주어진 문자열을 현재 문자열 뒤에 붙임 |
| boolean | equals(Object anObject) | 주어진 객체와 현재 문자열 비교 |
| boolean | isEmpty() | `length()`가 0이면 `true` 반환 |
| int | length() | 현재 문자열의 길이 반환 |
| String | toLowerCase() | 문자열의 문자들 모두 소문자로 변경 |
| String | toUpperCase() | 문자열의 문자들 모두 대문자로 변경 |

<br>

### 11. String 클래스의 문자열 기초 연산

<br>

| 메소드 이름 | 설명 | 
| --- | --- |
| length() | 문자열 길이 반환 | 
| charAt() | String 객체 안에 들어있는 문자 추출 (문자 번호 0부터 시작) |
| concat() | 두 개의 문자열 붙임 |
| `+` 연산자 | 두 개의 문자열 붙임 | 
| indexOf() | 문자열 안에서 단어 찾기 |
| split() | 문자열을 단어로 분리 | 
| boolean contains(charSequence s) | s에 지정된 문자들을 포함하고 있으면 true 반환 |
| String replace(Charsequence target, Charsequence replacement) | target이 지정하는 일련의 문자들을 replacement가 지정하는 문자들로 변경한 문자열 객체 반환 |
| String subString(int beginIndex) | beginIndex 인덱스부터 시작하는 부분 문자열 반환 | 
| String subString(int beginIndex, int endIndex) | beginIndex부터 endIndex-1 까지의 부분 문자열 반환 |
| String trim() | 문자열 앞뒤의 공백 문자들을 제거한 문자열 객체 반환

<br>

```java
String s = "Hello World!"
char c = s.charAt(0);         // 'H' 반환
```   

<br>

```java
String s = "The cat is on the table";
int index = s.indexOf("table");

if(index == -1)
    System.out.println("table은 없습니다.");
else
    System.out.println("table의 위치: " + index);

// table의 위치: 18
```   
> indexOf() 
> - 같은 단어가 여러 번 있는 경우 가장 처음에 나오는 단어의 인덱스 반환
> - 모두 찾고 싶은 경우 반복문 이용!

<br>
  
```java
String[] tokens = "I am a boy.".split(" ");
for (String token : tokens)
    System.out.println(token);

/**
I
am
a
boy
**/
```

<br>


### 12.  `StringBuffer` 클래스

- `String` 클래스의 경우 빈번하게 문자열을 변경할 때 비효율적   
∵ 새로운 `String` 객체를 생성하고 기존의 내용을 복사해야 하기 때문   

<br>

| | String | StringBuffer |
| --- | --- | ---| 
| 메모리 위치 | String Pool | heap |
| 수정 여부 | X (immutable) | O (mutable) |
| 스레드 안정성 | O | O |
| 동기화 여부 | O | O |
| 성능 | Fast | Slow |


<br>

- 메소드
    - `append()`
    - `insert()`
    - 어떤 타입의 데이터도 받을 수 있도록 중복 정의 되어있음
```java
StringBuffer sb = new StringBuffer("Hello");   // 16바이트 공간 할당
int length = sb.length();        // 5
int capacity = sb.capacity();    // 21

StringBuffer sb = new StringBuffer("10+20=");
sb.append(10+20);
sb.insert(0, "수식 ");
// sb = "수식 10+20=30"
```

<br> 

### 13.  `Math` 클래스

- 지수, 로그, 제곱근, 삼각함수와 같은 기본적인 수치 연산을 위한 메소드 제공   

<br>

### 14.  `Random` 클래스

- 난수 발생

```java
import java.util.*;
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) 
            System.out.print(random.nextInt(100) + ", ");
    }
}

// 12, 48, 9, 3, 44, 84, 60, 4, 34, 50,
```

<br>

### 15.  Array 클래스

```java
import java.util.*;

public class ArraysTest {
    public static void main(String[] args) {
        int[] array = {9, 4, 5, 6, 2, 1};
        Arrays.sort(array);               // 정렬
        printArray(array);
        System.out.println(Arrays.binarySearch(array, 9));     // 9 탐색
        Arrays.fill(array,8);       // 배열 8로 채움
        printArray(array);
    }
    
    private static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("]");
    }
}

/**
[1 2 4 5 6 9 ]
5
[8 8 8 8 8 8 ]
```

<br>

### 16. `Calender` 클래스

- 추상 클래스, 날짜와 시간에 대한 정보   
- 특정 시각을 연도, 월, 일 등으로 변환하는 메소드   