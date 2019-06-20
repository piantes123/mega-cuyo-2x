package com.mega.cuyo.actores;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetCuyo {

    
public final AtlasRegion cuyo;
    
    public AssetCuyo(TextureAtlas atlas) {
        cuyo = atlas.findRegion("cuyo-1");
    }
}
