package Order_complete;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Getride_order_complete_parallel {

    public AndroidDriver driver;

//    @BeforeTest
//    public void SetupAppium() throws Exception{
//
//// Appium Setup
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "HUAWEI nova 2 lite");
//        caps.setCapability("udid", "RBDBB18906501214");
//        caps.setCapability("platformName", "android");
//        caps.setCapability("platformVersion", "8.0.0");
//        caps.setCapability("skipUnlock", "true");
//        caps.setCapability("noReset","true");
//        caps.setCapability("newCommandTimeout","180");
//        caps.setCapability("appPackage", "com.getride.customer.debug");
//        caps.setCapability("appActivity", "com.htk.getride.ui.activities.MainActivity");
//        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
//
//        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
//        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//    }

    @Parameters({"platform", "udid", "systemPort"})
    @BeforeTest(alwaysRun = true)

    public void setup(String platform, String udid, String systemPort) throws Exception {
        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        String[] platformInfo = platform.split(" ");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.UDID, udid);
        caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        caps.setCapability("newCommandTimeout","300");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        caps.setCapability("noReset","true");


        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception{

        Thread.sleep(20000);
        driver.findElement(By.id("dropOffText")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("inputSearch")).sendKeys("Myan");
        driver.findElement(By.xpath("//*[@text='Myanmar Plaza']")).click();
        Thread.sleep(8000);
        driver.findElement(By.id("book")).click();
        Thread.sleep(60000);
        driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout' and ./*[@class='android.widget.ImageView']])[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='All went well']")).click();
//        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();

        //cancel order by customer

//        driver.findElement(By.id("positiveBtn")).click();
//        driver.findElement(By.id("cancelOrder")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.id("inputSearch")).sendKeys("I have urgent business");
//        driver.findElement(By.xpath("button1")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("btnOrderHistory")).click();


//        driver.findElement(By.id("viewOrder")).click();
//        driver.findElement(By.id("tripDetail")).click();
//        driver.findElement(By.id("close")).click();
//        driver.navigate().back();




    }

//    @AfterClass
//    public void teardown(){
//        if(driver!=null) driver.quit();
//
//    }
}
