import {HoSo} from "./hoso";

export class DuAn {
  id: number = 0;
  tenDuAn: string = '';
  listNhanVien: HoSo[] = [];
  ngayLapHoSoDuAn: string = '';
  ngayTienHanhThucHienDuAn?: Date;
  ngayKetThucDuAn?: Date;
  soNhanSuLamDuAn?: number;
  trangThai: number = 0;
  tongKinhPhi?: number
}
