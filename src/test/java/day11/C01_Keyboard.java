package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Keyboard extends TestBase {

    @Test
    public void keyboardActionsTest() {

         //Create a class: Action5
        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

         WebElement aramaKutusu = driver.findElement(By.name("q"));

        // aramaKutusu.sendKeys("iphone x fiyatkari "+ Keys.ENTER);//bu yetrelı olmaz

        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde shift tusun bas
                .sendKeys("iphone x fiyatları")//shıfte basılıyken yazı yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shıft de artık basma
                .sendKeys("cok pahalı!"+Keys.ENTER)//normal halde yaz ve enter tusuna bas
                .build()//birden fazla actions methodu kullanıldında build() kullanilması onerılır yapıyı güclendırıyo
                .perform();



    }
}
