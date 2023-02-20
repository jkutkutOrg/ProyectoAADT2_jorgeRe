package com.jkutkut.proyectoaadt2_jorgere.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;

import java.util.ArrayList;

@Dao
public interface AffectedCountryDAO {
    @Query("SELECT * FROM " + AffectedCountry.TABLE_NAME)
    public ArrayList<AffectedCountry> getAll();
}
