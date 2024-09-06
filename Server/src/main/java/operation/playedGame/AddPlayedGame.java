package operation.playedGame;

import abst.operation.GenericOperation;
import domain.PlayedGame;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da sačuva podatke o odigranoj utakmici u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dodavanja nove odigrane utakmice u bazu podataka.
 * 
 * @author Radin
 */
public class AddPlayedGame extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((PlayedGame) param);
    }
    
}