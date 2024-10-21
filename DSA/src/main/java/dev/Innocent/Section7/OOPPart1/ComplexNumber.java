package dev.Innocent.Section7.OOPPart1;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber complexNumber){
        this.real += complexNumber.real;
        this.imaginary += complexNumber.imaginary;
    }

    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber complexNumber){
        this.real -= complexNumber.real;
        this.imaginary -= complexNumber.imaginary;
    }
}