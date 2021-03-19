package com.mygdx.game.VaiGraph.Figures2D;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.mygdx.game.VaiGraph.FPoint;
import com.mygdx.game.VaiGraph.Figures2D._util.BodyPhysics;
import com.mygdx.game.VaiGraph.GUI.TextureMap;


public class DynamicRectData {
    private FPoint position;
    private FPoint size;
    private Sprite sprite;
    private MassData massData;
    private float gravitationScale;
    private float angle = 0;
    private BodyPhysics bodyPhysics;

    public DynamicRectData() {
        bodyPhysics = new BodyPhysics();
        position = new FPoint();
        size = new FPoint();
        massData = new MassData();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setPosition(double x, double y) {
        this.position.x = (float) x;
        this.position.y = (float) y;
    }

    public void setSize(float x, float y) {
        this.size.x = x;
        this.size.y = y;
    }

    public void setMassData(float I, float mass) {
        massData.I = I;
        massData.mass = mass;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setGravitationScale(float gravitationScale) {
        this.gravitationScale = gravitationScale;
    }

    public float getAngle() {
        return angle;
    }

    public float getGravitationScale() {
        return gravitationScale;
    }

    public FPoint getPosition() {
        return position;
    }

    public FPoint getSize() {
        return size;
    }

    public MassData getMassData() {
        return massData;
    }

    public BodyPhysics getBodyPhysics() {
        return bodyPhysics;
    }
}
