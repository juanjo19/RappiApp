package com.juanjose.rappiapp.model.dto.JsonComponents;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */
public class AppImage {

    @SerializedName("label")
    private String url;

    public String getUrl() {
        return url;
    }
}
