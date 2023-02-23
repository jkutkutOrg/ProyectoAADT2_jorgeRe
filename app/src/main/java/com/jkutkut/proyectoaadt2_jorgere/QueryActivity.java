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
    private EarthquakeDAO earthquakeCursor;
    private AffectedCountryDAO affectedCountryCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        loadInitialDataDB();

        btnFilterQuery = findViewById(R.id.btnFilterQuery);
        btnQuery = findViewById(R.id.btnQuery);
        rvQuery = findViewById(R.id.rvQuery);

        btnQuery.setOnClickListener(v -> search());
        btnFilterQuery.setOnClickListener(v -> openFilterDialog());

        rvQuery.setLayoutManager(new LinearLayoutManager(this));
        rvQuery.setAdapter(new EarthquakeAdapter(new ArrayList<>()));
        rvQuery.setItemAnimator(new DefaultItemAnimator());
    }

    private void loadInitialDataDB() {
        EarthquakeDB db = EarthquakeDB.getInstance(this);
        earthquakeCursor = db.earthquakeDAO();
        affectedCountryCursor = db.affectedCountryDAO();
        ArrayList<Earthquake> earthquakes = (ArrayList<Earthquake>) earthquakeCursor.getAll();
        ArrayList<AffectedCountry> affectedCountries = (ArrayList<AffectedCountry>) affectedCountryCursor.getAll();

        if (earthquakes.size() == 0) {
            System.out.println("******** Inserting Earthquakes **********");
            earthquakeCursor.insertAll(new DataEarthquakes().getData());
        }
        if (affectedCountries.size() == 0) {
            System.out.println("******** Inserting Affected countries **********");
            affectedCountryCursor.insertAll(new DataCountries().getData());
        }
        filters = new QueryFilters(
                (ArrayList<String>) affectedCountryCursor.getAllCountries()
        );
    }

    // Dialog listener

    private void openFilterDialog() {
        FilterDialog filterDialog = new FilterDialog();
        filterDialog.show(getSupportFragmentManager(), "FilterDialog");
    }

    public QueryFilters onDialogStart() {
        return filters;
    }

    public void onDialogEnd() {
        // TODO
        Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
        // TODO Update UI
    }

    // Search
    private void search() {
        // TODO
        Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show();

        ArrayList<Earthquake> data = (ArrayList<Earthquake>) earthquakeCursor.getAll();
        System.out.println("******** Size: " + data.size() + "**********");
        EarthquakeAdapter adapter = (EarthquakeAdapter) rvQuery.getAdapter();
        assert adapter != null;
        for (Earthquake e : data) {
            adapter.add(e);
        }
        adapter.notifyDataSetChanged();
    }
}