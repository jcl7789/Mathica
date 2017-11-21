package com.zeus.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.zeus.game.screens.PantallaCarga;
import com.zeus.game.screens.Splash;

public class Mathica extends Game {
    public static final String TITLE = "Mathica";
    public static final String VERSION = "0.2";
	public AssetManager manager;
	public Camera camera;

	public AssetManager getManager() {return manager;}

	@Override
	public void create () {
	    manager = new AssetManager();
	    manager.load("sound/coin.ogg", Sound.class);
        manager.load("music/mundo.mp3", Music.class);
        manager.load("music/preguntas.mp3", Music.class);
        manager.load("music/principal.mp3", Music.class);
	    camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        setScreen(new PantallaCarga(this));
	}

	public void finalizar_carga(){
        setScreen(new Splash(this));
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
