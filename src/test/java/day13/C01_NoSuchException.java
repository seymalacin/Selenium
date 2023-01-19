package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchException extends TestBase {

   /*
   NoSuchElementException----- veb element bulunamadı zamanda kullanılabılır
     *Yanlis locator
     *Popup, yeni pencere, iframe…
     *Sayfa dolmada problemler ve yavaşlamalar
     *Sakli olan elementler
   Cözüm:
     Locatorin dogrulugunu tekrar kontrol et
     Manual test ile iframe, yeni pencere, alert…. gibi elementlerin varliğini kontrol et
     Bekleme problemi olabilir. İmplicit wait bekleme suresini cozmuyor. Bu duurmda explicit wait ya da fluent wait kullaniriz
    */
    @Test
    public void noSuchElementTest() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:---yazım htası
                sendKeys("QA"+ Keys.ENTER);
    }
}
