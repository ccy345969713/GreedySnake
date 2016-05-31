package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import views.SnakeView;

import config.Constant;

import models.Model;

/******* ����ģʽ������ *******/
public class MenuBeansControl implements ActionListener {

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

	// ���췽��
	public MenuBeansControl(String info, JMenuItem start, JMenuItem pause,
			JMenuItem trandition, JMenuItem funny, JMenuItem standard,
			JMenuItem big, JMenuItem small, JMenuItem stage) {
		this.info = info;
		this.start = start;
		this.pause = pause;
		this.trandition = trandition;
		this.funny = funny;
		this.standard = standard;
		this.big = big;
		this.small = small;
		this.stage = stage;
	}

	// �¼�����
	public void actionPerformed(ActionEvent e) {
		// ��������ģʽ
		if (info.equals("trandition")) {
			Model model = Model.getInstance();
			model.setBeans(Constant.TRANDITION_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			trandition.setText("��ͳģʽ#");
			funny.setText("Ȥζģʽ");
		} else {
			Model model = Model.getInstance();
			model.setBeans(Constant.FUNNY_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			trandition.setText("��ͳģʽ");
			funny.setText("Ȥζģʽ#");
		}
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
