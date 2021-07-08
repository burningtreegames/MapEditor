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
	
	private static ArrayList<String> group;
	private static String[][] groupMap;
	private static int groups;
	private static int maxGroupSize;
	
	public ResourceLoader()
	{
		tiles = new Tiles();
		
		group = new ArrayList<String>();
		
		groups = 0;
		maxGroupSize = 0;
		
		fileReader();
		mapSaver();
		
		findMaxGroupSize();
		
		groupMap = new String[groups][maxGroupSize];

		System.out.println("tiles loaded = " + getTiles().getTiles().size());
		
		populateGroupMap();
		
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
			case "group":
				tile.setGroup(wordsArray[i + 1]);
				group.add(wordsArray[i + 1]);
				groups++;
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
				tile.setID(tiles.getTiles().size());
				tiles.addTiles(tile);
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
	
	public void findMaxGroupSize()
	{
		int tmpMax = 0;
		
		for(int i = 0; i < group.size(); i++)
		{
			for(int j = 0; j < group.size(); j++)
				if(group.get(i).compareTo(group.get(j)) == 0)
				{
					group.remove(j);
					tmpMax++;
				}
			
			if(tmpMax > maxGroupSize)
				maxGroupSize = tmpMax;
			
			tmpMax = 0;
		}
		
		System.out.println("groups = " + group.size() + " maxGroupSize = " + maxGroupSize);
	}
	
	public void populateGroupMap()
	{
		int tmp = 0 ;
		
		for(int i = 0; i < group.size(); i++)
		{
			for(int j = 0; j < tiles.getTiles().size(); j++)
			{
				
				String a = tiles.getTiles().get(j).getGroup();
				String b = group.get(i);
				
				if(a != null && a.compareTo(b) == 0);
				{
					//System.out.println("i = " + i + " j = " + j + " tmp = " + tmp);
					//groupMap[i][tmp] = tiles.getTiles().get(j).getName();
					System.out.println(a + "   " + b);
					tmp++;
				}
				//System.out.println(tiles.getTiles().get(j).getGroup());
			}
			tmp = 0;
		}
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
