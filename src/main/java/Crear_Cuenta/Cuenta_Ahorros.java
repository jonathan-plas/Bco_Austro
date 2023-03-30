package Crear_Cuenta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Cuenta_Ahorros  {
    String Url = "https://bancodelaustro-dev.outsystemsenterprise.com/Login/";
    public static WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Escritorio\\Todas las Carpetas\\chromedriver\\chromedriver.exe");
        ChromeOptions notificaciones = new ChromeOptions();
        notificaciones.addArguments("--disable-notifications");
        notificaciones.addArguments("--disable-extensions");
        driver = new ChromeDriver(notificaciones);
        driver.manage().window().maximize();
        driver.get(Url);
    }

        @Test()
        public void ingresar(){
            String usuario="BA01000815";
            String pass="ba.01000815";
            wait_time_clickable("//INPUT[@id='b1-Input_Username']");
            WebElement user = driver.findElement(By.xpath("//INPUT[@id='b1-Input_Username']"));
            user.sendKeys(usuario);
            WebElement contrasena = driver.findElement(By.xpath("//INPUT[@id='b1-Input_Password']"));
            contrasena.sendKeys(pass);
            WebElement btningresar = driver.findElement(By.xpath("//DIV[@data-container=''][text()='INGRESAR']"));
            btningresar.click();


            wait_time_clickable("//div[@class='line-space'][contains(.,'APERTURA')]");
            WebElement apertura = driver.findElement(By.xpath("//div[@class='line-space'][contains(.,'APERTURA')]"));
            apertura.click();
            wait_time_clickable("//span[contains(.,'DE AHORROS')]");
            WebElement cta_ahorros = driver.findElement(By.xpath("//span[contains(.,'DE AHORROS')]"));
            cta_ahorros.click();
            wait_time_clickable("//INPUT[@id='b1-b2-Input_numeroCedula4']");
            WebElement cedula= driver.findElement(By.xpath("//INPUT[@id='b1-b2-Input_numeroCedula4']"));
            cedula.sendKeys("0106833064");
            //campo huella dactilar
            wait_time_clickable("//INPUT[@id='b1-b2-Input_codigoDactilar4']");
            WebElement hda= driver.findElement(By.xpath("//INPUT[@id='b1-b2-Input_codigoDactilar4']"));
            hda.sendKeys("EE99999999");
            //Botón consultar
            wait_time_clickable("//BUTTON[@data-button='']");
            WebElement btnconsultar= driver.findElement(By.xpath("//BUTTON[@data-button='']"));
            btnconsultar.click();







        }
        public static WebElement wait_time_clickable (String soul) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (120));
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(soul)));
        }
}



