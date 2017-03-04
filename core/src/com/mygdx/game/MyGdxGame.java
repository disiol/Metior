package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background background;
    Hero hero;
    private final int ASTEROIDS_CAUNTER = 30;
    Asteroid[] asteroids;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        hero = new Hero();
        asteroids = new Asteroid[ASTEROIDS_CAUNTER];
        for (int i = 0; i <ASTEROIDS_CAUNTER; i++){
            asteroids[i] = new Asteroid();
        }


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        hero.render(batch);
        for (int i = 0; i <ASTEROIDS_CAUNTER; i++){
            asteroids[i].render(batch);
        }
        updateMyGdxGame();
        batch.end();


    }

    public void updateMyGdxGame() {
        background.updateBackground();
        hero.updateHero();
        for (int i = 0; i <ASTEROIDS_CAUNTER; i++){
            asteroids[i].updateAsteroid();
        }


    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
