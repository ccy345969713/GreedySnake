package config;

/******* 保存常量 ********/
public class Constant {

	/**** 棋盘模式 ****/
	public static final int STAGE_MODE = 000;// STAGE_MODE棋盘（60*40）
	public static final int STANDARD_MODE = 001;// STANDARD_MODE棋盘（50*50）
	public static final int BIG_MODE = 002;// BIG_MODE棋盘（70*70）
	public static final int SMALL_MODE = 003;// SMALL_MODE棋盘（40*40）

	/**** 棋盘的盘格类型 ****/
	// STAGE_MODE下才村个多种盘格类型，其他模式下只有空白盘格
	public static final int BLANK = 100;// 空白盘格（蛇可以正常通过）
	public static final int STONE = 101;// 石头盘格（蛇撞上则死亡）

	/**** 豆子模式 ****/
	public static final int TRANDITION_MODE = 400;// 传统模式（只有普通豆子）
	public static final int FUNNY_MODE = 401;// 趣味模式（有普通豆子，双倍豆子，加速豆子，减速豆子）

	/**** 豆子类型 ****/
	public static final int NORMAL_BEAN = 500;// 普通豆子（蛇吃后获得一倍积分）
	public static final int DOUBLE_BEAN = 501;// 双倍豆子（蛇吃后获得两倍积分）
	public static final int SPEEDUP_BEAN = 502;// 加速豆子（蛇吃后加快速度）
	public static final int SPEEDDOWN_BEAN = 503;// 减速豆子（蛇吃后减慢速度）

	/**** 豆子几率 ****/
	public static final float NORMAL_BEAN_RATE = (float) 0.8;// 产生普通豆子的几率
	public static final float DOUBLE_BEAN_RATE = (float) 0.1;// 产生双倍豆子的几率
	public static final float SPEEDUP_BEAN_RATE = (float) 0.05;// 产生加速豆子的几率
	public static final float SPEEDDOWN_BEAN_RATE = (float) 0.05;// 产生减速豆子几率

	/**** 蛇前进的方向 ****/
	public static final int UP = 301;// 向上走
	public static final int DOWN = 303;// 向下走
	public static final int LEFT = 302;// 向左走
	public static final int RIGHT = 304;// 向右走

	/**** 蛇的初始化长度 ****/
	public static final int snakeLength = (int) 4;// 长度的数值
}
