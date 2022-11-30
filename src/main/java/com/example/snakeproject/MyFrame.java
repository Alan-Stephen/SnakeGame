package com.example.snakeproject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.scene.image.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 */ 

// TODO: Seperate MyFrame and Play into MVC.
	// create seperate class for to implement KeyListener
public class MyFrame extends JPanel implements KeyListener
{
	private static final long serialVersionUID = -3149926831770554380L;

	public JFrame jFrame = new JFrame();

	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/snake-logo.png")));
	}

	/** Sets up JFrame by naming it and specifying other options and adds
	 * current class instance to the JFrame, also calls setVisible and MyThread.
	 *
	 * */
	public void loadFrame()
	{
		/*
		 * Komið í veg fyrir að myndin blikki.
		 */
		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("Snakee Yipee");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter()// loka
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		new MyThread().start();
	}

	/** Infinitely calls the repaint function until exception is thrown.
	 *
	 * */
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/** Interface for any visible objects on board.
	 *
	 * */
	public abstract static class SnakeObject
	{
		int x;
		int y;
		Image i;
		int w;
		int h;

		public boolean l; //not necesary


		public abstract void draw(Graphics g);

		public Rectangle getRectangle()
		{
			return new Rectangle(x, y, w, h);
		}
	}
}
