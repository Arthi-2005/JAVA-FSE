import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
  name = 'Angular Fullstack Demo';
  version = '1.0.0';
  author = 'DeepSkilling Student';
  topics = [
    { name: 'Components', desc: 'Building blocks of Angular apps' },
    { name: 'Data Binding', desc: 'Interpolation, Property, Event, Two-way' },
    { name: 'Directives', desc: '*ngIf, *ngFor, custom directives' },
    { name: 'Pipes', desc: 'Built-in and custom pipes' },
    { name: 'Routing', desc: 'Navigation between views' }
  ];
}
