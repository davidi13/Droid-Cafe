package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la ActionBar predeterminada
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Droid Cafe"); // Cambia el título si lo necesitas
        }
    }

    /**
     * Muestra un mensaje Toast con el texto proporcionado.
     *
     * @param message Mensaje que se mostrará en el Toast.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Muestra un mensaje que indica que la imagen del donut fue seleccionada
     * y abre la OrderActivity.
     *
     * @param view La vista que se tocó.
     */
    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
        openOrderActivity("Donut");
    }

    /**
     * Muestra un mensaje que indica que la imagen del sándwich de helado fue seleccionada
     * y abre la OrderActivity.
     *
     * @param view La vista que se tocó.
     */
    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        openOrderActivity("Ice Cream Sandwich");
    }

    /**
     * Muestra un mensaje que indica que la imagen del FroYo fue seleccionada
     * y abre la OrderActivity.
     *
     * @param view La vista que se tocó.
     */
    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
        openOrderActivity("FroYo");
    }

    /**
     * Abre la OrderActivity y envía el nombre del postre seleccionado.
     *
     * @param dessertName Nombre del postre seleccionado.
     */
    private void openOrderActivity(String dessertName) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("selectedDessert", dessertName); // Envía el nombre del postre
        startActivity(intent);
    }

    /**
     * Abre la OrderActivity desde un botón.
     */
    public void openOrderActivityFromButton(View view) {
        openOrderActivity("Custom Selection");
    }

    // -------------------------------
    // Menú en la Toolbar
    // -------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú en la ActionBar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar clics en los ítems del menú
        int id = item.getItemId();

        if (id == R.id.action_order) {
            // Navegar a OrderActivity cuando se selecciona "Order"
            openOrderActivity("Custom Selection");
            return true;
        } else if (id == R.id.action_status) {
            displayToast("Status selected");
            return true;
        } else if (id == R.id.action_favorites) {
            displayToast("Favorites selected");
            return true;
        } else if (id == R.id.action_contacts) {
            displayToast("Contacts selected");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
