import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DantocAdminComponent } from './dantoc-admin.component';

describe('DantocAdminComponent', () => {
  let component: DantocAdminComponent;
  let fixture: ComponentFixture<DantocAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DantocAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DantocAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
