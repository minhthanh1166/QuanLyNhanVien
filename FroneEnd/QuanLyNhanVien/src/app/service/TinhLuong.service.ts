import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TinhLuong} from "../models/TinhLuong";


@Injectable({
  providedIn: "root"
})
export class TinhLuongService {
  private apiServerUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}


  public listTinhLuong(): Observable<TinhLuong[]> {
    return this.http.get<TinhLuong[]>(`${this.apiServerUrl}/tinhluong/list`);
  }

  public listTinhLuongByHoSo(mahs : number): Observable<TinhLuong[]> {
    return this.http.get<TinhLuong[]>(`${this.apiServerUrl}/tinhluong/list?mahs=${mahs}`);
  }

  public listTinhLuongByDonVi(madv : string): Observable<TinhLuong[]> {
    return this.http.get<TinhLuong[]>(`${this.apiServerUrl}/tinhluong/list?madv=${madv}`);
  }

  public listTinhLuongByPhongBan(mapb : number): Observable<TinhLuong[]> {
    return this.http.get<TinhLuong[]>(`${this.apiServerUrl}/tinhluong/list?mapb=${mapb}`);
  }

  public addTinhLuong(obj: TinhLuong): Observable<TinhLuong> {
    return this.http.post<TinhLuong>(`${this.apiServerUrl}/tinhluong/add`, obj);
  }

  public updateTinhLuong(objId: number, obj: TinhLuong): Observable<TinhLuong> {
    return this.http.put<TinhLuong>(`${this.apiServerUrl}/tinhluong/${objId}`, obj);
  }

  public deleteTinhLuong(objId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/tinhluong/${objId}`);
  }
}

