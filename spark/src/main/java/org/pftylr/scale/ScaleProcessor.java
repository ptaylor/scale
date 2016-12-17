package org.pftylr.scale;

import java.util.Random;
import java.util.Date;
import com.google.gson.Gson;
import static org.pftylr.scale.ScaleLogging.*;

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

	long time = rng.nextInt(request.maxTime - request.minTime) + request.minTime;
	try {
	    debug("sleeping: " + time);
	    Thread.sleep(time);
	} catch (InterruptedException e) {
	    // Ignore
	}

	ScaleResponse response = new ScaleResponse();
	response.setStatus(true);
	
	return response;
    }
	

}
    