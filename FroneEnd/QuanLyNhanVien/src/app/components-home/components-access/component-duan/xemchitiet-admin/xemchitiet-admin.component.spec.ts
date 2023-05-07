import { ComponentFixture, TestBed } from '@angular/core/testing';

import { XemchitietAdminComponent } from './xemchitiet-admin.component';

describe('XemchitietAdminComponent', () => {
  let component: XemchitietAdminComponent;
  let fixture: ComponentFixture<XemchitietAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ XemchitietAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(XemchitietAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
