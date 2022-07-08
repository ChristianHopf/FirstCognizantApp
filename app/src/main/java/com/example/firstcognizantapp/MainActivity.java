package com.example.firstcognizantapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.net.Uri;
import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    public static String TAG = MainActivity.class.getSimpleName();
    EditText nameEditText;
    TextView resultTextView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.etName);
        nameEditText.setOnFocusChangeListener(this);
        resultTextView = findViewById(R.id.tvResult);
        spinner = findViewById(R.id.spinnerPhone);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on resume - resume saved app state");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on pause -- save app state");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "on destroy");
    }

    public void clickHandler(View clickedView) {
        switch(clickedView.getId()){
            case R.id.btnLogin:
                startHomeActivity();
                break;
            case R.id.btnCancel:
                // create a dial intent (phone dial activity) with number 1234567 and start activity
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1234567"));
                startActivity(dialIntent);
                break;
        }
    }

    private void startHomeActivity() {
        //Student christianStudent = new Student("Christian", 22, 42.0f);
        //Employee christianEmployee = new Employee("Christian", 45, 22.2f);
        //String name = nameEditText.getText().toString();
        Student parcelStudent = new Student("Parcel", 679, 55.5f);
        Intent homeIntent = new Intent(this, HomeActivity.class);
        homeIntent.putExtra("student", parcelStudent);
        //newIntent.putExtra("keyn", name);
        //throw new NullPointerException();
        startActivityForResult(homeIntent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        if (resultCode == RESULT_OK){
            String contact = dataIntent.getExtras().getString("contactKey");
            resultTextView.setText(contact);
        }
    }

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if (isFocussed){
            Toast.makeText(this, "FOCUSING", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "LOST FOCUS", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String type = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}