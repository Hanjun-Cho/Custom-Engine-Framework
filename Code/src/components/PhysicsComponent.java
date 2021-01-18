package components;

public class PhysicsComponent extends Component {

	public PhysicsComponent() {
		this.setGravity(9.81);
		this.componentID = 3;
	}
	
	public PhysicsComponent(double gravity) {
		this.setGravity(gravity);
		this.componentID = 3;
	}
	
	public void update() {
		if(!this.getParent().isColDown()) {			
			this.getParent().setY((int)(this.getParent().getY() + this.getGravity()));
		}
	}
}
