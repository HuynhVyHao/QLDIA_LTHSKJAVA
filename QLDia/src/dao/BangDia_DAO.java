package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Connect;
import entity.BangDia;
import entity.KhachHang;

public class BangDia_DAO {
		public ArrayList<BangDia> LayThongTin(){
			 ArrayList<BangDia> dsbangdia = new ArrayList<BangDia>();
			    try {
			        //Kết nối tới CSDL
			        Connection con = Connect.getConnection();
			        String sql = "SELECT * FROM BangDia";
			        Statement statement = con.createStatement();
			        ResultSet rs = statement.executeQuery(sql);

			        while (rs.next()) {
			            String maBD = rs.getString(1);
			            String tenBD = rs.getString(2);
			            String theLoai = rs.getString(3);
			            boolean tinhTrang = rs.getString(4).equals("Mới");
			            String tinhTrangStr;
			            if (tinhTrang) {
			                tinhTrangStr = "Mới";
			            } else {
			                tinhTrangStr = "Hỏng";
			            }
			            int donGia = rs.getInt(5);
			            int soLuongTon = rs.getInt(6);
			            String hangSX = rs.getString(7);
			            String ghiChu = rs.getString(8);

			            BangDia bd = new BangDia(maBD, tenBD, theLoai, tinhTrang, soLuongTon, soLuongTon, hangSX, ghiChu);
			            dsbangdia.add(bd);
			        }

			        
			    } catch (Exception e) {
			        e.printStackTrace();
			    }

			    return dsbangdia;
			}
		
		
	
		//THÊM
		  public boolean create(BangDia bd) {
			    Connect.getInstance();
			    Connection con = Connect.getConnection();
			    PreparedStatement stmt = null;
			    int n = 0;
			    try {
			    	
			      stmt = con.prepareStatement("INSERT INTO  BangDia(MaBD , TenBD,  TheLoai,DonGia, TinhTrang, SoLuong,HangSX, GhiChu) "
			      		+ " VALUES (?,?,?,?,?,?,?,?)");
			      stmt.setString(1, bd.getMaBangDia());
			      stmt.setString(2, bd.getTenBangDia());
			      stmt.setString(3, bd.getTheLoai());
			      stmt.setInt(4, bd.getDonGia());
			      stmt.setBoolean(5,bd.isTinhTrang());
			      stmt.setInt(6, bd.getSoLuongTon());
			      stmt.setString(7, bd.getHangSanXuat());
			      stmt.setString(8, bd.getGhiChu());
			     
			     
			    n= stmt.executeUpdate();
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }  finally {
			        try {
			            stmt.close();
			          } catch (SQLException e) {
			            e.printStackTrace();
			          }
			    
			    }
			   // return false;
			 return n > 0;
		  }
	
