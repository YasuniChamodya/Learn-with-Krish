import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { GasStationComponent } from './gas-station/gas-station.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { UserComponent } from './user/user.component';
import { ViewAllOrdersComponent } from './view-all-orders/view-all-orders.component';
import { OrderStatusComponent } from './order-status/order-status.component';
const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'',component:HomeComponent},
  {path:'gas_station',component:GasStationComponent},
  {path:'create_order/:id',component:CreateOrderComponent},
  {path:'user/:id',component:UserComponent},
  {path:'viewAll/:id',component:ViewAllOrdersComponent},
  {path:'viewStatus/:id',component:OrderStatusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
