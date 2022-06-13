import { Component } from '@angular/core';
import {newUser} from "../new-user";
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../user.service";
import {Router} from "@angular/router";
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent {
  userForm: any;
  user: newUser;
  check: boolean = false;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
    this.CreateForm();
  }
  CreateForm() {
    this.userForm = this.formBuilder.group({
      'name': ['', Validators.required],
      //'email': ['', [Validators.required]],
      'password': ['', [Validators.required]],
      //'confirmPassword': ['', [Validators.required]]
    });
  }

  saveUser(): void {
    if (this.userForm.dirty && this.userForm.valid) {
      this.user = {
        userName: this.userForm.value.name,
        //email: this.userForm.value.email,
        password: this.userForm.value.password,
        //confirmPassword: this.userForm.value.confirmPassword,
      }
    }
    this.userService.save(this.user).subscribe(
      data => {
        this.check = true;
      }
    );
    setTimeout(() => {
      this.check = false;
      this.router.navigate(['/login']);
    }, 5000);
  }
}