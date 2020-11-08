package game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener
{
	private static int windowWidth = 1024;
	private static int windowHeight = 576;
	private static int spriteSize = 64;
	private static int screenWidthInTiles;
	private static int screenHeightInTiles;
	private static float scale;
	
	private static OrthographicCamera camera;
	private Map map;
	
	private static GUI gui;
	
	private Cursor cursor;
	
	public void create()
	{
		System.out.println("Currently working controls.");
		System.out.println("F11 fullscreen, wasd & arrows move map + shift to step one, left mouse place tile foreground, rightmouse place tile background.");
		System.out.println("Foreground tiles are things like trees, npcs and rocks, background tiles are things like grass and water.");
		System.out.println("X is the delete foreground tile and background tiles you just overwrite with new tile.");
		System.out.println("Scroll wheel to change between tiles.");
		System.out.println("Nothing useful yet just a work in progress more coming soon.");
		camera = new OrthographicCamera(Game.getWindowWidth(), Game.getWindowHeight());
		camera.setToOrtho(true, Game.getWindowWidth(), Game.getWindowHeight());
		
		gui = new GUI(Game.getWindowWidth() - (spriteSize * 2), 0, spriteSize * 2, Game.getWindowHeight());
		map = new Map();
		cursor = new Cursor();
		
		scale = (float)Gdx.graphics.getWidth() / windowWidth;
		
		tileRescale();
	}
	
	public void render()
	{
		map.render();
		gui.render();
		
		update();
	}
	
	public void update()
	{
		inputListener();
		map.update();
		cursor.update();
		
		Gdx.graphics.setTitle("MapEditor, FPS = " + Gdx.graphics.getFramesPerSecond() + " DT = " + Gdx.graphics.getDeltaTime());
	}
	
	public void inputListener()
	{
		if (Gdx.input.isKeyPressed(Keys.F11)){
		    Boolean fullScreen = Gdx.graphics.isFullscreen();
		        Graphics.DisplayMode currentMode = Gdx.graphics.getDisplayMode();
		        if (fullScreen == true)
		        {
		            Gdx.graphics.setWindowedMode(Game.getWindowWidth(), Game.getWindowHeight());
		            scale = (float)Gdx.graphics.getWidth() / windowWidth;
		        }
		        else 
		        {
		            Gdx.graphics.setFullscreenMode(currentMode);
		            scale = (float)Gdx.graphics.getWidth() / windowWidth;
		        }
		        
		}
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			Gdx.app.exit();
	}
	
	public static void tileRescale()
	{		
		gui.setX(Game.getWindowWidth() - (spriteSize * 2));
		gui.setY(0);
		gui.setWidht(spriteSize * 2);
		gui.setHeight(windowHeight);
		screenWidthInTiles = (Game.getWindowWidth() - Game.getGUI().getWidth()) / Game.getSpriteSize();
		screenHeightInTiles = Game.getWindowHeight() / Game.getSpriteSize();
	}
	
	public void pause(){}
	public void resize(int arg0, int arg1){scale = (float)Gdx.graphics.getWidth() / windowWidth;}
	public void resume(){}
	public void dispose(){}
	
	public static OrthographicCamera getCamera(){return camera;}

	public static float getScale(){return scale;}
	public static int getWindowWidth(){return windowWidth;}
	public static int getWindowHeight(){return windowHeight;}
	public static int getSpriteSize(){return spriteSize;}
	public static void setSpriteSize(int size){spriteSize = size;}
	
	public static int getScreenWidthInTiles(){return screenWidthInTiles;}
	public static int getScreenHeightInTiles() {return screenHeightInTiles;}

	
	public static GUI getGUI(){return gui;}

}
