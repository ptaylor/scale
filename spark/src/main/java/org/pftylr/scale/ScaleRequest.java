package org.pftylr.scale;

public class ScaleRequest {

    int minTime;
    int maxTime;

    public ScaleRequest() {
    }

    public int getMinTime() {
	return minTime;
    }


    public int getMaxTime() {
	return maxTime;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{\n")
	    .append("  ").append("minTime: ").append(minTime).append("\n")
	    .append("  ").append("maxTime: ").append(maxTime).append("\n")
	    .append("}");
	return sb.toString();
    }
}