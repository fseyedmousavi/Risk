package risk;

import java.awt.*;
import javax.swing.*;

public class ThreePlayersGame extends Game {

    boolean won = false;
    ImageIcon image = new ImageIcon();
    Image temp;

    public void init() {
        players = new Player[3];
        p1.setAddSoldier(25);
        p2.setAddSoldier(25);
        p3.setAddSoldier(25);
        p1.setStateNo(0);//9
        p2.setStateNo(0);//10
        p3.setStateNo(0);//10
        p1.setAddState(9);
        p2.setAddState(10);
        p3.setAddState(10);
        p1.setNumber(1);
        p2.setNumber(2);
        p3.setNumber(3);
        p1.setPicture("img/green.jpg");
        p2.setPicture("img/red.jpg");
        p3.setPicture("img/blue.jpg");
        p1.setIcon("img/iconGreen.png");
        p2.setIcon("img/iconRed.png");
        p3.setIcon("img/iconBlue.png");
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        int width = (int) screenSize.getWidth();
        makeContinents();
        stateSpreader(3);
        map.drawMap(frame, screenSize.width, screenSize.height);
        setStatesForButtons();
        firstTurn(3);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        image = new ImageIcon("img/sea.jpg");
        temp = image.getImage().getScaledInstance(780, 490, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JLabel back = new JLabel(image);
        back.setBounds(200, 60, 780, 490);
        //start setting homeIcon **********************************************
        image = new ImageIcon("img/HomeIcon.png");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JButton homeButton = new JButton(image);
        homeButton.addActionListener((e) -> {
            frame.setVisible(false);
            frame.removeAll();
            GUI openMenu = new GUI();
            openMenu.init();
        });
        homeButton.setBounds(width - 50, 0, 50, 50);
        //homeIcon set
        //start setting players list ******************************************
        image = new ImageIcon("img/greenCrown.jpg");
        temp = image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        p = new JPanel();
        crowns = new JLabel[3];
        p.setBounds(width - 150, 50, 150, 240);
        crowns[0] = new JLabel("Player 1");
        crowns[0].setForeground(Color.white);
        crowns[0].setIcon(image);
        crowns[0].setName("green");
        p.add(crowns[0]);
        image = new ImageIcon("img/redCrown.jpg");
        temp = image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        crowns[1] = new JLabel("Player 2");
        crowns[1].setForeground(Color.white);
        crowns[1].setIcon(image);
        crowns[1].setName("red");
        p.add(crowns[1]);
        image = new ImageIcon("img/blueCrown.jpg");
        temp = image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        crowns[2] = new JLabel("Player 3");
        crowns[2].setForeground(Color.white);
        crowns[2].setIcon(image);
        crowns[2].setName("blue");
        p.add(crowns[2]);
        p.setBackground(Color.black);
        //players list set
        //*********************************************************************        
        frame.add(p);
        frame.add(homeButton);
        frame.add(back);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
