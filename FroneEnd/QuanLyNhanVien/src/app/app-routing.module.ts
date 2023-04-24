import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeAdminComponent } from './components-home/home-admin/home-admin.component';
import { TaikhoanAdminComponent } from './components-home/components-access/taikhoan-admin/taikhoan-admin.component';
import { PhongbanAdminComponent } from './components-home/components-access/phongban-admin/phongban-admin.component';
import { DantocAdminComponent } from './components-home/components-access/dantoc-admin/dantoc-admin.component';
import { TongiaoAdminComponent } from './components-home/components-access/tongiao-admin/tongiao-admin.component';
import { DonviAdminComponent } from './components-home/components-access/donvi-admin/donvi-admin.component';
import { HoSo } from './models/hoso';
import { HosoAdminComponent } from './components-home/components-access/components-hoso/hoso-admin/hoso-admin.component';
import { AddHosoAdminComponent } from './components-home/components-access/components-hoso/add-hoso-admin/add-hoso-admin.component';
import { ChucvuAdminComponent } from './components-home/components-access/chucvu-admin/chucvu-admin.component';
import {
  EditHosoAdmimComponent
} from "./components-home/components-access/components-hoso/edit-hoso-admim/edit-hoso-admim.component";
import {
  KhenthuongAdminComponent
} from "./components-home/components-access/khenthuong-admin/khenthuong-admin.component";
import {KyluatAdminComponent} from "./components-home/components-access/kyluat-admin/kyluat-admin.component";
import {LoginAdminComponent} from "./components-home/login-admin/login-admin.component";
import {ThongkeAdminComponent} from "./components-home/components-access/thongke-admin/thongke-admin.component";
import {DuanAdminComponent} from "./components-home/components-access/duan-admin/duan-admin.component";

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeAdminComponent },
  { path: 'taikhoan', component: TaikhoanAdminComponent },
  { path: 'phongban', component: PhongbanAdminComponent },
  { path: 'dantoc', component: DantocAdminComponent },
  { path: 'tongiao', component: TongiaoAdminComponent },
  { path: 'donvi', component: DonviAdminComponent },
  { path: 'hoso', component: HosoAdminComponent,  },
  { path: 'addhoso', component: AddHosoAdminComponent },
  { path: 'chucvu', component: ChucvuAdminComponent },
  { path: 'edithoso/:id', component: EditHosoAdmimComponent },
  { path: 'khenthuong', component: KhenthuongAdminComponent },
  { path: 'kyluat', component: KyluatAdminComponent },
  { path: 'login', component: LoginAdminComponent },
  { path: 'thongke', component: ThongkeAdminComponent },
  { path: 'duan', component: DuanAdminComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
