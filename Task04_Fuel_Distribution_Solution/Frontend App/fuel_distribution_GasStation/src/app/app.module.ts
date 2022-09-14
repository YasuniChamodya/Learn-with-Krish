import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { GasStationComponent } from './gas-station/gas-station.component';
import { UserComponent } from './user/user.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule}from'@angular/common/http';
import { ViewAllOrdersComponent } from './view-all-orders/view-all-orders.component';
import { OrderServiceService } from './Service/order-service.service';
import { OrderStatusComponent } from './order-status/order-status.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    GasStationComponent,
    UserComponent,
    CreateOrderComponent,
    NavbarComponent,
    ViewAllOrdersComponent,
    OrderStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [OrderServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
