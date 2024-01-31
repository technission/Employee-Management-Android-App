package com.learncodinganywhere.workit;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            new NetworkTask().execute("https://172.20.224.1/workit/connect.php");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        Button btn = (findViewById(R.id.loginButton));
        btn.setOnClickListener(v -> setContentView(R.layout.activity_landing_page));
    }

    private class NetworkTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // Perform network operations in the background
            System.out.println("Attempting to connect to WAMP MySQL...");
            try {
                System.out.println(fetchDataFromNetwork(params[0]));
                return fetchDataFromNetwork(params[0]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
        }
    }

    private String fetchDataFromNetwork(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            System.out.println("Stringbuilder: " + stringBuilder);

            return stringBuilder.toString();
        } finally {
            urlConnection.disconnect();
        }
    }

    public void showPopUp(View v) {
        setContentView(R.layout.menu_item_popout);
    }

    public void closePopUp(View v) {
        setContentView(R.layout.activity_landing_page);
    }

    public void EmployeeInfo(View v) {
        setContentView(R.layout.activity_emp_info);
    }
}