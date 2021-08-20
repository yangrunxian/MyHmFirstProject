package com.example.httplibrary.exception;

public class CreateErrorException extends Exception{
    public CreateErrorException() {
        super("創建網絡連接失敗");
    }
}
