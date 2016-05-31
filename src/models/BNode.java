package models;

/******* 豆子节点 *******/
public class BNode extends Node {

	// 豆子类型（使用Constant中的常量赋值）
	private final int type;

	// 构造方法（设置坐标和豆子类型）
	public BNode(int x, int y, int type) {
		super(x, y);
		this.type = type;
	}

	// 获取豆子类型
	public int getType() {
		return type;
	}
}
