import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhongbanAdminComponent } from './phongban-admin.component';

describe('PhongbanAdminComponent', () => {
  let component: PhongbanAdminComponent;
  let fixture: ComponentFixture<PhongbanAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhongbanAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhongbanAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
