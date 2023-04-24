import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHosoAdminComponent } from './add-hoso-admin.component';

describe('AddHosoAdminComponent', () => {
  let component: AddHosoAdminComponent;
  let fixture: ComponentFixture<AddHosoAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddHosoAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddHosoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
