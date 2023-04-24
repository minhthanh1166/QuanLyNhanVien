import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KhenthuongAdminComponent } from './khenthuong-admin.component';

describe('KhenthuongAdminComponent', () => {
  let component: KhenthuongAdminComponent;
  let fixture: ComponentFixture<KhenthuongAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KhenthuongAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KhenthuongAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
