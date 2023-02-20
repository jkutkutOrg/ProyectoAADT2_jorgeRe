package com.jkutkut.proyectoaadt2_jorgere.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jkutkut.proyectoaadt2_jorgere.db.dao.AffectedCountryDAO;
import com.jkutkut.proyectoaadt2_jorgere.db.dao.EarthquakeDAO;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

@Database(entities = {Earthquake.class, AffectedCountry.class}, version = 1)
public abstract class EarthquakeDB extends RoomDatabase {

    public abstract EarthquakeDAO earthquakeDAO();
    public abstract AffectedCountryDAO affectedCountryDAO();

    private static EarthquakeDB instance;

    public static EarthquakeDB getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(
                context.getApplicationContext(),
                EarthquakeDB.class,
                "earthquake.db"
            ).allowMainThreadQueries().build();
        return instance;
    }
}
