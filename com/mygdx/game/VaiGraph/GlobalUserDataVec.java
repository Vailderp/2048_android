package com.mygdx.game.VaiGraph;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GlobalUserDataVec {
    static public World world = new World(new Vector2(0, 0), false);
    static public ViewportSize viewportSize = new ViewportSize();
}
