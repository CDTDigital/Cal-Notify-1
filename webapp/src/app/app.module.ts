import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent }  from './app.component';
import { routing, appRoutingProviders } from './app.routing';

import {Home} from './components/home/home';
import {NavBar} from './components/navigation/navbar';
import {Footer} from './components/navigation/footer';

@NgModule({
  imports: [ BrowserModule, routing, FormsModule, HttpModule, ReactiveFormsModule ],
  declarations: [ AppComponent, Home, NavBar, Footer],
  providers: [appRoutingProviders],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
