package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.util.Random;


public class MonkeySubmitEvent extends MonkeyEvent {
    private AndroidDriver driver;
    private int submitX_mim, submitX_max, submitY_mim, submitY_max;

    public MonkeySubmitEvent(AndroidDriver driver, int submitX_mim, int submitX_max, int submitY_mim, int submitY_max) {
        super(MonkeyEvent.EVENT_TYPE_SUBMIT);
        this.submitX_max = submitX_max;
        this.submitX_mim = submitX_mim;
        this.submitY_max = submitY_max;
        this.submitY_mim = submitY_mim;
        this.driver = driver;

    }

    public int injectEvent() throws Exception {
        Random random = new Random();
        int x = random.nextInt(submitX_max) % (submitX_max - submitX_mim + 1) + submitX_mim;
        int y = random.nextInt(submitY_max) % (submitY_max - submitY_mim + 1) + submitY_mim;
        System.out.println("sending Event : Submit->(" + x + "," + y + ")");
        TouchAction action = new TouchAction(driver);
        PointOption option = new PointOption();
        action.tap(option.point(x, y)).perform();
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }


}
