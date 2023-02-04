### 1. 그래픽 사용자 인터페이스 (GUI)

- 컴포넌트들로 구성   

<br>

| Java AWT | Java Swing |
| --- | --- | 
| 플랫폼에 의존적 | 플랫폼에 독립적 |
| 컴포넌트들이 용량이 큼 | 컴포넌트 용량이 가벼움 |
| 교체할 수 있는 룩앤필(look and feel) 지원 X | 교체할 수 있는 룩앤필(look and feel) 지원 O |
| 컴포넌트 개수 적음 | 컴포넌트 개수 많음 |

<br>

### 2. 스윙 패키지 

- `java.awt` : GUI 컴포넌트를 위한 부모 클래스들 제공    
  \+ color, point와 같은 유틸리티 타입의 클래스 포함   
- `java.awt.event` : GUI 컴포넌트로부터 발생되는 이벤트를 처리하기 위한 클래스와 인터페이스 (버튼 클릭, 마우스 움직임 등)    
- `javax.swing` : 버튼, 텍스트 필드, 프레임, 패널과 같은 GUI 컴포넌트들 포함   

<br> 

### 3. 컨테이너와 컴포넌트

- __기본 컴포넌트__ : JButton, JLabel, JCheckBox, JChoice, JList, JMenu, JTextField, JScrollbar, JTextArea, JCanvas 등   
- __컨테이너 컴포넌트__ : 다른 컴포넌트들을 안에 포함할 수 있는 컴포넌트   
   : JFrame, JDialog, JApplet, JPanel, JScrollPane 등   

<br>

- __최상위 컨테이너__ : 절대 다른 컨테이너 안에 포함될 수 없는 컨테이너 (JFrame, JDialog, JApplet 등)   
- __일반 컨테이너__ : 다른 컨테이너 안에 포함될 수 있는 컨테이너 (JPanel, JScrollPane 등)   

<br>

### 4. GUI 작성 절차

- `컨테이너` 생성 -> `컴포넌트` 추가  

<br>

### 5. 프레임 생성

```java
#1
import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("Frame Test");
        f.setTitle("MyFrame");
        f.setSize(300, 200);
        f.setVisible(true);
        f.DefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```
<br>

```java
#2
import javax.swing.*;

public class MyFrame extends JFrame {
    pubic MyFrame() {
        setSize(300, 200);
        setTitle("My Frame");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }
}
```
<br>

![frame](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcRbQji%2FbtrVE0J1Al2%2FbKfG810AgsnmzH1vgK66Bk%2Fimg.jpg)

<br>

### 6. 프레임에 버튼 추가
```java
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setSize(300, 200);
        setTitle("My Frame");
        
        setLayout(new FlowLayout());
        JButton button = new JButton("버튼");
        add(button);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
```

<br>

### 7. 컨테이너 - `JFrame`
![jframe](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fc1GyRJ%2FbtrVzAfkfHr%2F0daG85NVKKqCr4kTFtO2W1%2Fimg.jpg)
<br>

- 컨테이너는 컴포넌트들을 트리 형태로 저장
- 최상위 컨테이너는 이 트리의 루트 노드가 됨
- 최상위 컨테이너는 내부에 콘텐트 팬 보유 - 화면에 보이는 컴포넌트 저장
- 최상위 컨테이너에는 메뉴바 추가 가능

<br>

- 중요 메소드

| 메소드 이름 | 설명 | 
| --- | --- |
| add(component) | 프레임에 컴포넌트 추가 |
| setLocation(x, y), setSize(width, height) | 프레임의 위치와 크기 설정 |
| setIconImage(IconImage) | 윈도우 시스템에 타이틀 바, 태스크 스위처에 표시할 아이콘 | 
| setTitle() | 타이틀바 제목 변경 |
| setResizable(boolean) | 사용자가 크기 조절 가능 여부 |

<br>

### 8. `JPanel` 클래스

- `패널` : 컴포넌트들을 부착할 수 있도록 설계된 컨테이너 중 하나 (최상위 컨테이너는 아님)   
- 별도의 패널을 쓰는 것이 유지 보수 및 배치 관리에 유리한 경우가 많음   

<br>

- 메소드

| 메소드 이름 | 설명 | 
| --- | --- |
| add(aComponent) | 패널에 컴포넌트 추가 |
| remove(aComponent) | 패널에서 컴포넌트 삭제 | 
| setBackGround(Color c) | 패널의 배경색 변경 | 

<br>

> ex)
```java
public class MyFrame extends JFrampe {
    public MyFrame() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        
        JButton b1 = new JButton("Button 1");
        b1.setBackground(Color.yellow);
        
        JButton b2 = new JButton("Button 2");
        b2.setBackground(Color.green);
        
        panel.add(b1);
        panel.add(b2);
        add(panel);
        
        setSize(300, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
```
<br>

![button](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FS147b%2FbtrVzE9Ml2p%2FSygMJReFj00HwlyUjvtD50%2Fimg.jpg)

<br>

### 9. 배치 관리자 (layout manager)

- __컨테이너만__ 사용 가능   
- 컨테이너 안의 각 컴포넌트의 위치와 크기를 결정하는 작업   

<br>

#### 9-1) 배치관리자 종류
##### 1) FlowLayout   
- 컨테이너에 추가되는 순서대로 컴포넌트 배치   
- 위에서 아래로, 왼쪽에서 오른쪽으로   
- `패널`의 기본 배치 관리자   

<br>

##### 2) BorderLayout
- 컨테이너의 영역을 동서남북, 중앙의 5개 영역으로 구분하여 배치   
- 한 구역에 한 개의 컴포넌트만 배치 가능   
- `add(btn, "South");`
- `프레임`의 기본 배치관리자   

<br>

##### 3) GridLayout
- 컨테이너 공간을 동일한 크기의 격자로 나누고, 이 격자에 컴포넌트 배치

<br>

##### 4) CardLayout
- 컨테이너에 컴포넌트를 카드처럼 겹치게 쌓아 배치
- 한 번에 하나의 컴포넌트만 볼 수있게 배치

<br>

#### 9-2) 설정
- 생성자 이용 : `JPanel panel = new JPanel(new BorderLayout());`
- setLayout() 이용 : `panel.setLayout(new FlowLayout());`

<br>

### 10.  절대 위치로 배치

- 배치 관리자  null로 설정 : `setLayout(null);`
- `add()` 메소드로 컴포넌트를 컨테이너에 추가
- 컴포넌트의 위치와 크기 지정
   - `setBounds(h, w, a, d);`