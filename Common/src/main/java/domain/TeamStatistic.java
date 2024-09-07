package domain;

import java.util.Objects;

/**
 * Predstavlja statistiku tima u okviru određene lige.
 * 
 * Sadrži informacije o broju odigranih, pobedjenih, izgubljenih i nerešenih utakmica, kao i bodovima i rangu tima.
 * 
 * @author Radin
 */
public class TeamStatistic implements GenericEntity{
    
	/**
     * ID statistike tima u bazi podataka.
     * Predstavlja jedinstveni identifikator statistike tima.
     */
    private Long id;
    /**
     * Liga u kojoj se tim takmiči.
     * Predstavlja objekat klase {@link League}.
     */
    private League league; 
    /**
     * Tim čija se statistika prati.
     * Predstavlja objekat klase {@link Team}.
     */
    private Team team;
    /**
     * Broj odigranih utakmica.
     * Predstavlja broj utakmica koje je tim odigrao.
     */
    private int playedGames;
    /**
     * Broj pobedjenih utakmica.
     * Predstavlja broj utakmica koje je tim pobedio.
     */
    private int wonGames;
    /**
     * Broj izgubljenih utakmica.
     * Predstavlja broj utakmica koje je tim izgubio.
     */
    private int lostGames;
    /**
     * Broj nerešenih utakmica.
     * Predstavlja broj utakmica koje su završene bez pobednika.
     */
    private int drawnGames;
    /**
     * Broj bodova koje je tim osvojio.
     * Predstavlja ukupni broj bodova koje je tim sakupio tokom sezone.
     */
    private int points;
    /**
     * Rang tima u ligi.
     * Predstavlja poziciju tima u tabeli lige.
     */
    private int rank;

    /**
     * Konstruktor za inicijalizaciju statistike tima sa svim atributima.
     * 
     * @param id - ID statistike tima kao Long vrednost.
     * @param league - Liga u kojoj se tim takmiči kao objekat klase {@link League}.
     * @param team - Tim čija se statistika prati kao objekat klase {@link Team}.
     * @param playedGames - Broj odigranih utakmica kao int.
     * @param wonGames - Broj pobedjenih utakmica kao int.
     * @param lostGames - Broj izgubljenih utakmica kao int.
     * @param drawnGames - Broj nerešenih utakmica kao int.
     * @param points - Broj bodova kao int.
     * @param rank - Rang tima kao int.
     */
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

    

    /**
     * Prazan konstruktor za kreiranje instance statistike tima bez inicijalizacije atributa.
     */
    public TeamStatistic() {
    }

    /**
     * Vraća ID statistike tima.
     * 
     * @return id - ID statistike tima kao Long vrednost.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID statistike tima.
     * 
     * @param id - Nova ID vrednost kao Long.
     * 
     * @throws NullPointerException - Ako je ID null.
     * @throws IllegalArgumentException - Ako je ID manji ili jednak 0.
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
     * Vraća ligu u kojoj se tim takmiči.
     * 
     * @return league - Liga kao objekat klase {@link League}.
     */
    public League getLeague() {
        return league;
    }

    /**
     * Postavlja novu ligu u kojoj se tim takmiči.
     * 
     * @param league - Nova liga kao objekat klase {@link League}.
     * 
     * @throws IllegalArgumentException - Ako je liga null.
     */
    public void setLeague(League league) {
        if (league == null) {
            throw new IllegalArgumentException("League cannot be null.");
        }
        this.league = league;
    }

