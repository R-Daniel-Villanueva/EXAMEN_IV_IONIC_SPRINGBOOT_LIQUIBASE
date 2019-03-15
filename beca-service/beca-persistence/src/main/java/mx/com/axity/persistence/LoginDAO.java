package mx.com.axity.persistence;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface LoginDAO extends CrudRepository<LoginDO, Long> {
    Optional<LoginDO> findByUserAndPassword(String user, String password);

    /*
    @Query("SELECT u FROM UserDO u WHERE u.name = ?1 and u.lasName = ?2")
    UserDO ValidateUserAndPwd(String user, String pwd);
    */
}
