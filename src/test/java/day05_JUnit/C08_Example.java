package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.time.Duration;
import java.util.List;


public class C08_Example {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){




        driver.get("https://www.youtube.com");

        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.click();
        searchBox.sendKeys("sana yanarım");
        searchBox.submit();
        driver.findElement(By.xpath("//*[@class='style-scope ytd-video-renderer']"));

        List<WebElement>ikincı=driver.findElements(By.id("thumbnail"));
        ikincı.get(2).click();

    }
}