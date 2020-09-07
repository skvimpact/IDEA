class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public Robot(int x, int y, Direction direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        //if (direction = Direction.UP) direction =
        switch (direction)
        {
            case UP:      direction = Direction.LEFT; break;
            case DOWN:    direction = Direction.RIGHT; break;
            case LEFT:    direction = Direction.DOWN; break;
            case RIGHT:   direction = Direction.UP; break;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction)
        {
            case UP:      direction = Direction.RIGHT; break;
            case DOWN:    direction = Direction.LEFT; break;
            case LEFT:    direction = Direction.UP; break;
            case RIGHT:   direction = Direction.DOWN; break;
        }

    }

    public void stepForward() {
        switch (direction)
        {
            case UP:      y += 1; break;
            case DOWN:    y -= 1; break;
            case LEFT:    x -= 1; break;
            case RIGHT:   x += 1; break;
        }

        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}