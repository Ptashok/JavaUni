package com.lab111;
import com.lab111.labwork3.*;

/**
 * Template first class.
 *
 */
public final class TestMain {

    /**
     * Constructor.
     *
     */
    private TestMain() {
        super();
    }

    /**
     * Invokes at application startup.
     * @param args Parameters from command line
     */
    public static void main(final String[] args) {
        Image image=new ProxyImage(1, 2, true, 0, 0, "image.jpg");
        int x=image.getX();
        int y=image.getY();
        image.draw();
        x=image.getX();
        y=image.getY();

    }

}


