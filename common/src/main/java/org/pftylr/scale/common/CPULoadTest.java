package org.pftylr.scale.common;

public class CPULoadTest {

    public static void main(String[] args) {

	System.out.println("initialising CPU load");
	ScaleCPULoad cpuLoad = new ScaleCPULoad();
	
	System.out.println("Starting tests...");
	test(cpuLoad, 10);
	test(cpuLoad, 50);
	test(cpuLoad, 100);
	test(cpuLoad, 250);
	test(cpuLoad, 500);
	test(cpuLoad, 1000);
	test(cpuLoad, 1300);
	test(cpuLoad, 1780);
	test(cpuLoad, 1780);
	test(cpuLoad, 1950);
	test(cpuLoad, 2000);
	
	System.out.println("Tests done");
	
    }
    
    private static void test(ScaleCPULoad cpuLoad, long t) {
	
	long before = System.currentTimeMillis();
	
	cpuLoad.load(t);
	
	long after = System.currentTimeMillis();
	
	long elapsed = after - before;
	
	long diff = elapsed - t;
	
	double percent = (diff / (double) t) * 100.0;
	
	System.out.println("expected " + t + " (ms), actual = " + elapsed + " (ms), difference = " + diff + " (ms) " + percent + "%");
	
    }
}
