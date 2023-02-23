package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

import java.util.List;

@Dao
public interface EarthquakeDAO {
    @Query("SELECT * FROM " + Earthquake.TABLE_NAME)
    List<Earthquake> getAll();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertAll(List<Earthquake> earthquakes);
}
