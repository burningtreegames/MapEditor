package game;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ResourceLoader
{
	private FileHandle file;
	private Sprite sprite;
	private Tiles tiles;
	
	public ResourceLoader()
	{
		tiles = new Tiles();
		
		fileReader();
		mapSaver();
		System.out.println("tiles loaded = " + getTiles().getTile().size());
	}
	
	public void fileReader()
	{
		file = new FileHandle(Gdx.files.getLocalStoragePath() + "/bin/resources/Objects.txt");
		Tile tile = new Tile();
		
		
		String wordsArray[] = file.readString().split("\\r?\\n");
		
		for(int i = 0; i < wordsArray.length; i++) 
		{
			
			switch(wordsArray[i]) 
			{
			case "name":
				tile.setName(wordsArray[i + 1]);	
			break;	
			case "path":
				tile.setPath(wordsArray[i + 1]);
			break;
			case "layer":	
				tile.setLayer(wordsArray[i + 1]);
			break;
			case "animated":			
				if(wordsArray[i + 1].compareTo("true") == 0)
					tile.setAnimated(true);
				else if(wordsArray[i + 1].compareTo("true") != 0)
					tile.setAnimated(false);
			break;
			case "animation_frames":			
				tile.setAnimationFrames(Integer.parseInt(wordsArray[i + 1]));
			break;
			case "walkable":			
				if(wordsArray[i + 1].compareTo("true") == 0)
					tile.setWalkable(true);
				else if(wordsArray[i + 1].compareTo("true") != 0)
					tile.setWalkable(false);
			break;
			case "end":
				sprite = new Sprite(new Texture(new FileHandle(Gdx.files.getLocalStoragePath() + tile.getPath())));
				tile.setSprite(sprite);
				tile.getSprite().setRegion(0, 0, (int)sprite.getHeight(), (int)sprite.getHeight());
				sprite.flip(false, true);
				tile.setWidth((int)sprite.getHeight());
				tile.setHeight((int)sprite.getHeight());
				tiles.addTile(tile);
				tile = new Tile();
			break;
			}
	
		}
		
	}
	
	public void mapSaver()
	{
		file = new FileHandle(Gdx.files.getLocalStoragePath() + "/bin/resources/Maps/" + Map.getMapName() + ".txt");
		file.delete();
		file.writeString("Butts", true);
		Tile tile = new Tile();
		
		
	}
	
	public Tiles getTiles()
	{
		return tiles;
	}

	public void setTiles(Tiles tiles)
	{
		this.tiles = tiles;
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
}
