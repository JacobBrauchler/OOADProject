package com.ooadproject.kja.checkers.views;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.models.*;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

/* JFrame is a subclass of a Java Container */
public class GameView extends JFrame {
  Container gameViewContainer;
  int gameViewWidth;
  int gameViewHeight;
  private Board checkersBoard;
  /* This constant defines how much of the users screen we want our game view to take up */
  private final double ratioOfViewSize = .85;
  private static final Color mainGreenColor = new Color(136,217,89);
  private static BoardView boardView;
  public GameView(Board checkersBoard) {
    this.checkersBoard = checkersBoard;
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      // TODO handle me
    }
    /* Every JFrame has a Container associated with it. This container is actually a JRootPane which manages the contentPane for this frame. This container is what we add other AWT/Swing components to. These elements are stacked in a front-to-back order. If no index is specified when adding a component to this container, it gets added to the end of the list (thus the bottom of the stacking order) */
    gameViewContainer = getContentPane();

    /* Set the background of our entire frame to black */
    gameViewContainer.setBackground(Color.black);
    gameViewContainer.setLayout(new BorderLayout());
    setTitle("Checkers Palooza");


    /* Get the dimensions of the users screen */
    int screenWidth = GenHelper.GetScreenWorkingWidth();
    int screenHeight = GenHelper.GetScreenWorkingHeight();

    /* Set our gameViews size based off of the dimensions of the users screen so that we are consistently filling the screen with our game regardless of how big/small the users screen is */
    gameViewWidth = (int)(screenWidth*ratioOfViewSize);
    gameViewHeight = (int)(screenHeight*ratioOfViewSize);

    setSize((gameViewWidth), (gameViewHeight));    
    /* This will center our JFrame onscreen */
    setLocationRelativeTo(null);

    /* This tells the program that if the user clicks the exit button, the entire java program exits. We want this because without this GameView Frame, our application is useless and has no need to continue working */
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    SidePanel sidePanel = new SidePanel();
    gameViewContainer.add(sidePanel, BorderLayout.LINE_END);
    boardView = new BoardView(checkersBoard, gameViewWidth, gameViewHeight);

    gameViewContainer.add(boardView, BorderLayout.CENTER);

    JLabel gameTitle = new JLabel("Welcome To Checkers Palooza");
    gameTitle.setFont(new Font("Herculanum", Font.PLAIN, 45));
    gameTitle.setForeground(mainGreenColor);
    gameTitle.setBorder( new EmptyBorder( 0, 10, 0, 0 ) ); 
    gameTitle.setHorizontalAlignment(JLabel.CENTER);
    gameTitle.setVerticalAlignment(JLabel.CENTER);
    add(gameTitle,BorderLayout.PAGE_START);
    setVisible(true);
  }

  public void reDrawBoard(Board checkersBoard)
  {
    //boardView.repaint();
    boardView = new BoardView(checkersBoard, gameViewWidth, gameViewHeight);
    gameViewContainer.add(boardView, BorderLayout.CENTER);
    //revalidate();
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paint(g);
  }

}
