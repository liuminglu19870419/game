package aaa.test.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LButton;
import org.loon.framework.javase.game.core.graphics.window.LPaper;

public class TestLPanel extends LPaper {

	List<LButton> lButtons = new ArrayList<LButton>();
	String title = "";
	public TestLPanel(int size, String title) {
		super(20, 20, 150, size * 60);
		this.title = title;
		// TODO Auto-generated constructor stub
		for (int i = 0; i < size; i++) {
			LButton lButton = new LButton("images/button.png");
			lButton.setText(title);
			lButton.setLocation(10, 10 + i * 50);
			this.add(lButton);
			lButtons.add(lButton);
		}
		this.setBackground(Color.WHITE);
		this.setLocked(true);
		this.setAlpha(0.1f);
	}

}
