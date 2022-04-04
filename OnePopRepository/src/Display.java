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
		Login.getUserNames();
		//App.getAppData();	
		EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Display().setVisible(true);
            }
        });
	}
	
    private JSplitPane splitPane = new JSplitPane();
    private JSplitPane bottomSplitPane = new JSplitPane();
    private JSplitPane middleSP = new JSplitPane();
    
    private JPanel topPanel = new JPanel();
    private JLabel onePopLabel = new JLabel("One Pop");
    private JButton loginButton = new JButton("Login");
    
    private JPanel leftPanel = new JPanel();
    private JButton homePageB = new JButton("Home Page");
    private JButton helpPageB = new JButton("Help Page");
    private JButton loungePageB = new JButton("Lounge Page");
    
    private JTextArea searchBar = new JTextArea();
    private JPanel searchPanel = new JPanel();
    private JButton searchButton = new JButton("Search");
    
    private JPanel mainPanel = new JPanel();
    private JTextArea mainDisplay = new JTextArea();
    private JScrollPane mainScroll = new JScrollPane();
    
    private JPanel loginPanel = new JPanel();
    
    private JLabel uNameLabel = new JLabel("Plese enter user name: ");
    private JTextArea uNameText = new JTextArea();
    
    private JLabel pWordLabel = new JLabel("Please enter password: ");
    private JTextArea pWordText = new JTextArea();
    private JButton enterButton = new JButton("Enter");
    

	public Display() {
		//Creating the window
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
		
		topPanel.setLayout(new FlowLayout());
		topPanel.add(onePopLabel);
		topPanel.add(loginButton);
		
		loginButton.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				middleSP.setBottomComponent(loginPanel);
				loginPanel.add(uNameLabel);
				loginPanel.add(uNameText);
				uNameText.setColumns(80);
				loginPanel.add(pWordLabel);
				loginPanel.add(pWordText);
				pWordText.setColumns(72);
				loginPanel.add(enterButton);
				repaint();
			}
		}));
		
		enterButton.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String uName = uNameText.getText();
				uNameText.setText("");
				
				String pWord = pWordText.getText();
				pWordText.setText("");
				
				boolean login = Login.loginCheck(uName, pWord);
				
				if(login == false) {
					actionPerformed(a);
				} else {
					middleSP.setBottomComponent(mainPanel);
					mainPanel.add(new JLabel("Welcome: " + uName));
					topPanel.remove(loginButton);
					repaint();
				}
				
			}
		}));
		
		bottomSplitPane.setDividerLocation(200);
		bottomSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		bottomSplitPane.setEnabled(false);
		bottomSplitPane.setLeftComponent(leftPanel);
		leftPanel.add(homePageB);
		leftPanel.add(loungePageB);
		leftPanel.add(helpPageB);
		bottomSplitPane.setRightComponent(middleSP);
		
		middleSP.setDividerLocation(35);
		middleSP.setOrientation(JSplitPane.VERTICAL_SPLIT);
		middleSP.setEnabled(false);
		middleSP.setTopComponent(searchPanel);
		searchBar.setSize(80, 25);
		
		searchPanel.setLayout(new FlowLayout());
		searchBar.setBounds(40, 39, 105, 20);
		searchBar.setColumns(40);
		searchPanel.add(searchBar);
		searchPanel.add(searchButton);
		
		middleSP.setBottomComponent(mainPanel);
		mainPanel.add(mainScroll);
		mainScroll.setViewportView(mainDisplay);
		mainDisplay.setEditable(false);
		
		pack();
	}
	
	private void changePage() {
		
	}
	
	private JButton makeLabel(App a) {
		return new JButton(a.displayBasic());
	}
	

}
