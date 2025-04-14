import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseCtl } from '../base.component';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent  extends BaseCtl  {

  getKey = false;
  selected = null;
  userForm: FormGroup = null;
  uploadForm: FormGroup;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.BOOKING, locator, route);
  }

  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }
  test() {

  }
  submit() {
    var _self = this;


    this.serviceLocator.httpService.post(this.api.save, this.form.data, function (res) {
      _self.form.message = '';
      _self.form.inputerror = {};

      if (res.success) {
        _self.form.error = false;
        _self.form.message = "Data is saved";
        _self.form.data.id = res.result.data;
      } else {
        _self.form.error = true;
        if (res.result.inputerror) {
          _self.form.inputerror = res.result.inputerror;
        }
        _self.form.message = res.result.message;
      }
    });
  }
  onUpload(userform: FormData) {
    this.submit();
  }
  populateForm(form, data) {
    form.id = data.id;
    form.bookingDate = data.bookingDate;
    form.location = data.location;
    form.serviceTypeId = data.serviceTypeId;
    form.customerName = data.customerName;
  }
  validateAlphabetInput(event: KeyboardEvent) {

    const str = event.key;
    console.log(str);
    if (!/^[a-zA-Z\s]*$/.test(str)) {
      event.preventDefault();
    }

  }
  validateAlphanumericInput(event: KeyboardEvent) {
      
    const str = event.key ;
    console.log(event);
    console.log(str);
    if (!/^[a-zA-Z1-9\s]$/.test(str)) {
      event.preventDefault();
    }
  }
  








}
