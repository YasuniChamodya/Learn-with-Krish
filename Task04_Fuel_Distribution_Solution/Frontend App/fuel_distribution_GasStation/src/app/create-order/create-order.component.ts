import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Order } from '../Model/order';
import { OrderServiceService } from '../Service/order-service.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.scss']
})
export class CreateOrderComponent implements OnInit {
  ordercreate = new FormGroup({
    fuelStationId: new FormControl(''),
    name: new FormControl(''),
    address: new FormControl(''),
    mobile: new FormControl(''),
    stockId: new FormControl(''),
    qty: new FormControl('')
  })




  order: any;
  responseOrder: any;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute, private orderService: OrderServiceService) { }

  ngOnInit(): void {

  }

  save(data: Order) {

console.log(data.fuelStationId);

    if (data.fuelStationId == "" || data.qty == "" || data.stockId == "" || data.address =="") {
      Swal.fire("Fill the form first", '', 'warning');
    } else {
      console.log(data);
      this.orderService.saveOrder(data).subscribe((result) => {
        console.log(result.address);

        // const response=JSON.parse(result.toString());
        //  console.log(response.id);
        this.setEmptyFields();
        Swal.fire("Your order is completed. Your order Ref id is " + result.id + ". Now you can track your order using Ref id.", '', 'success');
      })
    }
  }

  setEmptyFields(){
    this.ordercreate = new FormGroup({
      fuelStationId: new FormControl(''),
      name: new FormControl(''),
      address: new FormControl(''),
      mobile: new FormControl(''),
      stockId: new FormControl(''),
      qty: new FormControl('')
    })
  }

}
