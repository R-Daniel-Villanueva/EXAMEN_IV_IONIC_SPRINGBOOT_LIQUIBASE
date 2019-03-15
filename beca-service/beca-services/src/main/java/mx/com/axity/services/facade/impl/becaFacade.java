package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int operation(int a, int b) {

        int c = this.becaService.sum(a, b);
        b = this.becaService.substraction(c, a);
        int d =this.becaService.multiplication(b);
        return this.becaService.division(d);
    }

    @Override
    public List<UserTO> getAllUsers() {
        List<UserDO> userDOList = this.becaService.getAllUsers();

        Type userTOType = new TypeToken<List<UserTO>>() {}.getType();
        List<UserTO> result = this.modelMapper.map(userDOList, userTOType);

        return result;
    }

    @Override
    public void createUser(UserTO userTO) {
        Type userDOType = new TypeToken<UserDO>(){}.getType();
        UserDO userDO = this.modelMapper.map(userTO, userDOType);
        this.becaService.createUser(userDO);
    }

    public void updateUser(UserTO userTO) {
        this.becaService.readUser(userTO.getId());

        Type userDOType = new TypeToken<UserDO>(){}.getType();
        UserDO userDO = this.modelMapper.map(userTO, userDOType);
        this.becaService.updateUser(userDO);
    }

    @Override
    public UserTO readUser(int id) {
        UserDO userDO = this.becaService.readUser(id);
        Type userTOType = new TypeToken<UserTO>() {}.getType();
        UserTO result = this.modelMapper.map(userDO, userTOType);
        return result;
    }

    @Override
    public void deleteUser(int id) {
        this.becaService.deleteUser(id);
    }

    @Override
    public List<LoginTO> getAllLogins() {
        List<LoginDO> loginDOList = this.becaService.getAllLogins();

        Type loginTOType = new TypeToken<List<LoginTO>>() {}.getType();
        List<LoginTO> result = this.modelMapper.map(loginDOList, loginTOType);

        return result;
    }

    @Override
    public void createLogin(LoginTO loginTO) {
        Type loginDOType = new TypeToken<LoginDO>(){}.getType();
        LoginDO loginDO = this.modelMapper.map(loginTO, loginDOType);
        this.becaService.createLogin(loginDO);
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        Type loginDOType = new TypeToken<LoginDO>(){}.getType();
        LoginDO loginDO = this.modelMapper.map(loginTO, loginDOType);
        this.becaService.updateLogin(loginDO);
    }

    @Override
    public LoginTO readLogin(int id) {
        LoginDO loginDO = this.becaService.readLogin(id);
        Type loginTOType = new TypeToken<LoginTO>() {}.getType();
        LoginTO result = this.modelMapper.map(loginDO, loginTOType);
        return result;
    }

    @Override
    public void deleteLogin(int id) {
        this.becaService.deleteLogin(id);
    }

    @Override
    public UserTO makeLogin(LoginTO loginTO) {
        Type loginDOType = new TypeToken<LoginDO>(){}.getType();
        LoginDO loginDO = this.modelMapper.map(loginTO, loginDOType);

        UserDO userDO = this.becaService.makeLogin(loginDO);

        Type userTOType = new TypeToken<UserTO>(){}.getType();
        UserTO userTO = this.modelMapper.map(userDO, userTOType);

        return userTO;
    }
}
