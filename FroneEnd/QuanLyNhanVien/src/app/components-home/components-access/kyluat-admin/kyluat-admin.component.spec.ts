import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KyluatAdminComponent } from './kyluat-admin.component';

describe('KyluatAdminComponent', () => {
  let component: KyluatAdminComponent;
  let fixture: ComponentFixture<KyluatAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KyluatAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KyluatAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
