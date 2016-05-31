package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import views.SnakeView;

import config.Constant;

import models.Model;

/******* ����ģʽ������ *******/
public class MenuBoardControl implements ActionListener {

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
	JMenuItem stage1;
	JMenuItem stage2;

	// ���췽��
	public MenuBoardControl(String info, JMenuItem start, JMenuItem pause,
			JMenuItem trandition, JMenuItem funny, JMenuItem standard,
			JMenuItem big, JMenuItem small, JMenuItem stage, JMenuItem stage1,
			JMenuItem stage2) {
		this.info = info;
		this.start = start;
		this.pause = pause;
		this.trandition = trandition;
		this.funny = funny;
		this.standard = standard;
		this.big = big;
		this.small = small;
		this.stage = stage;
		this.stage1 = stage1;
		this.stage2 = stage2;
	}

	// �¼�����
	public void actionPerformed(ActionEvent e) {
		// ��������ģʽ
		if (info.equals("standard")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.STANDARD_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("��׼ģʽ#");
			big.setText("����ģʽ");
			small.setText("��Сģʽ");
			stage1.setText("�ؿ�1");
			stage2.setText("�ؿ�2");
		} else if (info.equals("big")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.BIG_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("��׼ģʽ");
			big.setText("����ģʽ#");
			small.setText("��Сģʽ");
			stage1.setText("�ؿ�1");
			stage2.setText("�ؿ�2");
		} else if (info.equals("small")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.SMALL_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("��׼ģʽ");
			big.setText("����ģʽ");
			small.setText("��Сģʽ#");
			stage1.setText("�ؿ�1");
			stage2.setText("�ؿ�2");
		} else if (info.equals("stage1")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.STAGE_MODE);
			model.resetGame(true, 1);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("��׼ģʽ");
			big.setText("����ģʽ");
			small.setText("��Сģʽ");
			stage1.setText("�ؿ�1#");
			stage2.setText("�ؿ�2");
		} else {
			Model model = Model.getInstance();
			model.setBoard(Constant.STAGE_MODE);
			model.resetGame(true, 2);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("��׼ģʽ");
			big.setText("����ģʽ");
			small.setText("��Сģʽ");
			stage1.setText("�ؿ�1");
			stage2.setText("�ؿ�2#");
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
