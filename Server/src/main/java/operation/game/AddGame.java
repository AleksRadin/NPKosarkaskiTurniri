package operation.game;

import abst.operation.GenericOperation;
import domain.Game;
import domain.GenericEntity;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da sačuva novu igru u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dodavanja nove igre u bazu podataka.
 * 
 * @author Radin
 */
public class AddGame extends GenericOperation{
	
	/**
     * Creates a new instance of {@link AddGame} using the default constructor.
     * This constructor initializes the repository through the superclass constructor.
     */
    public AddGame() {
        super();
    }
	
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         repository.add((Game) param);
    }
}