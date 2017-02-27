package com.juanjose.rappiapp.model.dto;

import java.util.List;

/**
 * Created by Juan José on 26/02/2017.
 */

public class MainDto {

    private Feed feed;

    public List<AppInfo> getInfo() {
        return feed.getInfo();
    }
}
