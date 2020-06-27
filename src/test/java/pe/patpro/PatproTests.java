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

//    testValidarNoVcios
//            esperado: Errores en el fromulario
//    testCombo con valores difrentes de los permitidos
//            esperado: El estado no puede ser diferente de esos valores
//    @Test(priority = 2)
//    public void validarLongituDeNombre() {
//        String res = paginaWeb.validarLongituDeNombre();
//        Assert.assertEquals(res, "La longitud del nombre debe estar entre 0 y 50.");
//    }

    @Test(priority = 2)
    public void insertar() {
        String res = paginaWeb.insertar();
        Assert.assertEquals(res, "Libro insertado correctamente.");
    }

    @Test(priority = 3)
    public void editar() {
        String res = paginaWeb.editar();
        Assert.assertEquals(res, "Libro modificado correctamente.");
    }

    @Test(priority = 4)
    public void eliminar() {
        String res = paginaWeb.eliminar();
        Assert.assertEquals(res, "Libro eliminado correctamente.");
    }

    @AfterTest
    public void cerrarNavegador() {
        paginaWeb.cerrarNavegador();
    }
}
