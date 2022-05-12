import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product.service";
import {Feedback} from "../feedback";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  getFeedback$: Observable<Feedback>;
  feedback: Feedback;

  constructor(private productService: ProductService) {
    this.feedback = new Feedback();
  }

  ngOnInit(): void {
    this.getFeedback$ = this.productService.showFeedback();
    }

  onSubmit() {
   this.productService.addComplaint(this.feedback).subscribe();
  }

}
