package components;

import java.awt.Rectangle;
import java.util.List;

import entities.Entity;
import entities.Tag;

public class CollisionComponent extends Component {

	private boolean trigger;
	
	public CollisionComponent(boolean trigger, List<Tag> allowedTags) {
		this.trigger = trigger;
		this.componentID = 2;
		this.allowedTags = allowedTags;
	}
	
	public void init() {
		this.getParent().setTrigger(trigger);
	}
	
	public void update() {
		this.getParent().setCollisionBox(new Rectangle(this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getHeight()));
	}
	
	public void doCollision(Entity collisionEntity) {
		if(this.getParent().allowedEntity(collisionEntity, allowedTags) && collisionEntity.allowedEntity(this.getParent(), collisionEntity.getComponent(2).allowedTags)) {			
			int yDifference = this.getParent().getY() - collisionEntity.getY();
			
			if(yDifference <= this.getParent().getHeight()) {
				this.getParent().setColDown(true);
			}
		}
	}
}
