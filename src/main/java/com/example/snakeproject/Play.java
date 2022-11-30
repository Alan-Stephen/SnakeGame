package com.example.snakeproject;



import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.event.KeyEvent;
// TODO: Seperate to MVC

// This class needs to be split up.

/**
 * Frame of program, contains primary game loop.
 */
public class Play extends MyFrame
{

	private static final long serialVersionUID = -3641221053272056036L;

	public Snake mySnake = new Snake(100, 100);// x , y
	public Food food = new Food();

	public Image background = ImageUtil.images.get("UI-background");
	public Image fail = ImageUtil.images.get("game-scene-01");

	/**
	 * handles keyPresses.
	 * */
	@Override
	public void keyPressed(KeyEvent e){
	}

	/**
	 * renders background, checks if snake is alive, creates new food if no
	 * food is on screen, updates score.
	 * */
	/*@Override
	public void paint(GraphicsContext g)
	{
		super.paint(g);
		g.drawImage(background, 0, 0, null);

		// Ákveða stöðu leiksins.
		if (mySnake.l)
		{
			mySnake.draw(g);
			if (food.l)
			{
				food.draw(g);
				food.eaten(mySnake);
			} else
			{
				food = new Food();
			}
		} else
		{
			g.drawImage(fail, 0, 0, null);
		}
		drawScore(g);
	}*/

	/**
	 * Draws score on screen
	 * */
	// TO DELETE BLOW
/*	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		// frame.setSize(400,600);
		frame.setBounds(450, 200, 920, 600);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SnakePanel panel = new SnakePanel();
		frame.add(panel);

		frame.setVisible(true);

		// Play the background music.
		MusicPlayer.getMusicPlay("resource\\music\\background.mp3");
	} 
*/
}
