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
 *
 * @author Radin
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    
    private static Communication instance;
    
    private Communication() throws Exception{
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public static Communication getInstance() throws Exception{
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }
    
    
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
    
    
//    public void addPlayer(Player player) throws Exception {
//    try {
//        Request request = new Request(Operation.ADD_PLAYER, player);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//
//        if (response.getException() != null) {
//            throw response.getException();
//        }
//        } catch (Exception e) {
//        throw new Exception("Player cannot be added");
//        }
//    }
    
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

//    public void editPlayer(Player player) throws Exception {
//        try {
//        Request request = new Request(Operation.EDIT_PLAYER, player);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//
//        if (response.getException() != null) {
//            throw response.getException();
//        }
//        } catch (Exception e) {
//            throw new Exception("Player cannot be edited");
//        }
//    }

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

    public void addPlayedGame(PlayedGame playedGame) throws Exception {
        Request request = new Request(Operation.ADD_PLAYED_GAME, playedGame);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

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

    public void addListOfReferees(ListOfReferees listOfReferees) throws Exception {
        Request request = new Request(Operation.ADD_LIST_OF_REFEREES, listOfReferees);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

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
