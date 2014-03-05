package aaa.test.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LButton;
import org.loon.framework.javase.game.core.graphics.window.LPaper;

public class TestLPanel2 extends LPaper {

	List<LButton> lButtons = new ArrayList<LButton>();
	String title = "";

	public TestLPanel2(int size, String title) {
		super(300, 500, 1000, 200);
		this.title = title;
		// TODO Auto-generated constructor stub
		int k = 10;
		int x = 0;
		int x_delata = 20;
		for (int i = 0; i < size; i++) {
			LButton lButton = new LButton("images/loli.png");
			lButton.setText(title);
			lButton.setLocation(x * 100 + x_delata, k);
			x += 1;
			if ((i + 1) % 10 == 0) {
				k += 100;
				x = 0;
			}
			lButtons.add(lButton);
			this.add(lButton);
		}
		this.setBackground(Color.WHITE);
		this.setLocked(true);
		this.setAlpha(0.1f);
	}
}
