package aaa.test.frame;

import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LPaper;

public class CommonSidePaper extends LPaper {
	
	String sidePaperId = null;
	public CommonSidePaper(String id, List<String> pIds) {
		// TODO Auto-generated constructor stub
		super(50, 50, 100, pIds.size() * 50);
		
	}

}
