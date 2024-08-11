package entity;

public class BangDia {
	private String maBangDia;
    private String tenBangDia;
    private String theLoai;
    private boolean tinhTrang;
    private int donGia;
    private int soLuongTon;
    private String hangSanXuat;
    private String ghiChu;
    
	public BangDia() {
		super();
	}

	public BangDia(String maBangDia, String tenBangDia, String theLoai, boolean tinhTrang, int donGia, int soLuongTon,
			String hangSanXuat, String ghiChu) {
		super();
		this.maBangDia = maBangDia;
		this.tenBangDia = tenBangDia;
		this.theLoai = theLoai;
		this.tinhTrang = tinhTrang;
		this.donGia = donGia;
		this.soLuongTon = soLuongTon;
		this.hangSanXuat = hangSanXuat;
		this.ghiChu = ghiChu;
	}

	public String getMaBangDia() {
		return maBangDia;
	}

	public void setMaBangDia(String maBangDia) {
		this.maBangDia = maBangDia;
	}

	public String getTenBangDia() {
		return tenBangDia;
	}

	public void setTenBangDia(String tenBangDia) {
		this.tenBangDia = tenBangDia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "BangDia [maBangDia=" + maBangDia + ", tenBangDia=" + tenBangDia + ", theLoai=" + theLoai
				+ ", tinhTrang=" + tinhTrang + ", donGia=" + donGia + ", soLuongTon=" + soLuongTon + ", hangSanXuat="
				+ hangSanXuat + ", ghiChu=" + ghiChu + "]";
	}
   

   

	
}
