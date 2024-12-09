package com.lab111.labwork3;

public class Image {

    protected int width;

    protected int height;

    protected boolean visible;

    protected int x;

    protected int y;

    /**
     * конструктор
     *
     * @param width
     *            - ширина
     * @param height
     *            -высота
     * @param visible
     *            - видимость
     * @param x
     *            - кооридината
     * @param y
     *            -координата
     */
    public Image(int width, int height, boolean visible, int x, int y) {
        super();
        this.width = width;
        this.height = height;
        this.visible = visible;
        this.x = x;
        this.y = y;
    }

    /**
     * нарисовать катринку
     */
    public void draw() {
        System.out.println("draw()");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean newVisible) {
        visible = newVisible;
    }

    public int getWigth() {
        return width;
    }

    public void setWigth(int newWigth) {
        width = newWigth;
    }

    public void setHeight(int newHeight) {
        height = newHeight;
    }

    public int getHeight() {
        return height;
    }

    /**
     * возращает цвет пикселя по координате
     *
     * @param x
     * @param y
     * @return
     */
    public int getColor(int x, int y) {
        System.out.println("getColor x = " + x + ", y = " + y);
        return 0;
    }
}

