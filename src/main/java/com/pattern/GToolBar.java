package com.pattern;

import javax.swing.*;
import java.awt.*;

public class GToolBar extends JToolBar {
    public GToolBar() {
        // 1. 툴바 기본 설정 (플로팅 방지 등)
        setFloatable(false); // 툴바가 창에서 떨어져 나가지 않게 고정

        // 2. 버튼들을 하나만 선택되게 그룹화 (선택 사항)
        ButtonGroup buttonGroup = new ButtonGroup();

        // 3. 버튼 만들기
        JRadioButton rectangle = new GToolBarButton("사각형", "/rectangle.png");
        JRadioButton ellipse = new GToolBarButton("타원", "/ellipse.png");
        JRadioButton line = new GToolBarButton("직선","/line.png");
        JRadioButton pencil = new GToolBarButton("연필","/pencil.png");
        JRadioButton eraser = new GToolBarButton("지우개", "/eraser.png");

        // 3. 버튼그룹에 버튼 추가 (논리적)
        buttonGroup.add(rectangle);
        buttonGroup.add(ellipse);
        buttonGroup.add(line);
        buttonGroup.add(pencil);

        // 4. 버튼을 툴바에다가 추가
        this.add(rectangle);
        this.add(ellipse);
        this.add(line);
        this.add(pencil);
        addSeparator(); // 구분선 추가
        this.add(eraser);

    }

}
