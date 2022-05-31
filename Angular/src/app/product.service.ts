import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Product} from "./product";
import {Parameters} from "./parameters";
import {InformationPage} from "./informationPage";
import {Feedback} from "./feedback";
import {Rating} from "./rating";

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
  private addConplaintUrl: string;
  private showFeedbackUrl: string;
  private deleteComplaintUrl: string;
  private sendRatingUrl: string;
  private getRatingUrl: string;

  constructor(private http: HttpClient) {
    this.productsUrl = 'http://localhost:8080/products';
    this.lastOneUrl = 'http://localhost:8080/productsDetail';
    this.lastThreeUrl = 'http://localhost:8080/lastThree';
    this.deleteUrl = 'http://localhost:8080/deleteProduct';
    this.idealUrl = 'http://localhost:8080/ideal';
    this.getIdealUrl = 'http://localhost:8080/getIdeal';
    this.getInfoAboutUrl = 'http://localhost:8080/infoAboutSport';
    this.saveInfoAboutUrl = 'http://localhost:8080/saveInfoAboutSport';
    this.addConplaintUrl = 'http://localhost:8080/addComplaint';
    this.showFeedbackUrl = 'http://localhost:8080/feedback';
    this.deleteComplaintUrl = 'http://localhost:8080/deleteComplaint';
    this.sendRatingUrl = 'http://localhost:8080/addNewRating';
    this.getRatingUrl = 'http://localhost:8080/getStars';
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

  public lastThree(): Observable<Product[]> {
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

  public addComplaint(feedback: Feedback){
    return this.http.post<Feedback>(this.addConplaintUrl, feedback);
  }

  public showFeedback(): Observable<Feedback[]>{
    return this.http.get<Feedback[]>(this.showFeedbackUrl);
  }

  public deleteFeedback(feedback: Feedback){
    return this.http.post<Feedback>(this.deleteComplaintUrl, feedback);
  }

  public sendRating(rating: number, product: Product){
    return this.http.post<Rating>(this.sendRatingUrl, {"numberOfStar" : rating, product: product});
  }

  public averageRating(): Observable<Product[]>{
    return this.http.get<Product[]>(this.getRatingUrl);
  }
}
