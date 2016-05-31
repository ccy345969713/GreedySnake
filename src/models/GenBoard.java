package models;

import config.Constant;

/******* 棋盘 *******/
public class GenBoard {

	// 棋盘
	private int[][] board;
	// 关卡障碍
	private GenSelector obstaclesInstance = GenSelector.getInstance();
	// GenBoard单例对象
	private static GenBoard instance = new GenBoard();

	// 构造函数
	private GenBoard() {
	}

	// 重置棋盘（mode值为Constant中的常量）
	public int[][] resetBoard(int mode) {
		switch (mode) {
		case Constant.STAGE_MODE:
			initBoard(60, 40);
			break;
		case Constant.SMALL_MODE:
			initBoard(40, 40);
			break;
		case Constant.STANDARD_MODE:
			initBoard(50, 50);
			break;
		case Constant.BIG_MODE:
			initBoard(70, 70);
			break;
		default:
			initBoard(50, 50);
		}

		// 将Obstacles数据加载到棋盘（Stage模式下）
		if (mode == Constant.STAGE_MODE) {
			Integer[][] obstacles = obstaclesInstance.getObstacles();
			for (int i = 0; i < obstacles.length; i++) {
				board[obstacles[i][0]][obstacles[i][1]] = Constant.STONE;
			}
		}

		return board;
	}

	// 初始化盘格
	private void initBoard(int x, int y) {
		board = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				board[i][j] = Constant.BLANK;
			}
		}
	}

	// 传递棋盘给豆子和蛇
	public int[][] giveBoardToOthers() {
		return board;
	}

	// GenBoard单例对象
	public static GenBoard getInstance() {
		return instance;
	}
}
