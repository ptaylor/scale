package org.pftylr.scale;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Parser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.GnuParser;

import static org.pftylr.scale.ScaleLogging.*;

public class ScaleConfig {

    int port = 8080;

    boolean debug = false;

    public ScaleConfig(String args[]) {

	
	for (String arg: args) {
	    debug("arg: " + arg);
	}
	try {
	    Options options = new Options();
	    options.addOption(new Option("p", "port", true, "server port"))
		.addOption(new Option("d", "debug", false, "debug enabled"));
	    
	    Parser parser = new GnuParser();
	    CommandLine cmd = parser.parse(options, args);
	    
	    
	    if (cmd.hasOption("p")) {
		System.out.println("XX " + cmd.getOptionValue("p"));
		port = Integer.parseInt(cmd.getOptionValue("p").trim());
	    }
	    
	    if (cmd.hasOption("d")) {
		debug = true;
	    }
	} catch (ParseException e) {
	    error("" + e, e);
	    throw new IllegalArgumentException();
	}
	    

    }

    public int getPort() {
        return port;
    }

    public boolean getDebug() {
	return debug;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{\n")
	    .append("  port:  ").append(port).append("\n")
	    .append("  debug: ").append(debug).append("\n")
	    .append("}");
	return sb.toString();
    }
}
    