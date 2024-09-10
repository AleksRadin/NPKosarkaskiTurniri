package domain;

import java.util.Objects;

/**
 * Predstavlja statistiku igrača.
 * 
 * Sadrži ID, ID igrača, broj poena, broj asistencija i broj utakmica.
 * 
 * @author Radin
 */
public class PlayerStatistic implements GenericEntity{
    
	/**
     * Jedinstveni identifikator statistike.
     */
    private Long id;
    /**
     * Igrač na kojeg se statistika odnosi.
     */
    private Player player;
    /**
     * Igra u kojoj je ostvarena statistika.
     */
    private Game game;
    /**
     * Broj minuta koje je igrač odigrao u igri.
     */
    private int minutesPlayed;
    /**
     * Broj poena koje je igrač postigao u igri.
     */
    private int pointsScored;
    /**
     * Broj postignutih trojki u igri.
     */
    private int threePointersMade;
    /**
     * Broj pokušaja trojki u igri.
     */
    private int threePointersAttempted;
    /**
     * Broj slobodnih bacanja koja je igrač postigao u igri.
     */
    private int freeThrowsMade;
    /**
     * Broj pokušaja slobodnih bacanja u igri.
     */
    private int freeThrowsAttempted;
    /**
     * Broj ofanzivnih skokova koje je igrač napravio u igri.
     */
    private int reboundsOffensive;
    /**
     * Broj defanzivnih skokova koje je igrač napravio u igri.
     */
    private int reboundsDefensive;
    /**
     * Broj asistencija koje je igrač imao u igri.
     */
    private int assists;
    /**
     * Broj ukradenih lopti koje je igrač napravio u igri.
     */
    private int steals;
    /**
     * Broj blokada koje je igrač napravio u igri.
     */
    private int blocks;
    /**
     * Broj ličnih grešaka koje je igrač napravio u igri.
     */
    private int personalFouls;

    /**
     * Konstruktor za kreiranje statistike igrača sa svim potrebnim informacijama.
     * 
     * @param id Jedinstveni identifikator statistike igrača.
     * @param player Igrač kojem statistika pripada.
     * @param game Igra za koju se vodi statistika.
     * @param minutesPlayed Broj minuta provedenih na terenu.
     * @param pointsScored Broj postignutih poena.
     * @param threePointersMade Broj postignutih trojki.
     * @param threePointersAttempted Broj pokušaja trojki.
     * @param freeThrowsMade Broj postignutih slobodnih bacanja.
     * @param freeThrowsAttempted Broj pokušaja slobodnih bacanja.
     * @param reboundsOffensive Broj ofanzivnih skokova.
     * @param reboundsDefensive Broj defanzivnih skokova.
     * @param assists Broj asistencija.
     * @param steals Broj ukradenih lopti.
     * @param blocks Broj blokada.
     * @param personalFouls Broj ličnih grešaka.
     */
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

    /**
     * Prazan konstruktor za inicijalizaciju objekta statistike igrača.
     */
    public PlayerStatistic() {
    }

    /**
     * Vraća jedinstveni identifikator statistike igrača.
     * 
     * @return Jedinstveni identifikator statistike igrača.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Postavlja jedinstveni identifikator statistike igrača.
     * 
     * @param id Jedinstveni identifikator statistike igrača.
     * @throws NullPointerException Ako je ID null.
     * @throws IllegalArgumentException Ako je ID manji ili jednak 0.
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
     * Vraća igrača kojem statistika pripada.
     * 
     * @return Igrač kojem statistika pripada.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Postavlja igrača kojem statistika pripada.
     * 
     * @param player Igrač kojem statistika pripada.
     * @throws NullPointerException Ako je igrač null.
     */
    public void setPlayer(Player player) {
        if (player == null) {
            throw new NullPointerException("Player cannot be null.");
        }
        this.player = player;
    }

    /**
     * Vraća igru za koju se vodi statistika.
     * 
     * @return Igra za koju se vodi statistika.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Postavlja igru za koju se vodi statistika.
     * 
     * @param game Igra za koju se vodi statistika.
     * @throws NullPointerException Ako je igra null.
     */
    public void setGame(Game game) {
        if (game == null) {
            throw new NullPointerException("Game cannot be null.");
        }
        this.game = game;
    }
    
