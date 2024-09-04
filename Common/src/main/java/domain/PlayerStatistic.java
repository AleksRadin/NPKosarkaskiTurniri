package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class PlayerStatistic implements GenericEntity{
    
    private Long id;
    private Player player;
    private Game game;
    private int minutesPlayed;
    private int pointsScored;
    private int threePointersMade;
    private int threePointersAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private int reboundsOffensive;
    private int reboundsDefensive;
    private int assists;
    private int steals;
    private int blocks;
    private int personalFouls;

    public PlayerStatistic(Long id, Player player, Game game, int minutesPlayed, int pointsScored, int threePointersMade, int threePointersAttempted, int freeThrowsMade, int freeThrowsAttempted, int reboundsOffensive, int reboundsDefensive, int assists, int steals, int blocks, int personalFouls) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.minutesPlayed = minutesPlayed;
        this.pointsScored = pointsScored;
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.reboundsOffensive = reboundsOffensive;
        this.reboundsDefensive = reboundsDefensive;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.personalFouls = personalFouls;
    }

    public PlayerStatistic() {
    }

    public Long getId() {
        return id;
    }
    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    public int getThreePointersMade() {
        return threePointersMade;
    }

    public void setThreePointersMade(int threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    public int getThreePointersAttempted() {
        return threePointersAttempted;
    }

    public void setThreePointersAttempted(int threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public int getReboundsOffensive() {
        return reboundsOffensive;
    }

    public void setReboundsOffensive(int reboundsOffensive) {
        this.reboundsOffensive = reboundsOffensive;
    }

    public int getReboundsDefensive() {
        return reboundsDefensive;
    }

    public void setReboundsDefensive(int reboundsDefensive) {
        this.reboundsDefensive = reboundsDefensive;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.player);
        hash = 53 * hash + Objects.hashCode(this.game);
        hash = 53 * hash + this.minutesPlayed;
        hash = 53 * hash + this.pointsScored;
        hash = 53 * hash + this.threePointersMade;
        hash = 53 * hash + this.threePointersAttempted;
        hash = 53 * hash + this.freeThrowsMade;
        hash = 53 * hash + this.freeThrowsAttempted;
        hash = 53 * hash + this.reboundsOffensive;
        hash = 53 * hash + this.reboundsDefensive;
        hash = 53 * hash + this.assists;
        hash = 53 * hash + this.steals;
        hash = 53 * hash + this.blocks;
        hash = 53 * hash + this.personalFouls;
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
        final PlayerStatistic other = (PlayerStatistic) obj;
        if (this.minutesPlayed != other.minutesPlayed) {
            return false;
        }
        if (this.pointsScored != other.pointsScored) {
            return false;
        }
        if (this.threePointersMade != other.threePointersMade) {
            return false;
        }
        if (this.threePointersAttempted != other.threePointersAttempted) {
            return false;
        }
        if (this.freeThrowsMade != other.freeThrowsMade) {
            return false;
        }
        if (this.freeThrowsAttempted != other.freeThrowsAttempted) {
            return false;
        }
        if (this.reboundsOffensive != other.reboundsOffensive) {
            return false;
        }
        if (this.reboundsDefensive != other.reboundsDefensive) {
            return false;
        }
        if (this.assists != other.assists) {
            return false;
        }
        if (this.steals != other.steals) {
            return false;
        }
        if (this.blocks != other.blocks) {
            return false;
        }
        if (this.personalFouls != other.personalFouls) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return Objects.equals(this.game, other.game);
    }

    @Override
    public String toString() {
        return "PlayerStatistic{" + "id=" + id + ", player=" + player + ", game=" + game + ", minutesPlayed=" + minutesPlayed + ", pointsScored=" + pointsScored + ", threePointersMade=" + threePointersMade + ", threePointersAttempted=" + threePointersAttempted + ", freeThrowsMade=" + freeThrowsMade + ", freeThrowsAttempted=" + freeThrowsAttempted + ", reboundsOffensive=" + reboundsOffensive + ", reboundsDefensive=" + reboundsDefensive + ", assists=" + assists + ", steals=" + steals + ", blocks=" + blocks + ", personalFouls=" + personalFouls + '}';
    }

    
     @Override
    public String getTableName() {
        return "player_statistic";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "player_id, game_id, minutes_played, points_scored, three_pointers_made, three_pointers_attempted, free_throws_made, free_throws_attempted, rebounds_offensive, rebounds_defensive, assists, steals, blocks, personal_fouls";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "player_id", "game_id", "minutes_played", "points_scored", "three_pointers_made", "three_pointers_attempted", "free_throws_made", "free_throws_attempted", "rebounds_offensive", "rebounds_defensive", "assists", "steals", "blocks", "personal_fouls"};
    }

    @Override
    public String getInsertValues() {
        return player.getId() + ", " + game.getId() + ", " + minutesPlayed + ", " + pointsScored + ", " + threePointersMade + ", " + threePointersAttempted + ", " + freeThrowsMade + ", " + freeThrowsAttempted + ", " + reboundsOffensive + ", " + reboundsDefensive + ", " + assists + ", " + steals + ", " + blocks + ", " + personalFouls;
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getLong", "getLong", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt", "getInt"};
    }

    @Override
    public String getUpdateValues() {
        return "player_id = " + player.getId() +
               ", game_id = " + game.getId() +
               ", minutes_played = " + minutesPlayed +
               ", points_scored = " + pointsScored +
               ", three_pointers_made = " + threePointersMade +
               ", three_pointers_attempted = " + threePointersAttempted +
               ", free_throws_made = " + freeThrowsMade +
               ", free_throws_attempted = " + freeThrowsAttempted +
               ", rebounds_offensive = " + reboundsOffensive +
               ", rebounds_defensive = " + reboundsDefensive +
               ", assists = " + assists +
               ", steals = " + steals +
               ", blocks = " + blocks +
               ", personal_fouls = " + personalFouls;
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "id = " + id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
