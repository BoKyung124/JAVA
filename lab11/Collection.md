### 1. 컬렉션 collection

- 자바에서 자료구조를 구현한 클래스
- list, stack, queue, set, hash table 등
- `컬렉션 인터페이스`와 `컬렉션 클래스`로 나누어 제공

<br>

![collection](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fpqw7g%2FbtrVU979OCG%2FIk5XRrPkAX8CFkVt6jHhO0%2Fimg.png)

<br>

- 컬렉션 인터페이스

| 인터페이스 | 설명 | 
| --- | --- |
| Collection | 모든 자료구조의 부모 인터페이스로서 객체의 모임 나타냄 | 
| Set | 집합 (중복된 원소 불가) | 
| List | 순서가 있는 자료구조 (중복된 원소 가능) |
| Map | 키와 값들이 연관되어 있는 dictionary와 같은 자료구조 |
| Queue | 선입선출 자료구조 |

<br>

### 2. 컬렉션 특징
- `제네릭` 사용
- 컬렉션에는 int, double과 같은 기초 자료형 사용 불가. `클래스`만 가능!
- 기초 자료형은 wrapper 클래스로 사용 (Integer, Double 등)
- 기본 자료형을 저장하면 자동으로 래퍼 클래스의 객체로 변환됨 (오토박싱)

<br>

### 3. 컬렉션 인터페이스 주요 메소드

| 메소드 | 설명 | 
| --- | --- |
| boolean isEmpty() <br/> boolean contains(Object obj) <br/> boolean cotainsAll(Colllection<?> c) | 공백 상태이면 true 반환 <br/> obj 포함하고 있으면 true 반환 |
| boolean add(E element) <br/> boolean addAll(Collection<? extends E> from) | 원소 추가 |
| boolean remove(Object obj) <br/> boolean removeAll(Collection<?> c) <br/> boolean retainAll(Collection<?> c) <br/> void clear() | 원소 삭제 | 
| Iterator\<E> iterator() <br/> Stream\<E> stream() <br/> Stream\<E> parallelStream() | 원소 방문 |
| int size() | 원소 개수 반환 | 
| Object[] toArray() <br/> \<T> T[] toArray(T[] a) | 컬렉션을 배열로 변환 |

<br>

### 4. 컬렉션 모든 요소 방문하기
```java
String a[] = new String[] {"A", "B", "C", "D", "E" };
List<String> list = Arrays.asList(a);

// 1. for문
for(int i = 0; i < list.size(); i++) 
    System.out.println(list.get(i));

// 2. for-each문
for(String s : list)
    System.out.println(s);
    
// 3. Iterator(반복자)
String s;
Iterator e = list.iterator();     
while(e.hasNext()) {
    s = (String) e.next();          // e는 Object 타입 반환
    System.out.println(s);
}

// 4. Stream 라이브러리 - forEach 메소드 & 람다식
list.forEach((n) -> System.out.println(n));
```
<br>

### 5. Iterator
- 특별한 타입의 객체로, __컬렉션의 원소들에 접근__ 하는 것이 목적
- 모든 컬렉션에 적용

<br>

| 메소드 | 설명 | 
| --- | --- |
| hasNext() | 아직 방문하지 않은 원소가 있으면 true 반환 |
| next() | 다음 원소 반환 |
| remove() | 최근에 반환된 원소 삭제 |

<br>

### 6. 람다식
- 나중에 실행될 목적으로 다른 곳에 전달될 수 있는 코드 블록   
```java
(int a, int b) -> { return a + b; }
// 매개변수     연산자      몸체
```
- 0개 이상의 매개 변수 가질 수 있음   
- 화살표 `->` 는 람다식에서 매개 변수와 몸체 구분   
- 매개 변수의 형식을 명시적으로 선언할 수 있으며, 문맥에서 추정될 수도 있음   
  - `(int a) == (a)`   
  - 빈 괄호는 매개 변수가 없음을 뜻함     
    - `ex. () -> 23`   
- 단일 매개 변수이고 타입이 유추가 가능한 경우에는 괄호 사용할 필요 없음     
  - `ex. a -> return a*a;`   
- 몸체에 하나 이상의 문장이 있으면 `{ }`로 묶어야 함   

<br>

```java
() -> System.out.println("Hello World");

(String s) -> { System.out.println(s); }

() -> 60

() -> { return 3.141592; }

(String s) -> s.length()

(Car c) -> c.getprice() > 150

(int x, int y) -> {
    System.out.print("결과값: ");
    System.out.println(x+y);
}

(Car c1, Car c2) -> c1.getPrice().compareTo(c2.getPrice())
```

<br>

### 7.  람다식 활용

> GUI 코드를 작성할 때 함수 몸체를 전달하고 싶은 경우
```java
// 기존
btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button click");
    }
});

// 람다식
btn.addActionListener( (e) -> {
    System.out.println("button click");
});
```

<br>

