package org.pftylr.scale.common;

import java.util.Random;
import java.util.Date;
import com.google.gson.Gson;
import static org.pftylr.scale.common.ScaleLogging.*;

public class ScaleProcessor {

    ScaleConfig config;
    Gson gson;
    Random rng;

    public ScaleProcessor(ScaleConfig config) {
	this.config = config;
	
	gson = new Gson();
	rng = new Random(new Date().getTime());

    }

    public ScaleConfig getConfig() {
        return config;
    }

    public String request(String requestBody) {

	long before = System.currentTimeMillis();

	debug("requestBody: " + requestBody);

	ScaleRequest request = gson.fromJson(requestBody, ScaleRequest.class);
	
	ScaleResponse response = process(request);
	
	

	long after = System.currentTimeMillis();
	response.setTime(after - before);

	debug("response: " + response);

	return gson.toJson(response);
    }

    private ScaleResponse process(ScaleRequest request) {

	debug("request: " + request);

	processData(request);
	processDelay(request);

	ScaleResponse response = new ScaleResponse();
	response.setStatus(true);
	
	return response;
    }

    private void processDelay(ScaleRequest request) {

	long time = randomBetween(request.getMinTime(), request.getMaxTime());
        debug("processDelay: " + time);

		config.getHandler().sleep(time);
    }

    private void processData(ScaleRequest request) {

	long size = randomBetween(request.getMinDataSize(), request.getMaxDataSize());
    	
	debug("processData: " + size);

	byte[] bytes = new byte[(int)size];
	rng.nextBytes(bytes);
    }
    
    private long randomBetween(long min, long max) {
	long b = 0;
	if (min != max) {
	    b = Math.abs(rng.nextLong()) % (max - min);
	}
	return b + min;		
    }
	

}
    