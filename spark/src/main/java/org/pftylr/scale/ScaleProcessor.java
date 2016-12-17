package org.pftylr.scale;

import static org.pftylr.scale.ScaleLogging.*;

public class ScaleProcessor {

    ScaleConfig config;

    public ScaleProcessor(ScaleConfig config) {
	this.config = config;

    }

    public ScaleConfig getConfig() {
        return config;
    }

    public String request(String request) {

	debug("request " + request);

	return request + " RESPOSNE";
    }

}
    