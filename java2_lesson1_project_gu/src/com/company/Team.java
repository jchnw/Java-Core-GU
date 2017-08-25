package com.company;


import java.util.Scanner;



    public class Team implements Participant{
        protected String teamname;

        public  Team(String name){

            this.teamname = name;
            MassiveInput();
        }

        Animal team[] = new Animal[4];

        private void MassiveInput() {
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < team.length; i++) {
                double decision = Math.random();
                if (decision == 0) {
                    System.out.println("Введите имя кота:");
                    String catname = input.nextLine();
                    team[i] = new Cat(catname, 8, 7, 0);
                } else {
                    System.out.println("Введите имя пса:");
                    String dogname = input.nextLine();
                    team[i] = new Dog(dogname, 9, 2, 10);
                }

            }
        }
        public void printResult(){
            System.out.println ("Полосу препятствий из команды " + this.teamname + " прошли:");
            for(int i = 0;i <team.length; i++){
                if (this.team[i].onDistance){
                    System.out.println (this.team[i].type + " по имени: " + this.team[i].name);
                }
            }
            if (!this.team[0].onDistance && !this.team[1].onDistance && !this.team[2].onDistance && !this.team[3].onDistance)
                System.out.println ("Полосу препятствий никто не прошел");
        }
        public void TeamInfo(){
            System.out.println ("Состав команды " + this.teamname + ":");
            for(int i = 0;i <team.length; i++){
                System.out.println (this.team[i].type + " по имени: " + this.team[i].name + ", пробегает: " + this.team[i].maxRunDistance + ", проплывает: " + this.team[i].maxSwimDistance + ", перепрыгивает: "+ this.team[i].maxJumpHeight + "м");
            }
        }

        @Override
        public void run(int distance) {
            for(int i = 0;i <team.length; i++) {
                if (distance <= team[i].maxRunDistance) {
                    System.out.println ( team[i].type + " " + team[i].name + " пробежал дистанцию");
                } else {
                    team[i].onDistance = false;
                    System.out.println ( team[i].type + " " + team[i].name + " не пробежал дистанцию" );
                }
            }
        }

        @Override
        public void swim(int distance) {
            for(int i = 0;i <team.length; i++) {
                if (team[i].maxSwimDistance == 0) {
                    System.out.println ( team[i].type + " " + team[i].name + " не умеет плавать" );
                }
                if (distance <= team[i].maxSwimDistance) {
                    System.out.println ( team[i].type + " " + team[i].name + " переплыл дистанцию" );
                } else {
                    team[i].onDistance = false;
                    System.out.println ( team[i].type + " " + team[i].name + " не переплыл дистанцию" );
                }
            }
        }

        @Override
        public void jump(int height) {
            for(int i = 0;i <team.length; i++){
                if(height<=team[i].maxJumpHeight){
                    System.out.println (team[i].type + " " + team[i].name + " перепрыгнул препятствие");
                }else{
                    team[i].onDistance = false;
                    System.out.println (team[i].type + " " + team[i].name + " не перепрыгнул препятствие");
                }
            }
        }
}

