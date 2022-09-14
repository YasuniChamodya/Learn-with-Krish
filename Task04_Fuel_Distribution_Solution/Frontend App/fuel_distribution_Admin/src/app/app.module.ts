import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule}from'@angular/common/http';
import { DispatchServiceService } from './Service/dispatch-service.service';
import { DispatchedOrdersComponent } from './dispatched-orders/dispatched-orders.component';
import { HomeComponent } from './home/home.component';
import { DeliveredOrdersComponent } from './delivered-orders/delivered-orders.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DispatchOrderComponent,
    DispatchedOrdersComponent,
    HomeComponent,
    DeliveredOrdersComponent,
    ProgressBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [DispatchServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
