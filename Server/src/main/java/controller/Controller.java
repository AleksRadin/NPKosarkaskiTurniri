package controller;

import domain.Coach;
import domain.Game;
import domain.League;
import domain.ListOfReferees;
import domain.PlayedGame;
import domain.Player;
import domain.PlayerStatistic;
import domain.Referee;
import domain.Team;
import domain.TeamStatistic;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import operation.coach.AddCoach;
import operation.coach.EditCoach;
import operation.coach.GetAllCoaches;
import operation.game.AddGame;
import operation.game.GetAllGames;
import operation.league.GetAllLeagues;
import operation.listOfReferees.AddListOfReferees;
import operation.listOfReferees.GetAllListOfReferees;
import operation.playedGame.AddPlayedGame;
import operation.playedGame.GetAllPlayedGames;
import operation.player.GetAllPlayers;
import operation.playerStats.AddPlayerStats;
import operation.playerStats.EditPlayerStats;
import operation.playerStats.GetAllPlayersStats;
import operation.referee.GetAllReferees;
import operation.team.AddTeam;
import operation.team.EditTeam;
import operation.team.GetAllTeams;
import operation.teamStats.AddTeamStats;
import operation.teamStats.EditTeamStats;
import operation.teamStats.GetAllTeamStats;
import operation.user.GetAllUsers;

/**
 * Kontroler klasa koja upravlja poslovnom logikom aplikacije.
 * Ova klasa koristi operacije definisane u drugom sloju aplikacije da bi se izvršavale akcije
 * kao što su dodavanje, izmena, i pretraga podataka o korisnicima, igračima, timovima, utakmicama, itd.
 * 
 * @author Radin
 */
public class Controller {
	/**
	 * Jedinstvena instanca Controller klase.
	 */
    private static Controller controller;

    /**
     * Privatni konstruktor koji se poziva samo jednom kako bi se kreirala jedina instanca klase Controller.
     */
    private Controller() {
    }
    
    /**
     * Metoda koja omogućava pristup instance kontrolera koristeći Singleton obrazac.
     * 
     * @return instanca kontrolera
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
    /**
     * Metoda koja omogućava prijavljivanje korisnika.
     * Proverava da li korisnik postoji u bazi podataka na osnovu korisničkog imena i lozinke.
     * 
     * @param user Korisnik koji pokušava da se prijavi
     * @return Prijavljeni korisnik ako su podaci tačni
     * @throws Exception Ukoliko korisničko ime ili lozinka nisu validni
     */
    public User login(User user) throws Exception {
        GetAllUsers operation = new GetAllUsers();
        operation.execute(user);
        List<User> users = operation.getUsers();
        for (User use : users) {
            if (user.getUsername().equals(use.getUsername()) && user.getPassword().equals(use.getPassword())) {
                return use;
            }
        }
        throw new Exception("Unknown user!");
    }
    
    /**
     * Dodaje novi tim u bazu podataka.
     * 
     * @param team Tim koji treba da se doda
     * @throws Exception Ukoliko dođe do greške prilikom dodavanja tima
     */
    public void addTeam(Team team) throws Exception {
        AddTeam operation = new AddTeam();
        operation.execute(team);
    }

    /**
     * Pretražuje sve igrače koji se slažu sa prosleđenim kriterijumom.
     * 
     * @param player Igrač po kome se vrši pretraga
     * @return Lista igrača koji zadovoljavaju prosleđeni kriterijum
     * @throws Exception Ukoliko nijedan igrač ne odgovara kriterijumu
     */
    public List<Player> getPlayers(Player player) throws Exception {
        List<Player> allPlayers = getAllPlayers(player);
    
        List<Player> players = new ArrayList<>();
    
        for(Player plr : allPlayers){
            if(plr.getLastname().equals(player.getLastname()))
            players.add(plr);
        }
        if(players.isEmpty()){
            throw new Exception("No players match the criteria.");
        }
        return players;
    }

    /**
     * Vraća sve igrače iz baze podataka.
     * 
     * @param player Igrač za koji se traže podaci (kriterijum pretrage)
     * @return Lista svih igrača
     * @throws Exception Ukoliko nema igrača u bazi podataka
     */
    public List<Player> getAllPlayers(Player player) throws Exception {
        GetAllPlayers operation =  new GetAllPlayers();
        operation.execute(player);
        List<Player> players = operation.getPlayers();
        
        if(players.isEmpty()){
        throw new Exception("No players were found in the database.");
    }
        return players;
        
    }

