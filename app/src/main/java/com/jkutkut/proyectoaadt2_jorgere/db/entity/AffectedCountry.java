package com.jkutkut.proyectoaadt2_jorgere.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (
    tableName = AffectedCountry.TABLE_NAME,
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
    public static final String TABLE_NAME = "affected_countries";

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
