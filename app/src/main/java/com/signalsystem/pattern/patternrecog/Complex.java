package com.signalsystem.pattern.patternrecog;

/**
 * Created by kim-donggi on 14. 12. 19..
 * 복소수 클래스
 */
public class Complex {
    private double re;
    private double im;

    public Complex() {

    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getAbsol() {
        return Math.sqrt(re * re + im * im);
    }

    public String toString(){
        return re + " + i" + im;
    }

    public static Complex add(Complex comp1, Complex comp2) {
        Complex complex = new Complex();
        complex.setRe(comp1.getRe() + comp2.getRe());
        complex.setIm(comp1.getIm() + comp2.getIm());

        return complex;
    }

    public static Complex minus(Complex comp1, Complex comp2) {
        Complex complex = new Complex();
        complex.setRe(comp1.getRe() - comp2.getRe());
        complex.setIm(comp1.getIm() - comp2.getIm());

        return complex;
    }

    public static Complex division(Complex comp, double operand) {
        comp.setRe(comp.getRe() / operand);
        comp.setIm(comp.getIm() / operand);

        return comp;
    }
}
