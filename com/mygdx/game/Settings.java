package com.mygdx.game;
class Window {
    public final int width;
    public final int height;
    Window(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
}
public class Settings {
    public static final float Rect2048_Size = 50;
    public static final Window window = new Window(800, 400);
}
