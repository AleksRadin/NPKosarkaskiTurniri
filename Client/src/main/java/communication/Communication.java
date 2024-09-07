package communication;

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
import java.net.Socket;
import java.util.List;

/**
 * Klasa za rukovanje komunikacijom između klijenta i servera za razne operacije 
 * kao što su autentifikacija korisnika, dodavanje i dohvat podataka, i modifikacija entiteta.
 * 
 * @author Radin
 */
public class Communication {
	/**
	 * Socket koji omogućava mrežnu komunikaciju između klijenta i servera.
	 */
    Socket socket;
    /**
     * Objekat klase Sender koji omogućava slanje zahteva serveru.
     */
    Sender sender;
    /**
     * Objekat klase Receiver koji omogućava prijem odgovora od servera.
     */
    Receiver receiver;
    
    private static Communication instance;
    

    /**
     * Privatni konstruktor za inicijalizaciju socket konekcije, sender-a i receiver-a.
     * 
     * @throws Exception ako inicijalizacija socketa ne uspe
     */
    private Communication() throws Exception{
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    

    /**
     * Vraća jedinu instancu klase Communication (Singleton šablon).
     * 
     * @return jedina instanca Communication klase
     * @throws Exception ako kreiranje instance ne uspe
     */
    public static Communication getInstance() throws Exception{
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }
    
    /**
     * Šalje zahtev serveru za prijavu korisnika.
     * 
     * @param username Korisničko ime korisnika
     * @param password Lozinka korisnika
     * @return Korisnik koji je uspešno prijavljen
     * @throws Exception ako prijava ne uspe
     */
    public User login(String username, String password) throws Exception {
        try{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Request request = new Request(Operation.LOGIN, user);
            sender.send(request);
            Response response = (Response)receiver.receive();
            if(response.getException() == null){
                return (User)response.getResult();
            }else{
                throw response.getException();
            }
        } catch(Exception e){
            throw new Exception("User cannot be logged in");
        }
    }
    
   
    /**
     * Šalje zahtev za čuvanje novog tima.
     * 
     * @param team tim koji treba sačuvati
     * @throws Exception ako tim ne može biti sačuvan
     */
    public void saveTeam(Team team) throws Exception {
    try {
        Request request = new Request(Operation.ADD_TEAM, team);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
        } catch (Exception e) {
        throw new Exception("Team cannot be saved");
        }
    }

    /**
     * Šalje zahtev za preuzimanje liste igrača.
     * 
     * @param player igrači koje treba preuzeti
     * @return lista igrača
     * @throws Exception ako igrači ne mogu biti preuzeti
     */
    public List<Player> getPlayers(Player player) throws Exception {
        Request request = new Request(Operation.GET_PLAYERS, player);
        sender.send(request);
        Response response = (Response) receiver.receive();
    
        if (response.getException() == null) {
            return (List<Player>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Šalje zahtev za izmenu tima.
     * 
     * @param team tim koji treba izmeniti
     * @throws Exception ako tim ne može biti izmenjen
     */
    public void editTeam(Team team) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_TEAM, team);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Team cannot be edited");
        }
    }

    /**
     * Šalje zahtev za preuzimanje liste timova.
     * 
     * @param team timovi koji treba da se preuzmu
     * @return lista timova
     * @throws Exception ako timovi ne mogu biti preuzeti
     */
    public List<Team> getTeams(Team team) throws Exception {
        try {
            Request request = new Request(Operation.GET_TEAMS, team);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (List<Team>) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve teams");
        }
    }

    /**
     * Šalje zahtev za dodavanje nove utakmice.
     * 
     * @param game utakmica koja treba biti dodata
     * @throws Exception ako utakmica ne može biti dodata
     */
    public void addGame(Game game) throws Exception {
        try {
            Request request = new Request(Operation.ADD_GAME, game);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Game cannot be added");
        }
    }

    /**
     * Šalje zahtev za preuzimanje liste utakmica.
     * 
     * @param game utakmica koja služi kao kriterijum za pretragu
     * @return lista utakmica koje odgovaraju kriterijumima
     * @throws Exception ako dođe do greške prilikom preuzimanja utakmica
     */
    public List<Game> getGames(Game game) throws Exception {
        try {
        Request request = new Request(Operation.GET_GAMES, game);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Game>) response.getResult();
        } else {
            throw response.getException();
        }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve games");
        }
    }

    /**
     * Šalje zahtev za dodavanje odigrane utakmice.
     * 
     * @param playedGame odigrana utakmica koja treba biti dodata
     * @throws Exception ako odigrana utakmica ne može biti dodata
     */
    public void addPlayedGame(PlayedGame playedGame) throws Exception {
        Request request = new Request(Operation.ADD_PLAYED_GAME, playedGame);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Šalje zahtev za preuzimanje liste svih utakmica.
     * 
     * @param game utakmice koje treba preuzeti
     * @return lista utakmica
     * @throws Exception ako utakmice ne mogu biti preuzete
     */
    public List<Game> getAllGames(Game game) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_GAMES, game);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (List<Game>) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve games");
        }
    }

    /**
     * Šalje zahtev za preuzimanje liste svih timova.
     * 
     * @param team timovi koji treba da se preuzmu
     * @return lista timova
     * @throws Exception ako timovi ne mogu biti preuzeti
     */
    public List<Team> getAllTeams(Team team) throws Exception {
        try {
    
        Request request = new Request(Operation.GET_ALL_TEAMS, team); 
        sender.send(request); 


        Response response = (Response) receiver.receive();


        if (response.getException() == null) {
            return (List<Team>) response.getResult(); 
        } else {
            throw response.getException(); 
        }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve teams: " + e.getMessage()); 
        }
    }

    /**
     * Šalje zahtev za dobijanje liste odigranih igara.
     *
     * @param playedGame kriterijumi za filtriranje odigranih igara
     * @return lista odigranih igara
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju odigranih igara
     */
    public List<PlayedGame> getAllPlayedGames(PlayedGame playedGame) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_PLAYED_GAMES, playedGame);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (List<PlayedGame>) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve games");
        }
    }

    /**
     * Šalje zahtev za dobijanje liste sudija.
     *
     * @param referee kriterijumi za filtriranje sudija
     * @return lista sudija
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju sudija
     */
    public List<Referee> getAllReferees(Referee referee) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_REFEREES, referee);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (List<Referee>) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve games");
        }
    }

    /**
     * Šalje zahtev za dodavanje liste sudija.
     *
     * @param listOfReferees objekat koji sadrži listu sudija za dodavanje
     * @throws Exception ako dođe do greške pri slanju zahteva ili dodavanju liste sudija
     */
    public void addListOfReferees(ListOfReferees listOfReferees) throws Exception {
        Request request = new Request(Operation.ADD_LIST_OF_REFEREES, listOfReferees);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    /**
     * Šalje zahtev za dobijanje liste referentnih sudija.
     *
     * @param list objekat koji sadrži kriterijume za filtriranje referentnih sudija
     * @return lista referentnih sudija
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju referentnih sudija
     */
    public List<ListOfReferees> getListOfReferees(ListOfReferees list) throws Exception {
        try {
            Request request = new Request(Operation.GET_LIST_OF_REFEREES, list);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (List<ListOfReferees>) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve teams");
        }
    }

    /**
     * Šalje zahtev za dobijanje liste igrača.
     *
     * @param player objekat koji sadrži kriterijume za filtriranje igrača
     * @return lista igrača
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju igrača
     */
    public List<Player> getAllPlayers(Player player) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_PLAYERS, player); 
            sender.send(request); 
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Player>) response.getResult(); 
            } else {
                throw response.getException(); 
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve list of players: " + e.getMessage()); 
        }
    }

    /**
     * Šalje zahtev za dodavanje trenera.
     *
     * @param coach objekat koji sadrži podatke o treneru za dodavanje
     * @throws Exception ako dođe do greške pri slanju zahteva ili dodavanju trenera
     */
    public void addCoach(Coach coach) throws Exception {
        try {
            Request request = new Request(Operation.ADD_COACH, coach);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Coach cannot be added");
        }
    }

    /**
     * Šalje zahtev za dobijanje liste trenera.
     *
     * @param coach kriterijumi za filtriranje trenera
     * @return lista trenera
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju trenera
     */
    public List<Coach> getCoaches(Coach coach) throws Exception {
        Request request = new Request(Operation.GET_COACHES, coach);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Coach>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    /**
     * Šalje zahtev za izmenu trenera.
     *
     * @param coach objekat koji sadrži nove podatke o treneru
     * @throws Exception ako dođe do greške pri slanju zahteva ili izmeni trenera
     */
    public void editCoach(Coach coach) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_COACH, coach);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Coach cannot be edited");
        }
    }

    /**
     * Šalje zahtev za dodavanje statistike igrača.
     *
     * @param playerStatistic objekat koji sadrži podatke o statistici igrača
     * @throws Exception ako dođe do greške pri slanju zahteva ili dodavanju statistike
     */
    public void addPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        try {
            Request request = new Request(Operation.ADD_PLAYER_STATISTIC, playerStatistic);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }

        } catch (Exception e) {
            throw new Exception("Player_stats cannot be added");
        }
    }

    /**
     * Šalje zahtev za dobijanje statistike igrača.
     *
     * @param playerStatistic kriterijumi za filtriranje statistike igrača
     * @return statistika igrača
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju statistike
     */
    public PlayerStatistic getPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        try {
            Request request = new Request(Operation.GET_PLAYER_STATISTICS, playerStatistic);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() == null) {
                return (PlayerStatistic) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve player statistics: " + e.getMessage());
        }
    }

    /**
     * Šalje zahtev za izmenu statistike igrača.
     *
     * @param playerStatistic objekat koji sadrži nove podatke o statistici igrača
     * @throws Exception ako dođe do greške pri slanju zahteva ili izmeni statistike
     */
    public void editPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_PLAYER_STATS, playerStatistic);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Player stats cannot be edited");
        }
    }

    /**
     * Šalje zahtev za dobijanje svih statistika timova.
     *
     * @param teamStatistic kriterijumi za filtriranje statistike timova
     * @return lista statistike timova
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju statistike timova
     */
    public List<TeamStatistic> getAllTeamStats(TeamStatistic teamStatistic) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_TEAM_STATS, teamStatistic); 
            sender.send(request); 
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<TeamStatistic>) response.getResult(); 
            } else {
                throw response.getException(); 
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve list of team stats: " + e.getMessage()); 
        }
    }

    /**
     * Šalje zahtev za dobijanje svih liga.
     *
     * @param league kriterijumi za filtriranje liga
     * @return lista liga
     * @throws Exception ako dođe do greške pri slanju zahteva ili dohvatanju liga
     */
    public List<League> getAllLeagues(League league) throws Exception {
        try {
            Request request = new Request(Operation.GET_ALL_LEAGUES, league); 
            sender.send(request); 
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<League>) response.getResult(); 
            } else {
                throw response.getException(); 
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve list of leagues: " + e.getMessage()); 
        }
    }

    /**
     * Šalje zahtev za izmenu statistike tima.
     *
     * @param newStat objekat koji sadrži nove podatke o statistici tima
     * @throws Exception ako dođe do greške pri slanju zahteva ili izmeni statistike tima
     */
    public void editTeamStat(TeamStatistic newStat) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_TEAM_STAT, newStat);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Team stats cannot be edited");
        }
    }

    /**
     * Šalje zahtev za dodavanje statistike tima.
     *
     * @param newStat objekat koji sadrži podatke o statistici tima za dodavanje
     * @throws Exception ako dođe do greške pri slanju zahteva ili dodavanju statistike tima
     */
    public void addTeamStat(TeamStatistic newStat) throws Exception {
        try {
            Request request = new Request(Operation.ADD_TEAM_STAT, newStat);
            sender.send(request);
            Response response = (Response) receiver.receive();

            if (response.getException() != null) {
                throw response.getException();
            }

        } catch (Exception e) {
            throw new Exception("Team stats cannot be added");
        }
    }
    
}
