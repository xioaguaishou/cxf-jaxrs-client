package com.jaxrs.client.vo;

import com.jaxrs.client.pojo.User;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(User.class)
public class Result<T> {
    public Result() {
    }

    public Result(HttpStatus state, String message) {
        this.state = state;
        this.message = message;
    }

    public Result(HttpStatus state, List<T> items) {
        this.state = state;
        this.items = items;
    }

    public Result(HttpStatus state, T t) {
        this.state = state;
        this.t = t;
    }

    private HttpStatus state = HttpStatus.OK;
    private String message;
    private T t;
    private List<T> items;

    public HttpStatus getState() {
        return state;
    }

    public void setState(HttpStatus state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", t=" + t +
                ", items=" + items +
                '}';
    }
}
