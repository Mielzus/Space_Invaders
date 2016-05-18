import java.lang.Math;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PixelInvaders extends JPanel implements ActionListener, KeyListener{	
	Timer tm = new Timer(5, this);
	Random random = new Random();
	public static JFrame jf = new JFrame();
	static int winX = 1024, winY = 720;
	int winCenter = winX/2-25, offset = 60;
	int A1X = winCenter-(5*offset), A2X = winCenter-(4*offset), A3X = winCenter-(3*offset), A4X = winCenter-(2*offset), A5X = winCenter-(offset), A6X = winCenter;
	int A7X = winCenter+(offset), A8X = winCenter+(2*offset), A9X = winCenter+(3*offset), A10X = winCenter+(4*offset), A11X = winCenter+(5*offset);
	int row1Y = 110, row2Y = row1Y+offset, row3Y = row2Y+offset, row4Y = row3Y+offset, row5Y = row4Y+offset;
	int alienX = winCenter-(5*offset), alienY = 110, original = winCenter-(5*offset);
	int x = winX/2-100, y = winY-80;
	int w1 = 20, h1 = 20, w2 = 30, h2 = 30, w3 = 40, h3 = 40, velX = 0;
	int boxVelX = 1, ufoX = winCenter, ufoY = 57, velUFO = 2, alien = 1, count = 0, count_2 = 0, count_3 = 0, count_4 = 0;
	int life = 3, score = 0, rowTotal = 5, alienTotal = 55, lifeX = 790, lifeY = 25, s = 0;
	boolean laser = false, laser1 = false, laser2 = false, laser3 = false, collided = false, drawUFO = true;
	int laserVelY = 12, laserVelocity = 6, bulletCount = 0, laserX, laserY, laserX1, laserY1, laserX2, laserY2, laserX3, laserY3;
	int shelter1 = 0, shelter2 = 0, shelter3 = 0, shelter4 = 0;
	private ImageIcon UFO, shelter, bullet;
	int choice;
	
	ImageIcon shooter = new ImageIcon(this.getClass().getResource("images\\cannon\\laserCannon.png")); 
	ImageIcon Alien1; boolean drawAlien1 = true; boolean drawShelter1 = true;
	ImageIcon Alien2; boolean drawAlien2 = true; boolean drawShelter2 = true;
	ImageIcon Alien3; boolean drawAlien3 = true; boolean drawShelter3 = true;
	ImageIcon Alien4; boolean drawAlien4 = true; boolean drawShelter4 = true;
	ImageIcon Alien5; boolean drawAlien5 = true;
	ImageIcon Alien6; boolean drawAlien6 = true;
	ImageIcon Alien7; boolean drawAlien7 = true;
	ImageIcon Alien8; boolean drawAlien8 = true;
	ImageIcon Alien9; boolean drawAlien9 = true;
	ImageIcon Alien10; boolean drawAlien10 = true;
	ImageIcon Alien11; boolean drawAlien11 = true;
	ImageIcon Alien12; boolean drawAlien12 = true;
	ImageIcon Alien13; boolean drawAlien13 = true;
	ImageIcon Alien14; boolean drawAlien14 = true;
	ImageIcon Alien15; boolean drawAlien15 = true;
	ImageIcon Alien16; boolean drawAlien16 = true;
	ImageIcon Alien17; boolean drawAlien17 = true;
	ImageIcon Alien18; boolean drawAlien18 = true;
	ImageIcon Alien19; boolean drawAlien19 = true;
	ImageIcon Alien20; boolean drawAlien20 = true;
	ImageIcon Alien21; boolean drawAlien21 = true;
	ImageIcon Alien22; boolean drawAlien22 = true;
	ImageIcon Alien23; boolean drawAlien23 = true;
	ImageIcon Alien24; boolean drawAlien24 = true; 
	ImageIcon Alien25; boolean drawAlien25 = true;
	ImageIcon Alien26; boolean drawAlien26 = true;
	ImageIcon Alien27; boolean drawAlien27 = true;
	ImageIcon Alien28; boolean drawAlien28 = true;
	ImageIcon Alien29; boolean drawAlien29 = true;
	ImageIcon Alien30; boolean drawAlien30 = true;
	ImageIcon Alien31; boolean drawAlien31 = true;
	ImageIcon Alien32; boolean drawAlien32 = true;
	ImageIcon Alien33; boolean drawAlien33 = true;
	ImageIcon Alien34; boolean drawAlien34 = true;
	ImageIcon Alien35; boolean drawAlien35 = true;
	ImageIcon Alien36; boolean drawAlien36 = true;
	ImageIcon Alien37; boolean drawAlien37 = true;
	ImageIcon Alien38; boolean drawAlien38 = true;
	ImageIcon Alien39; boolean drawAlien39 = true;
	ImageIcon Alien40; boolean drawAlien40 = true;
	ImageIcon Alien41; boolean drawAlien41 = true;
	ImageIcon Alien42; boolean drawAlien42 = true;
	ImageIcon Alien43; boolean drawAlien43 = true;
	ImageIcon Alien44; boolean drawAlien44 = true;
	ImageIcon Alien45; boolean drawAlien45 = true;
	ImageIcon Alien46; boolean drawAlien46 = true;
	ImageIcon Alien47; boolean drawAlien47 = true;
	ImageIcon Alien48; boolean drawAlien48 = true;
	ImageIcon Alien49; boolean drawAlien49 = true;
	ImageIcon Alien50; boolean drawAlien50 = true;
	ImageIcon Alien51; boolean drawAlien51 = true;
	ImageIcon Alien52; boolean drawAlien52 = true;
	ImageIcon Alien53; boolean drawAlien53 = true; 
	ImageIcon Alien54; boolean drawAlien54 = true;
	ImageIcon Alien55; boolean drawAlien55 = true;
                    
	public PixelInvaders(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public int randomRow(){
			int row = random.nextInt(5)+1;
			if(row == 1){
				choice = row1Y;
			}
			else if(row == 2){
				choice = row2Y;
			}
			else if(row == 3){
				choice = row3Y;
			}
			else if(row == 4){
				choice = row4Y;
			}
			else if(row == 5){
				choice = row5Y;
			}
			else{}
		return choice;
	}
	
	public int randomColumn(){
		int column = random.nextInt(11)+1;
		if(column == 1){
			choice = A1X;
		}
		else if(column == 2){
			choice = A2X;
		}
		else if(column == 3){
			choice = A3X;
		}
		else if(column == 4){
			choice = A4X;
		}
		else if(column == 5){
			choice = A5X;
		}
		else if(column == 6){
			choice = A6X;
		}
		else if(column == 7){
			choice = A7X;
		}
		else if(column == 8){
			choice = A8X;
		}
		else if(column == 9){
			choice = A9X;
		}
		else if(column == 10){
			choice = A10X;
		}
		else if(column == 11){
			choice = A11X;
		}
		return choice;
	}
	
	public ImageIcon shelterStatus(int i){
		if(i == 1){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter1.png"));
		}
		else if(i == 2){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter2.png"));
		}
		else if(i == 3){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter3.png"));
		}
		else if(i == 4){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter4.png"));
		}
		else if(i == 5){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter5.png"));
		}
		else if(i == 6){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter6.png"));
		}
		else if(i == 7){
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter7.png"));
		}
		else{
			shelter = new ImageIcon(this.getClass().getResource("images\\shelter\\shelter.png"));
		}
		return shelter;
	}
        
	public void drawLife(Graphics g, int input){
		offset = 0;
		for(int i = 0; i < input; i++){
			g.setColor(Color.GREEN);
			g.fillRect(lifeX+25+offset,lifeY,5,5);
			g.fillRect(lifeX+20+offset,lifeY+5,15,10);
			g.fillRect(lifeX+5+offset,lifeY+15,45,5);
			g.fillRect(lifeX+offset, lifeY+20, 55, 15);
			offset += 60;
		}
	}
        
        @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            //createPosition();

            bullet = new ImageIcon(this.getClass().getResource("images\\cannon\\laser.png"));
            UFO = new ImageIcon(this.getClass().getResource("images\\aliens\\UFO.png"));

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, (int)jf.getContentPane().getBounds().getWidth(), (int)jf.getContentPane().getBounds().getHeight());
                        
            if(alien == 1){
                Alien1 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien2 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien3 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien4 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien5 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien6 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien7 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien8 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien9 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien10 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien11 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader.png"));
                Alien12 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien13 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien14 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien15 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien16 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien17 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien18 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien19 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien20 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien21 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien22 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien23 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien24 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien25 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien26 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien27 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien28 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien29 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien30 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien31 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien32 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien33 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader.png"));
                Alien34 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien35 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien36 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien37 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien38 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien39 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien40 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien41 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien42 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien43 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien44 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien45 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien46 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien47 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien48 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien49 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien50 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien51 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien52 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien53 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien54 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
                Alien55 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader.png"));
            }
            else if(alien == -1){
                Alien1 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien2 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien3 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien4 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien5 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien6 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien7 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien8 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien9 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien10 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien11 = new ImageIcon(this.getClass().getResource("images\\aliens\\smallInvader_2.png"));
                Alien12 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien13 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien14 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien15 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien16 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien17 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien18 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien19 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien20 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien21 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien22 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien23 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien24 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien25 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien26 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien27 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien28 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien29 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien30 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien31 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien32 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien33 = new ImageIcon(this.getClass().getResource("images\\aliens\\mediumInvader_2.png"));
                Alien34 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien35 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien36 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien37 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien38 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien39 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien40 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien41 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien42 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien43 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien44 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien45 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien46 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien47 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien48 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien49 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien50 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien51 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien52 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien53 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien54 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
                Alien55 = new ImageIcon(this.getClass().getResource("images\\aliens\\largeInvader_2.png"));
            }
            
            //Row 1
            if(drawAlien1 == true){
                if((Math.abs((A1X+(int)(Alien1.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien1.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien1.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien1.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien1 == true){
                    drawAlien1 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien1.paintIcon(this, g, A1X, row1Y);}
            }
            if(drawAlien2 == true){
                if((Math.abs((A2X+(int)(Alien2.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien2.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien2.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien2.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien2 == true){
                    drawAlien2 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien2.paintIcon(this, g, A2X, row1Y);}
            }
            if(drawAlien3 == true){
                if((Math.abs((A3X+(int)(Alien3.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien3.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien3.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien3.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien3 == true){
                    drawAlien3 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien3.paintIcon(this, g, A3X, row1Y);}
            }
            if(drawAlien4 == true){
                if((Math.abs((A4X+(int)(Alien4.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien4.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien4.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien4.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien4 == true){
                    drawAlien4 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien4.paintIcon(this, g, A4X, row1Y);}
            }
            if(drawAlien5 == true){
                if((Math.abs((A5X+(int)(Alien5.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien5.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien5.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien5.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien5 == true){
                    drawAlien5 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien5.paintIcon(this, g, A5X, row1Y);}
            }
            if(drawAlien6 == true){
                if((Math.abs((A6X+(int)(Alien6.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien6.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien6.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien6.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien6 == true){
                    drawAlien6 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien6.paintIcon(this, g, A6X, row1Y);}
            }
            if(drawAlien7 == true){
                if((Math.abs((A7X+(int)(Alien7.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien7.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien7.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien7.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien7 == true){
                    drawAlien7 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien7.paintIcon(this, g, A7X, row1Y);}
            }
            if(drawAlien8 == true){
                if((Math.abs((A8X+(int)(Alien8.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien8.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien8.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien8.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien8 == true){
                    drawAlien8 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien8.paintIcon(this, g, A8X, row1Y);}
            }
            if(drawAlien9 == true){
                if((Math.abs((A9X+(int)(Alien9.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien9.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien9.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien9.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien9 == true){
                    drawAlien9 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien9.paintIcon(this, g, A9X, row1Y);}
            }
            if(drawAlien10 == true){
                if((Math.abs((A10X+(int)(Alien10.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien10.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien10.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien10.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien10 == true){
                    drawAlien10 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien10.paintIcon(this, g, A10X, row1Y);}
            }
            if(drawAlien11 == true){
                if((Math.abs((A11X+(int)(Alien11.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien11.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row1Y+(Alien11.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien11.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien11 == true){
                    drawAlien11 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 10;
                }
                else{Alien11.paintIcon(this, g, A11X, row1Y);}
            }
            //Row 2
            if(drawAlien12 == true){
                if((Math.abs((A1X+(int)(Alien12.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien12.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien12.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien12.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien12 == true){
                    drawAlien12 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien12.paintIcon(this, g, A1X, row2Y);}
            }
            if(drawAlien13 == true){
                if((Math.abs((A2X+(int)(Alien13.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien13.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien13.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien13.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien13 == true){
                    drawAlien13 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien13.paintIcon(this, g, A2X, row2Y);}
            }
            if(drawAlien14 == true){
                if((Math.abs((A3X+(int)(Alien14.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien14.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien14.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien14.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien14 == true){
                    drawAlien14 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien14.paintIcon(this, g, A3X, row2Y);}
            }
            if(drawAlien15 == true){
                if((Math.abs((A4X+(int)(Alien15.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien15.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien15.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien15.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien15 == true){
                    drawAlien15 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien15.paintIcon(this, g, A4X, row2Y);}
            }
            if(drawAlien16 == true){
                if((Math.abs((A5X+(int)(Alien16.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien16.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien16.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien16.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien16 == true){
                    drawAlien16 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien16.paintIcon(this, g, A5X, row2Y);}
            }
            if(drawAlien17 == true){
                if((Math.abs((A6X+(int)(Alien17.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien17.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien17.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien17.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien17 == true){
                    drawAlien17 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien17.paintIcon(this, g, A6X, row2Y);}
            }
            if(drawAlien18 == true){
                if((Math.abs((A7X+(int)(Alien18.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien18.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien18.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien18.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien18 == true){
                    drawAlien18 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien18.paintIcon(this, g, A7X, row2Y);}
            }
            if(drawAlien19 == true){
                if((Math.abs((A8X+(int)(Alien19.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien19.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien19.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien19.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien19 == true){
                    drawAlien19 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien19.paintIcon(this, g, A8X, row2Y);}
            }
            if(drawAlien20 == true){
                if((Math.abs((A9X+(int)(Alien20.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien20.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien20.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien20.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien20 == true){
                    drawAlien20 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien20.paintIcon(this, g, A9X, row2Y);}
            }
            if(drawAlien21 == true){
                if((Math.abs((A10X+(int)(Alien21.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien21.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien21.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien21.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien21 == true){
                    drawAlien21 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien21.paintIcon(this, g, A10X, row2Y);}
            }
            if(drawAlien22 == true){
                if((Math.abs((A11X+(int)(Alien22.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien22.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row2Y+(Alien22.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien22.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien22 == true){
                    drawAlien22 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien22.paintIcon(this, g, A11X, row2Y);}
            }
            //Row 3
            if(drawAlien23 == true){
                if((Math.abs((A1X+(int)(Alien23.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien23.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien23.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien23.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien23 == true){
                    drawAlien23 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien23.paintIcon(this, g, A1X, row3Y);}
            }
            if(drawAlien24 == true){
                if((Math.abs((A2X+(int)(Alien24.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien24.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien24.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien24.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien24 == true){
                    drawAlien24 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien24.paintIcon(this, g, A2X, row3Y);}
            }
            if(drawAlien25 == true){
                if((Math.abs((A3X+(int)(Alien25.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien25.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien25.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien25.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien25 == true){
                    drawAlien25 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien25.paintIcon(this, g, A3X, row3Y);}
            }
            if(drawAlien26 == true){
                if((Math.abs((A4X+(int)(Alien26.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien26.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien26.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien26.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien26 == true){
                    drawAlien26 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien26.paintIcon(this, g, A4X, row2Y);}
            }
            if(drawAlien27 == true){
                if((Math.abs((A5X+(int)(Alien27.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien27.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien27.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien27.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien27 == true){
                    drawAlien27 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien27.paintIcon(this, g, A5X, row3Y);}
            }
            if(drawAlien28 == true){
                if((Math.abs((A6X+(int)(Alien28.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien28.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien28.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien28.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien28 == true){
                    drawAlien28 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien28.paintIcon(this, g, A6X, row3Y);}
            }
            if(drawAlien29 == true){
                if((Math.abs((A7X+(int)(Alien29.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien29.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien29.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien29.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien29 == true){
                    drawAlien29 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien29.paintIcon(this, g, A7X, row3Y);}
            }
            if(drawAlien30 == true){
                if((Math.abs((A8X+(int)(Alien30.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien30.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien30.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien30.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien30 == true){
                    drawAlien30 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien30.paintIcon(this, g, A8X, row3Y);}
            }
            if(drawAlien31 == true){
                if((Math.abs((A9X+(int)(Alien31.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien31.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien31.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien31.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien31 == true){
                    drawAlien31 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien31.paintIcon(this, g, A9X, row3Y);}
            }
            if(drawAlien32 == true){
                if((Math.abs((A10X+(int)(Alien32.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien32.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien32.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien32.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien32 == true){
                    drawAlien32 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien32.paintIcon(this, g, A10X, row3Y);}
            }
            if(drawAlien33 == true){
                if((Math.abs((A11X+(int)(Alien33.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien33.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row3Y+(Alien33.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien33.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien33 == true){
                    drawAlien33 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 30;
                }
                else{Alien33.paintIcon(this, g, A11X, row3Y);}
            }
            //Row 4
            if(drawAlien34 == true){
                if((Math.abs((A1X+(int)(Alien34.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien34.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien34.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien34.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien34 == true){
                    drawAlien34 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien34.paintIcon(this, g, A1X, row4Y);}
            }
            if(drawAlien35 == true){
                if((Math.abs((A2X+(int)(Alien35.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien35.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien35.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien35.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien35 == true){
                    drawAlien35 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien35.paintIcon(this, g, A2X, row4Y);}
            }
            if(drawAlien36 == true){
                if((Math.abs((A3X+(int)(Alien36.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien36.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien36.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien36.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien36 == true){
                    drawAlien36 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien36.paintIcon(this, g, A3X, row4Y);}
            }
            if(drawAlien37 == true){
                if((Math.abs((A4X+(int)(Alien37.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien37.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien37.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien37.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien37 == true){
                    drawAlien37 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien37.paintIcon(this, g, A4X, row4Y);}
            }
            if(drawAlien38 == true){
                if((Math.abs((A5X+(int)(Alien38.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien38.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien38.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien38.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien38 == true){
                    drawAlien38 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien38.paintIcon(this, g, A5X, row4Y);}
            }
            if(drawAlien39 == true){
                if((Math.abs((A6X+(int)(Alien39.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien39.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien39.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien39.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien39 == true){
                    drawAlien39 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien39.paintIcon(this, g, A6X, row4Y);}
            }
            if(drawAlien40 == true){
                if((Math.abs((A7X+(int)(Alien40.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien40.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien40.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien40.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien40 == true){
                    drawAlien40 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien40.paintIcon(this, g, A7X, row4Y);}
            }
            if(drawAlien41 == true){
                if((Math.abs((A8X+(int)(Alien41.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien41.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien41.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien41.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien41 == true){
                    drawAlien41 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien41.paintIcon(this, g, A8X, row4Y);}
            }
            if(drawAlien42 == true){
                if((Math.abs((A9X+(int)(Alien42.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien42.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien42.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien42.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien42 == true){
                    drawAlien42 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien42.paintIcon(this, g, A9X, row4Y);}
            }
            if(drawAlien43 == true){
                if((Math.abs((A10X+(int)(Alien43.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien43.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien43.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien43.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien43 == true){
                    drawAlien43 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien43.paintIcon(this, g, A10X, row4Y);}
            }
            if(drawAlien44 == true){
                if((Math.abs((A11X+(int)(Alien44.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien44.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row4Y+(Alien44.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien44.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien44 == true){
                    drawAlien44 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien44.paintIcon(this, g, A11X, row4Y);}
            }
            //Row 5
            if(drawAlien45 == true){
                if((Math.abs((A1X+(int)(Alien45.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien45.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien45.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien45.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien45 == true){
                    drawAlien45 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien45.paintIcon(this, g, A1X, row5Y);}
            }
            if(drawAlien46 == true){
                if((Math.abs((A2X+(int)(Alien46.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien46.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien46.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien46.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien46 == true){
                    drawAlien46 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien46.paintIcon(this, g, A2X, row5Y);}                
            }
            if(drawAlien47 == true){
                if((Math.abs((A3X+(int)(Alien47.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien47.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien47.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien47.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien47 == true){
                    drawAlien47 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien47.paintIcon(this, g, A3X, row5Y);}                
            }
            if(drawAlien48 == true){
                if((Math.abs((A4X+(int)(Alien48.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien48.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien48.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien48.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien48 == true){
                    drawAlien48 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien48.paintIcon(this, g, A4X, row5Y);}                
            }
            if(drawAlien49 == true){
                if((Math.abs((A5X+(int)(Alien49.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien49.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien49.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien49.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien49 == true){
                    drawAlien49 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien49.paintIcon(this, g, A5X, row5Y);}                
            }
            if(drawAlien50 == true){
                if((Math.abs((A6X+(int)(Alien50.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien50.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien50.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien50.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien50 == true){
                    drawAlien50 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien50.paintIcon(this, g, A6X, row5Y);}                
            }
            if(drawAlien51 == true){
                if((Math.abs((A7X+(int)(Alien51.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien51.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien51.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien51.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien51 == true){
                    drawAlien51 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien51.paintIcon(this, g, A7X, row5Y);}               
            }
            if(drawAlien52 == true){
                if((Math.abs((A8X+(int)(Alien52.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien52.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien52.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien52.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien52 == true){
                    drawAlien52 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien52.paintIcon(this, g, A8X, row5Y);}                
            }
            if(drawAlien53 == true){
                if((Math.abs((A9X+(int)(Alien53.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien53.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien53.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien53.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien53 == true){
                    drawAlien53 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien53.paintIcon(this, g, A9X, row5Y);}
            }
            if(drawAlien54 == true){
                if((Math.abs((A10X+(int)(Alien54.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien54.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien54.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien54.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien54 == true){
                    drawAlien54 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien54.paintIcon(this, g, A10X, row5Y);}
            }
            if(drawAlien55 == true){
                if((Math.abs((A11X+(int)(Alien55.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (Alien55.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((row5Y+(Alien55.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (Alien55.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawAlien55 == true){
                    drawAlien55 = false; laser = false; bulletCount--; alienTotal--; laserVelY = 0; laserY = -20;
                    score += 20;
                }
                else{Alien55.paintIcon(this, g, A11X, row5Y);}
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("VERDANA", Font.BOLD, 25));
            g.drawString("Score", 50, 55);
            g.drawString(Integer.toString(score), 140, 55);
            g.drawString("Lives", 700, 55);
            /**__Shelter__**/
			shelterStatus(shelter1);
			shelter.paintIcon(this, g, 128, winY+195);
			 if(shelter1 < 8){
                if((Math.abs((128+(int)(shelter.getIconWidth())/2)-(laserX+(bullet.getIconWidth()))) < (shelter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs(((winY-195)+(shelter.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (shelter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawShelter3 == true){
                    laser = false; laserVelY = 0; laserY = -20;
                    shelter1++;
                }
                else{
					shelterStatus(shelter1);
					shelter.paintIcon(this, g, 128, winY-195);
				}
            }
			 /**__Shelter__**/
			 if(shelter2 < 8){
                if((Math.abs((340+(int)(shelter.getIconWidth())/2)-(laserX+(bullet.getIconWidth()))) < (shelter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs(((winY-195)+(shelter.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (shelter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawShelter1 == true){
                    laser = false; laserVelY = 0; laserY = -20;
                    shelter2++;
                }
                else{
					shelterStatus(shelter2);
					shelter.paintIcon(this, g, 340, winY-195);
				}
            }
			 /**__Shelter__**/
			 if(shelter3 < 8){
                if((Math.abs((570+(int)(shelter.getIconWidth())/2)-(laserX+(bullet.getIconWidth()))) < (shelter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs(((winY-195)+(shelter.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (shelter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawShelter3 == true){
                    laser = false; laserVelY = 0; laserY = -20;
                    shelter3++;
                }
                else{
					shelterStatus(shelter3);
					shelter.paintIcon(this, g, 570, winY-195);
				}
            }
			 /**__Shelter__**/
			 if(shelter4 < 8){
                if((Math.abs((800+(int)(shelter.getIconWidth())/2)-(laserX+(bullet.getIconWidth()))) < (shelter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs(((winY-195)+(shelter.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (shelter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawShelter3 == true){
                    laser = false; laserVelY = 0; laserY = -20;
                    shelter4++;
                }
                else{
					shelterStatus(shelter4);
					shelter.paintIcon(this, g, 800, winY-195);
				}
            }

            /**Life 1**/
            if(life == 1){
                drawLife(g,1);
            }
            /**Life 2**/
            else if(life == 2){
                drawLife(g,2);
            }
            /**Life 3**/
            else if(life == 3){
                drawLife(g,3);
            }
            /**Shooter**/
			g.setColor(Color.GREEN);
            g.fillRect(x+25,y,5,5);
            g.fillRect(x+20,y+5,15,10);
            g.fillRect(x+5,y+15,45,5);
            g.fillRect(x, y+20, 55, 15);
            /**UFO**/
            if(drawUFO == true){
                if((Math.abs((ufoX+(int)(UFO.getIconWidth()/2))-(laserX+(bullet.getIconWidth()))) < (UFO.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((ufoY+(UFO.getIconHeight()))-(laserY+(bullet.getIconHeight()))) < (UFO.getIconHeight()/2)+(bullet.getIconHeight()/2)) && drawUFO == true){
                    drawUFO = false; laser = false; bulletCount--;
                    score += random.nextInt(100);
                }
                else{UFO.paintIcon(this, g, ufoX, ufoY);}
            }
            if(laser == true){
                bullet.paintIcon(this, g, laserX-(int)2.5, laserY);
            }
            if(laser1 == true){
                bullet.paintIcon(this, g, laserX1, laserY1);
            }
			if(laser2 == true){
                bullet.paintIcon(this, g, laserX2, laserY2);
            }
			if(laser3 == true){
                bullet.paintIcon(this, g, laserX3, laserY3);
            }
	}
        
        @Override
	public void actionPerformed(ActionEvent e){
		double jfH = jf.getContentPane().getBounds().getHeight();
		double jfW = jf.getContentPane().getBounds().getWidth();
		
		if(x+1 < 1){
			x = 0;
			//velX *= -1;
		}
		if(x+55 > jfW){
			x = (int)jfW-55;
			//velX *= -1;
		}
		else{}
		
		if(A1X < 0){
			boxVelX *= -1;
			row1Y += 30; row2Y += 30; row3Y += 30; row4Y += 30; row5Y += 30;
		}
		if(A11X+50 > jfW){
			boxVelX *= -1;
			row1Y += 30; row2Y += 30; row3Y += 30; row4Y += 30; row5Y += 30;
		}
		if(row5Y+30 > x){
			//System.exit(0);
		}
		
		if(ufoX < -40){
			ufoX = (int)jf.getContentPane().getBounds().getWidth();
			//drawUFO = false;
		}
		else{}
		
		/**if(alienTotal == 0 || life == 0){
			System.exit(0);
		}**/
                
		if(laserY > -20){
                    laserY -= laserVelY;
		}
		if(laserY1 > -20){
                    laserY1 += laserVelocity;
		}
		if(laserY2 < jfH){
                    laserY2 += laserVelocity;
		}
		if(laserY3 < jfH){
                    laserY3 += laserVelocity;
		}
		if(drawUFO == true){
                    ufoX -= velUFO; 
		}
		else{}
		
		if(laser == true && laserY < -20){laser = false;}
		if(laser1 == true && laserY1 > jfH){laser1 = false;}
		if(laser2 == true && laserY2 > jfH){laser2 = false;}
		if(laser3 == true && laserY3 > jfH){laser3 = false;}
		
		 if(laser1 == true){
			if((Math.abs((x+(int)(shooter.getIconWidth()/2))-(laserX1+(bullet.getIconWidth()))) < (shooter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((y+(shooter.getIconHeight()))-(laserY1+(bullet.getIconHeight()))) < (shooter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && laser1 == true){
				laser1 = false;
				life--;
			}
			else{}
		}
		if(laser2 == true){
			if((Math.abs((x+(int)(shooter.getIconWidth()/2))-(laserX1+(bullet.getIconWidth()))) < (shooter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((y+(shooter.getIconHeight()))-(laserY1+(bullet.getIconHeight()))) < (shooter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && laser1 == true){
				laser2 = false;
				life--;
			}
			else{}
		}
		if(laser3 == true){
			if((Math.abs((x+(int)(shooter.getIconWidth()/2))-(laserX3+(bullet.getIconWidth()))) < (shooter.getIconWidth()/2)+(bullet.getIconWidth()/2)) && (Math.abs((y+(shooter.getIconHeight()))-(laserY3+(bullet.getIconHeight()))) < (shooter.getIconHeight()/2)+(bullet.getIconHeight()/2)) && laser3== true){
				laser3 = false;
				life--;
			}
			else{}
		}
		
		count += 1;
		count_2 += 1;
		count_3 += 1;
		count_4 += 1;
		
		if(count % 69 == 0){
			alien *= -1;
		}
            
		if(count_2 % 134 == 0 && laser1 != true){
			if(laser1 == false){
				laser1 = true;
				laserX1 = randomColumn()+32; laserY1 = randomRow()+16;
				bulletCount ++;
			}
			else{}
		}
		
		if(count_3 % 245 == 0 && laser2 != true){
			if(laser2 == false){
				laser2 = true;
				laserX2 = randomColumn()+32; laserY2 = randomRow()+16;
				bulletCount ++;
			}
			else{}
		}
		
		if(count_4 % 27 == 0 && laser3 != true){
			if(laser3 == false){
				laser3 = true;
				laserX3 = randomColumn()+32; laserY3 = randomRow()+16;
				bulletCount ++;
			}
			else{}
		}
		
		else{}
		
		x += velX;
		A1X -= boxVelX;
		A2X -= boxVelX;
		A3X -= boxVelX;
		A4X -= boxVelX;
		A5X -= boxVelX;
		A6X -= boxVelX;
		A7X -= boxVelX;
		A8X -= boxVelX;
		A9X -= boxVelX;
		A10X -= boxVelX;
		A11X -= boxVelX;
		repaint();
	}
	
        @Override
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();

		if(c == KeyEvent.VK_LEFT){
			velX = -3;
		}
		if(c == KeyEvent.VK_RIGHT){
			velX = 3;
		}	
		if(c == KeyEvent.VK_0){
			life = 0;
		}
		if(c == KeyEvent.VK_1){
			life = 1;
		}
		if(c == KeyEvent.VK_2){
			life = 2;
		}
		if(c == KeyEvent.VK_3){
			life = 3;
		}
		if(c == KeyEvent.VK_SPACE){
			if(laser == false){
				laser = true;
				laserX = x+(int)110/4; laserY = y-10; laserVelY = 3;
				bulletCount ++;
			}
			else{}
		}
	}
	
	
        @Override
	public void keyTyped(KeyEvent e){
		//If the block is to move after releasing key then comment out keyReleased section
	}
	
        @Override
	public void keyReleased(KeyEvent e){
		int c = e.getKeyCode();

		if(c == KeyEvent.VK_LEFT){
			velX = 0;
		}
		if(c == KeyEvent.VK_RIGHT){
			velX = 0;
		}
	}
	
	public static void main(String[] args) {
		PixelInvaders t = new PixelInvaders();
		jf.setTitle("Pixel Invaders 2015!");
		jf.setSize(winX,winY);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}
}