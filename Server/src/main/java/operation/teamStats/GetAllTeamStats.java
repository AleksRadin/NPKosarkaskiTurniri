package operation.teamStats;

import abst.operation.GenericOperation;
import domain.TeamStatistic;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dohvati sve statistike timova iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za dobijanje svih objekata TeamStatistic iz baze podataka.
 * Metoda executeOperation koristi repository za dobijanje svih objekata TeamStatistic i čuva ih u privatnom atributu teamStats.
 * 
 * @author Radin
 */
public class GetAllTeamStats extends GenericOperation {
	/**
     * Lista koja čuva dobijene statistike timova.
     */
    List<TeamStatistic> teamStats;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teamStats = repository.getAll((TeamStatistic) param);
    }
    
    /**
     * Vraća listu svih statistika timova dobijenih iz baze podataka.
     * 
     * @return Lista objekata tipa TeamStatistic koja sadrži sve statistike timova.
     */
    public List<TeamStatistic> getTeamStats() {
        return teamStats;
    }  
}
