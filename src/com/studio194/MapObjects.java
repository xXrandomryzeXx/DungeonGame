package com.studio194;

public class MapObjects {
    public final static String RedColor = "\033[0;31m";
    public final static String BlueColor = "\033[0;34m";
    public final static String YellowColor = "\033[0;33m";
    public final static String DefaultColor = "\033[0m";
    public final static String WhiteColor = "\033[0;37m";

    public final static String wall = BlueColor  + "#  " + DefaultColor;
    public final static String player = RedColor + "@  " + DefaultColor;
    public final static String coin = YellowColor + "$  " + DefaultColor;
    public final static String finish = WhiteColor + "±  " + DefaultColor;
}