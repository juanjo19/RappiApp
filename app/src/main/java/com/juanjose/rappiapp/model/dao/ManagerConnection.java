package com.juanjose.rappiapp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.juanjose.rappiapp.model.dao.daoListener.onListener;
import com.juanjose.rappiapp.model.dto.AppInfo;
import com.juanjose.rappiapp.model.dto.MainDto;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Juan José on 25/02/2017.
 */

public class ManagerConnection {

    private String path = "http://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";
    OkHttpClient client;
    String response;
    MainDto mainDto;
    protected Context context;

    public void sendRequest(final onListener listener){

        /*
        new Handler(Looper.myLooper()).post(new Runnable() {
            @Override
            public void run() {

                client = new OkHttpClient();

                try {
                    response = ApiCall.GET(client, path);
                    Gson gson = new GsonBuilder().create();
                    Type listType = new TypeToken<List<MainDto>>() {}.getType();
                    posts = gson.fromJson(response, listType);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                listener.onWebServiceResponse(posts);
            }
        });*/

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    client = new OkHttpClient();
                    response = ApiCall.GET(client, path);
                    Gson gson = new GsonBuilder().create();
                    mainDto = gson.fromJson(response, MainDto.class);
                    saveElement(mainDto);
                    //listener.onWebServiceResponse(mainDto);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }).start();
    }

    private void saveElement(MainDto param){
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(context.getApplicationContext(), "administrator", null, 1);
        SQLiteDatabase db = adminSQLiteOpenHelper.getWritableDatabase();
        db.execSQL("drop table if exists elements");
        List <AppInfo> list = param.getInfo();
        ContentValues register = new ContentValues();
        for (int i = 0; i < list.size(); i++ ) {
            register.put("category", list.get(i).getCategory());
            register.put("title", list.get(i).getTitle());
        }
        db.insert("elements", null, register);
        db.close();
    }

    //TODO metodo para verificar si hay conexion a internet
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void consultElements(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context.getApplicationContext(), "administrator", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("select category from elements where category = Social Networking", null);
    }



}
