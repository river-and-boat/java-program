package model;

import java.io.Serializable;

public class ResultTO<T> implements Serializable {
    private Boolean success;
    private String message;
    private T data;

    public ResultTO() {
    }

    public ResultTO(final Boolean success, final String message, final T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public static <T> ResultTO<T> buildSuccess(T data) {
        ResultTO<T> result = new ResultTO<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> ResultTO<T> buildFailed(T data) {
        ResultTO<T> result = new ResultTO<>();
        result.setSuccess(false);
        result.setMessage("failed");
        result.setData(data);
        return result;
    }
}
