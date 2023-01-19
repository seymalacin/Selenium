package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {


        //        Amazona git
        driver.get("https://www.amazon.com");
        waitFor(3);

//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies(); // toplam cerez sayisi
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada "+cookieSayisi+ " adet cookie var");

//        3. Bir Cookie yi ismiyle bul
        System.out.println("COKKIEYI ISMIYLE CAGIRIYORUM : "+driver.manage().getCookieNamed("i18n-prefs"));

//        tum cokkie leri yazdiralim
//        allCookies.stream().forEach(t -> System.out.println(t.getName()));//lambda kullanuımı
        for (Cookie eachCookie : allCookies){//forla yapımı
            System.out.println("COOKIE : "+eachCookie);//COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }

//        4. Yeni bir cookie ekle
        Cookie favoriCookiem= new Cookie("cikolatam","antep-fistikli-cikolata");//cookie olustur
        driver.manage().addCookie(favoriCookiem);//sayfaya yenı cookıe ekle
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());//cookıe sayısı arttı

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());


    }
    }

