package com.juanjose.rappiapp.model.dao;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.juanjose.rappiapp.model.dao.daoListener.onListener;
import com.juanjose.rappiapp.model.dto.MainDto;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by Juan José on 25/02/2017.
 */

public class ManagerConnection {

    private String path = "http://www.codemobiles.com/adhoc/feed/youtubes.json";
    OkHttpClient client;
    String response;

    public void sendRequest(final onListener listener){

        new Handler(Looper.myLooper()).post(new Runnable() {
            @Override
            public void run() {
                /*
                client = new OkHttpClient();

                try {
                    response = ApiCall.GET(client, path);
                    Gson gson = new GsonBuilder().create();
                    Type listType = new TypeToken<List<MainDto>>() {}.getType();
                    List<MainDto>posts = gson.fromJson(response, listType);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                String data = "hola mundo con listener";
                listener.onWebServiceResponse(data);
            }
        });
    }
}
