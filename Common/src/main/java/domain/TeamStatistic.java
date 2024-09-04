package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class TeamStatistic implements GenericEntity{
    
    private Long id;
    private League league; 
    private Team team;    
    private int playedGames;
    private int wonGames;
    private int lostGames;
    private int drawnGames;
    private int points;
    private int rank;

    public TeamStatistic(Long id, League league, Team team, int playedGames, int wonGames, int lostGames, int drawnGames, int points, int rank) {
        this.id = id;
        this.league = league;
        this.team = team;
        this.playedGames = playedGames;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
        this.drawnGames = drawnGames;
        this.points = points;
        this.rank = rank;
    }

    

    public TeamStatistic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("ID cannot be null.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        if (league == null) {
            throw new IllegalArgumentException("League cannot be null.");
        }
        this.league = league;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null.");
        }
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.points = points;
    }

    
    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        if (playedGames < 0) {
            throw new IllegalArgumentException("Played games cannot be negative.");
        }
        this.playedGames = playedGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        if (wonGames < 0) {
            throw new IllegalArgumentException("Won games cannot be negative.");
        }
        this.wonGames = wonGames;
    }
    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        if (lostGames < 0) {
            throw new IllegalArgumentException("Lost games cannot be negative.");
        }
        this.lostGames = lostGames;
    }

    public int getDrawnGames() {
        return drawnGames;
    }

    public void setDrawnGames(int drawnGames) {
        if (drawnGames < 0) {
            throw new IllegalArgumentException("Drawn games cannot be negative.");
        }
        this.drawnGames = drawnGames;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank <= 0) {
            throw new IllegalArgumentException("Rank must be positive.");
        }
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.league);
        hash = 83 * hash + Objects.hashCode(this.team);
        hash = 83 * hash + this.playedGames;
        hash = 83 * hash + this.wonGames;
        hash = 83 * hash + this.lostGames;
        hash = 83 * hash + this.drawnGames;
        hash = 83 * hash + this.rank;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TeamStatistic other = (TeamStatistic) obj;
        if (this.playedGames != other.playedGames) {
            return false;
        }
        if (this.wonGames != other.wonGames) {
            return false;
        }
        if (this.lostGames != other.lostGames) {
            return false;
        }
        if (this.drawnGames != other.drawnGames) {
            return false;
        }
        if (this.rank != other.rank) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.league, other.league)) {
            return false;
        }
        return Objects.equals(this.team, other.team);
    }

    @Override
    public String toString() {
        return "TeamStatistic{" + "id=" + id + ", league=" + league + ", team=" + team + ", playedGames=" + playedGames + ", wonGames=" + wonGames + ", lostGames=" + lostGames + ", drawnGames=" + drawnGames + ", rank=" + rank + '}';
    }
    
     @Override
    public String getTableName() {
        return "team_statistic";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "league_id, team_id, played_games, won_games, lost_games, drawn_games, points, team_rank"; 
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "league_id", "team_id", "played_games", "won_games", "lost_games", "drawn_games", "points", "team_rank"}; 
    }

    @Override
    public String getInsertValues() {
        return league.getId() + ", " + team.getId() + ", " + playedGames + ", " + wonGames + ", " + lostGames + ", " + drawnGames + ", " + points + ", " + rank; 
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getLong", "getLong", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt"}; 
    }

    @Override
    public String getUpdateValues() {
        return "league_id = " + league.getId() + ", " +
               "team_id = " + team.getId() + ", " +
               "played_games = " + playedGames + ", " +
               "won_games = " + wonGames + ", " +
               "lost_games = " + lostGames + ", " +
               "drawn_games = " + drawnGames + ", " +
               "points = " + points + ", " + 
               "team_rank = " + rank; // Update here to reflect the new column name
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "id = " + id;
    }
}
