import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the ConstumerPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-constumer',
  templateUrl: 'constumer.html',
})
export class ConstumerPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ConstumerPage');
  }
  goBack(){
    this.navCtrl.pop();
  }
  logout(){
    this.navCtrl.popToRoot();
  }


}
