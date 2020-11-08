package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tiles 
{
	private ArrayList<Tile> tile;
	
	private ArrayList<Tile> foregroundTiles;
	private ArrayList<Tile> backgroundTiles;
	
	public Tiles()
	{
		tile = new ArrayList<Tile>();
		
		foregroundTiles = new ArrayList<Tile>();
		backgroundTiles = new ArrayList<Tile>();
	}
	
	public void update()
	{
		/*
			for(int i = 0; i < foregroundTiles.size(); i++)//Fix This
				foregroundTiles.get(i).update();
			for(int i = 0; i < backgroundTiles.size(); i++)
				backgroundTiles.get(i).update();
			}*/
		
		for(int y = 0; y < Game.getScreenHeightInTiles() + 1; y++)
			for(int x = 0; x < Game.getScreenWidthInTiles(); x++)
				if(Map.getMapX() + x < Map.getMapSize() && Map.getMapY() + y < Map.getMapSize())
				{
					foregroundTiles.get(((Map.getMapY() + y) * Map.getMapSize()) + (Map.getMapX() + x)).update();
					backgroundTiles.get(((Map.getMapY() + y) * Map.getMapSize()) + (Map.getMapX() + x)).update();
				}
			

	}
	
	
	public void addTile(Tile tile)
	{
		this.tile.add(tile);
	}
	
	public ArrayList<Tile> getTile()
	{
		return tile;
	}
	
	public Tile getTilesByName(String name)
	{
		Tile t = tile.get(1);
		
		for(int i = 0; i < tile.size(); i++)
			if(tile.get(i).getName().compareTo(name) == 0)
				t = tile.get(i);
		return t;
	}
	
	public void addForegroundTiles(Tile tile)
	{
		this.foregroundTiles.add(tile);
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
		this.backgroundTiles.add(tile);
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
