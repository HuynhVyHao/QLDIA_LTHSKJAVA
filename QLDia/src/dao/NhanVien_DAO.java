package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;


import db.Connect;
import entity.KhachHang;
import	entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> LayThongTin() {
		// TODO Auto-generated method stub
		 ArrayList<NhanVien> dsNhanVien = new  ArrayList<NhanVien>();
		try {
			/*
			 * Ket noi SQL
			 */
		Connect.getInstance().connect();
			Connection con =Connect.getConnection();
			/*
			 * Thuc Thi Cau lenh SQL
			 */
			String SQL ="SELECT * FROM NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(SQL);
			while(rs.next()) {
				
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				int cMND = rs.getInt(4);
				Date ngaySinh= rs.getDate(5);
				int sDT= rs.getInt(6);
				String diaChi=rs.getString(7);
				String moTa=rs.getString(8);
				
			NhanVien nv = new NhanVien(maNV, hoTen, gioiTinh, cMND, ngaySinh, sDT, diaChi, moTa);
				dsNhanVien.add(nv);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	public boolean ThemNhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement statement = null;
		String SQL ="INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?)";
		int n = 0;
		try {
			statement = con.prepareStatement(SQL);
			statement.setString(1, nv.getMaNV());
			statement.setString(2, nv.getHoTen());
			statement.setString(3, nv.getGioiTinh());
			statement.setInt(4, nv.getCMND());
			LocalDate nsDate;
		    statement.setDate(5, Date.valueOf(nsDate=nv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
			statement.setInt(6,nv.getSDT());
			statement.setString(7, nv.getDiaChi());
			statement.setString(8,nv.getMoTa());
			
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean DeleteKhachHang (String MaNV) {
        Connect.getInstance();
        Connection con=Connect.getConnection();
        PreparedStatement statement=null;
        int n =0;
        try {
            statement=con.prepareStatement("delete from NhanVien where MaNV=? ");
            statement.setString(1,MaNV);
            n=statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return n>0;
    }
	public boolean SuaNhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement statement = null;
		String SQL ="UPDATE NhanVien SET HoTen=?,GioiTinh=?,CMND=?,NgaySinh=?,SDT=?,DiaChi=?,MoTa=? WHERE MaNV=?";
		int n = 0;
		try {
			statement = con.prepareStatement(SQL);
			statement.setString(8, nv.getMaNV());
			statement.setString(1, nv.getHoTen());
			statement.setString(2, nv.getGioiTinh());
			statement.setInt(3, nv.getCMND());
			LocalDate nsDate;
			statement.setDate(4, Date.valueOf(nsDate=nv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
			statement.setInt(5,nv.getSDT());
			statement.setString(6, nv.getDiaChi());
			statement.setString(7, nv.getMoTa());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}

	public static List <NhanVien> FindNhanVien(NhanVien id) {
        List <NhanVien > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from NhanVien where NhanVien.MANV='"+id.getMaNV()+"'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                NhanVien nv=new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setCMND(rs.getInt(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setSDT(rs.getInt(6));
                nv.setDiaChi(rs.getString(7));
                nv.setMoTa(rs.getString(8));
                Student2.add(nv);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
 
 public static List < NhanVien > FindNhanVienTen(NhanVien name) {
	    List < NhanVien > Student2 = new ArrayList <> ();
	    Connect.getInstance();
	    String sql = "Select *from NhanVien where NhanVien.HoTen like N'%"+name.getHoTen()+"%' ";
	    
	    try {
	    	Connection con = Connect.getConnection();
		    Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  NhanVien nv=new NhanVien();
				nv.setMaNV(rs.getString(1));
				nv.setHoTen(rs.getString(2));
				nv.setSDT(rs.getInt(6));
				nv.setDiaChi(rs.getString(7));
				nv.setGioiTinh(rs.getString(3));
				nv.setCMND(rs.getInt(4));
				nv.setNgaySinh(rs.getDate(5));
				nv.setMoTa(rs.getString(8));
				Student2.add(nv);
	      }
	    } catch (SQLException e) {
	    
	      
	    }
	    return Student2;
	  }
     
 public static List < NhanVien > FindNhanVienDiaChi(NhanVien addre) {
	    List < NhanVien > Student2 = new ArrayList <> ();
	    Connect.getInstance();
	    String sql = "Select *from NhanVien where NhanVien.DiaChi like N'%"+addre.getDiaChi()+"%' ";
	    
	    try {
	    	Connection con = Connect.getConnection();
		    Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  NhanVien nv=new NhanVien();
	    	  nv.setMaNV(rs.getString(1));
				nv.setHoTen(rs.getString(2));
				nv.setSDT(rs.getInt(6));
				nv.setDiaChi(rs.getString(7));
				nv.setGioiTinh(rs.getString(3));
				nv.setCMND(rs.getInt(4));
				nv.setNgaySinh(rs.getDate(5));
				nv.setMoTa(rs.getString(8));
				Student2.add(nv);
	      }
	    } catch (SQLException e) {
	    
	      
	    }
	    return Student2;
	  }
     
     
 public static List < NhanVien > FindNhanVienGT(NhanVien gt) {
	    List < NhanVien > Student2 = new ArrayList <> ();
	    Connect.getInstance();
	    String sql = "Select *from NhanVien where  NhanVien.GioiTinh=N'"+gt.getGioiTinh()+"' ";
	    				//+ "and NhanVien.diaChi like N'%"+addre.getDiaChi()+"%' ";
	    
	    try {
	    	Connection con = Connect.getConnection();
		    Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  NhanVien nv=new NhanVien();
	    	  nv.setMaNV(rs.getString(1));
				nv.setHoTen(rs.getString(2));
				nv.setSDT(rs.getInt(6));
				nv.setDiaChi(rs.getString(7));
				nv.setGioiTinh(rs.getString(3));
				nv.setCMND(rs.getInt(4));
				nv.setNgaySinh(rs.getDate(5));
				nv.setMoTa(rs.getString(8));
				Student2.add(nv);
	      }
	    } catch (SQLException e) {
	    
	      
	    }
	    return Student2;
	  }
     
 
 public static List < NhanVien > FindNhanVienALL(NhanVien id,NhanVien ten,NhanVien add,NhanVien gt) {
	    List < NhanVien > Student2 = new ArrayList <> ();
	    Connect.getInstance();
	    String sql = " Select *from NhanVien where NhanVien.MaNV='%"+id.getMaNV()+"%' or NhanVien.HoTen=N'%"+ten.getHoTen()+"%' "
	    		+ "or NhanVien.DiaChi=N'%"+add.getDiaChi()+"%' or NhanVien.GioiTinh=N'%"+gt.getGioiTinh()+"%' ";
	   
	    				//+ "and NhanVien.diaChi like N'%"+addre.getDiaChi()+"%' ";
	    
	    try {
	    	Connection con = Connect.getConnection();
		    Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    		NhanVien nv1=new NhanVien();
	    		nv1.setMaNV(rs.getString(1));
				nv1.setHoTen(rs.getString(2));
				nv1.setSDT(rs.getInt(3));
				nv1.setDiaChi(rs.getString(4));
				nv1.setGioiTinh(rs.getString(5));
				nv1.setCMND(rs.getInt(6));
				nv1.setNgaySinh(rs.getDate(7));
				nv1.setMoTa(rs.getString(8));
				Student2.add(nv1);
	      }
	    } catch (SQLException e) {
	    
	      
	    }
	    return Student2;
	  }

}
