package com.mega.cuyo.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mega.cuyo.utils.Constantes;

public class WorldRenderer implements Disposable {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();
    }

    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constantes.VIEWPORT_WIDTH, Constantes.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
    }

    public void render() {
        renderTestObjects();
    }

    private void renderTestObjects() {
        worldController.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (Sprite sprite : worldController.testSprites) {
            sprite.draw(batch);
        }
        batch.end();
    }

    public void resize(int width, int height) {
        camera.viewportWidth = (Constantes.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
