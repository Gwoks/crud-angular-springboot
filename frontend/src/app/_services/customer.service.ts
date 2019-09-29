import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Customer } from '../_model/customer';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class CustomerService {
  private baseUrl = environment.apiUrl + '/customer/';

  constructor(private http: HttpClient) {}

  getCustomer(id: string): Observable<Customer> {
    return this.http.get<Customer>(this.baseUrl + id);
  }

}
