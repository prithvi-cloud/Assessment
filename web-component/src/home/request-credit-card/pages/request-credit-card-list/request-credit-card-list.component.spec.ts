import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestCreditCardListComponent } from './request-credit-card-list.component';

describe('RequestCreditCardListComponent', () => {
  let component: RequestCreditCardListComponent;
  let fixture: ComponentFixture<RequestCreditCardListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestCreditCardListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestCreditCardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
