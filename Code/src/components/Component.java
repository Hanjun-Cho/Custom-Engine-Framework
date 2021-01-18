package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import entities.Tag;

public class Component {

	public int componentID;
	private Entity parent;
	
	public void init() {}
	public void update() {}
	public void setParent(Entity parent) { this.parent = parent;}
	public Entity getParent() {return parent;}

	/**
	 * Rendering Specific
	 */
	private Color color;
	private BufferedImage sprite;
	public void draw(Graphics g) {}
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}
	public BufferedImage getSprite() {return sprite;}
	public void setSprite(BufferedImage sprite) {this.sprite = sprite;}
	public List<Tag> allowedTags = new ArrayList<>();
	
	/**
	 * Physics Specific
	 */
	private double gravity;
	public double getGravity() {return gravity;}
	public void setGravity(double gravity) {this.gravity = gravity;}
	public void doCollision(Entity collisionEntity) {}
}
