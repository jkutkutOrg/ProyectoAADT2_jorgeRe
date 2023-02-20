package com.jkutkut.proyectoaadt2_jorgere.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (
    tableName = "affected_countries",
    primaryKeys = {"timedate", "country"},
    foreignKeys = {
        @ForeignKey(
            entity = Earthquake.class,
            parentColumns = "timedate",
            childColumns = "timedate",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class AffectedCountry {

    @NonNull
    @ColumnInfo(name = "timedate")
    public String timedate;

    @NonNull
    @ColumnInfo(name = "country")
    public String country;

    public AffectedCountry(
        @NonNull String timedate,
        @NonNull String country
    ) {
        this.timedate = timedate;
        this.country = country;
    }
}
