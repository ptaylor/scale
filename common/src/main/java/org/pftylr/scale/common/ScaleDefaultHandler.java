package org.pftylr.scale.common;

import static org.pftylr.scale.common.ScaleLogging.*;

public class ScaleDefaultHandler implements ScaleHandler {

    public void sleep(long msecs) {
           debug("sleep " + msecs + "(ms)");

        try {
            Thread.sleep(msecs);
        } catch (InterruptedException e) {
            error("sleep interrupted", e);
            // Ignore
        }

    }
}
