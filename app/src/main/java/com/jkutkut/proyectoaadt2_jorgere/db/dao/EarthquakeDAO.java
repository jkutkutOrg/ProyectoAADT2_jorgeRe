package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

import java.util.List;

@Dao
public interface EarthquakeDAO {
    @Query("SELECT * FROM " + Earthquake.TABLE_NAME)
    List<Earthquake> getAll();

    @RawQuery
    List<Earthquake> getAllByMagnitude(SupportSQLiteQuery query);
    default List<Earthquake> getAllByMagnitude(String operator, float magnitude) {
        String query = String.format(
            "SELECT * FROM %s WHERE %s %s ?",
            Earthquake.TABLE_NAME,
            Earthquake.COLUMN_MAGNITUDE,
            operator
            // Not using magnitude here to prevent SQL injection
        );
        return getAllByMagnitude(new SimpleSQLiteQuery(
            query,
            new Object[]{magnitude}
        ));
    }

    @Query(
        "SELECT * FROM " + Earthquake.TABLE_NAME + " e, " + AffectedCountry.TABLE_NAME + " c " +
        " WHERE " + "e." + Earthquake.COLUMN_TIMEDATE + " = " + "c." + AffectedCountry.COLUMN_TIMEDATE +
        " AND " + "c." + AffectedCountry.COLUMN_COUNTRY + " = :country"
    )
    List<Earthquake> getAllByCountry(String country);

    @RawQuery
    List<Earthquake> getAllByMagnitudeAndCountry(SupportSQLiteQuery query);
    default List<Earthquake> getAllByMagnitudeAndCountry(String operator, float magnitude, String country) {
        String query = String.format(
            "SELECT * FROM %s e, %s c " +
            " WHERE " + "e." + Earthquake.COLUMN_TIMEDATE + " = " + "c." + AffectedCountry.COLUMN_TIMEDATE +
            " AND " + "c." + AffectedCountry.COLUMN_COUNTRY + " = ?" +
            " AND " + "e." + Earthquake.COLUMN_MAGNITUDE + " %s ?",
            Earthquake.TABLE_NAME,
            AffectedCountry.TABLE_NAME,
            operator
            // Not using magnitude nor country here to prevent SQL injection
        );
        return getAllByMagnitudeAndCountry(new SimpleSQLiteQuery(
            query,
            new Object[]{country, magnitude}
        ));
    }

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertAll(List<Earthquake> earthquakes);
}
