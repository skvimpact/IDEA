//package ru.sberbank_cib.KSafonov;
//package org.stepic.java.example;
import java.util.Arrays;
/**
 * Created by KSafonov on 12/09/2017.
 */

//import java.util.Random;

public class MyException {
    public static void main(String[] args) {
        int t;
        for(t=0; t < 10; t++){
            if (t>5) break;
        }
        System.out.println(t);



      //  System.out.println(getCallerClassAndMethodName());
        //anotherMethod();
        anotherMethod4();
        //System.out.println(sqrt(123));
       // A a = new A();
       // System.out.println(a.myInteger);


/*
        Random random = new Random();
        int i = random.nextInt(100);;

        if (i > 50) {
            B b = new B();
            myCast(b);
        }
        else{
            A b = new A();
            myCast(b);
        }*/
    }

    public static void myCast(Object o) {
        A a = (A) o;
        System.out.println(a.myInteger);
    }

    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x); // your implementation here
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    private static void anotherMethod4() {
        anotherMethod3();
    }
    private static void anotherMethod3() {
        anotherMethod2();
    }

    private static void anotherMethod2() {
        anotherMethod();
    }


    public static String getCallerClassAndMethodName() {

        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        if (stackTraceElements.length > 2) {
            return(stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName());
        }
        else return null;
    }
}

class A{
    protected final int myInteger = 8;
}


class B{
    protected final int myInteger = 16;
}

class C{
    protected final int myInteger = 24;
}


/*
            for(StackTraceElement se:stackTraceElements){
                System.out.println(se.getClassName());
            }*/