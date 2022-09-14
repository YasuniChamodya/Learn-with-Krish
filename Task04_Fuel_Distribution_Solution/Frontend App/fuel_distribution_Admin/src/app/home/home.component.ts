import { Component, OnInit } from '@angular/core';
import { DispatchServiceService } from '../Service/dispatch-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
stock:any

  constructor(private dispatchService: DispatchServiceService) { 
    this.loadDetails();
  }

  ngOnInit(): void {
  }

  
  loadDetails(){
    this.dispatchService.availableStock().subscribe((result)=>{
     
      
      this.stock=result;
    })
  }

}
