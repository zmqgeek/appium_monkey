package tests;

import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import util.Shell;


public class MonkeyHomeKeyEvent extends MonkeyEvent{
	private String UDID;	
    private AndroidDriver driver;

    public MonkeyHomeKeyEvent(AndroidDriver driver, String udid) {
        super(MonkeyEvent.EVENT_TYPE_HOMEKEY);
        this.driver = driver;
        this.UDID = udid;
    }


	public int injectEvent() throws Exception{
		System.out.println("sending HOMEKEY Event.");
    	driver.execute(MobileCommand.RUN_APP_IN_BACKGROUND);
    	new Thread(new Runnable() {
            public void run() {
                try {
                    Shell.exec("pkill idevicedebug");
                    System.out.println("idevicedebug stop");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
                try {
                    Shell.exec("idevicedebug -u " + UDID );
                    Thread.sleep(3000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        return MonkeyEvent.INJECT_SUCCESS;
    } 
}
