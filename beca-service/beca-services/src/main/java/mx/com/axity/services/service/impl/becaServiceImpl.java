package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    LoginDAO loginDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int sum(int sum1, int sum2) {
        return sum1 + sum2;
    }

    @Override
    public int substraction(int substraction1, int substraction2) {
        return substraction1 - substraction2;
    }

    @Override
    public int multiplication(int multiplication1) {
        return multiplication1 * 4;
    }

    @Override
    public int division(int division1) {
        return division1 / 4;
    }

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) this.userDAO.findAll();
    }

    @Override
    public void createUser(UserDO userDO) {
        this.userDAO.save(userDO);
    }

    @Override
    public void updateUser(UserDO userDO) {
        //this.userDAO.findById(userDO.getId());
        this.userDAO.save(userDO);
    }

    @Override
    public UserDO readUser(int id) {
        return (UserDO) this.userDAO.findById((long) id).get();
    }

    @Override
    public void deleteUser(int id) {
        this.userDAO.deleteById((long) id);
    }

    @Override
    public List<LoginDO> getAllLogins() {
        return (List<LoginDO>) this.loginDAO.findAll();
    }

    @Override
    public void createLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public void updateLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public LoginDO readLogin(int id) {
        return (LoginDO) this.loginDAO.findById((long) id).get();
    }

    @Override
    public void deleteLogin(int id) {
        this.loginDAO.deleteById((long) id);
    }

    @Override
    public UserDO makeLogin(LoginDO loginDO) {
        LoginDO login = this.loginDAO.findByUserAndPassword(loginDO.getUser(), loginDO.getPassword()).get();

        UserDO userDO = this.userDAO.findById(login.getId()).get();

        return userDO;
    }

}
