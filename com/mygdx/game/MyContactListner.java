package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.VaiGraph.RectData;

public class MyContactListner implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Body FA = contact.getFixtureA().getBody();
        Body FB = contact.getFixtureB().getBody();
        if (FA == null || FB == null) {
            return;
        }
        if (FA.getUserData() == null || FB.getUserData() == null) {
            return;
        }
        RectData dataA;
        RectData dataB;
        if (isTutorialContact(FA, FB)) {
            dataA = (RectData) FA.getUserData();
            dataB = (RectData) FB.getUserData();
        }
        else {
            dataB = (RectData) FA.getUserData();
            dataA = (RectData) FB.getUserData();
        }

        if (dataA.number == dataB.number) {
            dataA.name = "d";
            dataB.name = "D";
            FA.setUserData(dataA);
            FB.setUserData(dataB);
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private boolean isTutorialContact(Body fa, Body fb) {
        return (fa.getUserData() instanceof RectData && fb.getUserData() instanceof RectData);
    }

}
