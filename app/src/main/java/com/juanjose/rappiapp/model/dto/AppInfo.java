package com.juanjose.rappiapp.model.dto;

import com.google.gson.annotations.SerializedName;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppArtist;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppImage;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppName;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppRights;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppSummary;
import com.juanjose.rappiapp.model.dto.JsonComponents.AppTitle;
import com.juanjose.rappiapp.model.dto.JsonComponents.category.AppCategory;
import com.juanjose.rappiapp.model.dto.JsonComponents.prices.AppPrice;
import com.juanjose.rappiapp.model.dto.JsonComponents.release.AppReleaseDate;

import java.util.List;

/**
 * Created by Juan José on 26/02/2017.
 */

public class AppInfo {

    private AppSummary summary;
    private AppRights rights;
    private AppCategory category;

    @SerializedName("title")
    private AppTitle appTitle;

    @SerializedName("im:name")
    private AppName appName;

    @SerializedName("im:image")
    private List<AppImage> images;

    @SerializedName("im:artist")
    private AppArtist artist;

    @SerializedName("im:price")
    private AppPrice price;

    @SerializedName("im:releaseDate")
    private AppReleaseDate releaseDate;


    public String getName() {
        return appName != null ? appName.getName() : "";
    }

    public String getAuthorName() {
        return artist != null ? artist.getLabel() : "";
    }

    public String getTitle() {
        return appTitle != null ? appTitle.getLabel() : "";
    }

    public String getSmallThumbnailUrl() {
        // Api always returns 3 images: 53px, 75px and 100px
        return images != null && !images.isEmpty() && images.size() == 3 ? images.get(0).getUrl() : "";
    }

    public String getMediumThumbnailUrl() {
        return images != null && !images.isEmpty() && images.size() == 3 ? images.get(1).getUrl() : "";
    }

    public String getBigThumbnailUrl() {
        return images != null && !images.isEmpty() && images.size() == 3 ? images.get(2).getUrl() : "";
    }

    public String getSummary() {
        return summary != null ? summary.getLabel() : "";
    }

    public String getPrice() {
        return price != null ? (price.getCurrency() + " " + price.getAmount()) : "";
    }

    public String getRights() {
        return rights != null ? rights.getLabel() : "";
    }

    public String getCategory() {
        return category != null ? category.getLabel() : "";
    }

    public String getReleaseDate() {
        return releaseDate != null ? releaseDate.getDate() : "";
    }
}
