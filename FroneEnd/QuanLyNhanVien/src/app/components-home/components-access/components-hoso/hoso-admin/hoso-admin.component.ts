import {Component, NgModule} from '@angular/core';

import {DonVi} from "../../../../models/donvi";
import {HinhThucKhenThuong} from "../../../../models/hinhthuckhenthuong";
import {HinhThucKyLuat} from "../../../../models/hinhthuckyluat";
import {PhongBan} from "../../../../models/phongban";
import {DonViService} from "../../../../service/donvi.service";
import {Router, RouterModule} from "@angular/router";
import {PhongBanService} from "../../../../service/phongban.service";
import {HoSo} from "../../../../models/hoso";
import {HoSoService} from "../../../../service/hoso.service";
import {ChucVuService} from "../../../../service/chucvu.service";
import {QuaTrinhDaoTaoBoiDuongService} from "../../../../service/quatrinhdaotaoboiduong.service";
import {HinhThucKhenThuongService} from "../../../../service/hinhthuckhenthuong.service";
import {HinhThucKyLuatService} from "../../../../service/hinhthuckyluat.service";
import {HttpErrorResponse} from "@angular/common/http";
import {FormControl, FormGroup, NgForm} from "@angular/forms";
import {DuAn} from "../../../../models/duan";
import {DuanService} from "../../../../service/duan.service";
import {AppComponent} from "../../../../app.component";
import {TaikhoanService} from "../../../../service/taikhoan.service";
import {Taikhoan} from "../../../../models/taikhoan";

@Component({
  selector: 'app-hoso-admin',
  templateUrl: './hoso-admin.component.html',
  styleUrls: ['./hoso-admin.component.css']
})
export class HosoAdminComponent {
  public listHoSo: HoSo[] = [];
  public listTK: Taikhoan[] = [];
  public listDonVi: DonVi[] = [];
  public editQD: HoSo = new HoSo();
  public deleteHoSo: HoSo | undefined;
  public keyId: number = 0;
  public htKhenThuongList: HinhThucKhenThuong[] = [];
  public htKyLuatList: HinhThucKyLuat[] = [];
  public checkTKHS: HoSo[] = [];

  protected ten: string = '';
  maDV: string = 'DVOceanTech10';
  public dv: DonVi = new DonVi();
  p: number = 0;
  private maxSizepagi: number = 10;
  filePath: any;
  private fileUpload: Blob = new Blob();
  soQuyetDinhGenerate: string = '';
  tenQuyetDinhGenerate: string = '';
  listPhongBan: PhongBan[] = [];

  matchedUsers: HoSo[] = [];

  constructor(private theService: HoSoService, private dvService: DonViService, private router: Router,
              private cvService: ChucVuService, private pbService: PhongBanService, private duAnService: DuanService,
              private qdktService: HinhThucKhenThuongService, private quaTrinhDTBDService: QuaTrinhDaoTaoBoiDuongService,
              private qdklService: HinhThucKyLuatService, public frmApp: AppComponent,
              private tkService: TaikhoanService) {
  }

  ngOnInit(): void {
    this.getListDonVi();
    this.getListHTKhenThuong();
    this.getListHTKyLuat();
    this.setDefaultDonViSelected();
    this.getListHoSo();
    this.getDuAn();
    this.getListTaiKhoan();
    this.checkUserHSTK();
    console.log("List" + this.editQD.donVi.tenDonVi)
  }

