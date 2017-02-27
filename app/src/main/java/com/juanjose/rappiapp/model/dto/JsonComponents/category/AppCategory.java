package com.juanjose.rappiapp.model.dto.JsonComponents.category;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */

public class AppCategory {

    @SerializedName("attributes")
    private AppCategoryAttribute attribute;

    public String getLabel() {
        return attribute != null ? attribute.getLabel() : "";
    }
}
