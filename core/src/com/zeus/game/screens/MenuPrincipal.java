package com.zeus.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zeus.game.Mathica;

/**
 * Created by usuario on 02/11/17.
 */

public class MenuPrincipal implements Screen {

    private Stage escena;
    private Table tabla;
    private Button botonJugar, botonSalir;
    private Label encabezado;
    private Skin skin;
    private BitmapFont letra;
    private TextureAtlas atlas;


    @Override
    public void show() {
        escena = new Stage();
        letra = new BitmapFont(Gdx.files.internal("font/pirate.fnt"), false);
        atlas = new TextureAtlas("ui/boton.atlas");
        skin = new Skin(atlas);
        tabla = new Table(skin);
        tabla.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        // creando botones
        TextButton.TextButtonStyle estilo_boton = new TextButton.TextButtonStyle();
        estilo_boton.up = skin.getDrawable("boton.arriba");
        estilo_boton.down = skin.getDrawable("boton.abajo");
        estilo_boton.pressedOffsetX = 1;
        estilo_boton.pressedOffsetY = -1;
        estilo_boton.font = letra;
        estilo_boton.fontColor = Color.BLACK;

        botonJugar = new TextButton("Jugar", estilo_boton);
        botonJugar.setTouchable(Touchable.enabled);
        botonSalir = new TextButton("Salir", estilo_boton);
        botonSalir.setTouchable(Touchable.enabled);
        botonJugar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Splash());
            }
        });


        botonJugar.pad(30);
        botonSalir.pad(30);

        // crear encabezado
        Label.LabelStyle estilo_encabe = new Label.LabelStyle(letra, Color.WHITE);
        encabezado = new Label(Mathica.TITLE, estilo_encabe);
        encabezado.setFontScale(2.5f);


        // creando la tabla contenedora
        tabla.add();
        tabla.add(encabezado);
        tabla.row().spaceBottom(100);
        tabla.add();
        tabla.add(botonJugar);
        tabla.add();
        tabla.add(botonSalir);
        tabla.debugTable();

        escena.addActor(tabla);


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
        letra.dispose();
        atlas.dispose();

    }
}
