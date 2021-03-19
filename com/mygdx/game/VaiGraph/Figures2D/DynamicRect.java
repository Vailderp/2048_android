package com.mygdx.game.VaiGraph.Figures2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.VaiGraph.FPoint;
import com.mygdx.game.VaiGraph.RectData;

import static com.mygdx.game.VaiGraph.GlobalUserDataVec.viewportSize;
import static com.mygdx.game.VaiGraph.GlobalUserDataVec.world;
import static com.mygdx.game.VaiGraph.MATH.toDeg;
import static com.mygdx.game.VaiGraph.Figures2D.FixtureDef_get.*;

public class DynamicRect {
    public MassData massData;
    public BodyDef bodyDef = new BodyDef();
    public Sprite sprite;
    public FPoint position;
    public FPoint size;
    public Body body;
    public boolean isVis = true;
    private final FPoint _size2 = new FPoint();
    private final FPoint _viewportSize_BodySize = new FPoint();

    public DynamicRect(DynamicRectData data, RectData rectData) {
        sprite = new Sprite();
        massData = data.getMassData();
        position = data.getPosition();
        size = data.getSize();
        _size2.x = size.x / 2;
        _size2.y = size.y / 2;
        massData.center.set(_size2.x, _size2.y);
        _viewportSize_BodySize.x = viewportSize.x / 2 + _size2.x;
        _viewportSize_BodySize.y = viewportSize.y / 2 + _size2.y;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(data.getPosition().x, data.getPosition().y);
        bodyDef.angle = data.getAngle();
        body = world.createBody(bodyDef);
        body.setMassData(massData);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(_size2.x, _size2.y);
        sprite = data.getSprite();
        body.createFixture(getFixtureDef(shape, data.getBodyPhysics().getDensity(), data.getBodyPhysics().getFriction(), data.getBodyPhysics().getRestitution()));
        body.setUserData(rectData);
        body.setGravityScale(data.getGravitationScale());
        shape.dispose();
    }

    public void draw(SpriteBatch batch) {
        sprite.setRotation(toDeg(body.getAngle()));
        sprite.setOrigin(_size2.x, _size2.y);
        sprite.setPosition(body.getPosition().x - _viewportSize_BodySize.x, body.getPosition().y - _viewportSize_BodySize.y);
        sprite.setSize(size.x, size.y);
        sprite.draw(batch);
    }
}
