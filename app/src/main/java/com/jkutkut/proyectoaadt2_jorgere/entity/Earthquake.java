package com.jkutkut.proyectoaadt2_jorgere.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "earthquakes",
    indices = {
        @Index(
            value = {"name"},
            unique = true
        )
    }
)
public class Earthquake {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "timedate")
    public String timedate;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @NonNull
    @ColumnInfo(name = "magnitude")
    public float magnitude;

    @NonNull
    @ColumnInfo(name = "coordinates")
    public String coordinates;

    @NonNull
    @ColumnInfo(name = "place")
    public String place;

    @NonNull
    @ColumnInfo(name = "deaths")
    public String deaths;

    public Earthquake(
        @NonNull String timedate,
        @NonNull Float magnitude,
        @NonNull String name,
        @NonNull String coordinates,
        @NonNull String place,
        @NonNull String deaths
    ) {
        this.timedate = timedate;
        this.name = name;
        this.magnitude = magnitude;
        this.coordinates = coordinates;
        this.place = place;
        this.deaths = deaths;
    }

}
