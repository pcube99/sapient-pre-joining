package com.sapient.week7;

public class Camera {
    private int no_of_mg_pixels;

    public int getNo_of_mg_pixels() {
        return no_of_mg_pixels;
    }

    public void setNo_of_mg_pixels(int no_of_mg_pixels) {
        this.no_of_mg_pixels = no_of_mg_pixels;
    }

    public void checkCamera() {
        System.out.println("Camera is initialized with " + getNo_of_mg_pixels() + " MP.");
    }
}
