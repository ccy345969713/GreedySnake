package models;

import java.util.LinkedList;
import java.util.Observable;

import config.Constant;

/******* 创建整体流程 *******/
public class Model extends Observable implements Runnable {

	// 棋盘
	private int[][] board;
	// 蛇
	private LinkedList<Node> snake;
	// 豆子
	private BNode bean;
	// GenSelector单例对象
	private GenSelector selector = GenSelector.getInstance();
	// GenBoard单例对象
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake单例对象
	private GenSnake snakeInstance = GenSnake.getInstance();
	// GenBeans单例对象
	private GenBeans beansInstance = GenBeans.getInstance();
	// Mode单例对象
	private static Model instance = new Model();

	// 计分控制
	private int score = 0;
	private String scoreLabel = "";
	// 速度控制
	private int timeInterval = 200;// 时间间隔（毫秒）
	private double speedChangeRate = 0.3;// 速度变化率
	private int currentTimeInterval = 200;

	// 系统模式
	private int boardMode = Constant.STANDARD_MODE;// 棋盘模式
	private int beansMode = Constant.TRANDITION_MODE;// 豆子模式
	private boolean pause = true;// 暂停标志

	// 构造方法
	private Model() {
	}

	// 重置游戏界面
	public void resetGame(boolean selectObstacle, int i) {
		// 重置界面
		if (boardMode == Constant.STAGE_MODE) {
			if (selectObstacle == true) {
				selector.setSpecifcStage(i);
			}
		}
		board = boardInstance.resetBoard(boardMode);
		snake = snakeInstance.resetSnake();
		beansInstance.resetBeans(beansMode);
		bean = beansInstance.getBean();
		// 重置参数
		scoreLabel = "游戏正在进行......";
		pause = true;
		score = 0;
		currentTimeInterval = timeInterval;
	}

	// 开始游戏
	public void startGame() {
		pause = false;
	}

	// 暂停游戏
	public void pauseGame() {
		pause = true;
	}

	// 加速
	public void speedUp() {
		currentTimeInterval = (int) ((1 - speedChangeRate) * currentTimeInterval);
	}

	// 减速
	public void speedDown() {
		currentTimeInterval = (int) ((1 + speedChangeRate) * currentTimeInterval);
	}

	// 蛇改变方向
	public void changeDirection(int newDirection) {
		snakeInstance.changeDiertion(newDirection);
	}

	// 蛇向前移动
	public boolean forwoard() {
		// 获取移动位置
		Node node = snakeInstance.headNode();
		int x = node.getX();
		int y = node.getY();
		int boderX = board.length;
		int boderY = board[0].length;
		// 是否超过边界
		if (!((0 <= x && x < boderX) && (0 <= y && y < boderY))) {
			return false;
		}
		// 是否遇见障碍物
		if (board[x][y] == Constant.STONE) {
			return false;
		}
		// 是否撞上自己
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == x && snake.get(i).getY() == y) {
				return false;
			}
		}
		// 是否遇见豆子
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
			// 蛇增长
			snakeInstance.grow();
			// 创建新豆子
			bean = beansInstance.getBean();
			return true;
		} else {
			snakeInstance.move();
			return true;
		}
	}

	// 运行函数
	public void run() {
		// 是否处于停止状态
		while (true) {
			// 控制速度
			try {
				Thread.sleep(currentTimeInterval);
			} catch (Exception e) {
				break;
			}
			// 是否暂停
			if (!pause) {
				if (forwoard()) {
					setChanged();
					notifyObservers();
				} else {
					scoreLabel = "游戏已经结束......";
					setChanged();
					notifyObservers();
				}
			}
		}
	}

	// 设置棋盘模式
	public void setBoard(int mode) {
		boardMode = mode;
	}

	// 设置豆子模式
	public void setBeans(int mode) {
		beansMode = mode;
	}

	// 查询是否处于停止状态
	public boolean isPlaying() {
		if (pause == false) {
			return true;
		} else {
			return false;
		}
	}

	// 查询界面的宽度
	public int width() {
		if (board != null) {
			return board.length;
		} else {
			return 0;
		}
	}

	// 查询界面的高度
	public int height() {
		if (board != null) {
			return board[0].length;
		} else {
			return 0;
		}
	}

	// 查询得分
	public String score() {
		return scoreLabel + "                         " + "             您的得分："
				+ score;
	}

	// 返回棋盘
	public int[][] getBoard() {
		return board;
	}

	// 返回蛇
	public LinkedList<Node> getSnake() {
		return snake;
	}

	// 返回豆子
	public BNode getBean() {
		return bean;
	}

	// Mode单例对象
	public static Model getInstance() {
		return instance;
	}
}
