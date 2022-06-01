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
    this.average();
  }

  findAll(): void {
    this.productService.findAll().subscribe(data => {
      this.product = data.find(product => product.id === this.detailId);
    });
  }

  average(): void{
    if (this.product.ratingAverage >= 0.5 && this.product.ratingAverage < 1.5){
      this.averageRating = 1;
    }
    else if (this.product.ratingAverage >= 1.5 && this.product.ratingAverage < 2.5){
      this.averageRating = 2;
    }
    else if (this.product.ratingAverage >= 2.5 && this.product.ratingAverage < 3.5){
      this.averageRating = 3;
    }
    else if (this.product.ratingAverage >= 3.5 && this.product.ratingAverage < 4.5){
      this.averageRating = 4;
    }
    else if (this.product.ratingAverage >= 4.5){
      this.averageRating = 5;
    }
    else{
      this.averageRating = 0;
    }
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  sendRating() {
    this.rating.numberOfStar = this.currentRate;
    this.productService.sendRating(this.rating.numberOfStar, this.product).subscribe(data => {
    });
    this.findAll();
    this.average();
  }
}
