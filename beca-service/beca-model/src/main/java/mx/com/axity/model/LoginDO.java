package mx.com.axity.model;

import javax.persistence.*;

@Entity
@Table(name = "login", schema = "public")
public class LoginDO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loginSeq")
    @SequenceGenerator(name = "loginSeq", sequenceName = "login_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "ds_user")
    private String user;
    @Column(name = "ds_password")
    private String password;


    protected LoginDO() {
    }

    public LoginDO(Long id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
