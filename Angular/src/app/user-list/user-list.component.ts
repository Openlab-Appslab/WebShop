import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {
  }

  public selected: string = 'ID';

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  changeState(){
    if (this.selected === 'Email') {
      this.users.sort((a, b) => (a.email > b.email) ? 1 : -1)
    }

    else if (this.selected === 'Name'){
      this.users.sort((a, b) => (a.name > b.name) ? 1 : -1)
    }
    else if (this.selected === 'ID'){
      this.users.sort((a, b) => (a.id > b.id) ? 1 : -1)
    }
  }
}