> 스레드 작성시 runnable 인터페이스 구현
```java
// 기존
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("thread start");
    }
}).start();

// 람다식
new Thread( () -> System.out.println("thread start") ).start();
```

<br>

> 배열의 모든 요소 출력
```java
// 기존
List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5 );

for (Integer n : list )
    System.out.println(n);

// 람다식
list.forEach( n -> System.out.println(n) );
```

<br>

### 8. 컬렉션 - `Vector` 클래스

- 가변 크기의 배열 (dynamic array)
- vector의 크기는 자동으로 관리됨

![vector](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcRDUOb%2FbtrVUl2eOv9%2FSV0ojfv5PS4nyhW7YKnNeK%2Fimg.png)

<br>

```java
import java.util.*;

public class VectorEx {
    public static void main(String[] args) {
        Vector<String> vec = new Vector<String>(2);
        vec.add("Apple");
        vec.add("Orange");
        vec.add("Mango");
        
        System.out.println("Vector size: " + vec.size());
        Collections.sort(vec);
        for(String s : vec)
            System.out.print(s + " ");
    }
}

// Vector size: 3
// Apple Mango Orange
```

<br>

### 9. ArrayList

- 가변 크기의 배열(Array)
```java
ArrayList<String> list = new ArrayList<String>();
```

<br>

| 메소드 | 설명 | 
| --- | --- | 
| list.add() | 원소 추가 | 
| list.set(2, "GRAPE") | 인덱스 2의 원소를 "GRAPE"로 교체 |
| list.remove(3) | 인덱스 3의 원소 삭제 |

<br>

```java
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() { return "(" + x + ", " + y + ")"); }
}

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList();
        
        list.add(new Point(0, 0));
        list.add(new Point(4, 0));
        list.add(new Point(3, 5));
        list.add(new Point(-1, 3));
        list.add(new Point(13, 2));
        
        System.out.println(list);
    }
}

// [(0, 0), (4, 0), (3, 5), (-1, 3), (13, 2)]
```

<br>

### 10.  Vector vs ArrayList

- `Vector`는 스레드 간 동기화 지원
- `ArrayList`는 동기화 X - Vector보다 성능은 우수함
![vs](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbEsTyh%2FbtrVU8IcOup%2FTQekA6HplLnjzo2GlH0NA0%2Fimg.png)

<br>

### 11. LinkedList
- 빈번하게 삽입과 삭제가 일어나는 경우에 사용
- 배열 중간 삽입은 원소들의 이동이 발생하지만, 연결 리스트는 `링크`만 수정하면 됨

![linked](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FHgxZf%2FbtrVQOEtuh0%2FLMqsgJjk1kbc03k7kNVPUk%2Fimg.png)

<br>

```java
import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("MILK");
        list.add("BREAD");
        list.add("BUTTER");
        list.add(1, "APPLE");
        list.add(2, "GRAPE");
        list.remove(3);
        
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i) + " ");
    }
}

// MILK APPLE GRAPE
```

<br>

### 12. ArrayList vs LinkedList

- `ArrayList`는 인덱스를 가지고 원소에 접근할 경우, 항상 일정한 시간만 소요됨
- `ArrayList`는 리스트의 각각의 원소를 위해 노드 객체를 할당할 필요 없음
- 동시에 많은 원소를 이동해야 하는 경우 `System.arraycopy()` 메소드 사용 가능

<br>

- 리스트의 처음에 빈번하게 원소를 추가하거나, 내부 원소 삭제를 반복하는 경우에는 `LinkedList`를 사용하는 것이 나음
- 이들 연산은 `LinkedList`에서는 일정한 시간만 걸리지만, `ArrayList`에서는 원소의 개수에 비례하는 시간 소요됨

<br>

### 13. Set

- 원소의 중복 허용X
- 순서 없음
- 인터페이스 구현 방법
  - `HashSet` : 해쉬 테이블에 원소 저장 -> 성능 면에서 가장 우수, 순서가 일정하지 않다는 단점
  - `TreeSet` : red-black tree에 원소 저장 -> 값에 따라 순서가 결정됨, HashSet보다는 느림
  - `LinkedHashSet` : 해쉬 테이블과 연결 리스트를 결합한 것, 원소 순서 = 삽입 순서

<br>

```java
import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        
        set.add("Milk");
        set.add("Break");
        set.add("Butter");
        set.add("Cheese");
        set.add("Ham");
        set.add("Ham");
        
        System.out.println(set);
        
        if(set.contains("Ham"))
            System.out.println("Ham도 포함되어 있음");
    }
}

// [Ham, Butter, Cheese, Milk, Bread]
// Ham도 포함되어 있음
```

<br>

### 14. set 대량 연산 메소드

| 메소드 | 설명 | 
| --- | --- | 
| s1.containsAll(s2) | s2가 s1의 부분집합이면 true 반환 |
| s1.addAll(s2) | s1을 s1과 s2의 합집합으로 만듦 | 
| s1.retainAll(s2) | s1을 s1과 s2의 교집합으로 만듦 |
| s1.removeAll(s3) | s1을 s1과 s2의 차집합으로 만듦 |

