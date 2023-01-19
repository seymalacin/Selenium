package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class Example extends TestBase {
    @Test
    public void test1() {

        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select option = new Select(dropdownMenu);
        List<WebElement> searchList = option.getOptions();
        searchList.stream().forEach(t-> System.out.println(t.getText()));

        //dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertTrue(searchList.size()>20);
    }

    @Test
    public void test2() {

        //Test02
        driver.get("https://amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement menu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        menu.click();
        Select select =new Select(menu);
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu =  driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone"+Keys.ENTER);
        System.out.println("Sonuc sayısı"+aramaKutusu);

        String [] aramaSonuc =driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("Arama sonuc sayısı ="+aramaSonuc [3]);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String iphone =driver.getTitle();
        Assert.assertTrue(iphone.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='s-image'])[2]")).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        String iphoneTitle = driver.getTitle();
        String iphonePrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Test
    public void test3() {

        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //dropdown’dan bebek bölümüne secin
         WebElement baby = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(baby);
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("bebek puset"+Keys.ENTER);
        String [] sonucSaysı = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("Arama sonuc yazısı :"+sonucSaysı [2]);

        //sonuç yazsının puset içerdiğini test edin
        String puset = driver.getTitle();
        Assert.assertTrue(puset.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='s-image'])[3]")).click();


        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title = driver.getTitle();
        String fiyat =driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]")).getText();


        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}
