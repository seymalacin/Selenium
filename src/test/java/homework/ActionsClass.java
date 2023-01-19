package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsClass extends TestBase {
    @Test
    public void hoverOver1() {


        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
         Actions actions =new Actions(driver);
         WebElement actionList = driver.findElement(By.xpath("//*[@class='dropbtn']"));
         actions.moveToElement(actionList).perform();
         waitFor(2);

        //Link 1" e tiklayin  87
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        // Popup mesajini yazdirin
        System.out.println("Well done you clicked on the link!");

        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //“Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHold).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHold=driver.findElement(By.xpath("//*[.='Click and Hold!']"));
        System.out.println("click  = " +clickAndHold.getText()) ;

        //8- “Double click me" butonunu cift tiklayin
         actions.doubleClick(driver.findElement(By.id("double-click"))).perform();


    }
}
