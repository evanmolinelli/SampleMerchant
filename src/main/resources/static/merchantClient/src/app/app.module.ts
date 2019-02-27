import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListOffersComponent } from './components/list-offers/list-offers.component';
import { OfferFormComponent } from './components/offer-form/offer-form.component';
import {OfferService} from './shared_service/offer.service';

const appRoutes:Routes=[
	{path: '', component:ListOffersComponent},
	{path: 'op', component:OfferFormComponent},
]

@NgModule({ 
  declarations: [
    AppComponent,
    ListOffersComponent,
    OfferFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [OfferService],
  bootstrap: [AppComponent]
})
export class AppModule { }
