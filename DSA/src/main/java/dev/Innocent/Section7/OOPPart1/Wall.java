package dev.Innocent.Section7.OOPPart1;

public class Wall {
    private double width;
    private double height;

    public Wall() {
    }

    public Wall(double width, double height) {
        this.width = width < 0 ? 0 : width;
        this.height = height < 0 ? 0: height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width < 0 ? 0 : width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height < 0 ? 0 : height;
    }

    public double getArea(){
        return getWidth() * getHeight();
    }
}