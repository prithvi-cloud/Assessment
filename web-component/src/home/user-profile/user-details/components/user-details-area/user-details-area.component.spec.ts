import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDetailsAreaComponent } from './user-details-area.component';

describe('UserDetailsAreaComponent', () => {
  let component: UserDetailsAreaComponent;
  let fixture: ComponentFixture<UserDetailsAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserDetailsAreaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserDetailsAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
