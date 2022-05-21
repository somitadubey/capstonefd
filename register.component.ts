import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import {Router} from "@angular/router"
import { User } from 'src/app/all/user';
import { Address } from 'src/app/all/address';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerFormGroup: FormGroup;
  
  user: User = new User();
   

  username_value:string;
  theusername: string;
  thepassword: string;

  constructor(private loginService: LoginService,
              private formBuilder: FormBuilder,
              private router: Router) { }


  ngOnInit(): void {
    
  }


  saveUser(){
    this.loginService.createUser(this.user).subscribe( data =>{
      console.log(data);
    },
    error => console.log(error));

    this.router.navigate(['/products']);
  }


 

}