    /**
     * Vraća tim čija se statistika prati.
     * 
     * @return team - Tim kao objekat klase {@link Team}.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Postavlja novi tim čija se statistika prati.
     * 
     * @param team - Novi tim kao objekat klase {@link Team}.
     * 
     * @throws IllegalArgumentException - Ako je tim null.
     */
    public void setTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null.");
        }
        this.team = team;
    }

    /**
     * Vraća broj bodova tima.
     * 
     * @return points - Broj bodova kao int.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Postavlja broj bodova tima.
     * 
     * @param points - Novi broj bodova kao int.
     * 
     * @throws IllegalArgumentException - Ako je broj bodova manji od 0.
     */
    public void setPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.points = points;
    }

    /**
     * Vraća broj odigranih utakmica.
     * 
     * @return playedGames - Broj odigranih utakmica kao int.
     */
    public int getPlayedGames() {
        return playedGames;
    }

    /**
     * Postavlja broj odigranih utakmica.
     * 
     * @param playedGames - Novi broj odigranih utakmica kao int.
     * 
     * @throws IllegalArgumentException - Ako je broj odigranih utakmica manji od 0.
     */
    public void setPlayedGames(int playedGames) {
        if (playedGames < 0) {
            throw new IllegalArgumentException("Played games cannot be negative.");
        }
        this.playedGames = playedGames;
    }
    
    /**
     * Vraća broj pobedjenih utakmica.
     * 
     * @return wonGames - Broj pobedjenih utakmica kao int.
     */
    public int getWonGames() {
        return wonGames;
    }

    /**
     * Postavlja broj pobedjenih utakmica.
     * 
     * @param wonGames - Novi broj pobedjenih utakmica kao int.
     * 
     * @throws IllegalArgumentException - Ako je broj pobedjenih utakmica manji od 0.
     */
    public void setWonGames(int wonGames) {
        if (wonGames < 0) {
            throw new IllegalArgumentException("Won games cannot be negative.");
        }
        this.wonGames = wonGames;
    }
    /**
     * Vraća broj izgubljenih utakmica.
     * 
     * @return lostGames - Broj izgubljenih utakmica kao int.
     */
    public int getLostGames() {
        return lostGames;
    }

    /**
     * Postavlja broj izgubljenih utakmica.
     * 
     * @param lostGames - Novi broj izgubljenih utakmica kao int.
     * 
     * @throws IllegalArgumentException - Ako je broj izgubljenih utakmica manji od 0.
     */
    public void setLostGames(int lostGames) {
        if (lostGames < 0) {
            throw new IllegalArgumentException("Lost games cannot be negative.");
        }
        this.lostGames = lostGames;
    }

    /**
     * Vraća broj nerešenih utakmica.
     * 
     * @return drawnGames - Broj nerešenih utakmica kao int.
     */
    public int getDrawnGames() {
        return drawnGames;
    }

    /**
     * Postavlja broj nerešenih utakmica.
     * 
     * @param drawnGames - Novi broj nerešenih utakmica kao int.
     * 
     * @throws IllegalArgumentException - Ako je broj nerešenih utakmica manji od 0.
     */
    public void setDrawnGames(int drawnGames) {
        if (drawnGames < 0) {
            throw new IllegalArgumentException("Drawn games cannot be negative.");
        }
        this.drawnGames = drawnGames;
    }

    /**
     * Vraća rang tima.
     * 
     * @return rank - Rang tima kao int.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Postavlja rang tima.
     * 
     * @param rank - Novi rang tima kao int.
     * 
     * @throws IllegalArgumentException - Ako je rang manji od 1.
     */
    public void setRank(int rank) {
        if (rank <= 0) {
            throw new IllegalArgumentException("Rank must be positive.");
        }
        this.rank = rank;
    }

    /**
     * Vraća hash kod objekta statistike tima.
     * 
     * @return hash code objekta kao int.
     */
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

    /**
     * Poredi trenutni objekat statistike tima sa datim objektom da bi se utvrdilo da li su jednaki.
     * Upoređuje sve atribute uključujući ID, ligu, tim, broj odigranih utakmica, broj pobedjenih utakmica,
     * broj izgubljenih utakmica, broj nerešenih utakmica, broj bodova i rang tima.
     * 
     * @param obj - Objekat sa kojim se poredi trenutni objekat statistike tima. Ako je null, objekat će biti različit od trenutnog objekta.
     * 
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, league, team, playedGames, wonGames, lostGames, drawnGames, points, rank) isti</li>
     *     <li>false - ako je objekat null, objekat nije klase TeamStatistic, ili se razlikuje po vrednosti nekog atributa</li>
     * </ul>
     */
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

    /**
     * Vraća string reprezentaciju statistike tima.
     * 
     * @return string - String koji sadrži sve podatke o statistici tima.
     */
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
