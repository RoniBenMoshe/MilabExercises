package com.example.assignment3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static boolean isLastwWantedStark = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_main, container, false);
        Button starkButton = (Button) mainView.findViewById(R.id.starkButton);
        Button lanisterButton = (Button) mainView.findViewById(R.id.lanisterButton);

        starkButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() ,RecycleActivity.class);
                isLastwWantedStark = true;
                startActivity(intent);
            }
        });

        lanisterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() ,RecycleActivity.class);
                isLastwWantedStark = false;
                startActivity(intent);
            }
        });

        return mainView;
    }
}