    /**
     * Pretražuje sve timove koji odgovaraju prosleđenom kriterijumu.
     * 
     * @param team Tim za koji se traže podaci
     * @return Lista timova koji odgovaraju kriterijumu
     * @throws Exception Ukoliko nema timova koji odgovaraju kriterijumu
     */
    public List<Team> getTeams(Team team) throws Exception {
        List<Team> allTeams = getAllTeams(team);
        
        List<Team> teams = new ArrayList<>();

        for (Team tm : allTeams) {
            if (tm.getName().equals(team.getName())) {
                teams.add(tm);
            }
        }

        if (teams.isEmpty()) {
            throw new Exception("No teams match the criteria.");
        }

        return teams;
    }
    
    /**
     * Vraća sve timove iz baze podataka.
     * 
     * @param team Tim za koji se traže podaci (kriterijum pretrage)
     * @return Lista svih timova
     * @throws Exception Ukoliko nema timova u bazi podataka
     */
    public List<Team> getAllTeams(Team team) throws Exception {
        GetAllTeams operation = new GetAllTeams();
        operation.execute(team);
        List<Team> teams = operation.getTeams();

        if (teams.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return teams;
    }
    

    /**
     * Ažurira informacije o timu u bazi podataka.
     * 
     * @param team Tim koji treba ažurirati
     * @throws Exception Ukoliko dođe do greške prilikom izmene tima
     */
    public void editTeam(Team team) throws Exception {
        EditTeam  operation = new EditTeam();
        operation.execute(team);
    }

    /**
     * Dodaje novu utakmicu u bazu podataka.
     * 
     * @param game Utakmica koja se dodaje
     * @throws Exception Ukoliko dođe do greške prilikom dodavanja utakmice
     */
    public void addGame(Game game) throws Exception {
        AddGame operation = new AddGame();
        operation.execute(game);
    }

    /**
     * Pretražuje sve utakmice koje odgovaraju prosleđenom kriterijumu.
     * 
     * @param game Utakmica za koju se traže podaci
     * @return Lista utakmica koje odgovaraju kriterijumu
     * @throws Exception Ukoliko nema utakmica koje odgovaraju kriterijumu
     */
    public Object getGames(Game game) throws Exception {
        List<Game> allGames = getAllGames(game);

        List<Game> filteredGames = new ArrayList<>();

        for (Game gm : allGames) {

            if (gm.getGameDate().equals(game.getGameDate())) {
                filteredGames.add(gm);
            }
        }

        if (filteredGames.isEmpty()) {
            throw new Exception("No games match the criteria.");
        }

        return filteredGames;
    }

    /**
     * Vraća sve utakmice iz baze podataka.
     * 
     * @param game Utakmica za koju se traže podaci (kriterijum pretrage)
     * @return Lista svih utakmica
     * @throws Exception Ukoliko nema utakmica u bazi podataka
     */
    public List<Game> getAllGames(Game game) throws Exception {
        GetAllGames operation = new GetAllGames();
        operation.execute(game);
        List<Game> games = operation.getGames();

        if (games.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }

        return games;
    }

    /**
     * Dodaje odigranu utakmicu u bazu podataka.
     * 
     * @param playedGame objekat koji predstavlja odigranu utakmicu
     * @throws Exception ako dođe do greške tokom dodavanja utakmice
     */
    public void addPlayedGame(PlayedGame playedGame) throws Exception {
        AddPlayedGame operation = new AddPlayedGame();
        operation.execute(playedGame);
    }

    /**
     * Dohvata sve odigrane utakmice iz baze podataka.
     * 
     * @param playedGame parametar za filtriranje (nije obavezno)
     * @return lista svih odigranih utakmica
     * @throws Exception ako nema pronađenih utakmica u bazi
     */
    public Object getAllPlayedGames(PlayedGame playedGame) throws Exception {
        List<Game> games = getAllGames(new Game());
        List<Team> teams = getAllTeams(new Team());
        GetAllPlayedGames operation = new GetAllPlayedGames();
        operation.execute(playedGame);
        List<PlayedGame> playedGames = operation.getPlayedGames();

        for (PlayedGame pg : playedGames) {
            for (Team team : teams) {
                if (pg.getAwayTeam().getId().equals(team.getId())) {
                    pg.setAwayTeam(team);
                }
                if (pg.getHomeTeam().getId().equals(team.getId())){
                    pg.setHomeTeam(team);
                }           
            } 
        }
        
        
        for (PlayedGame pg : playedGames) {
            for (Game game : games) {
                if(game.getId().equals(pg.getGame().getId())){
                    pg.setGame(game);
                }
            }
        }
        
        if (playedGames.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }

        return playedGames;
    }

    /**
     * Dohvata sve sudije iz baze podataka.
     * 
     * @param referee parametar za filtriranje (nije obavezno)
     * @return lista svih sudija
     * @throws Exception ako nema pronađenih sudija u bazi
     */
    public List<Referee> getAllReferees(Referee referee) throws Exception {
        GetAllReferees operation = new GetAllReferees();
        operation.execute(referee);
        List<Referee> referees = operation.getReferees();

        if (referees.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }

        return referees;
    }

    /**
     * Dodaje listu sudija za utakmicu u bazu podataka.
     * 
     * @param listOfReferees objekat koji sadrži listu sudija
     * @throws Exception ako dođe do greške tokom dodavanja
     */
    public void addListOfReferees(ListOfReferees listOfReferees) throws Exception {
        AddListOfReferees operation = new AddListOfReferees();
        operation.execute(listOfReferees);
    }

    /**
     * Dohvata listu sudija za određenu utakmicu.
     * 
     * @param listOfReferees objekat koji sadrži podatke o utakmici za filtriranje
     * @return lista sudija za određenu utakmicu
     * @throws Exception ako nema pronađenih sudija za tu utakmicu
     */
    public Object getListOfReferees(ListOfReferees listOfReferees) throws Exception {
        List<ListOfReferees> allRefereesLists = getAllListOfReferees(listOfReferees);
        
        List<ListOfReferees> filteredList = new ArrayList<>();

        
        for (ListOfReferees allRef : allRefereesLists) {
            if(allRef.getGame().getId().equals(listOfReferees.getGame().getId())){
                filteredList.add(allRef);
            }
        }
        
        List<Referee> referees = getAllReferees(new Referee());
        
        for (ListOfReferees ref : filteredList) {
            for (Referee referee : referees) {
                if(ref.getFirstReferee().getId().equals(referee.getId())){
                    ref.setFirstReferee(referee);
                }
                if(ref.getSecondReferee().getId().equals(referee.getId())){
                    ref.setSecondReferee(referee);
                }
                if(ref.getHeadReferee().getId().equals(referee.getId())){
                    ref.setHeadReferee(referee);
                }
            }
        }

        if (filteredList.isEmpty()) {
            throw new Exception("No games match the criteria.");
        }

        return filteredList;
    }

    /**
     * Dohvata sve liste sudija iz baze podataka.
     * 
     * @param list objekat koji predstavlja listu sudija
     * @return lista svih listi sudija
     * @throws Exception ako nema pronađenih listi sudija u bazi
     */
    public List<ListOfReferees> getAllListOfReferees(ListOfReferees list) throws Exception {
        GetAllListOfReferees operation = new GetAllListOfReferees();
        operation.execute(list);
        List<ListOfReferees> list2 = operation.getList();

        if (list2.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }
        return list2;
     }

    /**
     * Dodaje trenera u bazu podataka.
     * 
     * @param coach objekat koji predstavlja trenera koji se dodaje
     * @throws Exception ako dođe do greške tokom dodavanja trenera
     */
    public void addCoach(Coach coach) throws Exception {
        AddCoach operation = new AddCoach();
        operation.execute(coach);
    }

    /**
     * Vraca trenere iz baze podataka na osnovu prezimena.
     * 
     * @param coach objekat koji sadrži prezime trenera za filtriranje
     * @return lista trenera koji odgovaraju prezimenu
     * @throws Exception ako nijedan trener ne odgovara kriterijumu
     */
    public Object getCoaches(Coach coach) throws Exception {
        List<Coach> allCoaches = getAllCoaches(coach);

        List<Coach> coaches = new ArrayList<>();

        for (Coach c : allCoaches) {
            if (c.getLastname().equals(coach.getLastname())) {
                coaches.add(c);
            }
        }

        if (coaches.isEmpty()) {
            throw new Exception("No coaches match the criteria.");
        }

        return coaches;
    }

  
    /**
     * Vraca sve trenere iz baze podataka.
     * 
     * @param coach objekat za filtriranje (nije obavezno)
     * @return lista svih trenera iz baze podataka
     * @throws Exception ako nije pronađen nijedan trener
     */
    public List<Coach> getAllCoaches(Coach coach) throws Exception {
        try {

            GetAllCoaches operation = new GetAllCoaches();
            
            operation.execute(coach);
            List<Coach> coaches = operation.getCoaches();

            if (coaches.isEmpty()) {
                throw new Exception("No coaches were found in the database.");
            }

            return coaches;
        } catch (Exception e) {
            throw new Exception("Failed to retrieve coaches: " + e.getMessage());
        }
    }

    /**
     * Izmenjuje informacije o treneru u bazi podataka.
     * 
     * @param coach objekat koji sadrži izmenjene podatke o treneru
     * @throws Exception ako dođe do greške tokom izmene
     */
    public void editCoach(Coach coach) throws Exception {
        EditCoach  operation = new EditCoach();
        operation.execute(coach);
    }

    /**
     * Dodaje statistiku igrača u bazu podataka.
     * 
     * @param playerStatistic objekat koji sadrži statistiku igrača
     * @throws Exception ako dođe do greške tokom dodavanja statistike
     */
    public void addPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        AddPlayerStats operation = new AddPlayerStats();
        operation.execute(playerStatistic);
    }

