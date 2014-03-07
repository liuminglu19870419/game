package aaa.test.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.loon.framework.javase.game.GameScene;
import org.loon.framework.javase.game.core.graphics.Deploy;
import org.loon.framework.javase.game.core.graphics.Screen;
import org.loon.framework.javase.game.core.graphics.device.LGraphics;
import org.loon.framework.javase.game.core.graphics.window.LButton;
import org.loon.framework.javase.game.core.graphics.window.LPanel;
import org.loon.framework.javase.game.core.graphics.window.LPaper;
import org.loon.framework.javase.game.utils.GraphicsUtils;

public class MainScreen extends Screen {

	LPaper lPanel1 = null;
	LPanel lPanel2 = null;
	LPanel lPanel3 = null;
	LPanel lPanel4 = null;
	int HEIGHT = 960;
	int WIDTH = 1440;
	int titlePanelHeight = 40;
	int titlePanelWidth = 1440;
	int sidePanelHeight = HEIGHT - titlePanelHeight;
	int sidePanelWidth = 100;
	int mainPanelHeight = HEIGHT - titlePanelHeight;
	int mainPanelWidth = WIDTH - sidePanelWidth;
	int bottomPanelHeight = 0;
	int bottomPanelWidth = 0;

	int lButtonx = 500;
	int lButtony = 500;
	LButton lButton = new LButton("images/button.png");
	{
		lButton.setLocation(500, 500);
		add(lButton);
	}
	List<LButton> buttons2 = new ArrayList<>();
	List<LButton> buttons = new ArrayList<>();

	int deltax = 0;
	int deltay = 0;

	String[] itemStrings = { "�г�", "�ƹ�", "����", "�ݸ�", "��Ժ", "ѧ��", "�ֵ�",
			"���� ", "���� " };
	String[] peopleStrings = { "�г� ����", "�ƹ� ·��", "���� ·��", "�ݸ� ·��",
			"��Ժ ·��", "ѧ�� ·��", "�ֵ� ·��", "���� ·�� ", "���� ·�� " };

	public MainScreen() {
		// TODO Auto-generated constructor stub
		super();
		int count = itemStrings.length;
		LPaper lPaper = new LPaper(0, 50, 150, count * 50 + 10);
		for (int i = 0; i < count; i++) {
			LButton lButton = new LButton("images/button.png");
			lButton.setText(itemStrings[i]);
			// lButton.setSize(100, 40);
			lButton.setLocation(10, 10 + i * 50);
			lButton.setLayer(190);
			buttons.add(lButton);
			lPaper.add(lButton);
		}
		lPaper.setLocked(false);
		lPaper.setBackground(Color.WHITE);
		lPaper.setAlpha(0.1f);
		this.add(lPaper);
		int peoplecount = 20;
		BufferedImage bufferedImage = new BufferedImage(50, 50,
				BufferedImage.TYPE_4BYTE_ABGR);

		int k = 740;
		int x = 0;
		int x_delata = 220;
		LPaper lPaper1 = new LPaper(300, 500, 130, 220);
		for (int i = 0; i < peopleStrings.length; i++) {
			LButton lButton = new LButton("images/loli.png", "", x * 100
					+ x_delata, k) {

			};
			String[] namesStrings = peopleStrings[i].split(" ");
			lButton.setText(namesStrings[0] + "\n" + namesStrings[1]);
			x += 1;
			if ((i + 1) % 10 == 0) {
				k += 100;
				x = 0;
			}
			// LButton lButton = new LButton(lImage.getBufferedImage(), "",
			// i * 60, 500);
			buttons2.add(lButton);
			add(lButton);

		}

		lPanel1 = new LPaper(0, 0, titlePanelWidth, titlePanelHeight);
		lPanel1.setBackground(Color.GREEN);
		lPanel1.setAlpha(0.9f);
		lPanel1.setLayer(100);
		lPanel2 = new LPanel(0, titlePanelHeight + 1, sidePanelWidth,
				sidePanelHeight);
		lPanel2.setLayer(100);
		lPanel3 = new LPanel(sidePanelWidth + 1, titlePanelHeight + 1,
				mainPanelWidth, mainPanelHeight);
		lPanel2.setBackground(Color.RED);
		lPanel3.setBackground(Color.BLUE);
		lPanel3.setLayer(100);
		lPanel3.setAlpha(0.9f);
		lPanel2.setAlpha(0.9f);
		// this.add(lPanel1);
		// this.add(lPanel2);
		// this.add(lPanel3);
	}

