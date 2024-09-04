package player.state;

/**
 *
 * @author Radin
 */
public enum PlayerPosition {
    POINTGUARD("Point Guard"),
    SHOOTINGGUARD("Shooting Guard"),
    SMALLFORWARD("Small Forward"),
    POWERFORWARD("Power Forward"),
    CENTER("Center");

    private final String displayName;

    PlayerPosition(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}