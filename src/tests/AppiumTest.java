package tests;

import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class AppiumTest {
	
	public static void main(String[] args) {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "a");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android Emulator");
		caps.setCapability("platformVersion", "4.4.2");
		caps.setCapability("appPackage", "com.android.music");
		caps.setCapability("appActivity", "com.android.music.AlbumBrowserActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
}
