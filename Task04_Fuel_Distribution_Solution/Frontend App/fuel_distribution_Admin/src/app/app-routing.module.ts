import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';
import { DispatchedOrdersComponent } from './dispatched-orders/dispatched-orders.component';
import { HomeComponent } from './home/home.component';
import { DeliveredOrdersComponent } from './delivered-orders/delivered-orders.component';
const routes: Routes = [
  {path:'dispatch',component:DispatchOrderComponent},
  {path:'dispatched_orders',component:DispatchedOrdersComponent},
  {path:'home',component:HomeComponent},
  {path:'',component:HomeComponent},
  {path:'delivered_orders',component:DeliveredOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
