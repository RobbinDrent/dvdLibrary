import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxsetComponent } from './boxset.component';

describe('BoxsetComponent', () => {
  let component: BoxsetComponent;
  let fixture: ComponentFixture<BoxsetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxsetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoxsetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
