package aaa.game.global.screen;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.loon.framework.javase.game.core.graphics.device.LGraphics;

import aaa.game.component.screen.ScreenTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.global.button.CityButton;
import aaa.game.global.paper.GlobalSidePaper;

public class GlobalScreen extends ScreenTemplate {

	static GlobalSidePaper globalSidePaper = null;// 使用全局地图时，地图左边的按钮框
	static BufferedImage backMapBufferedImage = null;// 全国地图背景缓存
	static private List<CityButton> cities = null;// 地图内的城市集合,初始化方式可能还需要改进
	static private int deltaX = 0;
	static private int deltaY = 0;
	static private int speedX = 20;
	static private int speedY = 20;
	static {
		// 载入全局地图
		File file = new File(ConstVar.GlobalMap.MAP);
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			backMapBufferedImage = ImageIO.read(new BufferedInputStream(
					fileInputStream));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 载入全局左侧边框
		globalSidePaper = new GlobalSidePaper();
		cities = new ArrayList<CityButton>();
	}

	public GlobalScreen() {
		super();

		add(globalSidePaper);
		loadCities();
	}

	private void loadCities() {
		for (String cityId : ShareData.cities.getAllId()) {
			CityButton cityButton = new CityButton(cityId);
			cities.add(cityButton);
			add(cityButton);
		}
	}

	static public List<CityButton> getCityButtons() {
		return cities;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		System.out.println("key pressed");
		if (e.getKeyCode() == KeyEvent.VK_A) {
			deltaX -= speedX;
			if (deltaX <= 0) {
				deltaX = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			deltaX += speedX;
			if (deltaX >= backMapBufferedImage.getWidth()
					- ConstVar.GLOBAL_WIDTH) {
				deltaX = backMapBufferedImage.getWidth()
						- ConstVar.GLOBAL_WIDTH;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			deltaY -= speedY;
			if (deltaY <= 0) {
				deltaY = 0;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			deltaY += speedY;
			if (deltaY >= backMapBufferedImage.getHeight()
					- ConstVar.GLOBAL_HEIGHT) {
				deltaY = backMapBufferedImage.getHeight()
						- ConstVar.GLOBAL_HEIGHT;
			}
		}
		System.out.println(deltaX + " " + deltaY);
	}

	@Override
	public void draw(LGraphics g) {
		// TODO Auto-generated method stub
		g.setAntiAlias(true);
		g.drawImage(backMapBufferedImage.getSubimage(deltaX, deltaY,
				ConstVar.GLOBAL_WIDTH, ConstVar.GLOBAL_HEIGHT), null, 0, 0);

		for (CityButton cityButton : cities) {
			cityButton.setLocation(cityButton.getxPos() - deltaX,
					cityButton.getyPos() - deltaY);
		}
		g.setAntiAlias(false);
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyUp(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
