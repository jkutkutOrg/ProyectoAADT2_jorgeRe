package com.jkutkut.proyectoaadt2_jorgere.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jkutkut.proyectoaadt2_jorgere.R;

public class FilterDialog extends DialogFragment {

    private CheckBox chkMagnitude;
    private Spinner spnMagnitude;
    private EditText etxtMagnitude;

    private CheckBox chkCountry;
    private Spinner spnCountry;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.filter_dialog, null);

        chkMagnitude = v.findViewById(R.id.chkMagnitude);
        spnMagnitude = v.findViewById(R.id.spnMagnitude);
        etxtMagnitude = v.findViewById(R.id.etxtMagnitude);
        chkCountry = v.findViewById(R.id.chkCountry);
        spnCountry = v.findViewById(R.id.spnCountry);

        String[] countries = {"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador", "Paraguay", "Perú", "Uruguay", "Venezuela"};
        spnCountry.setAdapter(
            new android.widget.ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                countries
            )
        );

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
