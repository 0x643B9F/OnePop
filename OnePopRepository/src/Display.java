import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display extends JFrame {
	
	private JSplitPane splitPane = new JSplitPane();
    private JSplitPane bottomSP = new JSplitPane();
    private JSplitPane middleSP = new JSplitPane();
    
    private JPanel topPanel = new JPanel();
    private JLabel onePopLabel = new JLabel();
    private JButton loginButton = new JButton("    Login    ");
    
    private JPanel leftPanel = new JPanel();
    private JButton homePageB = new JButton("Home Page");
    private JButton helpPageB = new JButton(" Help Page ");
    private JButton loungePageB = new JButton("Lounge Page");
    
    private JTextArea searchBar = new JTextArea();
    private JPanel searchPanel = new JPanel();
    private JButton searchButton = new JButton("Search");
    
    private JPanel mainPanel = new JPanel();
    private JScrollPane mainScroll = new JScrollPane();
    
    private JPanel loginPanel = new JPanel();
    private JPanel helpPanel = new JPanel();
    private JLabel helpPage = new JLabel("<html>Welcome to One Pop Repository's Help Page. 3A's Studio <br/>blahblahblah</html>\", SwingConstants.CENTER");
    
    private JLabel uNameLabel = new JLabel("Plese enter user name: ");
    private JTextArea uNameText = new JTextArea();
    
    private JLabel pWordLabel = new JLabel("Please enter password: ");
    private JTextArea pWordText = new JTextArea();
    private JButton enterButton = new JButton("Enter");
    
    private int j = 0;
	
    public Display() {
		//Creating the window
		setTitle("One Pop Repository");
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		getContentPane().setLayout(new GridLayout());
		
		//Making base pane (Top JPanel and Bottom JSplitPanes)
		add(splitPane);
		splitPane.setDividerLocation(150);  
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);
		splitPane.setTopComponent(topPanel);
		//bottomSplitPane will have Panel on left side and anoth Split Pane on the right
		splitPane.setBottomComponent(bottomSP);
		
		//Creating Top Panel with Picture Label
		topPanel.add(onePopLabel);
		onePopLabel.setIcon(new ImageIcon("C:\\OP.png"));
		
		//Making 2nd layer pane (Left JPanel and Right JSplitPane)
		bottomSP.setDividerLocation(200);
		bottomSP.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		bottomSP.setEnabled(false);
		bottomSP.setLeftComponent(leftPanel);
		
		//Making Home Page Button
		leftPanel.add(homePageB);
//		homePageB.addActionListener((new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				searchButton.a
//			}
//		}));
		
		leftPanel.add(loungePageB);
		
		//Making Help Page Button
		leftPanel.add(helpPageB);
		helpPageB.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				middleSP.setBottomComponent(helpPanel);
				helpPanel.add(helpPage);
				repaint();
			}
		}));
		
		//Making Login Button
		leftPanel.add(loginButton);
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
		//Making "Enter" Button for Login Page
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
		
		//Making 3rd layer SplitPane (Top JPanel and Bottom JPanel)
		bottomSP.setRightComponent(middleSP);
		middleSP.setDividerLocation(35);
		middleSP.setOrientation(JSplitPane.VERTICAL_SPLIT);
		middleSP.setEnabled(false);
		middleSP.setTopComponent(searchPanel);
		searchBar.setSize(80, 25);
		searchBar.setColumns(40);
		
		//Making 
		searchPanel.add(searchBar);
		searchPanel.add(searchButton);
		searchButton.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String searchString = searchBar.getText();
				searchBar.setText("");
				ArrayList<App> apps = Search.search(searchString);
				displayAppButtons(apps);
				mainScroll.setViewportView(mainPanel);
				mainPanel.setPreferredSize(new Dimension(1000, (j*155)));
				middleSP.setBottomComponent(mainScroll);
				repaint();
			}
		}));
		
		displayAppButtons(Search.appsList);
		
		mainScroll.setViewportView(mainPanel);
		mainPanel.setPreferredSize(new Dimension(1000, (j*155)));
		middleSP.setBottomComponent(mainScroll);
		
		
		pack();
	}
	
	private void displayAppButtons(ArrayList<App> a) {
		j = 0;
		mainPanel.removeAll();
		for(int i = 0; i < a.size(); i++) {
			mainPanel.add(makeButton(a.get(i)));
			j++;
		}
	} 
	
	private JButton makeButton(App a) {
		JButton app = new JButton(a.displayExtended());
		app.setPreferredSize(new Dimension(1000, 150));
		return app;
	}
	
	public static void main(String[] args) {
		Login.getUserNames();
		Search.getApps();
		EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Display().setVisible(true);
            }
        });
	}

}