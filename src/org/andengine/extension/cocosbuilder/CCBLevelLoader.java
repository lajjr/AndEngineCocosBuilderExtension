package org.andengine.extension.cocosbuilder;

import java.util.HashMap;

import org.andengine.extension.cocosbuilder.loader.CCBEntityLoader;
import org.andengine.extension.cocosbuilder.loader.CCLayerEntityLoader;
import org.andengine.extension.cocosbuilder.loader.CCNodeEntityLoader;
import org.andengine.extension.cocosbuilder.loader.CCSpriteEntityLoader;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.level.IEntityLoader;
import org.andengine.util.level.LevelLoader;

import android.content.res.AssetManager;

/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 16:32:04 - 18.04.2012
 */
public class CCBLevelLoader extends LevelLoader<CCBEntityLoaderDataSource, CCBLevelLoaderResult> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public CCBLevelLoader(final AssetManager pAssetManager, final String pAssetBasePath, final VertexBufferObjectManager pVertexBufferObjectManager, final TextureManager pTextureManager, final FontManager pFontManager) {
		super(new CCBEntityLoaderDataSource(pAssetManager, pAssetBasePath, pVertexBufferObjectManager, pTextureManager, pFontManager));

		this.registerEntityLoader(new CCBEntityLoader());
		this.registerEntityLoader(new CCNodeEntityLoader());
		this.registerEntityLoader(new CCLayerEntityLoader());
		this.registerEntityLoader(new CCSpriteEntityLoader());
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected CCBLevelLoaderContentHandler onCreateLevelLoaderContentHandler(final HashMap<String, IEntityLoader<CCBEntityLoaderDataSource>> pEntityLoaders, final IEntityLoader<CCBEntityLoaderDataSource> pDefaultEntityLoader, final CCBEntityLoaderDataSource pEntityLoaderDataSource) {
		return new CCBLevelLoaderContentHandler(pEntityLoaders, pDefaultEntityLoader, pEntityLoaderDataSource);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
