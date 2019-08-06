package Order_incomplete;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetRide_CancelOrder_Parallel {

    public AndroidDriver driver;

    @Parameters({"platform", "udid", "systemPort"})
    @BeforeTest(alwaysRun = true)

    public void setup(String platform, String udid, String systemPort) throws Exception {
        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        String[] platformInfo = platform.split(" ");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        capabilities.setCapability("newCommandTimeout","300");
        capabilities.setCapability("appPackage", "com.getride.customer.debug");
        capabilities.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        capabilities.setCapability("noReset","true");


        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception{

        Thread.sleep(40000);
        driver.findElement(By.id("dropOffText")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("inputSearch")).sendKeys("Myan");
        driver.findElement(By.xpath("//*[@text='Myanmar Plaza']")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("book")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("cancelOrder")).click();

    }
}
