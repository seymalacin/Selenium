package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {

    //scrollIntoViewTest metotu olustur


    @Test
    public void scrollIntoViewTest() throws IOException {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al

        //*** bu 3 asama fix*****hersey icin

        // 1.Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

        //2.js Executor objesı olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

     //        3. Yapmak istedigim islemi js.executeScript metot u ile yap
//        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir -gorene kadar git
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);

        //sayfa ekran gorunturunu al
        takeScreenShotOfPage();

        //Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();



//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();


//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        // En uste git
        scrollTopJS();
        waitFor(3);

        //En alta git
        scrollEndJS();
        waitFor(3);

    }
}
