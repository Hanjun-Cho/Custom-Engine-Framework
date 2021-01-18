package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AssetImporter {

	public static BufferedImage testImage;
	public static BufferedImage characterImage;
	
	public static BufferedImage testImage2;
	
	public AssetImporter() throws IOException {
		testImage = ImageIO.read(getClass().getResourceAsStream("/test.jpg"));
		characterImage = ImageIO.read(getClass().getResourceAsStream("/character.png"));
		testImage2 = ImageIO.read(getClass().getResourceAsStream("/heung-min-son-tottenham-2020_3t51xh6qjyk81991plakoxm15.jpg"));
	}
}
