package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot2 extends TestBase {


    /*
        Ekran goruntusu alma:
          getScreenShotAs metotu ile alinir.
           Bu metot Selenium dan gelir
          getScreenshotAs metotu TakesScreenshot api indan gelir
          Selenium 4 den itibaren 2 farklı sekilde ekran goruntusu alınabilir:
           Tum Sayfa, Özel element
          Olusturmus oldugumuz ReusableMetot yardimizya ister tum sayfanin, istersem belirli bir elementin ekran goruntusunu kolaylıkla alabilirim
     */

    @Test
    public void screenshotOfSpecificElements() throws IOException {

        //Techpro education a git
        driver.get("https://www.techproeducation.com");


        //Sosyal medya elemanlarını goruntusunu al
        // 1. EKRAN GORUNTUSUNU CEK
        WebElement sosyalMedyaIconları =driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]"));
        File image = sosyalMedyaIconları.getScreenshotAs(OutputType.FILE);

        //  2.GPRUNTUYU KAYDET
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        waitFor(3);
        // Logonun ekran goruntusunu al
        takeScreenshotOfElement(driver.findElement(By.xpath("//div[@data-id='898ce2e']")));


    }
}
