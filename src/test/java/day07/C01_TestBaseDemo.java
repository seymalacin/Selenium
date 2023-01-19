package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
   UTILITIES:
   - Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase -> Bugun
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.
   - Bu support class'lar test case'lerin yazilmasini hizlandirir.
 */

    @Test
    public void test1(){
        //techproeducation ana sayfasina git ve
        driver.get("https://www.techproeducation.com");

        // titlein 'Bootcamps' kelimesini icerdigini test edelim
        String pageTite = driver.getTitle();
        Assert.assertTrue(pageTite.contains("Bootcamps"));

    }
}
