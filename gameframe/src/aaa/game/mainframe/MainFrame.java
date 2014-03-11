/**
 * @author xiaolubambi
 *
 */
package aaa.game.mainframe;

import java.util.Stack;

import org.loon.framework.javase.game.GameScene;
import org.loon.framework.javase.game.core.graphics.Deploy;

import aaa.game.component.screen.ScreenTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.global.screen.GlobalScreen;

public class MainFrame extends GameScene {

	private static MainFrame mainFrame = null;
	private static ScreenTemplate currentScreen = null;
	private static Stack<ScreenTemplate> screenStack = new Stack<ScreenTemplate>();

	private MainFrame() {
		super("game", ConstVar.GLOBAL_WIDTH, ConstVar.GLOBAL_HEIGHT);
		this.setCursor(ConstVar.GAME_CURSOR);
		this.getDeploy().setLogo(false);
		this.getDeploy().setShowFPS(ConstVar.DEBUG);
		this.getDeploy().setFPS(ConstVar.FPS);
	}

	public static void start() {
		mainFrame = new MainFrame();
		GlobalScreen screen = new GlobalScreen();
		pushScreen(screen);
		mainFrame.getDeploy().mainLoop();
		mainFrame.showFrame();
	}

	public static void pushScreen(ScreenTemplate screen) {
		currentScreen = screen;
		screenStack.push(screen);
		startScreen(currentScreen);
	}

	public static void popScreen() {
		if (screenStack.size() == 1) {
			return;
		} else {
			screenStack.pop();
			currentScreen = screenStack.peek();
			startScreen(currentScreen);
		}

	}

	private static void startScreen(ScreenTemplate screenTemplate) {
		mainFrame.getDeploy().setScreen(screenTemplate);
	}

	public static MainFrame getFrame() {
		return mainFrame;
	}
}
