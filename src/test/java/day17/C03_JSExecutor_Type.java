package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {

    @Test
    public void typeTest() {
        //1)typeTest metotu olustur
        //	2)Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

        //	3)Arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");
    }
}
