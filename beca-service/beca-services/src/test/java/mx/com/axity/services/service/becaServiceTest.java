package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class becaServiceTest extends BaseTest {

    //static final Logger log = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    IbecaService ibecaService;

    @Test
    public void updateExisteRegistro(){
        //Exito -> Registro existe y se actualiza
        UserDO userDO = this.ibecaService.readUser(7);

        Assert.assertTrue( userDO!=null );
        Assert.assertTrue( new Long(7).equals(userDO.getId()));
        Assert.assertTrue("numero 7".equals(userDO.getName()));
    }

    @Test
    public void updateNoExisteRegistro(){

        try {
            UserDO userDO = this.ibecaService.readUser(777);
        }
        catch (Throwable e){
            Assert.assertTrue(e instanceof NoSuchElementException);
        }

    }

    /*
    @Test
    public void exampleTest() {

        List<UserTO> users = this.becaService.getUsers();

        Assert.assertEquals(1, users.size());
    }


    @Test
    public void shouldReturnTheSumOfTwoNumbers(){
        int num1 = 5;
        int num2 = 10;

        int result = this.becaService.sum(num1,num2);

        Assert.assertEquals(15, result);
    }

    @Test
    public void shouldReturnTheSubstractionOfTwoNumbers(){
        int num1 = 5;
        int num2 = 10;

        int result = this.becaService.substraction(num1,num2);

        Assert.assertEquals(-5, result);
    }

    @Test
    public void shouldReturnTheMultiplicationOfOneNumber(){
        int num1 = 5;

        int result = this.becaService.multiplication(num1);

        Assert.assertEquals(20, result);
    }

    @Test
    public void shouldReturnTheDivisionOfOneNumber(){
        int num1 = 40;

        int result = this.becaService.division(num1);

        Assert.assertEquals(10, result);
    }

    */


}
