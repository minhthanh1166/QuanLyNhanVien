import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DanToc} from "../models/dantoc";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class DantocService {
  private apiServerUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {
  }

  public listDanToc(): Observable<DanToc[]> {
    return this.http.get<DanToc[]>(`${this.apiServerUrl}/dantoc/list`);
  }

  public addDanToc(obj: DanToc): Observable<DanToc> {
    return this.http.post<DanToc>(`${this.apiServerUrl}/dantoc/add`, obj);
  }

  public updateDanToc(objId: number, obj: DanToc): Observable<DanToc> {
    return this.http.put<DanToc>(`${this.apiServerUrl}/dantoc/${objId}`, obj);
  }

  public deleteDanToc(objId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/dantoc/${objId}`);
  }
}
