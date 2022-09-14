import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { OrderServiceService } from '../Service/order-service.service';


@Component({
  selector: 'app-view-all-orders',
  templateUrl: './view-all-orders.component.html',
  styleUrls: ['./view-all-orders.component.scss']
})
export class ViewAllOrdersComponent implements OnInit {
  // readonly ROOT_URL="http://localhost:8081/order";
   posts:any

  constructor(private http: HttpClient, private router: Router, private orderService: OrderServiceService) {
   console.log(  this.getAllOrders());
  //  console.log(this.posts);
   }

   getAllOrders() {
    // this.posts=this.http.get(this.ROOT_URL).pipe(
    //      catchError(this.handleError)
    // );
   this.orderService.viewAllOrders().subscribe((data)=>{
        this.posts=data;
        console.log(this.posts);
   });

  }

  // private handleError(error: HttpErrorResponse) {
  //   if (error.status === 0) {
  //     // A client-side or network error occurred. Handle it accordingly.
  //     Swal.fire("An error occurred: "+error.error, '','warning');
  //     console.error('An error occurred:', error.error);
  //   } else {
  //     // The backend returned an unsuccessful response code.
  //     // The response body may contain clues as to what went wrong.
  //     console.error(
  //       `Backend returned code ${error.status}, body was: `, error.error);
  //   }
  //   // Return an observable with a user-facing error message.
  //   Swal.fire("Something bad happened; please try again later.",'','error');
  //   return throwError(() => new Error('Something bad happened; please try again later.'));
  // }


  ngOnInit(): void {
  }


}
