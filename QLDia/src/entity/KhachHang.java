package entity;

import java.util.Date;

public class KhachHang {
	private	String maKH;
	private String hoTen;
	private String CMND;
	private String diaChi;
	private String gioiTinh;
	private Date ngaySinh;
	private String SDT;
	
	
	public KhachHang() {
		super();
	}


	public KhachHang(String maKH, String hoTen, String cMND, String diaChi, String gioiTinh, Date ngaySinh,
			String sDT) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		CMND = cMND;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
	}


	public String getMaKH() {
		return maKH;
	}


	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getCMND() {
		return CMND;
	}


	public void setCMND(String cMND) {
		CMND = cMND;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}
}