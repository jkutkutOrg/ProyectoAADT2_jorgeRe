package com.jkutkut.proyectoaadt2_jorgere.dialog.model;

import java.util.ArrayList;

public class QueryFilters {
    private boolean filterByMagnitude;
    private boolean filterByCountry;

    private String magnitudeOperator;
    private Float magnitudeValue;

    private String country;
    private String[] countries;

    public QueryFilters(String[] countries) {
        filterByMagnitude = false;
        filterByCountry = false;

        magnitudeOperator = null;
        magnitudeValue = null;

        country = null;
        this.countries = countries;
    }

    public QueryFilters(ArrayList<String> countries) {
        this(countries.toArray(new String[0]));
    }

                        // GETTERS
    public boolean isFilterByMagnitude() {
        return filterByMagnitude;
    }

    public boolean isFilterByCountry() {
        return filterByCountry;
    }

    public String getMagnitudeOperator() {
        return magnitudeOperator;
    }

    public Float getMagnitudeValue() {
        return magnitudeValue;
    }

    public String getCountry() {
        return country;
    }

    public String[] getCountries() {
        return countries;
    }

    // SETTERS
    public void setFilterByMagnitude(boolean filterByMagnitude) {
        this.filterByMagnitude = filterByMagnitude;
    }

    public void setFilterByCountry(boolean filterByCountry) {
        this.filterByCountry = filterByCountry;
    }

    public void setMagnitudeOperator(String magnitudeOperator) {
        this.magnitudeOperator = magnitudeOperator;
    }

    public void setMagnitudeValue(Float magnitudeValue) {
        this.magnitudeValue = magnitudeValue;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }
}
