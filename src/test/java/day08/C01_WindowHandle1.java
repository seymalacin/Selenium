package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {
        //Tests package’inda yeni bir class olusturun: WindowHandle
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

        //ılk sayfanın ıdsını alalım
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String window1Text =  driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);


        // Bu noktada 2 penvcere acık ve 2. sıne gecıs yapmak ıstıyorum
        // Bunun ıcın driver.getWindowHandles() ile tum pencerelerden ıdlerını alalım
        Set<String> allWindowHandles = driver.getWindowHandles();//{window1Handle,window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){

            //eger lıstedekı id window1 e esit degilse , otomatik window 2 ye esittir
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);//burdakı eachhandle window2 handle ina esittir
                break;

            }
        }
        //bu noktada 2. pencerede
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

        //sayfadakı textin"New Window" oldugunu dogrulayın
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());

        String window2Handle = driver.getWindowHandle();
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());

        //2.windowa tekrar gecelim
        driver.switchTo().window(window2Handle);

        //1. windova tekrar gecellim
        driver.switchTo().window(window1Handle);



    }
}
