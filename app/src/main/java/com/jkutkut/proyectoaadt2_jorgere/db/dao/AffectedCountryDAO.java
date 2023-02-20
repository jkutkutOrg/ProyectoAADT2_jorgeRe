package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;

import java.util.List;

@Dao
public interface AffectedCountryDAO {
    @Query("SELECT * FROM " + AffectedCountry.TABLE_NAME)
    public List<AffectedCountry> getAll();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public void insert(AffectedCountry affectedCountry);
}
