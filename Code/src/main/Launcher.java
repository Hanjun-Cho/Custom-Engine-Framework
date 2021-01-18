package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import components.CollisionComponent;
import components.Component;
import components.PhysicsComponent;
import components.ShapeComponent;
import components.SpriteComponent;
import entities.Entity;
import entities.EntityManager;
import entities.Tag;

public class Launcher extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static final int SCREEN_WIDTH = 1920, SCREEN_HEIGHT = 1080;
	private EntityManager entityManager;
	private Thread thread;
	private boolean isRunning = false;
	
	public Launcher() throws IOException {
		new Window(SCREEN_WIDTH, SCREEN_HEIGHT, "Side Scrolling Game", this);
		new AssetImporter();
		entityManager = new EntityManager();
		
		/**
		 * Creating an Entity
		 * Adding a shape component
		 * Adding Entity to the list of entities to render
		 */					
		Tag playerTag = new Tag("Player");
		Tag groundTag = new Tag("Ground");
		
		Random rand = new Random();
		
		for(int i = 0; i < 100; i++) {			
			List<Component> components = new ArrayList<>(); List<Tag> collisionTags = new ArrayList<>();
			collisionTags.add(groundTag);
			components.add(new SpriteComponent(AssetImporter.characterImage));
			components.add(new CollisionComponent(false, collisionTags));
			components.add(new PhysicsComponent());
			Entity character = new Entity("Test Object", rand.nextInt(SCREEN_WIDTH), 0, 50, 60, components, playerTag);
			entityManager.entities.add(character);
		}
		
		List<Component> components1 = new ArrayList<>(); List<Tag> groundCollisionTags = new ArrayList<>();
		groundCollisionTags.add(playerTag);
		components1.add(new ShapeComponent(ShapeComponent.ShapeType.Box, Color.black));
		components1.add(new CollisionComponent(false, groundCollisionTags));
		Entity testEntity1 = new Entity("Test Collision Object", 0, SCREEN_HEIGHT - 100, SCREEN_WIDTH, 100, components1, groundTag);
		entityManager.entities.add(testEntity1);
	}
	
	private void update() {
		if(entityManager != null) {
			entityManager.update();
		}
	}
	
	private void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {this.createBufferStrategy(3); return;}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		if(entityManager != null) {			
			entityManager.draw(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			isRunning = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoSecond = 1000000000 / amountOfTicks;
		double delta = 0;
		int FPS = 0;
		long timer = System.currentTimeMillis();
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoSecond;
			lastTime = now;
			
			while(delta >= 1) {
				update();
				delta--;
			}
			
			if(isRunning) {
				draw();
			}
			
			FPS++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(FPS);
				FPS = 0;
			}
		}
		
		stop();
	}
	
	public static void main(String[] args) throws IOException {
		new Launcher();
	}
}
