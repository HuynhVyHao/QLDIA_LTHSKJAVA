package gui;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;



import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.CardLayout;


public class TrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChu() {
		setBounds(0, 0, 965, 559);
		setVisible(true);
		
		JLabel lbIMG = new JLabel("");
		lbIMG.setIcon(new ImageIcon("E:\\QLDia\\image\\Ảnh 18_04_2023 9_56_50 CH.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lbIMG, GroupLayout.PREFERRED_SIZE, 945, Short.MAX_VALUE)
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lbIMG, GroupLayout.PREFERRED_SIZE, 559, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		setVisible(true);

	}
}
	