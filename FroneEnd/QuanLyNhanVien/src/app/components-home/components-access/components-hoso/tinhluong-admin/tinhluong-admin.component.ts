import {Component} from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";
import {DantocService} from "../../../../service/dantoc.service";
import {TinhLuongService} from "../../../../service/TinhLuong.service";
import {TinhLuong} from "../../../../models/TinhLuong";
import {HoSo} from "../../../../models/hoso";
import {HoSoService} from "../../../../service/hoso.service";
import {DonVi} from "../../../../models/donvi";
import {PhongBanService} from "../../../../service/phongban.service";
import {Router} from "@angular/router";
import {PhongBan} from "../../../../models/phongban";
import {DonViService} from "../../../../service/donvi.service";
import {DuAn} from "../../../../models/duan";
import {DanToc} from "../../../../models/dantoc";
import {AppComponent} from "../../../../app.component";


@Component({
  selector: 'app-tinhluong-admin',
  templateUrl: './tinhluong-admin.component.html',
  styleUrls: ['./tinhluong-admin.component.css']
})
export class TinhluongAdminComponent {
  public listTinhLuong: TinhLuong[] = [];
  public listHoSo: HoSo[] = [];
  public listPhongBan: PhongBan[] = [];
  public listDonVi: DonVi[] = [];
  phongBanSelected: PhongBan = new PhongBan();
  hoSoNhanVienSelected: HoSo = new HoSo();
  donViSelected: DonVi = new DonVi();

  public loadHoSo: HoSo = new HoSo();
  tl: TinhLuong = new TinhLuong();

  hs: HoSo = new HoSo();

  public keyId: number = 0;

  p: string | number = 1;

  public deleteTinhLuong: TinhLuong = new TinhLuong();
  public editTinhLuong: TinhLuong = new TinhLuong();
  formattedAmount: String = '';

  constructor(private theService: TinhLuongService, private hoSoService: HoSoService, private router: Router,
              private pbService: PhongBanService, private dvService: DonViService, private phongBanService: PhongBanService,
              public frmApp : AppComponent) {
  }

  ngOnInit(): void {
    this.getListTinhLuong();
    this.getListHoSo();
    this.getListDonVi();
    this.setDefaultDonViSelected();
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


  customCompareDV(o1: DonVi, o2: DonVi) {
    if (o1 !== null && o2 !== null) {
      return o1.maDonVi == o2.maDonVi;
    } else {
      return false;
    }
  }

  customComparePB(o1: PhongBan, o2: PhongBan) {
    if (o1 !== null && o2 !== null) {
      return o1.maPhongBan == o2.maPhongBan;
    } else {
      return false;
    }
  }

  customCompareNV(o1: HoSo, o2: HoSo) {
    if (o1 !== null && o2 !== null) {
      return o1.idHoSo == o2.idHoSo;
    } else {
      return false;
    }
  }


  loadHoSoByPhongBan(phongBanSelected: PhongBan) {
    console.log(phongBanSelected);
    this.hoSoService.listHoSoByPhongBan(phongBanSelected.maPhongBan).subscribe({
      next: data => {
        this.listHoSo = data;
      },
      error: ers => {
      }
    });
  }

  loadHoSoNhanVien(hoSoSelected: HoSo) {
    console.log(hoSoSelected);
    this.theService.listTinhLuongByHoSo(hoSoSelected.idHoSo).subscribe({
      next: data => {
        this.listTinhLuong = data;
      },
      error: ers => {
      }
    });
  }

  private getListTinhLuong(): void {
    this.theService.listTinhLuong().subscribe(
      (res: TinhLuong[]) => {
        this.listTinhLuong = res;
      },
      (err: HttpErrorResponse) => {
        alert(err.statusText);
      }
    );
  }

  private getListHoSo(): void {
    this.hoSoService.listHoSo().subscribe(
      (res: HoSo[]) => {
        this.listHoSo = res;
      },
      (err: HttpErrorResponse) => {
        alert(err.statusText);
      }
    );
  }

  public onOpenModalAdd(mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }

  public onAdd(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-obj-form').click();

    this.theService.addTinhLuong(addForm.value).subscribe(
      (response: TinhLuong) => {
        console.log(response);
        this.getListTinhLuong();
        console.log(this.listTinhLuong.length);
        this.p = Math.ceil((this.listTinhLuong.length + 1) / 5);
        addForm.reset();
        console.log(this.p)
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Sucessfully added!", "success");

      },
      (error: HttpErrorResponse) => {
        if (error.status == 406) {

          const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
          // @ts-ignore
          this.alertHold(alertPlaceholder, "Thêm thất bại. Mã đã tồn tại!", "warning");
        }
        addForm.reset();
      }
    );
  }


  public onUpdate(obj: TinhLuong): void {
    // @ts-ignore
    document.getElementById('edit-obj-btn-close').click();
    this.theService.updateTinhLuong(this.keyId, obj).subscribe(
      (response: TinhLuong) => {
        console.log(response);
        this.getListTinhLuong();

        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Update successfully!", "info");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onDelete(keyId: number): void {
    // @ts-ignore
    document.getElementById('delete-form-btn-no').click();
    this.theService.deleteTinhLuong(keyId).subscribe(
      (response: void) => {
        console.log(response);
        this.getListTinhLuong();
        this.p = Math.ceil((this.listTinhLuong.length - 1) / 5);
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Delete successfully!", "danger");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenEditOrDeleteModal(obj: TinhLuong, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'edit') {
      this.editTinhLuong = obj;
      this.keyId = obj.idTinhLuong;
      button.setAttribute('data-bs-target', '#updateModal');
    }
    if (mode === 'delete') {
      this.deleteTinhLuong = obj;
      this.keyId = obj.idTinhLuong;
      button.setAttribute('data-bs-target', '#deleteModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
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


  public getLuong(item: TinhLuong) {
    return this.formattedAmount = new Intl.NumberFormat('vi-VN', {
      style: 'currency',
      currency: 'VND'
    }).format(item.luongChinhThuc);
  }

  public getListPhongBan(dv : DonVi) {
    this.phongBanService.listPhongBanByDonVi(dv).subscribe({
      next: data => {
        this.listPhongBan = data;
      },
      error: err => {
        console.log(err)
      }
    });
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
}
