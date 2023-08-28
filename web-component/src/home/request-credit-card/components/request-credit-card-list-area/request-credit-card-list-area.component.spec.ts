import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestCreditCardListAreaComponent } from './request-credit-card-list-area.component';

describe('RequestCreditCardListAreaComponent', () => {
  let component: RequestCreditCardListAreaComponent;
  let fixture: ComponentFixture<RequestCreditCardListAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestCreditCardListAreaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestCreditCardListAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
