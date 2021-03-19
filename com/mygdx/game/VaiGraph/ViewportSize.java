package com.mygdx.game.VaiGraph;

public class ViewportSize {
    public ViewportSize() {
        x = 800;
        y = 400;
        x2 = x / 2;
        y2 = y / 2;
    }
    ViewportSize(int X, int Y) {
        x = X;
        y = Y;
        x2 = x / 2;
        y2 = y / 2;
    }
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int toBatchX(int POS_X)
    {
        return POS_X - x2;
    }
    public int toBatchY(int POS_Y)
    {
        return POS_Y - y2;
    }
    public int toBatchX(float POS_X)
    {
        return ((int)POS_X) - x2;
    }
    public int toBatchY(float POS_Y)
    {
        return ((int)POS_Y) - y2;
    }
    public int toBatchX(double POS_X)
    {
        return ((int)POS_X) - x2;
    }
    public int toBatchY(double POS_Y)
    {
        return ((int)POS_Y) - y2;
    }

    public void setX(int x) {
        this.x = x;
        this.x2 = x / 2;
    }

    public void setY(int y) {
        this.y = y;
        this.y2 = y / 2;
    }
}
