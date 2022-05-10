import { Component, OnInit } from '@angular/core';
import {InformationPage} from "../informationPage";
import {ProductService} from "../product.service";
import {Feedback} from "../feedback";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  feedback: Feedback;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.showFeedback().subscribe(data =>{
      this.feedback = data;
    })
  }
}
