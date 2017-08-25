package com.company;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        Team team = new Team("Avengers");
        team.TeamInfo();
        course.doIt(team);
        team.printResult();
    }
}
