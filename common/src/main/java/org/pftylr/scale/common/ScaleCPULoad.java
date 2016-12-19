package org.pftylr.scale.common;

import static org.pftylr.scale.common.ScaleLogging.*;

public class ScaleCPULoad {

    Double factor;
    
    public ScaleCPULoad() {
	factor = findAverageFactor(10000000, 100);
    }
    
    public void load(long t) {
	
	long n = (long) ((double) t * factor);
	debug("load = t: " + t + ", n: "+ n);
	
	loadCPU(n);
    }
    
    
    private double findAverageFactor(long n, int s) {	
	
	double totalFactors = 0.0;
	for (int i = 0; i < s; i++) {
	    totalFactors += findFactor(n);	   
	}
	
	double averageFactor = totalFactors / (double) s;
	
	debug("averageFactor: " + averageFactor);
	
	return averageFactor;
	
    }
    
    private double findFactor(long n) {
	
	long t = timeLoadCPU(n);
		
	double f = (double) n / (double) t;
	
	debug("CPU time - n: " + n + ", t: " + t + ", f: " + f);
	
	return f;
    }

    private long timeLoadCPU(long n) {
	long before = System.currentTimeMillis();	
	loadCPU(n);
	long after = System.currentTimeMillis();
	
	return after - before;
    }
	
    private void loadCPU(long n) {
	long count = 0;
	for (long i = 0L; i < n; i++) {
	    count = count + i * n;
	}
    }
    
    
    

}
    