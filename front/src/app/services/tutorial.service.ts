import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class TutorialService {
  private apiBaseUrl = "http://localhost:8088";

  constructor(private http: HttpClient) {}

  getPages() {
    return this.http.get(`${this.apiBaseUrl}/pages/all`);
  }

  getPageByCat(category: any) {
    return this.http.get(`${this.apiBaseUrl}/pages/category/${category}`);
  }

  addPage(page: any) {
    return this.http.post(`${this.apiBaseUrl}/pages`, page);
  }
}
