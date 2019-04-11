import { Component } from '@angular/core';
import { NavController} from 'ionic-angular';
import { AboutPage } from '../about/about';
import { CreateacountPage } from '../createacount/createacount';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginProvider } from '../../providers/loginservice/loginservice';
import { AccesoPage } from '../acceso/acceso';
import { EventsManagerProvider } from '../../providers/events-manager/events-manager';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  user:string;
  group:string;
  cursos:string[]=[
    'Ionic',
    'Docker',
    'Java'
  ];
  cost:number;
  loginForm:FormGroup;
  password:string;
  
  constructor(public navCtrl: NavController,
    private fb:FormBuilder,
    private login_provider:LoginProvider,
    private events_manager:EventsManagerProvider) {
      this.loginForm=this.fb.group({
        user:['',Validators.required],
        password:['',Validators.required]
      });
    
  }

  goAbout(){
    let data={
      user:this.user,
      group:this.group,
      courses:this.cursos,
      date:new Date(),
      cost:this.cost};
      
    //console.log(data);
    this.navCtrl.push(AboutPage,data);
  }    
  gocreate(){
    this.navCtrl.push(CreateacountPage);
  } 
  goregistros(){
    this.navCtrl.push(AccesoPage);
  } 
  /*    
  login(){
    this.login_provider.loginService(
      this.loginForm.get('user').value,
      this.loginForm.get('pwd').value).
      subscribe((response)=>{
        console.log(response);
      },error=> console.log(error));    
    }
  */   
  login(){
    this.events_manager.setIsLoading(true);
    this.login_provider.loginService(
      this.loginForm.get('user').value,
      this.loginForm.get('password').value).
      subscribe((response)=>{
        console.log(response);
        this.events_manager.setIsLoading(false);
        this.navCtrl.push(AccesoPage,response);
        this.events_manager.setMsgToast("EXITO");
        }, (error)=> { 
          console.log(error);
          this.events_manager.setIsLoading(false);
          this.events_manager.setMsgToast("USUARIO Y/O CONTRASEÑA INCORRECTA");
          console.log(error);
        }
      ); 
  }
    
}
