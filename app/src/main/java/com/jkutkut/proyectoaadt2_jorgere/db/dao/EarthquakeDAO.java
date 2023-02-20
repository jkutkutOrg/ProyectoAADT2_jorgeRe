package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

import java.util.ArrayList;

@Dao
public interface EarthquakeDAO {
    @Query("SELECT * FROM " + Earthquake.TABLE_NAME)
    public ArrayList<Earthquake> getAll();
}
