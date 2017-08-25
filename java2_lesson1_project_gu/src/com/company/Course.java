package com.company;

public class Course {
    Obstacle cr[];
    public Course (){
        cr = new Obstacle[] {new Cross ( 500 ), new Wall ( 2 ), new Water ( 5 ) };
    }
    public void doIt(Team team){
        for (int i = 0; i < cr.length; i++ ){
            cr[i].doIt(team);
        }
    }
}
