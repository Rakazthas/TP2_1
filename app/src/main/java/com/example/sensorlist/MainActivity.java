package com.example.sensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager snsManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView list;

        List<Sensor> snsList;
        StringBuffer snsListDesc = new StringBuffer();

        final SensorManager snsManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        snsList = snsManager.getSensorList(Sensor.TYPE_ALL);

        snsListDesc.append("Liste des senseurs disponibles : \r\n");
        for (Sensor s:snsList) {
            snsListDesc.append("\t-Nom : ").append(s.getName()).append("\r\n");
            snsListDesc.append("\t\tType : ").append(s.getType()).append("\r\n");
            snsListDesc.append("\t\tResolution : ").append(s.getResolution()).append("\r\n");
            snsListDesc.append("\t\tPortee max : ").append(s.getMaximumRange()).append("\r\n");
        }

        list = new TextView(this);
        list.setText(snsListDesc);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(list);

        setContentView(ll);
    }
}