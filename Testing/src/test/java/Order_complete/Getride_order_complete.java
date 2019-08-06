package Order_complete;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Getride_order_complete {

    public AndroidDriver driver;

    @BeforeTest
    public void SetupAppium() throws Exception{

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Galaxy A30");
//        caps.setCapability("udid", "R58M356N86D");
        caps.setCapability("deviceName", "HUAWEI nova 2 lite");
        caps.setCapability("udid", "RBDBB18906501214");
//        caps.setCapability("deviceName", "Oppo A57");
//        caps.setCapability("udid", "4699532");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("skipServerInstallation","ture");
        caps.setCapability("newCommandTimeout","300");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
//        caps.setCapability("autoGrantPermission","ture");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception {

        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@text='DISMISS']")).click();

        driver.findElement(By.xpath("(//*[@class='android.support.v7.app.ActionBar$Tab' and ./*[@class='android.widget.ImageView']])[1]")).click();

        driver.findElement(By.id("dropOffText")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("inputSearch")).sendKeys("Myan");
        driver.findElement(By.xpath("//*[@text='Myanmar Plaza']")).click();
        Thread.sleep(8000);
        driver.findElement(By.id("book")).click();
        Thread.sleep(30000);
        driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout' and ./*[@class='android.widget.ImageView']])[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='All went well']")).click();
//        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
    }
}
