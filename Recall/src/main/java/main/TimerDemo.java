package main;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo
{
   public static void main(String[] args)
   {
      TimerTask task = new TimerTask()
                       {
                          @Override
                          public void run()
                          {
                             System.out.println(System.currentTimeMillis());
//                             System.exit(0);
                          }
                       };
      Timer timer = new Timer(false);
      timer.schedule(task, 0, 1000); // Execute one-shot timer task after
                                  // 2-second delay.

//      timer.
   }
}