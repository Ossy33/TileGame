package dev.ossy.tilegame.states;

import dev.ossy.tilegame.Handler;
import dev.ossy.tilegame.gfx.Assets;
import dev.ossy.tilegame.ui.ClickListener;
import dev.ossy.tilegame.ui.UIImageButton;
import dev.ossy.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);

		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				State.setState(handler.getGame().gameState);

			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}


	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
}
