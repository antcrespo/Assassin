package mercergroup.assassin.core.models;

import javax.persistence.*;

/**
 * Created by Darargon on 11/26/16.
 */
@Entity
@Table(name = "kills")
public class Kill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long killId;

    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @JoinColumn(name = "killer_id", referencedColumnName = "id")
    private Player killer;

    @JoinColumn(name = "killed_id", referencedColumnName = "id")
    private Player killed;

    @Column(name = "time")
    private long time;

}
