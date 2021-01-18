package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

	public List<Entity> entities = new ArrayList<>();

	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			if(entities.get(i).hasComponent(2)) {
				entities.get(i).getComponent(2).update();

				for(int j = 0; j < entities.size(); j++) {
					if(i != j) {											
						if(entities.get(j).hasComponent(2)) {			
							Rectangle bound1 = entities.get(i).getCollisionBox();
							Rectangle bound2 = entities.get(j).getCollisionBox();
							
							if(bound1 != null && bound2 != null) {											
								if(bound2.intersects(bound1)) {
									entities.get(i).getComponent(2).doCollision(entities.get(j));
								}
							}
						}
					}
				}
			}
			
			if(entities.get(i).hasComponent(3)) {
				entities.get(i).getComponent(3).update();
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < entities.size(); i++) {
			if(entities.get(i).hasComponent(0)) {
				entities.get(i).getComponent(0).draw(g);
			}
			else if(entities.get(i).hasComponent(1)) {
				entities.get(i).getComponent(1).draw(g);
			}
		}
	}
}
