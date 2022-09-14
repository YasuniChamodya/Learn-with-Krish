import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { Dispatch } from '../Model/dispatch';
import { Order } from '../Model/order';
import { OrderDetails } from '../Model/order-details';
import { ScheduleDetails } from '../Model/schedule-details';
import { StatusDetails } from '../Model/status-details';
import{Stock} from '../Model/stock';

@Injectable({
  providedIn: 'root'
})
export class DispatchServiceService {

  constructor(private http: HttpClient) { }

  getAllOrderDetails():Observable<OrderDetails>{
   let url="http://localhost:8081/orderData";
   return this.http.get<OrderDetails>(url).pipe(catchError(this.handleError));
  }

  getAllDispatchDetails():Observable<OrderDetails>{
    let url="http://localhost:8081/dispatched_orders";
    return this.http.get<OrderDetails>(url).pipe(catchError(this.handleError));
   }

   getAllDeliveredDetails():Observable<OrderDetails>{
    let url="http://localhost:8081/delivered_orders";
    return this.http.get<OrderDetails>(url).pipe(catchError(this.handleError));
   }


  getStatus(id: number): Observable<StatusDetails> {
    console.log(id)
    let url = "http://localhost:8081/statusid?id=";
    return this.http.get<StatusDetails>(url + "" + id).pipe(catchError(this.handleError));

  }

  getScheduleData(id: number):Observable<ScheduleDetails> {
    let url = "http://localhost:8081/schedule?id=";
    return this.http.get<ScheduleDetails>(url + "" + id).pipe(catchError(this.handleError));
  }

  getOrderDetails(id:number):Observable<Order>{
    let url="http://localhost:8081/orderid?id=";
    return this.http.get<Order>(url + "" + id).pipe(catchError(this.handleError));
  }
  
  dispatchOrder(id:number,fuelStationId:string){
    console.log(id);
    console.log(fuelStationId)
    let url="http://localhost:8080/dispatch";
    
    return this.http.post(url, {gasStationId:fuelStationId,orderId:id,status:'Dispatch'}).pipe(catchError(this.handleError));

  }

  availableStock():Observable<Stock>{
    let url="http://localhost:8080/stock";
    return this.http.get<Stock>(url).pipe(catchError(this.handleError));

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
