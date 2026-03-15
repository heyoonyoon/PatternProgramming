package com.pattern.util;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Resize {
    /**
     * 이미지 경로와 높이를 받아 리사이징된 ImageIcon을 반환합니다.
     * @param path 이미지 리소스 경로 (예: "/pencil.png")
     * @param h 맞추고자 하는 높이(height)
     * @return 리사이징된 ImageIcon
     */
    public static ImageIcon fetchIcon(String path, int h) {
        try {
            // 클래스 레퍼런스를 통해 리소스를 가져옵니다.
            Image img = new ImageIcon(Resize.class.getResource(path)).getImage();
            return new ImageIcon(img.getScaledInstance(-1, h, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.err.println("이미지를 불러올 수 없습니다: " + path);
            return null;
        }
    }
}