<br>

### 15. Map

- `Dictionary`와 같은 자료 구조
- 많은 데이터 중 원하는 데이터 빠르게 찾을 수 있음

![map](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fva2in%2FbtrVUkvujIq%2FW7sK8yGGzZZjRV0HUxp9H0%2Fimg.png)

<br>

```java
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        
        map.put("kim", "1234");
        map.put("lee", "pass");
        map.put("park", "word");
        
        System.out.println(map.get("lee"));
        for(String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }
        
        map.remove("lee");
        map.put("choi", "password");
        map.put("choi", "pw");          // 대치 
        System.out.println(map);
```

<br>

### 16. map의 모든 요소 방문
```java
// 1. for-each 구문 & keySet()
String.out.println("key: " + key + ", value" + map.get(set));
    
//  2. Iterator
Iterator<String> e = map.keySet().iterator();
while (e.hasNext()) {
    String key = e.next();
    System.out.println("key: " + key + ", value: " + map.get(key));
}

// 3. Stream 라이브러리
map.forEach( (key, value) -> {
    System.out.println("key: " + key + ", value: " + value);
});
```

<br>

### 17. 큐 Queue
- 선입선출 (tail에 원소 추가, head에서 원소 제거)
- `Queue` 인터페이스로 정의
- 이 인터페이스를 구현한 3개의 클래스
  - `ArrayDeque`
  - `LinkedList `
  - `PriorityQueue`

<br>

| 메소드 | 설명 |
| --- | --- |
| add() | 새로운 원소 추가가 큐의 용량을 넘어서지 않으면 원소 추가 |
| remove(), poll() | 큐의 처음에 있는 원소 제거하거나 가져옴 <br/> 정확히 어떤 원소인지는 큐의 정렬 정책에 따라 달라짐 |

<br>

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] ars) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            q.add(i);
        System.out.println("큐의 요소: " + q);

        int e = q.remove();
        System.out.println("삭제된 요소: " + e);
        System.out.println(q);
    }
}

// 큐의 요소: [0, 1, 2, 3, 4]
// 삭제된 요소: 0
// [1, 2, 3, 4]
```

<br>

#### 17-1) 우선순위 큐

- 원소들이 무작위로 삽입되었더라도 정렬된 상태로 추출
- `remove()`를 호출할 때마다 가장 작은 원소가 추출됨

```java
import java.util;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(30);
        pq.add(80);
        pq.add(20);

        System.out.println(pq);
        System.out.println("삭제된 원소: " + pq.remove());
    }
}

// [20, 80, 30]
// 삭제된 원소: 20
```

### 18. Collection 클래스
- 여러 유용한 알고리즘을 구현한 메소드들 제공   
<br>

#### 18-1) 정렬 sorting
```java
List<String> list = new LinkedList<String>();
list.add("철수");
list.add("영희");
Collections.sort(list);     // 리스트 안 문자열이 정렬됨
```

<br>

> 리스트 안의 문자열 정렬
```java
import java.util.*;

public class Sort {
    public static void main(String[] args) {
        String[] sample = {"i", "walk", "the", "line"};

        List<String> list = Arrays.asList(sample);    // 배열을 리스트로 변경

        Collections.sort(list);
        System.out.println(list);
    }
}

// [i, line, the, walk]
```
<br>

> 사용자 클래스의 객체 정렬
```java
import java.util.*;

class Student implements Comparable<Student> {
    int number;
    String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String toString() { return name; }

    public int compareTo(Student s) {
        return s.number - number;
    }
}

public class SortTest {
    public static void main(String[] args) {
        Student array[] = {
            new Student(2, "김철수");
            new Student(3, "이철수");
            new Student(1, "박철수");
        };

        List<Student> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list);
    }
}

// [박철수, 김철수, 이철수]
```
<br>

#### 18-2) 섞기 shuffling
 
- 정렬의 반대 동작   
- 리스트에 존재하는 정렬을 파괴해서 원소들의 순서를 랜덤하게 만듦   

<br>

```java
import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++) 
            list.add(i);
        Collections.shuffle(list);
        System.out.println(list);
    }
}

// [5, 9, 7, 3, 6, 4, 8, 2, 1, 10]
```

<br>

#### 18-3) 탐색 searching

- 리스트 안에서 원하는 원소를 찾는 것   
- `선형 탐색` : 정렬되어 있지 않은 경우 처음부터 모든 원소를 방문하는 방법   
- `이진 탐색` : 정렬되어 있는 경우 중간에 있는 원소와 먼저 비교하는 방법 

<br>

```java
import java.util.*;

public class Search {
    public static void main(String[] args) {
        int key = 50;
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 100; i++)
            list.add(i);
        
        int index = Collections.binarySearch(list, key);
        System.out.println("탐색의 반환값: " + index);
    }
}

// 탐색의 반환값: 50
```