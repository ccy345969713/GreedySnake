package models;

import java.util.LinkedList;
import java.util.Random;

import config.Constant;

/******* 豆子 *******/
public class GenBeans {

	// 豆子模式
	private int mode;
	// 当前棋盘
	private int[][] board;
	// 当前蛇
	private LinkedList<Node> snake;
	// GenBoard单例对象
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake单例对象
	private GenSnake snakeInstance = GenSnake.getInstance();
	// GenBeans单例对象
	private static GenBeans instance = new GenBeans();

	// 构造方法
	private GenBeans() {
	}

	// 重置豆子
	public void resetBeans(int mode) {
		// 设置豆子模式
		this.mode = mode;
		// 获取当前棋盘
		board = boardInstance.giveBoardToOthers();
		// 获取当前蛇
		snake = snakeInstance.giveSnakeToOthers();
	}

	// 获取豆子
	public BNode getBean() {
		// 横坐标，纵坐标，豆子类型
		int x, y, type;
		// 传统模式下生成豆子
		if (mode == Constant.TRANDITION_MODE) {
			do {
				// 创建随机数x,y
				Random r = new Random();
				x = r.nextInt(board.length);
				y = r.nextInt(board[0].length);
			} while (board[x][y] != Constant.BLANK || isSnakeNode(x, y));

			return new BNode(x, y, Constant.NORMAL_BEAN);
		}
		// 趣味模式下生成豆子
		else {
			do {
				// 创建随机数x,y
				Random r = new Random();
				x = r.nextInt(board.length);
				y = r.nextInt(board[0].length);
			} while (board[x][y] != Constant.BLANK || isSnakeNode(x, y));
			// 生成豆子类型
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

	// 判断节点是否为蛇节点
	private boolean isSnakeNode(int x, int y) {
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == x && snake.get(i).getY() == y) {
				return true;
			}
		}
		return false;
	}

	// GenBeans单例对象
	public static GenBeans getInstance() {
		return instance;
	}
}
