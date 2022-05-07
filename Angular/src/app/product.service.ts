import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Product} from "./product";
import {Parameters} from "./parameters";
import {InformationPageComponent} from "./information-page/information-page.component";
import {InformationPage} from "./informationPage";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  private lastOneUrl: string;
  private lastThreeUrl: string;
  private deleteUrl: string;
  private idealUrl: string;
  private getIdealUrl: string;
  private getInfoAboutUrl: string;
  private saveInfoAboutUrl: string;

  constructor(private http: HttpClient) {
    this.productsUrl = 'http://localhost:8080/products';
    this.lastOneUrl = 'http://localhost:8080/productsDetail';
    this.lastThreeUrl = 'http://localhost:8080/lastThree';
    this.deleteUrl = 'http://localhost:8080/deleteProduct';
    this.idealUrl = 'http://localhost:8080/ideal';
    this.getIdealUrl = 'http://localhost:8080/getIdeal';
    this.getInfoAboutUrl = 'http://localhost:8080/infoAboutSport';
    this.saveInfoAboutUrl = 'http://localhost:8080/saveInfoAboutSport';
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

  public ideal(ideal: Parameters) {
    return this.http.post<Parameters>(this.idealUrl, ideal);
  }

  public getIdeal(): Observable<Product[]> {
    return this.http.get<Product[]>(this.getIdealUrl);
  }

  public getInfoAbout(): Observable<InformationPage> {
    return this.http.get<InformationPage>(this.getInfoAboutUrl);
  }

  public saveInfoAbout(informationPage: InformationPage) {
    return this.http.post<Product>(this.saveInfoAboutUrl, informationPage);
  }
}
