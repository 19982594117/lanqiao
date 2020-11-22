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
	Image heroImg[][]= new Image[4][3];
	/*
	Image heroDownImg[]=new Image[3];
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	*/
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");//0Ϊ��1Ϊ�ң�2Ϊ�ϣ�3Ϊ��
			}
			}
            /*
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
            ��*/


            /*
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			��*/


            /*
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			��*/
			

            /*
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			��*/
			
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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			e++;
			if(e==1){
				currentImg=heroImg[0][0];
				System.out.println("����ת");}
			else if(e%2==0){
				currentImg=heroImg[0][1];
				System.out.println("���ҽ�");}
			else{currentImg=heroImg[0][2];
				System.out.println("�����");}
			x=x-5;
			}
		if(action==RIGHT){
			t++;
			if(t==1){
				currentImg=heroImg[1][1];
				System.out.println("����ת");}
			else if(t%2==0){
				currentImg=heroImg[1][2];
				System.out.println("���ҽ�");}
			else{currentImg=heroImg[1][0];
			    System.out.println("�����");}
			x=x+5;
		}
		if(action==UP){
			a++;
			if(a==1){
			currentImg=heroImg[2][2];
			System.out.println("����ת");}
			else if(a%2==0){
				currentImg=heroImg[2][0];
				System.out.println("���ҽ�");}
			else{currentImg=heroImg[2][1];
			    System.out.println("�����");}
			y=y-5;
		}
		if(action==DOWN){
			b++;
			if(b==1){
			    currentImg=heroImg[3][1];
			    System.out.println("����ת");}
			else if(b%2==0){
				currentImg=heroImg[3][0];
				System.out.println("���ҽ�");}
			else{currentImg=heroImg[3][2];
			    System.out.println("�����");}
			y=y+5;
		}
		repaint();
    }
}