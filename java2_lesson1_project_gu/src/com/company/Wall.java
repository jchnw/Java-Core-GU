package com.company;

public class Wall extends Obstacle {
    int height;
    public Wall(int height){
        this.height = height;
    }
    @Override
    public void doIt(Team team){
        team.jump(this.height);
    }
}
