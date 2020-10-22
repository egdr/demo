package com.example.demo.core.res;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhang
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static <T>Result<T> genEnumResult(ResultCode resultCode) {
        return new Result()
                .setCode(resultCode)
                .setMessage(resultCode.msg());
    }

    public static <T>Result<T> genEnumResult(ResultCode resultCode,T data) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSON(data).toString());
            JSONArray records;
            if (jsonObject.containsKey("records")){
                records = jsonObject.getJSONArray("records");
                jsonObject.put("list",records);
                jsonObject.remove("records");
            }
            return new Result()
                    .setCode(resultCode)
                    .setData(jsonObject)
                    .setMessage(resultCode.msg());
        }catch (Exception e){
            return new Result()
                    .setCode(resultCode)
                    .setData(data)
                    .setMessage(resultCode.msg());
        }


    }

}
