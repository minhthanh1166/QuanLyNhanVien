import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TinhluongAdminComponent } from './tinhluong-admin.component';

describe('TinhluongAdminComponent', () => {
  let component: TinhluongAdminComponent;
  let fixture: ComponentFixture<TinhluongAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TinhluongAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TinhluongAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
