package tests;

import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class MonkeySwipeEvent extends MonkeyEvent {
    private int width, height;
    private AndroidDriver driver;


    public MonkeySwipeEvent(AndroidDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_SWIPE);
        this.width = width;
        this.height = height;
        this.driver = driver;

    }

    public int injectEvent() throws Exception {
        double startX = Math.ceil(Math.random() * (width - 1));
        double startY = Math.ceil(Math.random() * (height - 1));
        double endX = Math.ceil(Math.random() * (width - 1));
        double endY = Math.ceil(Math.random() * (height - 1));
        int nanos=(int)(2*1000);
        System.out.println("sending Swipe Event : Swipe-> [start(" + startX + "," + startY + "), end(" + startX + "," + endY+")]");
        TouchAction action=new TouchAction(driver).press(PointOption.point((int)startX,(int)startY)).waitAction(WaitOptions.waitOptions(Duration.ofNanos(nanos))).moveTo(PointOption.point((int)endX,(int)endY)).release().perform();

        return MonkeyEvent.INJECT_SUCCESS;
    }

}
