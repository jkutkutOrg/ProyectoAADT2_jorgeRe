package com.jkutkut.proyectoaadt2_jorgere.dialog;

import com.jkutkut.proyectoaadt2_jorgere.dialog.model.QueryFilters;

public interface FilterDialogListener {
    void onDialogEnd(); // TODO rethink names
    QueryFilters onDialogStart(); // TODO rethink names
}