    /**
     * Vraća broj minuta provedenih na terenu.
     * 
     * @return Broj minuta provedenih na terenu.
     */
    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    /**
     * Postavlja broj minuta provedenih na terenu.
     * 
     * @param minutesPlayed Broj minuta provedenih na terenu.
     * @throws IllegalArgumentException Ako je broj minuta negativan.
     */
    public void setMinutesPlayed(int minutesPlayed) {
        if (minutesPlayed < 0) {
            throw new IllegalArgumentException("Minutes played cannot be negative.");
        }
        this.minutesPlayed = minutesPlayed;
    }

    /**
     * Vraća broj postignutih poena.
     * 
     * @return Broj postignutih poena.
     */
    public int getPointsScored() {
        return pointsScored;
    }

    /**
     * Postavlja broj postignutih poena.
     * 
     * @param pointsScored Broj postignutih poena.
     * @throws IllegalArgumentException Ako je broj poena negativan.
     */
    public void setPointsScored(int pointsScored) {
        if (pointsScored < 0) {
            throw new IllegalArgumentException("Points scored cannot be negative.");
        }
        this.pointsScored = pointsScored;
    }

    /**
     * Vraća broj postignutih trojki.
     * 
     * @return Broj postignutih trojki.
     */
    public int getThreePointersMade() {
        return threePointersMade;
    }

    /**
     * Postavlja broj postignutih trojki.
     * 
     * @param threePointersMade Broj postignutih trojki.
     * @throws IllegalArgumentException Ako je broj trojki negativan.
     */
    public void setThreePointersMade(int threePointersMade) {
        if (threePointersMade < 0) {
            throw new IllegalArgumentException("Three pointers made cannot be negative.");
        }
        this.threePointersMade = threePointersMade;
    }

    /**
     * Vraća broj pokušaja trojki.
     * 
     * @return Broj pokušaja trojki.
     */
    public int getThreePointersAttempted() {
        return threePointersAttempted;
    }

    /**
     * Postavlja broj pokušaja trojki.
     * 
     * @param threePointersAttempted Broj pokušaja trojki.
     * @throws IllegalArgumentException Ako je broj pokušaja negativan.
     */
    public void setThreePointersAttempted(int threePointersAttempted) {
        if (threePointersAttempted < 0) {
            throw new IllegalArgumentException("Three pointers attempted cannot be negative.");
        }
        this.threePointersAttempted = threePointersAttempted;
    }

    /**
     * Vraća broj postignutih slobodnih bacanja.
     * 
     * @return Broj postignutih slobodnih bacanja.
     */
    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    /**
     * Postavlja broj postignutih slobodnih bacanja.
     * 
     * @param freeThrowsMade Broj postignutih slobodnih bacanja.
     * @throws IllegalArgumentException Ako je broj slobodnih bacanja negativan.
     */
    public void setFreeThrowsMade(int freeThrowsMade) {
        if (freeThrowsMade < 0) {
            throw new IllegalArgumentException("Free throws made cannot be negative.");
        }
        this.freeThrowsMade = freeThrowsMade;
    }

