import { Component, OnInit } from '@angular/core';
import {OfferService} from '../../shared_service/offer.service';
import {Offer} from '../../offer';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-offers',
  templateUrl: './list-offers.component.html',
  styleUrls: ['./list-offers.component.css']
})
export class ListOffersComponent implements OnInit {
   off: any = [];
  // tslint:disable-next-line:variable-name
  constructor(private _offerService: OfferService, private _router: Router) { }

  ngOnInit() {
      this._offerService.getOffers().subscribe((offers) => {
          console.log(offers);
          this.off = offers;
          console.log(this.off);
      }, (error) => {
        console.log(error);
      });
  }

  // tslint:disable-next-line:ban-types
  deleteOffer(id: Number) {
      this._offerService.deleteOffer(id).subscribe((data) => {
          this.off.splice(this.off.indexOf(this._offerService.getOffer(id)), 1);
      }, (error) => {
        console.log(error);
      });
  }

  updateOffer(offer) {
    this._offerService.setter(offer);
    this._router.navigate(['op']);
  }

  newOffer() {
      // tslint:disable-next-line:prefer-const
      let offer = new Offer();
      this._offerService.setter(offer);
      this._router.navigate(['op']);
  }

}
