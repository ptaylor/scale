package org.pftylr.scale.spark;

import org.pftylr.scale.common.ScaleConfig;
import org.pftylr.scale.common.ScaleDefaultHandler;
import org.pftylr.scale.common.ScaleProcessor;
import static org.pftylr.scale.common.ScaleLogging.*;
import static spark.Spark.*;

public class SparkServer {

	public static int IDLE_THREAD_TIMEOUT = 1000 * 60;

    public static void main(String[] args) {

	ScaleConfig config = new ScaleConfig(args, new ScaleDefaultHandler());
	ScaleProcessor processor = new ScaleProcessor(config);
		  try {

			  int maxThreads = config.getThreadPoolMax();
			  if (maxThreads < 10) {
				  maxThreads = 10;
			  }
			  info("threadPoolMax: " + maxThreads);
			  info("threadPoolMin: " + config.getThreadPoolMin());

			  threadPool(maxThreads, config.getThreadPoolMin(), IDLE_THREAD_TIMEOUT);
			  new SparkServer().run(processor);

		  } catch (Throwable t) {
			  info("exception " + t);
		  }
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

