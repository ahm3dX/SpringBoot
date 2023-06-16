import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders,HttpResponse} from '@angular/common/http';
import { Router } from '@angular/router';

import {map} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
    headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    response = new HttpResponse()
    data : Date = new Date();
    focus;
    focus1;
    username;
    password;
    token: string;
    login = false;

  constructor(private http: HttpClient,private router: Router) { }

    ngOnInit() {
        var body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.add('navbar-transparent');
      console.log('response1');
    }
    ngOnDestroy(){
        var body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.remove('navbar-transparent');
    }
  authenticateUser(username: string, password: string) {
    const body = { userName: username, password: password };
    console.log('response3');

    return this.http.post('http://192.168.0.9:8089/Forest/authenticate', body, {responseType: 'text'})
      .subscribe((token: string) => {
        this.token = token;
        localStorage.setItem('token', this.token);
        console.log('Bearer token:', this.token);
        console.log(localStorage.getItem('token'));
        this.login=true;
        this.router.navigate(['/posts']);
      });
      if(this.login){
        this.router.navigate(['/posts']);

      }

  }
}
