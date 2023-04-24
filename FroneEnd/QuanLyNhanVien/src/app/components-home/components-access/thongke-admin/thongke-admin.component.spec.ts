import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongkeAdminComponent } from './thongke-admin.component';

describe('ThongkeAdminComponent', () => {
  let component: ThongkeAdminComponent;
  let fixture: ComponentFixture<ThongkeAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongkeAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThongkeAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
