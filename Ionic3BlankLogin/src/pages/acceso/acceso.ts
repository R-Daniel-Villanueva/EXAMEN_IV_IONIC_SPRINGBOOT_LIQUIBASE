import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { StudentserviceProvider } from '../../providers/studentservice/studentservice';
import { EventsManagerProvider } from '../../providers/events-manager/events-manager';

/**
 * Generated class for the AccesoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-acceso',
  templateUrl: 'acceso.html',
})
export class AccesoPage {
  nombre:string;
  students:any[]=[];

  constructor(public navCtrl: NavController, public navParams: NavParams, 
    private student_provider:StudentserviceProvider,
    private events_manager:EventsManagerProvider) {

    this.nombre=navParams.get('name');

    this.student_provider
    .getStudents()
    .subscribe((response:any) =>{
      //this.students=response; 
      this.students=response;
      //console.log(response);
    },error =>{
      console.log(error);
    });

    
  }

  deletecard(student){
    this.events_manager.setIsLoading(true);
    this.student_provider
    .deleteStudent(student.id)
    .subscribe(()=>{
      this.events_manager.setIsLoading(false);
      this.loadStudents();
      this.events_manager.setMsgToast('Eliminacion correcta');
    },error =>{
      
      this.events_manager.setIsLoading(false);
      this.events_manager.setMsgToast(error.error.message);
    });
    console.log(student);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AccesoPage');
  }

  loadStudents(){
    this.student_provider
    .getStudents()
    .subscribe((response:any)=>{
      this.students=response;
    },error=>{
      console.log(error);
    })
  }

}
