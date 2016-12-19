package org.pftylr.scale.common;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Parser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.GnuParser;

import static org.pftylr.scale.common.ScaleLogging.*;

public class ScaleConfig {

    int port = 8080;

    boolean debug = false;
	ScaleHandler handler;
	int threadPoolMin = 4;
	int threadPoolMax = 4;

    public ScaleConfig(String args[], ScaleHandler handler) {


		this.handler = handler;
	
	for (String arg: args) {
	    debug("arg: " + arg);
	}
	try {
	    Options options = new Options();
	    options.addOption(new Option("p", "port", true, "server port"))
		.addOption(new Option("d", "debug", false, "debug enabled"))
				.addOption(new Option("n", "thread-pool-min", true, "thread pool min size"))
				.addOption(new Option("m", "thread-pool-max", true, "thread pool max size"));
		;
	    
	    Parser parser = new GnuParser();
	    CommandLine cmd = parser.parse(options, args);
	    
	    
	    if (cmd.hasOption("p")) {
		port = Integer.parseInt(cmd.getOptionValue("p").trim());
	    }

		if (cmd.hasOption("n")) {
			threadPoolMin = Integer.parseInt(cmd.getOptionValue("n").trim());
		}
		if (cmd.hasOption("m")) {
			threadPoolMax = Integer.parseInt(cmd.getOptionValue("m").trim());
		}


		if (cmd.hasOption("d")) {
		debug = true;
	    }
		ScaleLogging.setDebugEnabled(debug);

	} catch (ParseException e) {
	    error("" + e, e);
	    throw new IllegalArgumentException();
	}
	    

    }

	public ScaleHandler getHandler() {
		return handler;
	}

    public int getPort() {
        return port;
    }

    public boolean getDebug() {
	return debug;
    }

	public int getThreadPoolMin() { return threadPoolMin; }

	public int getThreadPoolMax() { return threadPoolMax; }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{\n")
	    .append("  port:  ").append(port).append("\n")
	    .append("  debug: ").append(debug).append("\n")
	    .append("}");
	return sb.toString();
    }
}
    