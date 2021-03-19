package com.mygdx.game.VaiGraph.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;

public class S_TexturesMap {
    private Map<String, Skin> elements = new HashMap<>();

    public void addElementByName(String name, String pathAtlas) {
        elements.put(name, new Skin(new TextureAtlas(Gdx.files.internal(pathAtlas))));
    }

    public Skin getElementByName(String name) {
        if (elements.get(name) == null) {
            System.out.println("NULL");
        }
        return elements.get(name);
    }
}
