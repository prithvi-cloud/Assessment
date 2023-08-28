import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditListAreaComponent } from './credit-list-area.component';

describe('CreditListAreaComponent', () => {
  let component: CreditListAreaComponent;
  let fixture: ComponentFixture<CreditListAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreditListAreaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreditListAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
