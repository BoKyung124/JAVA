### 1. 그리는 위치

- `JPanel` : 그림 그릴 수 있는 화면 갖고 있고, 동시에 컨테이너 역할도 함

```java
class MyPanel extends JPanel {
    ...
}

public class MyFrame extends JFrame {
    public MyFrame() {
        MyPanel panel = new MyPanel();
        add(panel);
    }
}
```

<br>

### 2. paintComponent()

- 컴포넌트가 가지고 있는 메소드   
- 모든 컴포넌트가 가지고 있으며, 이 메소드를 재정의함으로써 그림을 그림   
- 컴포넌트를 다시 그릴 필요가 있을 때마다 자바 시스템에 의해 호출됨 
  - ex. 프레임이 가려졌다가 다시 나타나는 경우   
- `super.paintComponent(g)` 호출   
- 전체 구성요소를 전부 그리는 것이 아닌 경우 호출   

```java
class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);                 
        // 그림그리는 코드
    }
}
```

<br>

### 3. repaint()

- 사용자가 직접 `paintComponent()`를 호출할 수 없음. 반드시 __자동으로__ 호출되어야 함   
- 사용자가 화면을 다시 그리고 싶은 경우 `repaint()` 호출   
-> repaint()가 적절한 시기에 paintComponent() 호출   

<br>

### 4. 색상 변경
```java
Color c = Color.BLUE;  
Color c = new Color(255, 0, 255);
```

- `setBackground(c)` : 컴포넌트 객체 배경색 설정
- `setColor(c)` : 전경색 설정
- `Color getColor()` : 현재 전경색 반환

<br>

### 5. 폰트 객체 생성

- Font(`폰트 이름`(Alias, Serif, Gothic ...) , `스타일`(Font.PLAIN, BOLD, ITALIC ...), `크기`(10, 30, ...))
```java
Font font = new Font("Courier", Font.PLAIN, 10);

public void paint(Graphics g) {
    g.setFont(font);
    ...
}

JLabel lbl = new JLabel("Hello");
lbl.setFont(new Font("Gothic", Font.BOLD, 30));
```

<br>

### 6. Graphics 클래스

- 텍스트 문자열 : `drawString();`
```java
g.drawString("Hello World!", x, y);   // x, y : 위치 설정
```
<br>

- 기초 도형들
- `draw---();` : 선으로 그리기
- `fill---();` : 채워서 그리기

<br>

| 기초 도형 | 관련 메소드 |
| --- | --- |
| 직선 | drawLine(), drawPolyline() |
| 사각형 | drawRect(), fillRect(), clearRect() | 
| 3차원 사각형 | draw3DRect(), fill3DRect() |
| 둥근 사각형 | drawRoundRect(), fillRoundRect() | 
| 타원 | drawOval(), fillOval() |
| 호 | drawArc(), fillArc() |
| 다각형 | drawPolygon(), fillPolygon() |

<br>

```java
drawLine(int x1, int y1, int x2, int y2);  // (x1, y1)에서 (x2, y2)까지 직선
drawRect(int x, int y, int width, int height);  // (x, y)에서 폭 width, 높이 height인 직사각형
drawOval(int x, int y, int width, int height);  
// (x, y)에서 폭 width, 높이 height인 직사각형에 내접하는 타원
drawArc(int x, int y, int width, int height, int startAngle, int arcAngle);
// 좌측 상단 좌표가 (x, y)이며 폭 width, 높이 height인 사각형에 내접하는 타원에서
// startAngle을 시작 각도로 하여 arcAngle의 각도만큼 호를 그림
drawPolygon(int[] x, int y[], length);   // 배열 x[], y[]를 갖고 여러 개의 직선 (전부 이음)
drawPolyline(int[] x, int y[], length);  // 배열 x[], y[]를 갖고 여러 개의 직선 (처음과 끝 잇지 않음)
```

<br>

- 이미지 : `drawImage();`
```java
ImageIcon icon = new ImageIcon("car.png");
img = icon.getImage();

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, x, y, null);
}
```

### 7. 그래픽 좌표계
![graphic](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fr1jo1%2FbtrVO1v2PJ6%2FOu8NIEtOPsLTcvaFqv4iHK%2Fimg.png)

<br>

### 8. 예제1) 화면 클릭하면 그 위치에 사각형 그리도록
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    int x, y;
    class MyPanel extends JPanel {
        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            });
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 100, 100);
        }
    }    
   
    public MyFrame() {
        setSize(600, 200);
        add(new MyPanel());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
        new MyFrame();
    }
}
```
![rect1](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcNltS1%2FbtrVUsmHpxn%2Fj2zuiKlox2liMunhs3Qcw1%2Fimg.png)   

![rect2](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FJjxiS%2FbtrVVIChILo%2F8GYSBqzgDcUKdUxLFxwHkk%2Fimg.png)


<br>

#### 발전 버전) 드래그 한 크기의 사각형 그리고 패널 위에 저장하기
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rect {
    int x, y, w, h;
    public Rect(int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
    }
}

public class GraphicTest extends JFrame {
    int x, y;
    int w = 100, h = 100;
    int x1, y1, x2, y2;
    Vector<Rect> list = new Vector<>();
    
    class MyPanel extends JPanel {
        public MyPanel() {
            addMouseListener(new mouseAdapter() {
                public void mousePressed(MouseEvent e) {   // 눌렀을 때 위치
                    x1 = e.getX();
                    y1 = e.getY(); 
                }
                
                public void mouseReleased(MouseEvent e) {    // 뗄 때 위치
                    x2 = e.getX();
                    y2 = e.getY();
                    x = Math.min(x1, x2);
                    y = Math.min(y1, y2);     // 사각형 시작점
                    w = Math.abs(x1-x2);
                    h = Math.abs(y1-y2);
                    
                    list.add(new Rect(x, y, w, h));    // 사각형 객체 모음
                    repaint();
                }
            });
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.orange);
            g.fillRect(x, y, w, h);    // 드래그하는 동안 그려지는 사각형
            for(Rect r : list)
                g.drawRect(r.x, r.y, r.w, r.h);
        }
    }
    
    public GraphicTest() {
        add(new MyPanel());
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new GraphicTest();
    }
}
```

<br>

### 9. 예제2) 바운싱 볼 애니메이션
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BounceBall extends JFrame implements ActionListener{
    static final int WIDTH = 600;
    static final int HEIGHT = 200;
    private static final int PERIOD = 10;
    
    class MyPanel extends JPanel {
        int x = 0, y = 0, xInc = 3, yInc = 3, diameter = 60;
        
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(x < 0 || x > (BounceBall.WIDTH - diameter))
                xInc = -xInc;
            if(y < 0 || y > (BounceBall.HEIGHT - diameter))
                yInc = -yInc;
            
            x += xInc;
            y += yInc;
            g.setColor(Color.RED);
            g.fillOval(x, y, diameter, diameter);
        }
    }
    
    public BounceBall() {
        MyPanel panel = new MyPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);
        pack();
        
        Timer timer = new Timer(PERIOD, this);
        timer.start();
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
    
    public static void main(String[] args) {
        new BounceBall();
    }
}
```