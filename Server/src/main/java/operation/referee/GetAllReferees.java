package operation.referee;

import abst.operation.GenericOperation;
import domain.Referee;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da preuzme sve sudije iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za preuzimanje svih sudija iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllReferees extends GenericOperation{
	/** Lista koja sadrži sve sudije preuzete iz baze podataka. */
    List<Referee> referees;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        referees = repository.getAll((Referee) param);
    }
    
    /**
     * Vraća listu svih sudija preuzetih iz baze podataka.
     * 
     * @return Lista sudija.
     */
    public List<Referee> getReferees() {
        return referees;
    }
}
