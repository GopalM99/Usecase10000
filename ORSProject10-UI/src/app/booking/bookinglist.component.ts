import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-bookinglist',
  templateUrl: './bookinglist.component.html',
  styleUrls: ['./bookinglist.component.css']
})
export class BookinglistComponent extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: {
      serviceTypeList: [] 
     
    },
    data: { id: null },
   
    searchParams: {
   
      location: null,
      bookingDate:'',
      serviceTypeId: null, 
      customerName:''
      
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };
 


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.BOOKING, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }


  validateAlphanumericInput(event: KeyboardEvent) {
      
    const str = event.key ;
    console.log(event);
    console.log(str);
    if (!/^[a-zA-Z0-9\s]$/.test(str)) {
      event.preventDefault();
    }
  }
  
  validateAlphabetInput(event: KeyboardEvent) {
    console.log(event);
    const str = event.key ;
    
    console.log(str);
    if (!/^[a-zA-Z\s]*$/.test(str)) {
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
