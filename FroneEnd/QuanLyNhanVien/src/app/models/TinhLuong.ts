import {HoSo} from "./hoso";
import {DonVi} from "./donvi";
import {PhongBan} from "./phongban";

export class TinhLuong {

  idTinhLuong:number = 0;
  hoso: HoSo = new HoSo();
  donVi: DonVi = new DonVi();
  phongBan: PhongBan = new PhongBan();
  heSoLuong:number = 0;
  phuCap: number = 0;
  soNgayDiLam: number = 0;
  luongCoBan: number = 0;
  luongChinhThuc: number = 0;
  thoiGianCapNhat?: Date;
  ghiChu ?: string;
}
