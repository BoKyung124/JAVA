### 1. 제네릭 (generic programming)

- __다양한 종류의 데이터__ 를 처리할 수 있는 클래스와 메소드를 작성하는 기법   
> ex) 
```java
class Box<T>   { ... }       // T : 타입 매개변수 - String도 될 수 있고, Integer도 될 수 있음
```

<br>

### 2. 기존의 방법

- 일반적인 객체를 처리하려면 `Object 참조 변수` 사용: 어떤 객체이든지 참조 가능
```java
public class Box {
    private Object data;
    private void set(Object data) { this.data = data; }
    public Object get() { return data; }
}

Box b = new Box();

b.set("Hello World!");          // 문자열 객체 저장
String s = (String)b.get();     // Object 타입을 String 타입으로 형변환

b.set(new Integer(10));         // 정수 객체 저장  
Integer i = (Integer)b.get();   // Object 타입을 Integer 타입으로 형변환

b.set("Hello World!");
Integer i = (Integer)b.get();   // 오류! 문자열을 정수 객체로 형변환 (x)
```

<br>

3. 제네릭을 이용한 방법
```java
class Box<T> {
    private T data;
    public void set(T data) { this.data = data; }
    public T get() { return data; }
}

Box<String> b = new Box<String>();
b.set("Hello World!");     // 문자열 저장
String s = b.get();

Box<String> stringBox = new Box<>();   // 뒤에 나오는 타입 <> 생략 가능
stringBox.set(new Integer(10));        // 정수 타입을 저장하려고 하면 컴파일 오류!
```

<br>

### 4. 제네릭 메소드
- 일반 클래스의 메소드에서도 `타입 매개 변수`를 사용해서 제네릭 메소드 정의 가능
- 이 경우에는 타입 매개 변수의 범위가 메소드 내부로 한정됨
```java
public class MyArray {
    public static <T> T getLast(T[] a) {    // 제네릭 메소드 정의
        return a[a.length - 1];
    }
}

public class MyArrayTest {
    public static void main(String[] args) {
        String[] language = { "C++", "C#", "JAVA" };
        String last = MyArray.getLast(language);      // last는 "JAVA"
        System.out.println(last);
    }
} 


// JAVA
```
<br>

- 예제2
```java
public class GenericTest {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] iArray = {10, 20, 30, 40, 50};        // wrapper 클래스
        Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5};
        Character[] cArray = {'K', 'O', 'R', 'E', 'A'};
        
        printArray(iArray);
        printArray(dArray);
        printArray(cArray);
    }
}

/**
10 20 30 40 50 
1.1 1.2 1.3 1.4 1.5
K O R E A
**/
```
> 제네릭 메소드에는 기본 data type을 매개 변수로 넘길 수 없음!   
> 객체 데이터 타입을 넘겨야 함 -> `wrapper` 클래스 이용   