package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Iframe extends TestBase {

/*
How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
***driver.findElements(By.tagName(“iframe”));
***driver.findElements(By.xpath(“//iframe”));
————————————
Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
***2 farkli yol vardır.
***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
———————————-
What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
*** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
—————————————
What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
Iframe. Cozum : switch to iframe
Alert. Cozum : switch to alert
New window(Yeni pencere) : switch to window

 */

    @Test
    public void iframeTest(){
        //Iframe nedir?

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim

      //  WebElement metinElementi = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']"));
      //  String anaMetin = metinElementi.getText();//bu sekılde de olabılır
              //tag[.='metin']; 1.   bana bu tagli metni ver isdedigini kulan
              //tag[text()='metin'];  2.
        String anaMetin =  driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        String expectedText =" black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists elementi iframe in icinde. ıframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar ılk ıframe switch yapıyoruz
        String icMetin =driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String exceptionText1="Applications lists";
        Assert.assertEquals(exceptionText1,icMetin);

        //alternatif olarak altındakı secenekler de kullanılabılır
       // Assert.assertTrue(exceptionText1.contains(icMetin));
       // Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isSelected());

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //Ana sayfadaki Powered By yazısını test etmek ıstıyorum ama driver hala iframein icinde
        //Iframenin dısına cıkmak ıcın driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText =driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));







    }

}
