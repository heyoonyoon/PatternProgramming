package com.pattern;

import javax.swing.*;

public class GMenuBar extends JMenuBar {
    public GMenuBar() {
        // [파일] 메뉴 구성
        JMenu fileMenu = new JMenu("파일");
        fileMenu.add(new JMenuItem("새로 만들기")); // 메뉴 아이템 생성 후, "파일" 메뉴에 추가
        fileMenu.add(new JMenuItem("저장"));
        fileMenu.add(new JMenuItem("종료"));
        this.add(fileMenu);

        // [편집] 메뉴 구성
        JMenu editMenu = new JMenu("편집");
        editMenu.add(new JMenuItem("실행 취소")); // 메뉴 아이템 생성 후, "파일" 메뉴에 추가
        editMenu.add(new JMenuItem("다시 실행"));
        editMenu.add(new JMenuItem("모두 삭제"));
        this.add(editMenu);

        // [윈도우] 메뉴 구성
        JMenu windowMenu = new JMenu("윈도우");
        windowMenu.add(new JMenuItem("창 최대화"));
        windowMenu.add(new JMenuItem("창 최대화"));
        this.add(editMenu);

    }
}
