package aaa.game.component.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStreamImpl;

import org.loon.framework.javase.game.core.graphics.LImage;
import org.loon.framework.javase.game.core.graphics.window.LButton;
import org.loon.framework.javase.game.utils.GraphicsUtils;

import aaa.game.constv.ConstVar;

/**
 * 通用按钮设计
 */
public class ButtonSideTemplate extends LButton {
	static BufferedImage bufferedImage = GraphicsUtils
			.loadBufferedImage(ConstVar.COMMON_SIDE_BUR_IMAGE);

	public ButtonSideTemplate() {
		super(bufferedImage, null, bufferedImage.getWidth(), bufferedImage
				.getHeight() / 4, 0, 0);

		// TODO Auto-generated constructor stub
	}

}
