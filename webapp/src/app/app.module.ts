import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent }  from './app.component';
import { routing, appRoutingProviders } from './app.routing';

import {ApiRequest} from './services/http/api_request';
import {UserState} from './services/user_state/user_state';

import {Home} from './components/home/home';
import {NavBar} from './components/navigation/navbar';
import {Notifications} from './components/notifications/notifications';
import {NotificationView} from './components/notifications/notification_view';
import {Message} from './components/notifications/message';
import {Footer} from './components/navigation/footer';
import {Signup} from './components/signup/signup';
import {Faq} from './components/faq/faq';
import {Contact} from './components/contact/contact';
import {Privacy} from './components/privacy/privacy';
import {AccountSettings} from './components/user/account_settings';
import {NotificationSettings} from './components/user/notification_settings';
import {Notify} from './components/admin/notify';
import {Reports} from './components/admin/reports';

@NgModule({
  imports: [ BrowserModule, routing, FormsModule, HttpModule, ReactiveFormsModule ],
  declarations: [ AppComponent, Home, NavBar, Footer, Signup, Notifications, Message, Faq, Contact, Privacy, AccountSettings, NotificationSettings, Notify, Reports, NotificationView],
  providers: [appRoutingProviders, ApiRequest, UserState],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
