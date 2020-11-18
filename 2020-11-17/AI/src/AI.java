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
	int x=100,y=120,i,t,a,b;
	Image downImg,leftImg,upImg,rightImg,currentImg,leftImg1,leftImg2,rightImg1,rightImg2,upImg1,upImg2,downImg1,downImg2;
	public MainCanvas(){
		try
		{
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			currentImg=downImg;
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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			i++;
			if(i==1){
				currentImg=leftImg;
				System.out.println("Ïò×ó×ª");}
			else if(i%2==0){
				currentImg=leftImg1;
				System.out.println("ÂõÓÒ½Å");}
			else{currentImg=leftImg2;
				System.out.println("Âõ×ó½Å");}
			x=x-5;
			}
		if(action==RIGHT){
			t++;
			if(t==1){
				currentImg=rightImg;
				System.out.println("ÏòÓÒ×ª");}
			else if(t%2==0){
				currentImg=rightImg1;
				System.out.println("ÂõÓÒ½Å");}
			else{currentImg=rightImg2;
			    System.out.println("Âõ×ó½Å");}
			x=x+5;
		}
		if(action==UP){
			a++;
			if(a==1){
			currentImg=upImg;
			System.out.println("ÏòÉÏ×ª");}
			else if(a%2==0){
				currentImg=upImg1;
				System.out.println("ÂõÓÒ½Å");}
			else{currentImg=upImg2;
			    System.out.println("Âõ×ó½Å");}
			y=y-5;
		}
		if(action==DOWN){
			b++;
			if(b==1){
			    currentImg=downImg;
			    System.out.println("ÏòÏÂ×ª");}
			else if(b%2==0){
				currentImg=downImg1;
				System.out.println("ÂõÓÒ½Å");}
			else{currentImg=downImg2;
			    System.out.println("Âõ×ó½Å");}
			y=y+5;
		}
		repaint();
    }
}