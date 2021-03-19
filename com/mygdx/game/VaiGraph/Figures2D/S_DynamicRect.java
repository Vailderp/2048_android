package com.mygdx.game.VaiGraph.Figures2D;

import com.mygdx.game.VaiGraph.FPoint;
import com.mygdx.game.VaiGraph.RectData;

import java.util.Vector;

import static com.mygdx.game.VaiGraph.GlobalUserDataVec.world;

public class S_DynamicRect {
    public Vector<DynamicRect> elements = new Vector<>();

    public void addElement(DynamicRectData dynamicRectData, RectData data2048)
    {
        elements.addElement(new DynamicRect(dynamicRectData, data2048));
    }

    public DynamicRect getElement(int index) {
        return elements.get(index);
    }

    public DynamicRect getElement(float index) {
        return elements.get((int)index);
    }

    public int getElementsSize() {
        return elements.size();
    }

    public RectData getRectData(int index) {
        return (RectData) elements.get(index).body.getUserData();
    }
    public RectData getRectData(float index) {
        return (RectData) elements.get((int)index).body.getUserData();
    }

    public FPoint getPosition(int index) {
        return (new FPoint(elements.get(index).body.getPosition().x, (elements.get(index).body.getPosition().y)));
    }
    public FPoint getPosition(float index) {
        return (new FPoint(elements.get((int)index).body.getPosition().x, (elements.get((int)index).body.getPosition().y)));
    }

    public float getAngle(int index) {
        return elements.get(index).body.getAngle();
    }
    public float getAngle(float index) {
        return elements.get((int)index).body.getAngle();
    }

    public void destroyElement(int index) {
        world.destroyBody(elements.get(index).body);
        elements.remove(index);
    }
    public void destroyElement(float index) {
        world.destroyBody(elements.get((int)index).body);
        elements.remove((int)index);
    }

}
