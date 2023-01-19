package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {



    @Test
    public void sendKeysMethod() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);

        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Seyma");
        Thread.sleep(5000);

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "Seyma";
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(5000);



    }
}
