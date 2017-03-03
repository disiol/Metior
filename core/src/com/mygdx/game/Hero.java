package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



/**
 * Created by Denis Oleynyk on 03.03.17.
 * Mail deoniisii@gamal.com
 */
public class Hero {

    public static final int Y = Size.HEIGHT;
    public static final int X = Size.WIDTH;
    public static final int HERO_Y_SIZE = 50;
    public static final int HERO_X_SIZE = 70;
    public static final int HERO_Y_POSITION = 10;
    public static final int HERO_X_POSITION = 10;
    private Texture textureHero;
    private Vector2 position;
    private float speed;

    public Hero() {
        textureHero = new Texture("hero 80*60_2.jpg");
        position = new Vector2(100, 100);
        speed = 10.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureHero, position.x, position.y);

    }

    public void updateHero() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (position.y <= Y - HERO_Y_SIZE) {
                position.y += speed;
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (position.y >= 0 + HERO_Y_POSITION) {
                position.y -= speed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (position.x <= X - HERO_X_SIZE) {
                position.x += speed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (position.x >= 0 + HERO_X_POSITION) {
                position.x -= speed;
            }
        }


    }

}
