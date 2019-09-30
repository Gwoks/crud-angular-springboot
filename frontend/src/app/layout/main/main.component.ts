import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Customer } from 'src/app/_model/customer';
import { Ticket } from 'src/app/_model/ticket';
import { Order } from 'src/app/_model/order';
import { CustomerService } from 'src/app/_services/customer.service';
import { OrderService } from 'src/app/_services/order.service';
import { TicketService } from 'src/app/_services/ticket.service';
import { ResponseModel } from 'src/app/_model/response';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  customer: Customer;
  ticket: Ticket;
  orders: Order;
  responseModel: ResponseModel;
  customers: Customer[];
  tickets: Ticket[];

  constructor(
    private customerService: CustomerService,
    private orderService: OrderService,
    private ticketService: TicketService
  ) {}

  customerId = new FormControl('', Validators.required);
  filmId = new FormControl('', Validators.required);
  filmBuy = new FormControl('', Validators.required);

  ngOnInit() {
    this.customerService.getAllCustomer().subscribe(cs => {
      this.customers = cs;
    });

    this.ticketService.getAllTicket().subscribe(ts => {
      this.tickets = ts;
    });
  }

  onSubmit() {
    let ticketId: number = this.filmId.value;
    let customerId: number = this.customerId.value;
    let buy: number = this.filmBuy.value;

    this.orderService
      .postOrder(new Order(ticketId, customerId, buy))
      .subscribe(response => (this.responseModel = response));
  }

  onReset() {
    this.customerId.reset();
    this.filmId.reset();
    this.filmBuy.reset();
  }

  customerSearch() {
    let id = this.customerId.value;
    this.customer = this.findCustomerById(id, this.customers);
    console.log(this.customers.find(x => x.id === id));
  }

  filmSearch() {
    let id = this.filmId.value;
    this.ticket = this.findTicketById(id, this.tickets);
    console.log(this.tickets.find(x => x.id === id));
  }

  findCustomerById(id: number, customers: Customer[]): Customer {
    return customers.find(x => x.id === id);
  }

  findTicketById(id: number, tickets: Ticket[]): Ticket {
    return tickets.find(x => x.id === id);
  }
}
