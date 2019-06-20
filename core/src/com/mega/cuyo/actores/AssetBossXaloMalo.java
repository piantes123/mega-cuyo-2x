package com.mega.cuyo.actores;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetBossXaloMalo {
    
    public final AtlasRegion xalo;
    
    public AssetBossXaloMalo(TextureAtlas atlas) {
        this.xalo = atlas.findRegion("xalo_malo_chico");
    }

}
