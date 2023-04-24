import {Component, OnInit} from '@angular/core';
import {HoSo} from "../../../models/hoso";
import {HoSoService} from "../../../service/hoso.service";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-thongke-admin',
  templateUrl: './thongke-admin.component.html',
  styleUrls: ['./thongke-admin.component.css']
})
export class ThongkeAdminComponent implements OnInit{
  dataSource: Object | undefined;
  private dataTrinhDoChuyenMon: any;
  private listHoSo: HoSo[] = [];
  dataSourceLuong: any;
  private dataLuong: any;
  dataSourceNhanVienThang: any;
  private dataNVThang: any;
  constructor(private hoSoSevice: HoSoService) {
   this.getListHoSo();
    this.chartDataHoSo()
  }


  ngOnInit(): void {
    this.getListHoSo();
  }

  public getListHoSo(): void {
    this.hoSoSevice.listHoSo().subscribe(
      {
        next: (res) => {
          this.listHoSo = res;

          // data trinh do chuyen mon
          this.setDataDSTrinhDoChuyenMon(res);
          this.chartDataHoSo();
          this.setDataDSLuong(res);
          this.chartDataLuong();
          this.setDataDSThang(res);
          this.chartDataThang();
        },
        error: (err) => {
          console.log(err);
        }
      }
    )
  }


  private chartDataHoSo() {
    this.dataSource = {
      chart: {
        //Set the chart caption
        caption: "Thống kê theo Level Developer",
        //Set the x-axis name
        xAxisName: "Cấp độ (Level)",
        //Set the y-axis name
        yAxisName: "Số lượng",
        //Set the theme for your chart
        theme: "fusion"
      },
      // Chart Data - from step 2
      data: this.dataTrinhDoChuyenMon
    };
  }

  public setDataDSTrinhDoChuyenMon(dshs: HoSo[]) {
    let fresher = 0;
    let junior = 0;
    let senior = 0;
    let lead = 0;
    let midLevel = 0;
    let seniorLeader = 0;

    for (let hoSo of dshs) {
      console.log('hoso ngaysinh: ' + hoSo.ngaySinh)
      if (hoSo.trinhDoChuyenMon == 'Fresher Developer') {
        fresher++;
      }
      if (hoSo.trinhDoChuyenMon == 'Junior Developer') {
        junior++;
      }
      if (hoSo.trinhDoChuyenMon == 'Senior Devloper') {
        senior++;
      }
      if (hoSo.trinhDoChuyenMon == 'Lead Devloper') {
        lead++;
      }
      if (hoSo.trinhDoChuyenMon == 'Mid-level Manager') {
        midLevel++;
      }
      if (hoSo.trinhDoChuyenMon == 'Senior Leader') {
        seniorLeader ++;
      }
    }
    this.dataTrinhDoChuyenMon = [
      {
        label: 'Fresher',
        value: fresher.toString()
      },
      {
        label: 'Junior',
        value: junior.toString()
      },
      {
        label: 'Senior',
        value: senior.toString()
      },
      {
        label: 'Lead Dev',
        value: lead.toString()
      },
      {
        label: 'Mid-level Manager',
        value: midLevel.toString()
      },
      {
        label: 'Senior Leader',
        value: seniorLeader.toString()
      },
    ];
  }


  private setDataDSLuong(res: HoSo[]) {
    let duoi5tr = 0;
    let tu5trDen10tr = 0;
    let tu10Den15tr = 0;
    let tu15Den30tr = 0;
    let tu30trDen50tr = 0;
    let tren50tr = 0;

    for (let hoSo of res) {
      if (hoSo.luong < 5000000) {
        duoi5tr++;
      }
      else if (hoSo.luong <= 10000000) {
        tu5trDen10tr++;
      }
      else if (hoSo.luong <= 15000000) {
        tu10Den15tr++;
      }
      else if (hoSo.luong <= 30000000) {
        tu15Den30tr++;
      }
      else if (hoSo.luong <= 50000000) {
        tu30trDen50tr++;
      }
      else {
        tren50tr ++;
      }
    }
    this.dataLuong = [
      {
        label: 'Dưới 5 triệu',
        value: duoi5tr.toString()
      },
      {
        label: 'Từ 5 đến 10 triệu',
        value: tu5trDen10tr.toString()
      },
      {
        label: 'từ 10 đến 15 triệu',
        value: tu10Den15tr.toString()
      },
      {
        label: 'Từ 15 đến 30 triệu',
        value: tu15Den30tr.toString()
      },
      {
        label: 'Từ 30 đến 50 triệu',
        value: tu30trDen50tr.toString()
      },
      {
        label: 'Trên 50 triệu',
        value: tren50tr.toString()
      },
    ];
  }

  private chartDataLuong() {
    this.dataSourceLuong = {
      chart: {
        //Set the chart caption
        caption: "Thống kê theo Mức lương",
        //Set the x-axis name
        xAxisName: "Mức lương",
        //Set the y-axis name
        yAxisName: "Số lượng",
        //Set the theme for your chart
        theme: "fusion"
      },
      // Chart Data - from step 2
      data: this.dataLuong
    };
  }

  private setDataDSThang(res: HoSo[]) {
    let quy1 = 0;
    let quy2 = 0;
    let quy3 = 0;
    let quy4 = 0;
    let monthOfHoSo : any;
    for (let hoSo of res) {
      monthOfHoSo = parseInt(formatDate(hoSo.ngayLapHoSo, 'M', 'en-US').toString());
      console.log('Tháng: ' + monthOfHoSo);
      if (monthOfHoSo >= 1 && monthOfHoSo <= 3) {
        quy1++;
      }
      else if (monthOfHoSo > 3 && monthOfHoSo <= 6) {
        quy2++;
      }
      else if (monthOfHoSo > 6 && monthOfHoSo <= 9) {
        quy3++;
      }
      else if (monthOfHoSo > 9 && monthOfHoSo <= 12) {
        quy4++;
      }
    }
    this.dataNVThang = [
      {
        label: 'Tháng 1 - 3',
        value: quy1.toString()
      },
      {
        label: 'Tháng 4 - 6',
        value: quy2.toString()
      },
      {
        label: 'Tháng 7 - 9',
        value: quy3.toString()
      },
      {
        label: 'Tháng 10 - 12',
        value: quy4.toString()
      },
    ];
  }

  private chartDataThang() {
    this.dataSourceNhanVienThang = {
      chart: {
        //Set the chart caption
        caption: "Thống kê số lượng nhân viên vào công ty",
        //Set the x-axis name
        xAxisName: "Theo tháng",
        //Set the y-axis name
        yAxisName: "Số lượng",
        //Set the theme for your chart
        theme: "fusion"
      },
      // Chart Data - from step 2
      data: this.dataNVThang
    };
  }
}
