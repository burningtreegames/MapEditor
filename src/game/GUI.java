package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class GUI 
{
	private int width;
	private int height;
	private int x;
	private int y;
	private ArrayList<Button> buttons;
	
	public GUI(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		buttons = new ArrayList<Button>();
	}

	
	public void render()
	{
		ShapeRenderer shape = new ShapeRenderer();
		shape.setProjectionMatrix(Game.getCamera().combined);
		shape.begin(ShapeType.Filled);
		shape.setColor(0.5f, 0.5f, 0.7f, 1);
		shape.rect(x, y, width, height);
		shape.end();
		shape.dispose();
		
		if(buttons.size() > 0)
			for(int i = buttons.size() - 1; i >= 0; i--)
				buttons.get(i).render();
	}
	
	public void update()
	{
		if(buttons.size() > 0)
			for(int i = buttons.size() - 1; i >= 0; i--)
				buttons.get(i).update();
	}
	
	
	
	public int getWidth(){return width;}
	
	public int getHeight(){return height;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
	public void setX(int x){this.x = x;}
	
	public void setY(int y){this.y = y;}
	
	public void setWidht(int width){this.width = width;}
	
	public void setHeight(int height){this.height = height;}
	
	public ArrayList<Button> getButtons(){return buttons;}
	
	public void setButtons(ArrayList<Button> buttons){this.buttons = buttons;}
	
	public void addButtons(Button button){this.buttons.add(button);}
}
