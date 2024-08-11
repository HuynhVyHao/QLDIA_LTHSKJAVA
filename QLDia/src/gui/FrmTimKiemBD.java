package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.BangDia_DAO;
import dao.NhanVien_DAO;
import db.Connect;
import entity.BangDia;
import entity.KhachHang;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTimKiemBD extends JPanel {
	private JTable tableBD;
	private JTextField txtmaBD;
	private JTextField txtTenBD;
	private BangDia_DAO bd_dao;
	private JComboBox cboTL,cboHSX;
	String sfind="";

	/**
	 * Create the panel.
	 */
	public FrmTimKiemBD() {
		setBounds(0, 0, 965, 559);
		setVisible(true);
		 try {
		      Connect.getInstance().connect();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableBD = new JTable();
		tableBD.setRowHeight(30);
		tableBD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableBD.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) tableBD.getModel();
		        txtmaBD.setText(model.getValueAt(row, 0).toString());
		        txtTenBD.setText(model.getValueAt(row, 1).toString());
		        String cbo1=model.getValueAt(row, 2).toString();
		       
			}
		});
		tableBD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(tableBD);
		tableBD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã BD", "Tên BD", "Thể Loại","Hãng Sản Xuất"
			}
		));
		LoadDatabase();
		JTableHeader head= tableBD.getTableHeader();
		head.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		JLabel lbltieuDe = new JLabel("Tìm Kiếm Băng Đĩa");
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel lblmaBD = new JLabel("Mã BD :");
		lblmaBD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblhoTenNV = new JLabel("Tên BD :");
		lblhoTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lbTL = new JLabel("Thể Loại :");
		lbTL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtmaBD = new JTextField();
		txtmaBD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmaBD.setColumns(10);
		
		txtTenBD = new JTextField();
		txtTenBD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTenBD.setColumns(10);
		
		cboTL = new JComboBox();
		cboTL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cboTL.setModel(new DefaultComboBoxModel(new String[] {"-Chọn-", "Hài ", "Kinh dị", "Hàng Động"}));
		
		cboHSX = new JComboBox();
		cboHSX.setModel(new DefaultComboBoxModel(new String[] {"-Chọn-", "Hãng 01", "Hãng 02", "Hãng 03"}));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		
		JButton btnTim = new JButton("Tìm Kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangDia bd = new BangDia();
				bd.setMaBangDia(txtmaBD.getText());
				bd.setTenBangDia(txtTenBD.getText());
				bd.setTheLoai(cboTL.getSelectedItem().toString());
				bd.setHangSanXuat(cboHSX.getSelectedItem().toString());
				if(txtmaBD.getText().length()==0
					&&txtTenBD.getText().length()==0
					&&cboTL.getSelectedIndex()==0
					&&cboHSX.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
				}else {
					if(txtmaBD.getText().length()>0) {
						LoadDatabasevaoTable(bd_dao.FindBangDia(bd));
					}
					if(txtTenBD.getText().length()>0) {
						LoadDatabasevaoTable(bd_dao.FindBangDiaTen(bd));
					}	
					if(cboTL.getSelectedIndex()>0) {
						LoadDatabasevaoTable(bd_dao.FindBangDiaTL(bd));
					}	
					if(cboHSX.getSelectedIndex()>0) {
						LoadDatabasevaoTable(bd_dao.FindBangDiaSX(bd));
					}	
				}
				JOptionPane.showMessageDialog(null, "Tìm Thấy");
			}
		});
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangDia_DAO bd_dao= new BangDia_DAO();
				txtmaBD.setText("");
				txtTenBD.setText("");
				cboHSX.setSelectedItem(null);
				cboTL.setSelectedItem(null);
				txtmaBD.requestFocus();
				LoadDatabasevaoTable(bd_dao.LayThongTin());
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReset)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(121)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(355)
					.addComponent(lbltieuDe, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addGap(322))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lbltieuDe)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
		);
		
		JLabel lblHngSnXut = new JLabel("Hãng Sản Xuất  :");
		lblHngSnXut.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
		cboHSX.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtmaBD, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblhoTenNV, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtTenBD, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbTL, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(cboTL, 0, 150, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(lblHngSnXut, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(cboHSX, 0, 169, Short.MAX_VALUE)))
					.addGap(43))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtmaBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblhoTenNV, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTenBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lbTL, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(cboTL, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(cboHSX, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHngSnXut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
//---------------------------
	}
		public void LoadDatabase() {
			BangDia_DAO bd_dao = new BangDia_DAO();
	        List <BangDia> list = bd_dao.LayThongTin();
	        DefaultTableModel modelBangDia= (DefaultTableModel) tableBD.getModel();
	        modelBangDia.setRowCount(0);
	        for (BangDia bd: list) {
	          modelBangDia.addRow(new Object[] {
	        		  bd.getMaBangDia(), bd.getTenBangDia(),bd.getTheLoai(),bd.getHangSanXuat()
	          });
	        }
		}
		public void LoadDatabasevaoTable(List<BangDia> BangDia) {
			BangDia_DAO bd_dao= new BangDia_DAO();
	        List <BangDia> list1 = bd_dao.LayThongTin();
	        list1=BangDia;
	        DefaultTableModel modelBangDia= (DefaultTableModel) tableBD.getModel();
	        modelBangDia.setRowCount(0);
	        list1.forEach((bd)->{
	            modelBangDia.addRow(new Object[] {
	            		 bd.getMaBangDia(), bd.getTenBangDia(),bd.getTheLoai(),bd.getHangSanXuat()
	                  });
	       });
	       }
	
	}