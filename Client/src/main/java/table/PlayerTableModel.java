package table;

import domain.Player;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import player.state.PlayerState;

/**
 * Model tabele za prikaz i upravljanje podacima o igračima u JTable komponenti.
 * Ovaj model povezan je sa klasom Team i omogućava CRUD operacije 
 * (kreiranje, čitanje, ažuriranje, brisanje) za objekte klase Player.
 * 
 * Model tabele podržava operacije kao što su dodavanje, ažuriranje i uklanjanje igrača,
 * uz osiguravanje jedinstvenih ID-ova za igrače i praćenje stanja svakog igrača.
 * @author Radin
 */
public class PlayerTableModel extends AbstractTableModel{
	/**
     * Tim koji sadrži igrače koji se prikazuju u tabeli.
     */
    private final Team team;
    /**
     * Nazivi kolona koji se prikazuju u JTable komponenti.
     */
    private final String[] columnNames = new String[]{"ID", "First Name", "Last Name", "Birthday", "Position", "Height", "Weight"};
    /**
     * Lista igrača koji su obrisani, ali još uvek nisu potvrđeni kao trajno izbrisani.
     */
    private final List<Player> deletedPlayers = new ArrayList<>();

    /**
     * Konstruktor koji kreira prazan tim i inicijalizuje model tabele.
     */
    public PlayerTableModel() {
        this.team = new Team();
    }

    /**
     * Vraća broj redova u tabeli, odnosno broj igrača u timu.
     * 
     * @return broj redova u tabeli
     */
    @Override
    public int getRowCount() {
        return team.getPlayers().size();
        
    }

    /**
     * Vraća broj kolona u tabeli.
     * 
     * @return broj kolona u tabeli
     */
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    /**
     * Vraća ime kolone na osnovu njenog indeksa.
     * 
     * @param column indeks kolone
     * @return ime kolone
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Vraća vrednost za određeni red i kolonu u tabeli.
     * 
     * @param rowIndex indeks reda
     * @param columnIndex indeks kolone
     * @return vrednost ćelije na datoj poziciji
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Player player = team.getPlayers().get(rowIndex);
        
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
    
    /**
     * Dodaje novog igrača u tim i tabelu. Dodeljuje jedinstveni ID igraču.
     * 
     * @param player novi igrač koji se dodaje
     */
    public void addPlayer(Player player){
        player.setTeam(team);
        
        Long newId = team.getPlayers().stream()
                     .mapToLong(Player::getId)
                     .max()
                     .orElse(0) + 1;
        player.setId(newId);
        
        
        player.setState(PlayerState.ADDED);
        
        team.getPlayers().add(player);
        int rowIndex = team.getPlayers().size() - 1;
        fireTableRowsInserted(rowIndex, rowIndex);
    }
    
    /**
     * Učitava postojećeg igrača u tim i tabelu bez dodeljivanja novog ID-a.
     * 
     * @param player igrač koji se učitava
     */
    public void loadPlayer(Player player) {
        player.setTeam(team);
        team.getPlayers().add(player);
        fireTableRowsInserted(team.getPlayers().size() - 1, team.getPlayers().size() - 1);
    }
    
    /**
     * Uklanja igrača iz tima i tabele na osnovu rednog indeksa.
     * 
     * @param rowIndex indeks reda u tabeli koji treba ukloniti
     */
    public void removePlayer(int rowIndex){
        team.getPlayers().remove(rowIndex);
        resort();
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    /**
     * Ažurira podatke o igraču na osnovu njegovog ID-a i osvežava prikaz u tabeli.
     * 
     * @param player igrač sa ažuriranim podacima
     */
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
    

    /**
     * Ponavlja dodeljivanje ID-ova svim igračima u timu, počevši od 1.
     */
    private void resort() {
        int number = 0;
        for (Player player : team.getPlayers()) {
            player.setId(Long.valueOf(++number));
        }
    }
    
    /**
     * Vraća tim sa svim igračima, uključujući i one koji su obrisani.
     * 
     * @return tim sa svim igračima
     */
    public Team getTeam(){
        for (Player deletedPlayer : deletedPlayers) {
            team.getPlayers().add(deletedPlayer);
        }
        return team;
    }

    /**
     * Obeležava igrača kao obrisanog i uklanja ga iz prikaza u tabeli.
     * 
     * @param player igrač koji se briše
     */
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
    
    /**
     * Vraća igrača na osnovu rednog indeksa, ignorišući igrače koji su obrisani.
     * 
     * @param rowIndex indeks reda u tabeli
     * @return igrač na datoj poziciji, ili null ako ne postoji
     */
    public Player getPlayerAt(int rowIndex) {
        return team.getPlayers().stream()
                   .filter(p -> p.getState() != PlayerState.DELETED)
                   .skip(rowIndex)
                   .findFirst()
                   .orElse(null);
    }
    
    
    
    
    
}
