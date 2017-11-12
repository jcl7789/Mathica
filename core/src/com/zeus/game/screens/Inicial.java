package com.zeus.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by usuario on 05/11/17.
 */

public class Inicial implements Screen {
    private Stage escena;
    private Table tabla;
    private Skin skin;
    private TextureAtlas atlas;

    @Override
    public void show() {
        escena = new Stage();
        atlas = new TextureAtlas("ui/boton.atlas");
        skin = new Skin(atlas);
        tabla = new Table(skin);
        tabla.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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

    }
}
