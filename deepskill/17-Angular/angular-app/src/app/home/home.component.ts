import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'Welcome to Angular Learning';
  today = new Date();
  userName = 'Angular Student';
  isDisabled = false;
  myPlaceholder = 'Enter your name...';
  message = '';
  showDetails = false;
  skills = ['HTML', 'CSS', 'JavaScript', 'TypeScript', 'Angular', 'RxJS'];

  sayHello(): void {
    this.message = 'Hello! Welcome to Angular!';
  }

  toggleDetails(): void {
    this.showDetails = !this.showDetails;
  }

  reset(): void {
    this.userName = '';
    this.message = '';
    this.showDetails = false;
  }
}
