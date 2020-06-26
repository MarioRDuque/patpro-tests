package pe.patpro;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pe.patpro.controlador.ControladorPrincipal;

@SpringBootTest
public class PatproTests {

    ControladorPrincipal paginaWeb;

    @BeforeTest
    public void setup() {
        paginaWeb = new ControladorPrincipal();
    }

//    @Test(priority = 1)
//    public void insertar() {
//        String res = paginaWeb.doSum("10", "20");
//        Assert.assertEquals(res, "30");
//    }
    
    @Test(priority = 4)
    public void sumTest() {
        String res = paginaWeb.doSum("10", "20");
        Assert.assertEquals(res, "30");
    }

    @Test(priority = 2)
    public void subTest() {
        String res = paginaWeb.doSub("100", "80");
        Assert.assertEquals(res, "20");
    }

    @Test(priority = 3)
    public void divTest() {
        String res = paginaWeb.doDiv("20", "2");
        Assert.assertEquals(res, "10");
    }
    
    @AfterTest
    public void cerrarNavegador(){
        paginaWeb.cerrarNavegador();
    }
}
