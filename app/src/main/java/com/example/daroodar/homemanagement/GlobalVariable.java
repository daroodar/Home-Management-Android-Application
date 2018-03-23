package com.example.daroodar.homemanagement;

import android.app.Application;

/**
 * Created by daroodar on 11/23/2017.
 */

public class GlobalVariable extends Application {

    private String RealPower,Vrms,Irms,PowerFactor;

    public String getRealPower() {
        return RealPower;
    }
    public void setRealPower(String str) {
        RealPower = str;
    }

    public String getVrms() {
        return Vrms;
    }
    public void setVrms(String str) { Vrms = str; }

    public String getIrms() {
        return Irms;
    }
    public void setIrms(String str) { Irms = str; }

    public String getPowerFactor() {
        return PowerFactor;
    }
    public void setPowerFactor(String str) {
        PowerFactor = str;
    }

}
