package com.topup.demo.exception;

public class WalletNotFoundException extends Exception {

    public WalletNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
