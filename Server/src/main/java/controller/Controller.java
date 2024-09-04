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
 *
 * @author Radin
 */
public class Controller {
    private static Controller controller;

    private Controller() {
    }
    
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
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
    
    
//    public void addPlayer(Player player) throws Exception {
//        AddPlayer operation = new AddPlayer();
//        operation.execute(player);
//    }
    
    public void addTeam(Team team) throws Exception {
        AddTeam operation = new AddTeam();
        operation.execute(team);
    }

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

    public List<Player> getAllPlayers(Player player) throws Exception {
        GetAllPlayers operation =  new GetAllPlayers();
        operation.execute(player);
        List<Player> players = operation.getPlayers();
        
        if(players.isEmpty()){
        throw new Exception("No players were found in the database.");
    }
        return players;
        
    }

//    public void editPlayer(Player player) throws Exception {
//        EditPlayer  operation = new EditPlayer();
//        operation.execute(player);
//    }

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
    
    public List<Team> getAllTeams(Team team) throws Exception {
        GetAllTeams operation = new GetAllTeams();
        operation.execute(team);
        List<Team> teams = operation.getTeams();

        if (teams.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return teams;
    }
    

    public void editTeam(Team team) throws Exception {
        EditTeam  operation = new EditTeam();
        operation.execute(team);
    }

    public void addGame(Game game) throws Exception {
        AddGame operation = new AddGame();
        operation.execute(game);
    }

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

    public List<Game> getAllGames(Game game) throws Exception {
        GetAllGames operation = new GetAllGames();
        operation.execute(game);
        List<Game> games = operation.getGames();

        if (games.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }

        return games;
    }

    public void addPlayedGame(PlayedGame playedGame) throws Exception {
        AddPlayedGame operation = new AddPlayedGame();
        operation.execute(playedGame);
    }

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

    public List<Referee> getAllReferees(Referee referee) throws Exception {
        GetAllReferees operation = new GetAllReferees();
        operation.execute(referee);
        List<Referee> referees = operation.getReferees();

        if (referees.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }

        return referees;
    }

    public void addListOfReferees(ListOfReferees listOfReferees) throws Exception {
        AddListOfReferees operation = new AddListOfReferees();
        operation.execute(listOfReferees);
    }

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
    
    public List<ListOfReferees> getAllListOfReferees(ListOfReferees list) throws Exception {
        GetAllListOfReferees operation = new GetAllListOfReferees();
        operation.execute(list);
        List<ListOfReferees> list2 = operation.getList();

        if (list2.isEmpty()) {
            throw new Exception("No games were found in the database.");
        }
        return list2;
     }

    public void addCoach(Coach coach) throws Exception {
        AddCoach operation = new AddCoach();
        operation.execute(coach);
    }

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

    public void editCoach(Coach coach) throws Exception {
        EditCoach  operation = new EditCoach();
        operation.execute(coach);
    }

    public void addPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        AddPlayerStats operation = new AddPlayerStats();
        operation.execute(playerStatistic);
    }

    public List<PlayerStatistic> getAllPlayersStats(PlayerStatistic playerStatistic) throws Exception {
        GetAllPlayersStats operation = new GetAllPlayersStats();
        operation.execute(playerStatistic);
        List<PlayerStatistic> playersStats = operation.getPlayersStats();

        if (playersStats.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return playersStats;
    }
    
    
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

    public void editPlayerStats(PlayerStatistic playerStatistic) throws Exception {
        EditPlayerStats  operation = new EditPlayerStats();
        operation.execute(playerStatistic);
    }

    public Object getAllTeamStats(TeamStatistic teamStatistic) throws Exception { 
        GetAllTeamStats operation = new GetAllTeamStats();
        operation.execute(teamStatistic);
        List<TeamStatistic> teamStats = operation.getTeamStats();

        if (teamStats.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return teamStats;
    }

    public Object getAllLeagues(League league) throws Exception {
        
        GetAllLeagues operation = new GetAllLeagues();
        operation.execute(league);
        List<League> leagues = operation.getLeagues();

        if (leagues.isEmpty()) {
            throw new Exception("No teams were found in the database.");
        }

        return leagues;
    }

    public void addTeamStat(TeamStatistic teamStatistic) throws Exception {
        AddTeamStats operation = new AddTeamStats();
        operation.execute(teamStatistic);
    }

    public void editTeamStat(TeamStatistic teamStatistic) throws Exception {
        EditTeamStats  operation = new EditTeamStats();
        operation.execute(teamStatistic);
    }
    

    

    
}
