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
class MainCanvas extends Canvas
{
	int x=100,y=120,i;
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
			currentImg=heroImg[3][1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void changePicAndDirect(int direction){
		i++;
		if(i%2==0){
			currentImg=heroImg[direction][1];
			}
		else if(i%2==1){
			currentImg=heroImg[direction][2];
			}
		repaint();
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicAndDirect(0);
			x=x-5;
			}
		if(action==RIGHT){
			changePicAndDirect(1);
			x=x+5;
		}
		if(action==UP){
			changePicAndDirect(2);
			y=y-5;
		}
		if(action==DOWN){
			changePicAndDirect(3);
			y=y+5;
		}
		repaint();
    }
}