import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../product";
import {ProductService} from "../product.service";

@Component({
  selector: 'app-product-list-detail',
  templateUrl: './product-list-detail.component.html',
  styleUrls: ['./product-list-detail.component.css']
})
export class ProductListDetailComponent implements OnInit {

  detailId: number;
  product: Product;

  constructor(private route: ActivatedRoute, private productService: ProductService) {
    this.detailId = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.productService.findAll().subscribe(data => {
      this.product = data.find(product => product.id === this.detailId);
    });
  }
}