    /**
     * Vraca sve statistike igrača iz baze podataka.
     * 
     * @param playerStatistic objekat za filtriranje (nije obavezno)
     * @return lista statistika svih igrača
     * @throws Exception ako nije pronađena nijedna statistika igrača
     */
    public List<PlayerStatistic> getAllPlayersStats(PlayerStatistic playerStatistic) throws Exception {
        GetAllPlayersStats operation = new GetAllPlayersStats();
        operation.execute(playerStatistic);
        List<PlayerStatistic> playersStats = operation.getPlayersStats();

        if (playersStats.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return playersStats;
    }
    
    
    /**
     * Vraca statistiku za određenog igrača i određenu utakmicu.
     * 
     * @param playerStatistic objekat koji sadrži podatke o igraču i utakmici za filtriranje
     * @return statistika igrača za tu utakmicu
     * @throws Exception ako nije pronađena statistika koja odgovara kriterijumu
     */
    public Object getPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        List<PlayerStatistic> playersStats = getAllPlayersStats(playerStatistic);

        PlayerStatistic filteredPlayerStats = null;

        for (PlayerStatistic ps : playersStats) {

            if (ps.getPlayer().getId().equals(playerStatistic.getPlayer().getId()) && ps.getGame().getId().equals(playerStatistic.getGame().getId())) {
                filteredPlayerStats = ps;
            }
        }

        if (filteredPlayerStats == null) {
            throw new Exception("No palyer match the criteria.");
        }

        return filteredPlayerStats;
    }

