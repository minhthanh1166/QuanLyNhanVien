import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Taikhoan} from "../models/taikhoan";


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiServerUrl = "http://localhost:8080/api";
  constructor(private http: HttpClient) {
  }

  public getTaiKhoan(u: String, p: String): Observable<Taikhoan> {
    return this.http.post<Taikhoan>(`${this.apiServerUrl}/taikhoan?u=${u}&p=${p}`, null);
  }


  logout(): void {
    localStorage.setItem('isLoggedIn', 'false');
    localStorage.removeItem('token');
    localStorage.removeItem('pquyen');
  }
}
