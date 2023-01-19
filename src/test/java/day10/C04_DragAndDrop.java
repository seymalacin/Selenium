package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {

    @Test
    public void dragAndDrop() {
        //EN FAZLA SURUKEMEK ICIN KULLANIAN METHOT BU
        //1.YOL-surukleme ıslemı-dragAndDrop
        //Class: Action4
        //Method: dragAndDropTest

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAMENIN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        // dragAndDrop() surukleme ıslemını gerceklesdırır
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak, hedef).perform();//kaynagı hedefe surukleyecek
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest() {
        //2.YOL
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAMENIN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        // dragAndDrop() surukleme ıslemını gerceklesdırır
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//kaynagı tut
                .moveToElement(hedef)//hedefe koy
                .release()//kaynagı bırak
                .build()//oncekı methodarın iliskısını kur/guclendir.KULLANILMASI TERCIH EDILIR. sart degıldır
                .perform();//islemı gerceklestır

    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAMENIN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        // dragAndDrop() surukleme ıslemını gerceklesdırır
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)
                .moveByOffset(430,30)
                .release()
                .build()
                .perform();

    }
}