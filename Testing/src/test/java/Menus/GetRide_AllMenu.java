package Menus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetRide_AllMenu {

    public AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void SetupAppium() throws Exception {

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Galaxy A30");
//        caps.setCapability("udid", "R58M356N86D");
        caps.setCapability("deviceName", "HUAWEI novs 2 lite");
        caps.setCapability("udid", "RBDBB18906501214");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("noReset","true");
//        caps.setCapability("skipServerInstallation","ture");
        caps.setCapability("newCommandTimeout","300");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test()
    public void test() throws Exception{

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='DISMISS']")).click();

        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='History']")).click();
//        driver.findElement(By.id("day")).click();
//        driver.findElement(By.id("btnMenu")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='Favourites']")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='Notifications']")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='User Profile']")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='Support']")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='About']")).click();
        driver.findElement(By.id("menu")).click();
        driver.findElement(By.xpath("//*[@text='Where you go']")).click();

        //Car
        driver.findElement(By.xpath("(//*[@class='android.support.v7.app.ActionBar$Tab' and ./*[@class='android.widget.ImageView']])[1]")).click();
        //Truck
        driver.findElement(By.xpath("(//*[@class='android.support.v7.app.ActionBar$Tab' and ./*[@class='android.widget.ImageView']])[2]")).click();
        //Tuk Tuk
        driver.findElement(By.xpath("(//*[@class='android.support.v7.app.ActionBar$Tab' and ./*[@class='android.widget.ImageView']])[3]")).click();

    }
}
