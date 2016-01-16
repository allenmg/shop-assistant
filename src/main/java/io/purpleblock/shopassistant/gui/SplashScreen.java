package io.purpleblock.shopassistant.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SplashScreen extends JFrame {
	
	public SplashScreen() {
		super();
		this.setSize(480, 240);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		pane.setBackground(Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel text = new JLabel("Loading Shop Assistant... ", SwingConstants.CENTER);
		Font font = new Font("Arial Black", Font.PLAIN, 21);
		text.setFont(font);
		text.setForeground(Color.WHITE);
		pane.add(text, gbc);
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("src/main/resources/io/purpleblock/shopassistant/gui/157-wrench-icon.png"));
			float[] scale = {2.0f,2.0f,2.0f,1.0f};
			float[] offsets = {0,0,0,0};
			RescaleOp lighten = new RescaleOp(scale, offsets, null);
			BufferedImage li = new BufferedImage(myPicture.getWidth(), myPicture.getHeight(), myPicture.getType());
			lighten.filter(myPicture, li);
			JLabel picLabel = new JLabel(new ImageIcon(li));
			pane.add(picLabel, gbc);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(ERROR);
		}
		
		
		this.setContentPane(pane);
		this.setVisible(true);
	}
}
