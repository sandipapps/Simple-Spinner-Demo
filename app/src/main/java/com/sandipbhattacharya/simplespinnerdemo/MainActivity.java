package com.sandipbhattacharya.simplespinnerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // Object references of our views
    Spinner spinnerMonth, spinnerYear;
    Button btnSubmit;
    // String array to hold the months that'll populate programmatically
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the objects by calling findViewById() which returns references to our views
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerYear = findViewById(R.id.spinnerYear);
        btnSubmit = findViewById(R.id.btnSubmit);
        // Call two methods to populate the spinners and define them below
        populateSpinnerMonth();
        populateSpinnerYear();
        // Attach OnClickListener on btnSubmit and show a Toast message based on which spinner items
        // are currently selected
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String month = spinnerMonth.getSelectedItem().toString();
                String year = spinnerYear.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, month + ", " + year, Toast.LENGTH_SHORT).show();
            }
        });

        // Next, attach OnItemSelectedListener on spinners
        spinnerMonth.setOnItemSelectedListener(this);
        spinnerYear.setOnItemSelectedListener(this);

        // For example:
        //spinnerMonth.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        //spinnerYear.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getId() == R.id.spinnerMonth) {
                    String selectedMonth = parent.getSelectedItem().toString();
                    //String selectedMonth = parent.getItemAtPosition(position).toString();
                    //String selectedMonth = months[position];
                    Toast.makeText(MainActivity.this, "Selected: " + selectedMonth, Toast.LENGTH_SHORT).show();
                } else if (parent.getId() == R.id.spinnerYear) {
                    String selectedYear = parent.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, "Selected: " + selectedYear, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    } // onCreate() ends.

    private void populateSpinnerYear() {
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);
    }

    private void populateSpinnerMonth() {
        months = new DateFormatSymbols().getMonths();
        // Creating the ArrayAdapter instance having the month list
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the ArrayAdapter on the Spinner
        spinnerMonth.setAdapter(monthAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinnerMonth){
            String selectedMonth = parent.getSelectedItem().toString();
            //String selectedMonth = parent.getItemAtPosition(position).toString();
            //String selectedMonth = months[position];
            Toast.makeText(this, "Selected: "+ selectedMonth, Toast.LENGTH_SHORT).show();
        }else if(parent.getId() == R.id.spinnerYear){
            String selectedYear = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: "+ selectedYear, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // For example:
    /*
    private class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(parent.getId() == R.id.spinnerMonth){
                String selectedMonth = parent.getSelectedItem().toString();
                //String selectedMonth = parent.getItemAtPosition(position).toString();
                //String selectedMonth = months[position];
                Toast.makeText(MainActivity.this, "Selected: "+ selectedMonth, Toast.LENGTH_SHORT).show();
            }else if(parent.getId() == R.id.spinnerYear){
                String selectedYear = parent.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "Selected: "+ selectedYear, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
     */
}
