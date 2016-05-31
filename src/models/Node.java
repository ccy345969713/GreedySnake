package models;

/******* 节点 *******/
public class Node {

	// 节点的x坐标
	private final int x;
	// 节点的y坐标
	private final int y;

	// 构造方法（设置坐标）
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 获取x坐标的值
	public int getX() {
		return x;
	}

	// 获取y坐标的值
	public int getY() {
		return y;
	}
}
