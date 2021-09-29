package me.aksamitsah.php;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed_name,ed_Password,ed_Contact,ed_email;
    String name,password,contact,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.name);
        ed_Password = findViewById(R.id.password);
        ed_Contact = findViewById(R.id.contact);
        ed_email = findViewById(R.id.email);
    }

    public void register(View view) {
        name = ed_name.getText().toString().trim();
        password = ed_Password.getText().toString().trim();
        contact = ed_Contact.getText().toString().trim();
        email = ed_email.getText().toString().trim();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        //backgroundTask.execute();
        backgroundTask.execute(method,name,email,contact,password);
        finish();
    }
}