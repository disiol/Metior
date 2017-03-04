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
        speedBullet();
        active = false;

    }

    public void destroy() {
        active = false;
    }

    public void setatp(int x, int y) {
        position.x = x;
        position.y = y;

    }

    public void updateBullet() {
        position.x += speed;
        if (position.y > Y) {
            destroy();

        }


    }

    private void speedBullet() {
        speed = 20.0f;
    }


}
