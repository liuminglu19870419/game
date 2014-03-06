package aaa.test.libtest;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameHideTeset {

	static JPanel jPanel = new JPanel();

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("test");
		jFrame.setSize(200, 200);
		jFrame.setLayout(new FlowLayout());
		JButton jButton = new JButton();
		jButton.setText("test");
		JButton jButton1 = new JButton();
		jButton1.setText("test1");
		jPanel.setFocusable(true);
		jPanel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("jpanel key released");
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		jPanel.add(jButton1);
		jFrame.add(jPanel);
		jFrame.add(jButton);
		jButton.addActionListener(new ActionListener() {
			boolean flag = false;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				flag = !flag;
				jPanel.setVisible(flag);
			}
		});
		jFrame.setVisible(true);
	}

}
