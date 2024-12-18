package com.example.droidcafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Habilitar la flecha de navegación en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Recuperar el postre seleccionado desde el Intent
        String selectedDessert = getIntent().getStringExtra("selectedDessert");

        // Mostrar el nombre del postre seleccionado en un TextView
        TextView selectedDessertTextView = findViewById(R.id.selected_dessert_textview);
        if (selectedDessert != null) {
            selectedDessertTextView.setText("You selected " + selectedDessert);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Finaliza la actividad actual y vuelve atrás
        return true;
    }

    /**
     * Muestra un mensaje Toast.
     *
     * @param message Mensaje a mostrar.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Maneja los clics de los RadioButtons.
     *
     * @param view Vista que fue clicada.
     */
    public void onRadioButtonClicked(View view) {
        // Comprueba si el botón está seleccionado
        boolean checked = ((RadioButton) view).isChecked();

        // Verifica cuál botón fue seleccionado con if-else
        if (view.getId() == R.id.sameday && checked) {
            displayToast(getString(R.string.chosen) + " " + getString(R.string.same_day_messenger_service));
        } else if (view.getId() == R.id.nextday && checked) {
            displayToast(getString(R.string.chosen) + " " + getString(R.string.next_day_ground_delivery));
        } else if (view.getId() == R.id.pickup && checked) {
            displayToast(getString(R.string.chosen) + " " + getString(R.string.pick_up));
        } else {
            Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
        }
    }
}
