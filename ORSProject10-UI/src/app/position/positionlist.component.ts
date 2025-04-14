import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-positionlist',
  templateUrl: './positionlist.component.html',
  styleUrls: ['./positionlist.component.css']
})
export class PositionlistComponent extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: {
      conditionList: [] 
     
    },
    data: { id: null },
   
    searchParams: {
   
      designation: '',
      openingDate: '',
      conditionId: null, 
      requiredExperience:null
      
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };
 


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.POSITION, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
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
  
  
 
  submit() {
   
    this.form.pageNo = 0;
    
    this.search();
  }


 
  search() {
   
    this.form.searchMessage = null;
    
    super.search();
  }

}


