import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeAdminComponent } from './components-home/home-admin/home-admin.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";

// Import FusionCharts library and chart modules
import * as FusionCharts from "fusioncharts";
import * as charts from "fusioncharts/fusioncharts.charts";
import * as FusionTheme from "fusioncharts/themes/fusioncharts.theme.fusion";
import {FusionChartsModule} from "angular-fusioncharts";
import { TaikhoanAdminComponent } from './components-home/components-access/taikhoan-admin/taikhoan-admin.component';
import { PhongbanAdminComponent } from './components-home/components-access/phongban-admin/phongban-admin.component';
import { DantocAdminComponent } from './components-home/components-access/dantoc-admin/dantoc-admin.component';
import { TongiaoAdminComponent } from './components-home/components-access/tongiao-admin/tongiao-admin.component';
import {NgxPaginationModule} from "ngx-pagination";
import { DonviAdminComponent } from './components-home/components-access/donvi-admin/donvi-admin.component';
import { HosoAdminComponent } from './components-home/components-access/components-hoso/hoso-admin/hoso-admin.component';
import { AddHosoAdminComponent } from './components-home/components-access/components-hoso/add-hoso-admin/add-hoso-admin.component';
import { ChucvuAdminComponent } from './components-home/components-access/chucvu-admin/chucvu-admin.component';
import { EditHosoAdmimComponent } from './components-home/components-access/components-hoso/edit-hoso-admim/edit-hoso-admim.component';
import { KhenthuongAdminComponent } from './components-home/components-access/khenthuong-admin/khenthuong-admin.component';
import { KyluatAdminComponent } from './components-home/components-access/kyluat-admin/kyluat-admin.component';
import {LoginAdminComponent} from "./components-home/login-admin/login-admin.component";
import { ThongkeAdminComponent } from './components-home/components-access/thongke-admin/thongke-admin.component';
import { DuanAdminComponent } from './components-home/components-access/component-duan/duan-admin/duan-admin.component';
import { XemchitietAdminComponent } from './components-home/components-access/component-duan/xemchitiet-admin/xemchitiet-admin.component';
import { TinhluongAdminComponent } from './components-home/components-access/components-hoso/tinhluong-admin/tinhluong-admin.component';
// Pass the fusioncharts library and chart modules
FusionChartsModule.fcRoot(FusionCharts, charts, FusionTheme);
@NgModule({
  declarations: [
    AppComponent,
    HomeAdminComponent,
    TaikhoanAdminComponent,
    PhongbanAdminComponent,
    DantocAdminComponent,
    TongiaoAdminComponent,
    DonviAdminComponent,
    HosoAdminComponent,
    AddHosoAdminComponent,
    ChucvuAdminComponent,
    EditHosoAdmimComponent,
    KhenthuongAdminComponent,
    KyluatAdminComponent,
    LoginAdminComponent,
    ThongkeAdminComponent,
    DuanAdminComponent,
    XemchitietAdminComponent,
    TinhluongAdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterOutlet,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FusionChartsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
