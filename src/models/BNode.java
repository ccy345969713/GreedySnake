package models;

/******* ���ӽڵ� *******/
public class BNode extends Node {

	// �������ͣ�ʹ��Constant�еĳ�����ֵ��
	private final int type;

	// ���췽������������Ͷ������ͣ�
	public BNode(int x, int y, int type) {
		super(x, y);
		this.type = type;
	}

	// ��ȡ��������
	public int getType() {
		return type;
	}
}
