package domain;

import java.io.Serializable;

/**
 *
 * @author Radin
 */
public interface GenericEntity extends Serializable{
    String getTableName();

    String getColumnNamesForInsert();
    
    String[] getColumnNamesForSelect();

    String getInsertValues();
    
    String[] getResultSetMethods();
    
    String getUpdateValues();
    
    String getWhereCondition();
    
    String getWhereConditionEditOperation();

    void setId(Long id);
}