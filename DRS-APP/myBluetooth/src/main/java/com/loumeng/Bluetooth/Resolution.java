package com.loumeng.Bluetooth;

public class Resolution {
    public int Rx;
    public int Ry;
    public int Ds;


    public Resolution(int f1, int f2, int dens) {
        Rx = f1;
        Ry = f2-f2%16;
        Ds = dens;
        Rx = (f2*1440)/2560;
    }

    public void ChangeResolution() {
        if (Root.IsRoot())
            Root.ExceCommond("wm size " + this.Rx + "x" + this.Ry);
    }

    public void ChangeR_quit() {
        if (Root.IsRoot())
            Root.ExceCommond("wm size 1440x2560");

    }
}
