package com.example.daroodar.homemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        GlobalVariable mApp = ((GlobalVariable) getApplicationContext());
        String RealPower = mApp.getRealPower();
        String Vrms = mApp.getVrms();
        String Irms = mApp.getIrms();
        String PowerFactor = mApp.getPowerFactor();
        String[] separated1 = RealPower.split(":");
        String[] separated2 = Vrms.split(":");
        String[] separated3 = Irms.split(":");
        String[] separated4 = PowerFactor.split(":");

        TextView tv1 = (TextView)findViewById(R.id.RealPowerText);
        TextView tv2 = (TextView)findViewById(R.id.VrmsText);
        TextView tv3 = (TextView)findViewById(R.id.IrmsText);
        TextView tv4 = (TextView)findViewById(R.id.PowerFactorText);
        tv1.setText("Real Power = "+separated1[1]+" dB");
        tv2.setText("Vrms = "+separated2[1]+" V");
        tv3.setText("Irms = "+separated3[1]+" mA");
        tv4.setText("Power Factor= "+separated4[1]);






    }
}
