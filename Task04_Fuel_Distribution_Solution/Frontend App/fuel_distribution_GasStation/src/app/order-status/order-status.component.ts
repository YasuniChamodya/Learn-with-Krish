import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { StatusDetails } from '../Model/status-details';
import { OrderServiceService } from '../Service/order-service.service';
import Swal from 'sweetalert2';
import { ScheduleDetails } from '../Model/schedule-details';
@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.scss']
})
export class OrderStatusComponent implements OnInit {
  id = new FormControl();
  date = new FormControl();
  gasStation=new FormControl();

  data: StatusDetails = { allocation: "", orderId: 0, schedule: "",dispatch:"", orderStatusId: 0,diliver:"",diliverDate:"" }
  scheduleData: ScheduleDetails = { scheduleId: 0, date: "", time: "", orderId: 0 }
  orderData:any;

  constructor(private orderService: OrderServiceService) { }

  ngOnInit(): void {
  }

deliver(id:number){
this.orderService.deliverOrder(id).subscribe((result)=>{
  Swal.fire("Order mark as delivered",'','success');
  this.viewStatus();
})
}

  viewStatus() {
    if (this.id.value == null) {
      Swal.fire("Please enter id..", '', 'warning')
    } else {
      this.orderService.getStatus(this.id.value).subscribe((result) => {
        if (result.allocation == null) {
          Swal.fire("Check your id and try again.", '', 'error')
        }
        this.data = result;
        console.log(this.data);
        this.viewScheduleDetails();
        this.viewOrderDetaile();
      })
    }

  }

  viewScheduleDetails() {
    this.orderService.getScheduleData(this.id.value).subscribe((result) => {
      this.scheduleData = result;
      this.date.setValue("Date: " + result.date + " Time: " + result.time);
    })
  }

  viewOrderDetaile(){
    this.orderService.getOrderDetails(this.id.value).subscribe((result)=>{
      this.orderData=result;
      this.gasStation.setValue(result.name);
    })
  }



}
