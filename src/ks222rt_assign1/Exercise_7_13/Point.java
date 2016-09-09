package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class Point {
    private int x = 0;
    private int y = 0;

    public Point(){
        this(0,0);
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isEqualTo(Point point){
        return x == point.x && y == point.y;
    }

    public String toString(){
        return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void moveToXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point){
        return Math.sqrt(Math.pow((x-point.x),2) + Math.pow((y-point.y),2));
    }
}
