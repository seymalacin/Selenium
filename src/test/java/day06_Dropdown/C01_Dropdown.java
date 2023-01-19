package day06_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.Year;
import java.util.List;

public class C01_Dropdown {

    /*
          Dropdown?
          -Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.
          ***Dropdown nasil automate edilir? How to handle dropdown?
          1- Dropdown elementi locate edilir.8 locatordan biri kulllaninbilir.
          2- Select classi kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
          3- Select objectini kullanarak ugun methodlarla islem yapilir
              - selectBylndex(int); index 0 dan baslar
              - selectByValue(“String”);
              - selectByVisibleText(“String”);
        * getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
        * getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.

     */

    WebDriver driver;

    //Eger test sınıfında bırden fazla method (@Test) olusturulmussa,@Before kullanılır
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Given kulanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasındayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void selectByIndexTest() {


        //1. LOCATE dropdown eelment
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2.Select objesını olustur
        Select yearDropdown = new Select(year);

        //3. Select objesını kulllanatak 3 farkı sekılde secım yapabılırım
        yearDropdown.selectByIndex(22);//Secenek sırası 0 dan baslar.2000 yılı 23. sırada

        // Dogum yılını,ayını ve gununu su sekilde secer :2000,January,10

        //Ay secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//option in value degeri ile ssecim yapilabilir january secenegının value sı 0

        //Gun secimi seectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE - buyuk kucuk harf onemlı

    }

    @Test
    public void printAllTest() {

        //Tüm eyalet isimleirni consola yazdir
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
//        Tum eyalet isimlerini consola yazdiralim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();//tum isimleri yazdirir getOptions()
//        for (WebElement eachState : stateList) {//for ile cozumu
//            System.out.println(eachState.getText());
//
           stateList.stream().forEach(t-> System.out.println(t.getText()));//lambda version
        }
        @Test
        public void getSelectedOptionsTest(){
        //State dropdowndakini varsayilan seçili secenegin 'Select a State' oldugunu verify edelim
            WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
            Select stateDropdown = new Select(state);

            //WebElement varsayilanElement = stateDropdown.getAllSelectedOptions();//bu ılı kodun yaptıgını attakı kod yaptı
           // String varsayilanElementText = varsayılanElement.getText();

            String varsayianText = stateDropdown.getFirstSelectedOption().getText();//secili olan elementi return eder

            Assert.assertEquals("Select a State",varsayianText);

        }
        @After
         public void tearDown(){
        driver.close();
        }

        /*
        ***INTERWIEWWW****
        1.what is dropdown? Ddopdown nedir?*****
        Dropdpwn liste olusturmak icin kulanilir.

        2.How to handle dropdown elements?Dropdown nasi autome ediir?*****
        - dropdown i locate ederim
        -sellect classi olusturururm
        -select objesi olustururum
        -select objesi ile istedigim secenegi secerim
        NOT:select objesi Olusturma nedenim dropdownarin select kılasi ile olusturulmasi

        3.Tüm dropdown seceneklerini nasil print(yazdiririz) ederiz?*****
        -Tup dropdown elementlerini getOpsions() methodu ile listeye koyariz
        -sonra secenekleri loop ile yazdieabiliriz

        4.Bir secenegin secili odugunu otomate etmek için ne yapilir?******
        ÖR:Gun olarak 10 i secdik ama ya secilmediyse?
        getFirstSelectedOption() secili olan secenegi return eder
         */


    }


