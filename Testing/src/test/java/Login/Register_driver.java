package Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Register_driver {

    public AndroidDriver driver;

    @BeforeTest
    public void SetupAppium() throws Exception{

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "HUAWEI novs 2 lite");
        caps.setCapability("udid", "RBDBB18906501214");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("newCommandTimeout","300");
        caps.setCapability("appPackage", "com.getride.getdriver.debug");
        caps.setCapability("appActivity", "com.htk.getride.driver.activities.SplashActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception {

        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();

        driver.findElement(By.id("radEng")).click();
        driver.findElement(By.id("btn_register")).click();

        driver.findElement(By.id("edt_full_name")).sendKeys("annann");
        driver.findElement(By.id("edt_id_card")).sendKeys("121314");
        driver.findElement(By.id("edt_d_o_birth")).sendKeys("1992-06-05");

        driver.findElement(By.id("btn_continue")).click();

        driver.findElement(By.id("edt_phone")).sendKeys("4151");
        driver.findElement(By.id("edt_pass")).sendKeys("qweqwe321321");
        driver.findElement(By.id("edt_confirm_pass")).sendKeys("qweqwe321321");

        driver.findElement(By.id("btn_continue")).click();

//        driver.findElementByImage("")

    }
}
