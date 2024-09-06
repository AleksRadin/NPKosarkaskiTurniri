package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da izmeni informacije o trenera u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju izmene podataka o treneru u bazi podataka.
 * 
 * @author Radin
 */
public class EditCoach extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Coach) param);
    }
}
