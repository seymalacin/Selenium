package day18;

import org.junit.Test;
import utilities.TestBase;
public class C01_JSExecutor_GetValue extends TestBase {

    //      1)getValueTest metotu olustur

    @Test
    public void getValueTest(){
        //  2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");

        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır

    }
}

