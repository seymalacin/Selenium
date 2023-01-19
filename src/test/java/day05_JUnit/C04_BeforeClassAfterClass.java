package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {


    /*
    @BeforeClass ve @AfterClass notasyonları sadece static methodlar icin calisir
    @BeforeClass ve @AfterClass kullanırsak olusturdugumuz @Test methodlarının hepsin aynı anda çalistırıp
    en son @AfterClass'ı calistirir
        Ama sadece @Before ve @After kulanırsak her test icin @before ve @after'i kullanırız

     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalıştı");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştı");
    }
    @Before
    public void setup01(){
        System.out.println("Her Test'ten önce çalışır");
    }
    @After
    public void teardown01(){
        System.out.println("Her Test'ten sonra çalışır");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }
    @Test
    @Ignore//Eger ücüncu testi calistirmak istemessek bu sekilde kullanabiliriz
    public void test03(){
        System.out.println("Üçüncü Test");
    }
}
