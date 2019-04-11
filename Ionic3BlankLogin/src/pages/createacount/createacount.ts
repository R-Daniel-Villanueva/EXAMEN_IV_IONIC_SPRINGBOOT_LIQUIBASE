import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, LoadingController } from 'ionic-angular';
import { FormGroup, FormBuilder, Validators  } from '@angular/forms';
import { StudentserviceProvider } from '../../providers/studentservice/studentservice';
import { Students } from '../../model/students.model';

/**
 * Generated class for the CreateacountPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({  
  selector: 'page-createacount',
  templateUrl: 'createacount.html',
})
export class CreateacountPage {

  createForm:FormGroup;
  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams,
    private fb:FormBuilder,
    private student_provider:StudentserviceProvider,
    private loadingControler: LoadingController) {
      this.createForm=this.fb.group({
        name:['',Validators.required],
        lastName:['',Validators.required],
        age:['',Validators.required]
        //CHECAR, ESTA MAL matricula:['',Validators.required, Validators.pattern("\[0-9\]+")]//Validador de numeros
      });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CreateacountPage');
  }

  createAcountStudent(){
    //console.log(this.createForm.getRawValue());//iMPRIME EL OBJETO Y TODO LOQ UE VIENE DENTRO DE EL
    let PresentLoading= this.loadingControler.create({
      content:'Espere por favor'
    });

    
    
    let acountInfo:Students=this.createForm.getRawValue();
    this.student_provider
    .createAccountSudent(acountInfo)
    .subscribe( ()=>{
      console.log('Data');
    },error =>{
      console.log('Error',error);
      PresentLoading.dismiss();//cierra el loading
    },() =>{
      console.log('Succes');
      PresentLoading.dismiss();//cierra el loading
    });
    
  }
}
