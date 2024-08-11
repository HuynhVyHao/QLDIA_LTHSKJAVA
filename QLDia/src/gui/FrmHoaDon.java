package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

  	public class FrmHoaDon extends JPanel {
		private JTextField textField_4;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_3;
		private JLabel lblNewLabel_5;
		private JTextField txtmaHD;
		private JTable table;
		private JTextField txtSoLuong;
		public FrmHoaDon(){
			setBounds(0, 00, 965, 807);
				setVisible(true);
				
				
			JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			
			JLabel lblmaBD = new JLabel("Mã HĐ :");
			
			JLabel lbltenBD = new JLabel("Mã KH : ");
			
			JLabel lbltheloai = new JLabel("Mã BĐ :");
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			
			lblNewLabel_2 = new JLabel("Số Lượng :");
			
			lblNewLabel_3 = new JLabel("Số Ngày Mượn :");
			
			lblNewLabel_5 = new JLabel("Ngày Thuê :");
			
			txtmaHD = new JTextField();
			txtmaHD.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("DANH SÁCH HÓA ĐƠN");
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
			
			JButton btnThem = new JButton("Thêm");
			btnThem.setIcon(new ImageIcon("E:\\QLDia\\image\\Iconsmind-Outline-Add-File.24.png"));
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			JButton btnSua = new JButton("Sửa");
			btnSua.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Mono-General-2-Edit.24.png"));
			
			JButton btnXoa = new JButton("Xóa");
			btnXoa.setIcon(new ImageIcon("E:\\QLDia\\image\\Icons8-Windows-8-Editing-Delete.24.png"));
			
			JButton btnXoaTrang = new JButton("Xóa Trắng");
			btnXoaTrang.setIcon(new ImageIcon("E:\\QLDia\\image\\Pictogrammers-Material-Delete-clock-outline.24.png"));
			
			JScrollPane scrollPane = new JScrollPane();
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã HĐ", "Tên Khách Hàng", "Tên Băng Đĩa", "Số Lượng","Tên Nhân Viên", "Ngày Thuê", "Số Ngày Được Thuê", "Thành Tiền", "Tình Trạng"
				}
			));
			
			JComboBox comboBoxmaBD = new JComboBox();
			
			JComboBox comboBoxmaKH = new JComboBox();
			
			txtSoLuong = new JTextField();
			txtSoLuong.setColumns(10);
			
			JButton btnThanhToan = new JButton("Thanh Toán");
			btnThanhToan.setIcon(new ImageIcon("E:\\QLDia\\image\\Fa-Team-Fontawesome-Regular-FontAwesome-Regular-Money-Bill-1.24.png"));
			
			JDateChooser dateChooser = new JDateChooser();
			
			JLabel lblNhnVinThanh = new JLabel("Nhân Viên Thanh Toán :\r\n");
			
			JComboBox comboBox = new JComboBox();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(60)
						.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(txtmaHD, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addGap(80)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(9)
						.addComponent(txtSoLuong, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addGap(136))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(58)
						.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(comboBoxmaKH, 0, 160, Short.MAX_VALUE)
						.addGap(80)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addGap(135))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(58)
						.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(comboBoxmaBD, 0, 159, Short.MAX_VALUE)
						.addGap(80)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addGap(136))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(6)
						.addComponent(lblNhnVinThanh, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(comboBox, 0, 159, Short.MAX_VALUE)
						.addGap(492))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(txtmaHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(14)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(1)
								.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addComponent(comboBoxmaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(1)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(12)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(comboBoxmaBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNhnVinThanh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
			);
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(409)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addGap(404))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(81)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addGap(56))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(66)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
						.addGap(19)
						.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addGap(23)
						.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addGap(10)
						.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addGap(17)
						.addComponent(btnThanhToan, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addGap(361))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(368)
						.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
						.addGap(361))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(23)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
						.addGap(21))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnThem)
							.addComponent(btnSua)
							.addComponent(btnXoa)
							.addComponent(btnXoaTrang)
							.addComponent(btnThanhToan))
						.addGap(31)
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
			);
			setLayout(groupLayout);
		}
	}



