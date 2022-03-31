import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductFormComponent} from "./product-form/product-form.component";
import { LoginComponent } from './component/login/login.component';
import {AuthGuard} from "./guard/auth.guard";
import {LastThreeComponent} from "./last-three/last-three.component";
import {ProductListDetailComponent} from "./product-list-detail/product-list-detail.component";

const routes: Routes = [
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'addproducts', component: ProductFormComponent, canActivate: [AuthGuard] },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent, canActivate: [AuthGuard] },
  { path: 'lastthree', component: LastThreeComponent },
  { path: 'detail/:id', component: ProductListDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
