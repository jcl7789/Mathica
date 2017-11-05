package com.zeus.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.awt.TextField;

/**
 * Created by usuario on 05/11/17.
 */

public class NuevoJugador implements Screen {

    private Stage escena;
    private Table tabla;
    private Skin skin;
    private TextField nombre;
    private TextButton crear;
    private TextButton volver;


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        escena.act(delta);
        escena.draw();
    }

    @Override
    public void resize(int width, int height) {
        tabla.invalidateHierarchy();
        tabla.setSize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        escena.dispose();
        skin.dispose();

    }
}
