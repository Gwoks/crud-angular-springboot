export class Order {
  id: number;
  ticketId: number;
  customerId: number;
  buy: number;

  constructor(ticketId: number, customerId: number, buy: number) {
    this.ticketId = ticketId;
    this.customerId = customerId;
    this.buy = buy;
  }
}
