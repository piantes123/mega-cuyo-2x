package com.mega.cuyo.actores;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetMegaMan {

    
    public final AtlasRegion megaman;
    
    public AssetMegaMan(TextureAtlas atlas) {
        megaman = atlas.findRegion("mega-hombre");
    }
}
