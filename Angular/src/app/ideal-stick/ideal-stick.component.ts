import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product.service";
import {Parameters} from "../parameters";
import {Product} from "../product";
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-ideal-stick',
  templateUrl: './ideal-stick.component.html',
  styleUrls: ['./ideal-stick.component.css']
})
export class IdealStickComponent implements OnInit {
  parameters: Parameters;
  products: Product[];

  constructor(private productService: ProductService, private authService: AuthService) {
    this.parameters = new Parameters();
  }

  ngOnInit(): void {
  }

  calculate() {
    this.productService.ideal(this.parameters).subscribe();
    setTimeout(() => {
      this.productService.getIdeal().subscribe(data => {
        this.products = data;
      });
    }, 10);
  }

  lastTree(product: Product) {
    this.productService.lastOne(product).subscribe(() => {
    });
  }

  isAdminLoggedIn() {
    return this.authService.isLoggedIn();
  }

  deleteProduct(product: Product) {
    this.productService.delete(product).subscribe(
      data => {
        this.products = this.products.filter(u => u !== product);
      },
      error => {
        console.log(error);
      });
  }
}
