package main;



class DoCalcStub implements DoCalcI {
    private boolean wasBuried;

    public DoCalcStub(int a, int b){
//        this.a = a;
//        this.b = b;
    }
    public int DoSum() {
        return 0;
    }

    public int DoMultiply() {
        return 0;
    }

    public int DoSubtraction() {
        return 0;
    }

    public int DoDivide() {
        return 0;
    }

    public void BuryIt() {
        wasBuried = true;
    }

    public boolean wasBuried(){return wasBuried;}
}

