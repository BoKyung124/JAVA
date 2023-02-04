### 1. 스윙 컴포넌트

- 윈도우 기반 응용 프로그램을 만드는데 사용되는 JFC(Java Foundation Classes) 의 일부   
- AWT와 달리 플랫폼 독립적이고 경량 컴포넌트 구조   
- JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser 등   

<br>

### 2. JComponent 클래스

- 최상위 컨테이너를 제외하고는 거의 모든 컴포넌트가 `JComponent`를 상속받음   
-  ex) JPanel, JLabel, JComboBox 등
- 스윙 컴포넌트들이 공통적으로 가져야하는 `속성`과 `메소드` 포함

<br>

#### 2-1) JComponent 메소드   
- 컴포넌트 외관 변경
  
| 메소드 | 설명 |
| --- | --- |
| setBorder(Border), getBorder() | 컴포넌트 경계 설정 | 
| setForeground(Color), setBackground(Color) | 컴포넌트의 전경색, 배경색 설정 |
| getForeground(), getBackground() | 컴포넌트의 전경색, 배경색 얻음 |
| setFont(Font), getFont() | 컴포넌트 폰트 설정 | 
| setCursor(Cursor), getCursor() | 컴포넌트 커서 설정|

<br>

- 컴포넌트 상태 변경

| 메소드 | 설명 | 
| --- | --- |
| setToolTipText(String) | tool tip에 표시되는 텍스트 설정 |
| setEnabled(boolean) <br/> isEnabled() | 컴포넌트 활성화하거나 비활성화 함 |
| setVisible(boolean) <br/> isVisible() | 컴포넌트 화면에 표시 |

<br>

- 공통 이벤트 처리

| 메소드 | 설명 |
| --- | --- |
| addMouseListener(MouseListener) <br/> removeMouseListener(MouseListener) | 마우스 리스너 추가하거나 제거 |
| ... | ... |

<br>

- 컴포넌트 그리기

| 메소드 | 설명 |
| --- | --- |
| repaint() | 컴포넌트의 일부나 전체 다시 그리도록 요청 |
| revalidate() | 컨테이너 안의 컴포넌트 다시 배치하도록 요청 |
| paintComponent(Graphics) | 컴포넌트 그리기 <br/> 컴포넌트에서는 이 메소드를 재정의하여 컴포넌트 위에 그림 그릴 수 있음 |

<br>

- 컨테이너에 추가 / 제거

| 메소드 | 설명 |
| --- | --- |
| add(Component) | 컴포넌트를 컨테이너에 추가 |
| remove(Component) | 컨테이너에서 컴포넌트 삭제 |
| getParent() | 컴포넌트의 컨테이너 반환 |

<br>

- 레이아웃

| 메소드 | 설명 |
| --- | --- |
| getWidth(), getHeight() | 픽셀 단위의 컴포넌트 크기 반환 |
| getSize() | 픽셀 단위의 컴포넌트 크기 반환 | 
| getX(), getY() | 부모 컨테이너 안에서의 컴포넌트의 상대적인 위치 반환 |
| getLocation() | 부모 컨테이너 안에서의 상대적인 위치 반환 |
| setLocation(int, int) | 부모 컨테이너 안에서의 컴포넌트의 좌표 지정 | 
| setBounds(int, int, int, int) | 부모 컨테이너 안에서의 크기와 위치 설정 |

<br>

- 크기와 위치 정보 얻기

| 메소드 | 설명 |
| --- | --- |
| setPreferredSize(Dimension) <br/> setMaximumSize(Dimension) <br/> setMinimumSize(Dimension) | 컴포넌트 크기 설정 |
| setAlignmentX(float), setAlignmentY(float) | 컨테이너 안에서 컴포넌트들의 정렬 지정 | 
| setLayout(LayoutManager), getLayout() | 배치 관리자 설정 |

<br>

### 3. 예제

> 텍스트 필드로 사용자에게 정수 입력받은 뒤 제곱 반환
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextTest extends JFrame {
    private JButton button;
    private JTextField text, result;
    public TextTest() {
        setSize(300, 150);
        
        ButtonListener listener = new ButtonListener();
        JPanel panel = new JPanel();
        panel.add(new JLabel("숫자 입력: "));
        
        text = new JTextField(15);
        text.addActionListener(listener);
        panel.add(text);
        
        panel.add(new JLabel("제곱한 값: "));
        result = new JTextField(15);
        result.setEditable(false);    // 출력만 가능
        panel.add(result);
        
        button = new JButton("OK");
        button.addActionListener(listener);
        panel.add(button);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    // 내부 클래스로서 텍스트 필드와 버튼의 액션 이벤트 처리
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button || e.getSource() == text) {
                String name = text.getText();
                int value = Integer.parseInt(name);
                resutl.setText("" + value * value);
                text.requestFocus();         // 텍스트창 선택됨
            }
        }
    }
    
    public static void main(String[] args) { 
        new TextTest();
    }
}
```

<br>

![text](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkUDVy%2FbtrVE2nZ5ec%2FFnYoXhSBpdJPG2Eg4pROm0%2Fimg.png)

<br>

### 4. JTextArea

- 텍스트 필드는 한 줄만 들어갈 수 있는 반면, 텍스트 영역은 여러 줄의 텍스트 들어갈 수 있음
```java
textArea = new JTextArea(10, 30);     // 10행 30열의 텍스트 영역 생성
```

<br>

### 5. scroll pane 

- 컴포넌트에 스크롤 기능 제공

```java
textArea = new JTextArea(6, 30);
JScrollPane scrollpane = new JScrollPane(textArea);
add(scrollpane, "Center");
```
![scroll](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbWo5dG%2FbtrVI7h3pZ7%2FoCRs7f8o4pmOeKUTpdaE40%2Fimg.png)

<br>

### 6. check box
![check](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fpbb42%2FbtrVCeI4FAv%2FhdtIQg15UgKkN3OL30xAJ0%2Fimg.png)

<br>

- 체크박스를 클릭하면 `ItemEvent` 발생   
-> `ItemListener` 구현해야 함 - 익명 클래스 사용하는 것이 편함   
```java
JCheckBox check = new JChechBox("CheckBox", false);
check.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        System.out.println("체크 상태: " + check.isSelected());
    }
});
```

<br>

> 예제
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxTest extends JFrame { 
    public CheckBoxTest() { 
        setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel();
        JCheckBox cbPizza = new JCheckBox("피자");
        JCheckBox cbPasta = new JCheckBox("스파게티");
        add(cbPizza);
        add(cbPasta);
        add(label);
        
        cbPizza.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("피자가 " + (e.getStateChange() == 1 ? "선택되었습니다." : "선택해제되었습니다."));
            }
        });
        
        cbPasta.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("스파게티가 " + (e.getStateChange() == 1 ? "선택되었습니다." : "선택해제되었습니다."));
            }
        });
        
        setSize(300, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
```
![checkbox](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdiKnRC%2FbtrVCeWBKdl%2Fr0znSP8CGx2Z0kBPOcdQ20%2Fimg.png)

