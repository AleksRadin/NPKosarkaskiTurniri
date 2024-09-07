package operation.listOfReferees;

import abst.operation.GenericOperation;
import domain.ListOfReferees;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da preuzme sve liste sudija iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dobijanja svih lista sudija iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllListOfReferees extends GenericOperation{

	/** Lista svih preuzetih lista sudija. */
    List<ListOfReferees> list;
    
    @Override
    protected void preconditions(Object param) throws Exception {    
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((ListOfReferees) param);
    }

    /**
     * Vraća listu svih preuzetih lista sudija.
     * 
     * @return Lista svih preuzetih lista sudija.
     */
    public List<ListOfReferees> getList() {
        return list;
    }
    
    
}