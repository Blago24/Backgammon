package com.backgammon.controllers;
import com.badlogic.gdx.Game;


import com.backgammon.ui.MainScreen;

public class Backgammon extends Game {
	public static final String GAME_NAME = "Backgammon";
	public static final int SCREEN_WIDTH = 850;
	public static final int SCREEN_HEIGHT = 700;

	private Game game;
	public Backgammon() {
		game = this;
	}
	@Override
	public void create () {
		setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
