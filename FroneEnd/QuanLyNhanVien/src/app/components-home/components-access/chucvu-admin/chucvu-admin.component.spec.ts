import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChucvuAdminComponent } from './chucvu-admin.component';

describe('ChucvuAdminComponent', () => {
  let component: ChucvuAdminComponent;
  let fixture: ComponentFixture<ChucvuAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChucvuAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChucvuAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
