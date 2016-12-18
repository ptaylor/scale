package org.pftylr.scale.spark;

import org.pftylr.scale.common.ScaleConfig;
import org.pftylr.scale.common.ScaleProcessor;
import static org.pftylr.scale.common.ScaleLogging.*;
import static spark.Spark.*;

public class SparkServer {

    public static void main(String[] args) {

	ScaleConfig config = new ScaleConfig(args);
	ScaleProcessor processor = new ScaleProcessor(config);

        new SparkServer().run(processor);
    }

    private void run(ScaleProcessor processor) {

	ScaleConfig config = processor.getConfig();
	debug("run");
	info("config: " + config);

	port(config.getPort());
	get("/ping", (req, res) -> {
	    info("ping");
	    return "ok";
	});

	post("/request", (req, res) -> {

		try {
		    String response = processor.request(req.body());
		    res.status(200);
		    res.body(response);
		} catch (Exception e) {
                    error("spark server error " + e, e);
		    res.status(500);
		    res.body("error " + e);
		}
		return res.body();
	});


    }
}

