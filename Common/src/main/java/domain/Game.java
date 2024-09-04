package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author Radin
 */
public class Game implements GenericEntity{
    private Long id;
    private LocalDate gameDate;
    private LocalTime gameTime;
    private League league;

    public Game(Long id, LocalDate gameDate, LocalTime gameTime, League league) {
        this.id = id;
        this.gameDate = gameDate;
        this.gameTime = gameTime;
        this.league = league;
    }


    public Game() {
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        if (league == null) {
            throw new NullPointerException("League cannot be null.");
        }
        this.league = league;
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

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        if (gameDate == null) {
            throw new NullPointerException("Game date cannot be null.");
        }
        this.gameDate = gameDate;
    }

    public LocalTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(LocalTime gameTime) {
        if (gameTime == null) {
            throw new NullPointerException("Game time cannot be null.");
        }
        this.gameTime = gameTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Game other = (Game) obj;
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return String.format("Game - %d", id);
    }

    @Override
    public String getTableName() {
        return "game";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "game_date, game_time, league_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "game_date", "game_time", "league_id"};
    }

    @Override
    public String getInsertValues() {
        return "'" + gameDate + "', '" + gameTime + "', " + league.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getDate", "getTime", "getLong"};
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = java.sql.Date.valueOf(gameDate);
        java.sql.Time sqlTime = java.sql.Time.valueOf(gameTime);
        return "game_date = '" + sqlDate + "', game_time = '" + sqlTime + "', league_id = " + league.getId();
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
