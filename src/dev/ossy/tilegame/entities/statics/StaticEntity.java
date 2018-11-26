package dev.ossy.tilegame.entities.statics;

import dev.ossy.tilegame.Handler;
import dev.ossy.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {


	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}


}
