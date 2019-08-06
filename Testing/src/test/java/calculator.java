import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class calculator {

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
        caps.setCapability("newCommandTimeout","300");
        caps.setCapability("appPackage", "com.mobile.legends");
        caps.setCapability("appActivity", "com.moba.unityplugin.MobaGameMainActivity");
        caps.setCapability("noReset","true");


        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    }

    @Test()
    public void test() throws Exception{


    }
}
