package com.jkutkut.proyectoaadt2_jorgere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.jkutkut.proyectoaadt2_jorgere.db.EarthquakeDB;
import com.jkutkut.proyectoaadt2_jorgere.db.dao.AffectedCountryDAO;
import com.jkutkut.proyectoaadt2_jorgere.db.dao.EarthquakeDAO;
import com.jkutkut.proyectoaadt2_jorgere.db.data.DataCountries;
import com.jkutkut.proyectoaadt2_jorgere.db.data.DataEarthquakes;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.AffectedCountry;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;
import com.jkutkut.proyectoaadt2_jorgere.dialog.FilterDialog;
import com.jkutkut.proyectoaadt2_jorgere.dialog.FilterDialogListener;
import com.jkutkut.proyectoaadt2_jorgere.dialog.model.QueryFilters;
import com.jkutkut.proyectoaadt2_jorgere.rvUtil.EarthquakeAdapter;

import java.util.ArrayList;

public class QueryActivity extends AppCompatActivity implements FilterDialogListener {

    private Button btnFilterQuery;
    private Button btnQuery;
    private RecyclerView rvQuery;

    private QueryFilters filters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        filters = new QueryFilters();

        btnFilterQuery = findViewById(R.id.btnFilterQuery);
        btnQuery = findViewById(R.id.btnQuery);
        rvQuery = findViewById(R.id.rvQuery);

        btnQuery.setOnClickListener(v -> {
            // TODO
            Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show();
        });
        btnFilterQuery.setOnClickListener(v -> {
            FilterDialog filterDialog = new FilterDialog();
            filterDialog.show(getSupportFragmentManager(), "FilterDialog");
        });

        loadInitialData();

        rvQuery.setLayoutManager(new LinearLayoutManager(this));
        rvQuery.setAdapter(new EarthquakeAdapter(new ArrayList<>()));
        rvQuery.setItemAnimator(new DefaultItemAnimator());

//        EarthquakeDAO cursor = EarthquakeDB.getInstance(this).earthquakeDAO();
//        ArrayList<Earthquake> data = (ArrayList<Earthquake>) cursor.getAll();
//        System.out.println("******** Size: " + data.size() + "**********");
//        for (Earthquake e : data) {
//            System.out.println(e);
//            ((EarthquakeAdapter) Objects.requireNonNull(rvQuery.getAdapter())).add(e);
//        }
//        EarthquakeAdapter adapter = (EarthquakeAdapter) rvQuery.getAdapter();
//        if (adapter != null) {
//            adapter.notifyDataSetChanged();
//        }
    }

    private void loadInitialData() {
        EarthquakeDB db = EarthquakeDB.getInstance(this);
        EarthquakeDAO earthquakeCursor = db.earthquakeDAO();
        AffectedCountryDAO affectedCountryCursor = db.affectedCountryDAO();
        ArrayList<Earthquake> earthquakes = (ArrayList<Earthquake>) earthquakeCursor.getAll();
        ArrayList<AffectedCountry> affectedCountries = (ArrayList<AffectedCountry>) affectedCountryCursor.getAll();

        if (earthquakes.size() == 0) {
            System.out.println("******** Inserting Earthquakes **********");
            for (Earthquake e : new DataEarthquakes().getData()) {
                earthquakeCursor.insert(e);
            }
        }
        if (affectedCountries.size() == 0) {
            System.out.println("******** Inserting Affected countries **********");
            for (AffectedCountry ac : new DataCountries().getData()) {
                affectedCountryCursor.insert(ac);
            }
        }
    }

    public QueryFilters onDialogStart() {
        return filters;
    }

    public void onDialogEnd() {
        // TODO
        Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
        // TODO Update UI
    }
}