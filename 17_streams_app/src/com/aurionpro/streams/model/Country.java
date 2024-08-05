package com.aurionpro.streams.model;

public class Country {
    private String countryCode;
    private String countryName;
    private int regionId;

    public Country(String countryCode, String countryName, int regionId) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getRegionId() {
        return regionId;
    }

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryName=" + countryName + ", regionId=" + regionId + "]";
	}

}

