import { Component } from '@angular/core';
import {DonVi} from "../../../../models/donvi";
import {DanToc} from "../../../../models/dantoc";
import {TonGiao} from "../../../../models/tongiao";
import {ChucVu} from "../../../../models/chucvu";
import {HoSo} from "../../../../models/hoso";
import {PhongBan} from "../../../../models/phongban";
import {HoSoService} from "../../../../service/hoso.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DonViService} from "../../../../service/donvi.service";
import {PhongBanService} from "../../../../service/phongban.service";
import {ChucVuService} from "../../../../service/chucvu.service";
import {NgForm} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-add-hoso-admin',
  templateUrl: './add-hoso-admin.component.html',
  styleUrls: ['./add-hoso-admin.component.css']
})
export class AddHosoAdminComponent {
  public listDonVi: DonVi[] = [];
  public listDanToc: DanToc[] = [];
  public listTonGiao: TonGiao[] = [];
  public listChucVu: ChucVu[] = [];
  maNgachSelect: string = '';
  private listHoSo: HoSo[] = [];

  trangThaiSelected: String = '';

  ngOnInit(): void {
    this.getListHoSo();
    this.getListDonVi();
    this.getListDanToc();
    this.getListTonGiao();
    this.getListChucVu();
    // this.getListNgach();

    this.setSoHieuNV();
    this.getProvinces();

    this.setDefaultDonViSelected();

  }

  constructor(private theService: HoSoService, private route: ActivatedRoute,
              private DVService: DonViService,
              private phongBanService: PhongBanService,
              private chucVuService: ChucVuService, private router: Router) {
  }

  navigate(url: string) {
    this.router.navigate([url]).then(r => console.log(r))
  }

  private getListHoSo() {
    this.theService.listHoSo().subscribe(
      {
        next: (res) => {
          this.listHoSo = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }

  private getListDonVi() {
    this.DVService.listDonVi().subscribe(
      {
        next: (res) => {
          this.listDonVi = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }

  private getListDanToc() {
    this.theService.listDanToc().subscribe(
      {
        next: (res) => {
          this.listDanToc = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }

  private getListTonGiao() {
    this.theService.listTonGiao().subscribe(
      {
        next: (res) => {
          this.listTonGiao = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }

  private getListChucVu() {
    this.chucVuService.listChucVu().subscribe(
      {
        next: (res) => {
          this.listChucVu = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }


  onAdd(addForm: NgForm) {
    console.log(addForm.value);
    this.theService.addHoSo(addForm.value).subscribe(
      {
        next: (response: HoSo) => {
          console.log(response);
          let formData = new FormData();
          formData.append('id', response.idHoSo.toString());
          formData.append('file', this.fileUpload);
          this.theService.uploadImage(formData).subscribe({
            next: value => {
              console.log(value);
            },
            error: err => {
              console.log(err)
            }
          });
          const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
          // @ts-ignore
          this.alertHold(alertPlaceholder, "Thêm hồ sơ thành công!", "success");
          addForm.reset();
          this.setSoHieuNV();
        },
        error: (error: HttpErrorResponse) => {
          if (error.status == 406) {
            const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
            // @ts-ignore
            this.alertHold(alertPlaceholder, "Thêm thất bại. Mã đã tồn tại!", "warning");
          }
        }
      }
    );
  }


  soHieuNV: string = 'NV';
  hocHamSelected: string = 'Không';
  hocViSelected: string = 'Không';
  trinhDoGDPTSelected: string = '12/12';
  trinhDoChuyenMonSelected: string = 'Không';
  ngoaiNguSelected: string = 'Không';
  noiSinhSelected: string = 'Hà Nội';


  public setSoHieuNV() {
    this.soHieuNV = 'NV' + Math.floor(Math.floor(10000000 + Math.random() * 90000000));
    for (const shnvElement of this.listHoSo) {
      if (shnvElement.soHieuNhanVien === this.soHieuNV) {
        this.soHieuNV = 'NV' + Math.floor(Math.floor(10000000 + Math.random() * 90000000));
      } else {
        break;
      }
    }
  }


  public alertHold(alertPlaceholder: Element, message: String, type: String): void {
    const alert = (message: String, type: any) => {
      const wrapper = document.createElement('div')
      wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" id="alert-btn-close" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
      ].join('')
      alertPlaceholder.append(wrapper);
    }
    alert(message, type);

    const alertClose = document.getElementById('alert-btn-close');
    setTimeout(function () {
      // @ts-ignore
      alertClose.click();
    }, 1000);
  }



  // Khai báo một mảng rỗng để chứa tên các tỉnh thành
  provinces: string[] = [];
  public getProvinces() : void {
    // Gửi yêu cầu HTTP đến API
    const provincesJSON = '';
    fetch('../../assets/tinhthanh.json')
      .then(response => response.json())
      .then(data => {
        for (let i=0; i<=100; i++) {
          if(i < 10 && data[`0${i}`] !== undefined) {
            this.provinces.push(data[`0${i}`].name)
          }
          else if(data[i.toString()] !== undefined) {
            this.provinces.push(data[i.toString()].name)
          }
        }
      });
  }

  fileUpload : any;
  donViSelected: DonVi = new DonVi();
  phongBanSelected: PhongBan = new PhongBan();
  listPhongBan: PhongBan[] = [];
  gioiTinhSelected: any = '';
  customComparePB(o1: PhongBan, o2: PhongBan) {
    if(o1 !== null && o2 !== null) {
      return o1.maPhongBan == o2.maPhongBan;
    }
    else {
      return false;
    }
  }
  private setDefaultDonViSelected() {
    this.phongBanService.listPhongBan().subscribe(
      {
        next: (res) => {
          this.listPhongBan = res;

        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }


  customCompareDV(o1: DonVi, o2: DonVi) {
    if(o1 !== null && o2 !== null) {
      return o1.maDonVi == o2.maDonVi;
    }
    else {
      return false;
    }
  }

  customCompareCV(o1: ChucVu, o2: ChucVu) {
    if(o1 !== null && o2 !== null) {
      return o1.maChucDanh == o2.maChucDanh;
    }
    else {
      return false;
    }
  }

  getFile(event: Event) {
    // @ts-ignore
    this.fileUpload = event.target.files[0];
    console.log(this.fileUpload);
  }


  protected readonly PhongBan = PhongBan;
  chucVuSelect: any = null;
  phongBanSelect: any = null;
  donViSelect: any = null;

}
