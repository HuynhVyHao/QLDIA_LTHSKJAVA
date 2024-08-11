package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import db.Connect;
import entity.KhachHang;
import entity.NhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmNhanVien extends JPanel {
	private JTextField txtDiaChi;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JTextField txtmaNV;
	private JTable tblNhanVien;
	private JTextField txtSDT;
	private JTextField txthoTen;
	private JTextField txtcmnd;
	private JTextField txtMoTa;
	private NhanVien_DAO nv_dao;
	private JDateChooser dateNgaySN;
	public FrmNhanVien(){
			setBounds(0, 00, 965, 785);
			setVisible(true);
			try {
	            Connect.getInstance().connect();
	          } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
		List <NhanVien> listnv = new ArrayList<>();
	    nv_dao=new NhanVien_DAO();
		JComboBox cboGT = new JComboBox();
		cboGT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboGT.setModel(new DefaultComboBoxModel(new String[] {"Nam ", "Nữ"}));
		JLabel lblNewLabel = new JLabel("NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblmaBD = new JLabel("Mã NV :");
		
		JLabel lbltenBD = new JLabel("Họ Và Tên :");
		
		JLabel lbltheloai = new JLabel("Giới Tính");
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Số Điện Thoại :");
		
		lblNewLabel_3 = new JLabel("Địa Chỉ :");
		
		lblNewLabel_5 = new JLabel("Ngày Sinh :");
		
		txtmaNV = new JTextField();
		txtmaNV.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("E:\\QLDia\\image\\Iconsmind-Outline-Add-File.24.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
				NhanVien nv=new NhanVien();
                nv.setMaNV(txtmaNV.getText());
                nv.setHoTen(txthoTen.getText());
                nv.setGioiTinh(cboGT.getSelectedItem().toString());
                nv.setNgaySinh(dateNgaySN.getDate());
                nv.setCMND(Integer.parseInt(txtcmnd.getText()));
                nv.setSDT(Integer.parseInt(txtSDT.getText()));
                nv.setDiaChi(txtDiaChi.getText());
                nv.setMoTa(txtMoTa.getText());
               
                
               NhanVien_DAO nv_dao = new NhanVien_DAO(); 

                listnv.add(nv);
                 if(nv_dao.ThemNhanVien(nv)) {
                     JOptionPane.showMessageDialog(null, "Thêm thành công");
                 }else {
                     JOptionPane.showMessageDialog(null, "Thêm thất bại");
                 }
                    
              LoadDatabase();
				}	}
		});
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Mono-General-2-Edit.24.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=new NhanVien();
                nv.setMaNV(txtmaNV.getText());
                nv.setHoTen(txthoTen.getText());
                nv.setGioiTinh(cboGT.getSelectedItem().toString());
                nv.setCMND(Integer.parseInt(txtcmnd.getText()));
                nv.setNgaySinh(dateNgaySN.getDate());
                nv.setSDT(Integer.parseInt(txtSDT.getText()));
                nv.setDiaChi(txtDiaChi.getText());
                nv.setMoTa(txtMoTa.getText());
                
                NhanVien_DAO nv_dao = new NhanVien_DAO(); 

                listnv.add(nv);
                 if(nv_dao.SuaNhanVien(nv)) {
                     JOptionPane.showMessageDialog(null, "Sửa thành công");
                 }else {
                     JOptionPane.showMessageDialog(null, "Sửa thất bại");
                 }
                    
             LoadDatabase();
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("E:\\QLDia\\image\\Icons8-Windows-8-Editing-Delete.24.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
		            int row = tblNhanVien.getSelectedRow();
		            String MaNV = (String) tblNhanVien.getValueAt(row, 0);
		            int action =JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không","Delete",JOptionPane.YES_NO_OPTION);
		            DefaultTableModel model=(DefaultTableModel) tblNhanVien.getModel();
		            if(action==JOptionPane.YES_OPTION) {
		                nv_dao.DeleteKhachHang(MaNV);
		                JOptionPane.showMessageDialog(null, "Xóa thành công");
		                model.removeRow(row);		            
		                LoadDatabase();
		           }
		            
	        }
			}
		});
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setIcon(new ImageIcon("E:\\QLDia\\image\\Pictogrammers-Material-Delete-clock-outline.24.png"));
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaNV.setText("");
				txthoTen.setText("");
                txtcmnd.setText("");
                cboGT.setSelectedItem(null); 
                txtSDT.setText("");
                txtDiaChi.setText("");
                txtMoTa.setText("");
                txtmaNV.requestFocus();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblNhanVien = new JTable();
		tblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblNhanVien.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) tblNhanVien.getModel();
                txtmaNV.setText(model.getValueAt(row, 0).toString());
                txthoTen.setText(model.getValueAt(row, 1).toString());
                cboGT.setSelectedItem(model.getValueAt(row,2 ));

                txtcmnd.setText(model.getValueAt(row, 3).toString());
                dateNgaySN.setDate((Date)model.getValueAt(row, 4));
                txtSDT.setText(model.getValueAt(row, 5).toString());
                txtDiaChi.setText(model.getValueAt(row, 6).toString());
                txtMoTa.setText(model.getValueAt(row, 7).toString());
			}
		});
		scrollPane.setViewportView(tblNhanVien);
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã NV", "Họ Và Tên", "Giới Tính", "CMND","Ngày Sinh", "SDT", "Địa Chỉ", "Mô Tả"
			}
		));
		LoadDatabase();
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(409)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(420))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(19)
					.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(493))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(368)
					.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(377))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(72))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem)
						.addComponent(btnSua)
						.addComponent(btnXoa)
						.addComponent(btnXoaTrang))
					.addGap(31)
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))
		);
		
		 dateNgaySN = new JDateChooser();
		 dateNgaySN.setLocale(new Locale("vi"));
	     dateNgaySN.setDateFormatString("dd-MM-yyyy");
		
		JLabel lblNhnVinThanh = new JLabel("Số CMND :");
		
	
		
		txthoTen = new JTextField();
		txthoTen.setColumns(10);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mô Tả :");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtmaNV, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(62)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(dateNgaySN, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(134))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(txthoTen, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addGap(64)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(133))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(cboGT, 0, 159, Short.MAX_VALUE)
					.addGap(66)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(132))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNhnVinThanh, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(txtcmnd, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(62)
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(txtMoTa, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(132))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtmaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(dateNgaySN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(txthoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(cboGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNhnVinThanh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(txtcmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(txtMoTa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	public void LoadDatabase() {
        List <NhanVien> list = nv_dao.LayThongTin();
        DefaultTableModel modelNhanVien= (DefaultTableModel) tblNhanVien.getModel();
        modelNhanVien.setRowCount(0);
        for (NhanVien nv: list) {
          modelNhanVien.addRow(new Object[] {
        		  nv.getMaNV(),nv.getHoTen(),nv.getGioiTinh(),nv.getCMND(),nv.getNgaySinh(),nv.getSDT(),nv.getDiaChi(),nv.getMoTa()
          });
        }
      }
	private boolean validData() {
	    String maNV = txtmaNV.getText().trim();
	    String tenNV = txthoTen.getText().trim();
	    String cmnd = txtcmnd.getText().trim();
	    String diachi = txtDiaChi.getText().trim();
	    String sdt= txtSDT.getText().trim();
	    String mota = txtMoTa.getText().trim();

	    if (maNV.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Mã nhân viên không được bỏ trống");
	        txtmaNV.requestFocus();
	        return false;
	    }

	    if (tenNV.isEmpty() ) {
	        JOptionPane.showMessageDialog(this, "Error: Tên nhân viên không được bỏ trống ");
	        txthoTen.requestFocus();
	        return false;
	    }

	    if (cmnd.isEmpty() || !cmnd.matches("\\d{9,12}")) {
	        JOptionPane.showMessageDialog(this, "Error: CMND không được bỏ trống và chỉ được nhập số từ 9-12 chữ số");
	        txtcmnd.requestFocus();
	        return false;
	    }

	    if (diachi.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Địa chỉ không được bỏ trống");
	        txtDiaChi.requestFocus();
	        return false;
	    }

	    if (sdt.isEmpty() || !sdt.matches("\\d{10,11}")) {
	        JOptionPane.showMessageDialog(this, "Error: Số điện thoại không được bỏ trống và chỉ được nhập số từ 10-11 chữ số");
	        txtSDT.requestFocus();
	        return false;
	    }
	    if (mota.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Mô tả không được bỏ trống");
	        txtMoTa.requestFocus();
	        return false;
	    }

	    return true;
}
}

