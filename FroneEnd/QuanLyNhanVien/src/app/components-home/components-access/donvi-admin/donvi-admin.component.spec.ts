import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonviAdminComponent } from './donvi-admin.component';

describe('DonviAdminComponent', () => {
  let component: DonviAdminComponent;
  let fixture: ComponentFixture<DonviAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonviAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonviAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
