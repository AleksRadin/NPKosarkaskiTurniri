package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Radin
 */
public class Team implements GenericEntity{
    
    private Long id;
    private String name;
    private String city;
    private String country;
    private int foundedIn;
    
    List<Player> players = new ArrayList<>();

    public Team(Long id, String name, String city, String country, int foundedIn) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.foundedIn = foundedIn;
        this.players = new ArrayList<>();
    }

    public Team() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        if (players == null) {
            throw new NullPointerException("Players list cannot be null.");
        }
        this.players = players;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
        this.city = city;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty.");
        }
        this.country = country;
    }

    public int getFoundedIn() {
        return foundedIn;
    }

    public void setFoundedIn(int foundedIn) {
        if (foundedIn <= 0) {
            throw new IllegalArgumentException("Founded year must be a positive number.");
        }
        this.foundedIn = foundedIn;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Team other = (Team) obj;
        return Objects.equals(this.id, other.id);
    }
    
    

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
//        hash = 83 * hash + Objects.hashCode(this.name);
//        hash = 83 * hash + Objects.hashCode(this.city);
//        hash = 83 * hash + Objects.hashCode(this.country);
//        hash = 83 * hash + this.foundedIn;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Team other = (Team) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (this.foundedIn != other.foundedIn) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.city, other.city)) {
//            return false;
//        }
//        return Objects.equals(this.country, other.country);
//    }

        
    
    @Override
    public String toString() {
        return name + " " + city + " " + country;
    }

    @Override
    public String getTableName() {
        return "team";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, city, country, foundedIn";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id","name", "city", "country", "foundedIn"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "'" + ", " + "'" + city + "'" + ", " + "'" + country + "'" + ", " +  foundedIn ;
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getString", "getInt"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', " + "city = '" + city + "', " + "country = '" + country + "', " + "foundedIn = " + foundedIn;
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
