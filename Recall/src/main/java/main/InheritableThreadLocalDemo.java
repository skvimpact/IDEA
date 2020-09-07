package main;
public class InheritableThreadLocalDemo
{
   private static final InheritableThreadLocal<Integer> intVal =
      new InheritableThreadLocal<Integer>();

   public static void main(String[] args)
   {


       Runnable rC = () ->
       {
           Thread thd = Thread.currentThread();
           String name = thd.getName();
           System.out.printf("%s %d%n", name,
                   intVal.get());
       };


       Runnable rP = () ->
                    {
                       intVal.set(new Integer(10));
                       Thread thdChild = new Thread(rC);
                       thdChild.setName("Child");
                       thdChild.start();
                        Thread thdChild2 = new Thread(rC);
                        thdChild2.setName("Child2");
                        thdChild2.start();

                    };


       Runnable rP2 = () ->
       {
           intVal.set(new Integer(20));
           Thread thdChild = new Thread(rC);
           thdChild.setName("Child");
           thdChild.start();
       };


      new Thread(rP).start();
      //new Thread(rP2).start();
   }
}