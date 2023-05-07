import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DuAn} from "../models/duan";
import {HoSo} from "../models/hoso";


@Injectable({
  providedIn: 'root',
})

export class DuanService {
  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}


  public listDuAn(): Observable<DuAn[]> {
    return this.http.get<DuAn[]>(`${this.apiServerUrl}/duan/list`);
  }

  public getDuAnById(id: number): Observable<DuAn> {
    return this.http.get<DuAn>(`${this.apiServerUrl}/duan/${id}`);
  }

  public addDuAn(obj: DuAn): Observable<DuAn> {
    return this.http.post<DuAn>(`${this.apiServerUrl}/duan/add`, obj);
  }

  public updateDuAn(objId: number | undefined, obj: DuAn): Observable<DuAn> {
    return this.http.put<DuAn>(`${this.apiServerUrl}/duan/${objId}`, obj);
  }

  public deleteDuAn(objId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/duan/${objId}`);
  }

  public deleteNhanVien(duAnID: number, nhanVienSelected: number[]): Observable<DuAn> {
    return this.http.put<DuAn>(`${this.apiServerUrl}/duan/delete/nhanvien?idda=${duAnID}`, nhanVienSelected);
  }

  public updateHoSoDuAn(id: number, manhanVien: number[]): Observable<DuAn> {
    return this.http.put<DuAn>(`${this.apiServerUrl}/duan/addnhanvien?id=${id}`, manhanVien);
  }
}


