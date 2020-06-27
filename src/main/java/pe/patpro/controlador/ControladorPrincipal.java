package pe.patpro.controlador;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Mario Ramos
 *
 */
public class ControladorPrincipal {

    WebDriver driver;
    NgWebDriver ngWebDriver;
    JavascriptExecutor jsDriver;

    public ControladorPrincipal() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jsDriver = (JavascriptExecutor) driver;
        ngWebDriver = new NgWebDriver(jsDriver);
        driver.get("http://localhost/proyectoFinal");
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.manage().window().maximize();
    }

    public String insertar() {
        try {
            Thread.sleep(3000);
            ByAngularModel nombre = ByAngular.model("libro.nombre");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("Luis");
            ByAngularModel autor = ByAngular.model("libro.autor");
            driver.findElement(autor).clear();
            driver.findElement(autor).sendKeys("Ortiz");
            ByAngularModel abreviatura = ByAngular.model("libro.abreviatura");
            driver.findElement(abreviatura).clear();
            driver.findElement(abreviatura).sendKeys("LO");
            ByAngularModel estado = ByAngular.model("libro.estado");
            driver.findElement(estado).sendKeys("REGULAR");
            ByAngularButtonText guardar = ByAngular.buttonText("Guardar");
            driver.findElement(guardar).click();
            Thread.sleep(3000);
            WebElement we = driver.findElement(By.id("alerta"));
            return we.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void cerrarNavegador() {
        driver.quit();
    }

    public String listar() {
        try {
            ngWebDriver.waitForAngularRequestsToFinish();
            Thread.sleep(3000);
            WebElement we = driver.findElement(By.id("alerta"));
            return we.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String editar() {
        try {
            WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/button[1]"));
            we.click();
            Thread.sleep(3000);
            ByAngularModel nombre = ByAngular.model("libro.nombre");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("Luis");
            ByAngularModel autor = ByAngular.model("libro.autor");
            driver.findElement(autor).clear();
            driver.findElement(autor).sendKeys("Ortiz");
            ByAngularModel abreviatura = ByAngular.model("libro.abreviatura");
            driver.findElement(abreviatura).clear();
            driver.findElement(abreviatura).sendKeys("LO");
            ByAngularModel estado = ByAngular.model("libro.estado");
            driver.findElement(estado).sendKeys("REGULAR");
            ByAngularButtonText guardar = ByAngular.buttonText("Guardar");
            driver.findElement(guardar).click();
            Thread.sleep(3000);
            WebElement we2 = driver.findElement(By.id("alerta"));
            return we2.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String eliminar() {
        try {
            WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/button[2]"));
            we.click();
            Thread.sleep(3000);
            ByAngularButtonText confirmar = ByAngular.buttonText("Confirmar");
            driver.findElement(confirmar).click();
            Thread.sleep(3000);
            WebElement we2 = driver.findElement(By.id("alerta"));
            return we2.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String validarLongituDeNombre() {
        try {
            WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/button[1]"));
            we.click();
            Thread.sleep(3000);
            ByAngularModel nombre = ByAngular.model("libro.nombre");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("Luis");
            ByAngularModel autor = ByAngular.model("libro.autor");
            driver.findElement(autor).clear();
            driver.findElement(autor).sendKeys("Ortiz");
            ByAngularModel abreviatura = ByAngular.model("libro.abreviatura");
            driver.findElement(abreviatura).clear();
            driver.findElement(abreviatura).sendKeys("LO");
            ByAngularModel estado = ByAngular.model("libro.estado");
            driver.findElement(estado).sendKeys("REGULAR");
            ByAngularButtonText guardar = ByAngular.buttonText("Guardar");
            driver.findElement(guardar).click();
            Thread.sleep(3000);
            WebElement we2 = driver.findElement(By.id("alerta"));
            return we2.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String insertarConNombreSuperiorA50() {
        try {
            ByAngularButtonText nuevo = ByAngular.buttonText("Nuevo");
            driver.findElement(nuevo).click();
            Thread.sleep(3000);
            ByAngularModel nombre = ByAngular.model("libro.nombre");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("La increíble y triste historia de la cándida Eréndira y su abuela desalmada, Gabriel García Márquez");
            ByAngularModel autor = ByAngular.model("libro.autor");
            driver.findElement(autor).clear();
            driver.findElement(autor).sendKeys("Ortiz");
            ByAngularModel abreviatura = ByAngular.model("libro.abreviatura");
            driver.findElement(abreviatura).clear();
            driver.findElement(abreviatura).sendKeys("LO");
            ByAngularModel estado = ByAngular.model("libro.estado");
            driver.findElement(estado).sendKeys("REGULAR");
            ByAngularButtonText guardar = ByAngular.buttonText("Guardar");
            driver.findElement(guardar).click();
            Thread.sleep(3000);
            WebElement we = driver.findElement(By.id("alerta"));
            return we.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String insertarConAbreviaturaSuperiorA10() {
        try {
            Thread.sleep(3000);
            ByAngularModel nombre = ByAngular.model("libro.nombre");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("La increíble y triste historia");
            ByAngularModel autor = ByAngular.model("libro.autor");
            driver.findElement(autor).clear();
            driver.findElement(autor).sendKeys("Ortiz");
            ByAngularModel abreviatura = ByAngular.model("libro.abreviatura");
            driver.findElement(abreviatura).clear();
            driver.findElement(abreviatura).sendKeys("ABCDEFGHIJKLMN");
            ByAngularModel estado = ByAngular.model("libro.estado");
            driver.findElement(estado).sendKeys("REGULAR");
            ByAngularButtonText guardar = ByAngular.buttonText("Guardar");
            driver.findElement(guardar).click();
            Thread.sleep(3000);
            WebElement we = driver.findElement(By.id("alerta"));
            return we.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
