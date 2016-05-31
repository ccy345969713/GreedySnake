package models;

import java.util.ArrayList;

import config.Obstacles;

/******* 关卡障碍物 （STAGE_MODE） *******/
public class GenSelector {

	// 当前关卡数据
	private Integer[][] obstacles;
	// 关卡数据集
	private ArrayList<Integer[][]> obstaclesData;
	// GenSelector单例对象
	private static GenSelector instance = new GenSelector();

	// 构造函数（建立关卡数据）
	private GenSelector() {
		// 建立关卡数据集
		obstaclesData = Obstacles.getObstaclesData();
	}

	// 选择指定的关卡（操作正确返回true，操作错误返回false）
	public boolean setSpecifcStage(int i) {
		// 统计关卡总数
		int numberOfObstaclesDatas = obstaclesData.size();
		// 选择指定关卡
		if (i >= 1 && i <= numberOfObstaclesDatas) {
			obstacles = obstaclesData.get(i - 1);
			return true;
		} else {
			return false;
		}
	}

	// 返回关卡数据
	public Integer[][] getObstacles() {
		return obstacles;
	}

	// 返回GenSelector单例对象
	public static GenSelector getInstance() {
		return instance;
	}
}
