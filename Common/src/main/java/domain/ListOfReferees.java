package domain;

import java.util.Objects;

/**
 * Predstavlja listu sudija u okviru utakmice.
 * 
 * Sadrži glavnog sudiju, prvog sudiju, drugog sudiju i utakmicu.
 * 
 * @author Radin
 */
public class ListOfReferees implements GenericEntity{
	/**
	 * Glavni sudija na utakmici.
	 */
    private Referee headReferee;
    /**
     * Prvi pomoćni sudija na utakmici.
     */
    private Referee firstReferee;
    /**
     * Drugi pomoćni sudija na utakmici.
     */
    private Referee secondReferee;
    /**
     * Utakmica za koju su dodeljeni sudije.
     */
    private Game game;
    /**
     * Jedinstveni identifikator liste sudija.
     */
    private Long id;

    /**
     * Konstruktor koji postavlja sve atribute liste sudija.
     * 
     * @param id - ID liste sudija.
     * @param headReferee - Glavni sudija.
     * @param firstReferee - Prvi sudija.
     * @param secondReferee - Drugi sudija.
     * @param game - Utakmica.
     */
    public ListOfReferees(Long id, Referee headReferee, Referee firstReferee, Referee secondReferee, Game game) {
        this.id = id;
        this.headReferee = headReferee;
        this.firstReferee = firstReferee;
        this.secondReferee = secondReferee;
        this.game = game;
    }

    /**
     * Konstruktor koji postavlja sve atribute osim ID-a.
     * 
     * @param headReferee - Glavni sudija.
     * @param firstReferee - Prvi sudija.
     * @param secondReferee - Drugi sudija.
     * @param game - Utakmica.
     */
    public ListOfReferees(Referee headReferee, Referee firstReferee, Referee secondReferee, Game game) {
        this.headReferee = headReferee;
        this.firstReferee = firstReferee;
        this.secondReferee = secondReferee;
        this.game = game;
    }

    /**
     * Default konstruktor.
     */
    public ListOfReferees() {
    }

    /**
     * Vraća ID liste sudija.
     * 
     * @return id - ID liste sudija.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost ID-a liste sudija.
     * 
     * @param id - Nova vrednost ID-a.
     * @throws NullPointerException - Ako je ID null.
     * @throws IllegalArgumentException - Ako je ID manji ili jednak nuli.
     */
    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("ID cannot be null.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    /**
     * Vraća glavnog sudiju.
     * 
     * @return headReferee - Glavni sudija.
     */
    public Referee getHeadReferee() {
        return headReferee;
    }

    /**
     * Postavlja novog glavnog sudiju.
     * 
     * @param headReferee - Novi glavni sudija.
     * @throws NullPointerException - Ako je glavni sudija null.
     */
    public void setHeadReferee(Referee headReferee) {
        if (headReferee == null) {
            throw new NullPointerException("Head referee cannot be null.");
        }
        this.headReferee = headReferee;
    }
    
    /**
     * Vraća prvog sudiju.
     * 
     * @return firstReferee - Prvi sudija.
     */
    public Referee getFirstReferee() {
        return firstReferee;
    }

    /**
     * Postavlja novog prvog sudiju.
     * 
     * @param firstReferee - Novi prvi sudija.
     * @throws NullPointerException - Ako je prvi sudija null.
     */
    public void setFirstReferee(Referee firstReferee) {
        if (firstReferee == null) {
            throw new NullPointerException("First referee cannot be null.");
        }
        this.firstReferee = firstReferee;
    }
    
    /**
     * Vraća drugog sudiju.
     * 
     * @return secondReferee - Drugi sudija.
     */
    public Referee getSecondReferee() {
        return secondReferee;
    }

    /**
     * Postavlja novog drugog sudiju.
     * 
     * @param secondReferee - Novi drugi sudija.
     * @throws NullPointerException - Ako je drugi sudija null.
     */
    public void setSecondReferee(Referee secondReferee) {
        if (secondReferee == null) {
            throw new NullPointerException("Second referee cannot be null.");
        }
        this.secondReferee = secondReferee;
    }
    
    /**
     * Vraća utakmicu.
     * 
     * @return game - Utakmica.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Postavlja novu utakmicu.
     * 
     * @param game - Nova utakmica.
     * @throws NullPointerException - Ako je utakmica null.
     */
    public void setGame(Game game) {
        if (game == null) {
            throw new NullPointerException("Game cannot be null.");
        }
        this.game = game;
    } 

    /**
     * Vraća hash kod objekta liste sudija.
     * 
     * @return hashCode - Hash kod objekta na osnovu vrednosti atributa.
     */
    @Override
	public int hashCode() {
		return Objects.hash(firstReferee, game, headReferee, id, secondReferee);
	}
    

    /**
     * Poredi dve liste sudija prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca liste sudija nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (headReferee, firstReferee, secondReferee, game, id) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase ListOfReferees, ili se razlikuje po vrednosti nekog atributa</li>
     * </ul>
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListOfReferees other = (ListOfReferees) obj;
		return Objects.equals(firstReferee, other.firstReferee) && Objects.equals(game, other.game)
				&& Objects.equals(headReferee, other.headReferee) && Objects.equals(id, other.id)
				&& Objects.equals(secondReferee, other.secondReferee);
	}

	/**
     * Vraća String reprezentaciju objekta liste sudija.
     * 
     * @return string - String reprezentacija objekta u formatu "ListOfReferees{headReferee=&lt;headReferee&gt;, firstReferee=&lt;firstReferee&gt;, secondReferee=&lt;secondReferee&gt;, game=&lt;game&gt;}"
     */
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
