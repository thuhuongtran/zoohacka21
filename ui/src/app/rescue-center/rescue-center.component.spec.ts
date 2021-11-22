import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RescueCenterComponent } from './rescue-center.component';

describe('RescueCenterComponent', () => {
  let component: RescueCenterComponent;
  let fixture: ComponentFixture<RescueCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RescueCenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RescueCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
