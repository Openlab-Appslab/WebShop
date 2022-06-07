import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { Product } from '../product';
import {ProductService} from "../product.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {

  product: Product;
  uploadedImage: File;
  dbImage: any;
  postResponse: any;
  successResponse: string;
  image: any;
  public selected: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private httpClient: HttpClient
  ){
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
      $event.preventDefault();
      this.onSubmit();
    }

    else if ($event.keyCode === 13 && (!this.product.productSize || !this.product.productParameters || !this.product.productName || !this.product.weightOfCustomer || !this.product.heightOfCustomer)) {
      alert('Please fill all inputs');
    }
  }

  public onImageUpload({event}: { event: any }) {
    this.uploadedImage = event.target.files[0];
  }
  imageUploadAction() {
    const imageFormData = new FormData();
    imageFormData.append('image', this.uploadedImage, this.uploadedImage.name);


    this.httpClient.post('http://localhost:8080/upload/image/', imageFormData, { observe: 'response' })
      .subscribe((response) => {
          if (response.status === 200) {
            this.postResponse = response;
            this.successResponse = this.postResponse.body.message;
          } else {
            this.successResponse = 'Image not uploaded due to some error!';
          }
        }
      );
  }

  changeState() {
    if (this.selected === 'Stick') {
      this.product.switchOfProduct = 1;
    } else if (this.selected === 'Ball') {
      this.product.switchOfProduct = 2;
    } else if (this.selected === 'Helmet') {
      this.product.switchOfProduct = 3;
    }
  }

}
