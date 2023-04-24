import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Nhom} from "../models/nhom";

@Injectable({
  providedIn: "root"
})
export class NhomService {
  private apiServerUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {
  }

  public listNhom(): Observable<Nhom[]> {
    return this.http.get<Nhom[]>(`${this.apiServerUrl}/nhom`);
  }

  public updateNhom(maNhom: String, nhom: Nhom): Observable<Nhom> {
    return this.http.put<Nhom>(`${this.apiServerUrl}/nhom/${maNhom}`, nhom);
  }

  public insertNhom(nhom: Nhom): Observable<Nhom> {
    return this.http.post<Nhom>(`${this.apiServerUrl}/nhom`, nhom);
  }

  public deleteNhomById(nhomByID: String): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/nhom/${nhomByID}`);
  }
}
