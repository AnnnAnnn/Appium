package Login;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Login_success_customer {

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

        driver.findElement(By.id("radEng")).click();

        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
//        driver.findElement(By.id("permission_allow_button")).click();

        driver.findElement(By.id("txtName")).sendKeys("htetaunglwin");
        driver.findElement(By.id("txtPhone")).sendKeys("09685203352");

        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();

        driver.findElement(By.id("com_accountkit_next_button")).click();

        Activity activity = new Activity("com.android.mms", "com.android.mms.ui.ConversationList");
        activity.setStopApp(false);
        driver.startActivity(activity);

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.mms:id/from']")).click();
//        String OTPText = driver.findElementById("content_text_view").getText();
        String OTPText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.mms:id/text_view']")).getText();

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
