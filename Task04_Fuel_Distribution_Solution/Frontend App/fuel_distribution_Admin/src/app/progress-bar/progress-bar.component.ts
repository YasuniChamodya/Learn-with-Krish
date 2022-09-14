import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {
 
  color: string = ''
  @Input() progress: number=0;
  constructor() { }

  ngOnInit(): void {
    if (this.progress < 0 || this.progress > 100) {
      this.progress = 0;
    }

    if (this.progress < 30) {
      this.color = 'red'
    } else if (this.progress < 60) {
      this.color = 'yellow'
    } else {
      this.color = 'green'
    }
  }

}
