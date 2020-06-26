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
import pe.patpro.entidades.Libro;

/**
 *
 * @author NaveenKhunteta
 *
 */
public class ControladorPrincipal {

    WebDriver driver;
    NgWebDriver ngWebDriver;
    JavascriptExecutor jsDriver;

    ByAngularModel first = ByAngular.model("first");
    ByAngularModel second = ByAngular.model("second");
    ByAngularModel operator = ByAngular.model("operator");
    ByAngularButtonText go = ByAngular.buttonText("Go!");

    By result = By.tagName("h2");

    public ControladorPrincipal() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jsDriver = (JavascriptExecutor) driver;
        ngWebDriver = new NgWebDriver(jsDriver);
        driver.get("http://localhost/proyectoFinal");
        ngWebDriver.waitForAngularRequestsToFinish();

    }

    public String validarNombre(String nombre) {
        ByAngularModel first = ByAngular.model("first");
        //resultado actual y resultado esperado
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(nombre);

        driver.findElement(operator).sendKeys("+");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();

        System.out.println(driver.findElement(result).getText());
        return driver.findElement(result).getText();
    }

    public String insertarLibro(Libro libro) {
        //resultado actual y resultado esperado
        try {
            String esperado = "Libro insertado correctamente";
            driver.findElement(first).clear();
            driver.findElement(first).sendKeys(libro.getNombre());

            driver.findElement(operator).sendKeys("+");
            driver.findElement(go).click();
            ngWebDriver.waitForAngularRequestsToFinish();
            Thread.sleep(3000);
            System.out.println(driver.findElement(result).getText());
            return driver.findElement(result).getText();
        } catch (Exception e) {
            return e != null ? e.getMessage() : "Nulo";
        }
    }

    public String doSum(String v1, String v2) {
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(v1);

        driver.findElement(second).clear();
        driver.findElement(second).sendKeys(v2);

        driver.findElement(operator).sendKeys("+");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();

        System.out.println(driver.findElement(result).getText());
        return driver.findElement(result).getText();
    }

    public String doSub(String v1, String v2) {
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(v1);

        driver.findElement(second).clear();
        driver.findElement(second).sendKeys(v2);

        driver.findElement(operator).sendKeys("-");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();

        System.out.println(driver.findElement(result).getText());
        return driver.findElement(result).getText();
    }

    public String doDiv(String v1, String v2) {
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(v1);

        driver.findElement(second).clear();
        driver.findElement(second).sendKeys(v2);

        driver.findElement(operator).sendKeys("/");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();

        System.out.println(driver.findElement(result).getText());
        return driver.findElement(result).getText();
    }

    public void cerrarNavegador() {
        driver.quit();
    }

}
