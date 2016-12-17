package org.pftylr.scale;

public class ScaleLogging {

    private static boolean debugEnabled = true;

    public static void info(String msg) {
	
	System.out.println("+ " + msg);
    }

    public static void debug(String msg) {
	if (debugEnabled) {
	    info(msg);
	}
    }

    public static void setDebugEnabled(boolean b) {
        debugEnabled = b;
    }

    public static void error(String msg, Throwable t) {
	info("ERROR " + msg);
    }
}