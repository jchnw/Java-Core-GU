package com.company;

public class Dog extends Animal{
    public Dog(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance){
        this.type = "Пёс";
        this.name = name;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }
}
