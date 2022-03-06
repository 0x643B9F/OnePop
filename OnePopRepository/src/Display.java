import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Display().setVisible(true);
            }
        });
	}
	
    private JSplitPane splitPane = new JSplitPane();  // split the window in top and bottom
    private JSplitPane bottomSplitPane = new JSplitPane(); //Split window from side to side
    private JSplitPane middleSP = new JSplitPane();
    private JPanel topPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JButton searchButton = new JButton("Search");
    private JPanel input = new JPanel();
    private JTextArea mainDisplay = new JTextArea();
    private JScrollPane mainScroll = new JScrollPane();
    private JTextArea searchBar = new JTextArea();
    private JPanel searchPanel = new JPanel();
    private JPanel leftPanel = new JPanel();

	public Display() {
		setTitle("One Pop Repository");
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		getContentPane().setLayout(new GridLayout());
		
		add(splitPane);
		splitPane.setDividerLocation(150);  
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);
		splitPane.setTopComponent(topPanel);
		splitPane.setBottomComponent(bottomSplitPane);
		
		bottomSplitPane.setDividerLocation(200);
		bottomSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		bottomSplitPane.setEnabled(false);
		bottomSplitPane.setLeftComponent(leftPanel);
		bottomSplitPane.setRightComponent(middleSP);
		
		middleSP.setDividerLocation(35);
		middleSP.setOrientation(JSplitPane.VERTICAL_SPLIT);
		middleSP.setEnabled(false);
		middleSP.setTopComponent(searchPanel);
		searchBar.setSize(80, 25);
		
		searchPanel.setLayout(new GridLayout());
		searchPanel.add(searchBar);
		searchPanel.add(searchButton);
		//searchPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		
		middleSP.setBottomComponent(mainScroll);
		mainScroll.setViewportView(mainDisplay);
		mainDisplay.setEditable(false);
		
		
		
		
		
		
		
//		rightPanel.add(searchBar);
//		rightPanel.add(searchButton);
//		rightPanel.add(mainDisplay); 
		
		pack();
	}

}
