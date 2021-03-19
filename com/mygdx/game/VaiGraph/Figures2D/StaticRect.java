package com.mygdx.game.VaiGraph.Figures2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.VaiGraph.FPoint;
import com.mygdx.game.VaiGraph.IPoint;
import com.mygdx.game.VaiGraph.RectData;
import com.mygdx.game.VaiGraph.ViewportSize;

import static com.mygdx.game.VaiGraph.Figures2D.FixtureDef_get.getFixtureDef;
import static com.mygdx.game.VaiGraph.GlobalUserDataVec.viewportSize;
import static com.mygdx.game.VaiGraph.GlobalUserDataVec.world;
import static com.mygdx.game.VaiGraph.MATH.toDeg;

public class StaticRect {
    public BodyDef bodyDef = new BodyDef();
    public Sprite sprite;
    public FPoint position;
    public FPoint size;
    private FPoint _size2 = new FPoint();
    public Body body;
    private final FPoint _viewportSize_BodySize = new FPoint();
    public boolean isVis = true;

    public StaticRect(StaticRectData data, RectData rectData) {
        position = data.getPosition();
        size = data.getSize();
        _size2.x = size.x / 2;
        _size2.y = size.y / 2;
        position.x += _size2.x;
        position.y += _size2.y;
        _viewportSize_BodySize.x = viewportSize.x / 2 + _size2.x;
        _viewportSize_BodySize.y = viewportSize.y / 2 + _size2.y;
        sprite = data.getSprite();
        sprite.setOrigin(_size2.x, _size2.y);
        sprite.setSize(size.x, size.y);
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(position.x, position.y);
        bodyDef.angle = data.getAngle();
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(_size2.x, _size2.y);
        body.createFixture(getFixtureDef(shape, data.getBodyPhysics().getDensity(), data.getBodyPhysics().getFriction(), data.getBodyPhysics().getRestitution()));
        body.setUserData(rectData);
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