    /**
     * Vraća broj pokušaja slobodnih bacanja.
     * 
     * @return Broj pokušaja slobodnih bacanja.
     */
    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    /**
     * Postavlja broj pokušaja slobodnih bacanja.
     * 
     * @param freeThrowsAttempted Broj pokušaja slobodnih bacanja.
     * @throws IllegalArgumentException Ako je broj pokušaja negativan.
     */
    public void setFreeThrowsAttempted(int freeThrowsAttempted) {
        if (freeThrowsAttempted < 0) {
            throw new IllegalArgumentException("Free throws attempted cannot be negative.");
        }
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    /**
     * Vraća broj ofanzivnih skokova.
     * 
     * @return Broj ofanzivnih skokova.
     */
    public int getReboundsOffensive() {
        return reboundsOffensive;
    }

    /**
     * Postavlja broj ofanzivnih skokova.
     * 
     * @param reboundsOffensive Broj ofanzivnih skokova.
     * @throws IllegalArgumentException Ako je broj skokova negativan.
     */
    public void setReboundsOffensive(int reboundsOffensive) {
        if (reboundsOffensive < 0) {
            throw new IllegalArgumentException("Offensive rebounds cannot be negative.");
        }
        this.reboundsOffensive = reboundsOffensive;
    }
    
    /**
     * Vraća broj defanzivnih skokova.
     * 
     * @return Broj defanzivnih skokova.
     */
    public int getReboundsDefensive() {
        return reboundsDefensive;
    }

    /**
     * Postavlja broj defanzivnih skokova.
     * 
     * @param reboundsDefensive Broj defanzivnih skokova.
     * @throws IllegalArgumentException Ako je broj skokova negativan.
     */
    public void setReboundsDefensive(int reboundsDefensive) {
        if (reboundsDefensive < 0) {
            throw new IllegalArgumentException("Defensive rebounds cannot be negative.");
        }
        this.reboundsDefensive = reboundsDefensive;
    }

    /**
     * Vraća broj asistencija.
     * 
     * @return Broj asistencija.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Postavlja broj asistencija.
     * 
     * @param assists Broj asistencija.
     * @throws IllegalArgumentException Ako je broj asistencija negativan.
     */
    public void setAssists(int assists) {
        if (assists < 0) {
            throw new IllegalArgumentException("Assists cannot be negative.");
        }
        this.assists = assists;
    }

    /**
     * Vraća broj ukradenih lopti.
     * 
     * @return Broj ukradenih lopti.
     */
    public int getSteals() {
        return steals;
    }

    /**
     * Postavlja broj ukradenih lopti.
     * 
     * @param steals Broj ukradenih lopti.
     * @throws IllegalArgumentException Ako je broj ukradenih lopti negativan.
     */
    public void setSteals(int steals) {
        if (steals < 0) {
            throw new IllegalArgumentException("Steals cannot be negative.");
        }
        this.steals = steals;
    }

    /**
     * Vraća broj blokada.
     * 
     * @return Broj blokada.
     */
    public int getBlocks() {
        return blocks;
    }

    /**
     * Postavlja broj blokada.
     * 
     * @param blocks Broj blokada.
     * @throws IllegalArgumentException Ako je broj blokada negativan.
     */
    public void setBlocks(int blocks) {
        if (blocks < 0) {
            throw new IllegalArgumentException("Blocks cannot be negative.");
        }
        this.blocks = blocks;
    }

    /**
     * Vraća broj ličnih grešaka.
     * 
     * @return Broj ličnih grešaka.
     */
    public int getPersonalFouls() {
        return personalFouls;
    }

    /**
     * Postavlja broj ličnih grešaka.
     * 
     * @param personalFouls Broj ličnih grešaka.
     * @throws IllegalArgumentException Ako je broj ličnih grešaka negativan.
     */
    public void setPersonalFouls(int personalFouls) {
        if (personalFouls < 0) {
            throw new IllegalArgumentException("Personal fouls cannot be negative.");
        }
        this.personalFouls = personalFouls;
    }

    /**
     * Vraća hash kod objekta `PlayerStatistic` koristeći sve atribute klase.
     * 
     * @return hashCode - Hash kod objekta.
     */
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

    /**
     * Poredi dva objekta `PlayerStatistic` prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca `PlayerStatistic` na kojoj je pozvana metoda `equals()`.
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, player, game, minutesPlayed, pointsScored, threePointersMade, threePointersAttempted, freeThrowsMade, freeThrowsAttempted, reboundsOffensive, reboundsDefensive, assists, steals, blocks, personalFouls) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase `PlayerStatistic`, ili se razlikuje po vrednosti nekog atributa</li>
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
        return Objects.equals(this.game.getId(), other.game.getId());
    }

    /**
     * Vraća String reprezentaciju objekta `PlayerStatistic`.
     * 
     * @return string - String reprezentacija objekta u formatu "id: id, player: player, game: game, minutesPlayed: minutesPlayed, pointsScored: pointsScored, threePointersMade: threePointersMade, threePointersAttempted: threePointersAttempted, freeThrowsMade: freeThrowsMade, freeThrowsAttempted: freeThrowsAttempted, reboundsOffensive: reboundsOffensive, reboundsDefensive: reboundsDefensive, assists: assists, steals: steals, blocks: blocks, personalFouls: personalFouls"
     */
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

}
