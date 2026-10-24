import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		// Use a white background to make the slide descriptions easier to read.
		textPane.setBackground(Color.WHITE);
	
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		// Changed the title to match the Product Owner's wellness travel focus.
		setTitle("Top 5 Wellness Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);

		// Keep the destination descriptions above the navigation buttons.
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(Color.WHITE);
		textPane.setBackground(Color.WHITE);
		textPane.setPreferredSize(new Dimension(790, 100));

		bottomPanel.add(textPane, BorderLayout.CENTER);
		bottomPanel.add(buttonPane, BorderLayout.SOUTH);

		

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	// Load wellness photos from resources and display them at 800 by 500 pixels.
	// Photo credits: Perspective Nature, Margaret Young,
	// Emily Irene Photo Co, and Daniele Franchi on Unsplash.
	// Forest photo: Crystal Young.
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/perspective-nature-pT7Zg368Sks-unsplash.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/margaret-young-plURrpY-7ok-unsplash.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/crystal young forest.jpg.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/emily-irene-photo-co-XdjuOZOEoeU-unsplash.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/daniele-franchi-oqCTpPIA00I-unsplash.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	// Match each slide number with a wellness vacation description to meet the Product Owner's updated requirements.
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Swiss Alps Wellness Retreat</font><br>Unwind with yoga, meditation, and peaceful nature walks.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Beach Wellness Retreat</font><br>Recharge with gentle yoga, guided meditation, and relaxing seaside walks.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Forest Wellness Retreat</font><br>Enjoy mindful nature walks, quiet meditation, and time away from screens.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Desert Spa Retreat</font><br>Unwind with spa treatments, gentle stretching, and quiet desert surroundings.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Lakeside Wellness Retreat</font><br>Relax with lakeside meditation, gentle yoga, and peaceful walks by the water.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}