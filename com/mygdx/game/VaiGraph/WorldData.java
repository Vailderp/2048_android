package com.mygdx.game.VaiGraph;

import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.VaiGraph.GlobalUserDataVec.world;

public class WorldData {
    public float timeStep;
    public int velocityIterations;
    public int positionIterations;
    public FPoint gravitation;
    WorldData()
    {
        timeStep = 1.f / 60.f;
        velocityIterations = 15;
        positionIterations = 15;
        gravitation = new FPoint( 9.f, 0);

    }

    public void setTimeStep(float timeStep) {
        this.timeStep = timeStep;
    }
    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    private void _setGravitation(float x, float y) {
        world.setGravity(new Vector2(x, y));
    }
    public void setGravitation(FPoint gravitation) {
        this.gravitation = gravitation;
        _setGravitation(gravitation.x, gravitation.y);
    }
    public void setGravitation(IPoint gravitation) {
        this.gravitation.x = gravitation.x;
        this.gravitation.y = gravitation.y;
        _setGravitation(gravitation.x, gravitation.y);
    }
    public void setGravitation(float x, float y) {
        this.gravitation.x = x;
        this.gravitation.y =  y;
        _setGravitation(x, y);
    }
    public void setGravitation(double x, double y) {
        this.gravitation.x = (float) x;
        this.gravitation.y =  (float)y;
        _setGravitation(this.gravitation.x, this.gravitation.y);
    }

    public void setPositionIterations(int positionIterations) {
        this.positionIterations = positionIterations;
    }
    public void setPositionIterations(float positionIterations) {
        this.positionIterations = (int) positionIterations;
    }

    public void setVelocityIterations(int velocityIterations) {
        this.velocityIterations = velocityIterations;
    }
    public void setVelocityIterations(float velocityIterations) {
        this.velocityIterations = (int) velocityIterations;
    }
}
