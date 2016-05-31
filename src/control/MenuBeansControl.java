package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import views.SnakeView;

import config.Constant;

import models.Model;

/******* 豆子模式控制器 *******/
public class MenuBeansControl implements ActionListener {

	// 点击信息
	String info;

	// 菜单栏选项
	JMenuItem start;
	JMenuItem pause;
	JMenuItem trandition;
	JMenuItem funny;
	JMenuItem standard;
	JMenuItem big;
	JMenuItem small;
	JMenuItem stage;

	// 构造方法
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

	// 事件动作
	public void actionPerformed(ActionEvent e) {
		// 更换豆子模式
		if (info.equals("trandition")) {
			Model model = Model.getInstance();
			model.setBeans(Constant.TRANDITION_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			trandition.setText("传统模式#");
			funny.setText("趣味模式");
		} else {
			Model model = Model.getInstance();
			model.setBeans(Constant.FUNNY_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			trandition.setText("传统模式");
			funny.setText("趣味模式#");
		}
		// 改变按键状态
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
