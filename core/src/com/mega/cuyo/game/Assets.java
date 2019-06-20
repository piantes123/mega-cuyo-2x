package com.mega.cuyo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.mega.cuyo.actores.AssetBossXaloMalo;
import com.mega.cuyo.actores.AssetCuyo;
import com.mega.cuyo.actores.AssetLevelDecoration;
import com.mega.cuyo.actores.AssetMegaMan;
import com.mega.cuyo.actores.AssetMuro;
import com.mega.cuyo.utils.Constantes;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    public AssetMegaMan megaman;
    public AssetMuro muro;
    public AssetBossXaloMalo bossXaloMalo;
    public AssetCuyo cuyo;
    public AssetLevelDecoration decoracionNivel;

    private AssetManager assetManager;

    // singleton: prevent instantiation from other classes
    private Assets() {

    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        // set asset manager error handler
        assetManager.setErrorListener(this);
        // load texture atlas
        assetManager.load(Constantes.RUTA_TEXTURE_ATLAS_OBJECTS_ATLAS, TextureAtlas.class);
        // start loading assets and wait until finished
        assetManager.finishLoading();
        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
        for (String a : assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + a);
        }

        TextureAtlas atlas = assetManager.get(Constantes.RUTA_TEXTURE_ATLAS_OBJECTS_ATLAS);
        // enable texture filtering for pixel smoothing
        for (Texture t : atlas.getTextures()) {
            t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }
        
        // create game resource objects
        megaman = new AssetMegaMan(atlas);
        muro = new AssetMuro(atlas);
        cuyo = new AssetCuyo(atlas);
        bossXaloMalo = new AssetBossXaloMalo(atlas);
        decoracionNivel = new AssetLevelDecoration(atlas);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception) throwable);
    }

}
