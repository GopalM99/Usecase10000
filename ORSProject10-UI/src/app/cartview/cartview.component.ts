import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { FormGroup } from '@angular/forms';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cartview',
  templateUrl: './cartview.component.html',
  styleUrls: ['./cartview.component.css']
})
export class CartviewComponent extends BaseCtl implements OnInit {

  getKey = false;
  selected = null;
  userForm: FormGroup = null;
  uploadForm: FormGroup;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.POSITION, locator, route);
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
    form.designation = data.designation;
    form.requiredExperience = data.requiredExperience;
    form.openingDate = data.openingDate;
    form.conditionId = data.conditionId;
  }
  validateAlphabetInput(event: KeyboardEvent) {

    const str = event.key;
    console.log(str);
    if (!/^[a-zA-Z\s]*$/.test(str)) {
      event.preventDefault();
    }

  }
  validateNumericInput(event: KeyboardEvent) {
      
    const str = event.key ;
    console.log(str);
    if (!/^\d$/.test(str)) {
      event.preventDefault();
    }
  }

}
