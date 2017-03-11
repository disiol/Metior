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
    private float angle;
    private int hp;

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
        hp = 10;
        if (textureAsteroid == null) {
            textureAsteroid = new Texture("asteroid60.tga");
        }


    }

    public int getHP(){
        return hp;
    }


    public void render(SpriteBatch batch) {
        //batch.draw(textureAsteroid, position.x, position.y);
        batch.draw(textureAsteroid, position.x, position.y, 30, 30, 60, 60, 1.0f,
                1.0f, angle, 0, 0, 60, 60, false, false);
    }

    public void recreate() {
        position = new Vector2((float) Math.random() * X, (float) Math.random() * Y);
        speedAsteroid();
        angle = (float) Math.random() * 360;
    }

    public void getDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            recreate();
        }

    }

    public void updateAsteroid(float deltaTime) {
        position.x -= speed * deltaTime;
        angle += speed * deltaTime / 2;
        if (position.x < -DELAY) {
            recreate();
        }
        rectangle.x = position.x;
        rectangle.y = position.y;


    }


    private void speedAsteroid() {
        speed = 50.0f * (float) Math.random() * 10.0f;
    }


}
