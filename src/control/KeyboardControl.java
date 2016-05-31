package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.Constant;

import models.Model;

/******* ��Ϸ���̿����� *******/
public class KeyboardControl implements KeyListener {

	// Model��������
	Model model = Model.getInstance();
	// KeyboardControl��������
	private static KeyboardControl instance = new KeyboardControl();

	// ���췽��
	private KeyboardControl() {
	}

	// ���ð���������
	public void keyPressed(KeyEvent e) {
		// �����İ���
		int keyCode = e.getKeyCode();
		// ��������Ϊ
		if (model.isPlaying()) {
			switch (keyCode) {
			case KeyEvent.VK_UP:
				model.changeDirection(Constant.UP);
				break;
			case KeyEvent.VK_DOWN:
				model.changeDirection(Constant.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				model.changeDirection(Constant.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				model.changeDirection(Constant.RIGHT);
				break;
			case KeyEvent.VK_PAGE_UP:
				model.speedUp();
				break;
			case KeyEvent.VK_PAGE_DOWN:
				model.speedDown();
				break;
			default:
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	// KeyboardControl��������
	public static KeyboardControl getInstance() {
		return instance;
	}
}
