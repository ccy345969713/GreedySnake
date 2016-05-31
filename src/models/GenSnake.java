package models;

import java.util.LinkedList;

import config.Constant;

/******* 整条蛇（由蛇节点构成） *******/
public class GenSnake {

	// 蛇
	private LinkedList<Node> snake;
	// 蛇移动前方的节点
	private Node n;
	// 蛇前进的方向
	private int direction;
	// GenBoard单例对象
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake单例对象
	private static GenSnake instance = new GenSnake();

	// 构造方法
	private GenSnake() {
	}

	// 重置蛇
	public LinkedList<Node> resetSnake() {
		// 设置蛇的初始化前进方向
		direction = Constant.RIGHT;
		// 获取当前棋盘
		int[][] board = boardInstance.giveBoardToOthers();
		// 获取蛇的初始长度
		int length = Constant.snakeLength;
		// 创建初始化的蛇
		snake = new LinkedList<Node>();
		for (int i = length - 1; i >= 0; i--) {
			if (board[i][0] == Constant.BLANK) {
				snake.add(new Node(i, 0));
			}
		}
		return snake;
	}

	// 蛇改变方向
	public void changeDiertion(int changeDirection) {
		if (direction % 2 != changeDirection % 2) {
			direction = changeDirection;
		}
	}

	// 蛇向前移动
	public void move() {
		// 添加前方节点
		snake.addFirst(n);
		// 删除后方节点
		snake.removeLast();
	}

	// 蛇吃豆子增长S
	public void grow() {
		snake.addFirst(n);
	}

	// 蛇移动前方的节点
	public Node headNode() {
		// 蛇处于头位的节点
		Node head = snake.getFirst();
		int x = head.getX();
		int y = head.getY();
		// 根据方向增减坐标值
		switch (direction) {
		case Constant.UP:
			y++;
			break;
		case Constant.DOWN:
			y--;
			break;
		case Constant.LEFT:
			x--;
			break;
		case Constant.RIGHT:
			x++;
			break;
		}
		// 记录移动的节点
		n = new Node(x, y);
		return n;
	}

	// 传递蛇给豆子
	public LinkedList<Node> giveSnakeToOthers() {
		return snake;
	}

	// GenSnake单例对象
	public static GenSnake getInstance() {
		return instance;
	}
}
