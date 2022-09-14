import { Component, OnInit } from '@angular/core';
import { DispatchServiceService } from '../Service/dispatch-service.service';

@Component({
  selector: 'app-dispatched-orders',
  templateUrl: './dispatched-orders.component.html',
  styleUrls: ['./dispatched-orders.component.scss']
})
export class DispatchedOrdersComponent implements OnInit {
  Dispatched_orders:any

  constructor(private dispatchService: DispatchServiceService) { 
    this.loadDetails();
  }

  ngOnInit(): void {
  }

  loadDetails(){
    this.dispatchService.getAllDispatchDetails().subscribe((result)=>{
      console.log(result);
      this.Dispatched_orders=result;
    })
  }

}
