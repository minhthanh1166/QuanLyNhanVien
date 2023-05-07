import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DuanAdminComponent } from './duan-admin.component';

describe('DuanAdminComponent', () => {
  let component: DuanAdminComponent;
  let fixture: ComponentFixture<DuanAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DuanAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DuanAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
