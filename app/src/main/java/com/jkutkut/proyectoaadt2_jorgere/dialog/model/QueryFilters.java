package com.jkutkut.proyectoaadt2_jorgere.dialog.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class QueryFilters implements Parcelable {

    private boolean filterByMagnitude;
    private boolean filterByCountry;

    private String magnitudeOperator;
    private Float magnitudeValue;

    private String country;
    private final String[] countries;

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

    protected QueryFilters(Parcel in) {
        filterByMagnitude = in.readByte() != 0;
        filterByCountry = in.readByte() != 0;
        magnitudeOperator = in.readString();
        if (in.readByte() == 0) {
            magnitudeValue = null;
        } else {
            magnitudeValue = in.readFloat();
        }
        country = in.readString();
        countries = in.createStringArray(); // TODO
    }

    public static final Creator<QueryFilters> CREATOR = new Creator<QueryFilters>() {
        @Override
        public QueryFilters createFromParcel(Parcel in) {
            return new QueryFilters(in);
        }

        @Override
        public QueryFilters[] newArray(int size) {
            return new QueryFilters[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0x0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dest.writeBoolean(filterByMagnitude);
            dest.writeBoolean(filterByCountry);
        }
        else {
            dest.writeByte((byte) (filterByMagnitude ? 0b1 : 0b0));
            dest.writeByte((byte) (filterByCountry ? 0b1 : 0b0));
        }
        dest.writeString(magnitudeOperator);
        dest.writeSerializable(magnitudeValue);
        dest.writeString(country);
        dest.writeStringArray(countries);
    }
}
