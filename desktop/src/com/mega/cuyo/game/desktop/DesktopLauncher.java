package com.mega.cuyo.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mega.cuyo.game.MegaCuyoX;


public class DesktopLauncher {

    private static boolean rebuildAtlas = false;
    private static boolean drawDebugOutline = true;

    public static void main(String[] arg) {

        if (rebuildAtlas) {
            Settings settings = new Settings();
            settings.maxWidth = 1024;
            settings.maxHeight = 1024;
            settings.duplicatePadding = false;
            settings.debug = drawDebugOutline;
            TexturePacker.process(settings, "assets-raw/images", "../core/assets/images/","megacuyo.pack");
        }
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Mega Cuyo X";
        config.width = 800;
        config.height = 480;
        
        MegaCuyoX game = new MegaCuyoX();
        new LwjglApplication(game, config);
    }
}
