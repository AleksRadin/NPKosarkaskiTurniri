package player.state;

/**
 * Enum koji predstavlja različite statuse koje igrač može imati u sistemu.
 * 
 * Ovi statusi se koriste za označavanje različitih stanja igrača, kao što su dodati, obrisani, izmenjeni ili nepromenjeni.
 * 
 * @author Radin
 */
public enum PlayerState {
	/**
     * Status koji označava da je igrač dodat u sistem.
     */
    ADDED,
    /**
     * Status koji označava da je igrač obrisan iz sistema.
     */
    DELETED,
    /**
     * Status koji označava da je igrač izmenjen u sistemu.
     */
    EDITED,
    /**
     * Status koji označava da igrač nije promenjen u sistemu.
     */
    UNCHANGED
}
