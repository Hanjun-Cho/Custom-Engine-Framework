package components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteComponent extends Component {

	public SpriteComponent(BufferedImage sprite) {
		this.setSprite(sprite);
		this.componentID = 1;
	}
	
	public void draw(Graphics g) {
		g.drawImage(this.getSprite(), this.getParent().getX(), this.getParent().getY(), this.getParent().getWidth(), this.getParent().getHeight(), null);
	}
}
