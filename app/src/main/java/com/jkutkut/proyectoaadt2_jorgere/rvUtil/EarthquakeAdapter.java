package com.jkutkut.proyectoaadt2_jorgere.rvUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jkutkut.proyectoaadt2_jorgere.R;
import com.jkutkut.proyectoaadt2_jorgere.db.entity.Earthquake;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Locale;

public class EarthquakeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<Earthquake> data;

    public EarthquakeAdapter(ArrayList<Earthquake> data) {
        this.data = data;
    }

    public void clear() {
        data.clear();
    }

    public void add(Earthquake earthquake) {
        data.add(earthquake);
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_earthquake, parent, false);
        return new EarthquakeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        ((EarthquakeViewHolder) holder).bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class EarthquakeViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtvName;
        private final TextView txtvMagnitude;
        private final TextView txtvPlace;
        private final TextView txtvCoordinates;
        private final TextView txtvDeaths;
        private final TextView txtvDatetime;

        public EarthquakeViewHolder(@NotNull View itemView) {
            super(itemView);
            txtvName = itemView.findViewById(R.id.txtvName);
            txtvMagnitude = itemView.findViewById(R.id.txtvMagnitude);
            txtvPlace = itemView.findViewById(R.id.txtvPlace);
            txtvCoordinates = itemView.findViewById(R.id.txtvCoordinates);
            txtvDeaths = itemView.findViewById(R.id.txtvDeaths);
            txtvDatetime = itemView.findViewById(R.id.txtvDatetime);
        }

        public void bind(Earthquake earthquake) {
            txtvName.setText(earthquake.getName());
            txtvMagnitude.setText(String.format(Locale.getDefault(),"%.2f", earthquake.getMagnitude()));
            txtvPlace.setText(earthquake.getPlace());
            txtvCoordinates.setText(earthquake.getCoordinates());
            txtvDeaths.setText(earthquake.getDeaths());
            txtvDatetime.setText(earthquake.getTimedate());
        }
    }
}
