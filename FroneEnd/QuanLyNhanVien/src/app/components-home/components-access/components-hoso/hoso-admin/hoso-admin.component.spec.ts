import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HosoAdminComponent } from './hoso-admin.component';

describe('HosoAdminComponent', () => {
  let component: HosoAdminComponent;
  let fixture: ComponentFixture<HosoAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HosoAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HosoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
