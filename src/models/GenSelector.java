package models;

import java.util.ArrayList;

import config.Obstacles;

/******* �ؿ��ϰ��� ��STAGE_MODE�� *******/
public class GenSelector {

	// ��ǰ�ؿ�����
	private Integer[][] obstacles;
	// �ؿ����ݼ�
	private ArrayList<Integer[][]> obstaclesData;
	// GenSelector��������
	private static GenSelector instance = new GenSelector();

	// ���캯���������ؿ����ݣ�
	private GenSelector() {
		// �����ؿ����ݼ�
		obstaclesData = Obstacles.getObstaclesData();
	}

	// ѡ��ָ���Ĺؿ���������ȷ����true���������󷵻�false��
	public boolean setSpecifcStage(int i) {
		// ͳ�ƹؿ�����
		int numberOfObstaclesDatas = obstaclesData.size();
		// ѡ��ָ���ؿ�
		if (i >= 1 && i <= numberOfObstaclesDatas) {
			obstacles = obstaclesData.get(i - 1);
			return true;
		} else {
			return false;
		}
	}

	// ���عؿ�����
	public Integer[][] getObstacles() {
		return obstacles;
	}

	// ����GenSelector��������
	public static GenSelector getInstance() {
		return instance;
	}
}