<br>

### 7. 라디오 버튼

- 체크 박스와 비슷하지만, 라디오 버튼은 하나의 버튼 그룹 안에서는 한 개의 버튼만 선택할 수 있음   

```java
JRadioButton radio1 = new JRadioButton("Small Size");
JRadioButton radio2 = new JRadioButton("Medium Size");
JRadioButton radio3 = new JRadioButton("Large Size");

// button group 객체 생성
ButtonGroup group = new ButtonGroup();

// 그룹에 라디오 버튼 객체들 추가
group.add(radio1);
group.add(radio2);
group.add(radio3);
```

<br>

### 8. 콤보 박스

- 여러 항목 중에서 하나 선택   
- 텍스트 필드와 리스트의 결합   
- 텍스트 직접 입력, 리스트에서 선택 둘 다 가능   

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxFrame extends JFrame implements ActionListener {
    JLabel lbl;
    
    public ComboBoxFrame() {
        setSize(400, 200);
        
        String[] ani = {"dog", "cat", "bird"};
        JComboBox aniList = new JComboBox(ani);
        aniList.setSelectedIndex(0);
        aniList.addActionListener(this);
        
        lbl = new JLabel();
        lbl.setHorizontalAlignment(JLabel.CENTER);
        changePicture(ani[aniList.getSelectedIndex()]);
        
        add(aniList, "North");
        add(lbl, "Center");
        setVisible(true)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String name = (String) cb.getSelectedItem();
        changePicture(name);
    }
    
    protected void changePicture(String name) {
        ImageIcon icon = new ImageIcon(name + ".png");
        lbl.setIcon(icon);
        if(icon != null) 
            lbl.setText(null);
        else
            lbl.setText("이미지가 발견되지 않았습니다.");
    }
    
    public static void main(String[] args) {
        new ComboBoxFrame();
    }
}
```
![combo](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbNvM06%2FbtrVzY8hA70%2FmyeCb0nBwGoLwdBRCk8nsk%2Fimg.png)

<br>

### 9. 메뉴 붙이기

- 윈도우 상단에 위치한 메뉴바 생성   
- 팝업 메뉴는 팝업이 가능한 컴포넌트 위에서 마우스 오른쪽 버튼을 누르면 그 위치에 등장   
- 메뉴 항목은 이미지나 텍스트 가질 수 있음   

<br>

- 메뉴 생성 절차 `[메뉴바 - 메뉴 - 메뉴항목]`
```java
// 1. 메뉴바 관련 변수 설정
JMenuBar menuBar;
JMenu menu;
JMenuItem menuItem;

// 2. 메뉴바 생성
menuBar = new JMenuBar();

// 3. 메뉴 생성하여 메뉴바에 추가
menu = JMenu("메뉴 1");
menuBar.add(menu);

// 4. 메뉴 항목 생성하여 메뉴에 추가
menuItem = new JMenuItem("메뉴 항목1", KeyEvent.VK_T);
menu.add(menuItem);

// 5. 프레임에 메뉴바 설정
frame.setJMenuBar(mb);

- 메뉴 이벤트 처리
// 각각의 메뉴 항목에 대해 액션 이벤트 처리기 등록
menuItem.addActionListener(this);
```

<br>

### 10. 슬라이더

- 사용자가 특정한 범위 안에서 하나의 값을 선택할 수 있는 컴포넌트   
- 슬라이더, 이벤트 처리   

```java
slider = new JSlider(0, 100, 50);

slider.setMajorTickSpacing(10);     // 큰 눈금 간격
slider.setMinorTickSpacing(1);      // 작은 눈금 간격
slider.setPaintTicks(true);         // 눈금 표시
slider.setPaintLabels(true);        // 값을 레이블로 표시

slider.addChangeListener(this);

public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider) e.getSource();
    if (!source.getValueIsAdjusting()) {
        int value = (int) source.getValue();
        button.setSize(value * 10, value * 10);
}
```