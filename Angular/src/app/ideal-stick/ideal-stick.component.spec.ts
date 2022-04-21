import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdealStickComponent } from './ideal-stick.component';

describe('IdealStickComponent', () => {
  let component: IdealStickComponent;
  let fixture: ComponentFixture<IdealStickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IdealStickComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IdealStickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
