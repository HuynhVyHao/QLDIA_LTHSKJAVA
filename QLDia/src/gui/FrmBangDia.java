package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import dao.BangDia_DAO;
import db.Connect;
import entity.BangDia;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class FrmBangDia extends JPanel {
	private JTextField txtmaBD;
	private JTextField txtDG;
	private JTextField txtSL;
	private JTextField txtHSX;
	private JTextField txtGC;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtTenBD;
	private JTextField txtTL;
	private JTable tableBD;
	private BangDia_DAO bd_dao;
	public FrmBangDia() {
			setBounds(0, 00, 965, 807);
			setVisible(true);
			 try {
			      Connect.getInstance().connect();
			    } catch (SQLException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		List<BangDia> listbd=new ArrayList<>();
		bd_dao = new BangDia_DAO();
			
		JLabel lblNewLabel = new JLabel("BĂNG ĐĨA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblmaBD = new JLabel("Mã Băng Đĩa :");
		
		txtmaBD = new JTextField();
		txtmaBD.setColumns(10);
		
		JLabel lbltenBD = new JLabel("Tên Băng Đĩa :");
		
		JLabel lbltheloai = new JLabel("Thể Loại :");
		
		txtDG = new JTextField();
		txtDG.setColumns(10);
		
		txtSL = new JTextField();
		txtSL.setColumns(10);
		
		txtHSX = new JTextField();
		txtHSX.setColumns(10);
		
		txtGC = new JTextField();
		txtGC.setColumns(10);
		
		JComboBox comboBoxTT = new JComboBox();
		comboBoxTT.setModel(new DefaultComboBoxModel(new String[] {"Mới", "Hỏng"}));
		
		lblNewLabel_2 = new JLabel("Tình Trạng :");
		
		lblNewLabel_3 = new JLabel("Đơn Giá :");
		
		lblNewLabel_4 = new JLabel("Số Lượng :");
		
		lblNewLabel_5 = new JLabel("Hãng Sản Xuất :");
		
		lblNewLabel_6 = new JLabel("Ghi Chú :");
		
		txtTenBD = new JTextField();
		txtTenBD.setColumns(10);
		
		txtTL = new JTextField();
		txtTL.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("DANH SÁCH BĂNG ĐĨA");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("E:\\QLDia\\image\\Iconsmind-Outline-Add-File.24.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
					BangDia bd=new BangDia();
					boolean addedFirstTime = (listbd.size() == 0); 
					bd.setMaBangDia(txtmaBD.getText());
					bd.setTenBangDia(txtTenBD.getText());
					bd.setTheLoai(txtTL.getText());
					String selectedTT = comboBoxTT.getSelectedItem().toString();
		            boolean tinhTrang = false;
		            if (selectedTT.equals("Mới")) {
		                tinhTrang = true;
		                // Khóa combobox "Hỏng"
		                
		            }

					bd.setDonGia(Integer.parseInt(txtDG.getText()));
					bd.setSoLuongTon(Integer.parseInt(txtSL.getText()));
					bd.setHangSanXuat(txtHSX.getText());
				
					bd.setGhiChu(txtGC.getText());
					
					 
					listbd.add(bd);
					if (addedFirstTime) { // kiểm tra nếu đây là lần đầu tiên thêm
						if (tinhTrang) {
							if (kiemTraThongTin(bd)) {
								if (bd_dao.create(bd)) {
									JOptionPane.showMessageDialog(null, "Thêm thành công");
								} else {
									JOptionPane.showMessageDialog(null, "Mã trùng");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Bạn chỉ được chọn tình trạng 'Mới' khi thêm mới đĩa lần đầu tiên.");
						}
					} else { // không phải lần đầu tiên thêm
						if (tinhTrang) {
							bd_dao.create(bd);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Bạn chỉ được chọn tình trạng 'Mới' khi thêm mới đĩa lần đầu tiên.");
						}
					}
						
					DocDuLieuDatabaseVaoTablebangdia();
				}
				
			}
		});
	
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Mono-General-2-Edit.24.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    BangDia bd = new BangDia();
			    bd.setMaBangDia(txtmaBD.getText());
			    bd.setTenBangDia(txtTenBD.getText());
			    bd.setTheLoai(txtTL.getText());
			    boolean tinhTrang = false;
			    if (comboBoxTT.getSelectedItem().equals("Mới")) {
			        tinhTrang = true;
			    }
			    bd.setTinhTrang(tinhTrang);
			    bd.setDonGia(Integer.parseInt(txtDG.getText()));
			    bd.setSoLuongTon(Integer.parseInt(txtSL.getText()));
			    bd.setHangSanXuat(txtHSX.getText());
			    bd.setGhiChu(txtGC.getText());
			    bd_dao = new BangDia_DAO();
			    if (bd_dao.SuaBD(bd)) {
			        JOptionPane.showMessageDialog(null, "Sửa thành công");
			    } else {
			        JOptionPane.showMessageDialog(null, "Sửa thất bại");
			    }
                    
                 DocDuLieuDatabaseVaoTablebangdia();
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("E:\\QLDia\\image\\Icons8-Windows-8-Editing-Delete.24.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
		            int row = tableBD.getSelectedRow();
		            String maBD = (String) tableBD.getValueAt(row, 0);
		            int action =JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không","Delete",JOptionPane.YES_NO_OPTION);
		            DefaultTableModel model=(DefaultTableModel) tableBD.getModel();
		            if(action==JOptionPane.YES_OPTION) {
						bd_dao.DeleteBangDia(maBD);
		                JOptionPane.showMessageDialog(null, "Xóa thành công");
		                model.removeRow(row);		            
		            
		           }
		        	DocDuLieuDatabaseVaoTablebangdia();
	        }
			}
		});
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setIcon(new ImageIcon("E:\\QLDia\\image\\Pictogrammers-Material-Delete-clock-outline.24.png"));
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaBD.setText("");
				txtTenBD.setText("");
                txtTL.setText("");
                txtDG.setText("");
                txtSL.setText("");
                txtHSX.setText("");
                txtGC.setText("");
                txtmaBD.requestFocus();
			}
			
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableBD = new JTable();
		tableBD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableBD.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) tableBD.getModel();
		        txtmaBD.setText(model.getValueAt(row, 0).toString());
		        txtTenBD.setText(model.getValueAt(row, 1).toString());
		        txtTL.setText(model.getValueAt(row, 2).toString());
		        String tinhTrangStr = model.getValueAt(row, 3).toString();
		        boolean tinhTrang = tinhTrangStr.equals("Mới");
		        if (tinhTrang) {
		            comboBoxTT.setSelectedItem("Mới");
		        } else {
		            comboBoxTT.setSelectedItem("Hỏng");
		        }
		        txtDG.setText(model.getValueAt(row, 4).toString());
		        txtSL.setText(model.getValueAt(row, 5).toString());
		        txtHSX.setText(model.getValueAt(row, 6).toString());
		        txtGC.setText(model.getValueAt(row, 7).toString());
			}
			
		});
		scrollPane.setViewportView(tableBD);
		tableBD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã BĐ", "Tên BĐ", "Thể Loại", "Tình Trạng", "Đơn Giá", "Số Lượng Tồn", "Hãng Sản Xuất", "Ghi Chú"
			}
		));
		//Load dữ liệu
		DocDuLieuDatabaseVaoTablebangdia();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtmaBD, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
							.addGap(48)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(comboBoxTT, 0, 117, Short.MAX_VALUE)
							.addGap(56)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(txtTL, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(txtTenBD, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(48)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(txtDG, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(46)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(txtSL, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
							.addGap(56)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtGC, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
						.addComponent(txtHSX, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
					.addGap(21))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtmaBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBoxTT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtHSX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(txtTenBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(txtDG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(24)
									.addComponent(txtSL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(27)
									.addComponent(txtTL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(txtGC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(423)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(443))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(501))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(376)
							.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(383)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem)
						.addComponent(btnSua)
						.addComponent(btnXoa)
						.addComponent(btnXoaTrang))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
	
	
	}
	
	public void DocDuLieuDatabaseVaoTablebangdia() {
	    List <BangDia> list = bd_dao.LayThongTin();
	    DefaultTableModel modelBD = (DefaultTableModel)tableBD.getModel();
	    modelBD.setRowCount(0);
	    for (BangDia bd: list) {
	        String tinhTrangStr;
	        if (bd.isTinhTrang()) {
	            tinhTrangStr = "Mới";
	        } else {
	            tinhTrangStr = "Hỏng";
	        }
	      modelBD.addRow(new Object[] {
	        bd.getMaBangDia(), bd.getTenBangDia(),bd.getTheLoai(),tinhTrangStr,bd.getDonGia(),bd.getSoLuongTon(),bd.getHangSanXuat(),bd.getGhiChu()
	      });
	    }
	  }
	private boolean validData() {
	    String maBD = txtmaBD.getText().trim();
	    String tenBD = txtTenBD.getText().trim();
	    String theLoai = txtTL.getText().trim();
	    String donGia = txtDG.getText().trim();
	    String soLuong = txtSL.getText().trim();
	    String hangSanXuat = txtHSX.getText().trim();
	    String ghiChu = txtGC.getText().trim();

	    if (maBD.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Mã Băng Đĩa không được bỏ trống");
	        txtmaBD.requestFocus();
	        return false;
	    }

	    if (tenBD.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Tên Băng Đĩa không được bỏ trống");
	        txtTenBD.requestFocus();
	        return false;
	    }

	    if (theLoai.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Thể Loại không được bỏ trống");
	        txtTL.requestFocus();
	        return false;
	    }

	    try {
	        double gia = Double.parseDouble(donGia);
	        if (gia <= 0) {
	            JOptionPane.showMessageDialog(this, "Error: Đơn giá phải lớn hơn 0");
	            txtTL.requestFocus();
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Error: Đơn giá không hợp lệ");
	        txtSL.requestFocus();
	        return false;
	    }

	    try {
	        int sl = Integer.parseInt(soLuong);
	        if (sl <= 0) {
	            JOptionPane.showMessageDialog(this, "Error: Số lượng phải lớn hơn 0");
	            txtSL.requestFocus();
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Error: Số lượng không hợp lệ");
	        txtSL.requestFocus();
	        return false;
	    }

	    if (hangSanXuat.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Hãng sản xuất không được bỏ trống");
	        txtHSX.requestFocus();
	        return false;
	    }

	    if (ghiChu.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Ghi chú không được bỏ trống");
	        txtGC.requestFocus();
	        return false;
	    }

	    return true;
	}
	  public boolean kiemTraThongTin(BangDia nv) {
		    List <BangDia> list = bd_dao.LayThongTin();
		    for (BangDia nv1: list) {
		      if (nv.getMaBangDia() == nv1.getMaBangDia()) {
		        return false;
		      }
		    }
		    return true;

		  }
	}
