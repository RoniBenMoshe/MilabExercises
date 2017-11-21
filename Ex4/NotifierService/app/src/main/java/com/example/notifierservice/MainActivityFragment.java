package com.example.notifierservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

      static int m_Minutes = 5;
    NumberPicker minutesPicker = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_main, container, false);
        minutesPicker = (NumberPicker) mainView.findViewById(R.id.minutesNumberPicker);
        Button startButton = (Button) mainView.findViewById(R.id.startButton);
        minutesPicker.setMaxValue(30);
        minutesPicker.setMinValue(1);
        minutesPicker.setWrapSelectorWheel(false);
        minutesPicker.setValue(5);

        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               m_Minutes = minutesPicker.getValue();
               startNotify();
            }
        });

        return mainView;
    }

    private void startNotify() {
        AlarmManager manager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this.getContext(), NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getContext(), 0, intent, 0);
        long delay = m_Minutes * 60 * 100;
        manager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+delay, delay, pendingIntent);
    }
}
