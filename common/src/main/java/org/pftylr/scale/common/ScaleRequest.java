package org.pftylr.scale.common;

public class ScaleRequest {

    private long minTime = 0;
    private long maxTime = 0;
    private long minDataSize = 0;
    private long maxDataSize = 0;

    public ScaleRequest() {
    }

    public long getMinTime() {
	return minTime;
    }

    public long getMaxTime() {
	return maxTime;
    }

    public long getMinDataSize() {
	return minDataSize;
    }

    public long getMaxDataSize() {
	return maxDataSize;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{\n")
	    .append("  ").append("minTime:      ").append(minTime).append("\n")
	    .append("  ").append("maxTime:      ").append(maxTime).append("\n")
	    .append("  ").append("minDataSize:  ").append(minDataSize).append("\n")
	    .append("  ").append("maxDataSize:  ").append(maxDataSize).append("\n")
	    .append("}");
	return sb.toString();
    }
}