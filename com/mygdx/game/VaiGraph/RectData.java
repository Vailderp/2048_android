package com.mygdx.game.VaiGraph;

public class RectData {
    public RectData() {
        name = "";
        number = 1;
    }
    public RectData(String Name, int Number) {
        name = Name;
        number = Number;
    }
    public String name;
    public int number;

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