	boolean pressed = false;
	int x[] = new int[5000];
	int y[] = new int[5000];

	boolean haveone = false;
	int count = 0;

	int xSpeed = 5;
	int ySpeed = 5;
	int imagex = 0;
	int imagey = 0;

	@Override
	public boolean next() {

		if (getMouseX() < 10) {
			imagex -= xSpeed;
			xSpeed++;
			if (imagex < 0) {
				imagex = 0;
				xSpeed = 5;
			}
		} else if (getMouseX() >= 1430) {
			imagex += xSpeed;
			xSpeed++;
			if (imagex > 5120 - 1440) {
				imagex = 5120 - 1440;
				xSpeed = 5;
			}
		} else {
			xSpeed = 5;
		}
		if (getMouseY() < 10) {
			imagey -= ySpeed;
			if (imagey < 0) {
				imagey = 0;
				ySpeed = 5;
			}

		} else if (getMouseY() > 950) {
			imagey += ySpeed;
			ySpeed++;
			if (imagey > 3200 - 960) {
				imagey = 3200 - 960;
				ySpeed = 5;
			}
		} else {
			ySpeed = 5;
		}
		for (LButton lButton : buttons2) {

			if (lButton.isPressed()) {
				int x = lButton.getScreenX();
				int y = lButton.getScreenY();
				lButton.setLocation(this.getMouseX() - 47,
						this.getMouseY() - 47);
				haveone = true;
			}
		}
		if (!haveone) {
			pressed = false;
		}
		if (isClick()) {
			Random random = new Random();
			for (int i = 1; i < x.length; i++) {
				x[i] = random.nextInt(1440);
				y[i] = random.nextInt(960);
			}
		}
		return true;
	}

	BufferedImage bufferedImage = null;
	{
		File file = new File("images/global.jpg");
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			bufferedImage = ImageIO.read(new BufferedInputStream(
					fileInputStream));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(LGraphics g) {
		// TODO Auto-generated method stub
		GraphicsUtils.setAntialias((Graphics) g, true);
		System.out.println(imagex);
		System.out.println(imagey);
		lButton.setLocation(-imagex + 200, -imagey + 200);
		g.drawImage(bufferedImage.getSubimage(imagex, imagey, 1440, 960), null,
				0, 0);
		g.setFont(GraphicsUtils.getFont("������κ", 20));
		// for (int i = 0; i < x.length; i++) {
		// GraphicsUtils.drawStyleString((Graphics) g, "hello", x[i], y[i],
		// Color.WHITE, Color.BLACK);
		// }

		GraphicsUtils.setAntialias((Graphics) g, false);
	}

	@Override
	public void leftClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKey(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyUp(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	boolean ispressed = false;

	@Override
	public void mouseReleased(MouseEvent arg0) {
		ispressed = false;
	}

	int lastx = 0;
	int lasty = 0;

	@Override
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		lastx = arg0.getX();
		lasty = arg0.getY();
		ispressed = true;
		System.out.println("pressed");
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMove(MouseEvent arg0) {
		super.mouseMove(arg0);

		if (arg0.getButton() == MouseEvent.MOUSE_DRAGGED) {
			int x = arg0.getX();
			System.out.println(x);
			int y = arg0.getY();
			imagex += 1;
			imagey += 1;

		}
	}

	public static void main(String[] args) {
		GameScene gameScene = new GameScene("main frame test", 1440, 960);
		Deploy deploy = gameScene.getDeploy();
		deploy.setScreen(new MainScreen());
		MainScreen mainScreen = new MainScreen();
		deploy.setFPS(100);
		deploy.setShowFPS(true);
		deploy.setLogo(false);
		deploy.mainLoop();
		gameScene.setCursor("images/cursor.png");
		gameScene.showFrame();

	}
}
