package control;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/******* 帮助菜单控制器 *******/
public class MenuHelpControl implements ActionListener {

	// 点击信息
	String info;
	// 父容器信息
	JFrame frame;

	// 构造方法
	public MenuHelpControl(String info, JFrame frame) {
		this.info = info;
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		if (info.equals("authorInfo")) {
			// 显示提示框
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, "制作人：杨雨绮", "作者信息",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			// 创建信息
			String gameInfo = "";
			gameInfo += "控制按钮：\n";
			gameInfo += "方向------上下左右\n";
			gameInfo += "加速------PageUp\n";
			gameInfo += "减速------PageDown\n\n";
			gameInfo += "棋盘模式：\n";
			gameInfo += "标准模式------50x50\n";
			gameInfo += "增大模式------70x70\n";
			gameInfo += "缩小模式------40x40\n";
			gameInfo += "闯关模式------60x40\n\n";
			gameInfo += "豆子模式：\n";
			gameInfo += "普通豆子（黑色）------1点积分\n";
			gameInfo += "双倍豆子（红色）------2点积分\n";
			gameInfo += "加速豆子（绿色）------1点积分，加速效果\n";
			gameInfo += "减速豆子（蓝色）------1点计分，减速效果\n";
			// 显示提示框
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, gameInfo, "游戏信息",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
