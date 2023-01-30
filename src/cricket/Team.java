package cricket;

import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    List<String> players;

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", players=" + players +
                '}';
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public Team(int teamId, String teamName, List<String> players) {
        this.teamId = teamId;
        this.players = players;
        this.teamName = teamName;
    }


}
