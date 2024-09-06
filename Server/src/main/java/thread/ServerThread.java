package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
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
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Predstavlja radnu nit servera koja obrađuje dolazne zahteve od klijenata.
 * Svaka instanca ove klase upravlja jednom povezanošću sa klijentom, prima zahteve,
 * obrađuje ih putem kontrolera, i šalje odgovore nazad klijentu.
 * 
 * @author Radin
 */
public class ServerThread extends Thread{
	/**
     * Socket koji predstavlja vezu između servera i klijenta.
     */
    Socket socket;
    /**
     * Sender za slanje odgovora klijentu.
     */
    Sender sender;
    /**
     * Receiver za primanje zahteva od klijenta.
     */
    Receiver receiver;

    /**
     * Konstruktor koji inicijalizuje novu radnu nit sa datim socket-om.
     * Inicijalizuje i Sender i Receiver za komunikaciju sa klijentom.
     * 
     * @param socket Socket koji predstavlja vezu između servera i klijenta.
     */
    public ServerThread(Socket socket) {
        this.socket = socket;        
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    /**
     * Pokreće radnu nit koja kontinuirano prima zahteve od klijenta, obrađuje ih
     * koristeći Controller i šalje rezultate nazad klijentu.
     * Zahtevi su obrađeni na osnovu operacije navedene u Request objektu.
     * U slučaju greške, odgovori se šalju sa detaljima greške.
     */
    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            response.setResult(Controller.getInstance().login((User) request.getArgument()));
                            break;
                        case ADD_TEAM:
                            Controller.getInstance().addTeam((Team) request.getArgument());
                            break;
                        case GET_PLAYERS:
                            response.setResult(Controller.getInstance().getPlayers((Player) request.getArgument()));
                            break;
                        case GET_TEAMS:
                            response.setResult(Controller.getInstance().getTeams((Team) request.getArgument()));
                            break;
                        case EDIT_TEAM:
                            Controller.getInstance().editTeam((Team) request.getArgument());
                            break;
                        case ADD_GAME:
                            Controller.getInstance().addGame((Game) request.getArgument());
                            break;    
                        case GET_GAMES:
                            response.setResult(Controller.getInstance().getGames((Game) request.getArgument()));
                            break;    
                        case ADD_PLAYED_GAME:
                            Controller.getInstance().addPlayedGame((PlayedGame) request.getArgument());
                            break;
                        case GET_ALL_GAMES:
                            response.setResult(Controller.getInstance().getAllGames((Game) request.getArgument()));
                            break;   
                        case GET_ALL_TEAMS:
                            response.setResult(Controller.getInstance().getAllTeams((Team) request.getArgument()));
                            break;  
                        case GET_ALL_PLAYED_GAMES:
                            response.setResult(Controller.getInstance().getAllPlayedGames((PlayedGame) request.getArgument()));
                            break;
                        case GET_ALL_REFEREES:
                            response.setResult(Controller.getInstance().getAllReferees((Referee) request.getArgument()));
                            break;    
                        case ADD_LIST_OF_REFEREES:
                            Controller.getInstance().addListOfReferees((ListOfReferees) request.getArgument());
                            break;
                        case GET_LIST_OF_REFEREES:
                            response.setResult(Controller.getInstance().getListOfReferees((ListOfReferees) request.getArgument()));
                            break;
                        case GET_ALL_PLAYERS:
                            response.setResult(Controller.getInstance().getAllPlayers((Player) request.getArgument()));
                            break;
                        case ADD_COACH:
                            Controller.getInstance().addCoach((Coach) request.getArgument());
                            break;
                        case GET_COACHES:
                            response.setResult(Controller.getInstance().getCoaches((Coach) request.getArgument()));
                            break;
                        case EDIT_COACH:
                            Controller.getInstance().editCoach((Coach) request.getArgument());
                            break;
                        case ADD_PLAYER_STATISTIC:
                            Controller.getInstance().addPlayerStats((PlayerStatistic) request.getArgument());
                            break;
                        case GET_PLAYER_STATISTICS:
                            response.setResult(Controller.getInstance().getPlayerStats((PlayerStatistic) request.getArgument()));
                            break; 
                        case EDIT_PLAYER_STATS:
                            Controller.getInstance().editPlayerStats((PlayerStatistic) request.getArgument());
                            break;   
                        case GET_ALL_TEAM_STATS:
                            response.setResult(Controller.getInstance().getAllTeamStats((TeamStatistic) request.getArgument()));
                            break;
                        case GET_ALL_LEAGUES:
                            response.setResult(Controller.getInstance().getAllLeagues((League) request.getArgument()));
                            break;
                        case ADD_TEAM_STAT:
                            Controller.getInstance().addTeamStat((TeamStatistic) request.getArgument());
                            break;
                        case EDIT_TEAM_STAT:
                            Controller.getInstance().editTeamStat((TeamStatistic) request.getArgument());
                            break;    
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (IOException ex) {
                interrupt();
            } catch (Exception ex) {
                ex.printStackTrace();
                interrupt();
            }
        }
    }
    
    /**
     * Zatvara Receiver koji je korišćen za prijem podataka sa klijenta.
     * 
     * @throws IOException Ako dođe do greške prilikom zatvaranja Receiver objekta.
     */
    public void close() throws IOException{
        receiver.close();
    }
    
}
