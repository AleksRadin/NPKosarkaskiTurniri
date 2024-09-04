package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class PlayedGame implements GenericEntity{
    private Team homeTeam;
    private Team awayTeam;
    private Game game;
    private int homeTeamPoints;
    private int awayTeamPoints;

    public PlayedGame(Team homeTeam, Team awayTeam, Game game, int homeTeamPoints, int awayTeamPoints) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.game = game;
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamPoints = awayTeamPoints;
    }

    public PlayedGame() {
    }
    
    

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(int homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(int awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.homeTeam);
        hash = 19 * hash + Objects.hashCode(this.awayTeam);
        hash = 19 * hash + Objects.hashCode(this.game);
        hash = 19 * hash + this.homeTeamPoints;
        hash = 19 * hash + this.awayTeamPoints;
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
        final PlayedGame other = (PlayedGame) obj;
        if (this.homeTeamPoints != other.homeTeamPoints) {
            return false;
        }
        if (this.awayTeamPoints != other.awayTeamPoints) {
            return false;
        }
        if (!Objects.equals(this.homeTeam, other.homeTeam)) {
            return false;
        }
        if (!Objects.equals(this.awayTeam, other.awayTeam)) {
            return false;
        }
        return Objects.equals(this.game, other.game);
    }

    @Override
    public String toString() {
        return "PlayedGame{" + "homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", game=" + game + ", homeTeamPoints=" + homeTeamPoints + ", awwayTeamPoints=" + awayTeamPoints + '}';
    }

    @Override
    public String getTableName() {
        return "played_game";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "home_team_id, away_team_id, game_id, home_team_points, away_team_points";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"home_team_id", "away_team_id", "game_id", "home_team_points", "away_team_points"};
    }

    @Override
    public String getInsertValues() {
        return homeTeam.getId() + ", " + awayTeam.getId() + ", " + game.getId() + ", " + homeTeamPoints + ", " + awayTeamPoints;
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getLong", "getLong", "getInt", "getInt"};
    }

    @Override
    public String getUpdateValues() {
        return "home_team_id = " + homeTeam.getId() +
           ", away_team_id = " + awayTeam.getId() +
           ", game_id = " + game.getId() +
           ", home_team_points = " + homeTeamPoints +
           ", away_team_points = " + awayTeamPoints;
    }

    @Override
    public String getWhereCondition() {
        return "home_team_id = " + homeTeam.getId() +
           " AND away_team_id = " + awayTeam.getId() +
           " AND game_id = " + game.getId();
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "home_team_id = " + homeTeam.getId() +
           " AND away_team_id = " + awayTeam.getId() +
           " AND game_id = " + game.getId();
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
