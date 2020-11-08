package game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Button
{
	
	private int width;
	private int height;
	private Sprite sprite;
	
	public Button(int width, int height, Sprite sprite)
	{
		this.width = width;
		this.height = height;
		this.sprite = new Sprite(sprite);
		
	}
	
	public void render()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public void setWidht(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setSprite(Sprite sprite)
	{
		this.sprite = sprite;
	}
}
