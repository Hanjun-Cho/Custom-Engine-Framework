package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AssetImporter {

	public static BufferedImage characterImage;
	public static BufferedImage daneScarlett;
	
	public AssetImporter() throws IOException {
		characterImage = ImageIO.read(getClass().getResourceAsStream("/character.png"));
		daneScarlett = ImageIO.read(getClass().getResourceAsStream("/Dane-Scarlett.jpg"));
	}
}
