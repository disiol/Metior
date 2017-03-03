package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {

//	public static final int WIDTH = 1280;
//	public static final int HEIGHT = 720;



    public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Size.WIDTH;
		config.height= Size.HEIGHT;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
