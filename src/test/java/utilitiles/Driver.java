package utilitiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {



    /*
      Driver classından driver'i getDriver() ile kullanıyoruz
      sonradan proje ye katılan insanların Driver class'idan obje olusturarak
      driver kullanmaya calışmalarını engellemek için

      Driver class'ini SINGLETON PATERN ile düzenleyebiliriz

      bunun için Driver class'inin parametresiz constructor'ini olusturup
      access modifiler'ini PRIVATE yapmamiz yeterli olur.
     */


        static WebDriver driver;

        public static WebDriver getDriver(){

            if (driver==null) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            }

            return driver;

        }

        public static void closeDriver(){
            if (driver !=null){
                driver.close();
                driver=null;
            }
        }

        public static void quitDriver(){
            if (driver != null){
                driver.quit();
                driver=null;
            }
        }
    }
