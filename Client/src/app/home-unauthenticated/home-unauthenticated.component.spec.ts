import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeUnauthenticatedComponent } from './home-unauthenticated.component';

describe('HomeUnauthenticatedComponent', () => {
  let component: HomeUnauthenticatedComponent;
  let fixture: ComponentFixture<HomeUnauthenticatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeUnauthenticatedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeUnauthenticatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
