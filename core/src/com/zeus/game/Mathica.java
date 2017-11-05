package com.zeus.game;

import com.badlogic.gdx.Game;
import com.zeus.game.screens.Splash;

public class Mathica extends Game {
    public static final String TITLE = "Mathica";
    public static final String VERSION = "0.2";
	
	@Override
	public void create () {
        setScreen(new Splash());
	}

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
        super.dispose();
	}

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
