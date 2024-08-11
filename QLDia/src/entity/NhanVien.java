
package entity;

import java.util.Date;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private String gioiTinh;
	private int CMND;
	private Date ngaySinh;
	private int SDT;
	private String diaChi;
	private String moTa;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String hoTen, String gioiTinh, int cMND, Date ngaySinh, int sDT, String diaChi,
			String moTa) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.diaChi = diaChi;
		this.moTa = moTa;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getCMND() {
		return CMND;
	}

	public void setCMND(int cMND) {
		CMND = cMND;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", CMND=" + CMND
				+ ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", diaChi=" + diaChi + ", moTa=" + moTa + "]";
	}
	
	

	
}

