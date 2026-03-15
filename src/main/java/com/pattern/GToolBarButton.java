package com.pattern;

import com.pattern.util.Resize;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;

public class GToolBarButton extends JRadioButton {

    public GToolBarButton(String text, String path){
        super(text);
        this.setIcon(Resize.fetchIcon(path, 24));
        this.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); //돌출된 모양
        this.setToolTipText(text); //마우스를 올려놓았을 때 나오는 풍선 도움말
    }
}

