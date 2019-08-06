import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Parallel_Testing {

    public AndroidDriver driver;

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
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        caps.setCapability("noReset","true");

        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception {


        driver.findElement(By.id("radEng")).click();

        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();

        driver.findElement(By.id("txtName")).sendKeys("htetaunglwin");
        driver.findElement(By.id("txtPhone")).sendKeys("09685203352");

        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();

        driver.findElement(By.id("com_accountkit_next_button")).click();

        Activity activity = new Activity("com.android.mms", "com.android.mms.ui.ConversationList");
        activity.setStopApp(false);
        driver.startActivity(activity);

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.mms:id/from']")).click();
        String OTPText = driver.findElementById("com.android.mms:id/text_view").getText();

        String OTP = OTPText.substring(4, 10);
        char[] eachOTP = OTP.toCharArray();

        driver.navigate().back();
        driver.navigate().back();

        for(int i=0;i<OTP.length();i++) {

            String pt = String.valueOf(eachOTP[i]);
//
            driver.findElement(By.id("com_accountkit_confirmation_code_" + (i + 1) )).sendKeys(pt);
        }

        driver.findElement(By.id("com_accountkit_next_button")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='DISMISS']")).click();

        WebElement dropoff = driver.findElement(By.id("dropOffText"));
        dropoff.click();
        driver.findElement(By.id("inputSearch")).click();
        driver.findElement(By.xpath("//*[@text='Sule Shangri-La Hotel']")).click();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

}
