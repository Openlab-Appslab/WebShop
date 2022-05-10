import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductFormComponent} from "./product-form/product-form.component";
import { LoginComponent } from './component/login/login.component';
import {AuthGuard} from "./guard/auth.guard";
import {LastThreeComponent} from "./last-three/last-three.component";
import {ProductListDetailComponent} from "./product-list-detail/product-list-detail.component";
import {IdealStickComponent} from "./ideal-stick/ideal-stick.component";
import {InformationPageComponent} from "./information-page/information-page.component";
import {FeedbackComponent} from "./feedback/feedback.component";

const routes: Routes = [
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'addproducts', component: ProductFormComponent, canActivate: [AuthGuard] },
  { path: 'lastthree', component: LastThreeComponent },
  { path: 'detail/:id', component: ProductListDetailComponent },
  { path: 'idealstick', component: IdealStickComponent },
  { path: 'infoaboutsport', component: InformationPageComponent },
  { path: 'contact', component: FeedbackComponent },
  { path: 'contact', component: FeedbackComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
