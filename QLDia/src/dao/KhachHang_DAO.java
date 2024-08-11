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


import db.Connect;
import	entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> LayThongTin() {
		// TODO Auto-generated method stub
		 ArrayList<KhachHang> dsKhachHang = new  ArrayList<KhachHang>();
		try {
			/*
			 * Ket noi SQL
			 */
		    Connect.getInstance().connect();
			Connection con =Connect.getConnection();
			/*
			 * Thuc Thi Cau lenh SQL
			 */
			String SQL ="SELECT * FROM KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(SQL);
			while(rs.next()) {
				
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String cMND = rs.getString(3);
				String diaChi=rs.getString(4);
				String gioiTinh = rs.getString(5);
				Date ngaySinh= rs.getDate(6);
				String sDT= rs.getString(7); 	
				
				KhachHang kh = new KhachHang(maKH, hoTen, cMND, diaChi, gioiTinh, ngaySinh, sDT);
				dsKhachHang.add(kh);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public boolean ThemKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement statement = null;
		String SQL ="INSERT INTO KhachHang VALUES(?,?,?,?,?,?,?)";
		int n = 0;
		try {
			statement = con.prepareStatement(SQL);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getHoTen());
			statement.setString(3, kh.getCMND());
			statement.setString(4, kh.getDiaChi());
			statement.setString(5, kh.getGioiTinh());
			LocalDate nsDate;
			statement.setDate(6, Date.valueOf(nsDate=kh.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
			statement.setString(7,kh.getSDT());
			
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
	public boolean DeleteKhachHang (String MaKH) {
        Connect.getInstance();
        Connection con=Connect.getConnection();
        PreparedStatement statement=null;
        int n =0;
        try {
            statement=con.prepareStatement("delete from KhachHang where MaKH=? ");
            statement.setString(1,MaKH);
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
	public boolean SuaKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement statement = null;
		String SQL ="UPDATE KhachHang SET HoTen=?,CMND=?,DiaChi=?,GioiTinh=?,NgaySinh=?,SDT=? WHERE MaKH=?";
		int n = 0;
		try {
			statement = con.prepareStatement(SQL);
			statement.setString(7, kh.getMaKH());
			statement.setString(1, kh.getHoTen());
			statement.setString(2, kh.getCMND());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getGioiTinh());
			LocalDate nsDate;
		    statement.setDate(5, Date.valueOf(nsDate=kh.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
			statement.setString(6,kh.getSDT());
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
	public static List <KhachHang> FindKhachHang(KhachHang id) {
        List <KhachHang > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from KhachHang where KhachHang.MaKH='"+id.getMaKH()+"'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setCMND(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSDT(rs.getString(7));
               
                Student2.add(kh);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
	public static List <KhachHang> FindKhachHangGT(KhachHang gt) {
        List <KhachHang > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from KhachHang where KhachHang.GioiTinh=N'"+gt.getGioiTinh()+"'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setCMND(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSDT(rs.getString(7));
               
                Student2.add(kh);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
	public static List <KhachHang> FindKhachHangHT(KhachHang ht) {
        List <KhachHang > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from KhachHang where KhachHang.HoTen like N'%"+ht.getHoTen()+"%'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setCMND(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSDT(rs.getString(7));
               
                Student2.add(kh);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
	public static List <KhachHang> FindKhachHangDC(KhachHang dc) {
        List <KhachHang > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from KhachHang where KhachHang.DiaChi like N'%"+dc.getDiaChi()+"%'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setCMND(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSDT(rs.getString(7));
               
                Student2.add(kh);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
	public static List <KhachHang> FindKhachHangSDT(KhachHang sdt) {
        List <KhachHang > Student2 = new ArrayList <> ();
        Connect.getInstance();
        String sql = "Select *from KhachHang where KhachHang.SDT like N'%"+sdt.getSDT()+"%'  ";


        try {
            Connection con = Connect.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setCMND(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setSDT(rs.getString(7));
               
                Student2.add(kh);
          }
        } catch (SQLException e) {


        }
        return Student2;
      }
}
