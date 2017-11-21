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
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.zeus.game.Mathica;

/**
 * Created by usuario on 05/11/17.
 */

public class SeleccionJugador implements Screen {

    private Stage escena;
    private Table tabla;
    private Skin skin;
    private TextureAtlas textureAtlas;
    private TextButton crear;
    private TextButton jugar;
    private TextButton volver;
    private Music musica;
    private List lista;
    private ScrollPane scrollPane;


    public SeleccionJugador(final Mathica game, final Music musica) {
        this.musica = musica;
        escena = new Stage(new FillViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(escena);
        textureAtlas = new TextureAtlas("ui/atlas.pack");
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),textureAtlas);
        tabla = new Table(skin);
        tabla.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        lista = new List(skin);

        crear = new TextButton("Crear", skin);
        crear.pad(25);
        crear.getLabel().setFontScale(0.5f);
        jugar = new TextButton("Jugar", skin);
        jugar.pad(25);
        volver = new TextButton("Volver", skin);
        volver.getLabel().setFontScale(0.5f);
        volver.pad(25);
        tabla.background(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("img/fondo.png"))))); /*fondo*/
        jugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(null);
                musica.stop();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Splash(game));
            }
        });
        volver.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(null);
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MenuPrincipal(game));
            }
        });



    }

    private void rellenar_lista(){
        //Aca se cargan los pjs desde android o null si esta vacio.
        lista = new List(skin);
        lista.setItems("uno","dos","tres");
        scrollPane = new ScrollPane(lista, skin);
    }

    private void setearTabla(){
        //creando la tabla
        //rellenar_lista();
        lista = new List(skin);
        lista.setItems("uno","dos","tres");
        scrollPane = new ScrollPane(lista, skin);
        tabla.clear();
        tabla.debug();
        tabla.debugTable();
        tabla.add("Seleccione su jugador").colspan(4).expandX().spaceBottom(50).row(); ;
        tabla.add().width(tabla.getWidth()/3);
        tabla.add().width(tabla.getWidth()/3);
        tabla.add().width(tabla.getWidth()/3).row();
        tabla.add(scrollPane).expandY().spaceLeft(100).padLeft(100).center();
        tabla.add().width(tabla.getWidth()/3);
        tabla.add(jugar).row();
        tabla.add(crear).bottom().left();
        tabla.add().width(tabla.getWidth()/3);
        tabla.add(volver).bottom().right();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(escena);
        setearTabla();
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
    tabla.setClip(true);
    setearTabla();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        escena.dispose();
        skin.dispose();
        textureAtlas.dispose();

    }
}
