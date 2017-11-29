package com.example.mysearch;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_main, container, false);
        Button searchButton = (Button) mainView.findViewById(R.id.searchButton);
        final TextView textToSearch = (TextView) mainView.findViewById(R.id.searchEditText);
        final TextView result = (TextView) mainView.findViewById(R.id.resultTextView);
        final RequestQueue queue = Volley.newRequestQueue(getContext());
        final String key = "AIzaSyDOoaB1DreJVJ-9degs6oIzHymIuWGnJe4";
        final String searchEngineId = "015748558140942425606:ri9xriaq8nm";

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String strToSearch = textToSearch.getText().toString();
                strToSearch = strToSearch.replace(" ", "+");
                Log.d("MainActivityFragment", "clicked, str:" + strToSearch );
                String url = "https://www.googleapis.com/customsearch/v1?q=" + strToSearch +
                        "&key=" + key + "&cx=" + searchEngineId + "&alt=json&fields=items/title";

                 StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("MainActivityFragment", "Response - " + response);
                        String resultTitlesToShow = "";
                        try {
                            JSONObject results = new JSONObject(response);
                            JSONArray arrJson = results.getJSONArray("items");
                            for(int i = 0; i < arrJson.length(); i++) {
                                resultTitlesToShow += (i + 1) + ". " + arrJson.get(i).toString()
                                        .replace("{", "").replace("}", "").replace("\"title\":", "")
                                        .replace("\"","") + "\n\n";
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        result.setText(resultTitlesToShow);

                    }


                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("MainActivityFragment", "Encountered error - " + error);

                    }
                });
                queue.add(req);
            }


        });
        return mainView;
    }
}
