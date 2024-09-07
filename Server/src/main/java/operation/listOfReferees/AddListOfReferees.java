package operation.listOfReferees;

import java.util.List;

import abst.operation.GenericOperation;
import controller.Controller;
import domain.GenericEntity;
import domain.ListOfReferees;
import repository.db.impl.RepositoryDBGeneric;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da sačuva listu sudija u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dodavanja liste sudija u bazu podataka.
 * 
 * @author Radin
 */
public class AddListOfReferees extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((ListOfReferees)param);
    }
    
}