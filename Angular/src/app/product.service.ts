import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Product} from "./product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  private lastOneUrl: string;
  private lastThreeUrl: string;
  private deleteUrl: string;

  constructor(private http: HttpClient) {
    this.productsUrl = 'http://localhost:8080/products';
    this.lastOneUrl = 'http://localhost:8080/productsDetail';
    this.lastThreeUrl = 'http://localhost:8080/lastThree';
    this.deleteUrl = 'http://localhost:8080/deleteProduct';
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl);
  }

  public save(product: Product) {
    return this.http.post<Product>(this.productsUrl, product);
  }

  public lastOne(product: Product) {
    return this.http.post<Product>(this.lastOneUrl, product);
  }

  public LastThree(): Observable<Product[]> {
    return this.http.get<Product[]>(this.lastThreeUrl);
  }

  public delete(product: Product) {
    return this.http.post<Product>(this.deleteUrl, product);
  }
}
