package domain;

import java.time.LocalDate;
import java.util.Objects;
import player.state.PlayerPosition;
import player.state.PlayerState;

/**
 *
 * @author Radin
 */
public class Player implements GenericEntity{
    
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String position;
    private double height;
    private double weight;
    private Team team;
    private PlayerState state;

    public Player(Long id, String firstname, String lastname, LocalDate birthday, String position, double height, double weight, Team team, PlayerState state) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.state = state;
    }

    

    public Player() {
    }

    public Player(Long id, String firstname, String lastname, LocalDate birthday, String position, double height, double weight, PlayerState state) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.state = state;
    }
  

    public void loadPlayer(){
        state = PlayerState.UNCHANGED;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.firstname);
        hash = 83 * hash + Objects.hashCode(this.lastname);
        hash = 83 * hash + Objects.hashCode(this.birthday);
        hash = 83 * hash + Objects.hashCode(this.position);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }

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
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return Objects.equals(this.birthday, other.birthday);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " - " + position;
    }

    @Override
    public String getTableName() {
        return "player";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, birthday, position, height, weight, team_id";
    } 

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "birthday", "position", "height", "weight", "team_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + "'" + birthday + "'" + ", " + "'" + position + "'" + ", " + height + ", " + weight + ", " + team.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getDate", "getString", "getDouble", "getDouble","getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birthday);
        return "firstname = '" + firstname + "', " + "lastname = '" + lastname + "', " + "birthday = '" + sqlDate + "', " + "position = '" + position + "', " + "height = " + height + ", " + "weight = " + weight + ", " + "team_id = " + team.getId();
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
