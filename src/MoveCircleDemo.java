


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MoveCircleDemo extends JFrame implements Runnable{

	Thread red,green,blue;
	int x1,x2,x3,y1,y2,y3;

	public  MoveCircleDemo() {

		red=new Thread(this);
		blue=new Thread(this);
		green=new Thread(this);

		red.start();
		green.start();
		blue.start();

		x1=x2=x3=30;
		y1=70;
		y2=180;
		y3=300;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			for(;;)
			{
				if(Thread.currentThread()==red)
				{
					if(x1==300)
					{
						synchronized (this)
						{
							wait();
							x1++;
						}
					}
					else
						x1++;

					Thread.sleep(10);
					
				}

				if(Thread.currentThread()==green)
				{
					if(x2==300)
					{
						synchronized (this)
						{
							wait();
							x2++;
						}
					}
					else
						x2++;
					Thread.sleep(20);
					
				}

				if(Thread.currentThread()==blue)
				{
					if(x3==300)
					{
						synchronized (this) 
						{
							
							notify();
							x3++;
						}
					}
					else
						x3++;
					Thread.sleep(30);
					
				}
				repaint();
			}
		}
		catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(x1,y1, 30, 30);

		g.setColor(Color.green);
		g.fillOval(x2,y2, 30, 30);

		g.setColor(Color.blue);
		g.fillOval(x3,y3, 30, 30);
	}
	public static void main(String[] args) {

		MoveCircleDemo mc=new MoveCircleDemo();
		mc.setSize(500,500);
		mc.setVisible(true);

	}

}
