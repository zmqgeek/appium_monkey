package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MonkeyBackEvent extends MonkeyEvent {
    private int backX, backY;
    private AndroidDriver driver;

    public MonkeyBackEvent(AndroidDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_BACK);
        this.backX = width;
        this.backY = height;
        this.driver = driver;
    }

    public int injectEvent() throws Exception {
        System.out.println("sending Event : Back->(" + backX + "," + backY + ")");
        TouchAction action = new TouchAction(driver);
        PointOption option = new PointOption();
        action.tap(option.point(backX, backY)).perform();
        return MonkeyEvent.INJECT_SUCCESS;
    }
}
