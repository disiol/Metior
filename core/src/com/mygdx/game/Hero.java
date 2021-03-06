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
    public static final int HERO_X_SIZE = 80;
    public static final int HERO_Y_POSITION = 10;
    public static final int HERO_X_POSITION = 10;
    private Texture textureHero;
    private Vector2 position;
    private float speed;
    private int fireRate;
    private int fireCounter;
    private int rate = 5;

    public Hero() {
        textureHero = new Texture("hero 80*60_2.jpg");
        position = new Vector2(100, 100);
        //TODO
        speed = 400.0f;
        fireRate = rate;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureHero, position.x, position.y);

    }

    public void updateHero(float deltaTime) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (fireCounter == 0) {
                fire(position.x + 40, position.y + 10);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 1;
                fire(position.x + 40, position.y + 10);
                //TODO
                // реализовать вылет 3 пуль
//                fire(position.x + 40, position.y + 5);
//                fire(position.x + 40, position.y);

            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += speed * deltaTime;
            if (position.y > Y) {
                position.y = -60;
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= speed * deltaTime;
            if (position.y < -60) {
                position.y = Y;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= speed * deltaTime;
            if (position.x < 0) {
                position.x = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += speed * deltaTime;
            if (position.x > X - HERO_X_SIZE) {
                position.x = X - HERO_X_SIZE;
            }

        }
    }

    public void fire(float x, float y) {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].setup(x, y);
                break;
            }
        }
    }

}
