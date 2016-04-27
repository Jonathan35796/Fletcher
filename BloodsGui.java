package scripts.BloodsAirCharger;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.tribot.api.General;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class BloodsGui extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String getFoodName;
	public boolean endGui = false;
	JTextField foodString = new JTextField(15);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodsGui frame = new BloodsGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the frame.
	 * @return 
	 */
	public BloodsGui() { 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		useFoodCheck = new JCheckBox("Don't use Food");
		useFoodCheck.setBounds(6, 182, 97, 23);
		contentPane.add(useFoodCheck);

		chckbxUseStaminas = new JCheckBox();
		chckbxUseStaminas.setBounds(6, 156, 97, 23);
		chckbxUseStaminas.setText("Use Stamina's?");
		contentPane.add(chckbxUseStaminas);

		lblNewLabel = new JLabel("Name of Food");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 132, 129, 14);
		contentPane.add(lblNewLabel);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(6, 11, 418, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		lblBloodflavorsAirOrbs = new JLabel("BloodFlavor's Air Orb's");
		lblBloodflavorsAirOrbs.setBounds(10, 11, 396, 51);
		panel.add(lblBloodflavorsAirOrbs);
		lblBloodflavorsAirOrbs.setFont(new Font("Poor Richard", Font.PLAIN, 32));
		lblBloodflavorsAirOrbs.setHorizontalAlignment(SwingConstants.CENTER);

		btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNewButtonActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(142, 215, 135, 23);
		contentPane.add(btnNewButton);

		lblNewLabel_1 = new JLabel("Start at Edgeville\r\n bank with a \r\nStaff of Air \r\nequipped and\r\n Glory(Charged) \r\nequipped.");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(16, 96, 408, 29);
		contentPane.add(lblNewLabel_1);

		lblCaseSensitive = new JLabel("Case sensitive");
		lblCaseSensitive.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCaseSensitive.setBounds(174, 141, 76, 19);
		contentPane.add(lblCaseSensitive);

		lblNewLabel_2 = new JLabel("Amount of Food ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_2.setBounds(281, 128, 129, 23);
		contentPane.add(lblNewLabel_2);

		amountOfFood = new JSlider();
		amountOfFood.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Values.foodToTake = amountOfFood.getValue();
			}
		});
		amountOfFood.setPaintLabels(true);
		amountOfFood.setSnapToTicks(true);
		amountOfFood.setBackground(SystemColor.menu);
		amountOfFood.setMinorTickSpacing(1);
		amountOfFood.setMajorTickSpacing(2);
		amountOfFood.setValue(3);
		amountOfFood.setMaximum(10);
		amountOfFood.setBounds(281, 156, 135, 38);
		contentPane.add(amountOfFood);

		TextField textField = new TextField();
		textField.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				Values.food = textField.getText();
			}
		});
		textField.setBounds(153, 166, 103, 23);
		contentPane.add(textField);



	}
	public void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if(!amountOfFood.getValueIsAdjusting()) {
			Values.foodToTake = amountOfFood.getValue();
		}
		if(chckbxUseStaminas.isSelected()) {
			Values.letsUseStaminas = true;
		}else {
			Values.letsUseStaminas = false;
		}
		if(useFoodCheck.isSelected()) {
			Values.useFood = false;
		}else {
			Values.useFood = true;
		}
		if(getFoodName != null) {
			Values.food = getFoodName;
		}
		//if(foodString != null) {
		//Values.food = foodString.getText();
		//} else {
		//General.println("You did not enter a food name!");
		//	}
		Values.guiComplete = true;

	}
	private javax.swing.JCheckBox chckbxUseStaminas;
	private javax.swing.JCheckBox useFoodCheck;
	private javax.swing.JButton btnNewButton;
	private JLabel lblBloodflavorsAirOrbs;
	private JSlider amountOfFood;
	private JLabel lblNewLabel_2;
	private JLabel lblCaseSensitive;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel textHolder;

	@Override
	public void keyTyped(KeyEvent e) {
		Values.food = e.getKeyText(15);

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
