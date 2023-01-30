package cricket;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team india=new Team(1,"India", List.of("Dhoni","Shewag","Rohit","Virat","Sachin"));
        Team england=new Team(2,"England", List.of("Cook","Puntin","hogg","Friz","Dimesh"));
        Team pakistan=new Team(3,"Pakistan", List.of("Inzaman","Wakar","Asif","Farook","Iqbal"));
        Game newGame=new Game(2,3,List.of(india,england,pakistan),5);
        newGame.start();
    }
}
