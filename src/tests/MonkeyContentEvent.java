package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.util.Random;


public class MonkeyContentEvent extends MonkeyEvent{

    private AndroidDriver driver;
    private int contentX_min, contentX_max, contentY_mim, contentY_max;

    public MonkeyContentEvent(AndroidDriver driver, int submitX_mim, int submitX_max, int submitY_mim, int submitY_max) {
        super(MonkeyEvent.EVENT_TYPE_CONTENT);
        this.contentX_max = submitX_max;
        this.contentX_min = submitX_mim;
        this.contentY_max = submitY_max;
        this.contentY_mim = submitY_mim;
        this.driver = driver;
    }

    public int injectEvent() throws Exception {
        Random random = new Random();
        int x = random.nextInt(contentX_max) % (contentX_max - contentX_min + 1) + contentX_min;
        int y = random.nextInt(contentY_max) % (contentY_max - contentY_mim + 1) + contentY_mim;
        System.out.println("sending Event : Content->(" + x + "," + y + ")");
        TouchAction action = new TouchAction(driver);
        PointOption option = new PointOption();
        action.tap(option.point(x,y)).perform();
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }
}
