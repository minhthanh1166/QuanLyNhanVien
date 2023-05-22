import {Component, OnInit} from '@angular/core';
import {DuAn} from "../../../../models/duan";
import {HttpErrorResponse} from "@angular/common/http";
import {DuanService} from "../../../../service/duan.service";
import {HoSoService} from "../../../../service/hoso.service";
import {AppComponent} from "../../../../app.component";

@Component({
  selector: 'app-xemchitiet-admin',
  templateUrl: './xemchitiet-admin.component.html',
  styleUrls: ['./xemchitiet-admin.component.css']
})
export class XemchitietAdminComponent implements OnInit {

  public listDuAn: DuAn[] = [];
  p: number = 1;
  countNV: any = 0;
  public deleteDuAn: DuAn = new DuAn();
  public keyId: number = 0;

  constructor(private theService: DuanService, private nhanVienService: HoSoService,
              public frmApp :AppComponent) {
  }

  ngOnInit(): void {
    this.getListDuAn();
  }

  private getListDuAn() {
    this.theService.listDuAn().subscribe(
      (res: DuAn[]) => {
        this.listDuAn = res;

      },
      (err: HttpErrorResponse) => {
        alert(err.statusText);
      }
    );
  }

  public onOpenEditOrDeleteModal(obj: DuAn, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'delete') {
      this.deleteDuAn = obj;
      this.keyId = obj.id;
      button.setAttribute('data-bs-target', '#deleteModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }


  public onDelete(idDuAn: number): void {
      this.theService.deleteNhanVien(idDuAn, this.checkedNhanVien).subscribe(
        {
          next: (response: DuAn) => {
            console.log(response);
            this.getListDuAn();
          },
          error: (error) => {
            console.log(error.message)
          }
        });

    // @ts-ignore
    document.getElementById(
      'delete-nvda-no').click();

    const
      alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    // @ts-ignore
    this.alertHold(alertPlaceholder, "Delete successfully!", "danger"
      );
  }

  public alertHold(alertPlaceholder
              :
              Element, message
              :
              String, type
              :
              String
  ):
    void {
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
      }, 1500
    )
    ;
  }

  checkedNhanVien: any[] = [];
  checkboxes = document.getElementsByName('check-box');

  getCheckedNV($event
                 :
                 Event
  ) {
    this.checkedNhanVien = [];
    this.checkboxes!.forEach((box) => {
      // @ts-ignore
      if (box.checked) {
        // @ts-ignore
        this.checkedNhanVien.push(box.value);
      }
    })


    console.log(this.checkedNhanVien);
  }
}