  public checkUserHSTK(): void {
    if (this.frmApp.showUserPermision() === "Nhân viên") {
      this.theService.listHoSo().subscribe(
        (res: HoSo[]) => {
          this.matchedUsers = this.listHoSo.filter((hoSo) =>
            this.listTK.find((taiKhoan) => taiKhoan.soCmnd === hoSo.soCmnd &&
              window.localStorage.getItem('token') === taiKhoan.tenDangNhap));
        },
        (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      );
    } else {
      this.theService.listHoSo().subscribe(
        {
          next: (res: HoSo[]) => {
            this.matchedUsers = res;
          },
          error: (err: HttpErrorResponse) => {
            alert(err.statusText);
          }
        }
      );
    }
  }



  public getListTaiKhoan(): void {
    this.tkService.listTaiKhoan().subscribe(
      {
        next: (res: Taikhoan[]) => {
          this.listTK = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    )
  }


  public getListHoSo(): void {
    this.theService.listHoSo().subscribe(
      {
        next: (res: HoSo[]) => {
          this.listHoSo = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    );
  }

  public getListDonVi(): void {
    this.dvService.listDonVi().subscribe(
      {
        next: (res: DonVi[]) => {
          this.listDonVi = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    );
  }

  public getListHTKhenThuong(): void {
    this.qdktService.listHinhThucKhenThuong().subscribe(
      {
        next: (res: HinhThucKhenThuong[]) => {
          this.htKhenThuongList = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    );
  }

  public getListHTKyLuat(): void {
    this.qdklService.listHinhThucKyLuat().subscribe(
      {
        next: (res: HinhThucKyLuat[]) => {
          this.htKyLuatList = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    );
  }


  public getDonViByID(id: any): void {
    this.dvService.getDonVi(id).subscribe(
      {
        next: (res: DonVi) => {
          this.dv = res;
        },
        error: (err: HttpErrorResponse) => {
          alert(err.statusText);
        }
      }
    );
  }

  public onDelete(keyId: number): void {
    // @ts-ignore
    document.getElementById('delete-form-btn-no').click();
    this.theService.deleteHoSo(keyId).subscribe({
      next: (data) => {
        console.log(data);
        this.getListHoSo();
        this.p = Math.ceil((this.listHoSo.length - 1) / this.maxSizepagi);
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Delete successfully!", "danger");
      },
      error: (HttpErrorResponse) => {
        // alert(HttpErrorResponse.message);
        alert("Nhân viên này đang làm dự án, không thể xoá!")
      }
    })
  }

  public searchName(): void {
    this.maDV = 'BNV54';
    this.theService.listHoSoByName(this.ten).subscribe(
      (res: HoSo[]) => {
        console.log(res);
        this.listHoSo = res;
        this.setDefaultDonViSelected();
        // @ts-ignore
        document.getElementById('select-donVi').value = '';
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
      }
    );
  }

  public refresh(): void {
    this.getListHoSo();
    this.ten = '';
  }


  public loadHoSoByDonVi(madv: string): void {
    this.theService.listHoSoByDonVi(madv).subscribe({
      next: value => {
        this.listHoSo = value;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
      }
    })
  }

  public onOpenModal(obj: HoSo, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'delete') {
      this.deleteHoSo = obj;
      this.keyId = obj.idHoSo;
      button.setAttribute('data-bs-target', '#deleteModal');
    }
    if (mode === 'khenthuong') {
      this.editQD = obj;

      button.setAttribute('data-bs-target', '#qdktcnModal');
    }
    if (mode === 'kyluat') {
      this.editQD = obj;
      button.setAttribute('data-bs-target', '#qdklcnModal');
    }
    if (mode === 'danhgia') {
      this.editQD = obj;
      button.setAttribute('data-bs-target', '#qddgModal');
    }
    if (mode === 'daotaoboiduong') {
      this.editQD = obj;
      button.setAttribute('data-bs-target', '#dtbdModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }


  onAddQDKT(addForm: NgForm): void {
    for (let idhoSoItem of this.checkedValues) {
      this.theService.getHoSo(idhoSoItem).subscribe({
        next: value => {
          // @ts-ignore
          this.theService.updateHoSoKhenThuong(addForm.value.soQuyetDinh, addForm.value.ngayKy, addForm.value.noiDungQuyetDinh, value.idHoSo)
            .subscribe({
              next: data => {
                console.log(data)
                this.checkedValues = [];
                this.getListHoSo();
                addForm.reset();
              },
              error: errd => {
                console.log(errd)
              }
            });
          // @ts-ignore
          document.getElementById('add-obj-form').click();
          let formData = new FormData();
          formData.append('file', this.fileUpload);
        },
        error: err => {
          console.log(err)
        }
      });
    }

    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Đã lập quyết định khen thưởng!", "success");

  }


  onAddQDKL(addForm: NgForm): void {
    for (let idhoSoItem of this.checkedValues) {
      this.theService.getHoSo(idhoSoItem).subscribe({
        next: value => {
          // @ts-ignore
          this.theService.updateHoSoKyLuat(addForm.value.soQuyetDinh, addForm.value.ngayKy, addForm.value.noiDungQuyetDinh, value.idHoSo)
            .subscribe({
              next: data => {
                console.log(data)
                this.checkedValues = [];
                this.getListHoSo();
                addForm.reset();
              },
              error: errd => {
              }
            });
          // @ts-ignore
          document.getElementById('add-obj-form-kl').click();
          let formData = new FormData();
          formData.append('file', this.fileUpload);
        },
        error: err => {
          console.log(err)
        }
      });
    }
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Đã lập quyết định kỷ luật!", "success");
  }

  onAddDG(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-obj-form-dg').click();
    this.theService.updateHoSoDanhGia(addForm.value.ngayDanhGia, addForm.value.danhGia, addForm.value.idHoSo)
      .subscribe(
        (response: HoSo) => {
          console.log(response);
          this.getListHoSo();
          this.checkedValues = [];
          const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
          // @ts-ignore
          this.alertHold(alertPlaceholder, "Đã quyết định đánh giá cán bộ!", "success");
        },
        (error: HttpErrorResponse) => {
          if (error.status == 406) {

            const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
            // @ts-ignore
            this.alertHold(alertPlaceholder, "Thất bại!", "warning");
          }
          addForm.reset();
        }
      );
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
    }, 1500);
  }


  getFile(event: Event) {
    // @ts-ignore
    let file = event.target.files[0];
    if (file.type !== 'application/pdf') {
      alert("vui lòng chọn tệp pdf")
    } else {
      this.fileUpload = file;
      console.log(this.fileUpload);
    }
  }

  navigate(url: string) {
    this.router.navigate([url]).then(r => console.log(r));
  }

  navigateCTHoSo(url: string, idHoSo: number) {
    this.router.navigate([`${url}/${idHoSo}`]).then(r => console.log("url" + r));
  }


  soQuyetDinhGenerateFunc(year: number, qd: string): void {
    let randomNumber = Math.floor(Math.random() * 1000);
    this.soQuyetDinhGenerate = `${randomNumber}-${year}/${qd}`;
  }


  checkboxes = document.getElementsByName('check-box-menu');
  checkedValues: number[] = [];
  HinhThucSelected: any = null;
  donViSelected: DonVi = new DonVi();
  phongBanSelected: PhongBan = new PhongBan();
  xepLoaiDanhGia: any = null;
  ngayGuiDaoTaoBoiDuong: string = '';
  trangThaiDaoTaoBoiDuongSelected: string = 'Chờ quyết định';
  sendHoSo: HoSo = new HoSo();


  getCheckBoxValue() {
    this.checkedValues = [];
    this.nhanVienArr = [];
    for (let i = 0; i < this.checkboxes.length; i++) {
      // @ts-ignore
      if (this.checkboxes[i].checked) {
        // @ts-ignore
        this.checkedValues.push(this.checkboxes[i].value);
      }
    }

  }

  onOpenModalMulti(mode: String) {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode == 'khenthuong') {
      button.setAttribute('data-bs-target', '#qdktModal');
      this.soQuyetDinhGenerateFunc(2023, 'QDKT');
      //  this.tenQuyetDinhGenerateFunc('khen thưởng', '', '');
    }
    if (mode == 'kyluat') {
      button.setAttribute('data-bs-target', '#qdklModal');
      this.soQuyetDinhGenerateFunc(2023, 'QDKL');
      //   this.tenQuyetDinhGenerateFunc('kỷ luật', '', '');
    }
    if (mode == 'danhgia') {
      button.setAttribute('data-bs-target', '#qdldgModal');
    }
    if (mode == 'daotao') {
      button.setAttribute('data-bs-target', '#qdldtModal');
    }
    if (mode == 'daotaoboiduong') {
      button.setAttribute('data-bs-target', '#multidaotaoboiduongModal');
    }
    if (mode == 'duan') {
      button.setAttribute('data-bs-target', '#duanModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }

  isChecked(): boolean {
    return this.checkedValues.length <= 0;
  }

  onChangeDonVi(donViSelectedChange: DonVi) {
    this.pbService.listPhongBanByDonVi(donViSelectedChange).subscribe({
      next: data => {
        this.listPhongBan = data;
      },
      error: err => {
        console.log(err)
      }
    });
  }

  setDefaultDonViSelected() {
    this.dvService.getDonVi('x').subscribe({
      next: value => {
        this.donViSelected = value
        console.log('dv value: ' + value.maDonVi);
        this.onChangeDonVi(this.donViSelected);
      },
      error: err => {
        console.log(err);
        this.dvService.getDonViByName('').subscribe({
          next: vdata => {
            this.donViSelected = vdata;
            this.maDV = vdata.maDonVi;
            this.onChangeDonVi(this.donViSelected);
          },
          error: errs => {
            console.log(errs);
          }
        });
      }
    });
  }

  customCompareDV(o1: DonVi, o2: DonVi) {
    if (o1 !== null && o2 !== null) {
      return o1.maDonVi == o2.maDonVi;
    } else {
      return false;
    }
  }

  customCompareN(o1: DuAn, o2: DuAn) {
    if (o1 !== null && o2 !== null) {
      return o1.id == o2.id;
    } else {
      return false;
    }
  }


  loadHoSoByPhongBan(phongBanSelected: PhongBan) {
    console.log(phongBanSelected);
    this.theService.listHoSoByPhongBan(phongBanSelected.maPhongBan).subscribe({
      next: data => {
        this.listHoSo = data;
      },
      error: ers => {
      }
    });
  }

  nhanVienArr: HoSo[] = [];

  onAddQDLDG(addDGForm: NgForm) {
    for (let idhoSoItem of this.checkedValues) {
      this.theService.getHoSo(idhoSoItem).subscribe({
        next: value => {
          // @ts-ignore
          this.theService.updateHoSoDanhGia(addDGForm.value.ngayGDanhGia, addDGForm.value.ndgdanhGia, value.idHoSo)
            .subscribe({
              next: data => {
                console.log(data)
                this.checkedValues = [];
                this.getListHoSo();
                addDGForm.reset();

              },
              error: errd => {
              }
            });
          // @ts-ignore
          document.getElementById('obj-form-dgl').click();

        },
        error: err => {
          console.log(err)
        }
      });
    }
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Đã lập đánh giá!", "success");

  }


  denNgayQTDTBD: any = '';
  coSoDaoTaoBoiDuong: any = '';
  trinhDoDaoTaoBoiDuong: any = '';
  tenChuyenNganhDaoTaoBoiDuong: any = '';


  addQuaTrinhDTBDForm = new FormGroup({
    hoSo: new FormControl(this.sendHoSo),
    tuNgay: new FormControl(this.ngayGuiDaoTaoBoiDuong),
    denNgay: new FormControl(this.denNgayQTDTBD),
    coSoDaoTaoBoiDuong: new FormControl(this.coSoDaoTaoBoiDuong),
    tenChuyenNganhDaoTaoBoiDuong: new FormControl(this.tenChuyenNganhDaoTaoBoiDuong),
    trinhDoDaoTaoBoiDuong: new FormControl(),
    trangThaiDaoTaoBoiDuong: new FormControl(this.trangThaiDaoTaoBoiDuongSelected)
  });
  chonDuAnTen: DuAn = new DuAn();
  danhSachDuAn: DuAn[] = [];


  getDuAn() {
    this.duAnService.listDuAn().subscribe(
      (data) => {
        this.danhSachDuAn = data;
      }
    );
  }

  onAddQuaTrinhDTBD() {
    for (let argument of this.checkedValues) {
      this.theService.getHoSo(argument).subscribe({
        next: hoSoData => {
          this.addQuaTrinhDTBDForm.patchValue({
            hoSo: hoSoData
          });
          console.log(this.addQuaTrinhDTBDForm.value);
          this.quaTrinhDTBDService.addQuaTrinhDaoTaoBoiDuong(this.addQuaTrinhDTBDForm.value)
            .subscribe({
              next: adddata => {
                console.log(adddata.hoSo.hoVaTen);
              },
              error: adderr => {
                console.log(adderr.data)
              }
            });
        },
        error: hError => {
          console.log(hError.data);
        }
      });
    }
    this.checkedValues = [];
    // @ts-ignore
    document.getElementById('obj-form-mtdtbd').click();
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Đã lưu thông tin đào tạo/ bồi dưỡng!", "success");
  }

  onAddDuAn(duAnForm: NgForm) {
    this.duAnService.updateHoSoDuAn(this.chonDuAnTen.id, this.checkedValues)
      .subscribe({
        next: data => {
          console.log(data)
          this.checkedValues = [];
          this.getListHoSo();
          duAnForm.reset();

          // @ts-ignore
          document.getElementById('obj-form-duan').click();
          // let formData = new FormData();
          // formData.append('file', this.fileUpload);
        },
        error: err1 => {

        }
      });
    // @ts-ignore
    document.getElementById('obj-form-duan').click();
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Đã thêm vào dự án!", "success");
  }
}

