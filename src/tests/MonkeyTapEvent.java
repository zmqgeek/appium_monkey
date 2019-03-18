package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.android.AndroidDriver;


public class MonkeyTapEvent extends MonkeyEvent{
    private int width, height;
    private AndroidDriver driver;


    public MonkeyTapEvent(AndroidDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_TAP);
        this.width = width;
        this.height = height;
        this.driver = driver;
    }

    public int injectEvent() throws Exception {
        int x = (int)Math.ceil(Math.random() * (width - 1));
        int y = (int)Math.ceil(Math.random() * (height - 1));
        System.out.println("sending Tap Event : Tap->(" + x + ", " + y + ")");
        TouchAction action = new TouchAction(driver);
        PointOption option = new PointOption();
        action.tap(option.point(x, y)).perform();
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }
}