package ru.inno.edu.task5.dto;

import ru.inno.edu.task5.model.TppProductRegisterModel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Response {

    private TppProductRegisterModel data;

    private Map<String, Object> errInfo = new LinkedHashMap<>();

    public Response() {
    }

    public Response(TppProductRegisterModel data) {
        this.data = data;
    }

    public Response(Map<String, Object> errInfo) {
        this.errInfo = errInfo;
    }
    public Response(String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message:", message);

        this.errInfo = body;

    }

    public TppProductRegisterModel getData() {
        return data;
    }

    public Map<String, Object> getErrInfo() {
        return new HashMap<>(errInfo);
    }
}
