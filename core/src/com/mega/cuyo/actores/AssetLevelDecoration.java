package com.mega.cuyo.actores;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetLevelDecoration {

    public final AtlasRegion edificios;

    public AssetLevelDecoration(TextureAtlas atlas) {
        edificios = atlas.findRegion("fondo-edificios-1");
        
    }
}
