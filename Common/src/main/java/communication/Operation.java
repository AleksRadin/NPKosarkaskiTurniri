package communication;

/**
 * Predstavlja enumeraciju koja opisuje sve moguće operacije u okviru aplikacije.
 * 
 * @author Radin
 */
public enum Operation {

    /**
     * Prijavljuje korisnika na sistem.
     */
    LOGIN,

    /**
     * Dodaje jednog igrača kao novi red u odgovarajućoj tabeli u okviru baze podataka.
     */
    ADD_PLAYER,

    /**
     * Dodaje jedan tim kao novi red u odgovarajućoj tabeli u okviru baze podataka.
     */
    ADD_TEAM,

    /**
     * Izlistava sve igrače iz baze podataka.
     */
    GET_PLAYERS,

    /**
     * Menja određeni red iz tabele namenjene igračima u okviru baze podataka.
     */
    EDIT_PLAYER,

    /**
     * Menja određeni red iz tabele namenjene timovima u okviru baze podataka.
     */
    EDIT_TEAM,

    /**
     * Izlistava sve timove iz baze podataka.
     */
    GET_TEAMS,

    /**
     * Cuva jednu utakmicu kao novi red u odgovarajućoj tabeli u okviru baze podataka.
     */
    ADD_GAME,

    /**
     * Izlistava sve utakmice iz baze podataka.
     */
    GET_GAMES,

    /**
     * Cuva podatak o odigranoj utakmici kao novi red u bazi podataka.
     */
    ADD_PLAYED_GAME,

    /**
     * Izlistava sve utakmice koje su odigrane, iz baze podataka.
     */
    GET_ALL_GAMES,

    /**
     * Izlistava sve timove iz baze podataka.
     */
    GET_ALL_TEAMS,

    /**
     * Izlistava sve odigrane utakmice iz baze podataka.
     */
    GET_ALL_PLAYED_GAMES,

    /**
     * Izlistava sve sudije iz baze podataka.
     */
    GET_ALL_REFEREES,

    /**
     * Dodaje listu sudija u bazu podataka.
     */
    ADD_LIST_OF_REFEREES,

    /**
     * Dohvata listu sudija iz baze podataka.
     */
    GET_LIST_OF_REFEREES,

    /**
     * Izlistava sve igrače iz baze podataka.
     */
    GET_ALL_PLAYERS,

    /**
     * Cuva jednog trenera kao novi red u odgovarajućoj tabeli u okviru baze podataka.
     */
    ADD_COACH,

    /**
     * Izlistava sve trenere iz baze podataka.
     */
    GET_COACHES,

    /**
     * Menja određeni red iz tabele namenjene trenerima u okviru baze podataka.
     */
    EDIT_COACH,

    /**
     * Cuva jednu statistiku igrača kao novi red u bazi podataka.
     */
    ADD_PLAYER_STATISTIC,

    /**
     * Izlistava sve statistike igrača iz baze podataka.
     */
    GET_PLAYER_STATISTICS,

    /**
     * Menja određeni red iz tabele namenjene statistikama igrača u okviru baze podataka.
     */
    EDIT_PLAYER_STATS,

    /**
     * Izlistava sve statistike timova iz baze podataka.
     */
    GET_ALL_TEAM_STATS,

    /**
     * Izlistava sve lige iz baze podataka.
     */
    GET_ALL_LEAGUES,

    /**
     * Menja određeni red iz tabele namenjene statistikama timova u okviru baze podataka.
     */
    EDIT_TEAM_STAT,

    /**
     * Cuva jednu statistiku tima kao novi red u bazi podataka.
     */
    ADD_TEAM_STAT;
}
