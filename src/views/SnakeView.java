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

/******* ��Ϸ��ͼ *******/
public class SnakeView implements Observer {

	// ��ͼ����
	JFrame mainFrame;
	Canvas paintCanvas;
	Container cp;
	// �̸��С
	private static final int nodeWidth = 10;
	private static final int nodeHeight = 10;
	// ������С
	private static int canvasWidth;
	private static int canvasHeight;
	// ����ͳ����
	JLabel score;

	// Model��������
	private Model model = Model.getInstance();
	// KeyboardControl��������
	private KeyboardControl control = KeyboardControl.getInstance();
	// SnakeView��������
	private static SnakeView instance = new SnakeView();

	private SnakeView() {
		// ���ƽ����
		mainFrame = new JFrame("̰ʳ��");
		cp = mainFrame.getContentPane();
		// �����м���Ϸ����
		model.resetGame(false, 0);
		paintCanvas = new Canvas();
		canvasWidth = nodeWidth * model.width();
		canvasHeight = nodeHeight * model.height();
		paintCanvas.setSize(canvasWidth - nodeWidth, canvasHeight - nodeHeight);
		cp.add(paintCanvas, BorderLayout.CENTER);
		// ����ͷ���˵���������ģʽ��
		JMenu menuBoard = new JMenu("����ģʽ");
		JMenuItem standard = new JMenuItem("��׼ģʽ#");
		JMenuItem big = new JMenuItem("����ģʽ");
		JMenuItem small = new JMenuItem("��Сģʽ");
		JMenu stage = new JMenu("����ģʽ");
		JMenuItem stage1 = new JMenuItem("�ؿ�1");
		JMenuItem stage2 = new JMenuItem("�ؿ�2");
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
		// ����ͷ���˵���������ģʽ��
		JMenu menuBeans = new JMenu("����ģʽ");
		JMenuItem trandition = new JMenuItem("��ͳģʽ#");
		JMenuItem funny = new JMenuItem("Ȥζģʽ");
		menuBeans.add(trandition);
		menuBeans.add(funny);
		funny.setEnabled(false);
		trandition.setEnabled(false);
		// ����ͷ���˵����������˵���
		JMenu menuHelp = new JMenu("����");
		JMenuItem authorInfo = new JMenuItem("������Ϣ");
		JMenuItem gameInfo = new JMenuItem("��Ϸ��Ϣ");
		menuHelp.add(authorInfo);
		menuHelp.add(gameInfo);
		// ����ͷ���˵���������ѡ�
		JMenu menuControl = new JMenu("����ѡ��");
		JMenuItem start = new JMenuItem("��ʼ");
		JMenuItem pause = new JMenuItem("��ͣ");
		JMenuItem restart = new JMenuItem("���¿�ʼ");
		menuControl.add(start);
		menuControl.add(pause);
		menuControl.add(restart);
		start.setEnabled(false);
		// ����ͷ���˵�������������
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
		// ����ͷ���˵��������壩
		JMenuBar menu = new JMenuBar();
		menu.add(menuControl);
		menu.add(menuBoard);
		menu.add(menuBeans);
		menu.add(menuHelp);
		cp.add(menu, BorderLayout.NORTH);
		// ������Ϸ�ײ��Ʒ���
		score = new JLabel("���ĵ÷֣�");
		cp.add(score, BorderLayout.SOUTH);
		// ���������
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.addKeyListener(control);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// ���½���
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

	// �۲��ߺ���
	public void update(Observable o, Object arg) {
		repaint();
	}

	// ��������»���
	private void repaint() {
		// ��ȡGraphics
		Graphics g = paintCanvas.getGraphics();
		// �������̣������ؿ��ϰ�� 
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
		// ������
		g.setColor(Color.BLACK);
		LinkedList<Node> na = model.getSnake();
		Iterator<Node> it = na.iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			drawNode(g, n);
		}
		// ���ƶ���
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
		// ���Ƶ÷�
		score.setText(model.score());
	}

	// ���ƽڵ�
	private void drawNode(Graphics g, Node n) {
		g.fillRect(n.getX() * nodeWidth, canvasHeight - (n.getY() + 1)
				* nodeHeight, nodeWidth - 1, nodeHeight - 1);
	}

	// SnakeView��������
	public static SnakeView getInstance() {
		return instance;
	}

	// ��������
	public static void main(String[] args) {
		// ��ȡģ��
		Model model = Model.getInstance();
		model.addObserver(SnakeView.getInstance());
		(new Thread(model)).start();
		model.startGame();
	}
}
