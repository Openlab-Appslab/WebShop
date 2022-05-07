import {Component, OnInit} from "@angular/core";
import {Product} from "../product";
import { ProductService } from '../product.service';
import {InformationPage} from "../informationPage";

@Component({
  selector: 'app-information-page',
  templateUrl: './information-page.component.html',
  styleUrls: ['./information-page.component.css']
})

export class InformationPageComponent implements OnInit {

  informationPage: InformationPage;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getInfoAbout().subscribe(data => {
      this.informationPage = data;
    });
  }
}
