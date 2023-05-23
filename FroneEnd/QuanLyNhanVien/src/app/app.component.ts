import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import * as $ from 'jquery';


// @ts-ignore
// @ts-ignore
// @ts-ignore
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'QuanLyNhanVien';

  constructor(private location: Location) {

  }

  ngOnInit(): void {

    let arrow = document.querySelectorAll(".arrow");
    for (var i = 0; i < arrow.length; i++) {
      arrow[i].addEventListener("click", (e) => {
        // @ts-ignore
        let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
      });
    }
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".bx-menu");
    console.log(sidebarBtn);
    // @ts-ignore
    sidebarBtn.addEventListener("click", () => {
      // @ts-ignore
      sidebar.classList.toggle("close");
    });


    console.log(this.location.path());
    this.handleShowHide();
    this.handleShowHide2()
    this.showUserPermision();
  }



  public handleShowHide() {
    if(this.location.path() === "/login") {
      $(document).ready(function () {
        $(".home-section").css("background-color", "#fff");
        $(".home-content").css("display", "none");
      });
    }
  }





  public handleShowHide2() {
    if(this.location.path() === "/home") {
      $(document).ready(function () {
        $(".home-section").css("background-color", "#e4e9f7");
        $(".home-content").css("display", "block");
      });

    }
  }


  // @ts-ignore
  hideSideBar() : boolean{
      return !window.localStorage.getItem('token')
  }

  public showUserName() : string {
    return (window.localStorage.getItem('token') || '').toString();
  }
  public showUserPermision() : string {
    let quyen =  parseInt((window.localStorage.getItem('pquyen') || '').toString());
    if(quyen === 1) {
      return 'Quản trị viên'
    }
    else if(quyen === 2) {
      return 'Nhân viên quản lý';
    }else if(quyen === 3) {
      return 'Nhân viên';
    }
    else {
      return 'Chưa xác định';
    }
  }
}
