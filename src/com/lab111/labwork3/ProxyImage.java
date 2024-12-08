package com.lab111.labwork3;
public class ProxyImage extends Image {

    public ProxyImage(int width, int height, boolean visible, int x, int y,
                      String fileName) {
        super(width, height, visible, x, y);
        this.fileName = fileName;
    }
    private String fileName;

    private RealImage realImage;//ссылка на настоящий обьект

    /*
     * нарисовать обьект
     */
    public void draw() {
        //если обьект еще незагружен, то загружается
        if (realImage == null)
            loadImage();
        realImage.draw();
    }

    public int getX() {
        if (realImage == null)
            return x;
        else
            return realImage.getX();
    }

    public int getY() {
        if (realImage == null)
            return y;
        else
            return realImage.getY();
    }

    public void setX(int newX) {
        if (realImage == null)
            x = newX;
        else
            realImage.setX(newX);
    }

    public boolean getVisible() {
        if (realImage == null)
            return visible;
        else
            return realImage.getVisible();
    }

    public void setVisible(boolean newVisible) {
        if (realImage == null)
            visible = newVisible;
        else
            realImage.setVisible(newVisible);
    }

    public int getWigth() {
        if (realImage == null)
            return width;
        else
            return realImage.getWigth();
    }

    public void setHeight(int newHeight) {
        if (realImage == null)
            height = newHeight;
        else
            realImage.setHeight(newHeight);
    }

    public int getHeight() {
        if (realImage == null)
            return height;
        else
            return realImage.getHeight();
    }

    public int getColor(int x, int y) {
        if (realImage == null)
            loadImage();
        return realImage.getColor(x, y);
    }

    /**
     * загружает и создает реальный обьект
     */
    private void loadImage() {
        realImage = new RealImage(width, height, visible, x, y);
    }

}
