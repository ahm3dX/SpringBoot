import { Component, OnInit } from '@angular/core';
import * as Rellax from 'rellax';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {
  data : Date = new Date();
  focus;
  focus1;
  public events:any[];
  constructor(public httpClient:HttpClient) { }

  ngOnInit() {
    
    this.httpClient.get('http://localhost:8089/Forest/event/get-events',{
      headers:{
          Authorization:"Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6Im1haGVyIiwic3ViIjoibWFoZXIiLCJpYXQiOjE2ODI3MTYxMjksImV4cCI6MTc2OTExNjEyOX0.u6skYrJLbD1L037616jZsAYu5b7yuhubGY-Rj1mY3RBkQNJg0RjW0XLG3Leb9umbB7k9ja_Gg7TUqgi_4XpAwA"
      }
  }).subscribe((data:any) => this.events = data);
    var rellaxHeader = new Rellax('.rellax-header');

    var body = document.getElementsByTagName('body')[0];
    body.classList.add('landing-page');
    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.add('navbar-transparent');
  }
  ngOnDestroy(){
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('landing-page');
    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.remove('navbar-transparent');
  }
}
