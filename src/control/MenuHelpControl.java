package control;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/******* �����˵������� *******/
public class MenuHelpControl implements ActionListener {

	// �����Ϣ
	String info;
	// ��������Ϣ
	JFrame frame;

	// ���췽��
	public MenuHelpControl(String info, JFrame frame) {
		this.info = info;
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		if (info.equals("authorInfo")) {
			// ��ʾ��ʾ��
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, "�����ˣ������", "������Ϣ",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			// ������Ϣ
			String gameInfo = "";
			gameInfo += "���ư�ť��\n";
			gameInfo += "����------��������\n";
			gameInfo += "����------PageUp\n";
			gameInfo += "����------PageDown\n\n";
			gameInfo += "����ģʽ��\n";
			gameInfo += "��׼ģʽ------50x50\n";
			gameInfo += "����ģʽ------70x70\n";
			gameInfo += "��Сģʽ------40x40\n";
			gameInfo += "����ģʽ------60x40\n\n";
			gameInfo += "����ģʽ��\n";
			gameInfo += "��ͨ���ӣ���ɫ��------1�����\n";
			gameInfo += "˫�����ӣ���ɫ��------2�����\n";
			gameInfo += "���ٶ��ӣ���ɫ��------1����֣�����Ч��\n";
			gameInfo += "���ٶ��ӣ���ɫ��------1��Ʒ֣�����Ч��\n";
			// ��ʾ��ʾ��
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, gameInfo, "��Ϸ��Ϣ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
