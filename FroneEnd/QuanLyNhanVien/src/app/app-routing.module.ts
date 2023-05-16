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
import {DuanAdminComponent} from "./components-home/components-access/component-duan/duan-admin/duan-admin.component";
import {
  XemchitietAdminComponent
} from "./components-home/components-access/component-duan/xemchitiet-admin/xemchitiet-admin.component";

import { AuthGuard } from "./service/auth.guard"
import {
  TinhluongAdminComponent
} from "./components-home/components-access/components-hoso/tinhluong-admin/tinhluong-admin.component";


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', component: HomeAdminComponent, canActivate: [AuthGuard]},
  { path: 'taikhoan', component: TaikhoanAdminComponent,  canActivate: [AuthGuard] },
  { path: 'phongban', component: PhongbanAdminComponent,  canActivate: [AuthGuard] },
  { path: 'dantoc', component: DantocAdminComponent,  canActivate: [AuthGuard] },
  { path: 'tongiao', component: TongiaoAdminComponent,  canActivate: [AuthGuard] },
  { path: 'donvi', component: DonviAdminComponent,  canActivate: [AuthGuard] },
  { path: 'hoso', component: HosoAdminComponent,  canActivate: [AuthGuard] },
  { path: 'addhoso', component: AddHosoAdminComponent,  canActivate: [AuthGuard] },
  { path: 'chucvu', component: ChucvuAdminComponent,  canActivate: [AuthGuard] },
  { path: 'edithoso/:id', component: EditHosoAdmimComponent,  canActivate: [AuthGuard] },
  { path: 'khenthuong', component: KhenthuongAdminComponent,  canActivate: [AuthGuard] },
  { path: 'kyluat', component: KyluatAdminComponent,  canActivate: [AuthGuard] },
  { path: 'login', component: LoginAdminComponent},
  { path: 'thongke', component: ThongkeAdminComponent,  canActivate: [AuthGuard] },
  { path: 'duan', component: DuanAdminComponent,  canActivate: [AuthGuard] },
  { path: 'xemchitiet-duan', component: XemchitietAdminComponent,  canActivate: [AuthGuard] },
  { path: 'tinhluong', component: TinhluongAdminComponent,  canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
