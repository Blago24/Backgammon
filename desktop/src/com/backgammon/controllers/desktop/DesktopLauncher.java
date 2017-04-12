package com.backgammon.controllers.desktop;
import com.backgammon.controllers.Backgammon;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.addIcon("images\\iconata.png", Files.FileType.Internal);
		config.width = Backgammon.SCREEN_WIDTH;
		config.height = Backgammon.SCREEN_HEIGHT;
		config.title = Backgammon.GAME_NAME;
		new LwjglApplication(new Backgammon(), config);
		
		
	}
}
