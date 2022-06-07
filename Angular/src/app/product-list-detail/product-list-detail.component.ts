import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../product";
import {ProductService} from "../product.service";
import {AuthService} from "../service/auth.service";
import {Rating} from "../rating";

@Component({
  selector: 'app-product-list-detail',
  templateUrl: './product-list-detail.component.html',
  styleUrls: ['./product-list-detail.component.css']
})
export class ProductListDetailComponent implements OnInit {

  detailId: number;
  product: Product;
  currentRate: number = 0;
  rating: Rating;
  averageRating: number;

  constructor(private route: ActivatedRoute, private productService: ProductService, private authService: AuthService) {
    this.detailId = +this.route.snapshot.paramMap.get('id');
    this.rating = new Rating();
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.productService.findAll().subscribe(data => {
      this.product = data.find(product => product.id === this.detailId);
    });
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  sendRating() {
    this.rating.numberOfStar = this.currentRate;
    this.productService.sendRating(this.rating.numberOfStar, this.product).subscribe(data => {
    });
    this.findAll();
  }
}
