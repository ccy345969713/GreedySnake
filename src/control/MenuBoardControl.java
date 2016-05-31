package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import views.SnakeView;

import config.Constant;

import models.Model;

/******* 棋盘模式控制器 *******/
public class MenuBoardControl implements ActionListener {

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
	JMenuItem stage1;
	JMenuItem stage2;

	// 构造方法
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

	// 事件动作
	public void actionPerformed(ActionEvent e) {
		// 更换棋盘模式
		if (info.equals("standard")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.STANDARD_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("标准模式#");
			big.setText("增大模式");
			small.setText("减小模式");
			stage1.setText("关卡1");
			stage2.setText("关卡2");
		} else if (info.equals("big")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.BIG_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("标准模式");
			big.setText("增大模式#");
			small.setText("减小模式");
			stage1.setText("关卡1");
			stage2.setText("关卡2");
		} else if (info.equals("small")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.SMALL_MODE);
			model.resetGame(false, 0);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("标准模式");
			big.setText("增大模式");
			small.setText("减小模式#");
			stage1.setText("关卡1");
			stage2.setText("关卡2");
		} else if (info.equals("stage1")) {
			Model model = Model.getInstance();
			model.setBoard(Constant.STAGE_MODE);
			model.resetGame(true, 1);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("标准模式");
			big.setText("增大模式");
			small.setText("减小模式");
			stage1.setText("关卡1#");
			stage2.setText("关卡2");
		} else {
			Model model = Model.getInstance();
			model.setBoard(Constant.STAGE_MODE);
			model.resetGame(true, 2);
			SnakeView.getInstance().renew();
			model.startGame();
			standard.setText("标准模式");
			big.setText("增大模式");
			small.setText("减小模式");
			stage1.setText("关卡1");
			stage2.setText("关卡2#");
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
