package com.modernjava.threads;

import com.modernjava.util.CommonUtil;
import static com.modernjava.util.LoggerUtil.log;

public class ExploreThreads {
    public static void doSomeWork() {
        log("started doSomeWork");
        CommonUtil.sleep(1000);
        log("finished doSomeWork");

    }

    public static void main(String[] args) {
        // Gives uss instance of the platform Thread!
        var thread1 = Thread.ofPlatform().name("T1");
        var thread2 = Thread.ofPlatform().name("T2");

        thread1.start(() -> {
            log("Run task 1 in the background!");
        });

        thread2.start(() -> {
            ExploreThreads.doSomeWork();
        });

        log("Program Completed!");
    }
}
