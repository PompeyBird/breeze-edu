package org.bird.breeze.edu.bean.common;

public class BreezeResult<T> {
    private boolean success;
    private String errorMsg;
    private T data;

    public BreezeResult(){
        this.success = true;
    }

    public BreezeResult(String errorMsg){
        this.success = false;
        this.errorMsg = errorMsg;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
