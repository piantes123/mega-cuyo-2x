package com.mega.cuyo.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.mega.cuyo.niveles.Nivel;

/**
 * 
 * @author fareyese
 *
 *         Juego Mega Cuyo X
 * 
 *         -Sera juego de plataforma en 2D - de desplazamiento lateral -Actores
 *         del juego: -Mega Man, sera el protagonista controlado por el jugador
 *         -Cuyos, seran los enemigos controlados por la IA -Terreno, servira
 *         como plataforma para hacer caminos y posicionar al jugador y la IA
 *         -Agua o Lava, si el jugador la toca muere inmediatamente
 *
 */
public class MegaCuyoX extends ApplicationAdapter {

    private static final String TAG = MegaCuyoX.class.getName();

    private WorldController worldController;
    private WorldRenderer worldRenderer;

    private Nivel nivelActual;

    private static final String TAG_CREATE = "CREATE";
    
    private boolean paused;

    @Override
    public void create() {
        // Set Libgdx log level to DEBUG
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // Load assets
        Assets.instance.init(new AssetManager());

        // Initialize controller and renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
        
     // Game world is active on start
        paused = false;
    }

    @Override
    public void render() {
        
     // Do not update game world when paused.
        if (!paused) {
            // Update game world by the time that has passed
            // since last rendered frame.
            worldController.update(Gdx.graphics.getDeltaTime());
        }
        
        // Sets the clear screen color to: Cornflower Blue
        Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
        // Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Render game world to screen
        worldRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        Assets.instance.init(new AssetManager());
        paused = false;
    }

    @Override
    public void dispose() {
        worldRenderer.dispose();
        Assets.instance.dispose();
    }
}
