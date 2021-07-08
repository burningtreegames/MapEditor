package game;

import org.lwjgl.input.Mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

public class Cursor 
{
	private static int x;
	private static int y;
	private static int mouseWheelTileID;
	
	public Cursor()
	{
		
	}
	
	public void update()
	{
		if(Gdx.input.isButtonJustPressed(Buttons.LEFT))
		{
			x = (int)((Gdx.input.getX() / Game.getScale()) / Game.getSpriteSize());
			y = (int)((Gdx.input.getY() / Game.getScale()) / Game.getSpriteSize());
			
			if(Map.getBackgroundTileAtXY(x, y).getWalkable() && Map.getTiles().getTiles().get(mouseWheelTileID).getLayer().compareTo("foreground") == 0)
			{ 
				Tile tile = new Tile(Map.getTiles().getTiles().get(mouseWheelTileID));////////////////////////////////////FIXXXXXXXXXXXXXXXXXXXXXXXX
				tile.setX(x);
				tile.setY(y);
				Map.setForegroundTileAtXY(x, y, tile);
			}
		}
		
		if(Gdx.input.isButtonJustPressed(Buttons.RIGHT) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			x = (int)((Gdx.input.getX() / Game.getScale()) / Game.getSpriteSize());
			y = (int)((Gdx.input.getY() / Game.getScale()) / Game.getSpriteSize());
			
			if(Map.getForegroundTileAtXY(x, y).getWalkable() && Map.getTiles().getTiles().get(mouseWheelTileID).getLayer().compareTo("background") == 0)
			{
				Tile tile = new Tile(Map.getTiles().getTiles().get(mouseWheelTileID));////////////////////////////////////FIXXXXXXXXXXXXXXXXXXXXXXXX
				tile.setX(x);
				tile.setY(y);
				Map.setBackgroundTileAtXY(x, y, tile);
			}
		}
		
		if(Gdx.input.isButtonJustPressed(Buttons.RIGHT) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			x = (int)((Gdx.input.getX() / Game.getScale()) / Game.getSpriteSize());
			y = (int)((Gdx.input.getY() / Game.getScale()) / Game.getSpriteSize());
			System.out.println("BackgroundTile = " + Map.getBackgroundTileAtXY(x, y).getName() + ", " + Map.getBackgroundTileAtXY(x, y).getID());
			System.out.println(Map.getBackgroundTileAtXY(x, y).getX() + ", " + Map.getBackgroundTileAtXY(x, y).getY());
			System.out.println("Walkable = " + Map.getBackgroundTileAtXY(x, y).getWalkable());
			System.out.println("ForegroundTile = " + Map.getForegroundTileAtXY(x, y).getName() + ", " + Map.getForegroundTileAtXY(x, y).getID());
			System.out.println(Map.getForegroundTileAtXY(x, y).getX() + ", " + Map.getForegroundTileAtXY(x, y).getY());
		}
		
		///////////////////Mouse Scroll Wheel
		int mouseWheel = Mouse.getDWheel();
		if(mouseWheel > 0 && mouseWheelTileID < Map.getTiles().getTiles().size() - 1)
			mouseWheelTileID++;
		else if(mouseWheel < 0 && mouseWheelTileID > 0)
			mouseWheelTileID--;
		
		///////////////////Keyboard WASD & Arrow Quick Move
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapX() < Map.getMapSize() - Game.getScreenWidthInTiles())
				Map.setMapX(+1);
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapX() > 0)
				Map.setMapX(-1);
		}
		if(Gdx.input.isKeyPressed(Keys.UP) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.W) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapY() > 0)
				Map.setMapY(-1);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.S) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapY() < Map.getMapSize() - Game.getScreenHeightInTiles())
				Map.setMapY(+1);
		}
		
		/////////////////////Keyboard WASD & Arrow Step Move w/ Left Shift
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyJustPressed(Keys.D) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapX() < Map.getMapSize() - Game.getScreenWidthInTiles())
				Map.setMapX(+1);
		}
		if(Gdx.input.isKeyJustPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyJustPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapX() > 0)
				Map.setMapX(-1);
		}
		if(Gdx.input.isKeyJustPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyJustPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapY() > 0)
				Map.setMapY(-1);
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyJustPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			if(Map.getMapY() < Map.getMapSize() - Game.getScreenHeightInTiles())
				Map.setMapY(+1);
		}
		
		//Scales Up & Down Sprite Size
		if(Gdx.input.isKeyJustPressed(Keys.PLUS))
		{
			if(Game.getSpriteSize() <= 512)
				Game.setSpriteSize(Game.getSpriteSize() * 2);
			Game.tileRescale();
				
		}
		if(Gdx.input.isKeyJustPressed(Keys.MINUS))
		{
			if(Game.getSpriteSize() > 1)
				Game.setSpriteSize(Game.getSpriteSize() / 2);
				
			Game.tileRescale();;
		}
		
	}
	
	public static int getX(){return x;}
	public static int getY(){return y;}
	public static int getMouseWheelTileID(){return mouseWheelTileID;}
	
}
