package models;

import java.util.LinkedList;
import java.util.Observable;

import config.Constant;

/******* ������������ *******/
public class Model extends Observable implements Runnable {

	// ����
	private int[][] board;
	// ��
	private LinkedList<Node> snake;
	// ����
	private BNode bean;
	// GenSelector��������
	private GenSelector selector = GenSelector.getInstance();
	// GenBoard��������
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake��������
	private GenSnake snakeInstance = GenSnake.getInstance();
	// GenBeans��������
	private GenBeans beansInstance = GenBeans.getInstance();
	// Mode��������
	private static Model instance = new Model();

	// �Ʒֿ���
	private int score = 0;
	private String scoreLabel = "";
	// �ٶȿ���
	private int timeInterval = 200;// ʱ���������룩
	private double speedChangeRate = 0.3;// �ٶȱ仯��
	private int currentTimeInterval = 200;

	// ϵͳģʽ
	private int boardMode = Constant.STANDARD_MODE;// ����ģʽ
	private int beansMode = Constant.TRANDITION_MODE;// ����ģʽ
	private boolean pause = true;// ��ͣ��־

	// ���췽��
	private Model() {
	}

	// ������Ϸ����
	public void resetGame(boolean selectObstacle, int i) {
		// ���ý���
		if (boardMode == Constant.STAGE_MODE) {
			if (selectObstacle == true) {
				selector.setSpecifcStage(i);
			}
		}
		board = boardInstance.resetBoard(boardMode);
		snake = snakeInstance.resetSnake();
		beansInstance.resetBeans(beansMode);
		bean = beansInstance.getBean();
		// ���ò���
		scoreLabel = "��Ϸ���ڽ���......";
		pause = true;
		score = 0;
		currentTimeInterval = timeInterval;
	}

	// ��ʼ��Ϸ
	public void startGame() {
		pause = false;
	}

	// ��ͣ��Ϸ
	public void pauseGame() {
		pause = true;
	}

	// ����
	public void speedUp() {
		currentTimeInterval = (int) ((1 - speedChangeRate) * currentTimeInterval);
	}

	// ����
	public void speedDown() {
		currentTimeInterval = (int) ((1 + speedChangeRate) * currentTimeInterval);
	}

	// �߸ı䷽��
	public void changeDirection(int newDirection) {
		snakeInstance.changeDiertion(newDirection);
	}

	// ����ǰ�ƶ�
	public boolean forwoard() {
		// ��ȡ�ƶ�λ��
		Node node = snakeInstance.headNode();
		int x = node.getX();
		int y = node.getY();
		int boderX = board.length;
		int boderY = board[0].length;
		// �Ƿ񳬹��߽�
		if (!((0 <= x && x < boderX) && (0 <= y && y < boderY))) {
			return false;
		}
		// �Ƿ������ϰ���
		if (board[x][y] == Constant.STONE) {
			return false;
		}
		// �Ƿ�ײ���Լ�
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == x && snake.get(i).getY() == y) {
				return false;
			}
		}
		// �Ƿ���������
		if (bean.getX() == x && bean.getY() == y) {
			if (bean.getType() == Constant.NORMAL_BEAN) {
				score = score + 1;
			} else if (bean.getType() == Constant.DOUBLE_BEAN) {
				score = score + 2;
			} else if (bean.getType() == Constant.SPEEDUP_BEAN) {
				score = score + 1;
				speedUp();
			} else {
				score = score + 1;
				speedDown();
			}
			// ������
			snakeInstance.grow();
			// �����¶���
			bean = beansInstance.getBean();
			return true;
		} else {
			snakeInstance.move();
			return true;
		}
	}

	// ���к���
	public void run() {
		// �Ƿ���ֹͣ״̬
		while (true) {
			// �����ٶ�
			try {
				Thread.sleep(currentTimeInterval);
			} catch (Exception e) {
				break;
			}
			// �Ƿ���ͣ
			if (!pause) {
				if (forwoard()) {
					setChanged();
					notifyObservers();
				} else {
					scoreLabel = "��Ϸ�Ѿ�����......";
					setChanged();
					notifyObservers();
				}
			}
		}
	}

	// ��������ģʽ
	public void setBoard(int mode) {
		boardMode = mode;
	}

	// ���ö���ģʽ
	public void setBeans(int mode) {
		beansMode = mode;
	}

	// ��ѯ�Ƿ���ֹͣ״̬
	public boolean isPlaying() {
		if (pause == false) {
			return true;
		} else {
			return false;
		}
	}

	// ��ѯ����Ŀ��
	public int width() {
		if (board != null) {
			return board.length;
		} else {
			return 0;
		}
	}

	// ��ѯ����ĸ߶�
	public int height() {
		if (board != null) {
			return board[0].length;
		} else {
			return 0;
		}
	}

	// ��ѯ�÷�
	public String score() {
		return scoreLabel + "                         " + "             ���ĵ÷֣�"
				+ score;
	}

	// ��������
	public int[][] getBoard() {
		return board;
	}

	// ������
	public LinkedList<Node> getSnake() {
		return snake;
	}

	// ���ض���
	public BNode getBean() {
		return bean;
	}

	// Mode��������
	public static Model getInstance() {
		return instance;
	}
}
