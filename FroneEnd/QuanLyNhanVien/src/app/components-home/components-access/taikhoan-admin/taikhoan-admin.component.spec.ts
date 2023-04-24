import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaikhoanAdminComponent } from './taikhoan-admin.component';

describe('AccountAdminComponent', () => {
  let component: TaikhoanAdminComponent;
  let fixture: ComponentFixture<TaikhoanAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaikhoanAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaikhoanAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
