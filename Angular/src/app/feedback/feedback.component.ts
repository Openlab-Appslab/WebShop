import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product.service";
import {Feedback} from "../feedback";
import {FormControl, FormGroup} from "@angular/forms";
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  getFeedback: Feedback[];
  feedback: Feedback;
  feedbackForm: FormGroup;
  success: boolean = false;

  constructor(private productService: ProductService, private authService: AuthService) {
    this.feedback = new Feedback();
  }

  ngOnInit(): void {
    this.productService.showFeedback().subscribe(data => this.getFeedback = data);
    this.feedbackForm = new FormGroup({
      nameOfCustomer: new FormControl(''),
      email: new FormControl(''),
      complaint: new FormControl('')
    });
    }

  completeLogin() {
    this.productService.addComplaint(this.feedback).subscribe();
    this.feedbackForm.reset();
    this.success = true;
  }

  isAdmin(): boolean{
    return this.authService.isAdminLoggedIn;
  }

  deleteFeedback(feedback: Feedback) {
    if (confirm('Are you sure you want to delete this feedback?')) {
      this.productService.deleteFeedback(feedback).subscribe(() => {
        this.productService.showFeedback().subscribe(data => {
          this.getFeedback = data;
        });
      });
    }
  }
}
