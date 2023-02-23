package com.jkutkut.proyectoaadt2_jorgere.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (
    tableName = AffectedCountry.TABLE_NAME,
    primaryKeys = {
        AffectedCountry.COLUMN_TIMEDATE,
        AffectedCountry.COLUMN_COUNTRY
    },
    foreignKeys = {
        @ForeignKey(
            entity = Earthquake.class,
            parentColumns = Earthquake.COLUMN_TIMEDATE,
            childColumns = AffectedCountry.COLUMN_TIMEDATE,
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class AffectedCountry {
    public static final String TABLE_NAME = "affected_countries";

    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_TIMEDATE = "timedate";

    @NonNull
    @ColumnInfo(name = COLUMN_TIMEDATE)
    public String timedate;

    @NonNull
    @ColumnInfo(name = COLUMN_COUNTRY)
    public String country;

    public AffectedCountry(
        @NonNull String timedate,
        @NonNull String country
    ) {
        this.timedate = timedate;
        this.country = country;
    }
}
