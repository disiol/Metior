package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis Oleynyk on 02.03.17.
 * Mail deoniisii@gamal.com
 */
public class Background {

    class Star {

        public static final int X = Size.WIDTH;
        public static final int Y = Size.HEIGHT;
        private Vector2 position;
        private float speed;

        public Star() {
            position = new Vector2((float) Math.random() * X, (float) Math.random() * Y);
            speedStar();


        }

        public void updateStar() {
            position.x -= speed;
            if (position.x < -20) {
                position.x = X;
                position.y = (float) (Math.random() * Y);
                speedStar();

            }


        }

        private void speedStar() {
            speed = 5.0f * (float) Math.random() * 9.0f;
            //TODO
        }// сделать привязку к дельта тайм(какдр в сек)
    }

    private Texture textureBackground;
    private static Texture textureStar;
    private final int STARS_COUNT = 200;
    private Star[] stars;

    public Background() {
        textureBackground = new Texture("background2.jpg");
        textureStar = new Texture("star2.jpg");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i] = new Star();

        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureBackground, 0, 0);
        for (int i = 0; i < STARS_COUNT; i++) {
            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);

        }
    }

    public void updateBackground() {
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i].updateStar();

        }
    }
}
