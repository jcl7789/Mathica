package com.zeus.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FillViewport;
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
    private TextureAtlas atlas;
    private Music musica;

    public MenuPrincipal(final Mathica game) {
        escena = new Stage(new FillViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        atlas = new TextureAtlas("ui/atlas.pack");
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
        tabla = new Table(skin);
        musica = game.getManager().get("music/principal.mp3");
        musica.setLooping(true);
        tabla.setBounds(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        encabezado = new Label("Bienvenido\na una aventura \nmatematica!", skin, "pirata_negro");
        encabezado.setAlignment(Align.center);
        encabezado.setFontScale(3);
        botonJugar = new TextButton("Jugar", skin);
        botonSalir = new TextButton("Salir", skin);
        botonJugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(null);
                ((Game) Gdx.app.getApplicationListener()).setScreen(new SeleccionJugador(game,musica));
            }
        });
        botonSalir.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    tabla.background(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("img/fondo.png"))))); /*fondo*/
    }


    @Override
    public void show() {
        musica.play();

        // creando la tabla contenedora
        botonJugar.pad(35).padLeft(20).padRight(20);
        botonSalir.pad(35).padLeft(20).padRight(20);

        tabla.add(encabezado).top().center().spaceBottom(tabla.getHeight()/3).colspan(3);
        tabla.row();
        tabla.add().width(tabla.getWidth()/3);
        tabla.add().width(tabla.getWidth()/3);
        tabla.add().width(tabla.getWidth()/3).row();
        tabla.add(botonJugar);
        tabla.add();
        tabla.add(botonSalir);
        tabla.debug();
        escena.addActor(tabla);
        Gdx.input.setInputProcessor(escena);


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
        atlas.dispose();

    }
}
