package com.dawnfan.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DawnInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DawnInterFrm frame = new DawnInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DawnInterFrm() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(153, 204, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DawnInterFrm.class.getResource("/images/dawnlogo.png")));
		
		JLabel lblAuthor = new JLabel("Author\uFF1A    \u8303 \u5353");
		lblAuthor.setBackground(Color.WHITE);
		lblAuthor.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Language\uFF1A  Java");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblEmailFanseteamcn = new JLabel("Email\uFF1A     fans@e-team.cn");
		lblEmailFanseteamcn.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblTel = new JLabel("Tel:        15891300969");
		lblTel.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lbldawn = new JLabel("-------------------- \u7248\u6743\u6240\u6709\uFF1ADawn --------------------");
		lbldawn.setFont(new Font("宋体", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTel)
									.addComponent(lblNewLabel_1)
									.addComponent(lblEmailFanseteamcn)
									.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lbldawn)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addComponent(lblAuthor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmailFanseteamcn)
					.addGap(14)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(lbldawn)
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);
		setTitle("\u5173\u4E8EDawn");
		setBounds(100, 100, 450, 366);
		
	}
}
