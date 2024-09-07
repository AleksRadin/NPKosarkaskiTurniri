package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da doda novog trenera u bazu podataka.
 * 
 * Ova klasa nasleđuje GenericOperationi implementira operaciju dodavanja trenera u bazu podataka.
 * 
 * @author Radin
 */
public class AddCoach extends GenericOperation{
	
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Coach) param);
    }
    
}