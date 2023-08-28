import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRequestCreditCardComponent } from './create-request-credit-card.component';

describe('CreateRequestCreditCardComponent', () => {
  let component: CreateRequestCreditCardComponent;
  let fixture: ComponentFixture<CreateRequestCreditCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRequestCreditCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateRequestCreditCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
