package me.aksamitsah.php;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class JsonQuery extends AppCompatActivity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_query);
    }

    public void JsonView(View view) {
        BackgroundJSON backgroundJSON = new BackgroundJSON();
        backgroundJSON.execute();
    }
    public void JsonNextClass(View view) {
        Intent i = new Intent(this,DisplaylistView.class);
        i.putExtra("json_data",json_string);
        startActivity(i);
    }


    @SuppressLint("StaticFieldLeak")
    class BackgroundJSON extends AsyncTask<Void, Void, String>{

        String json_url = "https://aksamitsah-tech.000webhostapp.com/json_response.php";
        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url = new URL(json_url);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream =httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((json_string=bufferedReader.readLine())!=null){
                    stringBuilder.append(json_string).append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpsURLConnection.disconnect();
                return stringBuilder.toString().trim();


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public BackgroundJSON() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);
            TextView textView = findViewById(R.id.textView2);
            textView.setText(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
