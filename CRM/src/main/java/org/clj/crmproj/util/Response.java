package org.clj.crmproj.util;

/**
 * Created by Administrator on 2017/2/9.
 */
public class Response {

    private String status = "S";
    private String errorMessage;
    private Object output;

    public Response() {
    }

    public Response(String errorMessage) {
        this.setStatus("E");
        this.setErrorMessage(errorMessage);
    }

    public Response(String status, String errorMessage) {
        this.setStatus(status);
        this.setErrorMessage(errorMessage);
    }

    public Response(Object output) {
        this.setOutput(output);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

}
