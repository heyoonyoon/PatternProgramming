package com.pattern;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame {
    public GFrame(){
        setTitle("그래픽 편집기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 (JFrame의 하위 계층으로, Menu Bar와 형제 관계이다)
        Container contentpane = getContentPane();
        contentpane.setLayout(new BorderLayout()); // 동서남북 배치를 위해 설정
        GToolBar toolBar = new GToolBar(); // 툴바 생성
        GPanel canvas = new GPanel();     // 캔버스 생성


        contentpane.add(toolBar, BorderLayout.NORTH); // 북쪽에 툴바 (형 1)
        contentpane.add(canvas, BorderLayout.CENTER);  // 중앙에 캔버스 (형 2)

        // 메뉴바
        setJMenuBar(new GMenuBar()); // 메뉴바 설정
        setSize(600,600);
        setVisible(true);

    }
}
