package components;

import java.awt.Rectangle;

import entities.Entity;

public class CollisionComponent extends Component {

	private boolean trigger;
	
	public CollisionComponent(boolean trigger) {
		this.trigger = trigger;
		this.componentID = 2;
	}
	
	public void init() {
		this.getParent().setTrigger(trigger);
	}
	
	public void update() {
		this.getParent().setCollisionBox(new Rectangle(this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getHeight()));
	}
	
	public void doCollision(Entity collisionEntity) {
		int yDifference = this.getParent().getY() - collisionEntity.getY();
		
		if(yDifference <= this.getParent().getHeight()) {
			this.getParent().setColDown(true);
		}
	}
}
