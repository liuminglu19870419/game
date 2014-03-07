package aaa.game.global.screen;

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
import aaa.game.global.button.CityButton;
import aaa.game.global.paper.GlobalSidePaper;

public class GlobalScreen extends ScreenTemplate {

	static GlobalSidePaper globalSidePaper = null;// 使用全局地图时，地图左边的按钮框
	static BufferedImage backMapBufferedImage = null;// 全国地图背景缓存
	static private List<CityButton> cities = null;// 地图内的城市集合,初始化方式可能还需要改进

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
		CityButton cityButton1 = new CityButton("cty00100");
		cityButton1.setLocation(300, 500);
		CityButton cityButton2 = new CityButton("cty00101");
		cityButton2.setLocation(600, 500);
		cities.add(cityButton1);
		cities.add(cityButton2);
		add(cityButton1);
		add(cityButton2);
	}

	static public List<CityButton> getCityButtons() {
		return cities;
	}

	@Override
	public void draw(LGraphics g) {
		// TODO Auto-generated method stub
		g.drawImage(backMapBufferedImage.getSubimage(0, 0,
				ConstVar.GLOBAL_WIDTH, ConstVar.GLOBAL_HEIGHT), null, 0, 0);
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
