package sample;


import java.util.ArrayList;
import java.util.List;

public class tetrominoes {

        int x, y;
        int speedX = 0;
        int speedY = 1;


    public void setX(int x) {
        this.x = this.x + x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public tetrominoes(int x, int y) {

        this.x = x;

        this.y = y;

    }


    public void addCordinate(){

        this.y +=speedY;

        this.x +=speedX;

    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
