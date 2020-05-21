package com.sapient.week7;

public class Screen {
    private int length;
    private int breadth;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public void checkScreen() {
        System.out.println("Screen is initialized with length = " + getLength() + " breadth = " + getBreadth());
    }
}
