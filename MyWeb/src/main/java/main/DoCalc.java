package main;

public class DoCalc implements DoCalcI{
    private int a;
    private int b;
    public DoCalc(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int DoSum(){ return a+b;}
    public int DoMultiply(){
        return a*b;
    }
    public int DoSubtraction(){ return a-b;}
    public int DoDivide(){
        return a/b;
    }
    public void BuryIt(){
        a = 0;
        b = 0;
        System.out.println("They are nulls now");
    }
}
