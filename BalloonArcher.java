import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;

class BalloonArcher implements ActionListener
{
	JFrame fr;
	
	//JPanel p;
	JButton shoot,restart;
	JLabel jl,jl1,jl2,jl3,jarrow,jleft;
	int x=600,y=600,a=680,b=750,c=740,d=650,z=60;
	ImageIcon archerIcon,balloon1,balloon2,balloon3,arrow,blast;
	Timer tm,tm2,tm3,tm4;
	int flag2=0,flag3=0,flag1=0,n=5,xy=6;
	JOptionPane jop;
	
	public BalloonArcher()
	{
		fr = new JFrame("ARROWMAN");
		fr.getContentPane().setBackground(Color.white);
		//p= new JPanel();
		
		balloon1 = new ImageIcon("balloonx.jpg");
		jl=new JLabel(balloon1);
				
		balloon2 = new ImageIcon("balloonx.jpg");
		jl2=new JLabel(balloon2);
		blast = new ImageIcon("blast.jpg");
		
		arrow = new ImageIcon("arrow.jpg");
		jarrow = new JLabel(arrow);		
				
		balloon3 = new ImageIcon("balloonx.jpg");
		jl3=new JLabel(balloon3);

		archerIcon = new ImageIcon("archerimg.png");
		jl1=new JLabel(archerIcon);

		jleft = new JLabel("ATTEMPTS LEFT: "+n);		

		shoot = new JButton("SHOOT");
		
		shoot.addActionListener(this);
		
		restart = new JButton("RESTART");
		restart.addActionListener(this);		

		fr.setLayout(null);
		jl1.setBounds(60,60,70,126);
		shoot.setBounds(60,350,80,30);
		restart.setBounds(60,400,90,30);
		jl.setBounds(600,600,61,83);
		jl2.setBounds(680,650,61,83);
		jl3.setBounds(740,750,61,83);	
		jarrow.setBounds(60,90,60,29);
		jleft.setBounds(60,500,200,30);
		//p.setLayout(new GridLayout(30,30));
		fr.add(jl);
		fr.add(jl2);
		fr.add(jl3);
		fr.add(shoot);
		fr.add(restart);
		fr.add(jl1);
		fr.add(jarrow);
		fr.add(jleft);
		tm=new Timer(150,new ActionListener() {
				public void actionPerformed(ActionEvent ac)
				{	if(flag1==0)
					{
					jl.setBounds(x,y,61,83);
					y=y-30;  }

					if(flag1==1){
					y=y+30;
					jl.setBounds(x,y,61,83);  
							if(y>600)
							tm.stop();  }
					if(y<0)
						y=600;  
					int px=(jl.getX());
					int qy=(jl.getY());
					int x1=(jarrow.getX());
					int y1=(jarrow.getY());
	
					if(qy<(y1+29) && (qy+83)>y1)
					{
						if((x1+60)>px && x1<(px+61))
						{
							jl.setIcon(blast);
							flag1=1;
							if(flag1==1)
								if(flag2==1)
									if(flag3==1)
										JOptionPane.showMessageDialog(fr,"YOU WON!!");
						}
						
						
					}	
			
				}});
		
		tm2=new Timer(150,new ActionListener() {
				public void actionPerformed(ActionEvent ac)
				{
					if(flag2==0)
					{
					jl2.setBounds(a,b,61,83);
						b=b-20;}
					if(flag2==1)
					{
						b=b+20;
						jl2.setBounds(a,b,61,83);	
						if(b>600)
							tm2.stop();		
					}	
					if(b<0)
						b=750;
					int px=(jl2.getX());
					int qy=(jl2.getY());
					int x1=(jarrow.getX());
					int y1=(jarrow.getY());
	
					if(qy<(y1+29) && (qy+83)>y1)
					{
						if((x1+60)>px && x1<(px+61))
						{
							jl2.setIcon(blast);
							flag2=1;
							if(flag1==1)
								if(flag2==1)
									if(flag3==1)
										JOptionPane.showMessageDialog(fr,"YOU WON!!");				
		
						}
						
						
					}
				}});
		tm3=new Timer(150,new ActionListener() {
				public void actionPerformed(ActionEvent ac)
				{
					if(flag3==0){
					jl3.setBounds(c,d,61,83);
					d=d-40;}
					if(d<0)
						d=650;

					if(flag3==1)
					{
						d=d+40;
						jl3.setBounds(c,d,61,83);
						if(d>600)
							tm3.stop();		
					}	
					int px=(jl3.getX());
					int qy=(jl3.getY());
					int x1=(jarrow.getX());
					int y1=(jarrow.getY());
					if(qy<(y1+29) && (qy+83)>y1)
					{
						if((x1+60)>px && x1<(px+61))
						{
							jl3.setIcon(blast);
							flag3=1;
							if(flag1==1)
								if(flag2==1)
									if(flag3==1)
										JOptionPane.showMessageDialog(fr,"YOU WON!!");			
			
						}
						
						
					}	
				}});
	
		tm4=new Timer(20,new ActionListener() {
				public void actionPerformed(ActionEvent ac)
				{
					
					jarrow.setBounds(z,90,60,29);
					z=z+20;
					if(z>1500){tm4.stop();
						z=90;
					if(xy!=0){
						n--;
						xy--;}
					jleft.setText("ATTEMPTS LEFT: "+n);
						if((n-1)<0){
						if(flag1!=1 || flag2!=1 || flag3!=1)
							JOptionPane.showMessageDialog(fr,"GAME OVER!!YOU LOST");							
						tm4.stop();
						tm.stop();
						tm2.stop();
						tm3.stop();}
				}
						
				}});
										
		
		tm.start();
		tm2.start();
		tm3.start();	
		
		fr.setSize(900,900);
		fr.setVisible(true);		

	}

	public void actionPerformed(ActionEvent act)
	{
		if(act.getSource()==shoot)
		{
			
			tm4.start();
			
		}
		
		if(act.getSource()==restart)
		{
			n=5;xy=6;
			flag1=0;
			flag2=0;
			flag3=0;
			jl.setIcon(balloon1);
			jl2.setIcon(balloon2);
			jl3.setIcon(balloon3);
			jleft.setText("ATTEMPTS LEFT: "+n);
			tm3.start();
			tm2.start();
			tm.start();
		
		}
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	
	public static void main(String[] srgs)
	{
		new BalloonArcher();

	}

}