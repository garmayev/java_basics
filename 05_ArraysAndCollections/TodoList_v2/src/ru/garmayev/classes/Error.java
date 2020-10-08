package ru.garmayev.classes;

import java.util.Formatter;

public class Error {
    private String message;
    private int code;

    public Error()
    {
        this.setMessage("");
        this.setCode(0);
    }

    public Error(String message)
    {
        this.setMessage(message);
    }

    public Error(int code)
    {
        this.setCode(code);
    }

    public Error(String message, int code)
    {
        this.setMessage(message);
        this.setCode(code);
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return this.code;
    }

    public String toString()
    {
        Formatter f = new Formatter(); // объявление объекта

        // форматирование текста по формату %S, %c

        return f.format("Ошибка #%d: %S", this.getCode(), this.getMessage()).toString();

    }
}
