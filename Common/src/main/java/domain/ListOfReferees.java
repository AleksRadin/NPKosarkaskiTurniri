package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class ListOfReferees implements GenericEntity{
    private Referee headReferee;
    private Referee firstReferee;
    private Referee secondReferee;
    private Game game;
    private Long id;

    public ListOfReferees(Long id, Referee headReferee, Referee firstReferee, Referee secondReferee, Game game) {
        this.id = id;
        this.headReferee = headReferee;
        this.firstReferee = firstReferee;
        this.secondReferee = secondReferee;
        this.game = game;
    }

    public ListOfReferees(Referee headReferee, Referee firstReferee, Referee secondReferee, Game game) {
        this.headReferee = headReferee;
        this.firstReferee = firstReferee;
        this.secondReferee = secondReferee;
        this.game = game;
    }

    public ListOfReferees() {
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

    public Referee getHeadReferee() {
        return headReferee;
    }

    public void setHeadReferee(Referee headReferee) {
        if (headReferee == null) {
            throw new NullPointerException("Head referee cannot be null.");
        }
        this.headReferee = headReferee;
    }
    
    public Referee getFirstReferee() {
        return firstReferee;
    }

    public void setFirstReferee(Referee firstReferee) {
        if (firstReferee == null) {
            throw new NullPointerException("First referee cannot be null.");
        }
        this.firstReferee = firstReferee;
    }
    
    public Referee getSecondReferee() {
        return secondReferee;
    }

    public void setSecondReferee(Referee secondReferee) {
        if (secondReferee == null) {
            throw new NullPointerException("Second referee cannot be null.");
        }
        this.secondReferee = secondReferee;
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        if (game == null) {
            throw new NullPointerException("Game cannot be null.");
        }
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.game);
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
        final ListOfReferees other = (ListOfReferees) obj;
        return Objects.equals(this.game, other.game);
    }

    

    @Override
    public String toString() {
        return "ListOfReferees{" + "headReferee=" + headReferee + ", firstReferee=" + firstReferee + ", secondReferee=" + secondReferee + ", game=" + game + '}';
    }

    @Override
    public String getTableName() {
        return "list_of_referees";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "head_referee_id, first_referee_id, second_referee_id, game_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{"head_referee_id", "first_referee_id", "second_referee_id", "game_id"};
    }

    @Override
    public String getInsertValues() {
        return headReferee.getId() + ", " + firstReferee.getId() + ", " + secondReferee.getId() + ", " + game.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[]{"getLong", "getLong", "getLong", "getLong"};
    }

    @Override
    public String getUpdateValues() {
        return "head_referee_id = " + headReferee.getId() + ", " +
               "first_referee_id = " + firstReferee.getId() + ", " +
               "second_referee_id = " + secondReferee.getId() + ", " +
               "game_id = " + game.getId();
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
