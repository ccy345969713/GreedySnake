package models;

import java.util.LinkedList;

import config.Constant;

/******* �����ߣ����߽ڵ㹹�ɣ� *******/
public class GenSnake {

	// ��
	private LinkedList<Node> snake;
	// ���ƶ�ǰ���Ľڵ�
	private Node n;
	// ��ǰ���ķ���
	private int direction;
	// GenBoard��������
	private GenBoard boardInstance = GenBoard.getInstance();
	// GenSnake��������
	private static GenSnake instance = new GenSnake();

	// ���췽��
	private GenSnake() {
	}

	// ������
	public LinkedList<Node> resetSnake() {
		// �����ߵĳ�ʼ��ǰ������
		direction = Constant.RIGHT;
		// ��ȡ��ǰ����
		int[][] board = boardInstance.giveBoardToOthers();
		// ��ȡ�ߵĳ�ʼ����
		int length = Constant.snakeLength;
		// ������ʼ������
		snake = new LinkedList<Node>();
		for (int i = length - 1; i >= 0; i--) {
			if (board[i][0] == Constant.BLANK) {
				snake.add(new Node(i, 0));
			}
		}
		return snake;
	}

	// �߸ı䷽��
	public void changeDiertion(int changeDirection) {
		if (direction % 2 != changeDirection % 2) {
			direction = changeDirection;
		}
	}

	// ����ǰ�ƶ�
	public void move() {
		// ���ǰ���ڵ�
		snake.addFirst(n);
		// ɾ���󷽽ڵ�
		snake.removeLast();
	}

	// �߳Զ�������S
	public void grow() {
		snake.addFirst(n);
	}

	// ���ƶ�ǰ���Ľڵ�
	public Node headNode() {
		// �ߴ���ͷλ�Ľڵ�
		Node head = snake.getFirst();
		int x = head.getX();
		int y = head.getY();
		// ���ݷ�����������ֵ
		switch (direction) {
		case Constant.UP:
			y++;
			break;
		case Constant.DOWN:
			y--;
			break;
		case Constant.LEFT:
			x--;
			break;
		case Constant.RIGHT:
			x++;
			break;
		}
		// ��¼�ƶ��Ľڵ�
		n = new Node(x, y);
		return n;
	}

	// �����߸�����
	public LinkedList<Node> giveSnakeToOthers() {
		return snake;
	}

	// GenSnake��������
	public static GenSnake getInstance() {
		return instance;
	}
}
