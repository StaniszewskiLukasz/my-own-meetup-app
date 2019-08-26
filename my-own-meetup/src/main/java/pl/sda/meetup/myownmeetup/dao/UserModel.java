package pl.sda.meetup.myownmeetup.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity znaczy że id tworzone jest w momencie dodawania do bazy
    //auto znaczy że hibernate ustawia id, SEQUENCE oznacza że pobiera id z bazy danych jakie ma wstawić w pole,
    // pobiera cały pakiet by nie pytać o id za każdym razem
    private Long id;
    @Column(unique = true)
    private String name;
    private String email;
    private String password;

    @ManyToMany
    private Set<RoleModel> roleModelSet;
}
