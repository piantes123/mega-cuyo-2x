package com.mega.cuyo.actores;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetMuro {

    public final AtlasRegion muro;

    public AssetMuro(TextureAtlas atlas) {
        muro = atlas.findRegion("muro");
    }
}
