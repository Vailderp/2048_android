package com.mygdx.game.VaiGraph;

class IntPoint {
    public int x;
    public int y;
}

public class IPoint extends IntPoint {
    public IPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public IPoint(float x, float y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public IPoint()
    {
        this.x = 0;
        this.y = 0;
    }

}
