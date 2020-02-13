package sample;

import java.util.ArrayList;

public class Snake {


    ArrayList<tetrominoes> cordinates = new ArrayList<>();


    public Snake(){

        cordinates.add(new tetrominoes(0,1));

        cordinates.add(new tetrominoes(0,2));

        cordinates.add(new tetrominoes(0,3));

        cordinates.add(new tetrominoes(0,4));
    }



    public void moveSnake(){

        for(int i = 0; i < cordinates.size() - 1   ; i++){

            cordinates.get(i).x = cordinates.get(i+1).x;

            cordinates.get(i).y = cordinates.get(i+1).y;

        }

            cordinates.get(cordinates.size()-1).addCordinate();
    }


    public void changeDirection(String direction){

        if(direction == "left"){

            cordinates.get(cordinates.size()-1).setSpeedX(-1);

            cordinates.get(cordinates.size()-1).setSpeedY(0);


        }
         if(direction == "right"){

            cordinates.get(cordinates.size()-1).setSpeedX(1);

            cordinates.get(cordinates.size()-1).setSpeedY(0);


        }

         if(direction == "up"){

            cordinates.get(cordinates.size()-1).setSpeedX(0);

            cordinates.get(cordinates.size()-1).setSpeedY(-1);


        }

         if(direction == "down"){

            cordinates.get(cordinates.size()-1).setSpeedX(0);

            cordinates.get(cordinates.size()-1).setSpeedY(1);
        }

    }


    public void add(){

        cordinates.add(0,new tetrominoes(cordinates.get(0).getX(),cordinates.get(0).getY()));

    }

    public boolean check() {

        int x =  cordinates.get(cordinates.size()-1).getX();

        int y =  cordinates.get(cordinates.size()-1).getY();


        for(int i = 0 ;i<cordinates.size()-1; i++){

            if ((cordinates.get(i).getX() == x)&&(cordinates.get(i).getY() == y)){

                Menu menu = new Menu();

                System.out.println("Your score " + menu.score);

                return true;
            }
        }

        return false;
    }
}
