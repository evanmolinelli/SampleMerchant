import { Component, OnInit } from '@angular/core';
import {OfferService} from '../../shared_service/offer.service';
import {Offer} from '../../offer';
import {Router} from '@angular/router';

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.css']
})
export class OfferFormComponent implements OnInit {
    offer: Offer;
  // tslint:disable-next-line:variable-name
  constructor(private _offerService: OfferService, private _router: Router) { }

  ngOnInit() {
      this.offer = this._offerService.getter();
  }
  processForm() {
      if (this.offer.id === undefined) {
          this._offerService.saveOffer(this.offer).subscribe((offer) => {
              console.log('New offer: ' + offer);
              this._router.navigate(['/']);
          }, (error) => {
              console.log(error);
          });
      } else {
          this._offerService.updateOffer(this.offer).subscribe((offer) => {
              console.log('Updated offer: ' + offer);
              this._router.navigate(['/']);
          }, (error) => {
              console.log(error);
          });
      }
  }

}
