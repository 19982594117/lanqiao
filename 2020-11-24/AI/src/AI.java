import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;

	int heroX=100,heroY=120,i,bossX=0,bossY=0;
	Image bossImg;
	Image heroImg[][]= new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");//0为左，1为右，2为上，3为下
			    }
			}
			bossImg=Image.createImage("/linrixin.jpg");
			currentImg=heroImg[3][1];
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void changePicAndDirect(int direction){
		i++;
		if(i%2==0){
			currentImg=heroImg[direction][1];
			}
		else if(i%2==1){
			currentImg=heroImg[direction][2];
			}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicAndDirect(0);
			heroX=heroX-5;
			}
		if(action==RIGHT){
			changePicAndDirect(1);
			heroX=heroX+5;
		}
		if(action==UP){
			changePicAndDirect(2);
			heroY=heroY-5;
		}
		if(action==DOWN){
			changePicAndDirect(3);
			heroY=heroY+5;
		}
		repaint();
    }
}