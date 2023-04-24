import {Component, OnInit} from '@angular/core';
import {DanToc} from "../../../models/dantoc";
import {DantocService} from "../../../service/dantoc.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-dantoc-admin',
  templateUrl: './dantoc-admin.component.html',
  styleUrls: ['./dantoc-admin.component.css']
})
export class DantocAdminComponent implements OnInit{
  public listDanToc: DanToc[] = [];
  public editDanToc: DanToc = new DanToc();
  public deleteDanToc: DanToc = new DanToc();
  public keyId: number = 0;

  protected ten: string = '';
  p: number = 1;

  constructor(private theService: DantocService) {
  }

  ngOnInit(): void {
    this.getListDanToc();
  }

  public getListDanToc(): void {
    this.theService.listDanToc().subscribe(
      (res: DanToc[]) => {
        this.listDanToc = res;

      },
      (err: HttpErrorResponse) => {
        alert(err.statusText);
      }
    );
  }

  public onAdd(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-obj-form').click();

    this.theService.addDanToc(addForm.value).subscribe(
      (response: DanToc) => {
        console.log(response);
        this.getListDanToc();
        console.log(this.listDanToc.length);
        this.p = Math.ceil((this.listDanToc.length + 1) / 5);
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

  public onUpdate(obj: DanToc): void {
    // @ts-ignore
    document.getElementById('edit-obj-btn-close').click();
    this.theService.updateDanToc(this.keyId, obj).subscribe(
      (response: DanToc) => {
        console.log(response);
        this.getListDanToc();

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
    this.theService.deleteDanToc(keyId).subscribe(
      (response: void) => {
        console.log(response);
        this.getListDanToc();
        this.p = Math.ceil((this.listDanToc.length - 1) / 5);
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
        // @ts-ignore
        this.alertHold(alertPlaceholder, "Delete successfully!", "danger");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  // public searchName(): void {
  //   this.theService.searchDanTocByName(this.ten).subscribe(
  //     (res: DanToc[]) => {
  //       this.listDanToc = res;
  //
  //     },
  //     (err: HttpErrorResponse) => {
  //       alert(err.message);
  //     }
  //   );
  // }
  pageChange: any;
  pageBoundsCorrection: any;

  public refresh(): void {
    this.getListDanToc();
    this.ten = '';
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

  public onOpenEditOrDeleteModal(obj: DanToc, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'edit') {
      this.editDanToc = obj;
      this.keyId = obj.maDanToc;
      button.setAttribute('data-bs-target', '#updateModal');
    }
    if (mode === 'delete') {
      this.deleteDanToc = obj;
      this.keyId = obj.maDanToc;
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
