package com.mygdx.game.VaiGraph.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.Vector;

public class TextureMap {
    private Skin skin;
    public TextureMap(String path)
    {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(path));
        skin = new Skin(atlas);
        atlas.dispose();
    }
    public Drawable getDrawableByName(String name) {
        return skin.getDrawable(name);
    }

    public Sprite getSpriteByName(String name) {
        return skin.getSprite(name);
    }

    public Texture getTextureByName(String name) {
        return skin.getSprite(name).getTexture();
    }

}
