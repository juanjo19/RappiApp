package com.juanjose.rappiapp.model.dto.JsonComponents.category;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */

public class AppCategoryAttribute {

    @SerializedName("im:id")
    private String id;

    private String term;

    private String scheme;

    private String label;

    public String getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public String getScheme() {
        return scheme;
    }

    public String getLabel() {
        return label;
    }
}
