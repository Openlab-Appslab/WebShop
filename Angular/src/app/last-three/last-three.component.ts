import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import { ProductService } from '../product.service';

@Component({
  selector: 'app-last-three',
  templateUrl: './last-three.component.html',
  styleUrls: ['./last-three.component.css']
})
export class LastThreeComponent implements OnInit {

  products: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.lastThree().subscribe(data => {
      this.products = data;
    });
  }

}
