package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis Oleynyk on 03.03.17.
 * Mail deoniisii@gamal.com
 */
public class Asteroid {


    //TODO
    public static final int DELAY = 60;
    public static final int X = Size.WIDTH + DELAY;
    public static final int Y = Size.HEIGHT;
    private Vector2 position;
    private float speed;
    private static Texture textureAsteroid;
    private Rectangle rectangle;

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    public Asteroid() {
        position = new Vector2(X + (float) Math.random() * X, (float) Math.random() * Y);
        speedAsteroid();
        rectangle = new Rectangle(position.x, position.y, 60, 60);
        if (textureAsteroid == null) {
            textureAsteroid = new Texture("Asteroid60_1.tga");
        }


    }


    public void render(SpriteBatch batch) {
        batch.draw(textureAsteroid, position.x, position.y);

    }

    private void recreate() {
        position = new Vector2((float) Math.random() * X, (float) Math.random() * Y);
        speedAsteroid();
    }

    public void updateAsteroid() {
        position.x -= speed;
        if (position.x < -DELAY) {
            recreate();
        }
        rectangle.x = position.x;
        rectangle.y = position.y;


    }


    private void speedAsteroid() {
        //TODO
        //дпрвязку к дельта кадру
        speed = 4.0f * (float) Math.random() * 8.0f;
    }


}
