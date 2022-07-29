package com.learncodinganywhere.workit;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String save_url = "http://192.168.1.94/dbconfig.php";
        if (type.equals("save")) {
            try {
                String fname = params[1];
                String lname = params[2];
                String address1 = params[3];
                String address2 = params[4];
                String state = params[5];
                String zip = params[6];
                String email = params[7];
                String phone = params[8];
                String efname = params[9];
                String elname = params[10];
                String ephone = params[11];
                String erelationship = params[12];
                URL url = new URL(save_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fname, "UTF-8") + "&"
                        + URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(lname, "UTF-8") + "&"
                        + URLEncoder.encode("address1", "UTF-8") + "=" + URLEncoder.encode(address1, "UTF-8") + "&"
                        + URLEncoder.encode("address2", "UTF-8") + "=" + URLEncoder.encode(address2, "UTF-8") + "&"
                        + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8") + "&"
                        + URLEncoder.encode("zip", "UTF-8") + "=" + URLEncoder.encode(zip, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&"
                        + URLEncoder.encode("efname", "UTF-8") + "=" + URLEncoder.encode(efname, "UTF-8") + "&"
                        + URLEncoder.encode("elname", "UTF-8") + "=" + URLEncoder.encode(elname, "UTF-8") + "&"
                        + URLEncoder.encode("ephone", "UTF-8") + "=" + URLEncoder.encode(ephone, "UTF-8") + "&"
                        + URLEncoder.encode("erelationship", "UTF-8") + "=" + URLEncoder.encode(erelationship, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
