package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Shell {

    public static void launchAPP(final String UDID) throws IOException, InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                Process pp;
                try {

                    System.out.println("=======启动app守护进程=======");
                    pp = Runtime.getRuntime().exec("/usr/local/bin/idevicesyslog -u " + UDID);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pp.getInputStream()));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 30, 10, TimeUnit.SECONDS);
    }

    public static void exec(String command) throws IOException, InterruptedException {
        Process p;
        p = Runtime.getRuntime().exec(command);
        p.waitFor();
        p.destroy();
    }
}

