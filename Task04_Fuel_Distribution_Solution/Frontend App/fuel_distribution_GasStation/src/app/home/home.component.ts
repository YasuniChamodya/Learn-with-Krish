import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {



  constructor(private router:Router){

  }

  ngOnInit(): void {
  }

    loadgas_station(){
   console.log("Kalpa");
    this.router.navigate(['create_order'])
  }

  load_user(){
    this.router.navigate(['user'])
  }
}
