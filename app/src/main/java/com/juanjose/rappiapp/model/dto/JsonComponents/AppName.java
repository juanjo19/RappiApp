package com.juanjose.rappiapp.model.dto.JsonComponents;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */

public class AppName {

    @SerializedName("label")
    private String name;

    public String getName() {
        return name;
    }
}
