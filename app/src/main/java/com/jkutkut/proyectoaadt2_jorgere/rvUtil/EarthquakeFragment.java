package com.jkutkut.proyectoaadt2_jorgere.rvUtil;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkutkut.proyectoaadt2_jorgere.R;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EarthquakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EarthquakeFragment extends Fragment {

    private static final String ARG_EARTHQUAKE_OBJ = "earthquake";

    private Earthquake earthquake;

    public EarthquakeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param earthquake - Object with the information.
     * @return New instance of the fragment.
     */
    public static EarthquakeFragment newInstance(Earthquake earthquake) {
        EarthquakeFragment fragment = new EarthquakeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_EARTHQUAKE_OBJ, earthquake);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null)
            return;
        earthquake = savedInstanceState.getSerializable(ARG_EARTHQUAKE_OBJ, Earthquake.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TODO
        return inflater.inflate(R.layout.fragment_earthquake, container, false);
    }
}