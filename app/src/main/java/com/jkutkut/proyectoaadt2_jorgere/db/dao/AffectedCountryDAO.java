package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface AffectedCountryDAO {
    @Query("SELECT * FROM " + AffectedCountry.TABLE_NAME)
    List<AffectedCountry> getAll();

    @Query("SELECT DISTINCT(" + AffectedCountry.COLUMN_COUNTRY + ") FROM " + AffectedCountry.TABLE_NAME)
    List<String> getAllCountries();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertAll(List<AffectedCountry> affectedCountry);
}
