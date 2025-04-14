import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
  styleUrls: ['./position.component.css']
})
export class PositionComponent  extends BaseCtl implements OnInit {

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
  validateAlphanumericInput(event: KeyboardEvent, errorField: string, limit: number, type: string) {
    const input = event.target as HTMLInputElement;
    const str = event.key;
  
    const allowedKeys = ['Backspace', 'ArrowLeft', 'ArrowRight', 'Tab', 'Delete'];
    const isAlphanumeric = /^[a-zA-Z0-9\s]$/.test(str);
    const isUnderLimit = input.value.length < limit;
  
    // Allow control keys
    if (str === 'Backspace') {
      this[errorField] = '';
      return;
    }
  
    if (allowedKeys.includes(str)) {
      return;
    }
  
    // Length check
    if (!isUnderLimit) {
      this[errorField] = `Maximum ${limit} characters allowed`;
      event.preventDefault();
      return;
    }
  
    // Check alphanumeric validity
    if (!isAlphanumeric) {
      this[errorField] = 'Only letters, numbers and spaces are allowed';
      event.preventDefault();
      return;
    }
  
    this[errorField] = '';
  }
  
  
  
  validateAlphabetInput(event: KeyboardEvent, errorField: string, limit: number, type: string) {
    const input = event.target as HTMLInputElement;
    const str = event.key;
  
    const allowedKeys = ['Backspace', 'ArrowLeft', 'ArrowRight', 'Tab', 'Delete'];
  
    const isAlphabet = /^[a-zA-Z\s]$/.test(str);
    const isUnderLimit = input.value.length < limit;
  
    // Clear previous error if backspacing
    if (str === 'Backspace') {
      this[errorField] = '';
      return;
    }
  
    // Allow control keys
    if (allowedKeys.includes(str)) {
      return;
    }
  
    // Show error if input is a number
    if (type === 'char' && /[0-9]/.test(str)) {
      this[errorField] = 'Only alphabets are allowed';
      event.preventDefault();
      return;
    }
  
    // Show error if length limit exceeded
    if (!isUnderLimit) {
      this[errorField] = `Maximum ${limit} characters allowed`;
      event.preventDefault();
      return;
    }
  
    // Show error if non-alphabet character is typed
    if (!isAlphabet) {
      this[errorField] = 'Only alphabets and spaces are allowed';
      event.preventDefault();
      return;
    }
  
    // Clear error if valid
    this[errorField] = '';
  }
  validateNumericInput(event: KeyboardEvent) {
      
    const str = event.key ;
    console.log(str);
    if (!/^\d$/.test(str)) {
      event.preventDefault();
    }
  }


}
