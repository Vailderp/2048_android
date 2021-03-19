package com.mygdx.game.VaiGraph;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.VaiGraph.Figures2D.S_DynamicRect;
import com.mygdx.game.VaiGraph.Figures2D.S_StaticRect;
import com.mygdx.game.VaiGraph.GUI.S_TexturesMap;

import static com.mygdx.game.VaiGraph.GlobalUserDataVec.viewportSize;
import static com.mygdx.game.VaiGraph.GlobalUserDataVec.world;

public class Screen {
    private int width;
    private int height;

    public S_DynamicRect dynamic_rects;
    public S_StaticRect static_rects;
    public WorldData world_settings;
    public OrthographicCamera camera;
    private SpriteBatch batch;
    public S_TexturesMap texturesMap;

    private void init() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        world_settings = new WorldData();
        dynamic_rects = new S_DynamicRect();
        static_rects = new S_StaticRect();
        texturesMap = new S_TexturesMap();
        world.setGravity(new Vector2(world_settings.gravitation.x, world_settings.gravitation.y));
        camera.setToOrtho(false, viewportSize.x, viewportSize.y);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.projection);
    }

    public Screen(int width, int height) {
        init();
        viewportSize.setX(width);
        viewportSize.setY(height);
        camera.setToOrtho(false, viewportSize.x, viewportSize.y);
        batch.setProjectionMatrix(camera.projection);
    }

    public Screen() {
        init();
    }

    public void clear(float r, float g, float b) {
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void clear() {
        clear(0, 0, 0);
    }

    public void display() {
        world.step(world_settings.timeStep, world_settings.velocityIterations, world_settings.positionIterations);
        batch.begin();

        for (int i = 0; i < dynamic_rects.elements.size(); i++) {
            if (dynamic_rects.elements.get(i).isVis) {
                dynamic_rects.elements.get(i).draw(batch);
            }
        }

        for (int i = 0; i < static_rects.elements.size(); i++) {
            if (static_rects.elements.get(i).isVis) {
                static_rects.elements.get(i).draw(batch);
            }
        }

        batch.end();
    }

    public Vector3 unproject(Vector3 p)
    {
        return camera.unproject(p);
    }

    public FPoint getTouchPosition()
    {
        Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        mousePos = unproject(mousePos);
        return (new FPoint(mousePos.x, mousePos.y));
    }

    public Vector3 getAccelerometer()
    {
        return (new Vector3(Gdx.input.getAccelerometerX(), Gdx.input.getAccelerometerY(), Gdx.input.getAccelerometerX()));
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
