package tests;

import util.Shell;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

public class Monkey {

	private AndroidDriver driver;
    //private AppiumDriver<MobileElement> driver;
    private int width, height, submitX_mim, submitX_max, submitY_mim, submitY_max, contentX_mim, contentX_max, contentY_mim, contentY_max, special_point_x, special_point_y;
    private static boolean needhelp = false;
    private static String UDID="emulator-5554";
    private static String PORT = "4327";
    private static String PROXYPORT = "8080";
    private int eventcount = 0;
    private int backX = 25, backY = 40;


    public static void main(String[] args) throws Exception {
    	Monkey m = new Monkey();
    	m.run();
    }
    private void run() throws Exception {
        init();
        width = driver.manage().window().getSize().getWidth();
        height = driver.manage().window().getSize().getHeight();
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        submitX_max = width - 1;
        submitX_mim = width / 10;
        submitY_max = height - 1;
        submitY_mim = height / 10 * 9;

        contentX_max = width - width / 10;
        contentX_mim = width / 10;
        contentY_max = height / 2 + height / 10;
        contentY_mim = height / 2 - height / 10;
        special_point_x = width / 2;
        special_point_y = (int) (height * 0.94);


        while (true) {
            if (eventcount >= 20000) {
                System.out.println("执行完毕，请重新启动再次运行~~~~");
                break;
            }
            Thread.sleep(100);
            switch (new MathRandom().PercentageRandom()) {
                case 0:{ 
                    new MonkeyTapEvent(driver, width, height).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 1: {
                    new MonkeySwipeEvent(driver, width, height).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 2: {
                    new MonkeyBackEvent(driver, backX, backY).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 3: {
                    new MonkeySubmitEvent(driver, submitX_mim, submitX_max, submitY_mim, submitY_max).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 4: {
                    new MonkeyContentEvent(driver, contentX_mim, contentX_max, contentY_mim, contentY_max).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 5: {
                    new MonkeyTapEvent(driver, special_point_x, special_point_y).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
                case 6: {
                    new MonkeyHomeKeyEvent(driver, UDID).injectEvent();
                    eventcount = eventcount + 1;
                    System.out.println("---EVENT执行了：" + eventcount + "次---");
                    break;
                }
            }
        }
    }

    private void init() throws IOException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "a");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android Emulator");
		caps.setCapability("platformVersion", "4.4.2");
		caps.setCapability("appPackage", "com.android.calendar");
		caps.setCapability("appActivity", "com.android.calendar.AllInOneActivity");
		caps.setCapability("noReset", "true");
        try {
            System.out.println("应用启动了~~~");
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("结束了");
        } catch (Exception e) {
            System.out.println("*******************************************\n\n\n" +
                    "请在命令行输入 appium 启动服务\n\n\n" +
                    "*******************************************\n");
        }
        //启动app守护进程
        Shell.launchAPP(UDID);
    }
}