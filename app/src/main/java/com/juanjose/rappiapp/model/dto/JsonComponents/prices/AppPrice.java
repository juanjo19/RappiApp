package com.juanjose.rappiapp.model.dto.JsonComponents.prices;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan José on 26/02/2017.
 */
public class AppPrice {

    @SerializedName("attributes")
    private AppPriceAttribute attribute;

    public String getAmount() {
        return attribute != null ? attribute.getAmount() : "";
    }

    public String getCurrency() {
        return attribute != null ? attribute.getCurrency() : "";
    }
}
