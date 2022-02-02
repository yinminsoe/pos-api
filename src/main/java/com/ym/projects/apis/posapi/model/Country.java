package com.ym.projects.apis.posapi.model;


public enum Country {
     MY("MYANMAR"), SG("SINGAPORE");
    public final String countryName;

    private Country(String countryName){
        this.countryName = countryName;
    }
}
