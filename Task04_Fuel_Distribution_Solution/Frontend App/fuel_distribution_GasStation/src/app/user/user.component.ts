import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { OrderServiceService } from '../Service/order-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  myOrders: any
  id = new FormControl();
  constructor(private orderService: OrderServiceService) { }

  ngOnInit(): void {
  }

  ViewDetails() {
    if (this.id.value == null) {
      Swal.fire("Please enter id..", '', 'warning')
    } else {

      this.orderService.getAllOrdersByStationId(this.id.value).subscribe((result) => {
        console.log(result);
       
        this.myOrders = result;
        if(this.myOrders==0){
          Swal.fire("Check your id and try again.", '', 'error')
        }

      })
    }

  }

}
