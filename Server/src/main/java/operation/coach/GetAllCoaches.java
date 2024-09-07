package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da preuzme sve trenere iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju preuzimanja svih trenera iz baze podataka.
 * Rezultati operacije se čuvaju u privatnom polju coaches koje se može dohvatiti putem getter metode.
 * 
 * @author Radin
 */
public class GetAllCoaches extends GenericOperation{
	/** Lista trenera dobijena iz baze podataka. */
    private List<Coach> coaches;

    @Override
    protected void preconditions(Object param) throws Exception {
        // Implement any preconditions for getting all coaches if needed
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        coaches = repository.getAll((Coach) param);
    }

    /**
     * Vraća listu svih trenera dobijenih iz baze podataka.
     * 
     * @return Lista trenera tipa Coach.
     */
    public List<Coach> getCoaches() {
        return coaches;
    }
}