import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditHosoAdmimComponent } from './edit-hoso-admim.component';

describe('EditHosoAdmimComponent', () => {
  let component: EditHosoAdmimComponent;
  let fixture: ComponentFixture<EditHosoAdmimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditHosoAdmimComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditHosoAdmimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
