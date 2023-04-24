import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TongiaoAdminComponent } from './tongiao-admin.component';

describe('TongiaoComponent', () => {
  let component: TongiaoAdminComponent;
  let fixture: ComponentFixture<TongiaoAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TongiaoAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TongiaoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
