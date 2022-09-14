import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ScheduleDetails } from '../Model/schedule-details';
import { StatusDetails } from '../Model/status-details';
import { DispatchServiceService } from '../Service/dispatch-service.service';

@Component({
  selector: 'app-dispatch-order',
  templateUrl: './dispatch-order.component.html',
  styleUrls: ['./dispatch-order.component.scss']
})
export class DispatchOrderComponent implements OnInit {
  id = new FormControl();

  data: StatusDetails = { allocation: "", orderId: 0, schedule: "", orderStatusId: 0 }
  scheduleData: ScheduleDetails = { scheduleId: 0, date: "", time: "", orderId: 0 }
  orderData: any;
  OrderDetails: any;


  constructor(private router: Router, private dispatch_service: DispatchServiceService) {
    this.loadDetails();
  }

  ngOnInit(): void {


  }
  loadDetails() {
    this.dispatch_service.getAllOrderDetails().subscribe((result) => {
      
      this.OrderDetails = result;
     
    })
  }



  viewStatus() {
    if (this.id.value == null) {
      // Swal.fire("Please enter id..", '', 'warning')
    } else {
      this.dispatch_service.getStatus(this.id.value).subscribe((result) => {
        if (result.allocation == null) {
          // Swal.fire("Check your id and try again.", '', 'error')
        }
        this.data = result;
        this.viewScheduleDetails();
        this.viewOrderDetaile();
      })
    }

  }

  viewScheduleDetails() {
    this.dispatch_service.getScheduleData(this.id.value).subscribe((result) => {
      this.scheduleData = result;

    })
  }

  viewOrderDetaile() {
    this.dispatch_service.getOrderDetails(this.id.value).subscribe((result) => {
      this.orderData = result;

    })
  }

  dispatch(id: number, fuelStationId: string) {



    this.dispatch_service.dispatchOrder(id, fuelStationId).subscribe((result) => {

      this.loadDetails();
      Swal.fire("Order dispatched", '', 'success');

    })

   
 
  }

 

}
