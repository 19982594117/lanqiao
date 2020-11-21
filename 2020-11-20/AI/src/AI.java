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
	int x=100,y=120,e,t,a,b;
	Image heroDownImg[]=new Image[3];
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}

            /*
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
            ��*/


			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}

            /*
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			��*/


			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
            /*
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			��*/
			

			for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
            /*
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			��*/
			
			currentImg=heroDownImg[1];
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
			e++;
			if(e==1){
				currentImg=heroLeftImg[1];
				System.out.println("����ת");}
			else if(e%2==0){
				currentImg=heroLeftImg[0];
				System.out.println("���ҽ�");}
			else{currentImg=heroLeftImg[2];
				System.out.println("�����");}
			x=x-5;
			}
		if(action==RIGHT){
			t++;
			if(t==1){
				currentImg=heroRightImg[1];
				System.out.println("����ת");}
			else if(t%2==0){
				currentImg=heroRightImg[0];
				System.out.println("���ҽ�");}
			else{currentImg=heroRightImg[2];
			    System.out.println("�����");}
			x=x+5;
		}
		if(action==UP){
			a++;
			if(a==1){
			currentImg=heroUpImg[1];
			System.out.println("����ת");}
			else if(a%2==0){
				currentImg=heroUpImg[0];
				System.out.println("���ҽ�");}
			else{currentImg=heroUpImg[2];
			    System.out.println("�����");}
			y=y-5;
		}
		if(action==DOWN){
			b++;
			if(b==1){
			    currentImg=heroDownImg[1];
			    System.out.println("����ת");}
			else if(b%2==0){
				currentImg=heroDownImg[0];
				System.out.println("���ҽ�");}
			else{currentImg=heroDownImg[2];
			    System.out.println("�����");}
			y=y+5;
		}
		repaint();
    }
}