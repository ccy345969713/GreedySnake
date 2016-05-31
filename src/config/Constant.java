package config;

/******* ���泣�� ********/
public class Constant {

	/**** ����ģʽ ****/
	public static final int STAGE_MODE = 000;// STAGE_MODE���̣�60*40��
	public static final int STANDARD_MODE = 001;// STANDARD_MODE���̣�50*50��
	public static final int BIG_MODE = 002;// BIG_MODE���̣�70*70��
	public static final int SMALL_MODE = 003;// SMALL_MODE���̣�40*40��

	/**** ���̵��̸����� ****/
	// STAGE_MODE�²Ŵ�������̸����ͣ�����ģʽ��ֻ�пհ��̸�
	public static final int BLANK = 100;// �հ��̸��߿�������ͨ����
	public static final int STONE = 101;// ʯͷ�̸���ײ����������

	/**** ����ģʽ ****/
	public static final int TRANDITION_MODE = 400;// ��ͳģʽ��ֻ����ͨ���ӣ�
	public static final int FUNNY_MODE = 401;// Ȥζģʽ������ͨ���ӣ�˫�����ӣ����ٶ��ӣ����ٶ��ӣ�

	/**** �������� ****/
	public static final int NORMAL_BEAN = 500;// ��ͨ���ӣ��߳Ժ���һ�����֣�
	public static final int DOUBLE_BEAN = 501;// ˫�����ӣ��߳Ժ����������֣�
	public static final int SPEEDUP_BEAN = 502;// ���ٶ��ӣ��߳Ժ�ӿ��ٶȣ�
	public static final int SPEEDDOWN_BEAN = 503;// ���ٶ��ӣ��߳Ժ�����ٶȣ�

	/**** ���Ӽ��� ****/
	public static final float NORMAL_BEAN_RATE = (float) 0.8;// ������ͨ���ӵļ���
	public static final float DOUBLE_BEAN_RATE = (float) 0.1;// ����˫�����ӵļ���
	public static final float SPEEDUP_BEAN_RATE = (float) 0.05;// �������ٶ��ӵļ���
	public static final float SPEEDDOWN_BEAN_RATE = (float) 0.05;// �������ٶ��Ӽ���

	/**** ��ǰ���ķ��� ****/
	public static final int UP = 301;// ������
	public static final int DOWN = 303;// ������
	public static final int LEFT = 302;// ������
	public static final int RIGHT = 304;// ������

	/**** �ߵĳ�ʼ������ ****/
	public static final int snakeLength = (int) 4;// ���ȵ���ֵ
}
