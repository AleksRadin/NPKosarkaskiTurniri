package player.state;

/**
 * Enum koji predstavlja različite pozicije igrača u košarkaškoj igri.
 * 
 * Svaka pozicija ima svoje ime koje se koristi za prikaz u korisničkom interfejsu ili za druge svrhe.
 * 
 * @author Radin
 */
public enum PlayerPosition {
	/**
     * Pozicija Point Guard.
     */
    POINTGUARD("Point Guard"),
    /**
     * Pozicija Shooting Guard.
     */	
    SHOOTINGGUARD("Shooting Guard"),
    /**
     * Pozicija Small Forward.
     */
    SMALLFORWARD("Small Forward"),
    /**
     * Pozicija Power Forward.
     */
    POWERFORWARD("Power Forward"),
    /**
     * Pozicija Center.
     */
    CENTER("Center");

	 /**
     * Ime pozicije koje se koristi za prikaz u korisničkom interfejsu.
     */
    private final String displayName;

    /**
     * Konstruktor koji postavlja ime pozicije.
     * 
     * @param displayName - Ime pozicije koje će biti korišćeno za prikaz.
     */
    PlayerPosition(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Vraća ime pozicije koje se koristi za prikaz.
     * 
     * @return displayName - Ime pozicije.
     */
    public String getDisplayName() {
        return displayName;
    }
}