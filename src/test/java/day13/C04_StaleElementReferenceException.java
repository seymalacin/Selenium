package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

   // eer kullandıgım element eskı ıse kullanım suresı gecmıs ıse
    //Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
    //-Sayfayi yenilediğinizde (refresh())
    //-Sayfada ileri geri gittimizde
    //COZUM:
    //Elementi tekrar bulmak

    @Test
    public void StaleElementReferenceExceptionTest1() {
        driver.get("https://techproeducation.com");

        //        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et

        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGİN"));
        waitFor(5);
        lmsLoginLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URL in lms kelımesını ıcerdıgını test et

        //        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gıttık
        waitFor(5);
        lmsLoginLink.click();//lms git

        /*
        lmsLoginLink lınkını sayfa yenılendıgınden (back())  sonra kullandıgım cın StaleElementRefranceException aldım
         */

    }

    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        // sayfa yenılenmeden once buldugum elementı , sayfa yenılendıkden sonra elemanı kulanmak ıstedım
        lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException

        //COZUM ESKI (SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        //  driver.findElement(By.linkText("LMS LOGIN")).click();
    }
}
