package main;

public class GreatCalculation {
    private DoCalcI handler;
    public GreatCalculation(DoCalcI handler)
    {
        this.handler = handler;
    }
    public void Execute(){
        handler.BuryIt();
    }
}
