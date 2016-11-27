package mercergroup.assassin.core.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Object to represent a User
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column private String name;
    private byte[] profilePicture;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="user", cascade = {CascadeType.ALL}, orphanRemoval=true)
    private Collection<Player> players;

}
