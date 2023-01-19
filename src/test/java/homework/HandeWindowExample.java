package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HandeWindowExample extends TestBase {

    @Test
    public void test1(){

        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title'in "Windows" oldugunu test edin
        String targetTitle="Windows";
        switchToWindow(targetTitle);

        //Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        String targetTitle2="New Window";
        switchToWindow(targetTitle2);

    }
}
