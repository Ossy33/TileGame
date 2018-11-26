package dev.ossy.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    public static BufferedImage player, treeTile, grassTile, stoneTile, dirtTile, darkBrickTile, lightBrickTile, barrierTile, whiteTile, blackTile, purpleTile, redTile, darkBlueTile, lightBlueTile, darkGreenTile, lightGreenTile, orangeTile;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] btn_start;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite Sheet.png"));

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(5* width, 2* height, width * 2, height);
        btn_start[1] = sheet.crop(5* width, 3* height, width * 2, height);

        player_down = new BufferedImage[2];
        player_down[0] = sheet.crop(width * 4, 0, width, height);
        player_down[1] = sheet.crop(width * 5, 0, width, height);

        player_up = new BufferedImage[2];
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);

        player_right = new BufferedImage[2];
        player_right[0] = sheet.crop(width * 4, height, width, height);
        player_right[1] = sheet.crop(width * 5, height, width, height);

        player_left = new BufferedImage[2];
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);

        player = sheet.crop(0,0, width, height);
        grassTile = sheet.crop(width, 0, width, height);
        stoneTile = sheet.crop(2*width, 0, width, height);
        dirtTile = sheet.crop(3*width,0, width, height);
        treeTile = sheet.crop(4*width, 2* height, width, height * 2);

        darkBrickTile = sheet.crop(0, height, width, height);
        lightBrickTile = sheet.crop(width, height, width, height);
        barrierTile = sheet.crop(2*width, height, width, height);
        whiteTile = sheet.crop(3* width, height, width, height);

        blackTile = sheet.crop(0,2*height, width, height);
        purpleTile = sheet.crop(width, 2* height, width, height);
        redTile = sheet.crop(2*width, 2* height, width, height);
        darkBlueTile = sheet.crop(3* width, 2* height, width ,height);
        lightBlueTile = sheet.crop(0, 3* height, width, height);
        darkGreenTile = sheet.crop(width, 3* height, width, height);
        lightGreenTile = sheet.crop(2*width, 3* height, width, height);
        orangeTile = sheet.crop(3*width, 3* height, width , height);


    }

}
