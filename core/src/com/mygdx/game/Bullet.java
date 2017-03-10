package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis Oleynyk on 04.03.17.
 * Mail deoniisii@gamal.com
 */
public class Bullet {
    public static final int X = Size.HEIGHT;
    public static final int Y = Size.WIDTH;
    private Vector2 position;
    private float speed;
    private boolean active;


    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }


    public Bullet() {
        position = new Vector2(0, 0);
        speed = 500.0f;// сделать привязку к дельта тайм(какдр в сек)
        active = false;

    }

    public void destroy() {
        active = false;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;

    }

    public void updateBullet(float deltaTime) {
        position.x += speed * deltaTime;
        if (position.y > Y) {
            destroy();

        }


    }




}
