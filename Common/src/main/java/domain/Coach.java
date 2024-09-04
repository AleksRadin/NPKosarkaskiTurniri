package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class Coach implements GenericEntity{
    
    private Long id;
    private String firstname;
    private String lastname;
    private int numbOfChampionships;
    private Team team;

    public Coach(Long id, String firstname, String lastname, int numbOfChampionships, Team team) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numbOfChampionships = numbOfChampionships;
        this.team = team;
    }

    public Coach() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("ID cannot be null.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname == null || firstname.isEmpty()) {
            throw new NullPointerException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.isEmpty()) {
            throw new NullPointerException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname;
    }

    public int getNumbOfChampionships() {
        return numbOfChampionships;
    }

    public void setNumbOfChampionships(int numbOfChampionships) {
        if (numbOfChampionships < 0) {
            throw new IllegalArgumentException("Number of championships cannot be negative.");
        }
        this.numbOfChampionships = numbOfChampionships;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if (team == null) {
            throw new NullPointerException("Team cannot be null.");
        }
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + this.numbOfChampionships;
        hash = 97 * hash + Objects.hashCode(this.team);
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
        final Coach other = (Coach) obj;
        if (this.numbOfChampionships != other.numbOfChampionships) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.team, other.team);
    }

    @Override
    public String toString() {
        return firstname + " - " + lastname;
    }
    
    
        @Override
    public String getTableName() {
        return "coach";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, number_of_championships, team_id";
    } 

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "number_of_championships", "team_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + numbOfChampionships + ", " + team.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getInt", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "firstname = '" + firstname + "', " + "lastname = '" + lastname + "', " + "number_of_championships = " + numbOfChampionships + ", " + "team_id = " + team.getId();
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
