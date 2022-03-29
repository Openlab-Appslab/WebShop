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
  public isVisible: boolean = false;
  min_value: any;
  max_value: any;
  check_min_state: boolean = false;
  check_max_state: boolean = false;
  toggle_name: string = "Filter size";


  ngOnInit(): void {
    this.productService.findAll().subscribe(data => {
      this.products = data;
  });
  }

  changeState(){
    if (this.selected === 'Parameter') {
      this.products.sort((a, b) => (a.productParameters > b.productParameters) ? 1 : -1)
    }

    else if (this.selected === 'Name'){
      this.products.sort((a, b) => (a.productName > b.productName) ? 1 : -1)
    }
    else if (this.selected === 'ID'){
      this.products.sort((a, b) => (a.id > b.id) ? 1 : -1)
    }
    else{
      this.products.sort((a, b) => (a.productSize > b.productSize) ? 1 : -1)
    }
  }

  toggle() {
    this.isVisible = !this.isVisible;
    if(this.isVisible)
      this.toggle_name = "Hide filter";
    else
      this.toggle_name = "Filter size";
  }

  FilterSize(){
    if (this.check_min_state && this.check_max_state){
      this.products = this.products.filter(value => value.productSize >= this.min_value);
      this.products = this.products.filter(value => value.productSize <= this.max_value);
    }
  }

  OnMaxChange(value: any) {
    this.max_value = value;
    this.check_max_state = this.max_value != '';
  }

  OnMinChange(value: any) {
    this.min_value = value;
    this.check_min_state = this.min_value != '';
  }

  ResetFilter() {
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
    this.productService.lastTree(product).subscribe(() => {});
  }
}
