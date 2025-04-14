import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent  extends BaseListCtl   {

  public form = {
    error: false,
    message: null,
    preload: {
      customerlist: [] 
     
    },
    data: { id: null },
   
    searchParams: {
   
      productName: null,
      orderDate:'',
      customerId: null, 
      quntity:''
      
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };
 


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.ORDER, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }


  validateAlphanumericInput(event: KeyboardEvent) {
    const input = event.target as HTMLInputElement;
    const str = event.key;
  
    // Log for debugging
    console.log(event);
    console.log(str);
  
    const isAlphanumeric = /^[a-zA-Z0-9\s]$/.test(str);
    const isUnderLimit = input.value.length < 25;
  
    if (!isAlphanumeric || !isUnderLimit) {
      event.preventDefault();
    }
  }
  
  validateAlphabetInput(event: KeyboardEvent) {
    const input = event.target as HTMLInputElement;
    const str = event.key;
  
    console.log(event);
    console.log(str);
  
    const isAlphabet = /^[a-zA-Z\s]$/.test(str);
    const isUnderLimit = input.value.length < 25;
  
    if (!isAlphabet || !isUnderLimit) {
      event.preventDefault();
    }
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
