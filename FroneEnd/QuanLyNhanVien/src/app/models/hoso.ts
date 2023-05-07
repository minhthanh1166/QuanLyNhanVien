import {DonVi} from "./donvi";
import {PhongBan} from "./phongban";
import {ChucVu} from "./chucvu";

export class HoSo {
  idHoSo : number = 0; //
  soHieuNhanVien : string = ''; //
  donVi : DonVi = new DonVi(); //
  phongBan : PhongBan = new PhongBan(); //
  imageUrl : Blob = new Blob(); //
  hoVaTen : string = ''; //
  ngaySinh ?: string; //
  gioiTinh : string = ''; //
  noiSinh : string = ''; //
  hoKhauThuongTru ?: string; //
  noiOHienTai ?: string; //
  danToc : number = 0; //
  tonGiao : number = 0; //
  soCmnd ?: string; //
  chucVu : ChucVu = new ChucVu(); //
  ngayBoNhiem ?: string; //
  luong : number = 0; //
  trinhDoGDPT ?: string; //
  trinhDoChuyenMon ?: string; //
  hocVi ?: string; //
  hocHam ?: string; //
  ngoaiNgu ?: string; //
  soBaoHiemXh ?: string; //
  danhGia : string = ''; //
  ngayDanhGia : string = '';
  quyetDinhKhenThuong: string = '';
  hinhThucKhenThuong: string = '';
  ngayKhenThuong: string = '';
  quyetDinhKyLuat: string = '';
  hinhThucKyLuat: string = '';
  ngayKyLuat: string = '';
  ngayGuiDaoTaoBoiDuong : string = '';
  tenChuyenNganhDaoTaoBoiDuong : string = '';
  trangThaiDaoTaoBoiDuong : string = '';
  trangThai?: string;
  ngayLapHoSo: string = '';
  constructor() {
  }
}
