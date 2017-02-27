package com.juanjose.rappiapp.model.dto.JsonComponents.release;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */
public class AppReleaseDate {

    @SerializedName("attributes")
    private AppReleaseDateAttribute attribute;

    public String getDate() {
        return attribute != null ? attribute.getLabel() : "";
    }
}
