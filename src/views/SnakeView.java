package views;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import config.Constant;
import control.KeyboardControl;
import control.MenuBeansControl;
import control.MenuBoardControl;
import control.MenuControlControl;
import control.MenuHelpControl;

import models.BNode;
import models.Model;
import models.Node;

/******* 游戏视图 *******/
public class SnakeView implements Observer {

	// 绘图界面
	JFrame mainFrame;
	Canvas paintCanvas;
	Container cp;
	// 盘格大小
	private static final int nodeWidth = 10;
	private static final int nodeHeight = 10;
	// 画布大小
	private static int canvasWidth;
	private static int canvasHeight;
	// 分数统计栏
	JLabel score;

	// Model单例对象
	private Model model = Model.getInstance();
	// KeyboardControl单例对象
	private KeyboardControl control = KeyboardControl.getInstance();
	// SnakeView单例对象
	private static SnakeView instance = new SnakeView();

	private SnakeView() {
		// 绘制界面框
		mainFrame = new JFrame("贪食蛇");
		cp = mainFrame.getContentPane();
		// 绘制中间游戏区域
		model.resetGame(false, 0);
		paintCanvas = new Canvas();
		canvasWidth = nodeWidth * model.width();
		canvasHeight = nodeHeight * model.height();
		paintCanvas.setSize(canvasWidth - nodeWidth, canvasHeight - nodeHeight);
		cp.add(paintCanvas, BorderLayout.CENTER);
		// 创建头部菜单栏（棋盘模式）
		JMenu menuBoard = new JMenu("棋盘模式");
		JMenuItem standard = new JMenuItem("标准模式#");
		JMenuItem big = new JMenuItem("增大模式");
		JMenuItem small = new JMenuItem("缩小模式");
		JMenu stage = new JMenu("闯关模式");
		JMenuItem stage1 = new JMenuItem("关卡1");
		JMenuItem stage2 = new JMenuItem("关卡2");
		stage.add(stage1);
		stage.add(stage2);
		menuBoard.add(standard);
		menuBoard.add(big);
		menuBoard.add(small);
		menuBoard.add(stage);
		standard.setEnabled(false);
		big.setEnabled(false);
		small.setEnabled(false);
		stage.setEnabled(false);
		// 创建头部菜单栏（豆子模式）
		JMenu menuBeans = new JMenu("豆子模式");
		JMenuItem trandition = new JMenuItem("传统模式#");
		JMenuItem funny = new JMenuItem("趣味模式");
		menuBeans.add(trandition);
		menuBeans.add(funny);
		funny.setEnabled(false);
		trandition.setEnabled(false);
		// 创建头部菜单栏（帮助菜单）
		JMenu menuHelp = new JMenu("帮助");
		JMenuItem authorInfo = new JMenuItem("作者信息");
		JMenuItem gameInfo = new JMenuItem("游戏信息");
		menuHelp.add(authorInfo);
		menuHelp.add(gameInfo);
		// 创建头部菜单栏（控制选项）
		JMenu menuControl = new JMenu("控制选项");
		JMenuItem start = new JMenuItem("开始");
		JMenuItem pause = new JMenuItem("暂停");
		JMenuItem restart = new JMenuItem("重新开始");
		menuControl.add(start);
		menuControl.add(pause);
		menuControl.add(restart);
		start.setEnabled(false);
		// 创建头部菜单栏（监听器）
		start.addActionListener(new MenuControlControl("start", start, pause,
				trandition, funny, standard, big, small, stage, mainFrame));
		pause.addActionListener(new MenuControlControl("pause", start, pause,
				trandition, funny, standard, big, small, stage, mainFrame));
		restart.addActionListener(new MenuControlControl("restart", start,
				pause, trandition, funny, standard, big, small, stage,
				mainFrame));
		standard.addActionListener(new MenuBoardControl("standard", start,
				pause, trandition, funny, standard, big, small, stage, stage1,
				stage2));
		big
				.addActionListener(new MenuBoardControl("big", start, pause,
						trandition, funny, standard, big, small, stage, stage1,
						stage2));
		small
				.addActionListener(new MenuBoardControl("small", start, pause,
						trandition, funny, standard, big, small, stage, stage1,
						stage2));
		stage1
				.addActionListener(new MenuBoardControl("stage1", start, pause,
						trandition, funny, standard, big, small, stage, stage1,
						stage2));
		stage2
				.addActionListener(new MenuBoardControl("stage2", start, pause,
						trandition, funny, standard, big, small, stage, stage1,
						stage2));
		trandition.addActionListener(new MenuBeansControl("trandition", start,
				pause, trandition, funny, standard, big, small, stage));
		funny.addActionListener(new MenuBeansControl("funny", start, pause,
				trandition, funny, standard, big, small, stage));
		authorInfo.addActionListener(new MenuHelpControl("authorInfo",
				mainFrame));
		gameInfo.addActionListener(new MenuHelpControl("gameInfo", mainFrame));
		// 创建头部菜单栏（总体）
		JMenuBar menu = new JMenuBar();
		menu.add(menuControl);
		menu.add(menuBoard);
		menu.add(menuBeans);
		menu.add(menuHelp);
		cp.add(menu, BorderLayout.NORTH);
		// 创建游戏底部计分栏
		score = new JLabel("您的得分：");
		cp.add(score, BorderLayout.SOUTH);
		// 界面的设置
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.addKeyListener(control);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// 更新界面
	public void renew() {
		cp.remove(paintCanvas);
		paintCanvas = new Canvas();
		canvasWidth = nodeWidth * model.width();
		canvasHeight = nodeHeight * model.height();
		paintCanvas.setSize(canvasWidth, canvasHeight);
		cp.add(paintCanvas, BorderLayout.CENTER);
		mainFrame.addKeyListener(control);
		mainFrame.pack();
	}

	// 观察者函数
	public void update(Observable o, Object arg) {
		repaint();
	}

	// 界面的重新绘制
	private void repaint() {
		// 获取Graphics
		Graphics g = paintCanvas.getGraphics();
		// 绘制棋盘（包括关卡障碍物） 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, canvasWidth, canvasHeight);
		int[][] board = model.getBoard();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == Constant.STONE) {
					g.setColor(Color.GRAY);
					drawNode(g, new Node(i, j));
				}
			}
		}
		// 绘制蛇
		g.setColor(Color.BLACK);
		LinkedList<Node> na = model.getSnake();
		Iterator<Node> it = na.iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			drawNode(g, n);
		}
		// 绘制豆子
		BNode n = model.getBean();
		switch (n.getType()) {
		case Constant.NORMAL_BEAN:
			g.setColor(Color.BLACK);
			break;
		case Constant.DOUBLE_BEAN:
			g.setColor(Color.RED);
			break;
		case Constant.SPEEDUP_BEAN:
			g.setColor(Color.GREEN);
			break;
		case Constant.SPEEDDOWN_BEAN:
			g.setColor(Color.BLUE);
			break;
		default:
			break;
		}
		drawNode(g, n);
		// 绘制得分
		score.setText(model.score());
	}

	// 绘制节点
	private void drawNode(Graphics g, Node n) {
		g.fillRect(n.getX() * nodeWidth, canvasHeight - (n.getY() + 1)
				* nodeHeight, nodeWidth - 1, nodeHeight - 1);
	}

	// SnakeView单例对象
	public static SnakeView getInstance() {
		return instance;
	}

	// 启动函数
	public static void main(String[] args) {
		// 获取模型
		Model model = Model.getInstance();
		model.addObserver(SnakeView.getInstance());
		(new Thread(model)).start();
		model.startGame();
	}
}
