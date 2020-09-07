package main;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
//import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


public class DoCalcTest {

    @Test
    public void doCheck1() throws Exception {
        DoCalc d = new DoCalc(4,4);

        assertEquals(8, d.DoSum());
        assertEquals(16, d.DoMultiply());
    }

    @Test
    public void doCheck2() throws Exception {
        DoCalc d = new DoCalc(4,4);

        Assert.assertEquals(0, d.DoSubtraction());
        Assert.assertEquals(1, d.DoDivide());
    }

    @Test
    public void doCheck3(){
        final DoCalcStub d = new DoCalcStub(2,3);
        new GreatCalculation(d).Execute();
       // Assert.assertEquals(20, d.DoMultiply());
        Assert.assertTrue(d.wasBuried());
    }

    @Test
    public void doCheck4() {
        final DoCalc spyDoCalc = spy(new DoCalc(2,3));

        doNothing().when(spyDoCalc).BuryIt();
//        doCallRealMethod().when(spyDoCalc).BuryIt();
        GreatCalculation gc = new GreatCalculation(spyDoCalc);

        verify(spyDoCalc, times(0)).BuryIt();
        gc.Execute();
        gc.Execute();
        gc.Execute();
        verify(spyDoCalc, times(3)).BuryIt();
        gc.Execute();
//        gc.Execute();
        verify(spyDoCalc, times(5)).BuryIt();

    }
}
