package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.Constant;

import models.Model;

/******* 游戏键盘控制器 *******/
public class KeyboardControl implements KeyListener {

	// Model单例对象
	Model model = Model.getInstance();
	// KeyboardControl单例对象
	private static KeyboardControl instance = new KeyboardControl();

	// 构造方法
	private KeyboardControl() {
	}

	// 设置按键监听器
	public void keyPressed(KeyEvent e) {
		// 触发的按键
		int keyCode = e.getKeyCode();
		// 处理按键行为
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

	// KeyboardControl单例对象
	public static KeyboardControl getInstance() {
		return instance;
	}
}
