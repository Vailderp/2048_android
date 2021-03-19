package com.mygdx.game.VaiGraph.Figures2D._util;

public class BodyPhysics {
    private boolean isSensor;
    private float density;
    private float friction;
    private float restitution;
    public BodyPhysics() {
        isSensor = false;
        density = 0.f;
        friction = 0.f;
        restitution = 0.f;
    }

    public float getDensity() {
        return density;
    }

    public float getFriction() {
        return friction;
    }

    public float getRestitution() {
        return restitution;
    }

    public boolean isSensor() {
        return isSensor;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public void setRestitution(float restitution) {
        this.restitution = restitution;
    }

    public void setSensor(boolean sensor) {
        isSensor = sensor;
    }
}
