import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import * as $ from 'jquery';


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
    this.handleShowHide()
  }

  public handleShowHide() {
    if(this.location.path() === "/home"){
      // $("#login-hide").css("display", "none");
      $(document).ready(function (){
        $("#login-hide").css("display", "none");

        // $('#login-hide').css("background-color", "red");
      });
    }
  }


  // @ts-ignore
  hideSideBar() : boolean{
      return !window.localStorage.getItem('token')

  }

}
