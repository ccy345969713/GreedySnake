package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import models.Model;

/******* ���Ʋ˵������� *******/
public class MenuControlControl implements ActionListener {

	// �����Ϣ
	String info;

	// �˵���ѡ��
	JMenuItem start;
	JMenuItem pause;
	JMenuItem trandition;
	JMenuItem funny;
	JMenuItem standard;
	JMenuItem big;
	JMenuItem small;
	JMenuItem stage;

	// ��������Ϣ
	JFrame frame;

	// ���췽��
	public MenuControlControl(String info, JMenuItem start, JMenuItem pause,
			JMenuItem trandition, JMenuItem funny, JMenuItem standard,
			JMenuItem big, JMenuItem small, JMenuItem stage, JFrame frame) {
		this.info = info;
		this.start = start;
		this.pause = pause;
		this.trandition = trandition;
		this.funny = funny;
		this.standard = standard;
		this.big = big;
		this.small = small;
		this.stage = stage;
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		// �����Ϸ״̬
		if (info.equals("start")) {
			Model.getInstance().startGame();
			// �ı䰴��״̬
			start.setEnabled(false);
			pause.setEnabled(true);
			trandition.setEnabled(false);
			funny.setEnabled(false);
			standard.setEnabled(false);
			big.setEnabled(false);
			small.setEnabled(false);
			stage.setEnabled(false);
		} else if (info.equals("pause")) {
			Model.getInstance().pauseGame();
			// �ı䰴��״̬
			start.setEnabled(true);
			pause.setEnabled(false);
			trandition.setEnabled(true);
			funny.setEnabled(true);
			standard.setEnabled(true);
			big.setEnabled(true);
			small.setEnabled(true);
			stage.setEnabled(true);
		} else {
			Model model = Model.getInstance();
			model.resetGame(false, 0);
			model.startGame();
			Model.getInstance().startGame();
			// �ı䰴��״̬
			start.setEnabled(false);
			pause.setEnabled(true);
			trandition.setEnabled(false);
			funny.setEnabled(false);
			standard.setEnabled(false);
			big.setEnabled(false);
			small.setEnabled(false);
			stage.setEnabled(false);
		}
	}
}
