package Login;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetOTP_Samsung {

    public AndroidDriver driver;

    @BeforeTest
    public void SetupAppium() throws Exception{

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy A20");
        caps.setCapability("udid", "R58M361KS2P");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception {

        driver.findElement(By.id("radEng")).click();

        driver.findElement(By.xpath("//*[@text='\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200E\u200E\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200EAllow\u200E\u200F\u200E\u200E\u200F\u200E']")).click();
//        driver.findElement(By.id("permission_allow_button")).click();

        driver.findElement(By.id("txtName")).sendKeys("htetaunglwin");
        driver.findElement(By.id("txtPhone")).sendKeys("09685203358");

        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//*[@text='\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200E\u200E\u200F\u200E\u200E\u200E\u200F\u200F\u200F\u200EAllow\u200E\u200F\u200E\u200E\u200F\u200E']")).click();

        driver.findElement(By.id("com_accountkit_next_button")).click();

//        Activity activity = new Activity("com.android.mms", "com.android.mms.ui.ConversationList");
        Activity activity = new Activity("com.samsung.android.messaging", "com.samsung.android.messaging.ui.view.main.WithActivity");
        activity.setStopApp(false);
        driver.startActivity(activity);

        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.samsung.android.messaging:id/card_view_list_item']")).click();
//        String OTPText = driver.findElementById("content_text_view").getText();
        String OTPText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.samsung.android.messaging:id/content_text_view']")).getText();

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

//        driver.findElement(By.xpath("//*[@text='DISMISS']")).click();

    }
//    @AfterClass
//    public void teardown(){
//        if(driver!=null) driver.quit();
//
//    }
}
