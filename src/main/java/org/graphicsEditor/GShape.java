package org.graphicsEditor;


import java.awt.*;

public class GShape {

     enum EShapeType {
        eRectangle,
        eCircle,
        eEllipse,
    }

    private int x0, y0, x1, y1;

    public GShape(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setLocation0(int x, int y) {
        this.x0 = x;
        this.y0 = y;
    }
    public void setLocation1(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }

    public void setSize(int width, int height) {
        this.x1 = x0 + width;
        this.y1 = y0 + height;
    }
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        int x = Math.min(x0, x1);
        int y = Math.min(y0, y1);
        int w = Math.abs(x1 - x0);
        int h = Math.abs(y1 - y0);
        g.drawRect(x, y, w, h);
    }

}
