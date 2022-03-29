import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Product} from "./product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  private lastTreeUrl: string;

  constructor(private http: HttpClient) {
    this.productsUrl = 'http://localhost:8080/products';
    this.lastTreeUrl = 'http://localhost:8080/productsDetail';
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl);
  }

  public save(product: Product) {
    return this.http.post<Product>(this.productsUrl, product);
  }

  lastTree(product: Product) {
    return this.http.post<Product>(this.lastTreeUrl, product);
  }
}
