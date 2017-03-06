package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background background;
    Hero hero;
    private final int ASTEROIDS_COUNTER = 30;
    Asteroid[] asteroids;
    private final int BULLETS_COUNT = 200;
    //TODO
    public static Bullet[] bullets;//упрощение сделать понормальому
    private Texture textureBullet;


    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        hero = new Hero();
        asteroids = new Asteroid[ASTEROIDS_COUNTER];
        for (int i = 0; i < ASTEROIDS_COUNTER; i++) {
            asteroids[i] = new Asteroid();
        }
        bullets = new Bullet[BULLETS_COUNT];
        for (int i = 0; i < BULLETS_COUNT; i++) {
            bullets[i] = new Bullet();
        }

        textureBullet = new Texture("bullet20.png");


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        hero.render(batch);
        for (int i = 0; i < ASTEROIDS_COUNTER; i++) {
            asteroids[i].render(batch);
        }
        for (int i = 0; i < BULLETS_COUNT; i++) {
            if (bullets[i].isActive())
                batch.draw(textureBullet, bullets[i].getPosition().x, bullets[i].getPosition().y);
        }
        updateMyGdxGame();
        batch.end();

    }

    public void updateMyGdxGame() {
        background.updateBackground();
        hero.updateHero();
        for (int i = 0; i < ASTEROIDS_COUNTER; i++) {
            asteroids[i].updateAsteroid();
        }
        for (int i = 0; i < BULLETS_COUNT; i++) {
            if (bullets[i].isActive()) {
                bullets[i].updateBullet();
            }
        }


    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
