import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

import {Offer} from '../offer';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class OfferService {
    private baseUrl =  'http://localhost:8080/api';
    offer: Offer;

  // tslint:disable-next-line:variable-name
  constructor(private _http: HttpClient) { }

  getOffers() {
      return this._http.get(this.baseUrl + '/Offers', httpOptions);
    //   .catchError(this.errorHandler);  .pipe(map((response: Response) => response.json()));
  }

  // tslint:disable-next-line:ban-types
  getOffer(id: Number) {
      return this._http.get(this.baseUrl + '/Offer/' + id, httpOptions);
    //   .pipe(map((response: Response) => response.json()));
    //   .catchError(this.errorHandler);
  }

  // tslint:disable-next-line:ban-types
  deleteOffer(id: Number) {
      return this._http.delete(this.baseUrl + '/DeleteOffer/' + id, httpOptions);
    //   .pipe(map((response: Response) => response.json()));
    //   .catchError(this.errorHandler);
  }

  saveOffer(offer: Offer) {
      // tslint:disable-next-line:max-line-length
      return this._http.post(this.baseUrl + '/SaveOffer', JSON.stringify(offer), httpOptions);
    //   .pipe(map((response: Response) => response.json()));
    //   .catchError(this.errorHandler);
  }

  updateOffer(offer: Offer) {
      return this._http.put(this.baseUrl + '/UpdateOffer/' + offer.id, JSON.stringify(offer), httpOptions);
    //   .pipe(map((response: Response) => response.json()));
    //   .catchError(this.errorHandler);
  }

//   errorHandler(error: Response) {
//     return Observable.throwError(error || 'Server Error!');
//   }

  setter(offer: Offer) {
      this.offer = offer;
  }

  getter() {
      return this.offer;
  }
}

