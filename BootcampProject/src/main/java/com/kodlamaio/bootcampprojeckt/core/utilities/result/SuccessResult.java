package com.kodlamaio.bootcampprojeckt.core.utilities.result;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }


}
