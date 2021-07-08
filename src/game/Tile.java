package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tile 
{
	private Sprite sprite;
	private int width;
	private int height;
	private int x;
	private int y;
	private int id;
	private int animationFrames;
	private int currentFrame = (int) (Math.random() * animationFrames);
	
	int i = Gdx.graphics.getFramesPerSecond();///////////////////////////////////////////////////////////////////fix
	
	private boolean walkable;
	private boolean animated;
	
	private String name;
	private String path;
	private String group;
	private String layer;
	
	public Tile(Tile tile)
	{
		this.x = tile.getX();
		this.y = tile.getY();
		this.width = tile.getWidth();
		this.height = tile.getHeight();
		this.id = tile.getID();
		this.name = tile.getName();
		this.sprite = tile.getSprite();
		this.walkable = tile.getWalkable();
		this.animated = tile.getAnimated();
		this.animationFrames = tile.getAnimationFrames();
		this.path = tile.getPath();
		this.layer = tile.getLayer();
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
		
	}
	public Tile(int x, int y, int width, int height, int id, Sprite sprite)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.sprite = sprite;
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public Tile(int x, int y, int width, int height, int id, String name, Sprite sprite)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.name = name;
		this.sprite = sprite;
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public Tile(int width, int height, int id, Sprite sprite)
	{
		this.width = width;
		this.height = height;
		this.id = id;
		this.sprite = sprite;
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public Tile(int width, int height, int id, String name, Sprite sprite)
	{
		this.width = width;
		this.height = height;
		this.id = id;
		this.name = name;
		this.sprite = sprite;
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public Tile(int width, int height, String name, Sprite sprite)
	{
		this.width = width;
		this.height = height;
		this.name = name;
		this.sprite = sprite;
		
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public Tile()
	{
		this.currentFrame = (int) (Math.random() * this.animationFrames);
	}
	
	public void update()
	{
		if(animated)
		{
			if(i == 0)
			{
				sprite.setRegion(sprite.getRegionWidth() * (currentFrame), 0, sprite.getRegionWidth(), sprite.getRegionHeight());
				sprite.flip(false, true);
				i = Gdx.graphics.getFramesPerSecond();
				
				if(currentFrame <= 0)
					currentFrame = animationFrames;
				
				currentFrame--;
			}
			i--;
		}
	}
	
	public int getAnimationFrames(){return animationFrames;}
	
	public void setAnimationFrames(int animationFrames){this.animationFrames = animationFrames;}
	
	public String getName(){return name;}
	
	public void setName(String name){this.name = name;}
	
	public String getPath(){return path;}
	
	public void setPath(String path){this.path = path;}
	
	public String getGroup(){return group;}
	
	public void setGroup(String group){this.group = group;}
	
	public String getLayer(){return layer;}
	
	public void setLayer(String layer){this.layer = layer;}
	
	public int getID(){return id;}
	
	public void setID(int id){this.id = id;}
	
	public int getWidth(){return width;}
	
	public int getHeight(){return height;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
	public void setX(int x){this.x = x;}
	
	public void setY(int y){this.y = y;}
	
	public boolean getWalkable(){return walkable;}
	
	public void setWalkable(boolean walkable){this.walkable = walkable;}
	
	public boolean getAnimated(){return animated;}
	
	public void setAnimated(boolean animated){this.animated = animated;}
	
	public void setWidth(int width){this.width = width;}
	
	public void setHeight(int height){this.height = height;}
	
	public Sprite getSprite(){return sprite;}
	
	public void setSprite(Sprite sprite){this.sprite = sprite;}
}
