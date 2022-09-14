import { Component, OnInit } from '@angular/core';
import { DispatchServiceService } from '../Service/dispatch-service.service';

@Component({
  selector: 'app-delivered-orders',
  templateUrl: './delivered-orders.component.html',
  styleUrls: ['./delivered-orders.component.scss']
})
export class DeliveredOrdersComponent implements OnInit {
DeliveredOrders:any;
  constructor(private dispatchService: DispatchServiceService) { }

  ngOnInit(): void {
    this.loadDetails();
  }

  loadDetails(){
    this.dispatchService.getAllDeliveredDetails().subscribe((result)=>{
      console.log(result);
      this.DeliveredOrders=result;
    })
  }

}
