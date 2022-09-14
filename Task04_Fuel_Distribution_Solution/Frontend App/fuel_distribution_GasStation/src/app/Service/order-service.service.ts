import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { Order } from '../Model/order';
import { OrderDetails } from '../Model/order-details';
import { ScheduleDetails } from '../Model/schedule-details';
import { StatusDetails } from '../Model/status-details';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {

  constructor(private http: HttpClient) { }

  readonly ROOT_URL = "http://localhost:8081/order";
  // posts:any

  viewAllOrders() {

    return this.http.get(this.ROOT_URL).pipe(catchError(this.handleError));

  }

  saveOrder(data: Order): Observable<Order> {
    return this.http.post<Order>(this.ROOT_URL, data).pipe(catchError(this.handleError));
  }


  getStatus(id: number): Observable<StatusDetails> {
    console.log(id)
    let url = "http://localhost:8081/statusid?id=";
    return this.http.get<StatusDetails>(url + "" + id).pipe(catchError(this.handleError));

  }

  getScheduleData(id: number): Observable<ScheduleDetails> {
    let url = "http://localhost:8081/schedule?id=";
    return this.http.get<ScheduleDetails>(url + "" + id).pipe(catchError(this.handleError));
  }

  getOrderDetails(id: number): Observable<Order> {
    let url = "http://localhost:8081/orderid?id=";
    return this.http.get<Order>(url + "" + id).pipe(catchError(this.handleError));
  }

  deliverOrder(id: number): Observable<StatusDetails> {
    let url = "http://localhost:8081/delivery?id=";
    return this.http.get<StatusDetails>(url + "" + id).pipe(catchError(this.handleError));
  
  }

  getAllOrdersByStationId(id:string):Observable<OrderDetails>{
    let url="http://localhost:8081/gas_station_orders?id=";
    return this.http.get<OrderDetails>(url+""+id).pipe(catchError(this.handleError));
   }




  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      Swal.fire("An error occurred: " + error.error, '', 'warning');
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    Swal.fire("Something bad happened; please try again later.", '', 'error');
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
