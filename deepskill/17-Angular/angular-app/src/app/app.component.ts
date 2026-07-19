import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <nav>
      <a routerLink="/">Home</a> |
      <a routerLink="/about">About</a>
    </nav>
    <hr>
    <router-outlet></router-outlet>
  `,
  styles: [`
    nav { background: #eee; padding: 10px; }
    a { text-decoration: none; color: #000; margin: 0 5px; }
    a:hover { color: #00f; }
  `]
})
export class AppComponent {
  title = 'angular-fullstack-demo';
}
