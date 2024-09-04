package table;

import domain.League;
import domain.Team;
import domain.PlayedGame;
import domain.TeamStatistic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class TeamTableModel extends AbstractTableModel {
    
    private List<TeamStatistic> teamStatistics;
    private final String[] columnNames = {"Rank", "Team Name", "Points", "Games Played", "Games Won", "Games Lost", "Draws"};

    public TeamTableModel(List<TeamStatistic> teamStatistics) {
        this.teamStatistics = teamStatistics;
    }

    public void setTeamStatistics(List<TeamStatistic> teamStatistics) {
        this.teamStatistics = teamStatistics;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (teamStatistics.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The table is empty, no data available.");
        }
        return teamStatistics.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TeamStatistic stat = teamStatistics.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stat.getRank(); 
            case 1:
                return stat.getTeam().getName(); 
            case 2:
                return stat.getPoints(); 
            case 3:
                return stat.getPlayedGames(); 
            case 4:
                return stat.getWonGames(); 
            case 5:
                return stat.getLostGames(); 
            case 6:
                return stat.getDrawnGames(); 
            default:
                return null;
        }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
    
    
    public void updateStatistics(List<Team> teams, List<PlayedGame> playedGames, League league) {
        Map<Long, TeamStatistic> teamStatisticMap = new HashMap<>();
        
        
        for (Team team : teams) {
            TeamStatistic teamStatistic = new TeamStatistic();
            teamStatistic.setTeam(team);
            teamStatistic.setLeague(league);
            teamStatistic.setPlayedGames(0);
            teamStatistic.setWonGames(0);
            teamStatistic.setLostGames(0);
            teamStatistic.setDrawnGames(0);
            teamStatistic.setPoints(0);
            teamStatistic.setRank(0); 
            
            teamStatisticMap.put(team.getId(), teamStatistic);
        }
        
        
        for (PlayedGame playedGame : playedGames) {
            if (playedGame.getGame().getLeague().getId().equals(league.getId())) {
                Team homeTeam = playedGame.getHomeTeam();
                Team awayTeam = playedGame.getAwayTeam();
                
                TeamStatistic homeStat = teamStatisticMap.get(homeTeam.getId());
                TeamStatistic awayStat = teamStatisticMap.get(awayTeam.getId());
                
                homeStat.setPlayedGames(homeStat.getPlayedGames() + 1);
                awayStat.setPlayedGames(awayStat.getPlayedGames() + 1);
                
                if (playedGame.getHomeTeamPoints() > playedGame.getAwayTeamPoints()) {
                    homeStat.setWonGames(homeStat.getWonGames() + 1);
                    awayStat.setLostGames(awayStat.getLostGames() + 1);
                    homeStat.setPoints(homeStat.getPoints() + 3);
                } else if (playedGame.getHomeTeamPoints() < playedGame.getAwayTeamPoints()) {
                    homeStat.setLostGames(homeStat.getLostGames() + 1);
                    awayStat.setWonGames(awayStat.getWonGames() + 1);
                    awayStat.setPoints(awayStat.getPoints() + 3);
                } else {
                    homeStat.setDrawnGames(homeStat.getDrawnGames() + 1);
                    awayStat.setDrawnGames(awayStat.getDrawnGames() + 1);
                    homeStat.setPoints(homeStat.getPoints() + 1);
                    awayStat.setPoints(awayStat.getPoints() + 1);
                }
            }
        }
        
        
        teamStatistics = new ArrayList<>(teamStatisticMap.values());
        
        teamStatistics.sort((ts1, ts2) -> Integer.compare(ts2.getPoints(), ts1.getPoints()));
    
        int rank = 1;
        for (TeamStatistic stat : teamStatistics) {
            stat.setRank(rank++);
        }
        
        fireTableDataChanged();
    }

    public List<TeamStatistic> getTeamStatistics() {
        return teamStatistics;  
    }
    
    
    
}
