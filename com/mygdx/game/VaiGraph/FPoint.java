package com.mygdx.game.VaiGraph;

class FloatPoint {
    public float x;
    public float y;
}

public class FPoint extends FloatPoint {
    public FPoint(int x, int y)
    {
        this.x = (float) x;
        this.y = (float) y;
    }

    public FPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FPoint()
    {
        this.x = 0;
        this.y = 0;
    }

}
