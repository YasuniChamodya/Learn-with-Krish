import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
id:number=0;

  constructor(  private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let type=this.route.snapshot.paramMap.get('id');
    console.log(type);
    
    if(type=='admin'){
      this.id=10;
    }else if(type=='user'){
      this.id=20;
    }
   
  }

}
