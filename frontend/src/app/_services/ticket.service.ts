import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Ticket } from '../_model/ticket';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class TicketService {
  private baseUrl = environment.apiUrl + '/ticket/';

  constructor(private http: HttpClient) {}

  getTicket(id: string): Observable<Ticket> {
    return this.http.get<Ticket>(this.baseUrl + id);
  }
}
