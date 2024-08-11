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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import dao.NhanVien_DAO;
import db.Connect;
import entity.NhanVien;


public class FrmTimKiemNhanVien extends JPanel {
	private JTable tableNhanVien;
	private JTextField txtmaNV;
	private JTextField txtTenNV;
	private JTextField txtdiaChi;
	private JButton btnTim,btnReset;
	private NhanVien_DAO nv_dao;
	private JComboBox cboGT;
	String sfind="";
	


	/**
	 * Create the panel.
	 */
	public FrmTimKiemNhanVien() {
		setBounds(0, 0, 965, 559);
		setVisible(true);
		 try {
		      Connect.getInstance().connect();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableNhanVien = new JTable();
		tableNhanVien.setRowHeight(30);
		tableNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableNhanVien.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) tableNhanVien.getModel();
		        txtmaNV.setText(model.getValueAt(row, 0).toString());
		        txtTenNV.setText(model.getValueAt(row, 1).toString());
		        txtdiaChi.setText(model.getValueAt(row, 2).toString());
		        String cbo1=model.getValueAt(row, 3).toString();
		        switch (cbo1) {
						case "Nam":
								cboGT.setSelectedIndex(1);
							break;
						case "Nữ":
							cboGT.setSelectedIndex(2);
						break;
		
				}
		       
		 
		       
			}
		});
		tableNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(tableNhanVien);
		
		tableNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã NV", "Họ Tên NV", "Địa chỉ", "Giới Tính"
			}
		));
		LoadDatabase();
	
		
		
		
		JLabel lbltieuDe = new JLabel("Tìm Kiếm Nhân Viên");
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel lblmaNV = new JLabel("Mã NV :");
		lblmaNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblhoTenNV = new JLabel("Họ Tên NV:");
		lblhoTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lbgioiTinh = new JLabel("Giới Tính:");
		lbgioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lbldiaChi = new JLabel("Địa chỉ:");
		lbldiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtmaNV = new JTextField();
		txtmaNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtmaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTenNV.setColumns(10);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtdiaChi.setColumns(10);
		
		cboGT = new JComboBox();
		cboGT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cboGT.setModel(new DefaultComboBoxModel(new String[] {"-Chọn-", "Nam ", "Nữ"}));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbgioiTinh)
						.addComponent(lblmaNV, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(cboGT, Alignment.TRAILING, 0, 98, Short.MAX_VALUE)
						.addComponent(txtmaNV, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblhoTenNV, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbldiaChi, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtdiaChi, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(txtTenNV, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
					.addGap(9))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtmaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblmaNV))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblhoTenNV))))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbgioiTinh)
						.addComponent(cboGT, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtdiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbldiaChi))
					.addGap(47))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		
		JButton btnTim = new JButton("Tìm Kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=new NhanVien();
				
				nv.setMaNV(txtmaNV.getText());
				nv.setHoTen(txtTenNV.getText());
				nv.setDiaChi(txtdiaChi.getText());
				nv.setGioiTinh(cboGT.getSelectedItem().toString());
				
				//sfind= txtdiaChi.getText();
				//TimDocDuLieuDatabaseVaoTable();
				if (txtmaNV.getText().length()==0
					&&txtTenNV.getText().length()==0
					&&txtdiaChi.getText().length()==0
					&&cboGT.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
				} else {
					if (txtmaNV.getText().length()>0)        
			               DocDuLieuDatabaseVaoTable(nv_dao.FindNhanVien(nv));
			                }  
				if(txtTenNV.getText().length()>0) {
					DocDuLieuDatabaseVaoTable(nv_dao.FindNhanVienTen(nv));
				}
				if(txtdiaChi.getText().length()>0) {
					DocDuLieuDatabaseVaoTable(nv_dao.FindNhanVienDiaChi(nv));
					
				}
				if(cboGT.getSelectedIndex()>0) {
					DocDuLieuDatabaseVaoTable(nv_dao.FindNhanVienGT(nv));
					
				}
					JOptionPane.showMessageDialog(null, "Tìm thấy");
			}
				
		});
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien_DAO nv_dao= new NhanVien_DAO();
				txtmaNV.setText("");
				txtTenNV.setText("");
				txtdiaChi.setText("");
				cboGT.setSelectedItem(null);
				DocDuLieuDatabaseVaoTable(nv_dao.LayThongTin());
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
					.addGap(197)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(81)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
			}
		
//---------------------------
	
	public void LoadDatabase() {
	NhanVien_DAO nv_dao = new NhanVien_DAO();
        List <NhanVien> list = nv_dao.LayThongTin();
        DefaultTableModel modelNhanVien= (DefaultTableModel) tableNhanVien.getModel();
        modelNhanVien.setRowCount(0);
        for (NhanVien nv: list) {
          modelNhanVien.addRow(new Object[] {
        		  nv.getMaNV(), nv.getHoTen(),nv.getDiaChi(),nv.getGioiTinh(),
          });
        }
	}
public void DocDuLieuDatabaseVaoTable(List < NhanVien> NhanVien1 ) {
//	NhanVien nv=new NhanVien();
    List < NhanVien> list1 = new ArrayList<>();
    list1=NhanVien1;
    DefaultTableModel modelNhanVien= (DefaultTableModel) tableNhanVien.getModel();
    modelNhanVien.setRowCount(0);
    list1.forEach((nv)->{
    	 modelNhanVien.addRow(new Object[] {
    			 nv.getMaNV(), nv.getHoTen(),nv.getDiaChi(),nv.getGioiTinh(),
 		      });
    });
	}


}

	