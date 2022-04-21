import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product.service";
import {Product} from "../product";

@Component({
  selector: 'app-ideal-stick',
  templateUrl: './ideal-stick.component.html',
  styleUrls: ['./ideal-stick.component.css']
})
export class IdealStickComponent implements OnInit {
  weight: number;
  height: number;
  products: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getIdeal().subscribe(data => {
      this.products = data;
    });
  }

  calculate() {
    this.productService.ideal(this.weight, this.height);
    this.productService.getIdeal().subscribe(data => {
      this.products = data;
    });
  }
}
