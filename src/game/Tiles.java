package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tiles 
{
	private ArrayList<Tile> tiles;
	
	private ArrayList<Tile> foregroundTiles;
	private ArrayList<Tile> backgroundTiles;
	
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
	
	
	public void addTiles(Tile tile)
	{
		tiles.add(tile);
	}
	
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	public Tile getTilesByName(String name)
	{
		Tile t = tiles.get(1);
		
		for(int i = 0; i < tiles.size(); i++)
			if(tiles.get(i).getName().compareTo(name) == 0)
				t = tiles.get(i);
		return t;
	}
	
	public void addForegroundTiles(Tile tile)
	{
		foregroundTiles.add(tile);
	}
	
	public ArrayList<Tile> getForegroundTiles()
	{
		return foregroundTiles;
	}
	
	public Tile getForegroundTilesByName(String name)
	{
		Tile t = foregroundTiles.get(1);
		
		for(int i = 0; i < foregroundTiles.size(); i++)
			if(foregroundTiles.get(i).getName().compareTo(name) == 0)
				t = foregroundTiles.get(i);
		return t;
	}
	
	public void addBackgroundTiles(Tile tile)
	{
		backgroundTiles.add(new Tile(tile));
	}
	
	public ArrayList<Tile> getBackgroundTiles()
	{
		return backgroundTiles;
	}
	
	public Tile getBackgroundTilesByName(String name)
	{
		Tile t = backgroundTiles.get(1);
		
		for(int i = 0; i < backgroundTiles.size(); i++)
			if(backgroundTiles.get(i).getName().compareTo(name) == 0)
				t = backgroundTiles.get(i);
		return t;
	}

}
