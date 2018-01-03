package com.example.ex9;

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
        Button getTimeButton = (Button)mainView.findViewById(R.id.buttonShowTime);
        final TextView textViewToShow = (TextView)mainView.findViewById(R.id.textViewTimeToShow);
        final RequestQueue queue = Volley.newRequestQueue(getContext());

        getTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://milabex7.herokuapp.com/server/getTime";
                StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("MainActivityFragment", "Response - " + response);
                        textViewToShow.setText(response);
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



        return  mainView;
    }
}
