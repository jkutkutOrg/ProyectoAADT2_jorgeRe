package com.jkutkut.proyectoaadt2_jorgere.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
    tableName = Earthquake.TABLE_NAME,
    indices = {
        @Index(
            value = {Earthquake.COLUMN_TIMEDATE},
            unique = true
        )
    }
)
public class Earthquake implements Serializable {
    public static final String TABLE_NAME = "earthquakes";

    public static final String COLUMN_TIMEDATE = "timedate";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MAGNITUDE = "magnitude";
    public static final String COLUMN_COORDINATES = "coordinates";
    public static final String COLUMN_PLACE = "place";
    public static final String COLUMN_DEATHS = "deaths";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = COLUMN_TIMEDATE)
    public String timedate;

    @NonNull
    @ColumnInfo(name = COLUMN_NAME)
    public String name;

    @NonNull
    @ColumnInfo(name = COLUMN_MAGNITUDE)
    public float magnitude;

    @NonNull
    @ColumnInfo(name = COLUMN_COORDINATES)
    public String coordinates;

    @NonNull
    @ColumnInfo(name = COLUMN_PLACE)
    public String place;

    @NonNull
    @ColumnInfo(name = COLUMN_DEATHS)
    public String deaths;

    public Earthquake(
        @NonNull String timedate,
        @NonNull Float magnitude,
        @NonNull String name,
        @NonNull String place,
        @NonNull String coordinates,
        @NonNull String deaths
    ) {
        this.timedate = timedate;
        this.name = name;
        this.magnitude = magnitude;
        this.coordinates = coordinates;
        this.place = place;
        this.deaths = deaths;
    }

    // GETTERS
    public String getTimedate() {
        return timedate;
    }

    public String getName() {
        return name;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getPlace() {
        return place;
    }

    public String getDeaths() {
        return deaths;
    }
}
