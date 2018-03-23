package com.example.daroodar.homemanagement;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;

import me.aflak.bluetooth.Bluetooth;

public class MainActivity extends AppCompatActivity {
    Bluetooth bluetooth;
    String RealPower,ReactivePower,PowerFactor;
    Switch simpleSwitch1,simpleSwitch2,simpleSwitch3,simpleSwitch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // WHEN CMPETING IT, set min API t 21
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bluetooth = new  Bluetooth(this);
        bluetooth.enableBluetooth();
        bluetooth.connectToName("HC-05");
        bluetooth.setCommunicationCallback(new Bluetooth.CommunicationCallback() {
            @Override
            public void onConnect(BluetoothDevice device) {

            }

            @Override
            public void onDisconnect(   BluetoothDevice device, String message) {
                // device disconnected
            }

            @Override
            public void onMessage(final String message) {


                        GlobalVariable mApp = ((GlobalVariable) getApplicationContext());

                       // tv1.setText(message);

                        Log.d("osma",message);
                        if(message.contains("Real")){
                            mApp.setRealPower(message);
                        }
                        else if (message.contains("Vrms")){
                            mApp.setVrms(message);
                        }
                        else if (message.contains("Irms")){
                            mApp.setIrms(message);
                        }


                        else if(message.contains("Factor")){
                            mApp.setPowerFactor(message);
                        }

            }




            @Override
            public void onError(String message) {
                // error occurred
            }

            @Override
            public void onConnectError(BluetoothDevice device, String message) {
                // error during connection
            }
        });
        simpleSwitch1 = (Switch) findViewById(R.id.simpleSwitch1);
        simpleSwitch2 = (Switch) findViewById(R.id.simpleSwitch2);
        simpleSwitch3 = (Switch) findViewById(R.id.simpleSwitch3);
        simpleSwitch4 = (Switch) findViewById(R.id.simpleSwitch4);
        simpleSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bluetooth.send("Switch1 ON");
                else
                    bluetooth.send("Switch1 OFF");

            }
        });
        simpleSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bluetooth.send("Switch2 ON");
                else
                    bluetooth.send("Switch2 OFF");
            }
        });
        simpleSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bluetooth.send("Switch3 ON");
                else
                    bluetooth.send("Switch3 OFF");

            }
        });
        simpleSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bluetooth.send("Switch4 ON");
                else
                    bluetooth.send("Switch4 OFF");
            }
        });

    }
    public void onCickTimer(View v){
        RelativeLayout ClockLayout=(RelativeLayout) findViewById(R.id.ClockLayout);
        Button MonitorID=(Button) findViewById(R.id.monitorId);
        Button TimerID=(Button) findViewById(R.id.monitorId3);
        MonitorID.setVisibility(v.INVISIBLE);
        TimerID.setVisibility(v.INVISIBLE);


        //Maybe yahan masa h
        ClockLayout.setVisibility(v.VISIBLE);
        TimePicker timePicker1;
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);




    }

    public void onClickConfirmTime(View v){
        TimePicker timePicker1;
        Button MonitorID=(Button) findViewById(R.id.monitorId);
        Button TimerID=(Button) findViewById(R.id.monitorId3);
        MonitorID.setVisibility(v.VISIBLE);
        TimerID.setVisibility(v.VISIBLE);
        RelativeLayout ClockLayout=(RelativeLayout) findViewById(R.id.ClockLayout);
        ClockLayout.setVisibility(v.INVISIBLE);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        int AlarmHour=timePicker1.getCurrentHour();
        int TotalAlarmMin=(timePicker1.getCurrentMinute())+(AlarmHour*60);
        int CurrentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int TotalCurrentMin = (Calendar.getInstance().get(Calendar.MINUTE))+(CurrentHour*60);
        int TimeLeft=TotalAlarmMin-TotalCurrentMin;
        if(TotalAlarmMin<TotalCurrentMin){
            TimeLeft=(60*24)-TotalCurrentMin+TotalAlarmMin;
        }
        String temp="Time Left : "+TimeLeft;

        Toast.makeText(this,temp ,Toast.LENGTH_LONG).show();
        bluetooth.send(temp);



    }
    public void onClickMonitor(View v){
        Intent myIntent = new Intent(this, MonitorActivity.class);
        this.startActivity(myIntent);


    }

}
