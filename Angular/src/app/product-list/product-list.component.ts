import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import { AuthService } from '../service/auth.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private route: ActivatedRoute, private productService: ProductService, private authService: AuthService) {
  }

  public selected: string = 'ID';
  public isVisible: boolean = false;
  min_value: any;
  max_value: any;
  check_min_state: boolean = false;
  check_max_state: boolean = false;
  toggle_name: string = "Filter size";
  averageRating: number;
  product: Product;


  ngOnInit(): void {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  changeState() {
    if (this.selected === 'Parameter') {
      this.products.sort((a, b) => (a.productParameters > b.productParameters) ? 1 : -1)
    } else if (this.selected === 'Name') {
      this.products.sort((a, b) => (a.productName > b.productName) ? 1 : -1)
    } else if (this.selected === 'ID') {
      this.products.sort((a, b) => (a.id > b.id) ? 1 : -1)
    } else {
      this.products.sort((a, b) => (a.productSize > b.productSize) ? 1 : -1)
    }
  }

  toggle() {
    this.isVisible = !this.isVisible;
    if (this.isVisible)
      this.toggle_name = "Hide filter";
    else
      this.toggle_name = "Filter size";
  }

  filterSize() {
    if (this.check_min_state && this.check_max_state) {
      this.products = this.products.filter(value => value.productSize >= this.min_value);
      this.products = this.products.filter(value => value.productSize <= this.max_value);
    }
  }

  onMaxChange(value: any) {
    this.max_value = value;
    this.check_max_state = this.max_value != '';
  }

  onMinChange(value: any) {
    this.min_value = value;
    this.check_min_state = this.min_value != '';
  }

  resetFilter() {
    this.min_value = '';
    this.max_value = '';
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  onlyNumbers(event: any): boolean {
    let charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 48 || charCode > 57)) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }

  lastTree(product: Product) {
    this.productService.lastOne(product).subscribe(() => {
    });
  }

  isAdminLoggedIn() {
    return this.authService.isAdminLoggedIn;
  }

  deleteProduct(product: Product) {
    this.productService.delete(product).subscribe(() => {
      this.productService.findAll().subscribe(data => {
        this.products = data;
      });
    });
  }

  filterProduct(event: any) {
    let searchValue = event.target.value;
    this.productService.findAll().subscribe(data => {
      this.products = data.filter(value => value.productName.toLowerCase().includes(searchValue.toLowerCase()));
    });
  }

}
