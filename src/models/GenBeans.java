package models;

import java.util.LinkedList;
import java.util.Random;

import config.Constant;

/******* ���� *******/
public class GenBeans {

	// ����ģʽ
	private int mode;
	// ��ǰ����
	private int[][] board;
	// ��ǰ��
	private LinkedList<Node> snake;
	// GenBoard��������
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake��������
	private GenSnake snakeInstance = GenSnake.getInstance();
	// GenBeans��������
	private static GenBeans instance = new GenBeans();

	// ���췽��
	private GenBeans() {
	}

	// ���ö���
	public void resetBeans(int mode) {
		// ���ö���ģʽ
		this.mode = mode;
		// ��ȡ��ǰ����
		board = boardInstance.giveBoardToOthers();
		// ��ȡ��ǰ��
		snake = snakeInstance.giveSnakeToOthers();
	}

	// ��ȡ����
	public BNode getBean() {
		// �����꣬�����꣬��������
		int x, y, type;
		// ��ͳģʽ�����ɶ���
		if (mode == Constant.TRANDITION_MODE) {
			do {
				// ���������x,y
				Random r = new Random();
				x = r.nextInt(board.length);
				y = r.nextInt(board[0].length);
			} while (board[x][y] != Constant.BLANK || isSnakeNode(x, y));

			return new BNode(x, y, Constant.NORMAL_BEAN);
		}
		// Ȥζģʽ�����ɶ���
		else {
			do {
				// ���������x,y
				Random r = new Random();
				x = r.nextInt(board.length);
				y = r.nextInt(board[0].length);
			} while (board[x][y] != Constant.BLANK || isSnakeNode(x, y));
			// ���ɶ�������
			Random r = new Random();
			type = r.nextInt(100);
			if (type < Constant.NORMAL_BEAN_RATE * 100) {
				type = Constant.NORMAL_BEAN;
			} else if ((type = (int) (type - Constant.NORMAL_BEAN_RATE * 100)) < Constant.DOUBLE_BEAN_RATE * 100) {
				type = Constant.DOUBLE_BEAN;
			} else if ((type = (int) (type - Constant.DOUBLE_BEAN_RATE * 100)) < Constant.SPEEDUP_BEAN_RATE * 100) {
				type = Constant.SPEEDUP_BEAN;
			} else {
				type = Constant.SPEEDDOWN_BEAN;
			}

			return new BNode(x, y, type);
		}
	}

	// �жϽڵ��Ƿ�Ϊ�߽ڵ�
	private boolean isSnakeNode(int x, int y) {
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == x && snake.get(i).getY() == y) {
				return true;
			}
		}
		return false;
	}

	// GenBeans��������
	public static GenBeans getInstance() {
		return instance;
	}
}
