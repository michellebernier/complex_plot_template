package app;

import math.Complex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	
	// Exemple : exp(1/z)
	public static Complex fonction(Complex z) {
		z.power(-1);
		z.exp();
		return z;
	}
	
	public static void main(String[] args) {
		
		int img_res_width = 1920, img_res_height = 1080;
		
		BufferedImage result = new BufferedImage(img_res_width, img_res_height, BufferedImage.TYPE_INT_RGB);
		
		double centerx = 0;
		double centery = 0;
		
		double scale_width = 2;
		double scale_height = scale_width * (double)img_res_height / (double)img_res_width; // On s'accomode à la résolution de l'image
		
		for (int x = 0; x < img_res_width; x++) {
			for (int y = 0; y < img_res_height; y++) {
				
				double transx = centerx + (double)(x - img_res_width / 2) / (double) img_res_width * scale_width;
				double transy = centery + (double)(y - img_res_height / 2) / (double) img_res_height * scale_height;
				
				Complex img = fonction(new Complex(transx, transy));
				
				float hue = (float)((Math.PI + Math.atan2(img.getImaginary(), img.getReal())) / (2d*Math.PI));
				float bri = (float)(1d / Math.log(img.getModulus() + Math.E));//(float)(2d / Math.PI * Math.atan(img.getModulus()));
				
				result.setRGB(x, y, Color.getHSBColor(hue, 1f, bri).getRGB());
				
			}
		}
		
		try {
			ImageIO.write(result, "png", new File("C:\\Users\\Louis\\Desktop\\output.png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
