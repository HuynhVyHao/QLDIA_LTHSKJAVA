package gui;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FrmManHinhChinh extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane,subPanel;
	private JTabbedPane tabbedPane;
	private FrmBangDia frmBangDia;
	private FrmKhachHang  frmKhachHang;
	private FrmHoaDon frmHoaDon;
	private FrmNhanVien frmnhanvien;
	private FrmTimKiemNhanVien frmTimKiemNhanVien;
	private FrmTimKiemKhachHang frmTimKiemKhachHang;
	private FrmTimKiemBD frmTimKiemBD;
	
	private TrangChu trangchu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManHinhChinh frame = new FrmManHinhChinh();
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
	public FrmManHinhChinh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\QLDia\\image\\Home.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 637);
		//setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("HỆ THỐNG QUẢN LÝ CHO THUÊ BÁN ĐĨA");
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(true);

		
		trangchu=new TrangChu();
		
		frmTimKiemBD = new FrmTimKiemBD();
		frmKhachHang = new FrmKhachHang();		
		frmBangDia= new  FrmBangDia();
		frmHoaDon = new FrmHoaDon();
		frmnhanvien = new FrmNhanVien();
		frmTimKiemNhanVien = new FrmTimKiemNhanVien();
		frmTimKiemKhachHang= new FrmTimKiemKhachHang();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBackground(Color.LIGHT_GRAY);
		
		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnTrangChu);
		
		JMenu mnBangDia = new JMenu("Băng Đĩa");
		mnBangDia.setIcon(new ImageIcon("E:\\QLDia\\image\\Graphicloads-100-Flat-Disk.24.png"));
		mnBangDia.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnBangDia.setBackground(new Color(255, 0, 0));
		
		menuBar.add(mnBangDia);
		
		JMenuItem mntmBangDia = new JMenuItem("Cập Nhật Băng Đĩa");
		mntmBangDia.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Flatastic-10-Edit-validated.24.png"));
		mnBangDia.add(mntmBangDia);
		
		JMenuItem mntmTimKiemBD = new JMenuItem("Tìm Kiếm Băng Đĩa");
		mntmTimKiemBD.setIcon(new ImageIcon("E:\\QLDia\\image\\Graphicloads-Colorful-Long-Shadow-Search.24.png"));
		mnBangDia.add(mntmTimKiemBD);
		
		JMenu mnKhachHang = new JMenu("Khách Hàng");
		mnKhachHang.setIcon(new ImageIcon("E:\\QLDia\\image\\nhanvien.png"));
		mnKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnKhachHang);
		
		JMenuItem mntmKhachHang = new JMenuItem("Cập Nhật Khách Hàng");
		mntmKhachHang.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Flatastic-10-Edit-validated.24.png"));
		mnKhachHang.add(mntmKhachHang);
		
		JMenuItem mntmTiemKiemKH = new JMenuItem("Tìm kiếm Khách Hàng");
		mntmTiemKiemKH.setIcon(new ImageIcon("E:\\QLDia\\image\\Graphicloads-Colorful-Long-Shadow-Search.24.png"));
		mnKhachHang.add(mntmTiemKiemKH);
		
		
		JMenu mnHoaDon = new JMenu("Hóa Đơn");
		mnHoaDon.setIcon(new ImageIcon("E:\\QLDia\\image\\hopdong.png"));
		mnHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnHoaDon.setBackground(Color.RED);
		
		menuBar.add(mnHoaDon);
		
		JMenuItem mntmHD = new JMenuItem("Thêm hóa đơn");
		mntmHD.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Flatastic-10-Edit-validated.24.png"));
		mnHoaDon.add(mntmHD);
		
		JMenu mnNhanVien = new JMenu("Nhân Viên");
		mnNhanVien.setIcon(new ImageIcon("E:\\QLDia\\image\\Microsoft-Fluentui-Emoji-Flat-Man-Office-Worker-Flat-Light.24.png"));
		mnNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmCNNhanVien = new JMenuItem("Cập Nhật Nhân Viên");
		mntmCNNhanVien.setIcon(new ImageIcon("E:\\QLDia\\image\\Custom-Icon-Design-Flatastic-10-Edit-validated.24.png"));
		mnNhanVien.add(mntmCNNhanVien);
		
		JMenuItem mntmTimKiemNhanVien = new JMenuItem("Tìm Kiếm Nhân Viên");
		mntmTimKiemNhanVien.setIcon(new ImageIcon("E:\\QLDia\\image\\Graphicloads-Colorful-Long-Shadow-Search.24.png"));
		mnNhanVien.add(mntmTimKiemNhanVien);
		
		JPanel panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout(0, 0));

//Phần liên kết màn hình----------------------------------------------------------	
		
		mntmBangDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmBangDia);
				panelBody.validate();
				
				
			}
		});
		mntmKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmKhachHang);
				panelBody.validate();
				
				
			}
		});
		mntmTiemKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmTimKiemKhachHang);
				panelBody.validate();
				
				
			}
		});
		
		mntmHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmHoaDon);
				panelBody.validate();
				
				
			}
		});
		
		mntmCNNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmnhanvien);
				panelBody.validate();
				
				
			}
		});
		mntmTimKiemNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmTimKiemNhanVien);
				panelBody.validate();
				
				
			}
		});
		mntmTimKiemBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.add(frmTimKiemBD);
				panelBody.validate();
				
				
			}
		});




		mnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuClick(trangchu);
			}
		});
		
		panelBody.add(trangchu);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(558, Short.MAX_VALUE))
		);
		
		
		
	
		contentPane.setLayout(gl_contentPane);
//------------------------------------------------------------------
		
		
		
	}
	
	
	public void menuClick(JPanel panel) {
		trangchu.setVisible(false);
		panel.setVisible(true);
	
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
