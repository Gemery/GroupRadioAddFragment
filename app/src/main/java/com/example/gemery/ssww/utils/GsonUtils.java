package com.example.gemery.ssww.utils;

import java.lang.reflect.Type;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



import com.google.gson.Gson;

import com.google.gson.JsonObject;

import com.google.gson.reflect.TypeToken;

public class GsonUtils {


    public static <T> T parseJSON(String json, Class<T> clazz) {

        Gson gson = new Gson();

        T info = gson.fromJson(json, clazz);

        return info;

    }


    public static <T> T parseJSON(String json, Type type) {

        Gson gson = new Gson();

        T info = gson.fromJson(json, type);

        return info;

    }


    public static <T> List<T> jsonToList(String json, Class<? extends T[]> clazz)

    {

        Gson gson = new Gson();

        T[] array = gson.fromJson(json, clazz);

        return Arrays.asList(array);

    }


    /**
     * @param json
     * @param clazz
     * @return
     */

    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz)

    {

        Type type = new TypeToken<ArrayList<JsonObject>>()

        {
        }.getType();

        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<>();

        for (JsonObject jsonObject : jsonObjects)

        {

            arrayList.add(new Gson().fromJson(jsonObject, clazz));

        }

        return arrayList;

    }

}