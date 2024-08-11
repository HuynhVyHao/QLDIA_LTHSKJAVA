package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import db.Connect;
import entity.BangDia;
import entity.KhachHang;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmKhachHang extends JPanel {
	private JTextField txtmaKH;
	private JTextField txtdiachiKH;
	private JTextField txtsdtKH;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txthotenKH;
	private JTextField txtcmmndKH;
	private JTable tblKhachHang;
	private JTable tblKhachHang_1;
	private KhachHang_DAO kh_dao;
	private JDateChooser dateNgaySN;
	public FrmKhachHang(){
			setBounds(0, 00, 965, 807);
			setVisible(true);
			try {
	            Connect.getInstance().connect();
	          } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
		List <KhachHang> listkh = new ArrayList<>();
	    kh_dao=new KhachHang_DAO();
	      
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblmaBD = new JLabel("Mã KH :");
		
		txtmaKH = new JTextField();
		txtmaKH.setColumns(10);
		
		JLabel lbltenBD = new JLabel("Họ Và Tên:");
		
		JLabel lbltheloai = new JLabel("Số CMND :");
		
		txtdiachiKH = new JTextField();
		txtdiachiKH.setColumns(10);
		
		txtsdtKH = new JTextField();
		txtsdtKH.setColumns(10);
		
		JComboBox comboBoxGTKH = new JComboBox();
		comboBoxGTKH.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		
		lblNewLabel_2 = new JLabel("Giới Tính :");
		
		lblNewLabel_3 = new JLabel("Ngày Sinh :");
		
		lblNewLabel_5 = new JLabel("Địa Chỉ :");
		
		lblNewLabel_6 = new JLabel("Số Điện Thoại :");
		
		txthotenKH = new JTextField();
		txthotenKH.setColumns(10);
		
		txtcmmndKH = new JTextField();
		txtcmmndKH.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("E:\\QLDia\\image\\Iconsmind-Outline-Add-File.24.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
				KhachHang kh=new KhachHang();
                kh.setMaKH(txtmaKH.getText());
                kh.setHoTen(txthotenKH.getText());
                kh.setCMND(txtcmmndKH.getText());
                kh.setDiaChi(txtdiachiKH.getText());
                kh.setGioiTinh(comboBoxGTKH.getSelectedItem().toString());
                kh.setNgaySinh(dateNgaySN.getDate());
                kh.setSDT(txtsdtKH.getText());
                
                KhachHang_DAO kh_dao = new KhachHang_DAO(); 

                listkh.add(kh);
                 if(kh_dao.ThemKhachHang(kh)) {
                     JOptionPane.showMessageDialog(null, "Thêm thành công");
                 }else {
                     JOptionPane.showMessageDialog(null, "Thêm thất bại");
                 }
                    
              LoadDatabase();
			}}
		});
		tblKhachHang = new JTable();
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Mono-General-2-Edit.24.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh=new KhachHang();
                kh.setMaKH(txtmaKH.getText());
                kh.setHoTen(txthotenKH.getText());
                kh.setCMND(txtcmmndKH.getText());
                kh.setDiaChi(txtdiachiKH.getText());
                kh.setGioiTinh(comboBoxGTKH.getSelectedItem().toString());
                kh.setNgaySinh(dateNgaySN.getDate());
                kh.setSDT(txtsdtKH.getText());
                
                kh_dao= new  KhachHang_DAO();

                listkh.add(kh);
                 if(kh_dao.SuaKhachHang(kh)) {
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
		            int row = tblKhachHang_1.getSelectedRow();
		            String MaKH = (String) tblKhachHang_1.getValueAt(row, 0);
		            int action =JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không","Delete",JOptionPane.YES_NO_OPTION);
		            DefaultTableModel model=(DefaultTableModel) tblKhachHang_1.getModel();
		            if(action==JOptionPane.YES_OPTION) {
		                kh_dao.DeleteKhachHang(MaKH);
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
				txtmaKH.setText("");
				txthotenKH.setText("");
                txtcmmndKH.setText("");
                txtdiachiKH.setText("");
                comboBoxGTKH.setSelectedItem(null);          
                txtsdtKH.setText("");
                txtmaKH.requestFocus();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblKhachHang_1 = new JTable();
		tblKhachHang_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblKhachHang_1.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) tblKhachHang_1.getModel();
                txtmaKH.setText(model.getValueAt(row, 0).toString());
                txthotenKH.setText(model.getValueAt(row, 1).toString());
                txtcmmndKH.setText(model.getValueAt(row, 2).toString());
                txtdiachiKH.setText(model.getValueAt(row, 3).toString());
                comboBoxGTKH.setSelectedItem(model.getValueAt(row,4 ));
                dateNgaySN.setDate((Date)model.getValueAt(row, 5));
                txtsdtKH.setText(model.getValueAt(row, 6).toString());
			}
		});
		scrollPane.setViewportView(tblKhachHang_1);
		tblKhachHang_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã KH", "Tên Khách Hàng", "CMND", "Địa Chỉ", "Giới Tính", "Ngày Sinh", "Số Điện Thoại"
			}
		));
		LoadDatabase();
		
		 dateNgaySN = new JDateChooser();
		 dateNgaySN.setLocale(new Locale("vi"));
	     dateNgaySN.setDateFormatString("dd-MM-yyyy");
	     
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtmaKH, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(80)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBoxGTKH, 0, 169, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txthotenKH, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(80)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(dateNgaySN, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtcmmndKH, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(80)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtsdtKH, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtdiachiKH, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(357)))
					.addGap(135))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblmaBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtmaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBoxGTKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbltenBD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txthotenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateNgaySN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbltheloai, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtcmmndKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtsdtKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtdiachiKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(409)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(420))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
					.addGap(368)
					.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(377))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem)
						.addComponent(btnSua)
						.addComponent(btnXoa)
						.addComponent(btnXoaTrang))
					.addGap(8)
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
	public void LoadDatabase() {
        List <KhachHang> list = kh_dao.LayThongTin();
        DefaultTableModel modelKhachHang= (DefaultTableModel) tblKhachHang_1.getModel();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh: list) {
          modelKhachHang.addRow(new Object[] {
        		  kh.getMaKH(),kh.getHoTen(),kh.getCMND(),kh.getDiaChi(),kh.getGioiTinh(),kh.getNgaySinh(),kh.getSDT()
          });
        }
      }
	private boolean validData() {
	    String maKH = txtmaKH.getText().trim();
	    String tenKH = txthotenKH.getText().trim();
	    String cmnd = txtcmmndKH.getText().trim();
	    String diachi = txtdiachiKH.getText().trim();
	    String sdt = txtsdtKH.getText().trim();

	    if (maKH.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Mã khách hàng không được bỏ trống");
	        txtmaKH.requestFocus();
	        return false;
	    }

	    if (tenKH.isEmpty() ) {
	        JOptionPane.showMessageDialog(this, "Error: Tên khách hàng không được bỏ trống ");
	        txthotenKH.requestFocus();
	        return false;
	    }

	    if (cmnd.isEmpty() || !cmnd.matches("\\d{9,12}")) {
	        JOptionPane.showMessageDialog(this, "Error: CMND không được bỏ trống và chỉ được nhập số từ 9-12 chữ số");
	        txtcmmndKH.requestFocus();
	        return false;
	    }

	    if (diachi.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: Địa chỉ không được bỏ trống");
	        txtdiachiKH.requestFocus();
	        return false;
	    }

	    if (sdt.isEmpty() || !sdt.matches("\\d{10,11}")) {
	        JOptionPane.showMessageDialog(this, "Error: Số điện thoại không được bỏ trống và chỉ được nhập số từ 10-11 chữ số");
	        txtsdtKH.requestFocus();
	        return false;
	    }

	    return true;
	}
	  public boolean kiemTraThongTin(KhachHang nv) {
		    List <KhachHang> list = kh_dao.LayThongTin();
		    for (KhachHang nv1: list) {
		      if (nv.getMaKH() == nv1.getMaKH()) {
		        return false;
		      }
		    }
		    return true;

		  }
}




