package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Example {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

//2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//4. Login tusuna basin
       driver.findElement(By.id("login-button")).click();

//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.cssSelector("div[class='inventory_item_img']"));
        String urunadi =ilkUrun.getText();
        ilkUrun.click();

//6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet = driver.findElement(By.cssSelector("div[class='inventory_item_name']"));
        System.out.println(sepet.getText().equals(urunadi) ? "Test's Passed" : "Test's Failed");

//9. Sayfayi kapatin
        driver.close();

    }
}
