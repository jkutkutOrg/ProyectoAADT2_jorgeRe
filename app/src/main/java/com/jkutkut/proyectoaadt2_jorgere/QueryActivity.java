package com.jkutkut.proyectoaadt2_jorgere;

import static com.jkutkut.proyectoaadt2_jorgere.dialog.FilterDialog.FILTERS_ARG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
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

    private TextView txtvMagnitude;
    private TextView txtvCountry;
    private RecyclerView rvQuery;

    private QueryFilters filters;
    private EarthquakeDAO earthquakeCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        loadInitialDataDB();

        Button btnFilterQuery = findViewById(R.id.btnFilterQuery);
        Button btnQuery = findViewById(R.id.btnQuery);
        txtvMagnitude = findViewById(R.id.txtvMagnitude);
        txtvCountry = findViewById(R.id.txtvCountry);
        rvQuery = findViewById(R.id.rvQuery);

        btnQuery.setOnClickListener(v -> search());
        btnFilterQuery.setOnClickListener(v -> openFilterDialog());

        rvQuery.setLayoutManager(new LinearLayoutManager(this));
        rvQuery.setAdapter(new EarthquakeAdapter(new ArrayList<>()));
        rvQuery.setItemAnimator(new DefaultItemAnimator());

        updateFiltersUI();
    }

    private void loadInitialDataDB() {
        EarthquakeDB db = EarthquakeDB.getInstance(this);
        earthquakeCursor = db.earthquakeDAO();
        AffectedCountryDAO affectedCountryCursor = db.affectedCountryDAO();
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

    // UI
    @SuppressLint("DefaultLocale")
    private void updateFiltersUI() {
        if (filters.isFilterByMagnitude()) {
            txtvMagnitude.setText(String.format(
                "%s %s %.2f",
                getString(R.string.magnitude),
                filters.getMagnitudeOperator(),
                filters.getMagnitudeValue()
            ));

        }
        else
            txtvMagnitude.setText("");
        if (filters.isFilterByCountry()) {
            txtvCountry.setText(String.format(
                    "%s %s",
                    getString(R.string.country),
                    filters.getCountry()
            ));
        }
        else
            txtvCountry.setText("");
    }

    // Dialog listener

    private void openFilterDialog() {
        Bundle args = new Bundle();
        args.putParcelable(FILTERS_ARG, filters);
        FilterDialog filterDialog = new FilterDialog();
        filterDialog.setArguments(args);
        filterDialog.show(getSupportFragmentManager(), "FilterDialog");
    }

    public void onDialogEnds(QueryFilters filters) {
        if (filters == null) {
            return;
        }
        this.filters = filters;
        updateFiltersUI();
    }

    // Search
    @SuppressLint("NotifyDataSetChanged")
    private void search() {
        ArrayList<Earthquake> data;
        EarthquakeAdapter adapter = (EarthquakeAdapter) rvQuery.getAdapter();
        assert adapter != null;
        adapter.clear();
        if (filters.isFilterByMagnitude() && filters.isFilterByCountry()) {
            data = (ArrayList<Earthquake>) earthquakeCursor.getAllByMagnitudeAndCountry(
                filters.getMagnitudeOperator(),
                filters.getMagnitudeValue(),
                filters.getCountry()
            );
        }
        else if (filters.isFilterByMagnitude()) {
            data = (ArrayList<Earthquake>) earthquakeCursor.getAllByMagnitude(
                filters.getMagnitudeOperator(),
                filters.getMagnitudeValue()
            );
        }
        else if (filters.isFilterByCountry()) {
            data = (ArrayList<Earthquake>) earthquakeCursor.getAllByCountry(
                filters.getCountry()
            );
        }
        else {
            data = (ArrayList<Earthquake>) earthquakeCursor.getAll();
        }

        if (data.size() == 0) {
            Toast.makeText(this, getString(R.string.query_no_results), Toast.LENGTH_SHORT).show();
        }
        for (Earthquake e : data) {
            adapter.add(e);
        }
        adapter.notifyDataSetChanged();
    }
}