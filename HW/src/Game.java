/**
 * Created by KSafonov on 07/09/2017.
 */
/*public*/ enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

interface IRobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}

interface IRobotConnectionManager {
    RobotConnection getConnection();
}

class RobotConnection implements IRobotConnection {
    public RobotConnection(){
        throw new RobotConnectionException("Can't establish connection");
    }
    public void moveRobotTo(int x, int y) {
        //throw new RuntimeException("moveRobot");
        //x = y / 0;
        return;
    }
    public void close() {return;}
}

class RobotConnectionManager implements IRobotConnectionManager {
    public RobotConnection getConnection(){
        return new RobotConnection();
    }
}


class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);

    }
    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
public class Game {
    public final int o = 0;
    public static final int p = 0;
    public Game()
    {}
    public static void main(String[] args) {
        /*
        Robot robot = new Robot(-100,4, Direction.UP);
        moveRobot(robot, 3,7);
        System.out.println("X = " + robot.getX() + "; Y = " + robot.getY() + ";");
        */
        moveRobot(new RobotConnectionManager(), 4, 5);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean success = false;
        for(int attempt = 0; !success && (attempt < 3); attempt++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()){
                robotConnection.moveRobotTo(toX, toY);
                success = true;
            }
            catch (RobotConnectionException ex) {
            }
        }
        if (!success) throw new RobotConnectionException("I can't do it");
    }
    public static void Throw()
    {
        //throw new RuntimeException("ElseException");
        throw new RobotConnectionException("RobotConnectionException");
    }
   public static void moveRobot(final Robot robot, int toX, int toY) {
        Direction work;
        int step = toX - robot.getX();
        Direction current = robot.getDirection();

        if (step != 0){
            if (step > 0) {
                work = Direction.RIGHT;}
            else {
                work = Direction.LEFT;}
            step = Math.abs(step);
            if  (work != current) {
                if      (((current == Direction.DOWN) && (work == Direction.UP)) ||
                        ((current == Direction.UP) && (work == Direction.DOWN)) ||
                        ((current == Direction.LEFT) && (work == Direction.RIGHT)) ||
                        ((current == Direction.RIGHT) && (work == Direction.LEFT))){
                            robot.turnLeft();
                            robot.turnLeft();
                } else if
                        (((current == Direction.DOWN) && (work == Direction.RIGHT)) ||
                        ((current == Direction.UP) && (work == Direction.LEFT)) ||
                        ((current == Direction.LEFT) && (work == Direction.DOWN)) ||
                        ((current == Direction.RIGHT) && (work == Direction.UP))) {
                            robot.turnLeft();
                }
                else {
                            robot.turnRight();
                }
            }
            for(int i=0;i<step;i++) robot.stepForward();
        }

       step = toY - robot.getY();
       current = robot.getDirection();

       if (step != 0){
           if (step > 0) {
               work = Direction.UP;}
           else {
               work = Direction.DOWN;}
           step = Math.abs(step);
           if  (work != current) {
               if      (((current == Direction.DOWN) && (work == Direction.UP)) ||
                       ((current == Direction.UP) && (work == Direction.DOWN)) ||
                       ((current == Direction.LEFT) && (work == Direction.RIGHT)) ||
                       ((current == Direction.RIGHT) && (work == Direction.LEFT))){
                   robot.turnLeft();
                   robot.turnLeft();
               } else if
                       (((current == Direction.DOWN) && (work == Direction.RIGHT)) ||
                               ((current == Direction.UP) && (work == Direction.LEFT)) ||
                               ((current == Direction.LEFT) && (work == Direction.DOWN)) ||
                               ((current == Direction.RIGHT) && (work == Direction.UP))) {
                   robot.turnLeft();
               }
               else {
                   robot.turnRight();
               }
           }
           for(int i=0;i<step;i++) robot.stepForward();
       }


   }

}



