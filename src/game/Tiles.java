package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tiles 
{
	private static ArrayList<Tile> tiles;
	
	private static ArrayList<Tile> foregroundTiles;
	private static ArrayList<Tile> backgroundTiles;
	
	public Tiles()
	{
		tiles = new ArrayList<Tile>();
		
		foregroundTiles = new ArrayList<Tile>();
		backgroundTiles = new ArrayList<Tile>();
	}
	
	public void update()
	{
		for(int y = 0; y < Game.getScreenHeightInTiles() + 1; y++)
			for(int x = 0; x < Game.getScreenWidthInTiles(); x++)
				if(Map.getMapX() + x < Map.getMapSize() && Map.getMapY() + y < Map.getMapSize())
				{
					foregroundTiles.get(((Map.getMapY() + y) * Map.getMapSize()) + (Map.getMapX() + x)).update();
					backgroundTiles.get(((Map.getMapY() + y) * Map.getMapSize()) + (Map.getMapX() + x)).update();
				}
	}
	
	
	public static void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	public static ArrayList<Tile> getTile()
	{
		return tiles;
	}
	
	public static Tile getTilesByName(String name)
	{
		Tile t = tiles.get(1);
		
		for(int i = 0; i < tiles.size(); i++)
			if(tiles.get(i).getName().compareTo(name) == 0)
				t = tiles.get(i);
		return t;
	}
	
	public static void addForegroundTiles(Tile tile)
	{
		foregroundTiles.add(tile);
	}
	
	public static ArrayList<Tile> getForegroundTiles()
	{
		return foregroundTiles;
	}
	
	public static Tile getForegroundTilesByName(String name)
	{
		Tile t = foregroundTiles.get(1);
		
		for(int i = 0; i < foregroundTiles.size(); i++)
			if(foregroundTiles.get(i).getName().compareTo(name) == 0)
				t = foregroundTiles.get(i);
		return t;
	}
	
	public static void addBackgroundTiles(Tile tile)
	{
		backgroundTiles.add(tile);
	}
	
	public static ArrayList<Tile> getBackgroundTiles()
	{
		return backgroundTiles;
	}
	
	public static Tile getBackgroundTilesByName(String name)
	{
		Tile t = backgroundTiles.get(1);
		
		for(int i = 0; i < backgroundTiles.size(); i++)
			if(backgroundTiles.get(i).getName().compareTo(name) == 0)
				t = backgroundTiles.get(i);
		return t;
	}

}