    /**
     * Izmenjuje statistiku igrača u bazi podataka.
     * 
     * @param playerStatistic objekat koji sadrži izmenjene podatke o statistici igrača
     * @throws Exception ako dođe do greške tokom izmene
     */
    public void editPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        EditPlayerStats  operation = new EditPlayerStats();
        operation.execute(playerStatistic);
    }

    /**
     * Vraca sve statistike timova iz baze podataka.
     * 
     * @param teamStatistic objekat za filtriranje (nije obavezno)
     * @return lista statistika svih timova
     * @throws Exception ako nije pronađena nijedna statistika timova
     */
    public Object getAllTeamStats(TeamStatistic teamStatistic) throws Exception { 
        GetAllTeamStats operation = new GetAllTeamStats();
        operation.execute(teamStatistic);
        List<TeamStatistic> teamStats = operation.getTeamStats();

        if (teamStats.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return teamStats;
    }

    /**
     * Vraca sve lige iz baze podataka.
     * 
     * @param league objekat za filtriranje (nije obavezno)
     * @return lista svih liga
     * @throws Exception ako nije pronađena nijedna liga
     */
    public Object getAllLeagues(League league) throws Exception {
        
        GetAllLeagues operation = new GetAllLeagues();
        operation.execute(league);
        List<League> leagues = operation.getLeagues();

        if (leagues.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return leagues;
    }

    /**
     * Dodaje statistiku tima u bazu podataka.
     * 
     * @param teamStatistic objekat koji sadrži statistiku tima
     * @throws Exception ako dođe do greške tokom dodavanja statistike
     */
    public void addTeamStat(TeamStatistic teamStatistic) throws Exception {
        AddTeamStats operation = new AddTeamStats();
        operation.execute(teamStatistic);
    }

    /**
     * Izmenjuje statistiku tima u bazi podataka.
     * 
     * @param teamStatistic objekat koji sadrži izmenjene podatke o statistici tima
     * @throws Exception ako dođe do greške tokom izmene statistike
     */
    public void editTeamStat(TeamStatistic teamStatistic) throws Exception {
        EditTeamStats  operation = new EditTeamStats();
        operation.execute(teamStatistic);
    }
    

    

    
}
