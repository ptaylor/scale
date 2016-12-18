package org.pftylr.scale.common;

public class ScaleResponse {

    private boolean status;
    private long time;

    public ScaleResponse() {
    }

    public ScaleResponse setStatus(boolean b) {
	status = b;
	return this;
    }

    public ScaleResponse setTime(long t) {
	time = t;
	return this;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{\n")
	    .append("  ").append("status: ").append(status).append("\n")
	    .append("  ").append("time:   ").append(time).append("\n")
	    .append("}");
	return sb.toString();
    }
}