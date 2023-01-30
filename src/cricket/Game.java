package cricket;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int noOfOvers;
    private int noOfTeams;
    private int noOfPlayerInEachTeam;
    private List<Team> teams;

    private static int compare(Object t1, Object t2) {
        HashMap<String, Object> d1 = (HashMap<String, Object>) t1;
        HashMap<String, Object> d2 = (HashMap<String, Object>) t2;
        return (int)d1.get("score")-(int)d2.get("score");
    }

    public int getNoOfPlayerInEachTeam() {
        return noOfPlayerInEachTeam;
    }

    public void setNoOfPlayerInEachTeam(int noOfPlayerInEachTeam) {
        this.noOfPlayerInEachTeam = noOfPlayerInEachTeam;
    }

    void start(){
        List<Object> finalScores=
                teams.stream()
                .map(team->{
                    return playInnings(noOfOvers,team);
                })
                .collect(Collectors.toList());

        Object winnerObj=finalScores.stream().max(Game::compare).get();
        HashMap<String, Object> winner=(HashMap<String, Object>)winnerObj;

        Team winnerTeam=(Team)winner.get("team");
        int winnerScore=(int)winner.get("score");
        int winnerWicket=(int)winner.get("wicket");

        System.out.println("Winning Team : "+winnerTeam.getTeamName());
        showScore(winnerScore,winnerWicket,winnerTeam);
    }

    private Object playInnings(int noOfOvers, Team team) {
        int score=0;
        int players=noOfPlayerInEachTeam;
        PlayShot cricketShot=new PlayCricketShot();
        System.out.println("Team "+team.getTeamName()+" is playing!");
        showScore(score,noOfPlayerInEachTeam-players,team);
        for(int over=1;over<=noOfOvers;over++)
        {
            for(int ball=1;ball<=6;ball++)
            {
                int shot=cricketShot.hitShot();
                if(shot==7){
                    players--;
                    showWicket(noOfPlayerInEachTeam-players-1,team);
                    if(players==1){
                        System.out.println("Innings Over");
                        break;
                    }
                    showScore(score,noOfPlayerInEachTeam-players,team);
                }
                //can Add other condition of wideBall,No ball etc
                else {
                    System.out.println(shot + " runs");
                    score += shot;
                }
            }
            System.out.println("score after "+over+" overs");
            showScore(score,noOfPlayerInEachTeam-players,team);
            if(players==1)break;
        }
        HashMap<String,Object> data=new HashMap<>();
        data.put("score",score);
        data.put("wicket",noOfPlayerInEachTeam-players);
        data.put("team", team);
        return data;
    }
    public void showScore(int run,int wicket,Team team){
        System.out.println(team.getTeamName()+" : "+run+"-"+wicket);
    }
    public void showWicket(int playerNo,Team team){
        System.out.println("Wicket : "+team.getPlayers().get(playerNo));
    }

    public Game() {
    }

    public Game(int noOfOvers, int noOfTeams, List<Team> teams,int noOfPlayerInEachTeam) {
        this.noOfOvers = noOfOvers;
        this.noOfTeams = noOfTeams;
        this.teams = teams;
        this.noOfPlayerInEachTeam=noOfPlayerInEachTeam;
    }

    public int getNoOfOvers() {
        return noOfOvers;
    }

    public void setNoOfOvers(int noOfOvers) {
        this.noOfOvers = noOfOvers;
    }

    public int getNoOfTeams() {
        return noOfTeams;
    }

    public void setNoOfTeams(int noOfTeams) {
        this.noOfTeams = noOfTeams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
