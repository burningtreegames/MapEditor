package game;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Map 
{
	
	private ResourceLoader resourceLoader;
	private static Tiles tiles;

	private static int mapSize;
	private static String mapName;
		
	private static int mapX;
	private static int mapY;
	
	public Map()
	{	
		mapName = "UntitledMap";
		resourceLoader = new ResourceLoader();
		tiles = new Tiles();
		tiles = resourceLoader.getTiles();
		
		mapSize = 512;
		mapX = 0;
		mapY = 0;
		
		populateMap();
	}
				
	public void populateMap()
	{
		Tile tile = new Tile();
		for(int y = 0; y < mapSize; y++)
			for(int x = 0; x < mapSize; x++)
			{
				tile = new Tile(Tiles.getTilesByName("Grass"));
				tile.setX(x);
				tile.setY(y);
				Tiles.addBackgroundTiles(tile);
				
				tile = new Tile(Tiles.getTilesByName("Delete"));
				
				tile.setX(x);
				tile.setY(y);
				Tiles.addForegroundTiles(tile);
			}
	}
	
	public void render()
	{
		Gdx.gl.glEnable(GL11.GL_BLEND);
		Gdx.gl.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(Game.getCamera().combined);
		spriteBatch.begin();
		
		
		
		for(int y = 0; y < Game.getScreenHeightInTiles() + 1; y++)
			for(int x = 0; x < Game.getScreenWidthInTiles(); x++)
				if(mapX + x < mapSize && mapY + y < mapSize)
				{
					
					spriteBatch.draw(Tiles.getBackgroundTiles().get(((mapY + y) * mapSize) + (mapX + x)).getSprite(), x * Game.getSpriteSize(), y * Game.getSpriteSize(), Game.getSpriteSize(), Game.getSpriteSize());
						
					if(Tiles.getForegroundTiles().get(((mapY + y) * mapSize) + (mapX + x)).getName().compareTo("Delete") != 0) // If Not Delete Tile
						spriteBatch.draw(Tiles.getForegroundTiles().get(((mapY + y) * mapSize) + (mapX + x)).getSprite(), x * Game.getSpriteSize(), y * Game.getSpriteSize(), Game.getSpriteSize(), Game.getSpriteSize());
				
					if(Maths.insideRectangle(x * Game.getSpriteSize(), y * Game.getSpriteSize(), (int)(Gdx.input.getX() / Game.getScale()), (int)(Gdx.input.getY() / Game.getScale()), Game.getSpriteSize()))
					{
						spriteBatch.draw(Tiles.getTile().get(Cursor.getMouseWheelTileID()).getSprite(), x * Game.getSpriteSize(), (y * Game.getSpriteSize()), Game.getSpriteSize(), Game.getSpriteSize());
						spriteBatch.draw(Tiles.getTilesByName("Cursor").getSprite(), x * Game.getSpriteSize(), (y * Game.getSpriteSize()), Game.getSpriteSize(), Game.getSpriteSize());
					}
				}
		
		spriteBatch.end();
		spriteBatch.dispose();
		 
	}
	
	public void update()
	{
		tiles.update();
	}
	
	public static int getMapSize(){return mapSize;}
	public static int getMapX(){return mapX;}
	public static int getMapY() {return mapY;}
	public static void setMapX(int x){mapX = mapX + x;}
	public static void setMapY(int y){mapY = mapY + y;}
	
	public static String getMapName() {return mapName;}
	public static void setMapName(String name){mapName = name;}
	
	public static Tiles getTiles() {return tiles;}
	
	public static void setForegroundTileAtXY(int x, int y, Tile tile)
	{
		Tiles.getForegroundTiles().set(((mapY + y) * mapSize) + (mapX + x), tile);
	}
	public static void setBackgroundTileAtXY(int x, int y, Tile tile)
	{
		Tiles.getBackgroundTiles().set(((mapY + y) * mapSize) + (mapX + x), tile);
	}
	
	public static Tile getForegroundTileAtXY(int x, int y){return Tiles.getForegroundTiles().get(((mapY + y) * mapSize) + (mapX + x));}
	public static Tile getBackgroundTileAtXY(int x, int y){return Tiles.getBackgroundTiles().get(((mapY + y) * mapSize) + (mapX + x));}
}
