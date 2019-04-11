import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { AboutPage } from '../pages/about/about';
import { ConstumerPage } from '../pages/constumer/constumer';
import { PipesModule } from '../pipes/pipes.module';
import { CreateacountPage } from '../pages/createacount/createacount';
import { StudentserviceProvider } from '../providers/studentservice/studentservice';
import { HttpClientModule } from '@angular/common/http';
import { LoginProvider } from '../providers/loginservice/loginservice';
import { LoginProviderMock } from '../mock/loginProviderMock';
import { AccesoPage } from '../pages/acceso/acceso';
import { EventsManagerProvider } from '../providers/events-manager/events-manager';
import { CardComponent } from '../components/card/card';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    AboutPage,
    ConstumerPage,
    CreateacountPage,
    AccesoPage,
    CardComponent
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    PipesModule,
    HttpClientModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    AboutPage,
    ConstumerPage,
    CreateacountPage,
    AccesoPage,
    CardComponent
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    StudentserviceProvider,
    /*---------------------------
    {
      provide: LoginProvider,
      useClass:LoginProviderMock
    },
    /*COMENTAR HASTA AQUI SI SE QUIERE HACER UN CONSUMO CON EL SERVICIO ORIGINAL*/ 
    LoginProvider,
    EventsManagerProvider
  ]
})
export class AppModule {}
