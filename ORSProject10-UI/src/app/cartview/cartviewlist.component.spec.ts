import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartviewlistComponent } from './cartviewlist.component';

describe('CartviewlistComponent', () => {
  let component: CartviewlistComponent;
  let fixture: ComponentFixture<CartviewlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartviewlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartviewlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
