package test.amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilitiles.ConfigReader;
import utilitiles.Driver;
import utilitiles.ReusableMethods;

public class C01_AmazonAnasayfa {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.allMenu.click();


       // WebElement allMenu= Driver.getDriver().findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
       // allMenu.click();
        WebElement electronics=Driver.getDriver().findElement(By.xpath("//a[@data-menu-id='5']"));
        electronics.click();
        WebElement cameraPhoto=Driver.getDriver().findElement(By.xpath("//a[text()='Camera & Photo']"));
        cameraPhoto.click();
        ReusableMethods.bekle(2);
        WebElement digitalCamerras=Driver.getDriver().findElement(By.xpath("//span[text()='Digital Cameras']"));
        digitalCamerras.click();
        ReusableMethods.bekle(2);
        /*WebElement sonucYazisi=Driver.getDriver().findElement(By.xpath("//options[text()='Digital Cameras']"));
        String expectedKelime="Digital Cameras";
        String actualSonucYazisi=sonucYazisi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        */

        WebElement dropdownElementi=Driver.getDriver().findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownElementi);
        select.selectByVisibleText("Digital Cameras");
        String actulOption=select.getFirstSelectedOption().getText();
        String expectedKelime="Digital Cameras";

        Assert.assertEquals(expectedKelime,actulOption);


        Driver.closeDriver();
    }
}
