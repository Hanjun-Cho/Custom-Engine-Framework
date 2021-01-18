package components;

import java.awt.Color;
import java.awt.Graphics;

public class ShapeComponent extends Component {

	public enum ShapeType { Box, Circle, Triangle, Cylinder }
	private ShapeType shapeType;
	
	public ShapeComponent(ShapeType shapeType, Color color) {
		this.shapeType = shapeType;
		this.setColor(color);
		this.componentID = 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());

		if(shapeType == ShapeType.Box) {	
			g.fillRect(this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getHeight());
		}
		else if(shapeType == ShapeType.Circle) {
			g.fillOval(this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getHeight());
		}
		else if(shapeType == ShapeType.Triangle) {
			int[] curXPoints = new int[] {
				this.getParent().getX() + this.getParent().getWidth() / 2,
				this.getParent().getX() + this.getParent().getWidth(),
				this.getParent().getX()
			};			
			
			int[] curYPoints = new int[] {
				this.getParent().getY(),
				this.getParent().getY() + this.getParent().getHeight(),
				this.getParent().getY() + this.getParent().getHeight()
			};
			
			g.fillPolygon(curXPoints, curYPoints, 3);
		}
		else if(shapeType == ShapeType.Cylinder) {
			g.fillOval(this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getWidth());
			g.fillRect(this.getParent().getX(), this.getParent().getY() + this.getParent().getWidth() / 2, this.getParent().getWidth(), this.getParent().getHeight() - this.getParent().getWidth());
			g.fillOval(this.getParent().getX(), this.getParent().getY() + this.getParent().getWidth() / 2 + (this.getParent().getHeight() - this.getParent().getWidth()) - this.getParent().getWidth() / 2, this.getParent().getWidth(), this.getParent().getWidth());
		}
	}

	public ShapeType getShapeType() {
		return shapeType;
	}
}
