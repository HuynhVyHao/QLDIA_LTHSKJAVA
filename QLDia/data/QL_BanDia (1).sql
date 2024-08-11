CREATE DATABASE QL_BanDia
GO

USE QL_BanDia
GO

CREATE TABLE BangDia
(
	MaBD char(10) not null primary key,
	TenBD nvarchar(50),
	TheLoai nvarchar(30),
	TinhTrang nvarchar(10),
	DonGia int,
	SoLuong int,
	HangSX nvarchar(30),
	GhiChu nvarchar(100)
)

CREATE TABLE KhachHang
(
	MaKH char(10) not null primary key,
	HoTen nvarchar(30),
	CMND nvarchar(30),
	DiaChi nvarchar(50),
	GioiTinh nvarchar(3),
	NgaySinh Date,
	SDT nvarchar(30)
)
CREATE TABLE NhanVien
(
    MaNV char(10) not null primary key,
    HoTen nvarchar(30),
    GioiTinh nvarchar(3),
    CMND int,
    NgaySinh date,
    SDT int,
    DiaChi nvarchar(30),
    MoTa nvarchar(30)
)
CREATE TABLE HoaDon
(
	MAHD char(10) not null primary key,
	MAKH char(10) not null references KhachHang(MAKH),
	MABD char(10) not null references BangDia(MABD),
	SoLuong int,
	SoNgayMuon int,
	NgayThue date,
	ThanhTien float
)

CREATE TABLE ChiTietHoaDon
(
	MAHD char(10) not null primary key,
	TenKH nvarchar(30),
	TenBD nvarchar(50),
	SoLuong int,
	TenNV nvarchar(30),
	NgayThue date,
	SoNgayDuocThue date,
	ThanhTien float,
	TinhTrang bit
)

------------------
SELECT * FROM BangDia

SELECT * FROM KhachHang

SELECT * FROM HoaDon

SELECT * FROM ChiTietHoaDon

SELECT * FROM NhanVien

-- Thêm dữ liệu

INSERT INTO BangDia VALUES ('BD01',N'Băng Đĩa 01',N'Kinh dị',N'Mới','2000','4',N'Hãng 01',N'Sợ')
INSERT INTO BangDia VALUES ('BD02',N'Băng Đĩa 02',N'Hài',N'Mới','5000','10',N'Hãng 02',N'Hài')
INSERT INTO BangDia VALUES ('BD03',N'Băng Đĩa 03',N'Hành Động',N'Mới','1000','3',N'Hãng 03',N'Hay')
INSERT INTO BangDia VALUES ('BD04',N'Băng Đĩa 03',N'Hành Động',N'Mới','1000','3',N'Hãng 03',N'Hay')
--
SET DATEFORMAT dmy
INSERT INTO KhachHang VALUES ('KH01',N'Hồ Mạnh Cường','200120012',N'123 Nguyễn Du',N'Nam','24/04/2002','12312315')
INSERT INTO KhachHang VALUES ('KH02',N'Đào Duy Từ','200120056',N'456 Thành Núi',N'Nam','06/06/2001','12312314')
INSERT INTO KhachHang VALUES ('KH03',N'Kỳ Duyên','200120034',N'789 Trường Chinh',N'Nữ','15/07/2003','12312312')

--
SET DATEFORMAT dmy
INSERT INTO HoaDon VALUES ('HD01','KH01','BD01','2','10','21/04/2023','500000')
INSERT INTO HoaDon VALUES ('HD02','KH02','BD02','1','15','18/04/2023','680000')
INSERT INTO HoaDon VALUES ('HD03','KH03','BD03','7','20','07/04/2023','800000')

--
SET DATEFORMAT dmy
INSERT INTO ChiTiet_HoaDon VALUES ('HD01',N'Khách Hàng 01', N'Băng Đĩa 01','2',N'Nguyễn Hồ Hoài Nam','01/01/2022','10','1000',N'Còn hàng')
INSERT INTO ChiTiet_HoaDon VALUES ('HD01',N'Khách Hàng 02', N'Băng Đĩa 02','2',N'Nguyễn Lê Bảo Thy','02/02/2022','20','0',N'Hết Hàng')
INSERT INTO ChiTiet_HoaDon VALUES ('HD01',N'Khách Hàng 03', N'Băng Đĩa 03','2',N'Hồ Quỳnh Hương','03/03/2022','30','10000',N'Còn hàng')

SET DATEFORMAT dmy
INSERT INTO NhanVien VALUES('NV01',N'Nguyễn Hồ Hoài Nam','Nam','0792020212','01/01/2000','01234567890','123 Trường Chinh','Nhân Viên Phục Vụ')
INSERT INTO NhanVien VALUES('NV02',N'Nguyễn Lê Bảo Thy','Nữ','0792020213','02/02/2001','01234567891','456 Hoàng Hoa Thám','Nhân Viên Pha Chế')
INSERT INTO NhanVien VALUES('NV03',N'Nguyễn Quốc Duy','Nam','0792020214','03/03/2002','01234567892','789 Nguyễn Du','Nhân Viên Kế Toán')
INSERT INTO NhanVien VALUES('NV04',N'Hồ Quỳnh Hương','Nữ','0792020215','04/04/2003','01234567893','123 Nguyễn Trãi','Giám Đốc Chi Nhánh')