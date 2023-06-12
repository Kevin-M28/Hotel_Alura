package com.hotelAlura.GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image mImage;
	
	
	public ImagenPanel(String direccionString) {
		this.mImage = new ImageIcon(getClass().getResource(direccionString)).getImage();
	}


	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
        g.drawImage(mImage, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
	}
	
}
