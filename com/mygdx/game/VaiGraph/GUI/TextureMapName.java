package com.mygdx.game.VaiGraph.GUI;

public class TextureMapName {
    private String nameTextureMap;
    private String nameImage;
    public TextureMapName(String nameTextureMap, String nameImage)
    {
        this.nameTextureMap = nameTextureMap;
        this.nameImage = nameImage;
    }
    public TextureMapName()
    {
        this.nameTextureMap = "";
        this.nameImage = "";
    }

    public String getNameTextureMap() {
        return nameTextureMap;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameTextureMap(String nameTextureMap) {
        this.nameTextureMap = nameTextureMap;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
