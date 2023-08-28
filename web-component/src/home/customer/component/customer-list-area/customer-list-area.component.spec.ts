import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerListAreaComponent } from './customer-list-area.component';

describe('CustomerListAreaComponent', () => {
  let component: CustomerListAreaComponent;
  let fixture: ComponentFixture<CustomerListAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerListAreaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerListAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
