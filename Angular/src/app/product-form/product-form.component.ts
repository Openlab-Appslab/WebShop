import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { Product } from '../product';
import {ProductService} from "../product.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {

  product: Product;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService){
    this.product = new Product();
  }

  onSubmit() {
    this.productService.save(this.product).subscribe(() => this.gotoProductList());
  }

  gotoProductList() {
    this.router.navigate(['/products']);
  }

  onlyNumbers($event: any) {
    let inputChar = String.fromCharCode($event.charCode);
    if (!/^[0-9]*$/.test(inputChar)) {
      $event.preventDefault();
    }
  }

  onlyNumbersAndSubmit($event: any) {
    if ($event.keyCode != 13) {
      let inputChar = String.fromCharCode($event.charCode);
      if (!/^[0-9]*$/.test(inputChar)) {
        $event.preventDefault();
      }
    }
    else if ($event.keyCode === 13 && this.product.productSize && this.product.productParameters && this.product.productName && this.product.weightOfCustomer && this.product.heightOfCustomer) {
      this.onSubmit();
    }

    else if ($event.keyCode === 13 && (!this.product.productSize || !this.product.productParameters || !this.product.productName || !this.product.weightOfCustomer || !this.product.heightOfCustomer)) {
      alert('Please fill all inputs');
    }
  }
}
