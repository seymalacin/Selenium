package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {


////    Task 1 : Table1’i print edin
////    Task 2 : 3. Row’ datalarını print edin
////    Task 3 : Son row daki dataları print edin
////    Task 4 : 5. Column datalarini print edin
//
////    Parameter 1 = row numarasi
////    Parameter 2 = column numarasi
////    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

    @Test
    public void table1Print(){
        //    https://the-internet.herokuapp.com/tables
        //    Task 1 : Table1’i print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        System.out.println(table1);

        //2.yol
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMDA
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }
    }
    @Test
    public void row3Print(){
        //    Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sonSatirVerileri(){
        //    Task 3 : Son row daki dataları print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sutun5Test(){
        //    Task 4 : 5. Column datalarini print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));
    }




    public void printData(int satir, int sutun){//satır ve sutun sayılarınnı parametreden gonderebılırım. bunun avantajı ısdedımde ısdedımı asagıda cagırabılmek
        //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }
     //    Task 4 : 5. Column datalarini print edin
     //    Parameter 1 = row numarasi

    @Test
    public void printDataTest(){
        //    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
        printData(2,3);//fbach@yahoo.com

        //    Parameter 2 = column numarasi
        printData(1,2);//john   //// bunun gibi direk yazdırmsk parametre ıcınde belırtım ıcın
    }

    }
