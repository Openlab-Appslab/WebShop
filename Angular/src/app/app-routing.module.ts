import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductFormComponent} from "./product-form/product-form.component";
import { LoginComponent } from './component/login/login.component';
import {AuthGuard} from "./guard/auth.guard";

const routes: Routes = [
  { path: '', component: ProductListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'products', component: ProductListComponent},
  { path: 'addproducts', component: ProductFormComponent, canActivate: [AuthGuard] },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
