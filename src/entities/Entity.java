package entities;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import components.Component;

public class Entity {

	private String name;
	private int x, y, width, height;
	private int rotX, rotY, rotDir, rotVel;
	private boolean rotating;
	public List<Component> components = new ArrayList<>();
	
	public Entity(String name, int x, int y, int width, int height, List<Component> components) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.components = components;
		
		if(this.components.size() > 0) {
			for(Component component : this.components) {
				component.setParent(this);
				
				if(component.componentID == 0) {
					component.init();
				}
				
				if(component.componentID == 2) {
					component.init();
				}
			}
		}
	}
	
	public boolean hasComponent(int componentID) {
		for(Component component : components) {
			if(component.componentID == componentID) {
				return true;
			}
		}
		
		return false;
	}
	
	public Component getComponent(int componentID) {
		for(int i = 0; i < components.size(); i++) {
			if(components.get(i).componentID == componentID) {
				return components.get(i);
			}
		}
		
		return null;
	}
	
	private Rectangle collisionBox;
	private boolean trigger = false;
	private boolean colRight = false, colLeft = false, colUp = false, colDown = false;
	public Rectangle getCollisionBox() {return collisionBox;}
	public void setCollisionBox(Rectangle collisionBox) {this.collisionBox = collisionBox;}
	public boolean getTrigger() {return trigger;}
	public void setTrigger(boolean trigger) {this.trigger = trigger;}
	public boolean isColRight() {return colRight;}
	public void setColRight(boolean colRight) {this.colRight = colRight;}
	public boolean isColLeft() {return colLeft;}
	public void setColLeft(boolean colLeft) {this.colLeft = colLeft;}
	public boolean isColUp() {return colUp;}
	public void setColUp(boolean colUp) {this.colUp = colUp;}
	public boolean isColDown() {return colDown;}
	public void setColDown(boolean colDown) {this.colDown = colDown;}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRotX() {
		return rotX;
	}

	public void setRotX(int rotX) {
		this.rotX = rotX;
	}

	public int getRotY() {
		return rotY;
	}

	public void setRotY(int rotY) {
		this.rotY = rotY;
	}

	public boolean isRotating() {
		return rotating;
	}

	public void setRotating(boolean rotating) {
		this.rotating = rotating;
	}

	public int getRotDir() {
		return rotDir;
	}

	public void setRotDir(int rotDir) {
		this.rotDir = rotDir;
	}

	public int getRotVel() {
		return rotVel;
	}

	public void setRotVel(int rotVel) {
		this.rotVel = rotVel;
	}
}
