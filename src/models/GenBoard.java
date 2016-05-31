package models;

import config.Constant;

/******* ���� *******/
public class GenBoard {

	// ����
	private int[][] board;
	// �ؿ��ϰ�
	private GenSelector obstaclesInstance = GenSelector.getInstance();
	// GenBoard��������
	private static GenBoard instance = new GenBoard();

	// ���캯��
	private GenBoard() {
	}

	// �������̣�modeֵΪConstant�еĳ�����
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

		// ��Obstacles���ݼ��ص����̣�Stageģʽ�£�
		if (mode == Constant.STAGE_MODE) {
			Integer[][] obstacles = obstaclesInstance.getObstacles();
			for (int i = 0; i < obstacles.length; i++) {
				board[obstacles[i][0]][obstacles[i][1]] = Constant.STONE;
			}
		}

		return board;
	}

	// ��ʼ���̸�
	private void initBoard(int x, int y) {
		board = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				board[i][j] = Constant.BLANK;
			}
		}
	}

	// �������̸����Ӻ���
	public int[][] giveBoardToOthers() {
		return board;
	}

	// GenBoard��������
	public static GenBoard getInstance() {
		return instance;
	}
}
