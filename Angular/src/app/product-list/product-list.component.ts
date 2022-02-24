import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private productService: ProductService) { }

  public selected: string = 'ID';

  ngOnInit(): void {
    this.productService.findAll().subscribe(data => {
      this.products = data;
  });
  }

  changeState(){
    if (this.selected === 'Parameter') {
      this.products.sort((a, b) => (a.product_parameters > b.product_parameters) ? 1 : -1)
    }

    else if (this.selected === 'Name'){
      this.products.sort((a, b) => (a.product_name > b.product_name) ? 1 : -1)
    }
    else if (this.selected === 'ID'){
      this.products.sort((a, b) => (a.id > b.id) ? 1 : -1)
    }
    else{
      this.products.sort((a, b) => (a.product_size > b.product_size) ? 1 : -1)
    }
  }
}
