package repository.db.impl;

import domain.GenericEntity;
import domain.ListOfReferees;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.db.DbConnection;
import repository.db.DbRepository;

/**
 * Implementacija generičkog repositorijuma za rad sa entitetima u bazi podataka.
 * Ova klasa koristi refleksiju za dinamičko mapiranje rezultata upita na entitete,
 * kao i za izvršavanje operacija dodavanja, izmene i brisanja podataka u bazi.
 * 
 * Implementira interfejs DbRepository pri cemu postavlja tip na GenericEntity
 * @author Radin
 */
public class RepositoryDBGeneric implements DbRepository<GenericEntity>{

	
	@Override
	public List<GenericEntity> getAll(GenericEntity param) throws Exception {
	    List<GenericEntity> entities = new ArrayList<>();
	
	    Connection connection = DbConnection.getInstance().getConnection();
	    String query = "SELECT * FROM " + param.getTableName();
	    Statement statement = connection.createStatement();
	    ResultSet rs = statement.executeQuery(query);
	
	    Method getColumnNamesForSelect = param.getClass().getMethod("getColumnNamesForSelect");
	    String[] columnNames = (String[]) getColumnNamesForSelect.invoke(param);
	    Field[] fields = param.getClass().getDeclaredFields();
	
	    
	    
	    while (rs.next()) {
	        GenericEntity entity = param.getClass().newInstance();
	        for (int i = 0; i < columnNames.length; i++) {
	            String fieldName = fields[i].getName();
	            Method setterMethod = param.getClass().getMethod(
	                "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
	                fields[i].getType()
	            );
	
	            Object value = rs.getClass().getMethod(param.getResultSetMethods()[i], String.class).invoke(rs, columnNames[i]);
	            if (columnNames[i].endsWith("_id")) {
	                Object helperEntity = fields[i].getType().newInstance();
	                Method setIdMethod = helperEntity.getClass().getMethod("setId", Long.class);
	                setIdMethod.invoke(helperEntity, value);
	                setterMethod.invoke(entity, helperEntity);
	            } else {
	                Class<?> fieldType = fields[i].getType();
	                if (fieldType == Date.class) {
	                    setterMethod.invoke(entity, new Date(((java.sql.Date) value).getTime()));
	                } else if (fieldType == LocalTime.class) {
	                    setterMethod.invoke(entity, ((java.sql.Time) value).toLocalTime());
	                } else if (fieldType == LocalDate.class) {
	                    if (value instanceof java.sql.Date) {
	                        setterMethod.invoke(entity, ((java.sql.Date) value).toLocalDate());
	                    } else if (value instanceof java.sql.Timestamp) {
	                        setterMethod.invoke(entity, ((java.sql.Timestamp) value).toLocalDateTime().toLocalDate());
	                    }
	                } else {
	                    setterMethod.invoke(entity, value);
	                }
	            }
	        }
	    entities.add(entity);
    }
    rs.close();
    statement.close();

    return entities;
}

    @Override
    public void add(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String query = "INSERT INTO " + param.getTableName() + " (" + param.getColumnNamesForInsert() + ") VALUES (" + param.getInsertValues() + ")";
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                param.setId(id);
            }
            
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String query = "UPDATE " + param.getTableName() + " SET " + param.getUpdateValues() + " WHERE " + param.getWhereConditionEditOperation();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
       try {
            Connection connection = DbConnection.getInstance().getConnection();
            String query = "DELETE FROM " + param.getTableName() + " WHERE " + param.getWhereCondition();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
