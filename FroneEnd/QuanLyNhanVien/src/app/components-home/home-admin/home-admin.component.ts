import {Component, OnInit} from '@angular/core';
import {TaikhoanService} from "../../service/taikhoan.service";
import {HoSoService} from "../../service/hoso.service";
import {DonViService} from "../../service/donvi.service";
import {PhongBanService} from "../../service/phongban.service";
import {interval, mapTo, Observable, scan, takeWhile} from "rxjs";
import {DuanService} from "../../service/duan.service";
import {LoginAdminComponent} from "../login-admin/login-admin.component";
import {AppComponent} from "../../app.component";

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  tongSoTaiKhoan: any = 0;
  tongSoNhanVien: any = 0;
  tongSoDonVi: any = 0;
  tongSoPhongBan: any = 0;

  countdown$: Observable<number> | undefined;
  countdown: number = 0 ;
  tongSoDuAn: any = 0;
  constructor(private tkService: TaikhoanService, private hoSoService: HoSoService,
              private donViService: DonViService, private phongBanService: PhongBanService,
              private duAnService: DuanService, private frmLogin: AppComponent) {
    this.getTongSoTaiKhoan();
    this.getTongSoNhanVien();
    this.getTongSoDonVi();
    this.getTongSoPhongBan();
    this.getTongSoDuAn();
    frmLogin.handleShowHide2();
    frmLogin.handleShowHide()

  }

  ngOnInit(): void {
    this.countdown$ = interval(5).pipe(
      mapTo(-1),
      scan((acc, curr) => acc + curr, 200),
      takeWhile(value => value >= 0)
    );
  }




  getTongSoTaiKhoan() {
    this.tkService.listTaiKhoan().subscribe(
      (data) => {
        for (let item of data) {
          this.tongSoTaiKhoan++;
        }
      }
    )
  }

  getTongSoNhanVien() {
    this.hoSoService.listHoSo().subscribe(
      (data) => {
        for (let item in data) {
          this.tongSoNhanVien++;
        }
      }
    )
  }

  private getTongSoDonVi() {
    this.donViService.listDonVi().subscribe(
      (data) => {
        for (const dataKey in data) {
          this.tongSoDonVi++;
        }
      }
    )
  }

  private getTongSoPhongBan() {
    this.phongBanService.listPhongBan().subscribe(
      (data) => {
        for (const dataKey in data) {
          this.tongSoPhongBan++;
        }
      }
    )
  }

  private getTongSoDuAn() {
    this.duAnService.listDuAn().subscribe(
      (data) => {
        for (const dataKey in data) {
          this.tongSoDuAn++;
        }
      }
    )
  }
}


