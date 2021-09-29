package me.aksamitsah.php;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DisplaylistView extends AppCompatActivity {

    String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaylist_view);

        JSON_STRING = getIntent().getExtras().getString("json_data");


    }
}