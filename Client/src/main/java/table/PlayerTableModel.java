package table;

import domain.Player;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import player.state.PlayerState;

/**
 *
 * @author Radin
 */
public class PlayerTableModel extends AbstractTableModel{
    private final Team team;
    private final String[] columnNames = new String[]{"ID", "First Name", "Last Name", "Birthday", "Position", "Height", "Weight"};
    private final List<Player> deletedPlayers = new ArrayList<>();

    public PlayerTableModel() {
        this.team = new Team();
    }

    
    @Override
    public int getRowCount() {
        return team.getPlayers().size();
        
//         return (int) team.getPlayers().stream()
//                     .filter(p -> p.getState() != PlayerState.DELETED)
//                     .count();
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
       Player player = team.getPlayers().get(rowIndex);
//        Player player = team.getPlayers().stream()
//                        .filter(p -> p.getState() != PlayerState.DELETED)
//                        .skip(rowIndex)
//                        .findFirst()
//                        .orElse(null);
//        
//        if (player == null) {
//            return null;  
//        }
        
        switch (columnIndex) {
            case 0:
                return player.getId();
            case 1:
                return player.getFirstname();
            case 2:
                return player.getLastname();
            case 3:
                return player.getBirthday();
            case 4:
                return player.getPosition();
            case 5:
                return player.getHeight();
            case 6:
                return player.getWeight();
            default:
                return null;
        }
    }
    
    public void addPlayer(Player player){
        player.setTeam(team);
        
        Long newId = team.getPlayers().stream()
                     .mapToLong(Player::getId)
                     .max()
                     .orElse(0) + 1;
        player.setId(newId);
        
        //player.setId(Long.valueOf(team.getPlayers().size() + 1));
        
        player.setState(PlayerState.ADDED);
        
        team.getPlayers().add(player);
        int rowIndex = team.getPlayers().size() - 1;
        fireTableRowsInserted(rowIndex, rowIndex);
    }
    
    public void loadPlayer(Player player) {
        player.setTeam(team);
        team.getPlayers().add(player);
        fireTableRowsInserted(team.getPlayers().size() - 1, team.getPlayers().size() - 1);
    }
    
    public void removePlayer(int rowIndex){
        team.getPlayers().remove(rowIndex);
        resort();
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void updatedPlayer(Player player){
        int rowIndex = -1;
        for (int i = 0; i < team.getPlayers().size(); i++) {
            if (team.getPlayers().get(i).getId().equals(player.getId())) {
                rowIndex = i;
                player.setState(PlayerState.EDITED);
                team.getPlayers().set(i, player);
                break;
            }
        }

        if (rowIndex != -1) {
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }
    

    private void resort() {
        int number = 0;
        for (Player player : team.getPlayers()) {
            player.setId(Long.valueOf(++number));
        }
    }
    
    public Team getTeam(){
        for (Player deletedPlayer : deletedPlayers) {
            team.getPlayers().add(deletedPlayer);
        }
        return team;
    }

    public void deletePlayer(Player player) {
        for (int i = 0; i < team.getPlayers().size(); i++) {
            Player currentPlayer = team.getPlayers().get(i);

            if (currentPlayer.getId().equals(player.getId())) {
                if (currentPlayer.getState() == PlayerState.EDITED || currentPlayer.getState() == PlayerState.UNCHANGED) {
                    currentPlayer.setState(PlayerState.DELETED);
                    deletedPlayers.add(player);
                } 
                team.getPlayers().remove(i);
                fireTableRowsDeleted(i, i);
                return;  
            }
        }
    }
    
    public Player getPlayerAt(int rowIndex) {
        return team.getPlayers().stream()
                   .filter(p -> p.getState() != PlayerState.DELETED)
                   .skip(rowIndex)
                   .findFirst()
                   .orElse(null);
    }
    
    
    
    
    
}
