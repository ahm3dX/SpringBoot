import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import * as Rellax from 'rellax';
import {NgbModal, ModalDismissReasons, NgbToast }from '@ng-bootstrap/ng-bootstrap';
import { ToastService } from 'app/Toast/toast-service';


@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.scss']
})

export class EventComponent implements OnInit {

  data : Date = new Date();
  name: string;
  description: string;
  objectif: string;
  location: string;
  datedebut: string;
  datefin: string;
  focus;
  focus1;
  public events:any[];
  constructor(public httpClient:HttpClient, private modalService: NgbModal, private toast: ToastService) { }
  closeResult: string;

  
  private saveEvent(event: any){
    this.toast.show("Event saved successfully", { classname: 'bg-success text-light', delay: 5000 })
    
    this.httpClient.post('http://localhost:8089/Forest/event/addevent/1',event,{
      headers:{
          Authorization:"Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6Im1haGVyIiwic3ViIjoibWFoZXIiLCJpYXQiOjE2ODMwNTU5NTgsImV4cCI6MTc2OTQ1NTk1OH0.NeohawZ5Vg8fclSeF7k7jiLLJFh7aoeeepVq1H9jE1_7C3IMXA8H5eSHFg0FGiVb6IcEfxKPWOuxx5gQxht5yQ"
      }
  }).subscribe((data:any) => {
    console.log("saved event", data);
    this.toast.show("Event saved successfully", { classname: 'bg-success text-light', delay: 5000 })
  });
  }



  open(content) {
    this.toast.show("Event saved successfully", { classname: 'bg-success text-light', delay: 5000 })

		this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
			(result) => {
				this.closeResult = `Closed with: ${result}`;
        console.log(result);
        console.log(this.name, this.location, this.description, this.objectif)
        this.saveEvent({name: this.name, location: this.location, description: this.description, objectif: this.objectif})
			},
			(reason) => {
				this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
			},
		);
	}
	private getDismissReason(reason: any): string {
		if (reason === ModalDismissReasons.ESC) {
			return 'by pressing ESC';
		} else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
			return 'by clicking on a backdrop';
		} else {
			return `with: ${reason}`;
		}
	}




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
