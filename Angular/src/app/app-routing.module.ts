import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductFormComponent} from "./product-form/product-form.component";

const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: 'addproducts', component: ProductFormComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
