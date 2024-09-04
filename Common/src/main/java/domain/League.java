package domain;

import java.util.Objects;

/**
 *
 * @author Radin
 */
public class League implements GenericEntity{
    private Long id;
    private String name;
    private String season;

    public League(Long id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
    }

    public League() {
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
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        if (season == null || season.isEmpty()) {
            throw new NullPointerException("Season cannot be null or empty.");
        }
        this.season = season;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.season);
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
        final League other = (League) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.season, other.season)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }
    
     @Override
    public String getTableName() {
        return "league";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, season";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "name", "season"};
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + season + "'";
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getString", "getString"};
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', season = '" + season + "'";
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
