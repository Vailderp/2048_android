package com.mygdx.game.VaiGraph;

public class MATH {
    public static final float PI = (float) Math.acos(-1);
    public static final float PI180 = PI / 180;
    public static final float toRad(float DEG) {
        return DEG * PI180;
    }
    public static final float toDeg(float RAD) {
        return RAD / PI180;
    }

}
