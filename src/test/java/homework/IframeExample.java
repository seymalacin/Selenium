package homework;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeExample extends TestBase {


    @Test
    public void test1() {



        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe ");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframe =driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
         String actual = driver.findElement(By.xpath("//h3")).getText();
         String expected = "Editor";
        Assert.assertTrue(actual.contains(expected));

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        textbox.clear();

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.id("tinymce")).sendKeys("iframein icindeyim");

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String text = driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
        Assert.assertTrue(text.contains("Elemental Selenium"));



    }
}