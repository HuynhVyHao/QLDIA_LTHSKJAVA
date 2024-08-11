package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import dao.KhachHang_DAO;

import db.Connect;
import entity.KhachHang;
import entity.NhanVien;


public class FrmTimKiemKhachHang extends JPanel {
	private JTable tableKH;
	private JTextField txtmaKH;
	private JTextField txtTenKH;
	private JTextField txtdiaChi;
	private JButton btnTim,btnReset;
	
	private JComboBox cboGT;
	String sfind="";
	private JTextField txtSDT;
	private KhachHang_DAO kh_dao;
	private DefaultTableModel model;


	/**
	 * Create the panel.
	 */
	public FrmTimKiemKhachHang() {
		setBounds(0, 0, 965, 559);
		setVisible(true);
		 try {
		      Connect.getInstance().connect();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
		JScrollPane scrollPane = new JScrollPane();
		List <KhachHang> listkh = new ArrayList<>();
	    kh_dao=new KhachHang_DAO();
		tableKH = new JTable();
		tableKH.setRowHeight(30);
		tableKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableKH.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) tableKH.getModel();
		        txtmaKH.setText(model.getValueAt(row, 0).toString());
		        txtTenKH.setText(model.getValueAt(row, 1).toString());
		        txtdiaChi.setText(model.getValueAt(row, 2).toString());
		        cboGT.setSelectedItem(model.getValueAt(row,3 ).toString());
	
		        txtSDT.setText(model.getValueAt(row, 4).toString());
			}
			
		});
		

		
		tableKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(tableKH);
		tableKH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã KH", "Họ Tên KH", "Địa Chỉ", "Giới Tính","Số Điện Thoại"
			}
		));
		LoadDatabase();
		JTableHeader head= tableKH.getTableHeader();
		head.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		JLabel lbltieuDe = new JLabel("Tìm Kiếm Khách Hàng");
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel lblmaKH = new JLabel("Mã KH:");
		lblmaKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblhoTenNV = new JLabel("Họ Tên KH:");
		lblhoTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lbgioiTinh = new JLabel("Giới Tính:");
		lbgioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lbldiaChi = new JLabel("Địa chỉ:");
		lbldiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtmaKH = new JTextField();
		txtmaKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtmaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTenKH.setColumns(10);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtdiaChi.setColumns(10);
		
		cboGT = new JComboBox();
		cboGT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cboGT.setModel(new DefaultComboBoxModel(new String[] {"-Chọn-", "Nam ", "Nữ"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		
		 btnTim = new JButton("Tìm Kiếm");
		 btnTim.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		KhachHang kh=new KhachHang();
                kh.setMaKH(txtmaKH.getText());
                kh.setGioiTinh(cboGT.getSelectedItem().toString());
                kh.setHoTen(txtTenKH.getText());
                kh.setDiaChi(txtdiaChi.getText());
                if (txtmaKH.getText().length()==0
                	&&cboGT.getSelectedIndex()==0
                	&&txtTenKH.getText().length()==0
                	&&txtdiaChi.getText().length()==0
                ){
                	JOptionPane.showMessageDialog(null, "Không tìm thấy");
                }else {
                if (txtmaKH.getText().length()>0)        
               LoadDatabasevaoTable(kh_dao.FindKhachHang(kh));
                }      
                if(cboGT.getSelectedIndex()>0) {
                	LoadDatabasevaoTable(kh_dao.FindKhachHangGT(kh));      	
                } else {
                	 if (txtTenKH.getText().length()>0)        
                         LoadDatabasevaoTable(kh_dao.FindKhachHangHT(kh));
                }
                if(txtdiaChi.getText().length()>0) {
                	LoadDatabasevaoTable(kh_dao.FindKhachHangDC(kh));      	
                }       
        
                JOptionPane.showMessageDialog(null, "Tìm thấy");
		 	}
		 });
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaKH.setText("");
				txtTenKH.setText("");
                txtdiaChi.setText("");
                cboGT.setSelectedItem(null);          
                txtSDT.setText("");
                txtmaKH.requestFocus();
				LoadDatabasevaoTable(kh_dao.LayThongTin());
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
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
		);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtSDT.setColumns(10);
		
		JLabel lblSdt = new JLabel("SDT :");
		lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblmaKH, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtmaKH, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(36)
							.addComponent(lblhoTenNV, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbgioiTinh, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(cboGT, 0, 150, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(lbldiaChi, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtdiaChi, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(302)))
					.addGap(43))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblmaKH))
						.addComponent(txtmaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblhoTenNV))
						.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lbgioiTinh))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(cboGT, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lbldiaChi))
						.addComponent(txtdiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSdt))
						.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
//-------------------------
	}
	
	public void LoadDatabase() {
        List <KhachHang> list = kh_dao.LayThongTin();
        DefaultTableModel modelKhachHang= (DefaultTableModel) tableKH.getModel();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh: list) {
          modelKhachHang.addRow(new Object[] {
        		  kh.getMaKH(),kh.getHoTen(),kh.getDiaChi(),kh.getGioiTinh(),kh.getSDT()
          });
        }
	}
	public void LoadDatabasevaoTable(List<KhachHang> KhachHang) {
        List <KhachHang> list1 = kh_dao.LayThongTin();
        list1=KhachHang;
        DefaultTableModel modelKhachHang= (DefaultTableModel) tableKH.getModel();
        modelKhachHang.setRowCount(0);
        list1.forEach((kh)->{
            modelKhachHang.addRow(new Object[] {
            		kh.getMaKH(),kh.getHoTen(),kh.getDiaChi(),kh.getGioiTinh(),kh.getSDT(),
                  });
       });
       }
	
}

