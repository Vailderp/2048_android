package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.VaiGraph.Figures2D.DynamicRect;
import com.mygdx.game.VaiGraph.Figures2D.DynamicRectData;
import com.mygdx.game.VaiGraph.Figures2D.StaticRectData;
import com.mygdx.game.VaiGraph.RectData;
import com.mygdx.game.VaiGraph.Screen;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.mygdx.game.Settings.*;
import static com.mygdx.game.VaiGraph.GlobalUserDataVec.*;

public class MyGdxGame extends ApplicationAdapter {
	DynamicRectData DRD;
	StaticRectData SRD;
	Random random;
	//Table table;
	//Stage stage;
	//BitmapFont font;

	Screen screen;

	float phone_width;
	float phone_height;

	
	@Override
	public void create () {
		phone_width = Gdx.graphics.getWidth();
		phone_height = Gdx.graphics.getHeight();
		random = new Random();
		screen = new Screen();
		//stage = new Stage(new ScreenViewport());
		//font = new BitmapFont();

		screen.texturesMap.addElementByName("rects", "rects/rects.atlas");
		/*
		Gdx.input.setInputProcessor(stage);
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		screen.texturesMap.addElementByName("gui", "gui/gui.atlas");
		textButtonStyle.up = screen.texturesMap.getElementByName("gui").getDrawable("settings icon");
		textButtonStyle.over = screen.texturesMap.getElementByName("rects").getDrawable("4");
		textButtonStyle.down = screen.texturesMap.getElementByName("rects").getDrawable("8");
		BitmapFont black = new BitmapFont(Gdx.files.internal("fonts/font2048.fnt"));
		textButtonStyle.font = black;

		TextButton buttonPlay = new TextButton("settings", textButtonStyle);
		buttonPlay.setPosition(0,0);
		table = new Table();
		table.setSize(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
		table.setPosition(0, 0);
		table.add(buttonPlay);
		stage.addActor(table);
		*/

		DRD = new DynamicRectData();
		SRD = new StaticRectData();
		DRD.setSize(Rect2048_Size,Rect2048_Size);
		DRD.setGravitationScale(1);
		DRD.getBodyPhysics().setDensity(0.f);
		DRD.getBodyPhysics().setFriction(1.f);
		DRD.getBodyPhysics().setRestitution(0.f);

		screen.world_settings.setGravitation(0, -9.8);
		world.setContactListener(new MyContactListner());

		SRD.setSprite(screen.texturesMap.getElementByName("rects").getSprite("2"));
		DRD.getBodyPhysics().setDensity(1.f);
		DRD.getBodyPhysics().setFriction(10.f);
		DRD.getBodyPhysics().setRestitution(1.f);

		SRD.setPosition(0, 0);
		SRD.setSize(1,400);
		screen.static_rects.addElement(SRD, new RectData("static", 0));

		SRD.setPosition(0, 0);
		SRD.setSize(800,1);
		screen.static_rects.addElement(SRD, new RectData("static", 0));

		SRD.setPosition(800, 0);
		SRD.setSize(1,400);
		screen.static_rects.addElement(SRD, new RectData("static", 0));

		SRD.setPosition(0, 400);
		SRD.setSize(800,1);
		screen.static_rects.addElement(SRD, new RectData("static", 0));

		//ADD PANELS
		/*SRD.setSprite(screen.texturesMap.getElementByName("gui").getSprite("blue_panel"));
		SRD.setPosition(0, 0);
		SRD.setSize(100, 400);
		screen.static_rects.addElement(SRD, new RectData("blue_panel_left", 0));
		SRD.setPosition(window.width - 100, 0);
		SRD.setSize(100, 400);
		screen.static_rects.addElement(SRD, new RectData("blue_panel_right", 0));*/

		run.start();

	}

	@Override
	public void render () {
		update();
		screen.clear(0.07f,0.25f,0.07f);
		screen.display();

		//stage.act();
		//stage.draw();

	}

	public void update () {
		OnTouchNewRect();
		RectsUnion();
	}
	
	@Override
	public void dispose () {

	}

	@Override
	public void pause () {
		super.pause();
	}

	@Override
	public void resume () {
		super.resume();
	}

	void OnTouchNewRect() {
		if (Gdx.input.justTouched()) {
			DRD.setSprite(screen.texturesMap.getElementByName("rects").getSprite("2"));
			DRD.setAngle(random.nextInt(6) - 3);
			DRD.setPosition(screen.getTouchPosition().x, screen.getTouchPosition().y);
			screen.dynamic_rects.addElement(DRD, new RectData("cube", 1));
		}
	}

	void RectsUnion() {
		for (int i = 0; i < screen.dynamic_rects.getElementsSize(); i++) {
			if (screen.dynamic_rects.getRectData(i).name == "d") {
				DRD.setPosition(screen.dynamic_rects.getPosition(i).x, screen.dynamic_rects.getPosition(i).y);
				DRD.setAngle(screen.dynamic_rects.getAngle(i));
				int Num = screen.dynamic_rects.getRectData(i).number + 1;
				String StrNum = String.valueOf((int)Math.pow(2, Num));
				DRD.setSprite(screen.texturesMap.getElementByName("rects").getSprite(StrNum));
				screen.dynamic_rects.destroyElement(i);
				screen.dynamic_rects.addElement(DRD, new RectData("cube", Num));
			}
			else if (screen.dynamic_rects.getRectData(i).name == "D")
			{
				screen.dynamic_rects.destroyElement(i);
			}
		}
	}

	Thread run = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					screen.world_settings.setGravitation(screen.getAccelerometer().y * 10, screen.getAccelerometer().x * -10);
					Thread.sleep(250);
				} catch (InterruptedException ex) {

				}
			}
		}
	});
}