	//XÓA
		  public boolean DeleteBangDia(String MaBD) {
		        Connect.getInstance();
		        Connection con=Connect.getConnection();
		        PreparedStatement statement=null;
		        int n =0;
		        try {
		            statement=con.prepareStatement("delete from BangDia where MaBD=? ");
		            statement.setString(1,MaBD);
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
		  public boolean SuaBD(BangDia bd) {
				// TODO Auto-generated method stub
				Connect.getInstance();
				Connection con = Connect.getConnection();
				PreparedStatement statement = null;
				String SQL ="UPDATE BangDia SET TenBD=?,TheLoai=?,TinhTrang=? ,DonGia=?,SoLuong=?,HangSX=?,GhiChu=?  WHERE MaBD=?";
				int n = 0;
				try {
					statement = con.prepareStatement(SQL);
					statement.setString(8, bd.getMaBangDia());
					statement.setString(1, bd.getTenBangDia());
					statement.setString(2, bd.getTheLoai());
					String tinhTrangStr;
					if (bd.isTinhTrang()) {
					    tinhTrangStr = "Mới";
					} else {
					    tinhTrangStr = "Hỏng";
					}
					statement.setString(3, tinhTrangStr);
					statement.setInt(4, bd.getDonGia());
					statement.setInt(5, bd.getSoLuongTon());
					statement.setString(6, bd.getHangSanXuat());
					statement.setString(7, bd.getGhiChu());
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
		  public static List <BangDia> FindBangDia(BangDia id) {
		        List <BangDia> Student2 = new ArrayList <> ();
		        Connect.getInstance();
		        String sql = "Select *from BangDia where BangDia.MaBD='"+id.getMaBangDia()+"'  ";


		        try {
		            Connection con = Connect.getConnection();
		            Statement stmt=con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		          while (rs.next()) {
		                BangDia bd = new BangDia();
		                bd.setMaBangDia(rs.getString(1));
		                bd.setTenBangDia(rs.getString(2));
		                bd.setTheLoai(rs.getString(3));
		                bd.setTinhTrang(rs.getBoolean(4));
		                bd.setDonGia(rs.getInt(5));
		                bd.setSoLuongTon(rs.getInt(6));
		                bd.setHangSanXuat(rs.getString(7));
		                bd.setGhiChu(rs.getString(8));
		               
		                Student2.add(bd);
		          }
		        } catch (SQLException e) {


		        }
		        return Student2;
		      }
		  public static List <BangDia> FindBangDiaTen(BangDia ten) {
		        List <BangDia> Student2 = new ArrayList <> ();
		        Connect.getInstance();
		        String sql = "Select *from BangDia where BangDia.TenBD like N'%"+ten.getTenBangDia()+"%'  ";


		        try {
		            Connection con = Connect.getConnection();
		            Statement stmt=con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		          while (rs.next()) {
		        	  BangDia bd = new BangDia();
		                bd.setMaBangDia(rs.getString(1));
		                bd.setTenBangDia(rs.getString(2));
		                bd.setTheLoai(rs.getString(3));
		                bd.setTinhTrang(rs.getBoolean(4));
		                bd.setDonGia(rs.getInt(5));
		                bd.setSoLuongTon(rs.getInt(6));
		                bd.setHangSanXuat(rs.getString(7));
		                bd.setGhiChu(rs.getString(8));
		               
		                Student2.add(bd);
		          }
		        } catch (SQLException e) {


		        }
		        return Student2;
		  }
		  public static List <BangDia> FindBangDiaTL(BangDia tl) {
		        List <BangDia> Student2 = new ArrayList <> ();
		        Connect.getInstance();
		        String sql = "Select *from BangDia where BangDia.TheLoai like N'%"+tl.getTheLoai()+"%'  ";


		        try {
		            Connection con = Connect.getConnection();
		            Statement stmt=con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		          while (rs.next()) {
		        	  BangDia bd = new BangDia();
		                bd.setMaBangDia(rs.getString(1));
		                bd.setTenBangDia(rs.getString(2));
		                bd.setTheLoai(rs.getString(3));
		                bd.setTinhTrang(rs.getBoolean(4));
		                bd.setDonGia(rs.getInt(5));
		                bd.setSoLuongTon(rs.getInt(6));
		                bd.setHangSanXuat(rs.getString(7));
		                bd.setGhiChu(rs.getString(8));
		               
		                Student2.add(bd);
		          }
		        } catch (SQLException e) {


		        }
		        return Student2;
		  }
		  public static List <BangDia> FindBangDiaSX(BangDia sx) {
		        List <BangDia> Student2 = new ArrayList <> ();
		        Connect.getInstance();
		        String sql = "Select *from BangDia where BangDia.HangSX like N'%"+sx.getHangSanXuat()+"%'  ";


		        try {
		            Connection con = Connect.getConnection();
		            Statement stmt=con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		          while (rs.next()) {
		        	  BangDia bd = new BangDia();
		                bd.setMaBangDia(rs.getString(1));
		                bd.setTenBangDia(rs.getString(2));
		                bd.setTheLoai(rs.getString(3));
		                bd.setTinhTrang(rs.getBoolean(4));
		                bd.setDonGia(rs.getInt(5));
		                bd.setSoLuongTon(rs.getInt(6));
		                bd.setHangSanXuat(rs.getString(7));
		                bd.setGhiChu(rs.getString(8));
		               
		                Student2.add(bd);
		          }
		        } catch (SQLException e) {


		        }
		        return Student2;
		  }
	}
