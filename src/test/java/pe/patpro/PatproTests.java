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

    @Test(priority = 1)
    public void listar() {
        String res = paginaWeb.listar();
        Assert.assertEquals(res, "Se han listado todos los registros.");
    }

    @Test(priority = 2)
    public void insertarValorDesconocidoEnCombo() {
        String res = paginaWeb.insertarValorDesconocidoEnCombo();
        Assert.assertEquals(res, "El valor ingresado no corresponde al combo.");
    }

    @Test(priority = 3)
    public void insertarConNombreSuperiorA50() {
        String res = paginaWeb.insertarConNombreSuperiorA50();
        Assert.assertEquals(res, "El nombre del libro debe tener menos de 50 caracteres.");
    }

    @Test(priority = 4)
    public void insertarConAbreviaturaSuperiorA10() {
        String res = paginaWeb.insertarConAbreviaturaSuperiorA10();
        Assert.assertEquals(res, "El nombre del libro debe tener menos de 10 caracteres.");
    }

    @Test(priority = 5)
    public void insertar() {
        String res = paginaWeb.insertar();
        Assert.assertEquals(res, "Libro insertado correctamente.");
    }

    @Test(priority = 6)
    public void editar() {
        String res = paginaWeb.editar();
        Assert.assertEquals(res, "Libro modificado correctamente.");
    }

    @Test(priority = 7)
    public void eliminar() {
        String res = paginaWeb.eliminar();
        Assert.assertEquals(res, "Libro eliminado correctamente.");
    }

    @AfterTest
    public void cerrarNavegador() {
        paginaWeb.cerrarNavegador();
    }
}
