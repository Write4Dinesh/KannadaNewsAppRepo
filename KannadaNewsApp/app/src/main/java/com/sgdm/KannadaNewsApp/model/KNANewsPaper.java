package com.sgdm.KannadaNewsApp.model;

import java.io.Serializable;

/**
 * Created by dinesh.k.masthaiah on 23-03-2016.
 */
public class KNANewsPaper implements Serializable {
    private String mName;
    private String mUrl;

    public KNANewsPaper(String name, String url) {
        mName = name;
        mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}

