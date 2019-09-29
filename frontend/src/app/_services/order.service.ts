import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Order } from '../_model/order';
import { ResponseModel } from '../_model/response';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class OrderService {
  private baseUrl = environment.apiUrl + '/orders/';

  constructor(private http: HttpClient) {}

  postOrder(value: Order): Observable<ResponseModel> {
    return this.http.post<ResponseModel>(this.baseUrl, value, httpOptions);
  }
}
