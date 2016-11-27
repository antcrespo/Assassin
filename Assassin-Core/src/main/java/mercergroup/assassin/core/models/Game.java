package mercergroup.assassin.core.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;


/**
 * Object for the game state
 */
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") private Long gameId;

    @Column(name = "start_date") private long startDate;
    @Column(name = "end_date") private long endDate;
    private long staleTime;
    @Column(name = "win_limit") private int winLimit;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Player admin;

    @OneToMany(fetch= FetchType.EAGER, mappedBy="game", cascade = {CascadeType.ALL}, orphanRemoval=true)
    private Collection<Player> players;


    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getStaleTime() {
        return staleTime;
    }

    public void setStaleTime(long staleTime) {
        this.staleTime = staleTime;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public int getWinLimit() {
        return winLimit;
    }

    public void setWinLimit(int winLimit) {
        this.winLimit = winLimit;
    }

    public Player getAdmin() {
        return admin;
    }

    public void setAdmin(Player admin) {
        this.admin = admin;
    }
}
