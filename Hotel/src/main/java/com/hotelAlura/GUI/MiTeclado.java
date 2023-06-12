package com.hotelAlura.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MiTeclado implements KeyListener {
	
	public MiTeclado() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ') {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
