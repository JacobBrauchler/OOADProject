package com.ooadproject.kja.checkers.views;
import com.ooadproject.kja.checkers.utilities.*;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

/* JFrame is a subclass of a Java Container */
public class GameView extends JFrame {
  /* This constant defines how much of the users screen we want our game view to take up */
  private final double ratioOfViewSize = .85;
  public GameView() {
    /* Every JFrame has a Container associated with it. This container is actually a JRootPane which manages the contentPane for this frame. This container is what we add other AWT/Swing components to. These elements are stacked in a front-to-back order. If no index is specified when adding a component to this container, it gets added to the end of the list (thus the bottom of the stacking order) */
    Container gameViewContainer = getContentPane();

    /* Set the background of our entire frame to black */
    gameViewContainer.setBackground(Color.black);
    gameViewContainer.setLayout(new BorderLayout());
    setTitle("Checkers Palooza");


    /* Get the dimensions of the users screen */
    int screenWidth = GenHelper.GetScreenWorkingWidth();
    int screenHeight = GenHelper.GetScreenWorkingHeight();

    /* Set our gameViews size based off of the dimensions of the users screen so that we are consistently filling the screen with our game regardless of how big/small the users screen is */
    int gameViewWidth = (int)(screenWidth*ratioOfViewSize);
    int gameViewHeight = (int)(screenHeight*ratioOfViewSize);

    setSize((gameViewWidth), (gameViewHeight));    
    /* This will center our JFrame onscreen */
    setLocationRelativeTo(null);

    /* This tells the program that if the user clicks the exit button, the entire java program exits. We want this because without this GameView Frame, our application is useless and has no need to continue working */
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SidePanel sidePanel = new SidePanel();
    gameViewContainer.add(sidePannel, BorderLayout.LINE_END);
    BoardView boardView = new BoardView();
    gameViewContainer.add(boardView, BorderLayout.CENTER);


    setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);
    g.drawString("Hello", 200, 50);
  }

}
