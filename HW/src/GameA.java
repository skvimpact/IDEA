/**
 * Created by KSafonov on 07/09/2017.
 */

public class GameA {
    public static void main(String[] args) {
        Robot robot = new Robot(5,3, Direction.UP);
        //System.out.println(robot.getDirection());
        moveRobot(robot, 3,7);
        System.out.println("X = " + robot.getX() + "; Y = " + robot.getY() + ";");
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        moveRobotAux(robot, toX,0);
        moveRobotAux(robot, 0, toY);
    }
    private static void moveRobotAux(Robot robot, int toX, int toY) {
        Direction work;
        int step = (toY == 0) ? toX - robot.getX() : toY - robot.getY();
        Direction current = robot.getDirection();

        if (step != 0){
            if (step > 0) {
                work = (toY == 0) ? Direction.RIGHT : Direction.UP;}
            else {
                work = (toY == 0) ? Direction.LEFT : Direction.DOWN;}
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



