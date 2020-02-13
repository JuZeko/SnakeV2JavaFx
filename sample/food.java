package sample;

public class food {

    int x = 0;
    int y = 0;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int range = 20;
    int min = 0;


    public food() {


        this.x = (int) (Math.random() * range) + min;

        this.y = (int) (Math.random() * range) + min;
    }


    public void random() {

        setX((int) (Math.random() * range) + min);
        setY((int) (Math.random() * range) + min);

    }
}
