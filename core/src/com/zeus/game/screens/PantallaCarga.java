package com.zeus.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.zeus.game.Mathica;


/**
 * Created by usuario on 19/11/17.
 */

public class PantallaCarga implements Screen {
    private Mathica game;
    private Label cargando;
    private Stage escena;
    private Skin skin;


    public PantallaCarga(Mathica game) {
        this.game = game;
        BitmapFont letra = new BitmapFont(Gdx.files.internal("font/pirate.fnt"), false);
        escena = new Stage(new FillViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),game.camera));
        Label.LabelStyle estilo_encabe = new Label.LabelStyle(letra, Color.WHITE);
        cargando = new Label("Menso:...",estilo_encabe);
        cargando.setFontScale(5f);
        cargando.setPosition(320 - cargando.getWidth() / 2, 180 - cargando.getHeight()/2);
        escena.addActor(cargando);
        escena.setViewport(new ScalingViewport(Scaling.fill, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));

    }


    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (game.getManager().update()){
            game.finalizar_carga();
        } else {
            int progreso = (int) game.getManager().getProgress() *100;
            for (int i = 0; i < 10000; i++) {

            }
            cargando.setText("Cargando: " + progreso + "%");
        }

        escena.act();
        escena.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }




}
