import {Component, OnInit} from '@angular/core';
import {DuAn} from "../../../../models/duan";
import {DuanService} from "../../../../service/duan.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-duan-admin',
  templateUrl: './duan-admin.component.html',
  styleUrls: ['./duan-admin.component.css']
})
export class DuanAdminComponent implements OnInit{
  public listDuAn: DuAn[] = [];
  public editDuAn: DuAn = new DuAn();
  public  showDuAn: DuAn = new DuAn();
  public deleteDuAn: DuAn = new DuAn();
  public keyId: number = 0;


  protected ten: string = '';
  p: number = 1;
  setValueTrangThai: number = 0;

  constructor(private theService: DuanService) {
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


  public onAdd(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-obj-form').click();

    this.theService.addDuAn(addForm.value).subscribe(
      (response: DuAn) => {
        console.log(response);
        this.getListDuAn();
        console.log(this.listDuAn.length);
        this.p = Math.ceil((this.listDuAn.length + 1) / 5);
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


  public onUpdate(obj: DuAn): void {
    // @ts-ignore
    document.getElementById('edit-obj-btn-close').click();
    this.theService.updateDuAn(this.keyId, obj).subscribe(
      (response: DuAn) => {
        console.log(response);
        this.getListDuAn();

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
    this.theService.deleteDuAn(keyId).subscribe(
      (response: void) => {
        console.log(response);
        this.getListDuAn();
        this.p = Math.ceil((this.listDuAn.length - 1) / 5);
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Delete successfully!", "danger");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public refresh(): void {
    this.getListDuAn();
    this.ten = '';
  }

  downModal() {
    const closeBtn = document.getElementById('show-form');
    closeBtn!.click();
  };
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


  // Show modal

  public onOpenModalShow(obj: DuAn, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
     if (mode === 'duan') {
       this.showDuAn = obj;
       this.keyId = obj.id;
     button.setAttribute('data-bs-target', '#showModal');
     }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }


  public onOpenEditOrDeleteModal(obj: DuAn, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'edit') {
      this.editDuAn = obj;
      this.keyId = obj.id;
      button.setAttribute('data-bs-target', '#updateModal');
    }
    if (mode === 'delete') {
      this.deleteDuAn = obj;
      this.keyId = obj.id;
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

}
